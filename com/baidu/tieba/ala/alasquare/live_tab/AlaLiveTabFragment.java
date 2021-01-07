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
import com.baidu.tbadk.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.am;
/* loaded from: classes10.dex */
public class AlaLiveTabFragment extends BaseFragment implements am {
    public static int gCn = 1;
    public static int gCo = 1;
    public static int gCp = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a gCq;
    private AlaLiveUserNotifyController gCr;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener gCs;
    private boolean gCv;
    private boolean gCt = true;
    private int gCu = -1;
    private CustomMessageListener gCw = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.gCq.mE(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.gCt || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.Zj();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.gCq.bVd());
                        AlaLiveTabFragment.this.gCq.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.gCt = false;
                    }
                } else if (AlaLiveTabFragment.this.gCt || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.gCq.bVd());
                    AlaLiveTabFragment.this.bUI();
                }
            }
        }
    };
    private CustomMessageListener gCx = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.gCq != null) {
                    AlaLiveTabFragment.this.gCq.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.gCq = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.gCv);
        if (this.gCr == null) {
            this.gCr = new AlaLiveUserNotifyController(getPageContext());
        }
        this.gCs = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.gCr.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.gCs);
        MessageManager.getInstance().registerListener(this.gCw);
        MessageManager.getInstance().registerListener(this.gCx);
        this.gCq.init();
        if (this.gCu > 0) {
            bUJ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bVd = this.gCq.bVd();
        if (bVd.getParent() instanceof ViewGroup) {
            ((ViewGroup) bVd.getParent()).removeView(bVd);
        }
        return bVd;
    }

    public boolean bUH() {
        return this.gCt;
    }

    public void bUI() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.gCq != null) {
                        AlaLiveTabFragment.this.gCq.mE(false);
                        AlaLiveTabFragment.this.bUJ();
                        AlaLiveTabFragment.this.gCq.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.sO(R.drawable.new_pic_emotion_08);
        this.gCq.mE(false);
        this.mRefreshView.sQ(0);
        this.mRefreshView.attachView(this.gCq.bVd(), false);
    }

    public void Zj() {
        this.gCq.mE(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.gCq.bVd());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUJ() {
        if (this.gCu < 0) {
            this.gCu = this.gCq.bVd().getHeight();
        }
        showLoadingView(this.gCq.bVd(), false, (((this.gCu - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.am
    public void WF() {
        this.gCq.bVe();
    }

    @Override // com.baidu.tieba.frs.am
    public void bUK() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bUL() {
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(y yVar) {
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.gCv = true;
        this.gCq.loadData();
        bUJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.gCq != null) {
                this.gCq.mF(true);
            }
        } else if (this.gCq != null) {
            this.gCq.mF(false);
        }
        if (this.gCq != null) {
            this.gCq.ca(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bUJ();
            this.gCq.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void bxP() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gCq != null) {
            this.gCq.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gCt = true;
        if (this.gCq != null) {
            this.gCq.destroy();
        }
        if (this.gCr != null) {
            this.gCr.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.gCs);
        MessageManager.getInstance().unRegisterListener(this.gCw);
        MessageManager.getInstance().unRegisterListener(this.gCx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a083";
    }
}
