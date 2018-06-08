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
import com.baidu.tieba.frs.af;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, af {
    private PersonalizePageView dPJ;
    private com.baidu.tieba.homepage.framework.b dPK;
    private VoiceManager dhB;
    private boolean dMI = false;
    private CustomMessageListener dPL = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.aCB();
            }
        }
    };
    private final CustomMessageListener dPM = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.dPJ != null) {
                PersonalizeFragment.this.dPJ.f(l);
            }
        }
    };
    private final CustomMessageListener cIo = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.dPJ.aCC();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.dPJ = new PersonalizePageView(context);
        this.dPJ.axa();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dPJ.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dPJ.getParent()).removeView(this.dPJ);
            if (this.dPK != null) {
                this.dPJ.setCallback(this.dPK);
            }
        }
        this.dPJ.setPageUniqueId(getUniqueId());
        if (this.dMI) {
            this.dPJ.axa();
            this.dMI = false;
        }
        return this.dPJ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onCreate(getPageContext());
        }
        this.dPL.setTag(getUniqueId());
        registerListener(this.dPL);
        registerListener(this.dPM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.af
    public void setHeaderViewHeight(int i) {
        this.dPJ.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        if (this.dPJ != null) {
            this.dPJ.setRecommendFrsNavigationAnimDispatcher(tVar);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
        if (this.dPJ != null) {
            this.dPJ.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dhB != null) {
            this.dhB.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dhB != null) {
            this.dhB.onResume(getPageContext());
        }
        this.dPJ.onResume();
        this.dPJ.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cIo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dPJ != null) {
            this.dPJ.aBX();
            this.dPJ.onPause();
            this.dPJ.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.cIo);
        if (this.dhB != null) {
            this.dhB.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dhB != null) {
            this.dhB.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dhB != null) {
            this.dhB.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dPL);
        MessageManager.getInstance().unRegisterListener(this.dPM);
        this.dhB = null;
        this.dPJ.onDestroy();
        this.dMI = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.dPJ.setViewForeground();
            aCB();
            com.baidu.tieba.a.d.Qe().onPageStart("page_recommend");
            return;
        }
        this.dPJ.aBX();
        com.baidu.tieba.a.d.Qe().onPageEnd("page_recommend");
    }

    public void TG() {
        this.dPJ.setViewForeground(true);
    }

    public void aCA() {
        this.dPJ.aCA();
    }

    public void completePullRefresh() {
        this.dPJ.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dPJ.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dPK = bVar;
        this.dPJ.setCallback(bVar);
    }

    public void ab(String str, int i) {
        this.dPJ.ab(str, i);
    }

    public void aBR() {
        this.dPJ.aBR();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.dPJ.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.af
    public void Tk() {
        this.dPJ.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dhB == null) {
            this.dhB = VoiceManager.instance();
        }
        return this.dhB;
    }

    @Override // com.baidu.tieba.frs.af
    public void Tl() {
    }

    @Override // com.baidu.tieba.frs.af
    public void Tm() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(w.c(arrayList, arrayList.size() - 1))) {
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
        this.dPJ.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.af
    public void Ay() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCB() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setVideoThreadId(String str) {
    }
}
