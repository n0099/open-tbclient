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
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aj;
/* loaded from: classes3.dex */
public class AlaLiveTabFragment extends BaseFragment implements aj {
    public static int fcg = 1;
    public static int fch = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a fci;
    private AlaLiveUserNotifyController fcj;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener fck;
    private boolean fcn;
    private boolean fcl = true;
    private int fcm = -1;
    private CustomMessageListener fco = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.fci.js(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.fcl || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.bqO();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fci.brj());
                        AlaLiveTabFragment.this.fci.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.fcl = false;
                    }
                } else if (AlaLiveTabFragment.this.fcl || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fci.brj());
                    AlaLiveTabFragment.this.bqN();
                }
            }
        }
    };
    private CustomMessageListener fcp = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.fci != null) {
                    AlaLiveTabFragment.this.fci.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.fci = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.fcn);
        if (this.fcj == null) {
            this.fcj = new AlaLiveUserNotifyController(getPageContext());
        }
        this.fck = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.fcj.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.fck);
        MessageManager.getInstance().registerListener(this.fco);
        MessageManager.getInstance().registerListener(this.fcp);
        this.fci.init();
        if (this.fcm > 0) {
            bqP();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup brj = this.fci.brj();
        if (brj.getParent() instanceof ViewGroup) {
            ((ViewGroup) brj.getParent()).removeView(brj);
        }
        return brj;
    }

    public boolean bqM() {
        return this.fcl;
    }

    public void bqN() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.fci != null) {
                        AlaLiveTabFragment.this.fci.js(false);
                        AlaLiveTabFragment.this.bqP();
                        AlaLiveTabFragment.this.fci.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.nt(R.drawable.new_pic_emotion_08);
        this.fci.js(false);
        this.mRefreshView.nv(0);
        this.mRefreshView.attachView(this.fci.brj(), false);
    }

    public void bqO() {
        this.fci.js(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.fci.brj());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqP() {
        if (this.fcm < 0) {
            this.fcm = this.fci.brj().getHeight();
        }
        showLoadingView(this.fci.brj(), false, (((this.fcm - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ho() {
        this.fci.brk();
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqQ() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqR() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.fcn = true;
        this.fci.loadData();
        bqP();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.fci != null) {
                this.fci.ju(true);
            }
        } else if (this.fci != null) {
            this.fci.ju(false);
        }
        if (this.fci != null) {
            this.fci.bB(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bqP();
            this.fci.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aWq() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fci != null) {
            this.fci.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fcl = true;
        if (this.fci != null) {
            this.fci.destroy();
        }
        if (this.fcj != null) {
            this.fcj.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.fck);
        MessageManager.getInstance().unRegisterListener(this.fco);
        MessageManager.getInstance().unRegisterListener(this.fcp);
    }
}
