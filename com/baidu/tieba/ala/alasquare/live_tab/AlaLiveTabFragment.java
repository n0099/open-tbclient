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
/* loaded from: classes3.dex */
public class AlaLiveTabFragment extends BaseFragment implements af {
    public static int elq = 1;
    public static int elr = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a els;
    private AlaLiveUserNotifyController elt;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener elu;
    private boolean elx;
    private boolean elv = true;
    private int elw = -1;
    private CustomMessageListener ely = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.els.hZ(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.elv || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.bcx();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.els.bcR());
                        AlaLiveTabFragment.this.els.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.elv = false;
                    }
                } else if (AlaLiveTabFragment.this.elv || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.els.bcR());
                    AlaLiveTabFragment.this.bcw();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.els = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.elx);
        if (this.elt == null) {
            this.elt = new AlaLiveUserNotifyController(getPageContext());
        }
        this.elu = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.elt.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.elu);
        MessageManager.getInstance().registerListener(this.ely);
        this.els.init();
        if (this.elw > 0) {
            bcy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bcR = this.els.bcR();
        if (bcR.getParent() instanceof ViewGroup) {
            ((ViewGroup) bcR.getParent()).removeView(bcR);
        }
        return bcR;
    }

    public void bcw() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.els != null) {
                        AlaLiveTabFragment.this.els.hZ(false);
                        AlaLiveTabFragment.this.bcy();
                        AlaLiveTabFragment.this.els.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mE(R.drawable.new_pic_emotion_08);
        this.els.hZ(false);
        this.mRefreshView.mG(0);
        this.mRefreshView.attachView(this.els.bcR(), false);
    }

    public void bcx() {
        this.els.hZ(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.els.bcR());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcy() {
        if (this.elw < 0) {
            this.elw = this.els.bcR().getHeight();
        }
        showLoadingView(this.els.bcR(), false, (((this.elw - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.af
    public void AC() {
        this.els.bcS();
    }

    @Override // com.baidu.tieba.frs.af
    public void bcz() {
    }

    @Override // com.baidu.tieba.frs.af
    public void bcA() {
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
        this.elx = true;
        this.els.loadData();
        bcy();
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
    public void aHN() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.els != null) {
            this.els.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.elv = true;
        if (this.els != null) {
            this.els.destroy();
        }
        if (this.elt != null) {
            this.elt.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.elu);
        MessageManager.getInstance().unRegisterListener(this.ely);
    }
}
