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
    private VoiceManager eYR;
    private PersonalizePageView fKp;
    private com.baidu.tieba.homepage.framework.b fKq;
    private boolean fGa = false;
    private CustomMessageListener fKr = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.bmp();
            }
        }
    };
    private final CustomMessageListener fKs = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.fKp != null) {
                PersonalizeFragment.this.fKp.f(l);
            }
        }
    };
    private final CustomMessageListener esk = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.fKp.bmr();
            }
        }
    };
    private final CustomMessageListener brp = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.bmo();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.fKp = new PersonalizePageView(context);
        this.fKp.bgA();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cdt().s(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.fKp.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.fKp.getParent()).removeView(this.fKp);
            if (this.fKq != null) {
                this.fKp.setCallback(this.fKq);
            }
        }
        this.fKp.setPageUniqueId(getUniqueId());
        if (this.fGa) {
            this.fKp.bgA();
            this.fGa = false;
        }
        return this.fKp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eYR = getVoiceManager();
        if (this.eYR != null) {
            this.eYR.onCreate(getPageContext());
        }
        this.fKr.setTag(getUniqueId());
        registerListener(this.fKr);
        registerListener(this.fKs);
        registerListener(this.brp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ae
    public void setHeaderViewHeight(int i) {
        this.fKp.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.fKp != null) {
            this.fKp.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.fKp != null) {
            this.fKp.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.eYR != null) {
            this.eYR.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.WM().dh(true);
        if (this.eYR != null) {
            this.eYR.onResume(getPageContext());
        }
        this.fKp.onResume();
        this.fKp.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.esk);
        bmo();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fKp != null) {
            this.fKp.blt();
            this.fKp.onPause();
            this.fKp.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.esk);
        if (this.eYR != null) {
            this.eYR.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.TZ().Ua();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.cdt().b(getUniqueId(), false);
        if (this.eYR != null) {
            this.eYR.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eYR != null) {
            this.eYR.onDestory(getPageContext());
        }
        com.baidu.tieba.q.c.cdt().t(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.fKr);
        MessageManager.getInstance().unRegisterListener(this.fKs);
        MessageManager.getInstance().unRegisterListener(this.brp);
        this.eYR = null;
        this.fKp.onDestroy();
        this.fGa = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.fKp.setViewForeground();
            bmm();
            bmp();
            com.baidu.tieba.a.d.awk().onPageStart("page_recommend");
            return;
        }
        this.fKp.blt();
        com.baidu.tieba.a.d.awk().onPageEnd("page_recommend");
    }

    private void bmm() {
        if (c.ak(getBaseFragmentActivity()) && this.fKp != null) {
            this.fKp.bmt();
        }
    }

    public void aCt() {
        this.fKp.setViewForeground(true);
    }

    public void bmn() {
        this.fKp.bmn();
    }

    public void completePullRefresh() {
        this.fKp.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.fKp != null) {
            this.fKp.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.fKq = bVar;
        this.fKp.setCallback(bVar);
    }

    public void aC(String str, int i) {
        this.fKp.aC(str, i);
    }

    public void blZ() {
        this.fKp.blZ();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.fKp.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmo() {
        com.baidu.tbadk.BdToken.c.TZ().fz(com.baidu.tbadk.BdToken.b.bqF);
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBu() {
        this.fKp.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYR == null) {
            this.eYR = VoiceManager.instance();
        }
        return this.eYR;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBv() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBw() {
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
        this.fKp.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void aeK() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmp() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }
}
