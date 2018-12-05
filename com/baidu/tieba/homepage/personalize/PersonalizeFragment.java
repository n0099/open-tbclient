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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ah {
    private VoiceManager dIc;
    private PersonalizePageView eup;
    private com.baidu.tieba.homepage.framework.b euq;
    private boolean eqf = false;
    private CustomMessageListener eur = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.aKY();
            }
        }
    };
    private final CustomMessageListener eus = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.eup != null) {
                PersonalizeFragment.this.eup.g(l);
            }
        }
    };
    private final CustomMessageListener deM = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.eup.aLa();
            }
        }
    };
    private final CustomMessageListener akA = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.aKX();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.eup = new PersonalizePageView(context);
        this.eup.aEW();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.eup.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.eup.getParent()).removeView(this.eup);
            if (this.euq != null) {
                this.eup.setCallback(this.euq);
            }
        }
        this.eup.setPageUniqueId(getUniqueId());
        if (this.eqf) {
            this.eup.aEW();
            this.eqf = false;
        }
        return this.eup;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onCreate(getPageContext());
        }
        this.eur.setTag(getUniqueId());
        registerListener(this.eur);
        registerListener(this.eus);
        registerListener(this.akA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.eup.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.eup != null) {
            this.eup.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.eup != null) {
            this.eup.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dIc != null) {
            this.dIc.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.xS().aX(true);
        if (this.dIc != null) {
            this.dIc.onResume(getPageContext());
        }
        this.eup.onResume();
        this.eup.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.deM);
        aKX();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eup != null) {
            this.eup.aKc();
            this.eup.onPause();
            this.eup.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.deM);
        if (this.dIc != null) {
            this.dIc.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.vu().vv();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dIc != null) {
            this.dIc.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dIc != null) {
            this.dIc.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.eur);
        MessageManager.getInstance().unRegisterListener(this.eus);
        MessageManager.getInstance().unRegisterListener(this.akA);
        this.dIc = null;
        this.eup.onDestroy();
        this.eqf = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.eup.setViewForeground();
            aKV();
            aKY();
            com.baidu.tieba.a.d.VM().onPageStart("page_recommend");
            return;
        }
        this.eup.aKc();
        com.baidu.tieba.a.d.VM().onPageEnd("page_recommend");
    }

    private void aKV() {
        if (c.O(getBaseFragmentActivity()) && this.eup != null) {
            this.eup.aLc();
        }
    }

    public void aaW() {
        this.eup.setViewForeground(true);
    }

    public void aKW() {
        this.eup.aKW();
    }

    public void completePullRefresh() {
        this.eup.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eup.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.euq = bVar;
        this.eup.setCallback(bVar);
    }

    public void ag(String str, int i) {
        this.eup.ag(str, i);
    }

    public void aKK() {
        this.eup.aKK();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.eup.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKX() {
        com.baidu.tbadk.BdToken.c.vu().bX(com.baidu.tbadk.BdToken.b.ajQ);
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaA() {
        this.eup.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dIc == null) {
            this.dIc = VoiceManager.instance();
        }
        return this.dIc;
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaB() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaC() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(v.d(arrayList, arrayList.size() - 1))) {
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
        this.eup.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void Fj() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKY() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}
