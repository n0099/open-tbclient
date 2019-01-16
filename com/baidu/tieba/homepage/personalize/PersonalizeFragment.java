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
    private VoiceManager dLz;
    private PersonalizePageView exQ;
    private com.baidu.tieba.homepage.framework.b exR;
    private boolean etD = false;
    private CustomMessageListener exS = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.aMl();
            }
        }
    };
    private final CustomMessageListener exT = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.exQ != null) {
                PersonalizeFragment.this.exQ.g(l);
            }
        }
    };
    private final CustomMessageListener dio = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.exQ.aMn();
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
        this.exQ = new PersonalizePageView(context);
        this.exQ.aGi();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.bCC().r(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.exQ.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.exQ.getParent()).removeView(this.exQ);
            if (this.exR != null) {
                this.exQ.setCallback(this.exR);
            }
        }
        this.exQ.setPageUniqueId(getUniqueId());
        if (this.etD) {
            this.exQ.aGi();
            this.etD = false;
        }
        return this.exQ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dLz = getVoiceManager();
        if (this.dLz != null) {
            this.dLz.onCreate(getPageContext());
        }
        this.exS.setTag(getUniqueId());
        registerListener(this.exS);
        registerListener(this.exT);
        registerListener(this.akJ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.exQ.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(v vVar) {
        if (this.exQ != null) {
            this.exQ.setRecommendFrsNavigationAnimDispatcher(vVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.exQ != null) {
            this.exQ.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dLz != null) {
            this.dLz.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.yf().aY(true);
        if (this.dLz != null) {
            this.dLz.onResume(getPageContext());
        }
        this.exQ.onResume();
        this.exQ.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.dio);
        aMk();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.exQ != null) {
            this.exQ.aLp();
            this.exQ.onPause();
            this.exQ.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.dio);
        if (this.dLz != null) {
            this.dLz.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.vy().vz();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.bCC().b(getUniqueId(), false);
        if (this.dLz != null) {
            this.dLz.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dLz != null) {
            this.dLz.onDestory(getPageContext());
        }
        com.baidu.tieba.q.c.bCC().s(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.exS);
        MessageManager.getInstance().unRegisterListener(this.exT);
        MessageManager.getInstance().unRegisterListener(this.akJ);
        this.dLz = null;
        this.exQ.onDestroy();
        this.etD = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.exQ.setViewForeground();
            aMi();
            aMl();
            com.baidu.tieba.a.d.Wk().onPageStart("page_recommend");
            return;
        }
        this.exQ.aLp();
        com.baidu.tieba.a.d.Wk().onPageEnd("page_recommend");
    }

    private void aMi() {
        if (c.L(getBaseFragmentActivity()) && this.exQ != null) {
            this.exQ.aMp();
        }
    }

    public void abv() {
        this.exQ.setViewForeground(true);
    }

    public void aMj() {
        this.exQ.aMj();
    }

    public void completePullRefresh() {
        this.exQ.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.exQ.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.exR = bVar;
        this.exQ.setCallback(bVar);
    }

    public void ah(String str, int i) {
        this.exQ.ah(str, i);
    }

    public void aLX() {
        this.exQ.aLX();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.exQ.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMk() {
        com.baidu.tbadk.BdToken.c.vy().bX(com.baidu.tbadk.BdToken.b.ajZ);
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaZ() {
        this.exQ.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dLz == null) {
            this.dLz = VoiceManager.instance();
        }
        return this.dLz;
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
        this.exQ.onChangeSkinType(i);
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
