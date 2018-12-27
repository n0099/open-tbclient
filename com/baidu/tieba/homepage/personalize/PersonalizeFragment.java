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
    private VoiceManager dKQ;
    private PersonalizePageView exf;
    private com.baidu.tieba.homepage.framework.b exg;
    private boolean esW = false;
    private CustomMessageListener exh = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.aLL();
            }
        }
    };
    private final CustomMessageListener exi = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.exf != null) {
                PersonalizeFragment.this.exf.g(l);
            }
        }
    };
    private final CustomMessageListener dhC = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.exf.aLN();
            }
        }
    };
    private final CustomMessageListener akA = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.aLK();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.exf = new PersonalizePageView(context);
        this.exf.aFL();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.bBT().r(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.exf.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.exf.getParent()).removeView(this.exf);
            if (this.exg != null) {
                this.exf.setCallback(this.exg);
            }
        }
        this.exf.setPageUniqueId(getUniqueId());
        if (this.esW) {
            this.exf.aFL();
            this.esW = false;
        }
        return this.exf;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dKQ = getVoiceManager();
        if (this.dKQ != null) {
            this.dKQ.onCreate(getPageContext());
        }
        this.exh.setTag(getUniqueId());
        registerListener(this.exh);
        registerListener(this.exi);
        registerListener(this.akA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.exf.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.exf != null) {
            this.exf.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.exf != null) {
            this.exf.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dKQ != null) {
            this.dKQ.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.xS().aX(true);
        if (this.dKQ != null) {
            this.dKQ.onResume(getPageContext());
        }
        this.exf.onResume();
        this.exf.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.dhC);
        aLK();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.exf != null) {
            this.exf.aKR();
            this.exf.onPause();
            this.exf.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.dhC);
        if (this.dKQ != null) {
            this.dKQ.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.vu().vv();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.bBT().b(getUniqueId(), false);
        if (this.dKQ != null) {
            this.dKQ.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dKQ != null) {
            this.dKQ.onDestory(getPageContext());
        }
        com.baidu.tieba.q.c.bBT().s(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.exh);
        MessageManager.getInstance().unRegisterListener(this.exi);
        MessageManager.getInstance().unRegisterListener(this.akA);
        this.dKQ = null;
        this.exf.onDestroy();
        this.esW = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.exf.setViewForeground();
            aLI();
            aLL();
            com.baidu.tieba.a.d.VO().onPageStart("page_recommend");
            return;
        }
        this.exf.aKR();
        com.baidu.tieba.a.d.VO().onPageEnd("page_recommend");
    }

    private void aLI() {
        if (c.O(getBaseFragmentActivity()) && this.exf != null) {
            this.exf.aLP();
        }
    }

    public void aaY() {
        this.exf.setViewForeground(true);
    }

    public void aLJ() {
        this.exf.aLJ();
    }

    public void completePullRefresh() {
        this.exf.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.exf.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.exg = bVar;
        this.exf.setCallback(bVar);
    }

    public void ah(String str, int i) {
        this.exf.ah(str, i);
    }

    public void aLy() {
        this.exf.aLy();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.exf.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLK() {
        com.baidu.tbadk.BdToken.c.vu().bX(com.baidu.tbadk.BdToken.b.ajQ);
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaC() {
        this.exf.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dKQ == null) {
            this.dKQ = VoiceManager.instance();
        }
        return this.dKQ;
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaD() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaE() {
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
        this.exf.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void Fj() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLL() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}
