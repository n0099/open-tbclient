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
    private String aOt;
    private String brl;
    private a gSK;
    private a gSL;
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
            this.brl = bundle.getString("anchor_id");
            this.aOt = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.brl = arguments.getString("anchor_id");
        this.aOt = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mRootView = new RelativeLayout(getPageContext().getPageActivity());
        this.gSK = new a(getPageContext(), false, this.mIsHost);
        this.gSK.d(this.mLiveId, this.brl, this.aOt, this.mTabId);
        this.gSL = new a(getPageContext(), true, this.mIsHost);
        this.gSL.d(this.mLiveId, this.brl, this.aOt, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.gSL.getRootView().setVisibility(0);
            this.gSK.getRootView().setVisibility(8);
        } else {
            this.gSL.getRootView().setVisibility(8);
            this.gSK.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.gSK.getRootView(), layoutParams);
        this.mRootView.addView(this.gSL.getRootView(), layoutParams);
        return this.mRootView;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gSK != null && this.gSL != null) {
            if (configuration.orientation == 2) {
                this.gSL.getRootView().setVisibility(0);
                this.gSK.getRootView().setVisibility(8);
            } else {
                this.gSL.getRootView().setVisibility(8);
                this.gSK.getRootView().setVisibility(0);
            }
            this.gSK.blq();
            this.gSL.blq();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.brl);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aOt);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gSK != null) {
            this.gSK.bXh();
            this.gSK.onDestroy();
        }
        if (this.gSL != null) {
            this.gSL.bXh();
            this.gSL.onDestroy();
        }
    }
}
