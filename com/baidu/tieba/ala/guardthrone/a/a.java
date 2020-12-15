package com.baidu.tieba.ala.guardthrone.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.j.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a implements c {
    private String aOt;
    private String brl;
    private com.baidu.tieba.ala.guardthrone.view.a gSM;
    private com.baidu.tieba.ala.guardthrone.view.a gSN;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.j.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.brl = str2;
        this.aOt = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.gSM = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.gSM.d(this.mLiveId, this.brl, this.aOt, this.mTabId);
        this.gSN = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.gSN.d(this.mLiveId, this.brl, this.aOt, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.gSN.getRootView().setVisibility(0);
            this.gSM.getRootView().setVisibility(8);
        } else {
            this.gSN.getRootView().setVisibility(8);
            this.gSM.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.gSM.getRootView(), layoutParams);
        this.mRootView.addView(this.gSN.getRootView(), layoutParams);
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
        if (this.gSM != null && this.gSN != null) {
            if (configuration.orientation == 2) {
                this.gSN.getRootView().setVisibility(0);
                this.gSM.getRootView().setVisibility(8);
            } else {
                this.gSN.getRootView().setVisibility(8);
                this.gSM.getRootView().setVisibility(0);
            }
            this.gSM.blq();
            this.gSN.blq();
        }
    }

    @Override // com.baidu.live.j.c
    public void onDestroy() {
        if (this.gSM != null) {
            this.gSM.bXi();
            this.gSM.onDestroy();
        }
        if (this.gSN != null) {
            this.gSN.bXi();
            this.gSN.onDestroy();
        }
    }

    @Override // com.baidu.live.j.c
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.j.c
    public void Mf() {
    }

    @Override // com.baidu.live.j.c
    public void cc(boolean z) {
    }
}
