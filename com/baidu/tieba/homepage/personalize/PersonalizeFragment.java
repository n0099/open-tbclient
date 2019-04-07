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
import com.baidu.tbadk.util.x;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ae {
    private VoiceManager eYD;
    private PersonalizePageView fKd;
    private com.baidu.tieba.homepage.framework.b fKe;
    private boolean fFO = false;
    private CustomMessageListener fKf = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.bmm();
            }
        }
    };
    private final CustomMessageListener fKg = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.fKd != null) {
                PersonalizeFragment.this.fKd.f(l);
            }
        }
    };
    private final CustomMessageListener erW = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.fKd.bmo();
            }
        }
    };
    private final CustomMessageListener brs = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.bml();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.fKd = new PersonalizePageView(context);
        this.fKd.bgy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cdp().s(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.fKd.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.fKd.getParent()).removeView(this.fKd);
            if (this.fKe != null) {
                this.fKd.setCallback(this.fKe);
            }
        }
        this.fKd.setPageUniqueId(getUniqueId());
        if (this.fFO) {
            this.fKd.bgy();
            this.fFO = false;
        }
        return this.fKd;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eYD = getVoiceManager();
        if (this.eYD != null) {
            this.eYD.onCreate(getPageContext());
        }
        this.fKf.setTag(getUniqueId());
        registerListener(this.fKf);
        registerListener(this.fKg);
        registerListener(this.brs);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ae
    public void setHeaderViewHeight(int i) {
        this.fKd.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.fKd != null) {
            this.fKd.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.fKd != null) {
            this.fKd.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.eYD != null) {
            this.eYD.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.WJ().dh(true);
        if (this.eYD != null) {
            this.eYD.onResume(getPageContext());
        }
        this.fKd.onResume();
        this.fKd.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.erW);
        bml();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fKd != null) {
            this.fKd.blq();
            this.fKd.onPause();
            this.fKd.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.erW);
        if (this.eYD != null) {
            this.eYD.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.TX().TY();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.cdp().b(getUniqueId(), false);
        if (this.eYD != null) {
            this.eYD.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eYD != null) {
            this.eYD.onDestory(getPageContext());
        }
        com.baidu.tieba.q.c.cdp().t(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.fKf);
        MessageManager.getInstance().unRegisterListener(this.fKg);
        MessageManager.getInstance().unRegisterListener(this.brs);
        this.eYD = null;
        this.fKd.onDestroy();
        this.fFO = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.fKd.setViewForeground();
            bmj();
            bmm();
            com.baidu.tieba.a.d.awh().onPageStart("page_recommend");
            return;
        }
        this.fKd.blq();
        com.baidu.tieba.a.d.awh().onPageEnd("page_recommend");
    }

    private void bmj() {
        if (c.ak(getBaseFragmentActivity()) && this.fKd != null) {
            this.fKd.bmq();
        }
    }

    public void aCq() {
        this.fKd.setViewForeground(true);
    }

    public void bmk() {
        this.fKd.bmk();
    }

    public void completePullRefresh() {
        this.fKd.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.fKd != null) {
            this.fKd.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.fKe = bVar;
        this.fKd.setCallback(bVar);
    }

    public void aC(String str, int i) {
        this.fKd.aC(str, i);
    }

    public void blW() {
        this.fKd.blW();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.fKd.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bml() {
        com.baidu.tbadk.BdToken.c.TX().fy(com.baidu.tbadk.BdToken.b.bqI);
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBr() {
        this.fKd.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYD == null) {
            this.eYD = VoiceManager.instance();
        }
        return this.eYD;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBs() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBt() {
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
        this.fKd.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void aeH() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmm() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }
}
