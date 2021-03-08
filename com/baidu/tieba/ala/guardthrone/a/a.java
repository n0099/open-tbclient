package com.baidu.tieba.ala.guardthrone.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.j.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes10.dex */
public class a implements c {
    private String aOA;
    private String bwh;
    private com.baidu.tieba.ala.guardthrone.view.a heA;
    private com.baidu.tieba.ala.guardthrone.view.a heB;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.j.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bwh = str2;
        this.aOA = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.heA = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.heA.i(this.mLiveId, this.bwh, this.aOA, this.mTabId);
        this.heB = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.heB.i(this.mLiveId, this.bwh, this.aOA, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.heB.getRootView().setVisibility(0);
            this.heA.getRootView().setVisibility(8);
        } else {
            this.heB.getRootView().setVisibility(8);
            this.heA.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.heA.getRootView(), layoutParams);
        this.mRootView.addView(this.heB.getRootView(), layoutParams);
    }

    @Override // com.baidu.live.j.c
    public void cb(boolean z) {
    }

    @Override // com.baidu.live.j.c
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.guard_throne_title) : "";
    }

    @Override // com.baidu.live.j.c
    public void onConfigurationChanged(Configuration configuration) {
        if (this.heA != null && this.heB != null) {
            if (configuration.orientation == 2) {
                this.heB.getRootView().setVisibility(0);
                this.heA.getRootView().setVisibility(8);
            } else {
                this.heB.getRootView().setVisibility(8);
                this.heA.getRootView().setVisibility(0);
            }
            this.heA.bkr();
            this.heB.bkr();
        }
    }

    @Override // com.baidu.live.j.c
    public void onDestroy() {
        if (this.heA != null) {
            this.heA.bWN();
            this.heA.onDestroy();
        }
        if (this.heB != null) {
            this.heB.bWN();
            this.heB.onDestroy();
        }
    }

    @Override // com.baidu.live.j.c
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.j.c
    public void cc(boolean z) {
    }

    @Override // com.baidu.live.j.c
    public void cd(boolean z) {
    }
}
