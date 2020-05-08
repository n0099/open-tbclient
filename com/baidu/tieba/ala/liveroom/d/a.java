package com.baidu.tieba.ala.liveroom.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private n aDK;
    private ViewGroup faV;
    protected c fyQ;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean fbb = true;
    private ViewGroup.LayoutParams faW = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.faV = (ViewGroup) this.mTbPageContext.getPageActivity().findViewById(a.g.live_root_view);
        bni();
    }

    private void bni() {
        this.mParentView = new FrameLayout(this.faV.getContext());
        this.mParentView.setBackgroundColor(0);
        this.faV.addView(this.mParentView, this.faW);
    }

    public void a(n nVar, b bVar) {
        if (nVar != null && nVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aDK = nVar;
            if (this.mParentView == null || this.faV.indexOfChild(this.mParentView) < 0) {
                bni();
                this.mParentView.setVisibility(this.fbb ? 0 : 8);
            }
            if (this.fyQ == null || (this.mParentView != null && this.mParentView.indexOfChild(this.fyQ.getView()) < 0)) {
                this.fyQ = new c(this.mTbPageContext);
                this.mParentView.addView(this.fyQ.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.fyQ.bty().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.fyQ.btx();
                        a.this.fyQ.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.qq(a.i.ala_back_to_come_title);
            this.fyQ.a(bVar2);
            this.fyQ.show();
        }
    }

    public void cl(int i) {
        View bty;
        LinearLayout.LayoutParams layoutParams;
        if (this.fyQ != null && (bty = this.fyQ.bty()) != null && (layoutParams = (LinearLayout.LayoutParams) bty.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.fyQ.show();
            } else if (i == 2) {
                this.fyQ.hide();
            }
            bty.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.fbb = true;
        iS(z);
    }

    private void iS(boolean z) {
        if (this.fyQ != null && this.fyQ.getView() != null && (this.fyQ.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fyQ.getView().getParent()).removeView(this.fyQ.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
