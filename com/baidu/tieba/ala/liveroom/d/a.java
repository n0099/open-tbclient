package com.baidu.tieba.ala.liveroom.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a {
    private ab aDd;
    private ViewGroup bRb;
    private boolean gNZ = true;
    private ViewGroup.LayoutParams htQ = new ViewGroup.LayoutParams(-2, -1);
    protected c htR;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.bRb = viewGroup;
        bNS();
    }

    private void bNS() {
        this.mParentView = new FrameLayout(this.bRb.getContext());
        this.mParentView.setId(a.f.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.bRb.addView(this.mParentView, this.htQ);
    }

    public void a(ab abVar, b bVar) {
        if (abVar != null && abVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aDd = abVar;
            if (this.mParentView == null || this.bRb.indexOfChild(this.mParentView) < 0) {
                bNS();
                this.mParentView.setVisibility(this.gNZ ? 0 : 8);
            }
            if (this.htR == null || (this.mParentView != null && this.mParentView.indexOfChild(this.htR.getView()) < 0)) {
                this.htR = new c(this.mTbPageContext);
                this.mParentView.addView(this.htR.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.htR.cct().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.htR.ccs();
                        a.this.htR.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.e.back_to_come_logo);
            bVar2.vr(a.h.ala_back_to_come_title);
            this.htR.a(bVar2);
            this.htR.show();
        }
    }

    public void cr(int i) {
        View cct;
        LinearLayout.LayoutParams layoutParams;
        if (this.htR != null && (cct = this.htR.cct()) != null && (layoutParams = (LinearLayout.LayoutParams) cct.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds288);
                this.htR.show();
            } else if (i == 2) {
                this.htR.hide();
            }
            cct.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.gNZ = true;
        mv(z);
    }

    private void mv(boolean z) {
        if (this.htR != null && this.htR.getView() != null && (this.htR.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.htR.getView().getParent()).removeView(this.htR.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
