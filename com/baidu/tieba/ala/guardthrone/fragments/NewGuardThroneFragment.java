package com.baidu.tieba.ala.guardthrone.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.ala.guardthrone.view.a;
/* loaded from: classes10.dex */
public class NewGuardThroneFragment extends BaseFragment {
    private String aOA;
    private String bwh;
    private a heA;
    private a heB;
    private boolean mIsHost;
    private String mLiveId;
    private RelativeLayout mRootView;
    private int mTabId;

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.bwh = bundle.getString("anchor_id");
            this.aOA = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.bwh = arguments.getString("anchor_id");
        this.aOA = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mRootView = new RelativeLayout(getPageContext().getPageActivity());
        this.heA = new a(getPageContext(), false, this.mIsHost);
        this.heA.i(this.mLiveId, this.bwh, this.aOA, this.mTabId);
        this.heB = new a(getPageContext(), true, this.mIsHost);
        this.heB.i(this.mLiveId, this.bwh, this.aOA, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.heB.getRootView().setVisibility(0);
            this.heA.getRootView().setVisibility(8);
        } else {
            this.heB.getRootView().setVisibility(8);
            this.heA.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.heA.getRootView(), layoutParams);
        this.mRootView.addView(this.heB.getRootView(), layoutParams);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.heA != null && this.heB != null) {
            if (configuration.orientation == 2) {
                this.heB.getRootView().setVisibility(0);
                this.heA.getRootView().setVisibility(8);
            } else {
                this.heB.getRootView().setVisibility(8);
                this.heA.getRootView().setVisibility(0);
            }
            this.heA.bkr();
            this.heB.bkr();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.bwh);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aOA);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.heA != null) {
            this.heA.bWN();
            this.heA.onDestroy();
        }
        if (this.heB != null) {
            this.heB.bWN();
            this.heB.onDestroy();
        }
    }
}
