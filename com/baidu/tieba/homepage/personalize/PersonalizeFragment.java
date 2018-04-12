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
import com.baidu.tbadk.util.s;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, af {
    private VoiceManager cXj;
    private PersonalizePageView dDv;
    private com.baidu.tieba.homepage.framework.b dDw;
    private boolean dAu = false;
    private CustomMessageListener dDx = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.axG();
            }
        }
    };
    private final CustomMessageListener dDy = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.dDv != null) {
                PersonalizeFragment.this.dDv.e(l);
            }
        }
    };
    private final CustomMessageListener cHI = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.dDv.axH();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.dDv = new PersonalizePageView(context);
        this.dDv.asV();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dDv.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dDv.getParent()).removeView(this.dDv);
            if (this.dDw != null) {
                this.dDv.setCallback(this.dDw);
            }
        }
        this.dDv.setPageUniqueId(getUniqueId());
        if (this.dAu) {
            this.dDv.asV();
            this.dAu = false;
        }
        return this.dDv;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cXj = getVoiceManager();
        if (this.cXj != null) {
            this.cXj.onCreate(getPageContext());
        }
        this.dDx.setTag(getUniqueId());
        registerListener(this.dDx);
        registerListener(this.dDy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.af
    public void setHeaderViewHeight(int i) {
        this.dDv.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dDv != null) {
            this.dDv.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
        if (this.dDv != null) {
            this.dDv.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cXj != null) {
            this.cXj.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cXj != null) {
            this.cXj.onResume(getPageContext());
        }
        this.dDv.onResume();
        this.dDv.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cHI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dDv != null) {
            this.dDv.axg();
            this.dDv.onPause();
            this.dDv.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.cHI);
        if (this.cXj != null) {
            this.cXj.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cXj != null) {
            this.cXj.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cXj != null) {
            this.cXj.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dDx);
        MessageManager.getInstance().unRegisterListener(this.dDy);
        this.cXj = null;
        this.dDv.onDestroy();
        this.dAu = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.dDv.setViewForeground();
            axG();
            com.baidu.tieba.a.d.MH().onPageStart("page_recommend");
            return;
        }
        this.dDv.axg();
        com.baidu.tieba.a.d.MH().onPageEnd("page_recommend");
    }

    public void Ql() {
        this.dDv.setViewForeground(true);
    }

    public void axF() {
        this.dDv.axF();
    }

    public void completePullRefresh() {
        this.dDv.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dDv.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dDw = bVar;
        this.dDv.setCallback(bVar);
    }

    public void Y(String str, int i) {
        this.dDv.Y(str, i);
    }

    public void axa() {
        this.dDv.axa();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.dDv.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.af
    public void PP() {
        this.dDv.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cXj == null) {
            this.cXj = VoiceManager.instance();
        }
        return this.cXj;
    }

    @Override // com.baidu.tieba.frs.af
    public void PQ() {
    }

    @Override // com.baidu.tieba.frs.af
    public void PR() {
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
        this.dDv.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.af
    public void wY() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axG() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setVideoThreadId(String str) {
    }
}
