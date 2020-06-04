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
import com.baidu.adp.widget.ListView.r;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, aj {
    private VoiceManager hns;
    private PersonalizePageView icq;
    private com.baidu.tieba.homepage.framework.b icr;
    private boolean hXy = false;
    private CustomMessageListener ics = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.cfU();
            }
        }
    };
    private final CustomMessageListener ict = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.icq != null) {
                PersonalizeFragment.this.icq.e(l);
            }
        }
    };
    private final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.icq.cfW();
            }
        }
    };
    private final CustomMessageListener hoG = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.cfT();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.icq = new PersonalizePageView(context);
        this.icq.bwC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dcI().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.icq.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.icq.getParent()).removeView(this.icq);
            if (this.icr != null) {
                this.icq.setCallback(this.icr);
            }
        }
        this.icq.setPageUniqueId(getUniqueId());
        if (this.hXy) {
            this.icq.bwC();
            this.hXy = false;
        }
        return this.icq;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hns = getVoiceManager();
        if (this.hns != null) {
            this.hns.onCreate(getPageContext());
        }
        this.ics.setTag(getUniqueId());
        registerListener(this.ics);
        registerListener(this.ict);
        registerListener(this.hoG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.icq != null) {
            this.icq.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.icq != null) {
            this.icq.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hns != null) {
            this.hns.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.aNY().gJ(true);
        if (this.hns != null) {
            this.hns.onResume(getPageContext());
        }
        this.icq.onResume();
        this.icq.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        cfT();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.icq != null) {
            this.icq.ceA();
            this.icq.onPause();
            this.icq.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        if (this.hns != null) {
            this.hns.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.aLi().aLn();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dcI().b(getUniqueId(), false);
        if (this.hns != null) {
            this.hns.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hns != null) {
            this.hns.onDestory(getPageContext());
        }
        com.baidu.tieba.s.c.dcI().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.ics);
        MessageManager.getInstance().unRegisterListener(this.ict);
        MessageManager.getInstance().unRegisterListener(this.hoG);
        this.hns = null;
        this.icq.onDestroy();
        this.hXy = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.icq.setViewForeground();
            cfR();
            cfU();
            com.baidu.tieba.a.d.bmb().onPageStart("page_recommend");
            return;
        }
        this.icq.ceA();
        com.baidu.tieba.a.d.bmb().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.yE(TbadkCoreApplication.getInst().getAdAdSense().eaO);
        }
        return pageStayDurationItem;
    }

    private void cfR() {
        if (c.am(getBaseFragmentActivity()) && this.icq != null) {
            this.icq.cfX();
        }
    }

    public void brL() {
        this.icq.setViewForeground(true);
    }

    public void cfS() {
        this.icq.cfS();
    }

    public void completePullRefresh() {
        this.icq.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.icq != null) {
            this.icq.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.icr = bVar;
        this.icq.setCallback(bVar);
    }

    public void aP(String str, int i) {
        this.icq.aP(str, i);
    }

    public void ceU() {
        this.icq.ceU();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.icq.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfT() {
        com.baidu.tbadk.BdToken.c.aLi().jT(com.baidu.tbadk.BdToken.b.dtU);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ho() {
        this.icq.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hns == null) {
            this.hns = VoiceManager.instance();
        }
        return this.hns;
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqS() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqT() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
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

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
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
        this.icq.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aj
    public void aWr() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfU() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(r rVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(rVar);
        }
    }
}
