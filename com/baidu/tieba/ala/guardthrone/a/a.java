package com.baidu.tieba.ala.guardthrone.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.h.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes7.dex */
public class a implements b {
    private String aHi;
    private String ber;
    private com.baidu.tieba.ala.guardthrone.view.a gex;
    private com.baidu.tieba.ala.guardthrone.view.a gey;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.ber = str2;
        this.aHi = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.gex = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.gex.d(this.mLiveId, this.ber, this.aHi, this.mTabId);
        this.gey = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.gey.d(this.mLiveId, this.ber, this.aHi, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.gey.getRootView().setVisibility(0);
            this.gex.getRootView().setVisibility(8);
        } else {
            this.gey.getRootView().setVisibility(8);
            this.gex.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.gex.getRootView(), layoutParams);
        this.mRootView.addView(this.gey.getRootView(), layoutParams);
    }

    @Override // com.baidu.live.h.b
    public void bJ(boolean z) {
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.i.guard_throne_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.gex != null && this.gey != null) {
            if (configuration.orientation == 2) {
                this.gey.getRootView().setVisibility(0);
                this.gex.getRootView().setVisibility(8);
            } else {
                this.gey.getRootView().setVisibility(8);
                this.gex.getRootView().setVisibility(0);
            }
            this.gex.baR();
            this.gey.baR();
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.gex != null) {
            this.gex.bLf();
            this.gex.onDestroy();
        }
        if (this.gey != null) {
            this.gey.bLf();
            this.gey.onDestroy();
        }
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        return this.mRootView;
    }
}
