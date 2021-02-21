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
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.am;
/* loaded from: classes10.dex */
public class AlaLiveTabFragment extends BaseFragment implements am {
    public static int gAE = 1;
    public static int gAF = 1;
    public static int gAG = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a gAH;
    private AlaLiveUserNotifyController gAI;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener gAJ;
    private boolean gAM;
    private boolean gAK = true;
    private int gAL = -1;
    private CustomMessageListener gAN = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.gAH.mE(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.gAK || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.WZ();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.gAH.bRV());
                        AlaLiveTabFragment.this.gAH.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.gAK = false;
                    }
                } else if (AlaLiveTabFragment.this.gAK || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.gAH.bRV());
                    AlaLiveTabFragment.this.bRB();
                }
            }
        }
    };
    private CustomMessageListener gAO = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.gAH != null) {
                    AlaLiveTabFragment.this.gAH.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.gAH = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.gAM);
        if (this.gAI == null) {
            this.gAI = new AlaLiveUserNotifyController(getPageContext());
        }
        this.gAJ = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.gAI.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.gAJ);
        MessageManager.getInstance().registerListener(this.gAN);
        MessageManager.getInstance().registerListener(this.gAO);
        this.gAH.init();
        if (this.gAL > 0) {
            bRC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bRV = this.gAH.bRV();
        if (bRV.getParent() instanceof ViewGroup) {
            ((ViewGroup) bRV.getParent()).removeView(bRV);
        }
        return bRV;
    }

    public boolean bRA() {
        return this.gAK;
    }

    public void bRB() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.gAH != null) {
                        AlaLiveTabFragment.this.gAH.mE(false);
                        AlaLiveTabFragment.this.bRC();
                        AlaLiveTabFragment.this.gAH.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.rn(R.drawable.new_pic_emotion_08);
        this.gAH.mE(false);
        this.mRefreshView.rp(0);
        this.mRefreshView.attachView(this.gAH.bRV(), false);
    }

    public void WZ() {
        this.gAH.mE(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.gAH.bRV());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRC() {
        if (this.gAL < 0) {
            this.gAL = this.gAH.bRV().getHeight();
        }
        showLoadingView(this.gAH.bRV(), false, (((this.gAL - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.am
    public void Ut() {
        this.gAH.bRW();
    }

    @Override // com.baidu.tieba.frs.am
    public void bRD() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bRE() {
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.gAM = true;
        this.gAH.loadData();
        bRC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.gAH != null) {
                this.gAH.mF(true);
            }
        } else if (this.gAH != null) {
            this.gAH.mF(false);
        }
        if (this.gAH != null) {
            this.gAH.cb(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bRC();
            this.gAH.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void bup() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gAH != null) {
            this.gAH.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gAK = true;
        if (this.gAH != null) {
            this.gAH.destroy();
        }
        if (this.gAI != null) {
            this.gAI.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.gAJ);
        MessageManager.getInstance().unRegisterListener(this.gAN);
        MessageManager.getInstance().unRegisterListener(this.gAO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a083";
    }
}
