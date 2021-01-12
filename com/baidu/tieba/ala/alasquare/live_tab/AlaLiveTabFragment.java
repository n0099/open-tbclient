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
/* loaded from: classes9.dex */
public class AlaLiveTabFragment extends BaseFragment implements am {
    public static int gxG = 1;
    public static int gxH = 1;
    public static int gxI = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a gxJ;
    private AlaLiveUserNotifyController gxK;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener gxL;
    private boolean gxO;
    private boolean gxM = true;
    private int gxN = -1;
    private CustomMessageListener gxP = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.gxJ.mA(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.gxM || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.Vq();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.gxJ.bRl());
                        AlaLiveTabFragment.this.gxJ.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.gxM = false;
                    }
                } else if (AlaLiveTabFragment.this.gxM || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.gxJ.bRl());
                    AlaLiveTabFragment.this.bQQ();
                }
            }
        }
    };
    private CustomMessageListener gxQ = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.gxJ != null) {
                    AlaLiveTabFragment.this.gxJ.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.gxJ = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.gxO);
        if (this.gxK == null) {
            this.gxK = new AlaLiveUserNotifyController(getPageContext());
        }
        this.gxL = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.gxK.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.gxL);
        MessageManager.getInstance().registerListener(this.gxP);
        MessageManager.getInstance().registerListener(this.gxQ);
        this.gxJ.init();
        if (this.gxN > 0) {
            bQR();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup bRl = this.gxJ.bRl();
        if (bRl.getParent() instanceof ViewGroup) {
            ((ViewGroup) bRl.getParent()).removeView(bRl);
        }
        return bRl;
    }

    public boolean bQP() {
        return this.gxM;
    }

    public void bQQ() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.gxJ != null) {
                        AlaLiveTabFragment.this.gxJ.mA(false);
                        AlaLiveTabFragment.this.bQR();
                        AlaLiveTabFragment.this.gxJ.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.ri(R.drawable.new_pic_emotion_08);
        this.gxJ.mA(false);
        this.mRefreshView.rk(0);
        this.mRefreshView.attachView(this.gxJ.bRl(), false);
    }

    public void Vq() {
        this.gxJ.mA(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.gxJ.bRl());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQR() {
        if (this.gxN < 0) {
            this.gxN = this.gxJ.bRl().getHeight();
        }
        showLoadingView(this.gxJ.bRl(), false, (((this.gxN - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.am
    public void SM() {
        this.gxJ.bRm();
    }

    @Override // com.baidu.tieba.frs.am
    public void bQS() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bQT() {
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
        this.gxO = true;
        this.gxJ.loadData();
        bQR();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.gxJ != null) {
                this.gxJ.mB(true);
            }
        } else if (this.gxJ != null) {
            this.gxJ.mB(false);
        }
        if (this.gxJ != null) {
            this.gxJ.bW(isPrimary());
        }
    }

    public void reload() {
        if (isAdded()) {
            bQR();
            this.gxJ.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void btV() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gxJ != null) {
            this.gxJ.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gxM = true;
        if (this.gxJ != null) {
            this.gxJ.destroy();
        }
        if (this.gxK != null) {
            this.gxK.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.gxL);
        MessageManager.getInstance().unRegisterListener(this.gxP);
        MessageManager.getInstance().unRegisterListener(this.gxQ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a083";
    }
}
