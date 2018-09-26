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
/* loaded from: classes2.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ah {
    private VoiceManager dsk;
    private PersonalizePageView eeh;
    private com.baidu.tieba.homepage.framework.b eei;
    private boolean dZX = false;
    private CustomMessageListener eej = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.aGq();
            }
        }
    };
    private final CustomMessageListener eek = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.eeh != null) {
                PersonalizeFragment.this.eeh.f(l);
            }
        }
    };
    private final CustomMessageListener cOD = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.eeh.aGs();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.eeh = new PersonalizePageView(context);
        this.eeh.aAw();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.eeh.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.eeh.getParent()).removeView(this.eeh);
            if (this.eei != null) {
                this.eeh.setCallback(this.eei);
            }
        }
        this.eeh.setPageUniqueId(getUniqueId());
        if (this.dZX) {
            this.eeh.aAw();
            this.dZX = false;
        }
        return this.eeh;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dsk = getVoiceManager();
        if (this.dsk != null) {
            this.dsk.onCreate(getPageContext());
        }
        this.eej.setTag(getUniqueId());
        registerListener(this.eej);
        registerListener(this.eek);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.eeh.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.eeh != null) {
            this.eeh.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.eeh != null) {
            this.eeh.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dsk != null) {
            this.dsk.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dsk != null) {
            this.dsk.onResume(getPageContext());
        }
        this.eeh.onResume();
        this.eeh.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cOD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eeh != null) {
            this.eeh.aFv();
            this.eeh.onPause();
            this.eeh.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.cOD);
        if (this.dsk != null) {
            this.dsk.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dsk != null) {
            this.dsk.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dsk != null) {
            this.dsk.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.eej);
        MessageManager.getInstance().unRegisterListener(this.eek);
        this.dsk = null;
        this.eeh.onDestroy();
        this.dZX = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.eeh.setViewForeground();
            aGo();
            aGq();
            com.baidu.tieba.a.d.SB().onPageStart("page_recommend");
            return;
        }
        this.eeh.aFv();
        com.baidu.tieba.a.d.SB().onPageEnd("page_recommend");
    }

    private void aGo() {
        if (c.G(getBaseFragmentActivity()) && this.eeh != null) {
            this.eeh.aGu();
        }
    }

    public void VY() {
        this.eeh.setViewForeground(true);
    }

    public void aGp() {
        this.eeh.aGp();
    }

    public void completePullRefresh() {
        this.eeh.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eeh.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.eei = bVar;
        this.eeh.setCallback(bVar);
    }

    public void ab(String str, int i) {
        this.eeh.ab(str, i);
    }

    public void aGd() {
        this.eeh.aGd();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.eeh.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.ah
    public void VC() {
        this.eeh.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dsk == null) {
            this.dsk = VoiceManager.instance();
        }
        return this.dsk;
    }

    @Override // com.baidu.tieba.frs.ah
    public void VD() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void VE() {
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
        this.eeh.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void BQ() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGq() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}
