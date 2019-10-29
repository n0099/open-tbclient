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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.g;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabModel;
import com.baidu.tieba.frs.ae;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaLiveTabFragment extends BaseFragment implements ae {
    private com.baidu.tieba.ala.alasquare.live_tab.view.a dwR;
    private AlaLiveTabModel dwS;
    private AlaLiveUserNotifyController dwT;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener dwU;
    private h.c dwV = new h.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                AlaLiveTabFragment.this.dwS.refresh();
            } else {
                AlaLiveTabFragment.this.dwR.aJH();
            }
        }
    };
    private BdListView.e dwW = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                AlaLiveTabFragment.this.dwR.hideLoadingView();
            } else {
                AlaLiveTabFragment.this.dwS.aIW();
            }
        }
    };
    private AlaLiveTabModel.a dwX = new AlaLiveTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabModel.a
        public void a(boolean z, boolean z2, List<m> list) {
            if (!z2) {
                AlaLiveTabFragment.this.dwR.hideLoadingView();
            } else if (z) {
                AlaLiveTabFragment.this.dwR.aJl();
            } else {
                AlaLiveTabFragment.this.dwR.aJk();
            }
            AlaLiveTabFragment.this.aJo();
            AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.dwR.aJG());
            AlaLiveTabFragment.this.dwR.aJH();
            AlaLiveTabFragment.this.dwR.setData(list);
            if (!v.isEmpty(list) && list.size() == 1 && (list.get(0) instanceof g)) {
                AlaLiveTabFragment.this.dwR.aJJ();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabModel.a
        public void d(int i, String str, boolean z) {
            AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.dwR.aJG());
            AlaLiveTabFragment.this.dwR.aJH();
            if (z) {
                AlaLiveTabFragment.this.showToast(R.string.data_load_error);
            } else {
                AlaLiveTabFragment.this.aJn();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.dwR == null) {
            this.dwR = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext());
        }
        if (this.dwS == null) {
            this.dwS = new AlaLiveTabModel(getPageContext(), this.dwX);
        }
        if (this.dwT == null) {
            this.dwT = new AlaLiveUserNotifyController(getPageContext());
        }
        this.dwU = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.dwT.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.dwU);
        init();
    }

    private void init() {
        this.dwR.init();
        this.dwR.setListPullRefreshListener(this.dwV);
        this.dwR.a(this.dwW);
        this.dwS.init();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup aJG = this.dwR.aJG();
        if (aJG.getParent() instanceof ViewGroup) {
            ((ViewGroup) aJG.getParent()).removeView(aJG);
        }
        return aJG;
    }

    public void aJn() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.dwS != null) {
                        AlaLiveTabFragment.this.showLoadingView(AlaLiveTabFragment.this.dwR.aJG());
                        AlaLiveTabFragment.this.dwS.refresh();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(j.isNetWorkAvailable() ? getResources().getString(R.string.load_error_new_tip) : getResources().getString(R.string.recommend_pb_no_net_text));
        this.mRefreshView.ka(j.isNetWorkAvailable() ? R.drawable.new_pic_emotion_08 : R.drawable.new_pic_emotion_09);
        this.dwR.mh(8);
        this.mRefreshView.kc(0);
        this.mRefreshView.attachView(this.dwR.aJG(), false);
    }

    public void aJo() {
        this.dwR.mh(0);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.dwR.aJG());
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        showLoadingView(this.dwR.aJG());
        this.dwS.refresh();
    }

    @Override // com.baidu.tieba.frs.ae
    public void vU() {
        this.dwR.reload();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJp() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJq() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.dwR.aJI();
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void anO() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dwR != null) {
            this.dwR.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dwR != null) {
            this.dwR.setListPullRefreshListener(null);
            this.dwR.a((BdListView.e) null);
            this.dwR.destroy();
        }
        if (this.dwS != null) {
            this.dwS.onDestroy();
        }
        if (this.dwT != null) {
            this.dwT.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.dwU);
    }
}
