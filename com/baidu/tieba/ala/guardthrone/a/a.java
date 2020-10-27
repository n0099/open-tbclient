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
    private String aMj;
    private String bmv;
    private com.baidu.tieba.ala.guardthrone.view.a gEf;
    private com.baidu.tieba.ala.guardthrone.view.a gEg;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bmv = str2;
        this.aMj = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.gEf = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.gEf.d(this.mLiveId, this.bmv, this.aMj, this.mTabId);
        this.gEg = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.gEg.d(this.mLiveId, this.bmv, this.aMj, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.gEg.getRootView().setVisibility(0);
            this.gEf.getRootView().setVisibility(8);
        } else {
            this.gEg.getRootView().setVisibility(8);
            this.gEf.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.gEf.getRootView(), layoutParams);
        this.mRootView.addView(this.gEg.getRootView(), layoutParams);
    }

    @Override // com.baidu.live.h.b
    public void bP(boolean z) {
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.i.guard_throne_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.gEf != null && this.gEg != null) {
            if (configuration.orientation == 2) {
                this.gEg.getRootView().setVisibility(0);
                this.gEf.getRootView().setVisibility(8);
            } else {
                this.gEg.getRootView().setVisibility(8);
                this.gEf.getRootView().setVisibility(0);
            }
            this.gEf.bgm();
            this.gEg.bgm();
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.gEf != null) {
            this.gEf.bRF();
            this.gEf.onDestroy();
        }
        if (this.gEg != null) {
            this.gEg.bRF();
            this.gEg.onDestroy();
        }
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.h.b
    public void Km() {
    }

    @Override // com.baidu.live.h.b
    public void bQ(boolean z) {
    }
}
