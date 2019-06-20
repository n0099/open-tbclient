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
    private PersonalizePageView gbp;
    private com.baidu.tieba.homepage.framework.b gbq;
    private boolean fWU = false;
    private CustomMessageListener gbr = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.btS();
            }
        }
    };
    private final CustomMessageListener gbs = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.gbp != null) {
                PersonalizeFragment.this.gbp.d(l);
            }
        }
    };
    private final CustomMessageListener bxW = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.gbp.btU();
            }
        }
    };
    private final CustomMessageListener fqi = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.btR();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.gbp = new PersonalizePageView(context);
        this.gbp.bnS();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.clw().u(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.gbp.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gbp.getParent()).removeView(this.gbp);
            if (this.gbq != null) {
                this.gbp.setCallback(this.gbq);
            }
        }
        this.gbp.setPageUniqueId(getUniqueId());
        if (this.fWU) {
            this.gbp.bnS();
            this.fWU = false;
        }
        return this.gbp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.foP = getVoiceManager();
        if (this.foP != null) {
            this.foP.onCreate(getPageContext());
        }
        this.gbr.setTag(getUniqueId());
        registerListener(this.gbr);
        registerListener(this.gbs);
        registerListener(this.fqi);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.gbp != null) {
            this.gbp.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.gbp != null) {
            this.gbp.showFloatingView();
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
        this.gbp.onResume();
        this.gbp.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.bxW);
        btR();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gbp != null) {
            this.gbp.bsS();
            this.gbp.onPause();
            this.gbp.setTabInForeBackgroundState(true);
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
        com.baidu.tieba.q.c.clw().b(getUniqueId(), false);
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
        com.baidu.tieba.q.c.clw().v(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gbr);
        MessageManager.getInstance().unRegisterListener(this.gbs);
        MessageManager.getInstance().unRegisterListener(this.fqi);
        this.foP = null;
        this.gbp.onDestroy();
        this.fWU = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.gbp.setViewForeground();
            btP();
            btS();
            com.baidu.tieba.a.d.aBq().onPageStart("page_recommend");
            return;
        }
        this.gbp.bsS();
        com.baidu.tieba.a.d.aBq().onPageEnd("page_recommend");
    }

    private void btP() {
        if (c.an(getBaseFragmentActivity()) && this.gbp != null) {
            this.gbp.btV();
        }
    }

    public void aIG() {
        this.gbp.setViewForeground(true);
    }

    public void btQ() {
        this.gbp.btQ();
    }

    public void completePullRefresh() {
        this.gbp.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gbp != null) {
            this.gbp.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.gbq = bVar;
        this.gbp.setCallback(bVar);
    }

    public void ay(String str, int i) {
        this.gbp.ay(str, i);
    }

    public void btx() {
        this.gbp.btx();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.gbp.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btR() {
        com.baidu.tbadk.BdToken.c.Yk().gj(com.baidu.tbadk.BdToken.b.bwY);
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHL() {
        this.gbp.reload();
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
        this.gbp.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void ajG() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btS() {
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
