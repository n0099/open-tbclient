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
import com.baidu.adp.widget.ListView.t;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes22.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, aq {
    private VoiceManager ioV;
    private PersonalizePageView jkb;
    private com.baidu.tieba.homepage.framework.b jkc;
    private boolean jcY = false;
    private CustomMessageListener jkd = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.cFb();
            }
        }
    };
    private final CustomMessageListener jke = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.jkb != null) {
                PersonalizeFragment.this.jkb.f(l);
            }
        }
    };
    private final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.jkb.cFe();
            }
        }
    };
    private final CustomMessageListener iqx = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.cFa();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.jkb = new PersonalizePageView(context);
        this.jkb.bQI();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dDn().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.jkb.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jkb.getParent()).removeView(this.jkb);
            if (this.jkc != null) {
                this.jkb.setCallback(this.jkc);
            }
        }
        this.jkb.setPageUniqueId(getUniqueId());
        if (this.jcY) {
            this.jkb.bQI();
            this.jcY = false;
        }
        return this.jkb;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.ioV = getVoiceManager();
        if (this.ioV != null) {
            this.ioV.onCreate(getPageContext());
        }
        this.jkd.setTag(getUniqueId());
        registerListener(this.jkd);
        registerListener(this.jke);
        registerListener(this.iqx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (this.jkb != null) {
            this.jkb.setRecommendFrsNavigationAnimDispatcher(abVar);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
        if (this.jkb != null) {
            this.jkb.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.ioV != null) {
            this.ioV.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.bfw().ik(true);
        if (this.ioV != null) {
            this.ioV.onResume(getPageContext());
        }
        this.jkb.onResume();
        this.jkb.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        cFa();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jkb != null) {
            this.jkb.cCY();
            this.jkb.onPause();
            this.jkb.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        if (this.ioV != null) {
            this.ioV.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.bbM().bbX();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dDn().b(getUniqueId(), false);
        if (this.ioV != null) {
            this.ioV.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ioV != null) {
            this.ioV.onDestory(getPageContext());
        }
        com.baidu.tieba.s.c.dDn().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.jkd);
        MessageManager.getInstance().unRegisterListener(this.jke);
        MessageManager.getInstance().unRegisterListener(this.iqx);
        this.ioV = null;
        this.jkb.onDestroy();
        this.jcY = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.jkb.setViewForeground();
            cEY();
            cFb();
            com.baidu.tieba.a.d.bEz().onPageStart("page_recommend");
            return;
        }
        this.jkb.cCY();
        com.baidu.tieba.a.d.bEz().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.DD(TbadkCoreApplication.getInst().getAdAdSense().eOl);
        }
        return pageStayDurationItem;
    }

    private void cEY() {
        if (c.au(getBaseFragmentActivity()) && this.jkb != null) {
            this.jkb.cFg();
        }
    }

    public void bKT() {
        this.jkb.setViewForeground(true);
    }

    public void cEZ() {
        this.jkb.cEZ();
    }

    public void completePullRefresh() {
        this.jkb.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jkb != null) {
            this.jkb.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.jkc = bVar;
        this.jkb.setCallback(bVar);
    }

    public void aR(String str, int i) {
        this.jkb.aR(str, i);
    }

    public void cDN() {
        this.jkb.cDN();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.jkb.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFa() {
        com.baidu.tbadk.BdToken.c.bbM().nl(com.baidu.tbadk.BdToken.b.ebP);
    }

    @Override // com.baidu.tieba.frs.aq
    public void Qi() {
        this.jkb.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ioV == null) {
            this.ioV = VoiceManager.instance();
        }
        return this.ioV;
    }

    @Override // com.baidu.tieba.frs.aq
    public void bKa() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bKb() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(y.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jkb.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aq
    public void bok() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFb() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(tVar);
        }
    }

    public void cFc() {
        this.jkb.cFf();
    }
}
