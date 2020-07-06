package com.baidu.tieba.ala.guardthrone.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.h.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes3.dex */
public class a implements b {
    private String aAL;
    private String aZa;
    private com.baidu.tieba.ala.guardthrone.view.a fNf;
    private com.baidu.tieba.ala.guardthrone.view.a fNg;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.aZa = str2;
        this.aAL = str3;
        this.mTabId = i;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = new RelativeLayout(this.mTbPageContext.getPageActivity());
        this.fNf = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, false, this.mIsHost);
        this.fNf.d(this.mLiveId, this.aZa, this.aAL, this.mTabId);
        this.fNg = new com.baidu.tieba.ala.guardthrone.view.a(this.mTbPageContext, true, this.mIsHost);
        this.fNg.d(this.mLiveId, this.aZa, this.aAL, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.fNg.getRootView().setVisibility(0);
            this.fNf.getRootView().setVisibility(8);
        } else {
            this.fNg.getRootView().setVisibility(8);
            this.fNf.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.fNf.getRootView(), layoutParams);
        this.mRootView.addView(this.fNg.getRootView(), layoutParams);
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
        if (this.fNf != null && this.fNg != null) {
            if (configuration.orientation == 2) {
                this.fNg.getRootView().setVisibility(0);
                this.fNf.getRootView().setVisibility(8);
            } else {
                this.fNg.getRootView().setVisibility(8);
                this.fNf.getRootView().setVisibility(0);
            }
            this.fNf.aOF();
            this.fNg.aOF();
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.fNf != null) {
            this.fNf.byx();
            this.fNf.onDestroy();
        }
        if (this.fNg != null) {
            this.fNg.byx();
            this.fNg.onDestroy();
        }
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        return this.mRootView;
    }
}
