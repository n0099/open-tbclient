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
    private VoiceManager foO;
    private PersonalizePageView gbm;
    private com.baidu.tieba.homepage.framework.b gbn;
    private boolean fWR = false;
    private CustomMessageListener gbo = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.btO();
            }
        }
    };
    private final CustomMessageListener gbp = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.gbm != null) {
                PersonalizeFragment.this.gbm.d(l);
            }
        }
    };
    private final CustomMessageListener bxW = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.gbm.btQ();
            }
        }
    };
    private final CustomMessageListener fqh = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.btN();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.gbm = new PersonalizePageView(context);
        this.gbm.bnP();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.clt().u(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.gbm.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gbm.getParent()).removeView(this.gbm);
            if (this.gbn != null) {
                this.gbm.setCallback(this.gbn);
            }
        }
        this.gbm.setPageUniqueId(getUniqueId());
        if (this.fWR) {
            this.gbm.bnP();
            this.fWR = false;
        }
        return this.gbm;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.foO = getVoiceManager();
        if (this.foO != null) {
            this.foO.onCreate(getPageContext());
        }
        this.gbo.setTag(getUniqueId());
        registerListener(this.gbo);
        registerListener(this.gbp);
        registerListener(this.fqh);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.gbm != null) {
            this.gbm.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.gbm != null) {
            this.gbm.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.foO != null) {
            this.foO.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.abp().dC(true);
        if (this.foO != null) {
            this.foO.onResume(getPageContext());
        }
        this.gbm.onResume();
        this.gbm.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.bxW);
        btN();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gbm != null) {
            this.gbm.bsN();
            this.gbm.onPause();
            this.gbm.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.bxW);
        if (this.foO != null) {
            this.foO.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.Yk().Yp();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.clt().b(getUniqueId(), false);
        if (this.foO != null) {
            this.foO.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.foO != null) {
            this.foO.onDestory(getPageContext());
        }
        com.baidu.tieba.q.c.clt().v(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gbo);
        MessageManager.getInstance().unRegisterListener(this.gbp);
        MessageManager.getInstance().unRegisterListener(this.fqh);
        this.foO = null;
        this.gbm.onDestroy();
        this.fWR = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.gbm.setViewForeground();
            btL();
            btO();
            com.baidu.tieba.a.d.aBn().onPageStart("page_recommend");
            return;
        }
        this.gbm.bsN();
        com.baidu.tieba.a.d.aBn().onPageEnd("page_recommend");
    }

    private void btL() {
        if (c.an(getBaseFragmentActivity()) && this.gbm != null) {
            this.gbm.btR();
        }
    }

    public void aID() {
        this.gbm.setViewForeground(true);
    }

    public void btM() {
        this.gbm.btM();
    }

    public void completePullRefresh() {
        this.gbm.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gbm != null) {
            this.gbm.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.gbn = bVar;
        this.gbm.setCallback(bVar);
    }

    public void ay(String str, int i) {
        this.gbm.ay(str, i);
    }

    public void btt() {
        this.gbm.btt();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.gbm.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btN() {
        com.baidu.tbadk.BdToken.c.Yk().gj(com.baidu.tbadk.BdToken.b.bwY);
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHI() {
        this.gbm.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.foO == null) {
            this.foO = VoiceManager.instance();
        }
        return this.foO;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHJ() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHK() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
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

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
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
        this.gbm.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void ajG() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btO() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }
}
