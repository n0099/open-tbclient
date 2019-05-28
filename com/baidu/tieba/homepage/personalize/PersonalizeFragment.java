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
    private VoiceManager foP;
    private PersonalizePageView gbn;
    private com.baidu.tieba.homepage.framework.b gbo;
    private boolean fWS = false;
    private CustomMessageListener gbp = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.btR();
            }
        }
    };
    private final CustomMessageListener gbq = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.gbn != null) {
                PersonalizeFragment.this.gbn.d(l);
            }
        }
    };
    private final CustomMessageListener bxW = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.gbn.btT();
            }
        }
    };
    private final CustomMessageListener fqi = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.btQ();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.gbn = new PersonalizePageView(context);
        this.gbn.bnS();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.clv().u(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.gbn.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gbn.getParent()).removeView(this.gbn);
            if (this.gbo != null) {
                this.gbn.setCallback(this.gbo);
            }
        }
        this.gbn.setPageUniqueId(getUniqueId());
        if (this.fWS) {
            this.gbn.bnS();
            this.fWS = false;
        }
        return this.gbn;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.foP = getVoiceManager();
        if (this.foP != null) {
            this.foP.onCreate(getPageContext());
        }
        this.gbp.setTag(getUniqueId());
        registerListener(this.gbp);
        registerListener(this.gbq);
        registerListener(this.fqi);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.gbn != null) {
            this.gbn.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.gbn != null) {
            this.gbn.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.foP != null) {
            this.foP.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.abp().dC(true);
        if (this.foP != null) {
            this.foP.onResume(getPageContext());
        }
        this.gbn.onResume();
        this.gbn.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.bxW);
        btQ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gbn != null) {
            this.gbn.bsQ();
            this.gbn.onPause();
            this.gbn.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.bxW);
        if (this.foP != null) {
            this.foP.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.Yk().Yp();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.clv().b(getUniqueId(), false);
        if (this.foP != null) {
            this.foP.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.foP != null) {
            this.foP.onDestory(getPageContext());
        }
        com.baidu.tieba.q.c.clv().v(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gbp);
        MessageManager.getInstance().unRegisterListener(this.gbq);
        MessageManager.getInstance().unRegisterListener(this.fqi);
        this.foP = null;
        this.gbn.onDestroy();
        this.fWS = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.gbn.setViewForeground();
            btO();
            btR();
            com.baidu.tieba.a.d.aBq().onPageStart("page_recommend");
            return;
        }
        this.gbn.bsQ();
        com.baidu.tieba.a.d.aBq().onPageEnd("page_recommend");
    }

    private void btO() {
        if (c.an(getBaseFragmentActivity()) && this.gbn != null) {
            this.gbn.btU();
        }
    }

    public void aIG() {
        this.gbn.setViewForeground(true);
    }

    public void btP() {
        this.gbn.btP();
    }

    public void completePullRefresh() {
        this.gbn.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gbn != null) {
            this.gbn.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.gbo = bVar;
        this.gbn.setCallback(bVar);
    }

    public void ay(String str, int i) {
        this.gbn.ay(str, i);
    }

    public void btw() {
        this.gbn.btw();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.gbn.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btQ() {
        com.baidu.tbadk.BdToken.c.Yk().gj(com.baidu.tbadk.BdToken.b.bwY);
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHL() {
        this.gbn.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.foP == null) {
            this.foP = VoiceManager.instance();
        }
        return this.foP;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHM() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHN() {
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
        this.gbn.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void ajG() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btR() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_recommend_label", false)) {
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
