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
    private String aHk;
    private String beu;
    private com.baidu.tieba.ala.guardthrone.view.a geB;
    private com.baidu.tieba.ala.guardthrone.view.a geC;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.beu = str2;
        this.aHk = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.geB = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.geB.d(this.mLiveId, this.beu, this.aHk, this.mTabId);
        this.geC = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.geC.d(this.mLiveId, this.beu, this.aHk, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.geC.getRootView().setVisibility(0);
            this.geB.getRootView().setVisibility(8);
        } else {
            this.geC.getRootView().setVisibility(8);
            this.geB.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.geB.getRootView(), layoutParams);
        this.mRootView.addView(this.geC.getRootView(), layoutParams);
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
        if (this.geB != null && this.geC != null) {
            if (configuration.orientation == 2) {
                this.geC.getRootView().setVisibility(0);
                this.geB.getRootView().setVisibility(8);
            } else {
                this.geC.getRootView().setVisibility(8);
                this.geB.getRootView().setVisibility(0);
            }
            this.geB.baR();
            this.geC.baR();
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.geB != null) {
            this.geB.bLg();
            this.geB.onDestroy();
        }
        if (this.geC != null) {
            this.geC.bLg();
            this.geC.onDestroy();
        }
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        return this.mRootView;
    }
}
