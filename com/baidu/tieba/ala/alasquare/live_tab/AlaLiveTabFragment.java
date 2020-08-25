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
    public static int fEe = 1;
    public static int fEf = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a fEg;
    private AlaLiveUserNotifyController fEh;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener fEi;
    private boolean fEl;
    private boolean fEj = true;
    private int fEk = -1;
    private CustomMessageListener fEm = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.fEg.kH(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.fEj || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.bFW();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fEg.bGq());
                        AlaLiveTabFragment.this.fEg.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.fEj = false;
                    }
                } else if (AlaLiveTabFragment.this.fEj || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fEg.bGq());
                    AlaLiveTabFragment.this.bFV();
                }
            }
        }
    };
    private CustomMessageListener fEn = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.fEg != null) {
                    AlaLiveTabFragment.this.fEg.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.fEg = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.fEl);
        if (this.fEh == null) {
            this.fEh = new AlaLiveUserNotifyController(getPageContext());
        }
        this.fEi = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.fEh.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.fEi);
        MessageManager.getInstance().registerListener(this.fEm);
        MessageManager.getInstance().registerListener(this.fEn);
        this.fEg.init();
        if (this.fEk > 0) {
            bFX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bGq = this.fEg.bGq();
        if (bGq.getParent() instanceof ViewGroup) {
            ((ViewGroup) bGq.getParent()).removeView(bGq);
        }
        return bGq;
    }

    public boolean bFU() {
        return this.fEj;
    }

    public void bFV() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.fEg != null) {
                        AlaLiveTabFragment.this.fEg.kH(false);
                        AlaLiveTabFragment.this.bFX();
                        AlaLiveTabFragment.this.fEg.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.qt(R.drawable.new_pic_emotion_08);
        this.fEg.kH(false);
        this.mRefreshView.qv(0);
        this.mRefreshView.attachView(this.fEg.bGq(), false);
    }

    public void bFW() {
        this.fEg.kH(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.fEg.bGq());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFX() {
        if (this.fEk < 0) {
            this.fEk = this.fEg.bGq().getHeight();
        }
        showLoadingView(this.fEg.bGq(), false, (((this.fEk - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.aq
    public void OA() {
        this.fEg.bGr();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bFY() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bFZ() {
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
        this.fEl = true;
        this.fEg.loadData();
        bFX();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.fEg != null) {
                this.fEg.kJ(true);
            }
        } else if (this.fEg != null) {
            this.fEg.kJ(false);
        }
        if (this.fEg != null) {
            this.fEg.bJ(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bFX();
            this.fEg.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bkF() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fEg != null) {
            this.fEg.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fEj = true;
        if (this.fEg != null) {
            this.fEg.destroy();
        }
        if (this.fEh != null) {
            this.fEh.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.fEi);
        MessageManager.getInstance().unRegisterListener(this.fEm);
        MessageManager.getInstance().unRegisterListener(this.fEn);
    }
}
