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
    private PersonalizePageView dWP;
    private com.baidu.tieba.homepage.framework.b dWQ;
    private VoiceManager dmn;
    private boolean dSG = false;
    private CustomMessageListener dWR = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.aEc();
            }
        }
    };
    private final CustomMessageListener dWS = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.dWP != null) {
                PersonalizeFragment.this.dWP.e(l);
            }
        }
    };
    private final CustomMessageListener cIM = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.dWP.aEe();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.dWP = new PersonalizePageView(context);
        this.dWP.ayh();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dWP.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dWP.getParent()).removeView(this.dWP);
            if (this.dWQ != null) {
                this.dWP.setCallback(this.dWQ);
            }
        }
        this.dWP.setPageUniqueId(getUniqueId());
        if (this.dSG) {
            this.dWP.ayh();
            this.dSG = false;
        }
        return this.dWP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onCreate(getPageContext());
        }
        this.dWR.setTag(getUniqueId());
        registerListener(this.dWR);
        registerListener(this.dWS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dWP.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dWP != null) {
            this.dWP.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.dWP != null) {
            this.dWP.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dmn != null) {
            this.dmn.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dmn != null) {
            this.dmn.onResume(getPageContext());
        }
        this.dWP.onResume();
        this.dWP.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cIM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dWP != null) {
            this.dWP.aDi();
            this.dWP.onPause();
            this.dWP.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.cIM);
        if (this.dmn != null) {
            this.dmn.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dmn != null) {
            this.dmn.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dmn != null) {
            this.dmn.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dWR);
        MessageManager.getInstance().unRegisterListener(this.dWS);
        this.dmn = null;
        this.dWP.onDestroy();
        this.dSG = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.dWP.setViewForeground();
            aEc();
            com.baidu.tieba.a.d.QN().onPageStart("page_recommend");
            return;
        }
        this.dWP.aDi();
        com.baidu.tieba.a.d.QN().onPageEnd("page_recommend");
    }

    public void Ul() {
        this.dWP.setViewForeground(true);
    }

    public void aEb() {
        this.dWP.aEb();
    }

    public void completePullRefresh() {
        this.dWP.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dWP.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dWQ = bVar;
        this.dWP.setCallback(bVar);
    }

    public void W(String str, int i) {
        this.dWP.W(str, i);
    }

    public void aDQ() {
        this.dWP.aDQ();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.dWP.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.ah
    public void TP() {
        this.dWP.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dmn == null) {
            this.dmn = VoiceManager.instance();
        }
        return this.dmn;
    }

    @Override // com.baidu.tieba.frs.ah
    public void TQ() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void TR() {
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
        this.dWP.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void AD() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEc() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}
