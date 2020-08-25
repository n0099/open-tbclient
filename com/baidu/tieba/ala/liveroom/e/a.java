package com.baidu.tieba.ala.liveroom.e;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes7.dex */
public class a {
    private r aAh;
    private ViewGroup fZu;
    protected c gpr;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean fQy = true;
    private ViewGroup.LayoutParams gpq = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.fZu = viewGroup;
        bIl();
    }

    private void bIl() {
        this.mParentView = new FrameLayout(this.fZu.getContext());
        this.mParentView.setId(a.g.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.fZu.addView(this.mParentView, this.gpq);
    }

    public void a(r rVar, b bVar) {
        if (rVar != null && rVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aAh = rVar;
            if (this.mParentView == null || this.fZu.indexOfChild(this.mParentView) < 0) {
                bIl();
                this.mParentView.setVisibility(this.fQy ? 0 : 8);
            }
            if (this.gpr == null || (this.mParentView != null && this.mParentView.indexOfChild(this.gpr.getView()) < 0)) {
                this.gpr = new c(this.mTbPageContext);
                this.mParentView.addView(this.gpr.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.gpr.bPd().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.gpr.bPc();
                        a.this.gpr.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.tT(a.i.ala_back_to_come_title);
            this.gpr.a(bVar2);
            this.gpr.show();
        }
    }

    public void dz(int i) {
        View bPd;
        LinearLayout.LayoutParams layoutParams;
        if (this.gpr != null && (bPd = this.gpr.bPd()) != null && (layoutParams = (LinearLayout.LayoutParams) bPd.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.gpr.show();
            } else if (i == 2) {
                this.gpr.hide();
            }
            bPd.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.fQy = true;
        kz(z);
    }

    private void kz(boolean z) {
        if (this.gpr != null && this.gpr.getView() != null && (this.gpr.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gpr.getView().getParent()).removeView(this.gpr.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
