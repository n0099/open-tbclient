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
import com.baidu.adp.widget.ListView.k;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ah {
    private VoiceManager dLA;
    private PersonalizePageView exR;
    private com.baidu.tieba.homepage.framework.b exS;
    private boolean etE = false;
    private CustomMessageListener exT = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.aMl();
            }
        }
    };
    private final CustomMessageListener exU = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.exR != null) {
                PersonalizeFragment.this.exR.g(l);
            }
        }
    };
    private final CustomMessageListener dip = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.exR.aMn();
            }
        }
    };
    private final CustomMessageListener akJ = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.aMk();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.exR = new PersonalizePageView(context);
        this.exR.aGi();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.bCC().r(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.exR.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.exR.getParent()).removeView(this.exR);
            if (this.exS != null) {
                this.exR.setCallback(this.exS);
            }
        }
        this.exR.setPageUniqueId(getUniqueId());
        if (this.etE) {
            this.exR.aGi();
            this.etE = false;
        }
        return this.exR;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dLA = getVoiceManager();
        if (this.dLA != null) {
            this.dLA.onCreate(getPageContext());
        }
        this.exT.setTag(getUniqueId());
        registerListener(this.exT);
        registerListener(this.exU);
        registerListener(this.akJ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.exR.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(v vVar) {
        if (this.exR != null) {
            this.exR.setRecommendFrsNavigationAnimDispatcher(vVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.exR != null) {
            this.exR.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dLA != null) {
            this.dLA.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.yf().aY(true);
        if (this.dLA != null) {
            this.dLA.onResume(getPageContext());
        }
        this.exR.onResume();
        this.exR.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.dip);
        aMk();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.exR != null) {
            this.exR.aLp();
            this.exR.onPause();
            this.exR.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.dip);
        if (this.dLA != null) {
            this.dLA.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.vy().vz();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.bCC().b(getUniqueId(), false);
        if (this.dLA != null) {
            this.dLA.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dLA != null) {
            this.dLA.onDestory(getPageContext());
        }
        com.baidu.tieba.q.c.bCC().s(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.exT);
        MessageManager.getInstance().unRegisterListener(this.exU);
        MessageManager.getInstance().unRegisterListener(this.akJ);
        this.dLA = null;
        this.exR.onDestroy();
        this.etE = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.exR.setViewForeground();
            aMi();
            aMl();
            com.baidu.tieba.a.d.Wk().onPageStart("page_recommend");
            return;
        }
        this.exR.aLp();
        com.baidu.tieba.a.d.Wk().onPageEnd("page_recommend");
    }

    private void aMi() {
        if (c.L(getBaseFragmentActivity()) && this.exR != null) {
            this.exR.aMp();
        }
    }

    public void abv() {
        this.exR.setViewForeground(true);
    }

    public void aMj() {
        this.exR.aMj();
    }

    public void completePullRefresh() {
        this.exR.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.exR.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.exS = bVar;
        this.exR.setCallback(bVar);
    }

    public void ah(String str, int i) {
        this.exR.ah(str, i);
    }

    public void aLX() {
        this.exR.aLX();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.exR.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMk() {
        com.baidu.tbadk.BdToken.c.vy().bX(com.baidu.tbadk.BdToken.b.ajZ);
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaZ() {
        this.exR.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dLA == null) {
            this.dLA = VoiceManager.instance();
        }
        return this.dLA;
    }

    @Override // com.baidu.tieba.frs.ah
    public void aba() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void abb() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
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
        this.exR.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void Fw() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMl() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(k kVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(kVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}
