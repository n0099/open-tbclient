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
/* loaded from: classes11.dex */
public class NewGuardThroneFragment extends BaseFragment {
    private String aNa;
    private String buH;
    private a hcD;
    private a hcE;
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
            this.buH = bundle.getString("anchor_id");
            this.aNa = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.buH = arguments.getString("anchor_id");
        this.aNa = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mRootView = new RelativeLayout(getPageContext().getPageActivity());
        this.hcD = new a(getPageContext(), false, this.mIsHost);
        this.hcD.i(this.mLiveId, this.buH, this.aNa, this.mTabId);
        this.hcE = new a(getPageContext(), true, this.mIsHost);
        this.hcE.i(this.mLiveId, this.buH, this.aNa, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.hcE.getRootView().setVisibility(0);
            this.hcD.getRootView().setVisibility(8);
        } else {
            this.hcE.getRootView().setVisibility(8);
            this.hcD.getRootView().setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mRootView.addView(this.hcD.getRootView(), layoutParams);
        this.mRootView.addView(this.hcE.getRootView(), layoutParams);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.hcD != null && this.hcE != null) {
            if (configuration.orientation == 2) {
                this.hcE.getRootView().setVisibility(0);
                this.hcD.getRootView().setVisibility(8);
            } else {
                this.hcE.getRootView().setVisibility(8);
                this.hcD.getRootView().setVisibility(0);
            }
            this.hcD.bkp();
            this.hcE.bkp();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.buH);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aNa);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hcD != null) {
            this.hcD.bWA();
            this.hcD.onDestroy();
        }
        if (this.hcE != null) {
            this.hcE.bWA();
            this.hcE.onDestroy();
        }
    }
}
