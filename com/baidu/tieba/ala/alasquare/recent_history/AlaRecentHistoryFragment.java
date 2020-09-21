package com.baidu.tieba.ala.alasquare.recent_history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import com.baidu.tieba.ala.alasquare.recent_history.c.a;
import com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaRecentHistoryFragment extends BaseFragment {
    private AlaRecentHistoryModel fMi;
    private a fMj;
    private h mRefreshView;
    private int mType;
    private f.c evf = new f.c() { // from class: com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaRecentHistoryFragment.this.fMi != null) {
                AlaRecentHistoryFragment.this.fMi.refresh();
            }
        }
    };
    private BdListView.e Vz = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaRecentHistoryFragment.this.fMi != null) {
                AlaRecentHistoryFragment.this.fMi.bGU();
            }
        }
    };
    private AlaRecentHistoryModel.a fMk = new AlaRecentHistoryModel.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryFragment.3
        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.a
        public void f(boolean z, List<b> list) {
            AlaRecentHistoryFragment.this.fMj.completePullRefresh();
            AlaRecentHistoryFragment.this.hideLoadingView(AlaRecentHistoryFragment.this.fMj.bHR());
            AlaRecentHistoryFragment.this.fMj.setData(list, z);
            if (y.isEmpty(list)) {
                AlaRecentHistoryFragment.this.a(true, AlaRecentHistoryFragment.this.fMj.bHR(), AlaRecentHistoryFragment.this.mType == 0 ? AlaRecentHistoryFragment.this.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_living_no_data_tip) : AlaRecentHistoryFragment.this.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_whole_no_data_tip));
            } else {
                AlaRecentHistoryFragment.this.a(false, null, null);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.a
        public void f(int i, String str, boolean z) {
            AlaRecentHistoryFragment.this.fMj.completePullRefresh();
            if (!z) {
                AlaRecentHistoryFragment.this.showNetRefreshView(AlaRecentHistoryFragment.this.fMj.bHR(), str, false);
            } else {
                AlaRecentHistoryFragment.this.showToast(R.string.square_load_data_failed_tip);
            }
            AlaRecentHistoryFragment.this.fMj.bHS();
        }
    };

    public static AlaRecentHistoryFragment sY(int i) {
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
        this.fMi = new AlaRecentHistoryModel(getPageContext(), this.mType, this.fMk);
        this.fMj = new a(getPageContext(), this.mType);
        this.fMj.setListPullRefreshListener(this.evf);
        this.fMj.setOnSrollToBottomListener(this.Vz);
        refreshData();
        if (this.mType == 0) {
            TiebaStatic.log("c12650");
        }
        return this.fMj.getRootView();
    }

    private void refreshData() {
        hideNetRefreshView(this.fMj.bHR());
        if (y.getCount(this.fMi.getData()) == 0) {
            showLoadingView(this.fMj.bHR());
        }
        if (this.fMi != null) {
            this.fMi.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ViewGroup viewGroup, String str) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getPageActivity(), null);
        }
        if (z) {
            this.mRefreshView.attachView(viewGroup);
            this.mRefreshView.buf().setVisibility(8);
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
        if (this.fMj != null) {
            this.fMj.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fMi != null) {
            this.fMi.onDestroy();
        }
        if (this.fMj != null) {
            this.fMj.onDestroy();
        }
    }
}
