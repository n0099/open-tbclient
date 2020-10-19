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
    private String aLF;
    private String bla;
    private com.baidu.tieba.ala.guardthrone.view.a gub;
    private com.baidu.tieba.ala.guardthrone.view.a guc;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bla = str2;
        this.aLF = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.gub = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.gub.d(this.mLiveId, this.bla, this.aLF, this.mTabId);
        this.guc = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.guc.d(this.mLiveId, this.bla, this.aLF, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.guc.getRootView().setVisibility(0);
            this.gub.getRootView().setVisibility(8);
        } else {
            this.guc.getRootView().setVisibility(8);
            this.gub.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.gub.getRootView(), layoutParams);
        this.mRootView.addView(this.guc.getRootView(), layoutParams);
    }

    @Override // com.baidu.live.h.b
    public void bO(boolean z) {
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.i.guard_throne_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.gub != null && this.guc != null) {
            if (configuration.orientation == 2) {
                this.guc.getRootView().setVisibility(0);
                this.gub.getRootView().setVisibility(8);
            } else {
                this.guc.getRootView().setVisibility(8);
                this.gub.getRootView().setVisibility(0);
            }
            this.gub.bet();
            this.guc.bet();
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.gub != null) {
            this.gub.bPa();
            this.gub.onDestroy();
        }
        if (this.guc != null) {
            this.guc.bPa();
            this.guc.onDestroy();
        }
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        return this.mRootView;
    }
}
