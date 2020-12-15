package com.baidu.tieba.ala.liveroom.e;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private w aFN;
    private ViewGroup bNk;
    private boolean gEp = true;
    private ViewGroup.LayoutParams hip = new ViewGroup.LayoutParams(-2, -1);
    protected c hiq;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.bNk = viewGroup;
        bUk();
    }

    private void bUk() {
        this.mParentView = new FrameLayout(this.bNk.getContext());
        this.mParentView.setId(a.f.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.bNk.addView(this.mParentView, this.hip);
    }

    public void a(w wVar, b bVar) {
        if (wVar != null && wVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aFN = wVar;
            if (this.mParentView == null || this.bNk.indexOfChild(this.mParentView) < 0) {
                bUk();
                this.mParentView.setVisibility(this.gEp ? 0 : 8);
            }
            if (this.hiq == null || (this.mParentView != null && this.mParentView.indexOfChild(this.hiq.getView()) < 0)) {
                this.hiq = new c(this.mTbPageContext);
                this.mParentView.addView(this.hiq.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.hiq.ccz().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.hiq.ccy();
                        a.this.hiq.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.e.back_to_come_logo);
            bVar2.wB(a.h.ala_back_to_come_title);
            this.hiq.a(bVar2);
            this.hiq.show();
        }
    }

    public void dX(int i) {
        View ccz;
        LinearLayout.LayoutParams layoutParams;
        if (this.hiq != null && (ccz = this.hiq.ccz()) != null && (layoutParams = (LinearLayout.LayoutParams) ccz.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds288);
                this.hiq.show();
            } else if (i == 2) {
                this.hiq.hide();
            }
            ccz.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.gEp = true;
        lY(z);
    }

    private void lY(boolean z) {
        if (this.hiq != null && this.hiq.getView() != null && (this.hiq.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hiq.getView().getParent()).removeView(this.hiq.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
