package com.baidu.tieba.homepage.personalize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.t;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes16.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ao {
    private VoiceManager hFy;
    private PersonalizePageView ixD;
    private com.baidu.tieba.homepage.framework.b ixE;
    private boolean isb = false;
    private CustomMessageListener ixF = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.cmW();
            }
        }
    };
    private final CustomMessageListener ixG = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.ixD != null) {
                PersonalizeFragment.this.ixD.e(l);
            }
        }
    };
    private final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.ixD.cmY();
            }
        }
    };
    private final CustomMessageListener hHa = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.cmV();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.ixD = new PersonalizePageView(context);
        this.ixD.bCM();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dkh().A(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.ixD.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ixD.getParent()).removeView(this.ixD);
            if (this.ixE != null) {
                this.ixD.setCallback(this.ixE);
            }
        }
        this.ixD.setPageUniqueId(getUniqueId());
        if (this.isb) {
            this.ixD.bCM();
            this.isb = false;
        }
        return this.ixD;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hFy = getVoiceManager();
        if (this.hFy != null) {
            this.hFy.onCreate(getPageContext());
        }
        this.ixF.setTag(getUniqueId());
        registerListener(this.ixF);
        registerListener(this.ixG);
        registerListener(this.hHa);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ao
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.ixD != null) {
            this.ixD.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void showFloatingView() {
        if (this.ixD != null) {
            this.ixD.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hFy != null) {
            this.hFy.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.aTD().hu(true);
        if (this.hFy != null) {
            this.hFy.onResume(getPageContext());
        }
        this.ixD.onResume();
        this.ixD.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        cmV();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ixD != null) {
            this.ixD.clx();
            this.ixD.onPause();
            this.ixD.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        if (this.hFy != null) {
            this.hFy.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.aQc().aQm();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dkh().b(getUniqueId(), false);
        if (this.hFy != null) {
            this.hFy.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hFy != null) {
            this.hFy.onDestory(getPageContext());
        }
        com.baidu.tieba.s.c.dkh().B(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.ixF);
        MessageManager.getInstance().unRegisterListener(this.ixG);
        MessageManager.getInstance().unRegisterListener(this.hHa);
        this.hFy = null;
        this.ixD.onDestroy();
        this.isb = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.ixD.setViewForeground();
            cmT();
            cmW();
            com.baidu.tieba.a.d.brD().onPageStart("page_recommend");
            return;
        }
        this.ixD.clx();
        com.baidu.tieba.a.d.brD().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.Ae(TbadkCoreApplication.getInst().getAdAdSense().epK);
        }
        return pageStayDurationItem;
    }

    private void cmT() {
        if (c.ao(getBaseFragmentActivity()) && this.ixD != null) {
            this.ixD.cmZ();
        }
    }

    public void bxR() {
        this.ixD.setViewForeground(true);
    }

    public void cmU() {
        this.ixD.cmU();
    }

    public void completePullRefresh() {
        this.ixD.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ixD != null) {
            this.ixD.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.ixE = bVar;
        this.ixD.setCallback(bVar);
    }

    public void aN(String str, int i) {
        this.ixD.aN(str, i);
    }

    public void clQ() {
        this.ixD.clQ();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.ixD.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmV() {
        com.baidu.tbadk.BdToken.c.aQc().kx(com.baidu.tbadk.BdToken.b.dEz);
    }

    @Override // com.baidu.tieba.frs.ao
    public void IH() {
        this.ixD.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hFy == null) {
            this.hFy = VoiceManager.instance();
        }
        return this.hFy;
    }

    @Override // com.baidu.tieba.frs.ao
    public void bwZ() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void bxa() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(x.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ixD.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ao
    public void bci() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmW() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(tVar);
        }
    }
}
