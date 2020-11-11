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
    private String aNj;
    private String bnP;
    private com.baidu.tieba.ala.guardthrone.view.a gJS;
    private com.baidu.tieba.ala.guardthrone.view.a gJT;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bnP = str2;
        this.aNj = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.gJS = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.gJS.d(this.mLiveId, this.bnP, this.aNj, this.mTabId);
        this.gJT = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.gJT.d(this.mLiveId, this.bnP, this.aNj, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.gJT.getRootView().setVisibility(0);
            this.gJS.getRootView().setVisibility(8);
        } else {
            this.gJT.getRootView().setVisibility(8);
            this.gJS.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.gJS.getRootView(), layoutParams);
        this.mRootView.addView(this.gJT.getRootView(), layoutParams);
    }

    @Override // com.baidu.live.h.b
    public void bQ(boolean z) {
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.guard_throne_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.gJS != null && this.gJT != null) {
            if (configuration.orientation == 2) {
                this.gJT.getRootView().setVisibility(0);
                this.gJS.getRootView().setVisibility(8);
            } else {
                this.gJT.getRootView().setVisibility(8);
                this.gJS.getRootView().setVisibility(0);
            }
            this.gJS.biM();
            this.gJT.biM();
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.gJS != null) {
            this.gJS.bUe();
            this.gJS.onDestroy();
        }
        if (this.gJT != null) {
            this.gJT.bUe();
            this.gJT.onDestroy();
        }
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.h.b
    public void KM() {
    }

    @Override // com.baidu.live.h.b
    public void bR(boolean z) {
    }
}
