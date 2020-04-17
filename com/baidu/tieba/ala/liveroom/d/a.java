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
    private n aDE;
    private ViewGroup faQ;
    protected c fyL;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean faW = true;
    private ViewGroup.LayoutParams faR = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.faQ = (ViewGroup) this.mTbPageContext.getPageActivity().findViewById(a.g.live_root_view);
        bnk();
    }

    private void bnk() {
        this.mParentView = new FrameLayout(this.faQ.getContext());
        this.mParentView.setBackgroundColor(0);
        this.faQ.addView(this.mParentView, this.faR);
    }

    public void a(n nVar, b bVar) {
        if (nVar != null && nVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aDE = nVar;
            if (this.mParentView == null || this.faQ.indexOfChild(this.mParentView) < 0) {
                bnk();
                this.mParentView.setVisibility(this.faW ? 0 : 8);
            }
            if (this.fyL == null || (this.mParentView != null && this.mParentView.indexOfChild(this.fyL.getView()) < 0)) {
                this.fyL = new c(this.mTbPageContext);
                this.mParentView.addView(this.fyL.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.fyL.btA().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.fyL.btz();
                        a.this.fyL.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.qq(a.i.ala_back_to_come_title);
            this.fyL.a(bVar2);
            this.fyL.show();
        }
    }

    public void cl(int i) {
        View btA;
        LinearLayout.LayoutParams layoutParams;
        if (this.fyL != null && (btA = this.fyL.btA()) != null && (layoutParams = (LinearLayout.LayoutParams) btA.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.fyL.show();
            } else if (i == 2) {
                this.fyL.hide();
            }
            btA.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.faW = true;
        iS(z);
    }

    private void iS(boolean z) {
        if (this.fyL != null && this.fyL.getView() != null && (this.fyL.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fyL.getView().getParent()).removeView(this.fyL.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
