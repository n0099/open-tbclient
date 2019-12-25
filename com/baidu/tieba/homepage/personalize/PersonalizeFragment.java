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
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, af {
    private PersonalizePageView gWn;
    private com.baidu.tieba.homepage.framework.b gWo;
    private VoiceManager giZ;
    private boolean gRo = false;
    private CustomMessageListener gWp = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.bLP();
            }
        }
    };
    private final CustomMessageListener gWq = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.gWn != null) {
                PersonalizeFragment.this.gWn.e(l);
            }
        }
    };
    private final CustomMessageListener cDA = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.gWn.bLR();
            }
        }
    };
    private final CustomMessageListener gkl = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.bLO();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.gWn = new PersonalizePageView(context);
        this.gWn.initListeners();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.r.c.cHo().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.gWn.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gWn.getParent()).removeView(this.gWn);
            if (this.gWo != null) {
                this.gWn.setCallback(this.gWo);
            }
        }
        this.gWn.setPageUniqueId(getUniqueId());
        if (this.gRo) {
            this.gWn.initListeners();
            this.gRo = false;
        }
        return this.gWn;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.giZ = getVoiceManager();
        if (this.giZ != null) {
            this.giZ.onCreate(getPageContext());
        }
        this.gWp.setTag(getUniqueId());
        registerListener(this.gWp);
        registerListener(this.gWq);
        registerListener(this.gkl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.gWn != null) {
            this.gWn.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
        if (this.gWn != null) {
            this.gWn.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.giZ != null) {
            this.giZ.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.axn().fh(true);
        if (this.giZ != null) {
            this.giZ.onResume(getPageContext());
        }
        this.gWn.onResume();
        this.gWn.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cDA);
        bLO();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gWn != null) {
            this.gWn.bKv();
            this.gWn.onPause();
            this.gWn.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.cDA);
        if (this.giZ != null) {
            this.giZ.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.auQ().auV();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.r.c.cHo().b(getUniqueId(), false);
        if (this.giZ != null) {
            this.giZ.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.giZ != null) {
            this.giZ.onDestory(getPageContext());
        }
        com.baidu.tieba.r.c.cHo().x(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gWp);
        MessageManager.getInstance().unRegisterListener(this.gWq);
        MessageManager.getInstance().unRegisterListener(this.gkl);
        this.giZ = null;
        this.gWn.onDestroy();
        this.gRo = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.gWn.setViewForeground();
            bLM();
            bLP();
            com.baidu.tieba.a.d.aUV().onPageStart("page_recommend");
            return;
        }
        this.gWn.bKv();
        com.baidu.tieba.a.d.aUV().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.vf(TbadkCoreApplication.getInst().getAdAdSense().dhF);
        }
        return pageStayDurationItem;
    }

    private void bLM() {
        if (c.an(getBaseFragmentActivity()) && this.gWn != null) {
            this.gWn.bLS();
        }
    }

    public void baE() {
        this.gWn.setViewForeground(true);
    }

    public void bLN() {
        this.gWn.bLN();
    }

    public void completePullRefresh() {
        this.gWn.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gWn != null) {
            this.gWn.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.gWo = bVar;
        this.gWn.setCallback(bVar);
    }

    public void aF(String str, int i) {
        this.gWn.aF(str, i);
    }

    public void bKS() {
        this.gWn.bKS();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.gWn.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLO() {
        com.baidu.tbadk.BdToken.c.auQ().iT(com.baidu.tbadk.BdToken.b.cCD);
    }

    @Override // com.baidu.tieba.frs.af
    public void xT() {
        this.gWn.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.giZ == null) {
            this.giZ = VoiceManager.instance();
        }
        return this.giZ;
    }

    @Override // com.baidu.tieba.frs.af
    public void aZL() {
    }

    @Override // com.baidu.tieba.frs.af
    public void aZM() {
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
        this.gWn.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.af
    public void aFd() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLP() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(pVar);
        }
    }
}
