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
    private com.baidu.tieba.ala.alasquare.live_tab.view.a dwa;
    private AlaLiveTabModel dwb;
    private AlaLiveUserNotifyController dwc;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener dwd;
    private h.c dwe = new h.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                AlaLiveTabFragment.this.dwb.refresh();
            } else {
                AlaLiveTabFragment.this.dwa.aJF();
            }
        }
    };
    private BdListView.e dwf = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                AlaLiveTabFragment.this.dwa.hideLoadingView();
            } else {
                AlaLiveTabFragment.this.dwb.aIU();
            }
        }
    };
    private AlaLiveTabModel.a dwg = new AlaLiveTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabModel.a
        public void a(boolean z, boolean z2, List<m> list) {
            if (!z2) {
                AlaLiveTabFragment.this.dwa.hideLoadingView();
            } else if (z) {
                AlaLiveTabFragment.this.dwa.aJj();
            } else {
                AlaLiveTabFragment.this.dwa.aJi();
            }
            AlaLiveTabFragment.this.aJm();
            AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.dwa.aJE());
            AlaLiveTabFragment.this.dwa.aJF();
            AlaLiveTabFragment.this.dwa.setData(list);
            if (!v.isEmpty(list) && list.size() == 1 && (list.get(0) instanceof g)) {
                AlaLiveTabFragment.this.dwa.aJH();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabModel.a
        public void d(int i, String str, boolean z) {
            AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.dwa.aJE());
            AlaLiveTabFragment.this.dwa.aJF();
            if (z) {
                AlaLiveTabFragment.this.showToast(R.string.data_load_error);
            } else {
                AlaLiveTabFragment.this.aJl();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.dwa == null) {
            this.dwa = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext());
        }
        if (this.dwb == null) {
            this.dwb = new AlaLiveTabModel(getPageContext(), this.dwg);
        }
        if (this.dwc == null) {
            this.dwc = new AlaLiveUserNotifyController(getPageContext());
        }
        this.dwd = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.dwc.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.dwd);
        init();
    }

    private void init() {
        this.dwa.init();
        this.dwa.setListPullRefreshListener(this.dwe);
        this.dwa.a(this.dwf);
        this.dwb.init();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup aJE = this.dwa.aJE();
        if (aJE.getParent() instanceof ViewGroup) {
            ((ViewGroup) aJE.getParent()).removeView(aJE);
        }
        return aJE;
    }

    public void aJl() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.dwb != null) {
                        AlaLiveTabFragment.this.showLoadingView(AlaLiveTabFragment.this.dwa.aJE());
                        AlaLiveTabFragment.this.dwb.refresh();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(j.isNetWorkAvailable() ? getResources().getString(R.string.load_error_new_tip) : getResources().getString(R.string.recommend_pb_no_net_text));
        this.mRefreshView.jZ(j.isNetWorkAvailable() ? R.drawable.new_pic_emotion_08 : R.drawable.new_pic_emotion_09);
        this.dwa.mg(8);
        this.mRefreshView.kb(0);
        this.mRefreshView.attachView(this.dwa.aJE(), false);
    }

    public void aJm() {
        this.dwa.mg(0);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.dwa.aJE());
            this.mRefreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        showLoadingView(this.dwa.aJE());
        this.dwb.refresh();
    }

    @Override // com.baidu.tieba.frs.ae
    public void vV() {
        this.dwa.reload();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJn() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJo() {
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
            this.dwa.aJG();
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void anM() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dwa != null) {
            this.dwa.onChangeSkinType();
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
        if (this.dwa != null) {
            this.dwa.setListPullRefreshListener(null);
            this.dwa.a((BdListView.e) null);
            this.dwa.destroy();
        }
        if (this.dwb != null) {
            this.dwb.onDestroy();
        }
        if (this.dwc != null) {
            this.dwc.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.dwd);
    }
}
