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
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aq;
/* loaded from: classes4.dex */
public class AlaLiveTabFragment extends BaseFragment implements aq {
    public static int fEi = 1;
    public static int fEj = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a fEk;
    private AlaLiveUserNotifyController fEl;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener fEm;
    private boolean fEp;
    private boolean fEn = true;
    private int fEo = -1;
    private CustomMessageListener fEq = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.fEk.kJ(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.fEn || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.bFX();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fEk.bGr());
                        AlaLiveTabFragment.this.fEk.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.fEn = false;
                    }
                } else if (AlaLiveTabFragment.this.fEn || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fEk.bGr());
                    AlaLiveTabFragment.this.bFW();
                }
            }
        }
    };
    private CustomMessageListener fEr = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.fEk != null) {
                    AlaLiveTabFragment.this.fEk.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.fEk = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.fEp);
        if (this.fEl == null) {
            this.fEl = new AlaLiveUserNotifyController(getPageContext());
        }
        this.fEm = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.fEl.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.fEm);
        MessageManager.getInstance().registerListener(this.fEq);
        MessageManager.getInstance().registerListener(this.fEr);
        this.fEk.init();
        if (this.fEo > 0) {
            bFY();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bGr = this.fEk.bGr();
        if (bGr.getParent() instanceof ViewGroup) {
            ((ViewGroup) bGr.getParent()).removeView(bGr);
        }
        return bGr;
    }

    public boolean bFV() {
        return this.fEn;
    }

    public void bFW() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.fEk != null) {
                        AlaLiveTabFragment.this.fEk.kJ(false);
                        AlaLiveTabFragment.this.bFY();
                        AlaLiveTabFragment.this.fEk.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.qt(R.drawable.new_pic_emotion_08);
        this.fEk.kJ(false);
        this.mRefreshView.qv(0);
        this.mRefreshView.attachView(this.fEk.bGr(), false);
    }

    public void bFX() {
        this.fEk.kJ(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.fEk.bGr());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFY() {
        if (this.fEo < 0) {
            this.fEo = this.fEk.bGr().getHeight();
        }
        showLoadingView(this.fEk.bGr(), false, (((this.fEo - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.aq
    public void OA() {
        this.fEk.bGs();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bFZ() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bGa() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.fEp = true;
        this.fEk.loadData();
        bFY();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.fEk != null) {
                this.fEk.kL(true);
            }
        } else if (this.fEk != null) {
            this.fEk.kL(false);
        }
        if (this.fEk != null) {
            this.fEk.bJ(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bFY();
            this.fEk.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bkF() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fEk != null) {
            this.fEk.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fEn = true;
        if (this.fEk != null) {
            this.fEk.destroy();
        }
        if (this.fEl != null) {
            this.fEl.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.fEm);
        MessageManager.getInstance().unRegisterListener(this.fEq);
        MessageManager.getInstance().unRegisterListener(this.fEr);
    }
}
