package com.baidu.tieba.ala.guardthrone.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.k.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes11.dex */
public class a implements c {
    private String aPa;
    private String bvS;
    private com.baidu.tieba.ala.guardthrone.view.a heA;
    private com.baidu.tieba.ala.guardthrone.view.a hez;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.k.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bvS = str2;
        this.aPa = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.hez = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.hez.i(this.mLiveId, this.bvS, this.aPa, this.mTabId);
        this.heA = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.heA.i(this.mLiveId, this.bvS, this.aPa, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.heA.getRootView().setVisibility(0);
            this.hez.getRootView().setVisibility(8);
        } else {
            this.heA.getRootView().setVisibility(8);
            this.hez.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.hez.getRootView(), layoutParams);
        this.mRootView.addView(this.heA.getRootView(), layoutParams);
    }

    @Override // com.baidu.live.k.c
    public void ca(boolean z) {
    }

    @Override // com.baidu.live.k.c
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.guard_throne_title) : "";
    }

    @Override // com.baidu.live.k.c
    public void onConfigurationChanged(Configuration configuration) {
        if (this.hez != null && this.heA != null) {
            if (configuration.orientation == 2) {
                this.heA.getRootView().setVisibility(0);
                this.hez.getRootView().setVisibility(8);
            } else {
                this.heA.getRootView().setVisibility(8);
                this.hez.getRootView().setVisibility(0);
            }
            this.hez.bnO();
            this.heA.bnO();
        }
    }

    @Override // com.baidu.live.k.c
    public void onDestroy() {
        if (this.hez != null) {
            this.hez.bZN();
            this.hez.onDestroy();
        }
        if (this.heA != null) {
            this.heA.bZN();
            this.heA.onDestroy();
        }
    }

    @Override // com.baidu.live.k.c
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.k.c
    public void cb(boolean z) {
    }

    @Override // com.baidu.live.k.c
    public void cc(boolean z) {
    }
}
