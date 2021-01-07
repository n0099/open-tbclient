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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, am {
    private VoiceManager jfh;
    private PersonalizePageView keh;
    private com.baidu.tieba.homepage.framework.b kei;
    private boolean jWR = false;
    private CustomMessageListener kej = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.cSL();
            }
        }
    };
    private final CustomMessageListener kek = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.keh != null) {
                PersonalizeFragment.this.keh.h(l);
            }
        }
    };
    private final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.keh.cSO();
            }
        }
    };
    private final CustomMessageListener jgK = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.cSK();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.keh = new PersonalizePageView(context);
        this.keh.cbY();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dNY().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.keh.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.keh.getParent()).removeView(this.keh);
            if (this.kei != null) {
                this.keh.setCallback(this.kei);
            }
        }
        this.keh.setPageUniqueId(getUniqueId());
        if (this.jWR) {
            this.keh.cbY();
            this.jWR = false;
        }
        return this.keh;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.jfh = getVoiceManager();
        if (this.jfh != null) {
            this.jfh.onCreate(getPageContext());
        }
        this.kej.setTag(getUniqueId());
        registerListener(this.kej);
        registerListener(this.kek);
        registerListener(this.jgK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(y yVar) {
        if (this.keh != null) {
            this.keh.setRecommendFrsNavigationAnimDispatcher(yVar);
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
        if (this.keh != null) {
            this.keh.showFloatingView();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.jfh != null) {
            this.jfh.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.boD().jr(true);
        if (this.jfh != null) {
            this.jfh.onResume(getPageContext());
        }
        this.keh.onResume();
        this.keh.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        cSK();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.keh != null) {
            this.keh.cQI();
            this.keh.onPause();
            this.keh.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        if (this.jfh != null) {
            this.jfh.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.bkU().blf();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dNY().b(getUniqueId(), false);
        if (this.jfh != null) {
            this.jfh.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jfh != null) {
            this.jfh.onDestory(getPageContext());
        }
        com.baidu.tieba.s.c.dNY().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.kej);
        MessageManager.getInstance().unRegisterListener(this.kek);
        MessageManager.getInstance().unRegisterListener(this.jgK);
        this.jfh = null;
        this.keh.onDestroy();
        this.jWR = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.keh.setViewForeground();
            cSI();
            cSL();
            com.baidu.tieba.a.d.bOn().onPageStart("page_recommend");
            return;
        }
        this.keh.cQI();
        com.baidu.tieba.a.d.bOn().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.Eq(TbadkCoreApplication.getInst().getAdAdSense().fsN);
        }
        return pageStayDurationItem;
    }

    private void cSI() {
        if (c.ax(getBaseFragmentActivity()) && this.keh != null) {
            this.keh.cSR();
        }
    }

    public void bVF() {
        this.keh.setViewForeground(true);
    }

    public void cSJ() {
        this.keh.cSJ();
    }

    public void completePullRefresh() {
        this.keh.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.keh != null) {
            this.keh.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.kei = bVar;
        this.keh.setCallback(bVar);
    }

    public void bc(String str, int i) {
        this.keh.bc(str, i);
    }

    public void cRx() {
        this.keh.cRx();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.keh.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSK() {
        com.baidu.tbadk.BdToken.c.bkU().oj(com.baidu.tbadk.BdToken.b.eEN);
    }

    @Override // com.baidu.tieba.frs.am
    public void WF() {
        this.keh.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jfh == null) {
            this.jfh = VoiceManager.instance();
        }
        return this.jfh;
    }

    @Override // com.baidu.tieba.frs.am
    public void bUK() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bUL() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(x.getItem(arrayList, arrayList.size() - 1))) {
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
        this.keh.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.am
    public void bxP() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSL() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.i
    public void onPreLoad(q qVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(qVar);
        }
    }

    public void cSM() {
        this.keh.cSP();
    }
}
