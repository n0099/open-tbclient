package com.baidu.tieba.ala.guardthrone.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.h.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a implements b {
    private String aWr;
    private String ayw;
    private com.baidu.tieba.ala.guardthrone.view.a fBW;
    private com.baidu.tieba.ala.guardthrone.view.a fBX;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.aWr = str2;
        this.ayw = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.fBW = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.fBW.d(this.mLiveId, this.aWr, this.ayw, this.mTabId);
        this.fBX = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.fBX.d(this.mLiveId, this.aWr, this.ayw, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.fBX.getRootView().setVisibility(0);
            this.fBW.getRootView().setVisibility(8);
        } else {
            this.fBX.getRootView().setVisibility(8);
            this.fBW.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.fBW.getRootView(), layoutParams);
        this.mRootView.addView(this.fBX.getRootView(), layoutParams);
    }

    @Override // com.baidu.live.h.b
    public void bB(boolean z) {
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.i.guard_throne_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.fBW != null && this.fBX != null) {
            if (configuration.orientation == 2) {
                this.fBX.getRootView().setVisibility(0);
                this.fBW.getRootView().setVisibility(8);
            } else {
                this.fBX.getRootView().setVisibility(8);
                this.fBW.getRootView().setVisibility(0);
            }
            this.fBW.aNc();
            this.fBX.aNc();
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.fBW != null) {
            this.fBW.bvB();
            this.fBW.onDestroy();
        }
        if (this.fBX != null) {
            this.fBX.bvB();
            this.fBX.onDestroy();
        }
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        return this.mRootView;
    }
}
