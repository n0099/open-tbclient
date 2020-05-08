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
    public static int ePy = 1;
    public static int ePz = 1;
    private com.baidu.tieba.ala.alasquare.live_tab.view.a ePA;
    private AlaLiveUserNotifyController ePB;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener ePC;
    private boolean ePF;
    private boolean ePD = true;
    private int ePE = -1;
    private CustomMessageListener ePG = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.alasquare.live_tab.b.b)) {
                AlaLiveTabFragment.this.ePA.iZ(true);
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = (com.baidu.tieba.ala.alasquare.live_tab.b.b) customResponsedMessage.getData();
                if (bVar.isSuccess) {
                    if (AlaLiveTabFragment.this.ePD || !bVar.isLoadMore) {
                        AlaLiveTabFragment.this.blr();
                        AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.ePA.blL());
                        AlaLiveTabFragment.this.ePA.a(bVar.superEntranceInfo);
                        AlaLiveTabFragment.this.ePD = false;
                    }
                } else if (AlaLiveTabFragment.this.ePD || !bVar.isLoadMore) {
                    AlaLiveTabFragment.this.hideLoadingView(AlaLiveTabFragment.this.ePA.blL());
                    AlaLiveTabFragment.this.blq();
                }
            }
        }
    };
    private CustomMessageListener ePH = new CustomMessageListener(2921446) { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (AlaLiveTabFragment.this.ePA != null) {
                    AlaLiveTabFragment.this.ePA.setCurrentTab(intValue);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.ePA = new com.baidu.tieba.ala.alasquare.live_tab.view.a(getPageContext(), getChildFragmentManager(), this.ePF);
        if (this.ePB == null) {
            this.ePB = new AlaLiveUserNotifyController(getPageContext());
        }
        this.ePC = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.3
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (AlaLiveTabFragment.this.isPrimary()) {
                    AlaLiveTabFragment.this.ePB.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.ePC);
        MessageManager.getInstance().registerListener(this.ePG);
        MessageManager.getInstance().registerListener(this.ePH);
        this.ePA.init();
        if (this.ePE > 0) {
            bls();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup blL = this.ePA.blL();
        if (blL.getParent() instanceof ViewGroup) {
            ((ViewGroup) blL.getParent()).removeView(blL);
        }
        return blL;
    }

    public void blq() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && AlaLiveTabFragment.this.ePA != null) {
                        AlaLiveTabFragment.this.ePA.iZ(false);
                        AlaLiveTabFragment.this.bls();
                        AlaLiveTabFragment.this.ePA.loadData();
                        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mR(R.drawable.new_pic_emotion_08);
        this.ePA.iZ(false);
        this.mRefreshView.mT(0);
        this.mRefreshView.attachView(this.ePA.blL(), false);
    }

    public void blr() {
        this.ePA.iZ(true);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.ePA.blL());
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bls() {
        if (this.ePE < 0) {
            this.ePE = this.ePA.blL().getHeight();
        }
        showLoadingView(this.ePA.blL(), false, (((this.ePE - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
    }

    @Override // com.baidu.tieba.frs.aj
    public void FG() {
        this.ePA.blM();
    }

    @Override // com.baidu.tieba.frs.aj
    public void blt() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void blu() {
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
        this.ePF = true;
        this.ePA.loadData();
        bls();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            if (this.ePA != null) {
                this.ePA.jc(true);
            }
        } else if (this.ePA != null) {
            this.ePA.jc(false);
        }
        if (this.ePA != null) {
            this.ePA.jb(isPrimary());
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aQm() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ePA != null) {
            this.ePA.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ePD = true;
        if (this.ePA != null) {
            this.ePA.destroy();
        }
        if (this.ePB != null) {
            this.ePB.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.ePC);
        MessageManager.getInstance().unRegisterListener(this.ePG);
        MessageManager.getInstance().unRegisterListener(this.ePH);
    }
}
