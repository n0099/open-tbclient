package com.baidu.tieba.ala.guardthrone.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.j.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes11.dex */
public class a implements c {
    private String aNa;
    private String buH;
    private com.baidu.tieba.ala.guardthrone.view.a hcD;
    private com.baidu.tieba.ala.guardthrone.view.a hcE;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.j.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.buH = str2;
        this.aNa = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.hcD = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.hcD.i(this.mLiveId, this.buH, this.aNa, this.mTabId);
        this.hcE = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.hcE.i(this.mLiveId, this.buH, this.aNa, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.hcE.getRootView().setVisibility(0);
            this.hcD.getRootView().setVisibility(8);
        } else {
            this.hcE.getRootView().setVisibility(8);
            this.hcD.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.hcD.getRootView(), layoutParams);
        this.mRootView.addView(this.hcE.getRootView(), layoutParams);
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
        if (this.hcD != null && this.hcE != null) {
            if (configuration.orientation == 2) {
                this.hcE.getRootView().setVisibility(0);
                this.hcD.getRootView().setVisibility(8);
            } else {
                this.hcE.getRootView().setVisibility(8);
                this.hcD.getRootView().setVisibility(0);
            }
            this.hcD.bkp();
            this.hcE.bkp();
        }
    }

    @Override // com.baidu.live.j.c
    public void onDestroy() {
        if (this.hcD != null) {
            this.hcD.bWA();
            this.hcD.onDestroy();
        }
        if (this.hcE != null) {
            this.hcE.bWA();
            this.hcE.onDestroy();
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
