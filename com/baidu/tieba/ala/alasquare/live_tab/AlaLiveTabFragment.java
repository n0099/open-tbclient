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
import com.baidu.tieba.frs.ao;
/* loaded from: classes4.dex */
public class AlaLiveTabFragment extends BaseFragment implements ao {
    public static int fsK = 1;
    public static int fsL = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a fsM;
    private AlaLiveUserNotifyController fsN;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener fsO;
    private boolean fsR;
    private boolean fsP = true;
    private int fsQ = -1;
    private CustomMessageListener fsS = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.fsM.kj(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.fsP || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.bwX();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fsM.bxr());
                        AlaLiveTabFragment.this.fsM.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.fsP = false;
                    }
                } else if (AlaLiveTabFragment.this.fsP || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fsM.bxr());
                    AlaLiveTabFragment.this.bwW();
                }
            }
        }
    };
    private CustomMessageListener fsT = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.fsM != null) {
                    AlaLiveTabFragment.this.fsM.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.fsM = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.fsR);
        if (this.fsN == null) {
            this.fsN = new AlaLiveUserNotifyController(getPageContext());
        }
        this.fsO = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.fsN.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.fsO);
        MessageManager.getInstance().registerListener(this.fsS);
        MessageManager.getInstance().registerListener(this.fsT);
        this.fsM.init();
        if (this.fsQ > 0) {
            bwY();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bxr = this.fsM.bxr();
        if (bxr.getParent() instanceof ViewGroup) {
            ((ViewGroup) bxr.getParent()).removeView(bxr);
        }
        return bxr;
    }

    public boolean bwV() {
        return this.fsP;
    }

    public void bwW() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.fsM != null) {
                        AlaLiveTabFragment.this.fsM.kj(false);
                        AlaLiveTabFragment.this.bwY();
                        AlaLiveTabFragment.this.fsM.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.oi(R.drawable.new_pic_emotion_08);
        this.fsM.kj(false);
        this.mRefreshView.ok(0);
        this.mRefreshView.attachView(this.fsM.bxr(), false);
    }

    public void bwX() {
        this.fsM.kj(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.fsM.bxr());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwY() {
        if (this.fsQ < 0) {
            this.fsQ = this.fsM.bxr().getHeight();
        }
        showLoadingView(this.fsM.bxr(), false, (((this.fsQ - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.ao
    public void IH() {
        this.fsM.bxs();
    }

    @Override // com.baidu.tieba.frs.ao
    public void bwZ() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void bxa() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.ao
    public void showFloatingView() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.fsR = true;
        this.fsM.loadData();
        bwY();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.fsM != null) {
                this.fsM.kl(true);
            }
        } else if (this.fsM != null) {
            this.fsM.kl(false);
        }
        if (this.fsM != null) {
            this.fsM.bE(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bwY();
            this.fsM.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bci() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fsM != null) {
            this.fsM.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fsP = true;
        if (this.fsM != null) {
            this.fsM.destroy();
        }
        if (this.fsN != null) {
            this.fsN.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.fsO);
        MessageManager.getInstance().unRegisterListener(this.fsS);
        MessageManager.getInstance().unRegisterListener(this.fsT);
    }
}
