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
    public static int gAq = 1;
    public static int gAr = 1;
    public static int gAs = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a gAt;
    private AlaLiveUserNotifyController gAu;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener gAv;
    private boolean gAy;
    private boolean gAw = true;
    private int gAx = -1;
    private CustomMessageListener gAz = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.gAt.mE(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.gAw || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.WZ();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.gAt.bRO());
                        AlaLiveTabFragment.this.gAt.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.gAw = false;
                    }
                } else if (AlaLiveTabFragment.this.gAw || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.gAt.bRO());
                    AlaLiveTabFragment.this.bRu();
                }
            }
        }
    };
    private CustomMessageListener gAA = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.gAt != null) {
                    AlaLiveTabFragment.this.gAt.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.gAt = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.gAy);
        if (this.gAu == null) {
            this.gAu = new AlaLiveUserNotifyController(getPageContext());
        }
        this.gAv = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.gAu.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.gAv);
        MessageManager.getInstance().registerListener(this.gAz);
        MessageManager.getInstance().registerListener(this.gAA);
        this.gAt.init();
        if (this.gAx > 0) {
            bRv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bRO = this.gAt.bRO();
        if (bRO.getParent() instanceof ViewGroup) {
            ((ViewGroup) bRO.getParent()).removeView(bRO);
        }
        return bRO;
    }

    public boolean bRt() {
        return this.gAw;
    }

    public void bRu() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.gAt != null) {
                        AlaLiveTabFragment.this.gAt.mE(false);
                        AlaLiveTabFragment.this.bRv();
                        AlaLiveTabFragment.this.gAt.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.rn(R.drawable.new_pic_emotion_08);
        this.gAt.mE(false);
        this.mRefreshView.rp(0);
        this.mRefreshView.attachView(this.gAt.bRO(), false);
    }

    public void WZ() {
        this.gAt.mE(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.gAt.bRO());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRv() {
        if (this.gAx < 0) {
            this.gAx = this.gAt.bRO().getHeight();
        }
        showLoadingView(this.gAt.bRO(), false, (((this.gAx - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.am
    public void Ut() {
        this.gAt.bRP();
    }

    @Override // com.baidu.tieba.frs.am
    public void bRw() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bRx() {
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
        this.gAy = true;
        this.gAt.loadData();
        bRv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.gAt != null) {
                this.gAt.mF(true);
            }
        } else if (this.gAt != null) {
            this.gAt.mF(false);
        }
        if (this.gAt != null) {
            this.gAt.cb(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bRv();
            this.gAt.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void bup() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gAt != null) {
            this.gAt.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gAw = true;
        if (this.gAt != null) {
            this.gAt.destroy();
        }
        if (this.gAu != null) {
            this.gAu.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.gAv);
        MessageManager.getInstance().unRegisterListener(this.gAz);
        MessageManager.getInstance().unRegisterListener(this.gAA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a083";
    }
}
