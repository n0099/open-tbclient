package com.baidu.tieba.ala.guardthrone.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.h.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a implements b {
    private String aLy;
    private String bme;
    private com.baidu.tieba.ala.guardthrone.view.a gJA;
    private com.baidu.tieba.ala.guardthrone.view.a gJz;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bme = str2;
        this.aLy = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.gJz = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.gJz.d(this.mLiveId, this.bme, this.aLy, this.mTabId);
        this.gJA = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.gJA.d(this.mLiveId, this.bme, this.aLy, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.gJA.getRootView().setVisibility(0);
            this.gJz.getRootView().setVisibility(8);
        } else {
            this.gJA.getRootView().setVisibility(8);
            this.gJz.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.gJz.getRootView(), layoutParams);
        this.mRootView.addView(this.gJA.getRootView(), layoutParams);
    }

    @Override // com.baidu.live.h.b
    public void bS(boolean z) {
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.guard_throne_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.gJz != null && this.gJA != null) {
            if (configuration.orientation == 2) {
                this.gJA.getRootView().setVisibility(0);
                this.gJz.getRootView().setVisibility(8);
            } else {
                this.gJA.getRootView().setVisibility(8);
                this.gJz.getRootView().setVisibility(0);
            }
            this.gJz.big();
            this.gJA.big();
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.gJz != null) {
            this.gJz.bTx();
            this.gJz.onDestroy();
        }
        if (this.gJA != null) {
            this.gJA.bTx();
            this.gJA.onDestroy();
        }
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.h.b
    public void Kd() {
    }

    @Override // com.baidu.live.h.b
    public void bT(boolean z) {
    }
}
