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
    private String aIB;
    private String bhk;
    private com.baidu.tieba.ala.guardthrone.view.a ghM;
    private com.baidu.tieba.ala.guardthrone.view.a ghN;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bhk = str2;
        this.aIB = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.ghM = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.ghM.d(this.mLiveId, this.bhk, this.aIB, this.mTabId);
        this.ghN = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.ghN.d(this.mLiveId, this.bhk, this.aIB, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.ghN.getRootView().setVisibility(0);
            this.ghM.getRootView().setVisibility(8);
        } else {
            this.ghN.getRootView().setVisibility(8);
            this.ghM.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.ghM.getRootView(), layoutParams);
        this.mRootView.addView(this.ghN.getRootView(), layoutParams);
    }

    @Override // com.baidu.live.h.b
    public void bL(boolean z) {
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.i.guard_throne_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.ghM != null && this.ghN != null) {
            if (configuration.orientation == 2) {
                this.ghN.getRootView().setVisibility(0);
                this.ghM.getRootView().setVisibility(8);
            } else {
                this.ghN.getRootView().setVisibility(8);
                this.ghM.getRootView().setVisibility(0);
            }
            this.ghM.bbL();
            this.ghN.bbL();
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.ghM != null) {
            this.ghM.bMq();
            this.ghM.onDestroy();
        }
        if (this.ghN != null) {
            this.ghN.bMq();
            this.ghN.onDestroy();
        }
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        return this.mRootView;
    }
}
