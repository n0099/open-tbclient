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
    private VoiceManager cYn;
    private PersonalizePageView dEy;
    private com.baidu.tieba.homepage.framework.b dEz;
    private boolean dBy = false;
    private CustomMessageListener dEA = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.axE();
            }
        }
    };
    private final CustomMessageListener dEB = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.dEy != null) {
                PersonalizeFragment.this.dEy.e(l);
            }
        }
    };
    private final CustomMessageListener cIO = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.dEy.axF();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.dEy = new PersonalizePageView(context);
        this.dEy.asU();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dEy.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dEy.getParent()).removeView(this.dEy);
            if (this.dEz != null) {
                this.dEy.setCallback(this.dEz);
            }
        }
        this.dEy.setPageUniqueId(getUniqueId());
        if (this.dBy) {
            this.dEy.asU();
            this.dBy = false;
        }
        return this.dEy;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cYn = getVoiceManager();
        if (this.cYn != null) {
            this.cYn.onCreate(getPageContext());
        }
        this.dEA.setTag(getUniqueId());
        registerListener(this.dEA);
        registerListener(this.dEB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.af
    public void setHeaderViewHeight(int i) {
        this.dEy.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dEy != null) {
            this.dEy.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
        if (this.dEy != null) {
            this.dEy.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cYn != null) {
            this.cYn.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cYn != null) {
            this.cYn.onResume(getPageContext());
        }
        this.dEy.onResume();
        this.dEy.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cIO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dEy != null) {
            this.dEy.axf();
            this.dEy.onPause();
            this.dEy.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.cIO);
        if (this.cYn != null) {
            this.cYn.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cYn != null) {
            this.cYn.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cYn != null) {
            this.cYn.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dEA);
        MessageManager.getInstance().unRegisterListener(this.dEB);
        this.cYn = null;
        this.dEy.onDestroy();
        this.dBy = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.dEy.setViewForeground();
            axE();
            com.baidu.tieba.a.d.MF().onPageStart("page_recommend");
            return;
        }
        this.dEy.axf();
        com.baidu.tieba.a.d.MF().onPageEnd("page_recommend");
    }

    public void Qi() {
        this.dEy.setViewForeground(true);
    }

    public void axD() {
        this.dEy.axD();
    }

    public void completePullRefresh() {
        this.dEy.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dEy.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dEz = bVar;
        this.dEy.setCallback(bVar);
    }

    public void Y(String str, int i) {
        this.dEy.Y(str, i);
    }

    public void awZ() {
        this.dEy.awZ();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.dEy.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.af
    public void PM() {
        this.dEy.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cYn == null) {
            this.cYn = VoiceManager.instance();
        }
        return this.cYn;
    }

    @Override // com.baidu.tieba.frs.af
    public void PN() {
    }

    @Override // com.baidu.tieba.frs.af
    public void PO() {
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
        this.dEy.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.af
    public void wX() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axE() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setVideoThreadId(String str) {
    }
}
