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
    private w aEc;
    private ViewGroup bEg;
    protected c gST;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean gqi = true;
    private ViewGroup.LayoutParams gSS = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.bEg = viewGroup;
        bOG();
    }

    private void bOG() {
        this.mParentView = new FrameLayout(this.bEg.getContext());
        this.mParentView.setId(a.g.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.bEg.addView(this.mParentView, this.gSS);
    }

    public void a(w wVar, b bVar) {
        if (wVar != null && wVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aEc = wVar;
            if (this.mParentView == null || this.bEg.indexOfChild(this.mParentView) < 0) {
                bOG();
                this.mParentView.setVisibility(this.gqi ? 0 : 8);
            }
            if (this.gST == null || (this.mParentView != null && this.mParentView.indexOfChild(this.gST.getView()) < 0)) {
                this.gST = new c(this.mTbPageContext);
                this.mParentView.addView(this.gST.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.gST.bWI().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.gST.bWH();
                        a.this.gST.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.vl(a.i.ala_back_to_come_title);
            this.gST.a(bVar2);
            this.gST.show();
        }
    }

    public void dI(int i) {
        View bWI;
        LinearLayout.LayoutParams layoutParams;
        if (this.gST != null && (bWI = this.gST.bWI()) != null && (layoutParams = (LinearLayout.LayoutParams) bWI.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.gST.show();
            } else if (i == 2) {
                this.gST.hide();
            }
            bWI.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.gqi = true;
        lt(z);
    }

    private void lt(boolean z) {
        if (this.gST != null && this.gST.getView() != null && (this.gST.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gST.getView().getParent()).removeView(this.gST.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
