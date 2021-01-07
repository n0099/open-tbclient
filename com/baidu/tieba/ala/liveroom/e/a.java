package com.baidu.tieba.ala.liveroom.e;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a {
    private x aGe;
    private ViewGroup bRX;
    private boolean gPZ = true;
    private ViewGroup.LayoutParams hul = new ViewGroup.LayoutParams(-2, -1);
    protected c hum;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.bRX = viewGroup;
        bRj();
    }

    private void bRj() {
        this.mParentView = new FrameLayout(this.bRX.getContext());
        this.mParentView.setId(a.f.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.bRX.addView(this.mParentView, this.hul);
    }

    public void a(x xVar, b bVar) {
        if (xVar != null && xVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aGe = xVar;
            if (this.mParentView == null || this.bRX.indexOfChild(this.mParentView) < 0) {
                bRj();
                this.mParentView.setVisibility(this.gPZ ? 0 : 8);
            }
            if (this.hum == null || (this.mParentView != null && this.mParentView.indexOfChild(this.hum.getView()) < 0)) {
                this.hum = new c(this.mTbPageContext);
                this.mParentView.addView(this.hum.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.hum.cfq().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.hum.cfp();
                        a.this.hum.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.e.back_to_come_logo);
            bVar2.wM(a.h.ala_back_to_come_title);
            this.hum.a(bVar2);
            this.hum.show();
        }
    }

    public void dU(int i) {
        View cfq;
        LinearLayout.LayoutParams layoutParams;
        if (this.hum != null && (cfq = this.hum.cfq()) != null && (layoutParams = (LinearLayout.LayoutParams) cfq.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds288);
                this.hum.show();
            } else if (i == 2) {
                this.hum.hide();
            }
            cfq.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.gPZ = true;
        mv(z);
    }

    private void mv(boolean z) {
        if (this.hum != null && this.hum.getView() != null && (this.hum.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hum.getView().getParent()).removeView(this.hum.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
