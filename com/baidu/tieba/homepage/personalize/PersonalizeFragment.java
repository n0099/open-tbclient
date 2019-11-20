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
import com.baidu.tbadk.util.w;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ae {
    private VoiceManager fuw;
    private PersonalizePageView giU;
    private com.baidu.tieba.homepage.framework.b giV;
    private boolean gde = false;
    private CustomMessageListener giW = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.buB();
            }
        }
    };
    private final CustomMessageListener giX = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.giU != null) {
                PersonalizeFragment.this.giU.c(l);
            }
        }
    };
    private final CustomMessageListener bRa = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.giU.buD();
            }
        }
    };
    private final CustomMessageListener fvP = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.buA();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.giU = new PersonalizePageView(context);
        this.giU.aNb();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cni().v(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.giU.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.giU.getParent()).removeView(this.giU);
            if (this.giV != null) {
                this.giU.setCallback(this.giV);
            }
        }
        this.giU.setPageUniqueId(getUniqueId());
        if (this.gde) {
            this.giU.aNb();
            this.gde = false;
        }
        return this.giU;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.fuw = getVoiceManager();
        if (this.fuw != null) {
            this.fuw.onCreate(getPageContext());
        }
        this.giW.setTag(getUniqueId());
        registerListener(this.giW);
        registerListener(this.giX);
        registerListener(this.fvP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
        if (this.giU != null) {
            this.giU.setRecommendFrsNavigationAnimDispatcher(wVar);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.giU != null) {
            this.giU.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fuw != null) {
            this.fuw.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.agw().dW(true);
        if (this.fuw != null) {
            this.fuw.onResume(getPageContext());
        }
        this.giU.onResume();
        this.giU.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.bRa);
        buA();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.giU != null) {
            this.giU.bsX();
            this.giU.onPause();
            this.giU.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.bRa);
        if (this.fuw != null) {
            this.fuw.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.adX().aec();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.cni().b(getUniqueId(), false);
        if (this.fuw != null) {
            this.fuw.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fuw != null) {
            this.fuw.onDestory(getPageContext());
        }
        com.baidu.tieba.q.c.cni().w(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.giW);
        MessageManager.getInstance().unRegisterListener(this.giX);
        MessageManager.getInstance().unRegisterListener(this.fvP);
        this.fuw = null;
        this.giU.onDestroy();
        this.gde = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.giU.setViewForeground();
            buy();
            buB();
            com.baidu.tieba.a.d.aDc().onPageStart("page_recommend");
            return;
        }
        this.giU.bsX();
        com.baidu.tieba.a.d.aDc().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.qd(TbadkCoreApplication.getInst().getAdAdSense().ctT);
        }
        return pageStayDurationItem;
    }

    private void buy() {
        if (c.ai(getBaseFragmentActivity()) && this.giU != null) {
            this.giU.buE();
        }
    }

    public void aKf() {
        this.giU.setViewForeground(true);
    }

    public void buz() {
        this.giU.buz();
    }

    public void completePullRefresh() {
        this.giU.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.giU != null) {
            this.giU.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.giV = bVar;
        this.giU.setCallback(bVar);
    }

    public void aw(String str, int i) {
        this.giU.aw(str, i);
    }

    public void btE() {
        this.giU.btE();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.giU.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buA() {
        com.baidu.tbadk.BdToken.c.adX().hi(com.baidu.tbadk.BdToken.b.bQc);
    }

    @Override // com.baidu.tieba.frs.ae
    public void vV() {
        this.giU.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fuw == null) {
            this.fuw = VoiceManager.instance();
        }
        return this.fuw;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJn() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJo() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
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

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
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
        this.giU.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void anM() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buB() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(pVar);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }
}
