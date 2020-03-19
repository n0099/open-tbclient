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
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ag {
    private VoiceManager gpi;
    private PersonalizePageView hdh;
    private com.baidu.tieba.homepage.framework.b hdi;
    private boolean gYe = false;
    private CustomMessageListener hdj = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.bOQ();
            }
        }
    };
    private final CustomMessageListener hdk = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.hdh != null) {
                PersonalizeFragment.this.hdh.e(l);
            }
        }
    };
    private final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.hdh.bOS();
            }
        }
    };
    private final CustomMessageListener gqu = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.bOP();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.hdh = new PersonalizePageView(context);
        this.hdh.initListeners();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cKv().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.hdh.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.hdh.getParent()).removeView(this.hdh);
            if (this.hdi != null) {
                this.hdh.setCallback(this.hdi);
            }
        }
        this.hdh.setPageUniqueId(getUniqueId());
        if (this.gYe) {
            this.hdh.initListeners();
            this.gYe = false;
        }
        return this.hdh;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gpi = getVoiceManager();
        if (this.gpi != null) {
            this.gpi.onCreate(getPageContext());
        }
        this.hdj.setTag(getUniqueId());
        registerListener(this.hdj);
        registerListener(this.hdk);
        registerListener(this.gqu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ag
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.hdh != null) {
            this.hdh.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void showFloatingView() {
        if (this.hdh != null) {
            this.hdh.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gpi != null) {
            this.gpi.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.azZ().fu(true);
        if (this.gpi != null) {
            this.gpi.onResume(getPageContext());
        }
        this.hdh.onResume();
        this.hdh.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        bOP();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hdh != null) {
            this.hdh.bNu();
            this.hdh.onPause();
            this.hdh.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        if (this.gpi != null) {
            this.gpi.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.axC().axH();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.cKv().b(getUniqueId(), false);
        if (this.gpi != null) {
            this.gpi.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gpi != null) {
            this.gpi.onDestory(getPageContext());
        }
        com.baidu.tieba.s.c.cKv().x(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.hdj);
        MessageManager.getInstance().unRegisterListener(this.hdk);
        MessageManager.getInstance().unRegisterListener(this.gqu);
        this.gpi = null;
        this.hdh.onDestroy();
        this.gYe = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.hdh.setViewForeground();
            bON();
            bOQ();
            com.baidu.tieba.a.d.aXK().onPageStart("page_recommend");
            return;
        }
        this.hdh.bNu();
        com.baidu.tieba.a.d.aXK().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.vG(TbadkCoreApplication.getInst().getAdAdSense().dmy);
        }
        return pageStayDurationItem;
    }

    private void bON() {
        if (c.ar(getBaseFragmentActivity()) && this.hdh != null) {
            this.hdh.bOT();
        }
    }

    public void bdw() {
        this.hdh.setViewForeground(true);
    }

    public void bOO() {
        this.hdh.bOO();
    }

    public void completePullRefresh() {
        this.hdh.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.hdh != null) {
            this.hdh.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.hdi = bVar;
        this.hdh.setCallback(bVar);
    }

    public void aE(String str, int i) {
        this.hdh.aE(str, i);
    }

    public void bNR() {
        this.hdh.bNR();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.hdh.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOP() {
        com.baidu.tbadk.BdToken.c.axC().jk(com.baidu.tbadk.BdToken.b.cGZ);
    }

    @Override // com.baidu.tieba.frs.ag
    public void AJ() {
        this.hdh.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gpi == null) {
            this.gpi = VoiceManager.instance();
        }
        return this.gpi;
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcE() {
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcF() {
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
        this.hdh.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ag
    public void aHS() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOQ() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
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
