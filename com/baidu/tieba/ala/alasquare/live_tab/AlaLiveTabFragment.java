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
import com.baidu.tieba.frs.ag;
/* loaded from: classes3.dex */
public class AlaLiveTabFragment extends BaseFragment implements ag {
    public static int elT = 1;
    public static int elU = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a elV;
    private AlaLiveUserNotifyController elW;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener elX;
    private boolean ema;
    private boolean elY = true;
    private int elZ = -1;
    private CustomMessageListener emb = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.elV.ia(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.elY || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.bcC();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.elV.bcW());
                        AlaLiveTabFragment.this.elV.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.elY = false;
                    }
                } else if (AlaLiveTabFragment.this.elY || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.elV.bcW());
                    AlaLiveTabFragment.this.bcB();
                }
            }
        }
    };
    private CustomMessageListener emc = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.elV != null) {
                    AlaLiveTabFragment.this.elV.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.elV = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.ema);
        if (this.elW == null) {
            this.elW = new AlaLiveUserNotifyController(getPageContext());
        }
        this.elX = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.elW.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.elX);
        MessageManager.getInstance().registerListener(this.emb);
        MessageManager.getInstance().registerListener(this.emc);
        this.elV.init();
        if (this.elZ > 0) {
            bcD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bcW = this.elV.bcW();
        if (bcW.getParent() instanceof ViewGroup) {
            ((ViewGroup) bcW.getParent()).removeView(bcW);
        }
        return bcW;
    }

    public void bcB() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.elV != null) {
                        AlaLiveTabFragment.this.elV.ia(false);
                        AlaLiveTabFragment.this.bcD();
                        AlaLiveTabFragment.this.elV.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mG(R.drawable.new_pic_emotion_08);
        this.elV.ia(false);
        this.mRefreshView.mI(0);
        this.mRefreshView.attachView(this.elV.bcW(), false);
    }

    public void bcC() {
        this.elV.ia(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.elV.bcW());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcD() {
        if (this.elZ < 0) {
            this.elZ = this.elV.bcW().getHeight();
        }
        showLoadingView(this.elV.bcW(), false, (((this.elZ - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.ag
    public void AJ() {
        this.elV.bcX();
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcE() {
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcF() {
    }

    @Override // com.baidu.tieba.frs.ag
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
    }

    @Override // com.baidu.tieba.frs.ag
    public void showFloatingView() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.ema = true;
        this.elV.loadData();
        bcD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.elV != null) {
                this.elV.ic(true);
            }
        } else if (this.elV != null) {
            this.elV.ic(false);
        }
        if (this.elV != null) {
            this.elV.onPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aHS() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.elV != null) {
            this.elV.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.elY = true;
        if (this.elV != null) {
            this.elV.destroy();
        }
        if (this.elW != null) {
            this.elW.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.elX);
        MessageManager.getInstance().unRegisterListener(this.emb);
        MessageManager.getInstance().unRegisterListener(this.emc);
    }
}
