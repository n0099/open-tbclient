package com.baidu.tieba.ala.guardthrone.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.ala.guardthrone.view.a;
/* loaded from: classes4.dex */
public class NewGuardThroneFragment extends BaseFragment {
    private String aBY;
    private String aYY;
    private a fSy;
    private a fSz;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.aYY = bundle.getString("anchor_id");
            this.aBY = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.aYY = arguments.getString("anchor_id");
        this.aBY = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mRootView = new RelativeLayout(getPageContext().getPageActivity());
        this.fSy = new a(getPageContext(), false, this.mIsHost);
        this.fSy.d(this.mLiveId, this.aYY, this.aBY, this.mTabId);
        this.fSz = new a(getPageContext(), true, this.mIsHost);
        this.fSz.d(this.mLiveId, this.aYY, this.aBY, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.fSz.getRootView().setVisibility(0);
            this.fSy.getRootView().setVisibility(8);
        } else {
            this.fSz.getRootView().setVisibility(8);
            this.fSy.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.fSy.getRootView(), layoutParams);
        this.mRootView.addView(this.fSz.getRootView(), layoutParams);
        return this.mRootView;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.fSy != null && this.fSz != null) {
            if (configuration.orientation == 2) {
                this.fSz.getRootView().setVisibility(0);
                this.fSy.getRootView().setVisibility(8);
            } else {
                this.fSz.getRootView().setVisibility(8);
                this.fSy.getRootView().setVisibility(0);
            }
            this.fSy.aSA();
            this.fSz.aSA();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.aYY);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aBY);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fSy != null) {
            this.fSy.bBL();
            this.fSy.onDestroy();
        }
        if (this.fSz != null) {
            this.fSz.bBL();
            this.fSz.onDestroy();
        }
    }
}
