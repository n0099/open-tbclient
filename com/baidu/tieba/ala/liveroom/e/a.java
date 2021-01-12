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
/* loaded from: classes10.dex */
public class a {
    private x aBr;
    private ViewGroup bNl;
    private boolean gLt = true;
    private ViewGroup.LayoutParams hpF = new ViewGroup.LayoutParams(-2, -1);
    protected c hpG;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.bNl = viewGroup;
        bNr();
    }

    private void bNr() {
        this.mParentView = new FrameLayout(this.bNl.getContext());
        this.mParentView.setId(a.f.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.bNl.addView(this.mParentView, this.hpF);
    }

    public void a(x xVar, b bVar) {
        if (xVar != null && xVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aBr = xVar;
            if (this.mParentView == null || this.bNl.indexOfChild(this.mParentView) < 0) {
                bNr();
                this.mParentView.setVisibility(this.gLt ? 0 : 8);
            }
            if (this.hpG == null || (this.mParentView != null && this.mParentView.indexOfChild(this.hpG.getView()) < 0)) {
                this.hpG = new c(this.mTbPageContext);
                this.mParentView.addView(this.hpG.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.hpG.cby().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.hpG.cbx();
                        a.this.hpG.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.e.back_to_come_logo);
            bVar2.vg(a.h.ala_back_to_come_title);
            this.hpG.a(bVar2);
            this.hpG.show();
        }
    }

    public void co(int i) {
        View cby;
        LinearLayout.LayoutParams layoutParams;
        if (this.hpG != null && (cby = this.hpG.cby()) != null && (layoutParams = (LinearLayout.LayoutParams) cby.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds288);
                this.hpG.show();
            } else if (i == 2) {
                this.hpG.hide();
            }
            cby.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.gLt = true;
        mr(z);
    }

    private void mr(boolean z) {
        if (this.hpG != null && this.hpG.getView() != null && (this.hpG.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hpG.getView().getParent()).removeView(this.hpG.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
