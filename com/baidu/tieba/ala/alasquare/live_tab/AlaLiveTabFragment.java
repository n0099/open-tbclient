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
    public static int fTD = 1;
    public static int fTE = 1;
    public static int fTF = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a fTG;
    private AlaLiveUserNotifyController fTH;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener fTI;
    private boolean fTL;
    private boolean fTJ = true;
    private int fTK = -1;
    private CustomMessageListener fTM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.fTG.lj(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.fTJ || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.SK();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fTG.bKt());
                        AlaLiveTabFragment.this.fTG.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.fTJ = false;
                    }
                } else if (AlaLiveTabFragment.this.fTJ || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fTG.bKt());
                    AlaLiveTabFragment.this.bJY();
                }
            }
        }
    };
    private CustomMessageListener fTN = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.fTG != null) {
                    AlaLiveTabFragment.this.fTG.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.fTG = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.fTL);
        if (this.fTH == null) {
            this.fTH = new AlaLiveUserNotifyController(getPageContext());
        }
        this.fTI = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.fTH.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.fTI);
        MessageManager.getInstance().registerListener(this.fTM);
        MessageManager.getInstance().registerListener(this.fTN);
        this.fTG.init();
        if (this.fTK > 0) {
            bJZ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bKt = this.fTG.bKt();
        if (bKt.getParent() instanceof ViewGroup) {
            ((ViewGroup) bKt.getParent()).removeView(bKt);
        }
        return bKt;
    }

    public boolean bJX() {
        return this.fTJ;
    }

    public void bJY() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.fTG != null) {
                        AlaLiveTabFragment.this.fTG.lj(false);
                        AlaLiveTabFragment.this.bJZ();
                        AlaLiveTabFragment.this.fTG.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.ri(R.drawable.new_pic_emotion_08);
        this.fTG.lj(false);
        this.mRefreshView.rk(0);
        this.mRefreshView.attachView(this.fTG.bKt(), false);
    }

    public void SK() {
        this.fTG.lj(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.fTG.bKt());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJZ() {
        if (this.fTK < 0) {
            this.fTK = this.fTG.bKt().getHeight();
        }
        showLoadingView(this.fTG.bKt(), false, (((this.fTK - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.aq
    public void Qi() {
        this.fTG.bKu();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bKa() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bKb() {
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
        this.fTL = true;
        this.fTG.loadData();
        bJZ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.fTG != null) {
                this.fTG.ll(true);
            }
        } else if (this.fTG != null) {
            this.fTG.ll(false);
        }
        if (this.fTG != null) {
            this.fTG.bO(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bJZ();
            this.fTG.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bok() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fTG != null) {
            this.fTG.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fTJ = true;
        if (this.fTG != null) {
            this.fTG.destroy();
        }
        if (this.fTH != null) {
            this.fTH.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.fTI);
        MessageManager.getInstance().unRegisterListener(this.fTM);
        MessageManager.getInstance().unRegisterListener(this.fTN);
    }
}
