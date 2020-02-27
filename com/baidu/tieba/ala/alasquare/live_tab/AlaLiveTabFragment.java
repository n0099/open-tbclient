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
    public static int elp = 1;
    public static int elq = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a elr;
    private AlaLiveUserNotifyController els;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener elt;
    private boolean elw;
    private boolean elu = true;
    private int elv = -1;
    private CustomMessageListener elx = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.elr.hZ(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.elu || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.bcv();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.elr.bcP());
                        AlaLiveTabFragment.this.elr.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.elu = false;
                    }
                } else if (AlaLiveTabFragment.this.elu || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.elr.bcP());
                    AlaLiveTabFragment.this.bcu();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.elr = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.elw);
        if (this.els == null) {
            this.els = new AlaLiveUserNotifyController(getPageContext());
        }
        this.elt = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.els.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.elt);
        MessageManager.getInstance().registerListener(this.elx);
        this.elr.init();
        if (this.elv > 0) {
            bcw();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bcP = this.elr.bcP();
        if (bcP.getParent() instanceof ViewGroup) {
            ((ViewGroup) bcP.getParent()).removeView(bcP);
        }
        return bcP;
    }

    public void bcu() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.elr != null) {
                        AlaLiveTabFragment.this.elr.hZ(false);
                        AlaLiveTabFragment.this.bcw();
                        AlaLiveTabFragment.this.elr.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mE(R.drawable.new_pic_emotion_08);
        this.elr.hZ(false);
        this.mRefreshView.mG(0);
        this.mRefreshView.attachView(this.elr.bcP(), false);
    }

    public void bcv() {
        this.elr.hZ(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.elr.bcP());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcw() {
        if (this.elv < 0) {
            this.elv = this.elr.bcP().getHeight();
        }
        showLoadingView(this.elr.bcP(), false, (((this.elv - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.af
    public void AA() {
        this.elr.bcQ();
    }

    @Override // com.baidu.tieba.frs.af
    public void bcx() {
    }

    @Override // com.baidu.tieba.frs.af
    public void bcy() {
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
        this.elw = true;
        this.elr.loadData();
        bcw();
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
    public void aHL() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.elr != null) {
            this.elr.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.elu = true;
        if (this.elr != null) {
            this.elr.destroy();
        }
        if (this.els != null) {
            this.els.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.elt);
        MessageManager.getInstance().unRegisterListener(this.elx);
    }
}
