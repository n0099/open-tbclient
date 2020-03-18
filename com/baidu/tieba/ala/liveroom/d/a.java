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
    private m alp;
    protected c eUr;
    private ViewGroup ewN;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean ewT = true;
    private ViewGroup.LayoutParams ewO = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.ewN = (ViewGroup) this.mTbPageContext.getPageActivity().findViewById(a.g.live_root_view);
        bdY();
    }

    private void bdY() {
        this.mParentView = new FrameLayout(this.ewN.getContext());
        this.mParentView.setBackgroundColor(0);
        this.ewN.addView(this.mParentView, this.ewO);
    }

    public void a(m mVar, b bVar) {
        if (mVar != null && mVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.alp = mVar;
            if (this.mParentView == null || this.ewN.indexOfChild(this.mParentView) < 0) {
                bdY();
                this.mParentView.setVisibility(this.ewT ? 0 : 8);
            }
            if (this.eUr == null || (this.mParentView != null && this.mParentView.indexOfChild(this.eUr.getView()) < 0)) {
                this.eUr = new c(this.mTbPageContext);
                this.mParentView.addView(this.eUr.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.eUr.bkg().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.eUr.bkf();
                        a.this.eUr.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.pW(a.i.ala_back_to_come_title);
            this.eUr.a(bVar2);
            this.eUr.show();
        }
    }

    public void bW(int i) {
        View bkg;
        LinearLayout.LayoutParams layoutParams;
        if (this.eUr != null && (bkg = this.eUr.bkg()) != null && (layoutParams = (LinearLayout.LayoutParams) bkg.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.eUr.show();
            } else if (i == 2) {
                this.eUr.hide();
            }
            bkg.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.ewT = true;
        hT(z);
    }

    private void hT(boolean z) {
        if (this.eUr != null && this.eUr.getView() != null && (this.eUr.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.eUr.getView().getParent()).removeView(this.eUr.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
