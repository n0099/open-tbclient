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
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes16.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, aq {
    private VoiceManager hSO;
    private PersonalizePageView iMr;
    private com.baidu.tieba.homepage.framework.b iMs;
    private boolean iGq = false;
    private CustomMessageListener iMt = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.cxL();
            }
        }
    };
    private final CustomMessageListener iMu = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.iMr != null) {
                PersonalizeFragment.this.iMr.e(l);
            }
        }
    };
    private final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.iMr.cxN();
            }
        }
    };
    private final CustomMessageListener hUq = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.cxK();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.iMr = new PersonalizePageView(context);
        this.iMr.bMg();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dvE().A(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.iMr.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iMr.getParent()).removeView(this.iMr);
            if (this.iMs != null) {
                this.iMr.setCallback(this.iMs);
            }
        }
        this.iMr.setPageUniqueId(getUniqueId());
        if (this.iGq) {
            this.iMr.bMg();
            this.iGq = false;
        }
        return this.iMr;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hSO = getVoiceManager();
        if (this.hSO != null) {
            this.hSO.onCreate(getPageContext());
        }
        this.iMt.setTag(getUniqueId());
        registerListener(this.iMt);
        registerListener(this.iMu);
        registerListener(this.hUq);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.iMr != null) {
            this.iMr.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
        if (this.iMr != null) {
            this.iMr.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hSO != null) {
            this.hSO.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.bbU().hQ(true);
        if (this.hSO != null) {
            this.hSO.onResume(getPageContext());
        }
        this.iMr.onResume();
        this.iMr.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        cxK();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iMr != null) {
            this.iMr.cwg();
            this.iMr.onPause();
            this.iMr.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        if (this.hSO != null) {
            this.hSO.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.aYs().aYC();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dvE().b(getUniqueId(), false);
        if (this.hSO != null) {
            this.hSO.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hSO != null) {
            this.hSO.onDestory(getPageContext());
        }
        com.baidu.tieba.s.c.dvE().B(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.iMt);
        MessageManager.getInstance().unRegisterListener(this.iMu);
        MessageManager.getInstance().unRegisterListener(this.hUq);
        this.hSO = null;
        this.iMr.onDestroy();
        this.iGq = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.iMr.setViewForeground();
            cxI();
            cxL();
            com.baidu.tieba.a.d.bAA().onPageStart("page_recommend");
            return;
        }
        this.iMr.cwg();
        com.baidu.tieba.a.d.bAA().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.Cu(TbadkCoreApplication.getInst().getAdAdSense().ezW);
        }
        return pageStayDurationItem;
    }

    private void cxI() {
        if (c.ap(getBaseFragmentActivity()) && this.iMr != null) {
            this.iMr.cxO();
        }
    }

    public void bGQ() {
        this.iMr.setViewForeground(true);
    }

    public void cxJ() {
        this.iMr.cxJ();
    }

    public void completePullRefresh() {
        this.iMr.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.iMr != null) {
            this.iMr.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.iMs = bVar;
        this.iMr.setCallback(bVar);
    }

    public void aQ(String str, int i) {
        this.iMr.aQ(str, i);
    }

    public void cwz() {
        this.iMr.cwz();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.iMr.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxK() {
        com.baidu.tbadk.BdToken.c.aYs().mD(com.baidu.tbadk.BdToken.b.dNH);
    }

    @Override // com.baidu.tieba.frs.aq
    public void OA() {
        this.iMr.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hSO == null) {
            this.hSO = VoiceManager.instance();
        }
        return this.hSO;
    }

    @Override // com.baidu.tieba.frs.aq
    public void bFY() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bFZ() {
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
        this.iMr.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aq
    public void bkF() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxL() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(tVar);
        }
    }
}
