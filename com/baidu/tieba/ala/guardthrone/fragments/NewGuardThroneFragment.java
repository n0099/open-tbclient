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
    private String aKn;
    private String bre;
    private a gZT;
    private a gZU;
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
            this.bre = bundle.getString("anchor_id");
            this.aKn = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.bre = arguments.getString("anchor_id");
        this.aKn = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mRootView = new RelativeLayout(getPageContext().getPageActivity());
        this.gZT = new a(getPageContext(), false, this.mIsHost);
        this.gZT.i(this.mLiveId, this.bre, this.aKn, this.mTabId);
        this.gZU = new a(getPageContext(), true, this.mIsHost);
        this.gZU.i(this.mLiveId, this.bre, this.aKn, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
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
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
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

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.bre);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aKn);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gZT != null) {
            this.gZT.bVW();
            this.gZT.onDestroy();
        }
        if (this.gZU != null) {
            this.gZU.bVW();
            this.gZU.onDestroy();
        }
    }
}
