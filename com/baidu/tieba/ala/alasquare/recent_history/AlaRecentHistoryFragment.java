package com.baidu.tieba.ala.alasquare.recent_history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import com.baidu.tieba.ala.alasquare.recent_history.c.a;
import com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaRecentHistoryFragment extends BaseFragment {
    private AlaRecentHistoryModel dzM;
    private a dzN;
    private h mRefreshView;
    private int mType;
    private h.c cpa = new h.c() { // from class: com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryFragment.1
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (AlaRecentHistoryFragment.this.dzM != null) {
                AlaRecentHistoryFragment.this.dzM.refresh();
            }
        }
    };
    private BdListView.e xE = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaRecentHistoryFragment.this.dzM != null) {
                AlaRecentHistoryFragment.this.dzM.aIU();
            }
        }
    };
    private AlaRecentHistoryModel.a dzO = new AlaRecentHistoryModel.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryFragment.3
        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.a
        public void d(boolean z, List<b> list) {
            AlaRecentHistoryFragment.this.dzN.completePullRefresh();
            AlaRecentHistoryFragment.this.hideLoadingView(AlaRecentHistoryFragment.this.dzN.aJP());
            AlaRecentHistoryFragment.this.dzN.setData(list, z);
            if (v.isEmpty(list)) {
                AlaRecentHistoryFragment.this.a(true, AlaRecentHistoryFragment.this.dzN.aJP(), AlaRecentHistoryFragment.this.mType == 0 ? AlaRecentHistoryFragment.this.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_living_no_data_tip) : AlaRecentHistoryFragment.this.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_whole_no_data_tip));
            } else {
                AlaRecentHistoryFragment.this.a(false, null, null);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.a
        public void d(int i, String str, boolean z) {
            AlaRecentHistoryFragment.this.dzN.completePullRefresh();
            if (!z) {
                AlaRecentHistoryFragment.this.showNetRefreshView(AlaRecentHistoryFragment.this.dzN.aJP(), str, false);
            } else {
                AlaRecentHistoryFragment.this.showToast(R.string.square_load_data_failed_tip);
            }
            AlaRecentHistoryFragment.this.dzN.aJQ();
        }
    };

    public static AlaRecentHistoryFragment mh(int i) {
        AlaRecentHistoryFragment alaRecentHistoryFragment = new AlaRecentHistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key_type", i);
        alaRecentHistoryFragment.setArguments(bundle);
        return alaRecentHistoryFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mType = arguments.getInt("key_type");
            if (this.mType < 0 || this.mType > 1) {
                getPageContext().getPageActivity().finish();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dzM = new AlaRecentHistoryModel(getPageContext(), this.mType, this.dzO);
        this.dzN = new a(getPageContext(), this.mType);
        this.dzN.setListPullRefreshListener(this.cpa);
        this.dzN.setOnSrollToBottomListener(this.xE);
        refreshData();
        if (this.mType == 0) {
            TiebaStatic.log("c12650");
        }
        return this.dzN.getRootView();
    }

    private void refreshData() {
        hideNetRefreshView(this.dzN.aJP());
        if (v.getCount(this.dzM.getData()) == 0) {
            showLoadingView(this.dzN.aJP());
        }
        if (this.dzM != null) {
            this.dzM.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ViewGroup viewGroup, String str) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getPageActivity(), null);
        }
        if (z) {
            this.mRefreshView.attachView(viewGroup);
            this.mRefreshView.avv().setVisibility(8);
            this.mRefreshView.setSubText(null);
            this.mRefreshView.getTitleView().setVisibility(0);
            this.mRefreshView.getTitleView().setText(str);
            return;
        }
        this.mRefreshView.dettachView(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        refreshData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dzN != null) {
            this.dzN.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dzM != null) {
            this.dzM.onDestroy();
        }
        if (this.dzN != null) {
            this.dzN.onDestroy();
        }
    }
}
