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
import com.baidu.tbadk.util.x;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ae {
    private VoiceManager eYS;
    private PersonalizePageView fKq;
    private com.baidu.tieba.homepage.framework.b fKr;
    private boolean fGb = false;
    private CustomMessageListener fKs = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.bmq();
            }
        }
    };
    private final CustomMessageListener fKt = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.fKq != null) {
                PersonalizeFragment.this.fKq.f(l);
            }
        }
    };
    private final CustomMessageListener eso = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.fKq.bms();
            }
        }
    };
    private final CustomMessageListener bro = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.bmp();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.fKq = new PersonalizePageView(context);
        this.fKq.bgB();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cdr().s(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.fKq.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.fKq.getParent()).removeView(this.fKq);
            if (this.fKr != null) {
                this.fKq.setCallback(this.fKr);
            }
        }
        this.fKq.setPageUniqueId(getUniqueId());
        if (this.fGb) {
            this.fKq.bgB();
            this.fGb = false;
        }
        return this.fKq;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eYS = getVoiceManager();
        if (this.eYS != null) {
            this.eYS.onCreate(getPageContext());
        }
        this.fKs.setTag(getUniqueId());
        registerListener(this.fKs);
        registerListener(this.fKt);
        registerListener(this.bro);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ae
    public void setHeaderViewHeight(int i) {
        this.fKq.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.fKq != null) {
            this.fKq.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.fKq != null) {
            this.fKq.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.eYS != null) {
            this.eYS.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.WM().dh(true);
        if (this.eYS != null) {
            this.eYS.onResume(getPageContext());
        }
        this.fKq.onResume();
        this.fKq.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.eso);
        bmp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fKq != null) {
            this.fKq.blu();
            this.fKq.onPause();
            this.fKq.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.eso);
        if (this.eYS != null) {
            this.eYS.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.TZ().Ua();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.cdr().b(getUniqueId(), false);
        if (this.eYS != null) {
            this.eYS.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eYS != null) {
            this.eYS.onDestory(getPageContext());
        }
        com.baidu.tieba.q.c.cdr().t(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.fKs);
        MessageManager.getInstance().unRegisterListener(this.fKt);
        MessageManager.getInstance().unRegisterListener(this.bro);
        this.eYS = null;
        this.fKq.onDestroy();
        this.fGb = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.fKq.setViewForeground();
            bmn();
            bmq();
            com.baidu.tieba.a.d.awl().onPageStart("page_recommend");
            return;
        }
        this.fKq.blu();
        com.baidu.tieba.a.d.awl().onPageEnd("page_recommend");
    }

    private void bmn() {
        if (c.ak(getBaseFragmentActivity()) && this.fKq != null) {
            this.fKq.bmu();
        }
    }

    public void aCu() {
        this.fKq.setViewForeground(true);
    }

    public void bmo() {
        this.fKq.bmo();
    }

    public void completePullRefresh() {
        this.fKq.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.fKq != null) {
            this.fKq.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.fKr = bVar;
        this.fKq.setCallback(bVar);
    }

    public void aC(String str, int i) {
        this.fKq.aC(str, i);
    }

    public void bma() {
        this.fKq.bma();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.fKq.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmp() {
        com.baidu.tbadk.BdToken.c.TZ().fz(com.baidu.tbadk.BdToken.b.bqE);
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBv() {
        this.fKq.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYS == null) {
            this.eYS = VoiceManager.instance();
        }
        return this.eYS;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBw() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBx() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
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
        this.fKq.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void aeK() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmq() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }
}
