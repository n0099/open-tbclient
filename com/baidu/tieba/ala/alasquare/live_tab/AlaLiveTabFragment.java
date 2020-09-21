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
    public static int fHu = 1;
    public static int fHv = 1;
    private boolean fHB;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a fHw;
    private AlaLiveUserNotifyController fHx;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener fHy;
    private boolean fHz = true;
    private int fHA = -1;
    private CustomMessageListener fHC = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.fHw.kL(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.fHz || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.bHn();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fHw.bHH());
                        AlaLiveTabFragment.this.fHw.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.fHz = false;
                    }
                } else if (AlaLiveTabFragment.this.fHz || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fHw.bHH());
                    AlaLiveTabFragment.this.bHm();
                }
            }
        }
    };
    private CustomMessageListener fHD = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.fHw != null) {
                    AlaLiveTabFragment.this.fHw.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.fHw = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.fHB);
        if (this.fHx == null) {
            this.fHx = new AlaLiveUserNotifyController(getPageContext());
        }
        this.fHy = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.fHx.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.fHy);
        MessageManager.getInstance().registerListener(this.fHC);
        MessageManager.getInstance().registerListener(this.fHD);
        this.fHw.init();
        if (this.fHA > 0) {
            bHo();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bHH = this.fHw.bHH();
        if (bHH.getParent() instanceof ViewGroup) {
            ((ViewGroup) bHH.getParent()).removeView(bHH);
        }
        return bHH;
    }

    public boolean bHl() {
        return this.fHz;
    }

    public void bHm() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.fHw != null) {
                        AlaLiveTabFragment.this.fHw.kL(false);
                        AlaLiveTabFragment.this.bHo();
                        AlaLiveTabFragment.this.fHw.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.qK(R.drawable.new_pic_emotion_08);
        this.fHw.kL(false);
        this.mRefreshView.qM(0);
        this.mRefreshView.attachView(this.fHw.bHH(), false);
    }

    public void bHn() {
        this.fHw.kL(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.fHw.bHH());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHo() {
        if (this.fHA < 0) {
            this.fHA = this.fHw.bHH().getHeight();
        }
        showLoadingView(this.fHw.bHH(), false, (((this.fHA - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.aq
    public void Pd() {
        this.fHw.bHI();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bHp() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bHq() {
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
        this.fHB = true;
        this.fHw.loadData();
        bHo();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.fHw != null) {
                this.fHw.kN(true);
            }
        } else if (this.fHw != null) {
            this.fHw.kN(false);
        }
        if (this.fHw != null) {
            this.fHw.bL(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bHo();
            this.fHw.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void blA() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fHw != null) {
            this.fHw.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fHz = true;
        if (this.fHw != null) {
            this.fHw.destroy();
        }
        if (this.fHx != null) {
            this.fHx.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.fHy);
        MessageManager.getInstance().unRegisterListener(this.fHC);
        MessageManager.getInstance().unRegisterListener(this.fHD);
    }
}
