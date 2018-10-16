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
    private VoiceManager dAm;
    private PersonalizePageView elZ;
    private com.baidu.tieba.homepage.framework.b ema;
    private boolean ehQ = false;
    private CustomMessageListener emb = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.aJI();
            }
        }
    };
    private final CustomMessageListener emc = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.elZ != null) {
                PersonalizeFragment.this.elZ.f(l);
            }
        }
    };
    private final CustomMessageListener cWU = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.elZ.aJK();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.elZ = new PersonalizePageView(context);
        this.elZ.aDP();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.elZ.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.elZ.getParent()).removeView(this.elZ);
            if (this.ema != null) {
                this.elZ.setCallback(this.ema);
            }
        }
        this.elZ.setPageUniqueId(getUniqueId());
        if (this.ehQ) {
            this.elZ.aDP();
            this.ehQ = false;
        }
        return this.elZ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onCreate(getPageContext());
        }
        this.emb.setTag(getUniqueId());
        registerListener(this.emb);
        registerListener(this.emc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.elZ.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.elZ != null) {
            this.elZ.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.elZ != null) {
            this.elZ.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dAm != null) {
            this.dAm.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dAm != null) {
            this.dAm.onResume(getPageContext());
        }
        this.elZ.onResume();
        this.elZ.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cWU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.elZ != null) {
            this.elZ.aIN();
            this.elZ.onPause();
            this.elZ.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.cWU);
        if (this.dAm != null) {
            this.dAm.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dAm != null) {
            this.dAm.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dAm != null) {
            this.dAm.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.emb);
        MessageManager.getInstance().unRegisterListener(this.emc);
        this.dAm = null;
        this.elZ.onDestroy();
        this.ehQ = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.elZ.setViewForeground();
            aJG();
            aJI();
            com.baidu.tieba.a.d.Ux().onPageStart("page_recommend");
            return;
        }
        this.elZ.aIN();
        com.baidu.tieba.a.d.Ux().onPageEnd("page_recommend");
    }

    private void aJG() {
        if (c.I(getBaseFragmentActivity()) && this.elZ != null) {
            this.elZ.aJM();
        }
    }

    public void ZF() {
        this.elZ.setViewForeground(true);
    }

    public void aJH() {
        this.elZ.aJH();
    }

    public void completePullRefresh() {
        this.elZ.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.elZ.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.ema = bVar;
        this.elZ.setCallback(bVar);
    }

    public void af(String str, int i) {
        this.elZ.af(str, i);
    }

    public void aJv() {
        this.elZ.aJv();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.elZ.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zj() {
        this.elZ.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dAm == null) {
            this.dAm = VoiceManager.instance();
        }
        return this.dAm;
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zk() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zl() {
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
        this.elZ.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void DV() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJI() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}
