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
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes22.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ap {
    private VoiceManager iSW;
    private PersonalizePageView jQX;
    private com.baidu.tieba.homepage.framework.b jQY;
    private boolean jJG = false;
    private CustomMessageListener jQZ = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.cPE();
            }
        }
    };
    private final CustomMessageListener jRa = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.jQX != null) {
                PersonalizeFragment.this.jQX.h(l);
            }
        }
    };
    private final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.jQX.cPH();
            }
        }
    };
    private final CustomMessageListener iUy = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.cPD();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.jQX = new PersonalizePageView(context);
        this.jQX.bZq();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.t.c.dOf().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.jQX.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jQX.getParent()).removeView(this.jQX);
            if (this.jQY != null) {
                this.jQX.setCallback(this.jQY);
            }
        }
        this.jQX.setPageUniqueId(getUniqueId());
        if (this.jJG) {
            this.jQX.bZq();
            this.jJG = false;
        }
        return this.jQX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.iSW = getVoiceManager();
        if (this.iSW != null) {
            this.iSW.onCreate(getPageContext());
        }
        this.jQZ.setTag(getUniqueId());
        registerListener(this.jQZ);
        registerListener(this.jRa);
        registerListener(this.iUy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ap
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.jQX != null) {
            this.jQX.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void showFloatingView() {
        if (this.jQX != null) {
            this.jQX.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iSW != null) {
            this.iSW.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.bmd().iW(true);
        if (this.iSW != null) {
            this.iSW.onResume(getPageContext());
        }
        this.jQX.onResume();
        this.jQX.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        cPD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jQX != null) {
            this.jQX.cNB();
            this.jQX.onPause();
            this.jQX.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        if (this.iSW != null) {
            this.iSW.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.biD().biO();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.t.c.dOf().b(getUniqueId(), false);
        if (this.iSW != null) {
            this.iSW.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iSW != null) {
            this.iSW.onDestory(getPageContext());
        }
        com.baidu.tieba.t.c.dOf().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.jQZ);
        MessageManager.getInstance().unRegisterListener(this.jRa);
        MessageManager.getInstance().unRegisterListener(this.iUy);
        this.iSW = null;
        this.jQX.onDestroy();
        this.jJG = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.jQX.setViewForeground();
            cPB();
            cPE();
            com.baidu.tieba.a.d.bLU().onPageStart("page_recommend");
            return;
        }
        this.jQX.cNB();
        com.baidu.tieba.a.d.bLU().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.Eu(TbadkCoreApplication.getInst().getAdAdSense().fje);
        }
        return pageStayDurationItem;
    }

    private void cPB() {
        if (c.au(getBaseFragmentActivity()) && this.jQX != null) {
            this.jQX.cPK();
        }
    }

    public void bTa() {
        this.jQX.setViewForeground(true);
    }

    public void cPC() {
        this.jQX.cPC();
    }

    public void completePullRefresh() {
        this.jQX.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jQX != null) {
            this.jQX.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.jQY = bVar;
        this.jQX.setCallback(bVar);
    }

    public void aU(String str, int i) {
        this.jQX.aU(str, i);
    }

    public void cOq() {
        this.jQX.cOq();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.jQX.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPD() {
        com.baidu.tbadk.BdToken.c.biD().oa(com.baidu.tbadk.BdToken.b.evx);
    }

    @Override // com.baidu.tieba.frs.ap
    public void VC() {
        this.jQX.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iSW == null) {
            this.iSW = VoiceManager.instance();
        }
        return this.iSW;
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSh() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSi() {
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
        this.jQX.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ap
    public void bvt() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPE() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(tVar);
        }
    }

    public void cPF() {
        this.jQX.cPI();
    }
}
