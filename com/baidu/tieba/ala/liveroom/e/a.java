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
    private r aAj;
    private ViewGroup fZy;
    protected c gpv;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean fQC = true;
    private ViewGroup.LayoutParams gpu = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.fZy = viewGroup;
        bIm();
    }

    private void bIm() {
        this.mParentView = new FrameLayout(this.fZy.getContext());
        this.mParentView.setId(a.g.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.fZy.addView(this.mParentView, this.gpu);
    }

    public void a(r rVar, b bVar) {
        if (rVar != null && rVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aAj = rVar;
            if (this.mParentView == null || this.fZy.indexOfChild(this.mParentView) < 0) {
                bIm();
                this.mParentView.setVisibility(this.fQC ? 0 : 8);
            }
            if (this.gpv == null || (this.mParentView != null && this.mParentView.indexOfChild(this.gpv.getView()) < 0)) {
                this.gpv = new c(this.mTbPageContext);
                this.mParentView.addView(this.gpv.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.gpv.bPe().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.gpv.bPd();
                        a.this.gpv.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.tT(a.i.ala_back_to_come_title);
            this.gpv.a(bVar2);
            this.gpv.show();
        }
    }

    public void dz(int i) {
        View bPe;
        LinearLayout.LayoutParams layoutParams;
        if (this.gpv != null && (bPe = this.gpv.bPe()) != null && (layoutParams = (LinearLayout.LayoutParams) bPe.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.gpv.show();
            } else if (i == 2) {
                this.gpv.hide();
            }
            bPe.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.fQC = true;
        kB(z);
    }

    private void kB(boolean z) {
        if (this.gpv != null && this.gpv.getView() != null && (this.gpv.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gpv.getView().getParent()).removeView(this.gpv.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
