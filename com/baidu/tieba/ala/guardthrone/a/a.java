package com.baidu.tieba.ala.guardthrone.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.k.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes10.dex */
public class a implements c {
    private String aKn;
    private String bre;
    private com.baidu.tieba.ala.guardthrone.view.a gZT;
    private com.baidu.tieba.ala.guardthrone.view.a gZU;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.k.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bre = str2;
        this.aKn = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.gZT = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.gZT.i(this.mLiveId, this.bre, this.aKn, this.mTabId);
        this.gZU = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.gZU.i(this.mLiveId, this.bre, this.aKn, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.gZU.getRootView().setVisibility(0);
            this.gZT.getRootView().setVisibility(8);
        } else {
            this.gZU.getRootView().setVisibility(8);
            this.gZT.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.gZT.getRootView(), layoutParams);
        this.mRootView.addView(this.gZU.getRootView(), layoutParams);
    }

    @Override // com.baidu.live.k.c
    public void bW(boolean z) {
    }

    @Override // com.baidu.live.k.c
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.guard_throne_title) : "";
    }

    @Override // com.baidu.live.k.c
    public void onConfigurationChanged(Configuration configuration) {
        if (this.gZT != null && this.gZU != null) {
            if (configuration.orientation == 2) {
                this.gZU.getRootView().setVisibility(0);
                this.gZT.getRootView().setVisibility(8);
            } else {
                this.gZU.getRootView().setVisibility(8);
                this.gZT.getRootView().setVisibility(0);
            }
            this.gZT.bjV();
            this.gZU.bjV();
        }
    }

    @Override // com.baidu.live.k.c
    public void onDestroy() {
        if (this.gZT != null) {
            this.gZT.bVW();
            this.gZT.onDestroy();
        }
        if (this.gZU != null) {
            this.gZU.bVW();
            this.gZU.onDestroy();
        }
    }

    @Override // com.baidu.live.k.c
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.k.c
    public void bX(boolean z) {
    }

    @Override // com.baidu.live.k.c
    public void bY(boolean z) {
    }
}
