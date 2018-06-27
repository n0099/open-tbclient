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
import com.baidu.tbadk.util.t;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ah {
    private PersonalizePageView dTb;
    private com.baidu.tieba.homepage.framework.b dTc;
    private VoiceManager djz;
    private boolean dPY = false;
    private CustomMessageListener dTd = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.aDf();
            }
        }
    };
    private final CustomMessageListener dTe = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.dTb != null) {
                PersonalizeFragment.this.dTb.f(l);
            }
        }
    };
    private final CustomMessageListener cGi = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.dTb.aDh();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.dTb = new PersonalizePageView(context);
        this.dTb.axE();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dTb.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dTb.getParent()).removeView(this.dTb);
            if (this.dTc != null) {
                this.dTb.setCallback(this.dTc);
            }
        }
        this.dTb.setPageUniqueId(getUniqueId());
        if (this.dPY) {
            this.dTb.axE();
            this.dPY = false;
        }
        return this.dTb;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.djz = getVoiceManager();
        if (this.djz != null) {
            this.djz.onCreate(getPageContext());
        }
        this.dTd.setTag(getUniqueId());
        registerListener(this.dTd);
        registerListener(this.dTe);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dTb.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        if (this.dTb != null) {
            this.dTb.setRecommendFrsNavigationAnimDispatcher(tVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.dTb != null) {
            this.dTb.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.djz != null) {
            this.djz.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.djz != null) {
            this.djz.onResume(getPageContext());
        }
        this.dTb.onResume();
        this.dTb.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cGi);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dTb != null) {
            this.dTb.aCD();
            this.dTb.onPause();
            this.dTb.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.cGi);
        if (this.djz != null) {
            this.djz.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.djz != null) {
            this.djz.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.djz != null) {
            this.djz.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dTd);
        MessageManager.getInstance().unRegisterListener(this.dTe);
        this.djz = null;
        this.dTb.onDestroy();
        this.dPY = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.dTb.setViewForeground();
            aDf();
            com.baidu.tieba.a.d.QB().onPageStart("page_recommend");
            return;
        }
        this.dTb.aCD();
        com.baidu.tieba.a.d.QB().onPageEnd("page_recommend");
    }

    public void Ua() {
        this.dTb.setViewForeground(true);
    }

    public void aDe() {
        this.dTb.aDe();
    }

    public void completePullRefresh() {
        this.dTb.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dTb.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dTc = bVar;
        this.dTb.setCallback(bVar);
    }

    public void aa(String str, int i) {
        this.dTb.aa(str, i);
    }

    public void aCx() {
        this.dTb.aCx();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.dTb.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.ah
    public void TE() {
        this.dTb.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.djz == null) {
            this.djz = VoiceManager.instance();
        }
        return this.djz;
    }

    @Override // com.baidu.tieba.frs.ah
    public void TF() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void TG() {
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
        this.dTb.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void AP() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDf() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}
