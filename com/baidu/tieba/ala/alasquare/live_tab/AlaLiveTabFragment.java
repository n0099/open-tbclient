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
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ap;
/* loaded from: classes6.dex */
public class AlaLiveTabFragment extends BaseFragment implements ap {
    public static int gro = 1;
    public static int grp = 1;
    public static int grq = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a grr;
    private AlaLiveUserNotifyController grs;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener grt;
    private boolean grw;
    private boolean gru = true;
    private int grv = -1;
    private CustomMessageListener grx = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.grr.mh(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.gru || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.Yb();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.grr.bSA());
                        AlaLiveTabFragment.this.grr.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.gru = false;
                    }
                } else if (AlaLiveTabFragment.this.gru || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.grr.bSA());
                    AlaLiveTabFragment.this.bSf();
                }
            }
        }
    };
    private CustomMessageListener gry = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.grr != null) {
                    AlaLiveTabFragment.this.grr.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.grr = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.grw);
        if (this.grs == null) {
            this.grs = new AlaLiveUserNotifyController(getPageContext());
        }
        this.grt = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.grs.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.grt);
        MessageManager.getInstance().registerListener(this.grx);
        MessageManager.getInstance().registerListener(this.gry);
        this.grr.init();
        if (this.grv > 0) {
            bSg();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bSA = this.grr.bSA();
        if (bSA.getParent() instanceof ViewGroup) {
            ((ViewGroup) bSA.getParent()).removeView(bSA);
        }
        return bSA;
    }

    public boolean bSe() {
        return this.gru;
    }

    public void bSf() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.grr != null) {
                        AlaLiveTabFragment.this.grr.mh(false);
                        AlaLiveTabFragment.this.bSg();
                        AlaLiveTabFragment.this.grr.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.sC(R.drawable.new_pic_emotion_08);
        this.grr.mh(false);
        this.mRefreshView.sE(0);
        this.mRefreshView.attachView(this.grr.bSA(), false);
    }

    public void Yb() {
        this.grr.mh(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.grr.bSA());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSg() {
        if (this.grv < 0) {
            this.grv = this.grr.bSA().getHeight();
        }
        showLoadingView(this.grr.bSA(), false, (((this.grv - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.ap
    public void VC() {
        this.grr.bSB();
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSh() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSi() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
    }

    @Override // com.baidu.tieba.frs.ap
    public void showFloatingView() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.grw = true;
        this.grr.loadData();
        bSg();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.grr != null) {
                this.grr.mi(true);
            }
        } else if (this.grr != null) {
            this.grr.mi(false);
        }
        if (this.grr != null) {
            this.grr.cb(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bSg();
            this.grr.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void bvt() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.grr != null) {
            this.grr.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gru = true;
        if (this.grr != null) {
            this.grr.destroy();
        }
        if (this.grs != null) {
            this.grs.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.grt);
        MessageManager.getInstance().unRegisterListener(this.grx);
        MessageManager.getInstance().unRegisterListener(this.gry);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a083";
    }
}
