package com.baidu.tieba.ala.alasquare.live_tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.notify.AlaLiveUserNotifyController;
import com.baidu.ala.notify.AlaLiveUserNotifyManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabModel;
import com.baidu.tieba.frs.af;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaLiveTabFragment extends BaseFragment implements af {
    private com.baidu.tieba.ala.alasquare.live_tab.view.a ehc;
    private AlaLiveTabModel ehd;
    private AlaLiveUserNotifyController ehe;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener ehf;
    private g.c ehg = new g.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                AlaLiveTabFragment.this.ehd.refresh();
            } else {
                AlaLiveTabFragment.this.ehc.bad();
            }
        }
    };
    private BdListView.e ehh = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                AlaLiveTabFragment.this.ehc.hideLoadingView();
            } else {
                AlaLiveTabFragment.this.ehd.aZs();
            }
        }
    };
    private AlaLiveTabModel.a ehi = new AlaLiveTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabModel.a
        public void a(boolean z, boolean z2, List<m> list) {
            if (!z2) {
                AlaLiveTabFragment.this.ehc.hideLoadingView();
            } else if (z) {
                AlaLiveTabFragment.this.ehc.aZH();
            } else {
                AlaLiveTabFragment.this.ehc.aZG();
            }
            AlaLiveTabFragment.this.aZK();
            AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.ehc.bac());
            AlaLiveTabFragment.this.ehc.bad();
            AlaLiveTabFragment.this.ehc.setData(list);
            if (v.isEmpty(list) || list.size() != 1 || !(list.get(0) instanceof com.baidu.tieba.ala.alasquare.live_tab.b.g)) {
                AlaLiveTabFragment.this.ehc.bag();
            } else {
                AlaLiveTabFragment.this.ehc.baf();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabModel.a
        public void e(int i, String str, boolean z) {
            AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.ehc.bac());
            AlaLiveTabFragment.this.ehc.bad();
            if (z) {
                AlaLiveTabFragment.this.showToast(R.string.data_load_error);
            } else {
                AlaLiveTabFragment.this.aZJ();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ehc == null) {
            this.ehc = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext());
        }
        if (this.ehd == null) {
            this.ehd = new AlaLiveTabModel(getPageContext(), this.ehi);
        }
        if (this.ehe == null) {
            this.ehe = new AlaLiveUserNotifyController(getPageContext());
        }
        this.ehf = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.ehe.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.ehf);
        init();
    }

    private void init() {
        this.ehc.init();
        this.ehc.setListPullRefreshListener(this.ehg);
        this.ehc.a(this.ehh);
        this.ehd.init();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bac = this.ehc.bac();
        if (bac.getParent() instanceof ViewGroup) {
            ((ViewGroup) bac.getParent()).removeView(bac);
        }
        return bac;
    }

    public void aZJ() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.ehd != null) {
                        AlaLiveTabFragment.this.showLoadingView(AlaLiveTabFragment.this.ehc.bac(), false, (((AlaLiveTabFragment.this.ehc.bac().getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(AlaLiveTabFragment.this.getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                        AlaLiveTabFragment.this.ehd.refresh();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mn(R.drawable.new_pic_emotion_08);
        this.ehc.op(8);
        this.mRefreshView.mp(0);
        this.mRefreshView.attachView(this.ehc.bac(), false);
    }

    public void aZK() {
        this.ehc.op(0);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.ehc.bac());
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        showLoadingView(this.ehc.bac(), false, (((this.ehc.bac().getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
        this.ehd.refresh();
    }

    @Override // com.baidu.tieba.frs.af
    public void xT() {
        this.ehc.reload();
    }

    @Override // com.baidu.tieba.frs.af
    public void aZL() {
    }

    @Override // com.baidu.tieba.frs.af
    public void aZM() {
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.ehc.bae();
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void aFd() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ehc != null) {
            this.ehc.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ehc != null) {
            this.ehc.setListPullRefreshListener(null);
            this.ehc.a((BdListView.e) null);
            this.ehc.destroy();
        }
        if (this.ehd != null) {
            this.ehd.onDestroy();
        }
        if (this.ehe != null) {
            this.ehe.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.ehf);
    }
}
