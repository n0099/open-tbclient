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
    public static int elD = 1;
    public static int elE = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a elF;
    private AlaLiveUserNotifyController elG;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener elH;
    private boolean elK;
    private boolean elI = true;
    private int elJ = -1;
    private CustomMessageListener elL = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.elF.hZ(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.elI || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.bcy();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.elF.bcS());
                        AlaLiveTabFragment.this.elF.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.elI = false;
                    }
                } else if (AlaLiveTabFragment.this.elI || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.elF.bcS());
                    AlaLiveTabFragment.this.bcx();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.elF = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.elK);
        if (this.elG == null) {
            this.elG = new AlaLiveUserNotifyController(getPageContext());
        }
        this.elH = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.elG.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.elH);
        MessageManager.getInstance().registerListener(this.elL);
        this.elF.init();
        if (this.elJ > 0) {
            bcz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bcS = this.elF.bcS();
        if (bcS.getParent() instanceof ViewGroup) {
            ((ViewGroup) bcS.getParent()).removeView(bcS);
        }
        return bcS;
    }

    public void bcx() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.elF != null) {
                        AlaLiveTabFragment.this.elF.hZ(false);
                        AlaLiveTabFragment.this.bcz();
                        AlaLiveTabFragment.this.elF.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mE(R.drawable.new_pic_emotion_08);
        this.elF.hZ(false);
        this.mRefreshView.mG(0);
        this.mRefreshView.attachView(this.elF.bcS(), false);
    }

    public void bcy() {
        this.elF.hZ(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.elF.bcS());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcz() {
        if (this.elJ < 0) {
            this.elJ = this.elF.bcS().getHeight();
        }
        showLoadingView(this.elF.bcS(), false, (((this.elJ - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.af
    public void AC() {
        this.elF.bcT();
    }

    @Override // com.baidu.tieba.frs.af
    public void bcA() {
    }

    @Override // com.baidu.tieba.frs.af
    public void bcB() {
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
        this.elK = true;
        this.elF.loadData();
        bcz();
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
    public void aHO() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.elF != null) {
            this.elF.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.elI = true;
        if (this.elF != null) {
            this.elF.destroy();
        }
        if (this.elG != null) {
            this.elG.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.elH);
        MessageManager.getInstance().unRegisterListener(this.elL);
    }
}
