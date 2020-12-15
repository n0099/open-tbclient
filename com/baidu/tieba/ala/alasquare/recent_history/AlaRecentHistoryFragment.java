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
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import com.baidu.tieba.ala.alasquare.recent_history.c.a;
import com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaRecentHistoryFragment extends BaseFragment {
    private AlaRecentHistoryModel gwj;
    private a gwk;
    private h mRefreshView;
    private int mType;
    private f.c fci = new f.c() { // from class: com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaRecentHistoryFragment.this.gwj != null) {
                AlaRecentHistoryFragment.this.gwj.refresh();
            }
        }
    };
    private BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaRecentHistoryFragment.this.gwj != null) {
                AlaRecentHistoryFragment.this.gwj.bRN();
            }
        }
    };
    private AlaRecentHistoryModel.a gwl = new AlaRecentHistoryModel.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryFragment.3
        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.a
        public void e(boolean z, List<b> list) {
            AlaRecentHistoryFragment.this.gwk.completePullRefresh();
            AlaRecentHistoryFragment.this.hideLoadingView(AlaRecentHistoryFragment.this.gwk.bSK());
            AlaRecentHistoryFragment.this.gwk.setData(list, z);
            if (y.isEmpty(list)) {
                AlaRecentHistoryFragment.this.a(true, AlaRecentHistoryFragment.this.gwk.bSK(), AlaRecentHistoryFragment.this.mType == 0 ? AlaRecentHistoryFragment.this.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_living_no_data_tip) : AlaRecentHistoryFragment.this.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_whole_no_data_tip));
            } else {
                AlaRecentHistoryFragment.this.a(false, null, null);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.a
        public void h(int i, String str, boolean z) {
            AlaRecentHistoryFragment.this.gwk.completePullRefresh();
            if (!z) {
                AlaRecentHistoryFragment.this.showNetRefreshView(AlaRecentHistoryFragment.this.gwk.bSK(), str, false);
            } else {
                AlaRecentHistoryFragment.this.showToast(R.string.square_load_data_failed_tip);
            }
            AlaRecentHistoryFragment.this.gwk.bSL();
        }
    };

    public static AlaRecentHistoryFragment vb(int i) {
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
        this.gwj = new AlaRecentHistoryModel(getPageContext(), this.mType, this.gwl);
        this.gwk = new a(getPageContext(), this.mType);
        this.gwk.setListPullRefreshListener(this.fci);
        this.gwk.setOnSrollToBottomListener(this.WQ);
        refreshData();
        if (this.mType == 0) {
            TiebaStatic.log("c12650");
        }
        return this.gwk.getRootView();
    }

    private void refreshData() {
        hideNetRefreshView(this.gwk.bSK());
        if (y.getCount(this.gwj.getData()) == 0) {
            showLoadingView(this.gwk.bSK());
        }
        if (this.gwj != null) {
            this.gwj.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ViewGroup viewGroup, String str) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getPageActivity(), null);
        }
        if (z) {
            this.mRefreshView.attachView(viewGroup);
            this.mRefreshView.bDZ().setVisibility(8);
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
        if (this.gwk != null) {
            this.gwk.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gwj != null) {
            this.gwj.onDestroy();
        }
        if (this.gwk != null) {
            this.gwk.onDestroy();
        }
    }
}
