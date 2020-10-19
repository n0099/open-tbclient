package com.baidu.tieba.ala.liveroom.e;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private u aDU;
    private ViewGroup bBk;
    protected c gHe;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean ggf = true;
    private ViewGroup.LayoutParams gHd = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.bBk = viewGroup;
        bMe();
    }

    private void bMe() {
        this.mParentView = new FrameLayout(this.bBk.getContext());
        this.mParentView.setId(a.g.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.bBk.addView(this.mParentView, this.gHd);
    }

    public void a(u uVar, b bVar) {
        if (uVar != null && uVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aDU = uVar;
            if (this.mParentView == null || this.bBk.indexOfChild(this.mParentView) < 0) {
                bMe();
                this.mParentView.setVisibility(this.ggf ? 0 : 8);
            }
            if (this.gHe == null || (this.mParentView != null && this.mParentView.indexOfChild(this.gHe.getView()) < 0)) {
                this.gHe = new c(this.mTbPageContext);
                this.mParentView.addView(this.gHe.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.gHe.bTJ().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.gHe.bTI();
                        a.this.gHe.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.uR(a.i.ala_back_to_come_title);
            this.gHe.a(bVar2);
            this.gHe.show();
        }
    }

    public void dI(int i) {
        View bTJ;
        LinearLayout.LayoutParams layoutParams;
        if (this.gHe != null && (bTJ = this.gHe.bTJ()) != null && (layoutParams = (LinearLayout.LayoutParams) bTJ.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.gHe.show();
            } else if (i == 2) {
                this.gHe.hide();
            }
            bTJ.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.ggf = true;
        lb(z);
    }

    private void lb(boolean z) {
        if (this.gHe != null && this.gHe.getView() != null && (this.gHe.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gHe.getView().getParent()).removeView(this.gHe.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
