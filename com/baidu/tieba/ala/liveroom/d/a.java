package com.baidu.tieba.ala.liveroom.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private m ale;
    protected c eTT;
    private ViewGroup ewr;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean ewx = true;
    private ViewGroup.LayoutParams ews = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.ewr = (ViewGroup) this.mTbPageContext.getPageActivity().findViewById(a.g.live_root_view);
        bdT();
    }

    private void bdT() {
        this.mParentView = new FrameLayout(this.ewr.getContext());
        this.mParentView.setBackgroundColor(0);
        this.ewr.addView(this.mParentView, this.ews);
    }

    public void a(m mVar, b bVar) {
        if (mVar != null && mVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.ale = mVar;
            if (this.mParentView == null || this.ewr.indexOfChild(this.mParentView) < 0) {
                bdT();
                this.mParentView.setVisibility(this.ewx ? 0 : 8);
            }
            if (this.eTT == null || (this.mParentView != null && this.mParentView.indexOfChild(this.eTT.getView()) < 0)) {
                this.eTT = new c(this.mTbPageContext);
                this.mParentView.addView(this.eTT.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.eTT.bkb().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.eTT.bka();
                        a.this.eTT.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.pU(a.i.ala_back_to_come_title);
            this.eTT.a(bVar2);
            this.eTT.show();
        }
    }

    public void bW(int i) {
        View bkb;
        LinearLayout.LayoutParams layoutParams;
        if (this.eTT != null && (bkb = this.eTT.bkb()) != null && (layoutParams = (LinearLayout.LayoutParams) bkb.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.eTT.show();
            } else if (i == 2) {
                this.eTT.hide();
            }
            bkb.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.ewx = true;
        hS(z);
    }

    private void hS(boolean z) {
        if (this.eTT != null && this.eTT.getView() != null && (this.eTT.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.eTT.getView().getParent()).removeView(this.eTT.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
