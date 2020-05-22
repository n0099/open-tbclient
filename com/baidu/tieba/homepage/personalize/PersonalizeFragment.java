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
import com.baidu.adp.widget.ListView.r;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, aj {
    private VoiceManager hnh;
    private PersonalizePageView ibD;
    private com.baidu.tieba.homepage.framework.b ibE;
    private boolean hWL = false;
    private CustomMessageListener ibF = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.cfL();
            }
        }
    };
    private final CustomMessageListener ibG = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.ibD != null) {
                PersonalizeFragment.this.ibD.e(l);
            }
        }
    };
    private final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.ibD.cfN();
            }
        }
    };
    private final CustomMessageListener hov = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.cfK();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.ibD = new PersonalizePageView(context);
        this.ibD.bwA();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dct().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.ibD.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ibD.getParent()).removeView(this.ibD);
            if (this.ibE != null) {
                this.ibD.setCallback(this.ibE);
            }
        }
        this.ibD.setPageUniqueId(getUniqueId());
        if (this.hWL) {
            this.ibD.bwA();
            this.hWL = false;
        }
        return this.ibD;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hnh = getVoiceManager();
        if (this.hnh != null) {
            this.hnh.onCreate(getPageContext());
        }
        this.ibF.setTag(getUniqueId());
        registerListener(this.ibF);
        registerListener(this.ibG);
        registerListener(this.hov);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.ibD != null) {
            this.ibD.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.ibD != null) {
            this.ibD.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hnh != null) {
            this.hnh.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.aNY().gJ(true);
        if (this.hnh != null) {
            this.hnh.onResume(getPageContext());
        }
        this.ibD.onResume();
        this.ibD.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        cfK();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ibD != null) {
            this.ibD.ces();
            this.ibD.onPause();
            this.ibD.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        if (this.hnh != null) {
            this.hnh.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.aLi().aLn();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dct().b(getUniqueId(), false);
        if (this.hnh != null) {
            this.hnh.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hnh != null) {
            this.hnh.onDestory(getPageContext());
        }
        com.baidu.tieba.s.c.dct().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.ibF);
        MessageManager.getInstance().unRegisterListener(this.ibG);
        MessageManager.getInstance().unRegisterListener(this.hov);
        this.hnh = null;
        this.ibD.onDestroy();
        this.hWL = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.ibD.setViewForeground();
            cfI();
            cfL();
            com.baidu.tieba.a.d.blZ().onPageStart("page_recommend");
            return;
        }
        this.ibD.ces();
        com.baidu.tieba.a.d.blZ().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.yE(TbadkCoreApplication.getInst().getAdAdSense().eaO);
        }
        return pageStayDurationItem;
    }

    private void cfI() {
        if (c.am(getBaseFragmentActivity()) && this.ibD != null) {
            this.ibD.cfO();
        }
    }

    public void brJ() {
        this.ibD.setViewForeground(true);
    }

    public void cfJ() {
        this.ibD.cfJ();
    }

    public void completePullRefresh() {
        this.ibD.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ibD != null) {
            this.ibD.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.ibE = bVar;
        this.ibD.setCallback(bVar);
    }

    public void aP(String str, int i) {
        this.ibD.aP(str, i);
    }

    public void ceM() {
        this.ibD.ceM();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.ibD.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfK() {
        com.baidu.tbadk.BdToken.c.aLi().jR(com.baidu.tbadk.BdToken.b.dtU);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ho() {
        this.ibD.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hnh == null) {
            this.hnh = VoiceManager.instance();
        }
        return this.hnh;
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqQ() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqR() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(v.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ibD.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aj
    public void aWq() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfL() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(r rVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(rVar);
        }
    }
}
