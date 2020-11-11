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
    public static int gjw = 1;
    public static int gjx = 1;
    public static int gjy = 1;
    private AlaLiveUserNotifyController gjA;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener gjB;
    private boolean gjE;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a gjz;
    private boolean gjC = true;
    private int gjD = -1;
    private CustomMessageListener gjF = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.gjz.lL(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.gjC || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.Wk();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.gjz.bPv());
                        AlaLiveTabFragment.this.gjz.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.gjC = false;
                    }
                } else if (AlaLiveTabFragment.this.gjC || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.gjz.bPv());
                    AlaLiveTabFragment.this.bPa();
                }
            }
        }
    };
    private CustomMessageListener gjG = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.gjz != null) {
                    AlaLiveTabFragment.this.gjz.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.gjz = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.gjE);
        if (this.gjA == null) {
            this.gjA = new AlaLiveUserNotifyController(getPageContext());
        }
        this.gjB = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.gjA.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.gjB);
        MessageManager.getInstance().registerListener(this.gjF);
        MessageManager.getInstance().registerListener(this.gjG);
        this.gjz.init();
        if (this.gjD > 0) {
            bPb();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bPv = this.gjz.bPv();
        if (bPv.getParent() instanceof ViewGroup) {
            ((ViewGroup) bPv.getParent()).removeView(bPv);
        }
        return bPv;
    }

    public boolean bOZ() {
        return this.gjC;
    }

    public void bPa() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.gjz != null) {
                        AlaLiveTabFragment.this.gjz.lL(false);
                        AlaLiveTabFragment.this.bPb();
                        AlaLiveTabFragment.this.gjz.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.rD(R.drawable.new_pic_emotion_08);
        this.gjz.lL(false);
        this.mRefreshView.rF(0);
        this.mRefreshView.attachView(this.gjz.bPv(), false);
    }

    public void Wk() {
        this.gjz.lL(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.gjz.bPv());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPb() {
        if (this.gjD < 0) {
            this.gjD = this.gjz.bPv().getHeight();
        }
        showLoadingView(this.gjz.bPv(), false, (((this.gjD - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.aq
    public void TL() {
        this.gjz.bPw();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bPc() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bPd() {
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
        this.gjE = true;
        this.gjz.loadData();
        bPb();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.gjz != null) {
                this.gjz.lM(true);
            }
        } else if (this.gjz != null) {
            this.gjz.lM(false);
        }
        if (this.gjz != null) {
            this.gjz.bQ(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bPb();
            this.gjz.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bsD() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gjz != null) {
            this.gjz.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gjC = true;
        if (this.gjz != null) {
            this.gjz.destroy();
        }
        if (this.gjA != null) {
            this.gjA.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.gjB);
        MessageManager.getInstance().unRegisterListener(this.gjF);
        MessageManager.getInstance().unRegisterListener(this.gjG);
    }
}
