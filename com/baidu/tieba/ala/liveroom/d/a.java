package com.baidu.tieba.ala.liveroom.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private q aJj;
    protected c fNd;
    private ViewGroup foI;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean foO = true;
    private ViewGroup.LayoutParams foJ = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.foI = (ViewGroup) this.mTbPageContext.getPageActivity().findViewById(a.g.live_root_view);
        btc();
    }

    private void btc() {
        this.mParentView = new FrameLayout(this.foI.getContext());
        this.mParentView.setBackgroundColor(0);
        this.foI.addView(this.mParentView, this.foJ);
    }

    public void a(q qVar, b bVar) {
        if (qVar != null && qVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aJj = qVar;
            if (this.mParentView == null || this.foI.indexOfChild(this.mParentView) < 0) {
                btc();
                this.mParentView.setVisibility(this.foO ? 0 : 8);
            }
            if (this.fNd == null || (this.mParentView != null && this.mParentView.indexOfChild(this.fNd.getView()) < 0)) {
                this.fNd = new c(this.mTbPageContext);
                this.mParentView.addView(this.fNd.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.fNd.bzz().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.fNd.bzy();
                        a.this.fNd.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.qT(a.i.ala_back_to_come_title);
            this.fNd.a(bVar2);
            this.fNd.show();
        }
    }

    public void cu(int i) {
        View bzz;
        LinearLayout.LayoutParams layoutParams;
        if (this.fNd != null && (bzz = this.fNd.bzz()) != null && (layoutParams = (LinearLayout.LayoutParams) bzz.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.fNd.show();
            } else if (i == 2) {
                this.fNd.hide();
            }
            bzz.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.foO = true;
        jk(z);
    }

    private void jk(boolean z) {
        if (this.fNd != null && this.fNd.getView() != null && (this.fNd.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fNd.getView().getParent()).removeView(this.fNd.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
