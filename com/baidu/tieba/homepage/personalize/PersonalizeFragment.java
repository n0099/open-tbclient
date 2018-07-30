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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ah {
    private PersonalizePageView dWS;
    private com.baidu.tieba.homepage.framework.b dWT;
    private VoiceManager dmp;
    private boolean dSL = false;
    private CustomMessageListener dWU = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.aEf();
            }
        }
    };
    private final CustomMessageListener dWV = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.dWS != null) {
                PersonalizeFragment.this.dWS.e(l);
            }
        }
    };
    private final CustomMessageListener cIP = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.dWS.aEh();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.dWS = new PersonalizePageView(context);
        this.dWS.ayj();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dWS.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dWS.getParent()).removeView(this.dWS);
            if (this.dWT != null) {
                this.dWS.setCallback(this.dWT);
            }
        }
        this.dWS.setPageUniqueId(getUniqueId());
        if (this.dSL) {
            this.dWS.ayj();
            this.dSL = false;
        }
        return this.dWS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dmp = getVoiceManager();
        if (this.dmp != null) {
            this.dmp.onCreate(getPageContext());
        }
        this.dWU.setTag(getUniqueId());
        registerListener(this.dWU);
        registerListener(this.dWV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dWS.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dWS != null) {
            this.dWS.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.dWS != null) {
            this.dWS.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dmp != null) {
            this.dmp.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dmp != null) {
            this.dmp.onResume(getPageContext());
        }
        this.dWS.onResume();
        this.dWS.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cIP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dWS != null) {
            this.dWS.aDl();
            this.dWS.onPause();
            this.dWS.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.cIP);
        if (this.dmp != null) {
            this.dmp.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dmp != null) {
            this.dmp.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dmp != null) {
            this.dmp.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dWU);
        MessageManager.getInstance().unRegisterListener(this.dWV);
        this.dmp = null;
        this.dWS.onDestroy();
        this.dSL = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.dWS.setViewForeground();
            aEf();
            com.baidu.tieba.a.d.QI().onPageStart("page_recommend");
            return;
        }
        this.dWS.aDl();
        com.baidu.tieba.a.d.QI().onPageEnd("page_recommend");
    }

    public void Ui() {
        this.dWS.setViewForeground(true);
    }

    public void aEe() {
        this.dWS.aEe();
    }

    public void completePullRefresh() {
        this.dWS.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dWS.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dWT = bVar;
        this.dWS.setCallback(bVar);
    }

    public void W(String str, int i) {
        this.dWS.W(str, i);
    }

    public void aDT() {
        this.dWS.aDT();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.dWS.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.ah
    public void TM() {
        this.dWS.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dmp == null) {
            this.dmp = VoiceManager.instance();
        }
        return this.dmp;
    }

    @Override // com.baidu.tieba.frs.ah
    public void TN() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void TO() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(w.d(arrayList, arrayList.size() - 1))) {
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
        this.dWS.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void AG() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEf() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}
