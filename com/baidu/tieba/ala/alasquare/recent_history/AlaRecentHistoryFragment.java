package com.baidu.tieba.ala.alasquare.recent_history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import com.baidu.tieba.ala.alasquare.recent_history.c.a;
import com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaRecentHistoryFragment extends BaseFragment {
    private AlaRecentHistoryModel fxx;
    private a fxy;
    private h mRefreshView;
    private int mType;
    private f.c ejc = new f.c() { // from class: com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaRecentHistoryFragment.this.fxx != null) {
                AlaRecentHistoryFragment.this.fxx.refresh();
            }
        }
    };
    private BdListView.e UC = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaRecentHistoryFragment.this.fxx != null) {
                AlaRecentHistoryFragment.this.fxx.bwE();
            }
        }
    };
    private AlaRecentHistoryModel.a fxz = new AlaRecentHistoryModel.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryFragment.3
        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.a
        public void e(boolean z, List<b> list) {
            AlaRecentHistoryFragment.this.fxy.completePullRefresh();
            AlaRecentHistoryFragment.this.hideLoadingView(AlaRecentHistoryFragment.this.fxy.bxB());
            AlaRecentHistoryFragment.this.fxy.setData(list, z);
            if (x.isEmpty(list)) {
                AlaRecentHistoryFragment.this.a(true, AlaRecentHistoryFragment.this.fxy.bxB(), AlaRecentHistoryFragment.this.mType == 0 ? AlaRecentHistoryFragment.this.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_living_no_data_tip) : AlaRecentHistoryFragment.this.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_whole_no_data_tip));
            } else {
                AlaRecentHistoryFragment.this.a(false, null, null);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.a
        public void g(int i, String str, boolean z) {
            AlaRecentHistoryFragment.this.fxy.completePullRefresh();
            if (!z) {
                AlaRecentHistoryFragment.this.showNetRefreshView(AlaRecentHistoryFragment.this.fxy.bxB(), str, false);
            } else {
                AlaRecentHistoryFragment.this.showToast(R.string.square_load_data_failed_tip);
            }
            AlaRecentHistoryFragment.this.fxy.bxC();
        }
    };

    public static AlaRecentHistoryFragment qu(int i) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fxx = new AlaRecentHistoryModel(getPageContext(), this.mType, this.fxz);
        this.fxy = new a(getPageContext(), this.mType);
        this.fxy.setListPullRefreshListener(this.ejc);
        this.fxy.setOnSrollToBottomListener(this.UC);
        refreshData();
        if (this.mType == 0) {
            TiebaStatic.log("c12650");
        }
        return this.fxy.getRootView();
    }

    private void refreshData() {
        hideNetRefreshView(this.fxy.bxB());
        if (x.getCount(this.fxx.getData()) == 0) {
            showLoadingView(this.fxy.bxB());
        }
        if (this.fxx != null) {
            this.fxx.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ViewGroup viewGroup, String str) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getPageActivity(), null);
        }
        if (z) {
            this.mRefreshView.attachView(viewGroup);
            this.mRefreshView.bko().setVisibility(8);
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
        if (this.fxy != null) {
            this.fxy.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fxx != null) {
            this.fxx.onDestroy();
        }
        if (this.fxy != null) {
            this.fxy.onDestroy();
        }
    }
}
