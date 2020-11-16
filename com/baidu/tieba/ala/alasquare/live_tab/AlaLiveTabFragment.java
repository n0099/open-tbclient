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
import com.baidu.tieba.frs.aq;
/* loaded from: classes4.dex */
public class AlaLiveTabFragment extends BaseFragment implements aq {
    public static int gjd = 1;
    public static int gje = 1;
    public static int gjf = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a gjg;
    private AlaLiveUserNotifyController gjh;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener gji;
    private boolean gjl;
    private boolean gjj = true;
    private int gjk = -1;
    private CustomMessageListener gjm = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.gjg.lM(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.gjj || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.VB();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.gjg.bOO());
                        AlaLiveTabFragment.this.gjg.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.gjj = false;
                    }
                } else if (AlaLiveTabFragment.this.gjj || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.gjg.bOO());
                    AlaLiveTabFragment.this.bOt();
                }
            }
        }
    };
    private CustomMessageListener gjn = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.gjg != null) {
                    AlaLiveTabFragment.this.gjg.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.gjg = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.gjl);
        if (this.gjh == null) {
            this.gjh = new AlaLiveUserNotifyController(getPageContext());
        }
        this.gji = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.gjh.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.gji);
        MessageManager.getInstance().registerListener(this.gjm);
        MessageManager.getInstance().registerListener(this.gjn);
        this.gjg.init();
        if (this.gjk > 0) {
            bOu();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bOO = this.gjg.bOO();
        if (bOO.getParent() instanceof ViewGroup) {
            ((ViewGroup) bOO.getParent()).removeView(bOO);
        }
        return bOO;
    }

    public boolean bOs() {
        return this.gjj;
    }

    public void bOt() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.gjg != null) {
                        AlaLiveTabFragment.this.gjg.lM(false);
                        AlaLiveTabFragment.this.bOu();
                        AlaLiveTabFragment.this.gjg.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.sb(R.drawable.new_pic_emotion_08);
        this.gjg.lM(false);
        this.mRefreshView.sd(0);
        this.mRefreshView.attachView(this.gjg.bOO(), false);
    }

    public void VB() {
        this.gjg.lM(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.gjg.bOO());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOu() {
        if (this.gjk < 0) {
            this.gjk = this.gjg.bOO().getHeight();
        }
        showLoadingView(this.gjg.bOO(), false, (((this.gjk - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.aq
    public void Tc() {
        this.gjg.bOP();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bOv() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bOw() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.gjl = true;
        this.gjg.loadData();
        bOu();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.gjg != null) {
                this.gjg.lN(true);
            }
        } else if (this.gjg != null) {
            this.gjg.lN(false);
        }
        if (this.gjg != null) {
            this.gjg.bS(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bOu();
            this.gjg.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void brT() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gjg != null) {
            this.gjg.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gjj = true;
        if (this.gjg != null) {
            this.gjg.destroy();
        }
        if (this.gjh != null) {
            this.gjh.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.gji);
        MessageManager.getInstance().unRegisterListener(this.gjm);
        MessageManager.getInstance().unRegisterListener(this.gjn);
    }
}
