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
import com.baidu.adp.widget.ListView.p;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ae {
    private VoiceManager fvn;
    private PersonalizePageView gjL;
    private com.baidu.tieba.homepage.framework.b gjM;
    private boolean gdV = false;
    private CustomMessageListener gjN = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.buD();
            }
        }
    };
    private final CustomMessageListener gjO = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.gjL != null) {
                PersonalizeFragment.this.gjL.c(l);
            }
        }
    };
    private final CustomMessageListener bRR = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.gjL.buF();
            }
        }
    };
    private final CustomMessageListener fwG = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.buC();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.gjL = new PersonalizePageView(context);
        this.gjL.aNd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cnk().v(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.gjL.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gjL.getParent()).removeView(this.gjL);
            if (this.gjM != null) {
                this.gjL.setCallback(this.gjM);
            }
        }
        this.gjL.setPageUniqueId(getUniqueId());
        if (this.gdV) {
            this.gjL.aNd();
            this.gdV = false;
        }
        return this.gjL;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.fvn = getVoiceManager();
        if (this.fvn != null) {
            this.fvn.onCreate(getPageContext());
        }
        this.gjN.setTag(getUniqueId());
        registerListener(this.gjN);
        registerListener(this.gjO);
        registerListener(this.fwG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
        if (this.gjL != null) {
            this.gjL.setRecommendFrsNavigationAnimDispatcher(wVar);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.gjL != null) {
            this.gjL.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fvn != null) {
            this.fvn.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.agy().dW(true);
        if (this.fvn != null) {
            this.fvn.onResume(getPageContext());
        }
        this.gjL.onResume();
        this.gjL.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.bRR);
        buC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gjL != null) {
            this.gjL.bsZ();
            this.gjL.onPause();
            this.gjL.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.bRR);
        if (this.fvn != null) {
            this.fvn.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.adZ().aee();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.cnk().b(getUniqueId(), false);
        if (this.fvn != null) {
            this.fvn.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fvn != null) {
            this.fvn.onDestory(getPageContext());
        }
        com.baidu.tieba.q.c.cnk().w(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gjN);
        MessageManager.getInstance().unRegisterListener(this.gjO);
        MessageManager.getInstance().unRegisterListener(this.fwG);
        this.fvn = null;
        this.gjL.onDestroy();
        this.gdV = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.gjL.setViewForeground();
            buA();
            buD();
            com.baidu.tieba.a.d.aDe().onPageStart("page_recommend");
            return;
        }
        this.gjL.bsZ();
        com.baidu.tieba.a.d.aDe().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.qd(TbadkCoreApplication.getInst().getAdAdSense().cuL);
        }
        return pageStayDurationItem;
    }

    private void buA() {
        if (c.ai(getBaseFragmentActivity()) && this.gjL != null) {
            this.gjL.buG();
        }
    }

    public void aKh() {
        this.gjL.setViewForeground(true);
    }

    public void buB() {
        this.gjL.buB();
    }

    public void completePullRefresh() {
        this.gjL.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gjL != null) {
            this.gjL.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.gjM = bVar;
        this.gjL.setCallback(bVar);
    }

    public void aw(String str, int i) {
        this.gjL.aw(str, i);
    }

    public void btG() {
        this.gjL.btG();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.gjL.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buC() {
        com.baidu.tbadk.BdToken.c.adZ().hj(com.baidu.tbadk.BdToken.b.bQT);
    }

    @Override // com.baidu.tieba.frs.ae
    public void vU() {
        this.gjL.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fvn == null) {
            this.fvn = VoiceManager.instance();
        }
        return this.fvn;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJp() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJq() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(v.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gjL.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void anO() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buD() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(pVar);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }
}
