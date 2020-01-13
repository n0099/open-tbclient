package com.baidu.tieba.ala.liveroom.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.l;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class a {
    private l aiW;
    protected c ePD;
    private ViewGroup erT;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean erZ = true;
    private ViewGroup.LayoutParams erU = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.erT = (ViewGroup) this.mTbPageContext.getPageActivity().findViewById(a.g.live_root_view);
        bbB();
    }

    private void bbB() {
        this.mParentView = new FrameLayout(this.erT.getContext());
        this.mParentView.setBackgroundColor(0);
        this.erT.addView(this.mParentView, this.erU);
    }

    public void a(l lVar, b bVar) {
        if (lVar != null && lVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aiW = lVar;
            if (this.mParentView == null || this.erT.indexOfChild(this.mParentView) < 0) {
                bbB();
                this.mParentView.setVisibility(this.erZ ? 0 : 8);
            }
            if (this.ePD == null || (this.mParentView != null && this.mParentView.indexOfChild(this.ePD.getView()) < 0)) {
                this.ePD = new c(this.mTbPageContext);
                this.mParentView.addView(this.ePD.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.ePD.bhY().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.ePD.bhX();
                        a.this.ePD.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.pM(a.i.ala_back_to_come_title);
            this.ePD.a(bVar2);
            this.ePD.show();
        }
    }

    public void bN(int i) {
        View bhY;
        LinearLayout.LayoutParams layoutParams;
        if (this.ePD != null && (bhY = this.ePD.bhY()) != null && (layoutParams = (LinearLayout.LayoutParams) bhY.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.ePD.show();
            } else if (i == 2) {
                this.ePD.hide();
            }
            bhY.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.erZ = true;
        hL(z);
    }

    private void hL(boolean z) {
        if (this.ePD != null && this.ePD.getView() != null && (this.ePD.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ePD.getView().getParent()).removeView(this.ePD.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
