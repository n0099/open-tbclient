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
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aq;
/* loaded from: classes4.dex */
public class AlaLiveTabFragment extends BaseFragment implements aq {
    public static int gdG = 1;
    public static int gdH = 1;
    public static int gdI = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a gdJ;
    private AlaLiveUserNotifyController gdK;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener gdL;
    private boolean gdO;
    private boolean gdM = true;
    private int gdN = -1;
    private CustomMessageListener gdP = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.gdJ.lC(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.gdM || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.TK();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.gdJ.bMV());
                        AlaLiveTabFragment.this.gdJ.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.gdM = false;
                    }
                } else if (AlaLiveTabFragment.this.gdM || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.gdJ.bMV());
                    AlaLiveTabFragment.this.bMA();
                }
            }
        }
    };
    private CustomMessageListener gdQ = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.gdJ != null) {
                    AlaLiveTabFragment.this.gdJ.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.gdJ = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.gdO);
        if (this.gdK == null) {
            this.gdK = new AlaLiveUserNotifyController(getPageContext());
        }
        this.gdL = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.gdK.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.gdL);
        MessageManager.getInstance().registerListener(this.gdP);
        MessageManager.getInstance().registerListener(this.gdQ);
        this.gdJ.init();
        if (this.gdN > 0) {
            bMB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bMV = this.gdJ.bMV();
        if (bMV.getParent() instanceof ViewGroup) {
            ((ViewGroup) bMV.getParent()).removeView(bMV);
        }
        return bMV;
    }

    public boolean bMz() {
        return this.gdM;
    }

    public void bMA() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.gdJ != null) {
                        AlaLiveTabFragment.this.gdJ.lC(false);
                        AlaLiveTabFragment.this.bMB();
                        AlaLiveTabFragment.this.gdJ.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.rt(R.drawable.new_pic_emotion_08);
        this.gdJ.lC(false);
        this.mRefreshView.rv(0);
        this.mRefreshView.attachView(this.gdJ.bMV(), false);
    }

    public void TK() {
        this.gdJ.lC(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.gdJ.bMV());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMB() {
        if (this.gdN < 0) {
            this.gdN = this.gdJ.bMV().getHeight();
        }
        showLoadingView(this.gdJ.bMV(), false, (((this.gdN - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.aq
    public void Rd() {
        this.gdJ.bMW();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bMC() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bMD() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.gdO = true;
        this.gdJ.loadData();
        bMB();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.gdJ != null) {
                this.gdJ.lD(true);
            }
        } else if (this.gdJ != null) {
            this.gdJ.lD(false);
        }
        if (this.gdJ != null) {
            this.gdJ.bP(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bMB();
            this.gdJ.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bqd() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gdJ != null) {
            this.gdJ.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gdM = true;
        if (this.gdJ != null) {
            this.gdJ.destroy();
        }
        if (this.gdK != null) {
            this.gdK.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.gdL);
        MessageManager.getInstance().unRegisterListener(this.gdP);
        MessageManager.getInstance().unRegisterListener(this.gdQ);
    }
}
