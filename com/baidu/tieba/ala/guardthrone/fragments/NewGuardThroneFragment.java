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
    private String aLF;
    private String bla;
    private a gub;
    private a guc;
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
            this.bla = bundle.getString("anchor_id");
            this.aLF = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.bla = arguments.getString("anchor_id");
        this.aLF = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mRootView = new RelativeLayout(getPageContext().getPageActivity());
        this.gub = new a(getPageContext(), false, this.mIsHost);
        this.gub.d(this.mLiveId, this.bla, this.aLF, this.mTabId);
        this.guc = new a(getPageContext(), true, this.mIsHost);
        this.guc.d(this.mLiveId, this.bla, this.aLF, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
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
        return this.mRootView;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
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

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.bla);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aLF);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gub != null) {
            this.gub.bPa();
            this.gub.onDestroy();
        }
        if (this.guc != null) {
            this.guc.bPa();
            this.guc.onDestroy();
        }
    }
}
