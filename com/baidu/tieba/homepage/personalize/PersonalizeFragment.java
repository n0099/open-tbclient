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
    private VoiceManager fun;
    private PersonalizePageView giv;
    private com.baidu.tieba.homepage.framework.b giw;
    private boolean gcH = false;
    private CustomMessageListener gix = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.bwL();
            }
        }
    };
    private final CustomMessageListener giy = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.giv != null) {
                PersonalizeFragment.this.giv.d(l);
            }
        }
    };
    private final CustomMessageListener byN = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.giv.bwN();
            }
        }
    };
    private final CustomMessageListener fvF = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.bwK();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.giv = new PersonalizePageView(context);
        this.giv.bqg();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.coG().u(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.giv.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.giv.getParent()).removeView(this.giv);
            if (this.giw != null) {
                this.giv.setCallback(this.giw);
            }
        }
        this.giv.setPageUniqueId(getUniqueId());
        if (this.gcH) {
            this.giv.bqg();
            this.gcH = false;
        }
        return this.giv;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.fun = getVoiceManager();
        if (this.fun != null) {
            this.fun.onCreate(getPageContext());
        }
        this.gix.setTag(getUniqueId());
        registerListener(this.gix);
        registerListener(this.giy);
        registerListener(this.fvF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.giv != null) {
            this.giv.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.giv != null) {
            this.giv.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fun != null) {
            this.fun.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.aco().dG(true);
        if (this.fun != null) {
            this.fun.onResume(getPageContext());
        }
        this.giv.onResume();
        this.giv.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.byN);
        bwK();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.giv != null) {
            this.giv.bvg();
            this.giv.onPause();
            this.giv.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.byN);
        if (this.fun != null) {
            this.fun.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.Zg().Zl();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.coG().b(getUniqueId(), false);
        if (this.fun != null) {
            this.fun.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fun != null) {
            this.fun.onDestory(getPageContext());
        }
        com.baidu.tieba.q.c.coG().v(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gix);
        MessageManager.getInstance().unRegisterListener(this.giy);
        MessageManager.getInstance().unRegisterListener(this.fvF);
        this.fun = null;
        this.giv.onDestroy();
        this.gcH = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.giv.setViewForeground();
            bwI();
            bwL();
            com.baidu.tieba.a.d.aCH().onPageStart("page_recommend");
            return;
        }
        this.giv.bvg();
        com.baidu.tieba.a.d.aCH().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.qU(TbadkCoreApplication.getInst().getAdAdSense().cfT);
        }
        return pageStayDurationItem;
    }

    private void bwI() {
        if (c.aq(getBaseFragmentActivity()) && this.giv != null) {
            this.giv.bwO();
        }
    }

    public void aKj() {
        this.giv.setViewForeground(true);
    }

    public void bwJ() {
        this.giv.bwJ();
    }

    public void completePullRefresh() {
        this.giv.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.giv != null) {
            this.giv.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.giw = bVar;
        this.giv.setCallback(bVar);
    }

    public void az(String str, int i) {
        this.giv.az(str, i);
    }

    public void bvN() {
        this.giv.bvN();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.giv.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwK() {
        com.baidu.tbadk.BdToken.c.Zg().gn(com.baidu.tbadk.BdToken.b.bxP);
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJk() {
        this.giv.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fun == null) {
            this.fun = VoiceManager.instance();
        }
        return this.fun;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJl() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJm() {
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
        this.giv.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void akN() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwL() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("show_recommend_label", false)) {
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
