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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ae {
    private VoiceManager ftO;
    private PersonalizePageView ghE;
    private com.baidu.tieba.homepage.framework.b ghF;
    private boolean gbR = false;
    private CustomMessageListener ghG = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.bwx();
            }
        }
    };
    private final CustomMessageListener ghH = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.ghE != null) {
                PersonalizeFragment.this.ghE.d(l);
            }
        }
    };
    private final CustomMessageListener byN = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.ghE.bwz();
            }
        }
    };
    private final CustomMessageListener fvg = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.bww();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.ghE = new PersonalizePageView(context);
        this.ghE.bpT();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.coo().u(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.ghE.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ghE.getParent()).removeView(this.ghE);
            if (this.ghF != null) {
                this.ghE.setCallback(this.ghF);
            }
        }
        this.ghE.setPageUniqueId(getUniqueId());
        if (this.gbR) {
            this.ghE.bpT();
            this.gbR = false;
        }
        return this.ghE;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.ftO = getVoiceManager();
        if (this.ftO != null) {
            this.ftO.onCreate(getPageContext());
        }
        this.ghG.setTag(getUniqueId());
        registerListener(this.ghG);
        registerListener(this.ghH);
        registerListener(this.fvg);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.ghE != null) {
            this.ghE.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.ghE != null) {
            this.ghE.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.ftO != null) {
            this.ftO.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.aco().dG(true);
        if (this.ftO != null) {
            this.ftO.onResume(getPageContext());
        }
        this.ghE.onResume();
        this.ghE.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.byN);
        bww();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ghE != null) {
            this.ghE.buT();
            this.ghE.onPause();
            this.ghE.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.byN);
        if (this.ftO != null) {
            this.ftO.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.Zg().Zl();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.coo().b(getUniqueId(), false);
        if (this.ftO != null) {
            this.ftO.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ftO != null) {
            this.ftO.onDestory(getPageContext());
        }
        com.baidu.tieba.q.c.coo().v(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.ghG);
        MessageManager.getInstance().unRegisterListener(this.ghH);
        MessageManager.getInstance().unRegisterListener(this.fvg);
        this.ftO = null;
        this.ghE.onDestroy();
        this.gbR = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.ghE.setViewForeground();
            bwu();
            bwx();
            com.baidu.tieba.a.d.aCF().onPageStart("page_recommend");
            return;
        }
        this.ghE.buT();
        com.baidu.tieba.a.d.aCF().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.qU(TbadkCoreApplication.getInst().getAdAdSense().cfM);
        }
        return pageStayDurationItem;
    }

    private void bwu() {
        if (c.aq(getBaseFragmentActivity()) && this.ghE != null) {
            this.ghE.bwA();
        }
    }

    public void aKh() {
        this.ghE.setViewForeground(true);
    }

    public void bwv() {
        this.ghE.bwv();
    }

    public void completePullRefresh() {
        this.ghE.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ghE != null) {
            this.ghE.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.ghF = bVar;
        this.ghE.setCallback(bVar);
    }

    public void az(String str, int i) {
        this.ghE.az(str, i);
    }

    public void bvA() {
        this.ghE.bvA();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.ghE.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bww() {
        com.baidu.tbadk.BdToken.c.Zg().gn(com.baidu.tbadk.BdToken.b.bxP);
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJi() {
        this.ghE.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ftO == null) {
            this.ftO = VoiceManager.instance();
        }
        return this.ftO;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJj() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJk() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(v.c(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a002";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ghE.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void akL() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwx() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
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
