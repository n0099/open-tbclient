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
    private VoiceManager dBD;
    private PersonalizePageView enu;
    private com.baidu.tieba.homepage.framework.b env;
    private boolean ejl = false;
    private CustomMessageListener enw = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.aJg();
            }
        }
    };
    private final CustomMessageListener enx = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.enu != null) {
                PersonalizeFragment.this.enu.g(l);
            }
        }
    };
    private final CustomMessageListener cYa = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.enu.aJi();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.enu = new PersonalizePageView(context);
        this.enu.aDk();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.enu.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.enu.getParent()).removeView(this.enu);
            if (this.env != null) {
                this.enu.setCallback(this.env);
            }
        }
        this.enu.setPageUniqueId(getUniqueId());
        if (this.ejl) {
            this.enu.aDk();
            this.ejl = false;
        }
        return this.enu;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onCreate(getPageContext());
        }
        this.enw.setTag(getUniqueId());
        registerListener(this.enw);
        registerListener(this.enx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.enu.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.enu != null) {
            this.enu.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.enu != null) {
            this.enu.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dBD != null) {
            this.dBD.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dBD != null) {
            this.dBD.onResume(getPageContext());
        }
        this.enu.onResume();
        this.enu.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cYa);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.enu != null) {
            this.enu.aIl();
            this.enu.onPause();
            this.enu.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.cYa);
        if (this.dBD != null) {
            this.dBD.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dBD != null) {
            this.dBD.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dBD != null) {
            this.dBD.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.enw);
        MessageManager.getInstance().unRegisterListener(this.enx);
        this.dBD = null;
        this.enu.onDestroy();
        this.ejl = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.enu.setViewForeground();
            aJe();
            aJg();
            com.baidu.tieba.a.d.UG().onPageStart("page_recommend");
            return;
        }
        this.enu.aIl();
        com.baidu.tieba.a.d.UG().onPageEnd("page_recommend");
    }

    private void aJe() {
        if (c.L(getBaseFragmentActivity()) && this.enu != null) {
            this.enu.aJk();
        }
    }

    public void ZQ() {
        this.enu.setViewForeground(true);
    }

    public void aJf() {
        this.enu.aJf();
    }

    public void completePullRefresh() {
        this.enu.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.enu.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.env = bVar;
        this.enu.setCallback(bVar);
    }

    public void af(String str, int i) {
        this.enu.af(str, i);
    }

    public void aIT() {
        this.enu.aIT();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.enu.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zu() {
        this.enu.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dBD == null) {
            this.dBD = VoiceManager.instance();
        }
        return this.dBD;
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zv() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zw() {
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
        this.enu.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void Ef() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJg() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}
