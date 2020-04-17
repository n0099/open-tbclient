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
import com.baidu.tieba.frs.aj;
/* loaded from: classes3.dex */
public class AlaLiveTabFragment extends BaseFragment implements aj {
    public static int ePt = 1;
    public static int ePu = 1;
    private boolean ePA;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a ePv;
    private AlaLiveUserNotifyController ePw;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener ePx;
    private boolean ePy = true;
    private int ePz = -1;
    private CustomMessageListener ePB = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.ePv.iZ(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.ePy || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.blt();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.ePv.blN());
                        AlaLiveTabFragment.this.ePv.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.ePy = false;
                    }
                } else if (AlaLiveTabFragment.this.ePy || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.ePv.blN());
                    AlaLiveTabFragment.this.bls();
                }
            }
        }
    };
    private CustomMessageListener ePC = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.ePv != null) {
                    AlaLiveTabFragment.this.ePv.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.ePv = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.ePA);
        if (this.ePw == null) {
            this.ePw = new AlaLiveUserNotifyController(getPageContext());
        }
        this.ePx = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.ePw.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.ePx);
        MessageManager.getInstance().registerListener(this.ePB);
        MessageManager.getInstance().registerListener(this.ePC);
        this.ePv.init();
        if (this.ePz > 0) {
            blu();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup blN = this.ePv.blN();
        if (blN.getParent() instanceof ViewGroup) {
            ((ViewGroup) blN.getParent()).removeView(blN);
        }
        return blN;
    }

    public void bls() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.ePv != null) {
                        AlaLiveTabFragment.this.ePv.iZ(false);
                        AlaLiveTabFragment.this.blu();
                        AlaLiveTabFragment.this.ePv.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mR(R.drawable.new_pic_emotion_08);
        this.ePv.iZ(false);
        this.mRefreshView.mT(0);
        this.mRefreshView.attachView(this.ePv.blN(), false);
    }

    public void blt() {
        this.ePv.iZ(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.ePv.blN());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blu() {
        if (this.ePz < 0) {
            this.ePz = this.ePv.blN().getHeight();
        }
        showLoadingView(this.ePv.blN(), false, (((this.ePz - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.aj
    public void FH() {
        this.ePv.blO();
    }

    @Override // com.baidu.tieba.frs.aj
    public void blv() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void blw() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        this.ePA = true;
        this.ePv.loadData();
        blu();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.ePv != null) {
                this.ePv.jc(true);
            }
        } else if (this.ePv != null) {
            this.ePv.jc(false);
        }
        if (this.ePv != null) {
            this.ePv.jb(isPrimary());
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aQp() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ePv != null) {
            this.ePv.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ePy = true;
        if (this.ePv != null) {
            this.ePv.destroy();
        }
        if (this.ePw != null) {
            this.ePw.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.ePx);
        MessageManager.getInstance().unRegisterListener(this.ePB);
        MessageManager.getInstance().unRegisterListener(this.ePC);
    }
}
