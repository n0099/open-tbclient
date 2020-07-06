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
/* loaded from: classes3.dex */
public class AlaLiveTabFragment extends BaseFragment implements ao {
    public static int fnB = 1;
    public static int fnC = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a fnD;
    private AlaLiveUserNotifyController fnE;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener fnF;
    private boolean fnI;
    private boolean fnG = true;
    private int fnH = -1;
    private CustomMessageListener fnJ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.fnD.jF(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.fnG || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.btO();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fnD.bui());
                        AlaLiveTabFragment.this.fnD.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.fnG = false;
                    }
                } else if (AlaLiveTabFragment.this.fnG || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fnD.bui());
                    AlaLiveTabFragment.this.btN();
                }
            }
        }
    };
    private CustomMessageListener fnK = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.fnD != null) {
                    AlaLiveTabFragment.this.fnD.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.fnD = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.fnI);
        if (this.fnE == null) {
            this.fnE = new AlaLiveUserNotifyController(getPageContext());
        }
        this.fnF = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.fnE.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.fnF);
        MessageManager.getInstance().registerListener(this.fnJ);
        MessageManager.getInstance().registerListener(this.fnK);
        this.fnD.init();
        if (this.fnH > 0) {
            btP();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bui = this.fnD.bui();
        if (bui.getParent() instanceof ViewGroup) {
            ((ViewGroup) bui.getParent()).removeView(bui);
        }
        return bui;
    }

    public boolean btM() {
        return this.fnG;
    }

    public void btN() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.fnD != null) {
                        AlaLiveTabFragment.this.fnD.jF(false);
                        AlaLiveTabFragment.this.btP();
                        AlaLiveTabFragment.this.fnD.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.nQ(R.drawable.new_pic_emotion_08);
        this.fnD.jF(false);
        this.mRefreshView.nS(0);
        this.mRefreshView.attachView(this.fnD.bui(), false);
    }

    public void btO() {
        this.fnD.jF(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.fnD.bui());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btP() {
        if (this.fnH < 0) {
            this.fnH = this.fnD.bui().getHeight();
        }
        showLoadingView(this.fnD.bui(), false, (((this.fnH - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.ao
    public void IB() {
        this.fnD.buj();
    }

    @Override // com.baidu.tieba.frs.ao
    public void btQ() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void btR() {
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
        this.fnI = true;
        this.fnD.loadData();
        btP();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.fnD != null) {
                this.fnD.jH(true);
            }
        } else if (this.fnD != null) {
            this.fnD.jH(false);
        }
        if (this.fnD != null) {
            this.fnD.bB(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            btP();
            this.fnD.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void aYj() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fnD != null) {
            this.fnD.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fnG = true;
        if (this.fnD != null) {
            this.fnD.destroy();
        }
        if (this.fnE != null) {
            this.fnE.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.fnF);
        MessageManager.getInstance().unRegisterListener(this.fnJ);
        MessageManager.getInstance().unRegisterListener(this.fnK);
    }
}
