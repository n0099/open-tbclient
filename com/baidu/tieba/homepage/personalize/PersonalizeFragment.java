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
import com.baidu.adp.widget.ListView.p;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, af {
    private VoiceManager goj;
    private PersonalizePageView hbL;
    private com.baidu.tieba.homepage.framework.b hbM;
    private boolean gWJ = false;
    private CustomMessageListener hbN = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.bOz();
            }
        }
    };
    private final CustomMessageListener hbO = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.hbL != null) {
                PersonalizeFragment.this.hbL.e(l);
            }
        }
    };
    private final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.hbL.bOB();
            }
        }
    };
    private final CustomMessageListener gpv = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.bOy();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.hbL = new PersonalizePageView(context);
        this.hbL.initListeners();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cJY().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.hbL.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.hbL.getParent()).removeView(this.hbL);
            if (this.hbM != null) {
                this.hbL.setCallback(this.hbM);
            }
        }
        this.hbL.setPageUniqueId(getUniqueId());
        if (this.gWJ) {
            this.hbL.initListeners();
            this.gWJ = false;
        }
        return this.hbL;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.goj = getVoiceManager();
        if (this.goj != null) {
            this.goj.onCreate(getPageContext());
        }
        this.hbN.setTag(getUniqueId());
        registerListener(this.hbN);
        registerListener(this.hbO);
        registerListener(this.gpv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.hbL != null) {
            this.hbL.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
        if (this.hbL != null) {
            this.hbL.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.goj != null) {
            this.goj.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.azU().ft(true);
        if (this.goj != null) {
            this.goj.onResume(getPageContext());
        }
        this.hbL.onResume();
        this.hbL.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        bOy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hbL != null) {
            this.hbL.bNd();
            this.hbL.onPause();
            this.hbL.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        if (this.goj != null) {
            this.goj.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.axx().axC();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.cJY().b(getUniqueId(), false);
        if (this.goj != null) {
            this.goj.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.goj != null) {
            this.goj.onDestory(getPageContext());
        }
        com.baidu.tieba.s.c.cJY().x(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.hbN);
        MessageManager.getInstance().unRegisterListener(this.hbO);
        MessageManager.getInstance().unRegisterListener(this.gpv);
        this.goj = null;
        this.hbL.onDestroy();
        this.gWJ = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.hbL.setViewForeground();
            bOw();
            bOz();
            com.baidu.tieba.a.d.aXD().onPageStart("page_recommend");
            return;
        }
        this.hbL.bNd();
        com.baidu.tieba.a.d.aXD().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.vE(TbadkCoreApplication.getInst().getAdAdSense().dlX);
        }
        return pageStayDurationItem;
    }

    private void bOw() {
        if (c.ap(getBaseFragmentActivity()) && this.hbL != null) {
            this.hbL.bOC();
        }
    }

    public void bdo() {
        this.hbL.setViewForeground(true);
    }

    public void bOx() {
        this.hbL.bOx();
    }

    public void completePullRefresh() {
        this.hbL.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.hbL != null) {
            this.hbL.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.hbM = bVar;
        this.hbL.setCallback(bVar);
    }

    public void aE(String str, int i) {
        this.hbL.aE(str, i);
    }

    public void bNA() {
        this.hbL.bNA();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.hbL.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOy() {
        com.baidu.tbadk.BdToken.c.axx().jk(com.baidu.tbadk.BdToken.b.cGM);
    }

    @Override // com.baidu.tieba.frs.af
    public void AA() {
        this.hbL.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.goj == null) {
            this.goj = VoiceManager.instance();
        }
        return this.goj;
    }

    @Override // com.baidu.tieba.frs.af
    public void bcx() {
    }

    @Override // com.baidu.tieba.frs.af
    public void bcy() {
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
        this.hbL.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.af
    public void aHL() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOz() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(pVar);
        }
    }
}
