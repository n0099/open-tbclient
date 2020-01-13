package com.baidu.tieba.ala.alasquare.live_tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.notify.AlaLiveUserNotifyController;
import com.baidu.ala.notify.AlaLiveUserNotifyManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.af;
/* loaded from: classes2.dex */
public class AlaLiveTabFragment extends BaseFragment implements af {
    private com.baidu.tieba.ala.alasquare.live_tab.view.a ehl;
    private AlaLiveUserNotifyController ehm;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener ehn;
    private boolean ehq;
    private boolean eho = true;
    private int ehp = -1;
    private CustomMessageListener ehr = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.ehl.hS(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.eho || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.baf();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.ehl.baA());
                        AlaLiveTabFragment.this.ehl.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.eho = false;
                    }
                } else if (AlaLiveTabFragment.this.eho || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.ehl.baA());
                    AlaLiveTabFragment.this.bae();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.ehl = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.ehq);
        if (this.ehm == null) {
            this.ehm = new AlaLiveUserNotifyController(getPageContext());
        }
        this.ehn = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.ehm.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.ehn);
        MessageManager.getInstance().registerListener(this.ehr);
        this.ehl.init();
        if (this.ehp > 0) {
            bag();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup baA = this.ehl.baA();
        if (baA.getParent() instanceof ViewGroup) {
            ((ViewGroup) baA.getParent()).removeView(baA);
        }
        return baA;
    }

    public void bae() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.ehl != null) {
                        AlaLiveTabFragment.this.ehl.hS(false);
                        AlaLiveTabFragment.this.bag();
                        AlaLiveTabFragment.this.ehl.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mn(R.drawable.new_pic_emotion_08);
        this.ehl.hS(false);
        this.mRefreshView.mp(0);
        this.mRefreshView.attachView(this.ehl.baA(), false);
    }

    public void baf() {
        this.ehl.hS(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.ehl.baA());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bag() {
        if (this.ehp < 0) {
            this.ehp = this.ehl.baA().getHeight();
        }
        showLoadingView(this.ehl.baA(), false, (((this.ehp - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.af
    public void yj() {
        this.ehl.baB();
    }

    @Override // com.baidu.tieba.frs.af
    public void bah() {
    }

    @Override // com.baidu.tieba.frs.af
    public void bai() {
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.ehq = true;
        this.ehl.loadData();
        bag();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void aFw() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ehl != null) {
            this.ehl.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eho = true;
        if (this.ehl != null) {
            this.ehl.destroy();
        }
        if (this.ehm != null) {
            this.ehm.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.ehn);
        MessageManager.getInstance().unRegisterListener(this.ehr);
    }
}
