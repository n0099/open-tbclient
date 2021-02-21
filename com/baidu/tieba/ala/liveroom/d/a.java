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
    private boolean gOn = true;
    private ViewGroup.LayoutParams hue = new ViewGroup.LayoutParams(-2, -1);
    protected c huf;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.bRb = viewGroup;
        bNZ();
    }

    private void bNZ() {
        this.mParentView = new FrameLayout(this.bRb.getContext());
        this.mParentView.setId(a.f.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.bRb.addView(this.mParentView, this.hue);
    }

    public void a(ab abVar, b bVar) {
        if (abVar != null && abVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aDd = abVar;
            if (this.mParentView == null || this.bRb.indexOfChild(this.mParentView) < 0) {
                bNZ();
                this.mParentView.setVisibility(this.gOn ? 0 : 8);
            }
            if (this.huf == null || (this.mParentView != null && this.mParentView.indexOfChild(this.huf.getView()) < 0)) {
                this.huf = new c(this.mTbPageContext);
                this.mParentView.addView(this.huf.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.huf.ccA().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.huf.ccz();
                        a.this.huf.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.e.back_to_come_logo);
            bVar2.vr(a.h.ala_back_to_come_title);
            this.huf.a(bVar2);
            this.huf.show();
        }
    }

    public void cr(int i) {
        View ccA;
        LinearLayout.LayoutParams layoutParams;
        if (this.huf != null && (ccA = this.huf.ccA()) != null && (layoutParams = (LinearLayout.LayoutParams) ccA.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds288);
                this.huf.show();
            } else if (i == 2) {
                this.huf.hide();
            }
            ccA.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.gOn = true;
        mv(z);
    }

    private void mv(boolean z) {
        if (this.huf != null && this.huf.getView() != null && (this.huf.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.huf.getView().getParent()).removeView(this.huf.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
