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
    private w aES;
    private ViewGroup bJN;
    protected c gYY;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean gvW = true;
    private ViewGroup.LayoutParams gYX = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.bJN = viewGroup;
        bRg();
    }

    private void bRg() {
        this.mParentView = new FrameLayout(this.bJN.getContext());
        this.mParentView.setId(a.f.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.bJN.addView(this.mParentView, this.gYX);
    }

    public void a(w wVar, b bVar) {
        if (wVar != null && wVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aES = wVar;
            if (this.mParentView == null || this.bJN.indexOfChild(this.mParentView) < 0) {
                bRg();
                this.mParentView.setVisibility(this.gvW ? 0 : 8);
            }
            if (this.gYY == null || (this.mParentView != null && this.mParentView.indexOfChild(this.gYY.getView()) < 0)) {
                this.gYY = new c(this.mTbPageContext);
                this.mParentView.addView(this.gYY.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.gYY.bZk().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.gYY.bZj();
                        a.this.gYY.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.e.back_to_come_logo);
            bVar2.vy(a.h.ala_back_to_come_title);
            this.gYY.a(bVar2);
            this.gYY.show();
        }
    }

    public void dI(int i) {
        View bZk;
        LinearLayout.LayoutParams layoutParams;
        if (this.gYY != null && (bZk = this.gYY.bZk()) != null && (layoutParams = (LinearLayout.LayoutParams) bZk.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds288);
                this.gYY.show();
            } else if (i == 2) {
                this.gYY.hide();
            }
            bZk.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.gvW = true;
        lC(z);
    }

    private void lC(boolean z) {
        if (this.gYY != null && this.gYY.getView() != null && (this.gYY.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gYY.getView().getParent()).removeView(this.gYY.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
