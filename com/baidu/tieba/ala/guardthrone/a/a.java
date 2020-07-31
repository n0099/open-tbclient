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
    private String aBY;
    private String aYY;
    private com.baidu.tieba.ala.guardthrone.view.a fSy;
    private com.baidu.tieba.ala.guardthrone.view.a fSz;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.aYY = str2;
        this.aBY = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.fSy = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.fSy.d(this.mLiveId, this.aYY, this.aBY, this.mTabId);
        this.fSz = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.fSz.d(this.mLiveId, this.aYY, this.aBY, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.fSz.getRootView().setVisibility(0);
            this.fSy.getRootView().setVisibility(8);
        } else {
            this.fSz.getRootView().setVisibility(8);
            this.fSy.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.fSy.getRootView(), layoutParams);
        this.mRootView.addView(this.fSz.getRootView(), layoutParams);
    }

    @Override // com.baidu.live.h.b
    public void bE(boolean z) {
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.i.guard_throne_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.fSy != null && this.fSz != null) {
            if (configuration.orientation == 2) {
                this.fSz.getRootView().setVisibility(0);
                this.fSy.getRootView().setVisibility(8);
            } else {
                this.fSz.getRootView().setVisibility(8);
                this.fSy.getRootView().setVisibility(0);
            }
            this.fSy.aSA();
            this.fSz.aSA();
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.fSy != null) {
            this.fSy.bBL();
            this.fSy.onDestroy();
        }
        if (this.fSz != null) {
            this.fSz.bBL();
            this.fSz.onDestroy();
        }
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        return this.mRootView;
    }
}
