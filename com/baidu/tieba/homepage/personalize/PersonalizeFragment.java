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
import com.baidu.tbadk.util.w;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ae {
    private VoiceManager fwa;
    private PersonalizePageView gkn;
    private com.baidu.tieba.homepage.framework.b gko;
    private boolean gez = false;
    private CustomMessageListener gkp = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.bxz();
            }
        }
    };
    private final CustomMessageListener gkq = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.gkn != null) {
                PersonalizeFragment.this.gkn.d(l);
            }
        }
    };
    private final CustomMessageListener bzl = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.gkn.bxB();
            }
        }
    };
    private final CustomMessageListener fxs = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.bxy();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.gkn = new PersonalizePageView(context);
        this.gkn.bqS();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cpt().u(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.gkn.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gkn.getParent()).removeView(this.gkn);
            if (this.gko != null) {
                this.gkn.setCallback(this.gko);
            }
        }
        this.gkn.setPageUniqueId(getUniqueId());
        if (this.gez) {
            this.gkn.bqS();
            this.gez = false;
        }
        return this.gkn;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.fwa = getVoiceManager();
        if (this.fwa != null) {
            this.fwa.onCreate(getPageContext());
        }
        this.gkp.setTag(getUniqueId());
        registerListener(this.gkp);
        registerListener(this.gkq);
        registerListener(this.fxs);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
        if (this.gkn != null) {
            this.gkn.setRecommendFrsNavigationAnimDispatcher(wVar);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.gkn != null) {
            this.gkn.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fwa != null) {
            this.fwa.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.acs().dG(true);
        if (this.fwa != null) {
            this.fwa.onResume(getPageContext());
        }
        this.gkn.onResume();
        this.gkn.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.bzl);
        bxy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gkn != null) {
            this.gkn.bvU();
            this.gkn.onPause();
            this.gkn.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.bzl);
        if (this.fwa != null) {
            this.fwa.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.Zk().Zp();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.cpt().b(getUniqueId(), false);
        if (this.fwa != null) {
            this.fwa.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fwa != null) {
            this.fwa.onDestory(getPageContext());
        }
        com.baidu.tieba.q.c.cpt().v(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gkp);
        MessageManager.getInstance().unRegisterListener(this.gkq);
        MessageManager.getInstance().unRegisterListener(this.fxs);
        this.fwa = null;
        this.gkn.onDestroy();
        this.gez = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.gkn.setViewForeground();
            bxw();
            bxz();
            com.baidu.tieba.a.d.aCV().onPageStart("page_recommend");
            return;
        }
        this.gkn.bvU();
        com.baidu.tieba.a.d.aCV().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.rf(TbadkCoreApplication.getInst().getAdAdSense().cgM);
        }
        return pageStayDurationItem;
    }

    private void bxw() {
        if (c.aq(getBaseFragmentActivity()) && this.gkn != null) {
            this.gkn.bxC();
        }
    }

    public void aKN() {
        this.gkn.setViewForeground(true);
    }

    public void bxx() {
        this.gkn.bxx();
    }

    public void completePullRefresh() {
        this.gkn.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gkn != null) {
            this.gkn.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.gko = bVar;
        this.gkn.setCallback(bVar);
    }

    public void aB(String str, int i) {
        this.gkn.aB(str, i);
    }

    public void bwB() {
        this.gkn.bwB();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.gkn.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxy() {
        com.baidu.tbadk.BdToken.c.Zk().go(com.baidu.tbadk.BdToken.b.byn);
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJO() {
        this.gkn.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fwa == null) {
            this.fwa = VoiceManager.instance();
        }
        return this.fwa;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJP() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJQ() {
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
        this.gkn.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void akZ() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxz() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("show_recommend_label", false)) {
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
