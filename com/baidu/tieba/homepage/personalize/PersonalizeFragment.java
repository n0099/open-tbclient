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
/* loaded from: classes7.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, af {
    private PersonalizePageView gZL;
    private com.baidu.tieba.homepage.framework.b gZM;
    private VoiceManager gmi;
    private boolean gUI = false;
    private CustomMessageListener gZN = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.bMX();
            }
        }
    };
    private final CustomMessageListener gZO = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.gZL != null) {
                PersonalizeFragment.this.gZL.e(l);
            }
        }
    };
    private final CustomMessageListener cDL = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.gZL.bMZ();
            }
        }
    };
    private final CustomMessageListener gnu = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.bMW();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.gZL = new PersonalizePageView(context);
        this.gZL.initListeners();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.r.c.cIs().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.gZL.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gZL.getParent()).removeView(this.gZL);
            if (this.gZM != null) {
                this.gZL.setCallback(this.gZM);
            }
        }
        this.gZL.setPageUniqueId(getUniqueId());
        if (this.gUI) {
            this.gZL.initListeners();
            this.gUI = false;
        }
        return this.gZL;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onCreate(getPageContext());
        }
        this.gZN.setTag(getUniqueId());
        registerListener(this.gZN);
        registerListener(this.gZO);
        registerListener(this.gnu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.gZL != null) {
            this.gZL.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
        if (this.gZL != null) {
            this.gZL.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gmi != null) {
            this.gmi.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.axG().fm(true);
        if (this.gmi != null) {
            this.gmi.onResume(getPageContext());
        }
        this.gZL.onResume();
        this.gZL.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cDL);
        bMW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gZL != null) {
            this.gZL.bLA();
            this.gZL.onPause();
            this.gZL.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.cDL);
        if (this.gmi != null) {
            this.gmi.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.avj().avo();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.r.c.cIs().b(getUniqueId(), false);
        if (this.gmi != null) {
            this.gmi.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gmi != null) {
            this.gmi.onDestory(getPageContext());
        }
        com.baidu.tieba.r.c.cIs().x(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gZN);
        MessageManager.getInstance().unRegisterListener(this.gZO);
        MessageManager.getInstance().unRegisterListener(this.gnu);
        this.gmi = null;
        this.gZL.onDestroy();
        this.gUI = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.gZL.setViewForeground();
            bMU();
            bMX();
            com.baidu.tieba.a.d.aVo().onPageStart("page_recommend");
            return;
        }
        this.gZL.bLA();
        com.baidu.tieba.a.d.aVo().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.vk(TbadkCoreApplication.getInst().getAdAdSense().dhR);
        }
        return pageStayDurationItem;
    }

    private void bMU() {
        if (c.ao(getBaseFragmentActivity()) && this.gZL != null) {
            this.gZL.bNa();
        }
    }

    public void baZ() {
        this.gZL.setViewForeground(true);
    }

    public void bMV() {
        this.gZL.bMV();
    }

    public void completePullRefresh() {
        this.gZL.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gZL != null) {
            this.gZL.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.gZM = bVar;
        this.gZL.setCallback(bVar);
    }

    public void aG(String str, int i) {
        this.gZL.aG(str, i);
    }

    public void bLX() {
        this.gZL.bLX();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.gZL.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMW() {
        com.baidu.tbadk.BdToken.c.avj().iT(com.baidu.tbadk.BdToken.b.cCO);
    }

    @Override // com.baidu.tieba.frs.af
    public void yj() {
        this.gZL.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gmi == null) {
            this.gmi = VoiceManager.instance();
        }
        return this.gmi;
    }

    @Override // com.baidu.tieba.frs.af
    public void bah() {
    }

    @Override // com.baidu.tieba.frs.af
    public void bai() {
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
        this.gZL.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.af
    public void aFw() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMX() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
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
