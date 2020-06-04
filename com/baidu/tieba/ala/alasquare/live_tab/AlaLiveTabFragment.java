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
import com.baidu.tieba.frs.aj;
/* loaded from: classes3.dex */
public class AlaLiveTabFragment extends BaseFragment implements aj {
    public static int fcr = 1;
    public static int fcs = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a fct;
    private AlaLiveUserNotifyController fcu;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener fcv;
    private boolean fcy;
    private boolean fcw = true;
    private int fcx = -1;
    private CustomMessageListener fcz = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.fct.js(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.fcw || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.bqQ();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fct.brl());
                        AlaLiveTabFragment.this.fct.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.fcw = false;
                    }
                } else if (AlaLiveTabFragment.this.fcw || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.fct.brl());
                    AlaLiveTabFragment.this.bqP();
                }
            }
        }
    };
    private CustomMessageListener fcA = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.fct != null) {
                    AlaLiveTabFragment.this.fct.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.fct = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.fcy);
        if (this.fcu == null) {
            this.fcu = new AlaLiveUserNotifyController(getPageContext());
        }
        this.fcv = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.fcu.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.fcv);
        MessageManager.getInstance().registerListener(this.fcz);
        MessageManager.getInstance().registerListener(this.fcA);
        this.fct.init();
        if (this.fcx > 0) {
            bqR();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup brl = this.fct.brl();
        if (brl.getParent() instanceof ViewGroup) {
            ((ViewGroup) brl.getParent()).removeView(brl);
        }
        return brl;
    }

    public boolean bqO() {
        return this.fcw;
    }

    public void bqP() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.fct != null) {
                        AlaLiveTabFragment.this.fct.js(false);
                        AlaLiveTabFragment.this.bqR();
                        AlaLiveTabFragment.this.fct.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.nv(R.drawable.new_pic_emotion_08);
        this.fct.js(false);
        this.mRefreshView.nx(0);
        this.mRefreshView.attachView(this.fct.brl(), false);
    }

    public void bqQ() {
        this.fct.js(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.fct.brl());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqR() {
        if (this.fcx < 0) {
            this.fcx = this.fct.brl().getHeight();
        }
        showLoadingView(this.fct.brl(), false, (((this.fcx - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ho() {
        this.fct.brm();
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqS() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqT() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.fcy = true;
        this.fct.loadData();
        bqR();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.fct != null) {
                this.fct.ju(true);
            }
        } else if (this.fct != null) {
            this.fct.ju(false);
        }
        if (this.fct != null) {
            this.fct.bB(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bqR();
            this.fct.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aWr() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fct != null) {
            this.fct.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fcw = true;
        if (this.fct != null) {
            this.fct.destroy();
        }
        if (this.fcu != null) {
            this.fcu.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.fcv);
        MessageManager.getInstance().unRegisterListener(this.fcz);
        MessageManager.getInstance().unRegisterListener(this.fcA);
    }
}
