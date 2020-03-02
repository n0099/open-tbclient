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
    private m ald;
    protected c eTG;
    private ViewGroup ewe;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean ewk = true;
    private ViewGroup.LayoutParams ewf = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.ewe = (ViewGroup) this.mTbPageContext.getPageActivity().findViewById(a.g.live_root_view);
        bdS();
    }

    private void bdS() {
        this.mParentView = new FrameLayout(this.ewe.getContext());
        this.mParentView.setBackgroundColor(0);
        this.ewe.addView(this.mParentView, this.ewf);
    }

    public void a(m mVar, b bVar) {
        if (mVar != null && mVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.ald = mVar;
            if (this.mParentView == null || this.ewe.indexOfChild(this.mParentView) < 0) {
                bdS();
                this.mParentView.setVisibility(this.ewk ? 0 : 8);
            }
            if (this.eTG == null || (this.mParentView != null && this.mParentView.indexOfChild(this.eTG.getView()) < 0)) {
                this.eTG = new c(this.mTbPageContext);
                this.mParentView.addView(this.eTG.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.eTG.bka().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.eTG.bjZ();
                        a.this.eTG.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.pU(a.i.ala_back_to_come_title);
            this.eTG.a(bVar2);
            this.eTG.show();
        }
    }

    public void bW(int i) {
        View bka;
        LinearLayout.LayoutParams layoutParams;
        if (this.eTG != null && (bka = this.eTG.bka()) != null && (layoutParams = (LinearLayout.LayoutParams) bka.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.eTG.show();
            } else if (i == 2) {
                this.eTG.hide();
            }
            bka.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.ewk = true;
        hS(z);
    }

    private void hS(boolean z) {
        if (this.eTG != null && this.eTG.getView() != null && (this.eTG.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.eTG.getView().getParent()).removeView(this.eTG.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
