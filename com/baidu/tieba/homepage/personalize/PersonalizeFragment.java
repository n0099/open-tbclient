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
    private PersonalizePageView ema;
    private com.baidu.tieba.homepage.framework.b emb;
    private boolean ehR = false;
    private CustomMessageListener emc = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.aJI();
            }
        }
    };
    private final CustomMessageListener emd = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.ema != null) {
                PersonalizeFragment.this.ema.f(l);
            }
        }
    };
    private final CustomMessageListener cWU = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.ema.aJK();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.ema = new PersonalizePageView(context);
        this.ema.aDQ();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.ema.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ema.getParent()).removeView(this.ema);
            if (this.emb != null) {
                this.ema.setCallback(this.emb);
            }
        }
        this.ema.setPageUniqueId(getUniqueId());
        if (this.ehR) {
            this.ema.aDQ();
            this.ehR = false;
        }
        return this.ema;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onCreate(getPageContext());
        }
        this.emc.setTag(getUniqueId());
        registerListener(this.emc);
        registerListener(this.emd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.ema.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.ema != null) {
            this.ema.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.ema != null) {
            this.ema.showFloatingView();
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
        this.ema.onResume();
        this.ema.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cWU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ema != null) {
            this.ema.aIN();
            this.ema.onPause();
            this.ema.setTabInForeBackgroundState(true);
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
        MessageManager.getInstance().unRegisterListener(this.emc);
        MessageManager.getInstance().unRegisterListener(this.emd);
        this.dAm = null;
        this.ema.onDestroy();
        this.ehR = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.ema.setViewForeground();
            aJG();
            aJI();
            com.baidu.tieba.a.d.Ux().onPageStart("page_recommend");
            return;
        }
        this.ema.aIN();
        com.baidu.tieba.a.d.Ux().onPageEnd("page_recommend");
    }

    private void aJG() {
        if (c.I(getBaseFragmentActivity()) && this.ema != null) {
            this.ema.aJM();
        }
    }

    public void ZG() {
        this.ema.setViewForeground(true);
    }

    public void aJH() {
        this.ema.aJH();
    }

    public void completePullRefresh() {
        this.ema.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ema.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.emb = bVar;
        this.ema.setCallback(bVar);
    }

    public void af(String str, int i) {
        this.ema.af(str, i);
    }

    public void aJv() {
        this.ema.aJv();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.ema.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zk() {
        this.ema.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dAm == null) {
            this.dAm = VoiceManager.instance();
        }
        return this.dAm;
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zl() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zm() {
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
        this.ema.onChangeSkinType(i);
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
