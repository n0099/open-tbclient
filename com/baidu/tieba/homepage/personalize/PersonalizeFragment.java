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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, ao {
    private VoiceManager hzJ;
    private PersonalizePageView irx;
    private com.baidu.tieba.homepage.framework.b iry;
    private boolean ilW = false;
    private CustomMessageListener irz = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.cjv();
            }
        }
    };
    private final CustomMessageListener irA = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.irx != null) {
                PersonalizeFragment.this.irx.e(l);
            }
        }
    };
    private final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.irx.cjx();
            }
        }
    };
    private final CustomMessageListener hBf = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.cju();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.irx = new PersonalizePageView(context);
        this.irx.bzy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dgY().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.irx.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.irx.getParent()).removeView(this.irx);
            if (this.iry != null) {
                this.irx.setCallback(this.iry);
            }
        }
        this.irx.setPageUniqueId(getUniqueId());
        if (this.ilW) {
            this.irx.bzy();
            this.ilW = false;
        }
        return this.irx;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hzJ = getVoiceManager();
        if (this.hzJ != null) {
            this.hzJ.onCreate(getPageContext());
        }
        this.irz.setTag(getUniqueId());
        registerListener(this.irz);
        registerListener(this.irA);
        registerListener(this.hBf);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ao
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.irx != null) {
            this.irx.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void showFloatingView() {
        if (this.irx != null) {
            this.irx.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hzJ != null) {
            this.hzJ.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.aPI().gQ(true);
        if (this.hzJ != null) {
            this.hzJ.onResume(getPageContext());
        }
        this.irx.onResume();
        this.irx.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        cju();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.irx != null) {
            this.irx.chY();
            this.irx.onPause();
            this.irx.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        if (this.hzJ != null) {
            this.hzJ.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.aMo().aMy();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dgY().b(getUniqueId(), false);
        if (this.hzJ != null) {
            this.hzJ.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hzJ != null) {
            this.hzJ.onDestory(getPageContext());
        }
        com.baidu.tieba.s.c.dgY().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.irz);
        MessageManager.getInstance().unRegisterListener(this.irA);
        MessageManager.getInstance().unRegisterListener(this.hBf);
        this.hzJ = null;
        this.irx.onDestroy();
        this.ilW = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.irx.setViewForeground();
            cjs();
            cjv();
            com.baidu.tieba.a.d.boB().onPageStart("page_recommend");
            return;
        }
        this.irx.chY();
        com.baidu.tieba.a.d.boB().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.yX(TbadkCoreApplication.getInst().getAdAdSense().ejy);
        }
        return pageStayDurationItem;
    }

    private void cjs() {
        if (c.an(getBaseFragmentActivity()) && this.irx != null) {
            this.irx.cjy();
        }
    }

    public void buI() {
        this.irx.setViewForeground(true);
    }

    public void cjt() {
        this.irx.cjt();
    }

    public void completePullRefresh() {
        this.irx.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.irx != null) {
            this.irx.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.iry = bVar;
        this.irx.setCallback(bVar);
    }

    public void aO(String str, int i) {
        this.irx.aO(str, i);
    }

    public void cir() {
        this.irx.cir();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.irx.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cju() {
        com.baidu.tbadk.BdToken.c.aMo().ke(com.baidu.tbadk.BdToken.b.dyD);
    }

    @Override // com.baidu.tieba.frs.ao
    public void IB() {
        this.irx.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hzJ == null) {
            this.hzJ = VoiceManager.instance();
        }
        return this.hzJ;
    }

    @Override // com.baidu.tieba.frs.ao
    public void btQ() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void btR() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(w.getItem(arrayList, arrayList.size() - 1))) {
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
        this.irx.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ao
    public void aYj() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjv() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
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
