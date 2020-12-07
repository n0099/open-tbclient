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
    public static int grm = 1;
    public static int grn = 1;
    public static int gro = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a grp;
    private AlaLiveUserNotifyController grq;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener grr;
    private boolean gru;
    private boolean grs = true;
    private int grt = -1;
    private CustomMessageListener grv = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.grp.mh(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.grs || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.Yb();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.grp.bSz());
                        AlaLiveTabFragment.this.grp.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.grs = false;
                    }
                } else if (AlaLiveTabFragment.this.grs || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.grp.bSz());
                    AlaLiveTabFragment.this.bSe();
                }
            }
        }
    };
    private CustomMessageListener grw = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.grp != null) {
                    AlaLiveTabFragment.this.grp.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.grp = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.gru);
        if (this.grq == null) {
            this.grq = new AlaLiveUserNotifyController(getPageContext());
        }
        this.grr = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.grq.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.grr);
        MessageManager.getInstance().registerListener(this.grv);
        MessageManager.getInstance().registerListener(this.grw);
        this.grp.init();
        if (this.grt > 0) {
            bSf();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bSz = this.grp.bSz();
        if (bSz.getParent() instanceof ViewGroup) {
            ((ViewGroup) bSz.getParent()).removeView(bSz);
        }
        return bSz;
    }

    public boolean bSd() {
        return this.grs;
    }

    public void bSe() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.grp != null) {
                        AlaLiveTabFragment.this.grp.mh(false);
                        AlaLiveTabFragment.this.bSf();
                        AlaLiveTabFragment.this.grp.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.sC(R.drawable.new_pic_emotion_08);
        this.grp.mh(false);
        this.mRefreshView.sE(0);
        this.mRefreshView.attachView(this.grp.bSz(), false);
    }

    public void Yb() {
        this.grp.mh(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.grp.bSz());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSf() {
        if (this.grt < 0) {
            this.grt = this.grp.bSz().getHeight();
        }
        showLoadingView(this.grp.bSz(), false, (((this.grt - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.ap
    public void VC() {
        this.grp.bSA();
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSg() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSh() {
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
        this.gru = true;
        this.grp.loadData();
        bSf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.grp != null) {
                this.grp.mi(true);
            }
        } else if (this.grp != null) {
            this.grp.mi(false);
        }
        if (this.grp != null) {
            this.grp.cb(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bSf();
            this.grp.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void bvt() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.grp != null) {
            this.grp.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.grs = true;
        if (this.grp != null) {
            this.grp.destroy();
        }
        if (this.grq != null) {
            this.grq.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.grr);
        MessageManager.getInstance().unRegisterListener(this.grv);
        MessageManager.getInstance().unRegisterListener(this.grw);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a083";
    }
}
