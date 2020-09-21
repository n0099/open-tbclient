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
    private u aAP;
    private ViewGroup gcM;
    protected c gsJ;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean fTM = true;
    private ViewGroup.LayoutParams gsI = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.gcM = viewGroup;
        bJu();
    }

    private void bJu() {
        this.mParentView = new FrameLayout(this.gcM.getContext());
        this.mParentView.setId(a.g.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.gcM.addView(this.mParentView, this.gsI);
    }

    public void a(u uVar, b bVar) {
        if (uVar != null && uVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aAP = uVar;
            if (this.mParentView == null || this.gcM.indexOfChild(this.mParentView) < 0) {
                bJu();
                this.mParentView.setVisibility(this.fTM ? 0 : 8);
            }
            if (this.gsJ == null || (this.mParentView != null && this.mParentView.indexOfChild(this.gsJ.getView()) < 0)) {
                this.gsJ = new c(this.mTbPageContext);
                this.mParentView.addView(this.gsJ.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.gsJ.bQq().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.gsJ.bQp();
                        a.this.gsJ.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.um(a.i.ala_back_to_come_title);
            this.gsJ.a(bVar2);
            this.gsJ.show();
        }
    }

    public void dD(int i) {
        View bQq;
        LinearLayout.LayoutParams layoutParams;
        if (this.gsJ != null && (bQq = this.gsJ.bQq()) != null && (layoutParams = (LinearLayout.LayoutParams) bQq.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.gsJ.show();
            } else if (i == 2) {
                this.gsJ.hide();
            }
            bQq.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.fTM = true;
        kD(z);
    }

    private void kD(boolean z) {
        if (this.gsJ != null && this.gsJ.getView() != null && (this.gsJ.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gsJ.getView().getParent()).removeView(this.gsJ.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
