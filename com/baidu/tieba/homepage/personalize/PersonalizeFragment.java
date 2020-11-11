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
    private VoiceManager iHo;
    private PersonalizePageView jCv;
    private com.baidu.tieba.homepage.framework.b jCw;
    private boolean jvr = false;
    private CustomMessageListener jCx = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.cKJ();
            }
        }
    };
    private final CustomMessageListener jCy = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.jCv != null) {
                PersonalizeFragment.this.jCv.g(l);
            }
        }
    };
    private final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.jCv.cKM();
            }
        }
    };
    private final CustomMessageListener iIQ = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.cKI();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.jCv = new PersonalizePageView(context);
        this.jCv.bWm();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dIX().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.jCv.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jCv.getParent()).removeView(this.jCv);
            if (this.jCw != null) {
                this.jCv.setCallback(this.jCw);
            }
        }
        this.jCv.setPageUniqueId(getUniqueId());
        if (this.jvr) {
            this.jCv.bWm();
            this.jvr = false;
        }
        return this.jCv;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.iHo = getVoiceManager();
        if (this.iHo != null) {
            this.iHo.onCreate(getPageContext());
        }
        this.jCx.setTag(getUniqueId());
        registerListener(this.jCx);
        registerListener(this.jCy);
        registerListener(this.iIQ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (this.jCv != null) {
            this.jCv.setRecommendFrsNavigationAnimDispatcher(abVar);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
        if (this.jCv != null) {
            this.jCv.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iHo != null) {
            this.iHo.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.bjP().iG(true);
        if (this.iHo != null) {
            this.iHo.onResume(getPageContext());
        }
        this.jCv.onResume();
        this.jCv.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        cKI();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jCv != null) {
            this.jCv.cIG();
            this.jCv.onPause();
            this.jCv.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        if (this.iHo != null) {
            this.iHo.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.bgf().bgq();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dIX().b(getUniqueId(), false);
        if (this.iHo != null) {
            this.iHo.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iHo != null) {
            this.iHo.onDestory(getPageContext());
        }
        com.baidu.tieba.s.c.dIX().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.jCx);
        MessageManager.getInstance().unRegisterListener(this.jCy);
        MessageManager.getInstance().unRegisterListener(this.iIQ);
        this.iHo = null;
        this.jCv.onDestroy();
        this.jvr = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.jCv.setViewForeground();
            cKG();
            cKJ();
            com.baidu.tieba.a.d.bIR().onPageStart("page_recommend");
            return;
        }
        this.jCv.cIG();
        com.baidu.tieba.a.d.bIR().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.Ek(TbadkCoreApplication.getInst().getAdAdSense().fcx);
        }
        return pageStayDurationItem;
    }

    private void cKG() {
        if (c.au(getBaseFragmentActivity()) && this.jCv != null) {
            this.jCv.cKO();
        }
    }

    public void bPV() {
        this.jCv.setViewForeground(true);
    }

    public void cKH() {
        this.jCv.cKH();
    }

    public void completePullRefresh() {
        this.jCv.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jCv != null) {
            this.jCv.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.jCw = bVar;
        this.jCv.setCallback(bVar);
    }

    public void aU(String str, int i) {
        this.jCv.aU(str, i);
    }

    public void cJv() {
        this.jCv.cJv();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.jCv.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKI() {
        com.baidu.tbadk.BdToken.c.bgf().nG(com.baidu.tbadk.BdToken.b.eqf);
    }

    @Override // com.baidu.tieba.frs.aq
    public void TL() {
        this.jCv.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iHo == null) {
            this.iHo = VoiceManager.instance();
        }
        return this.iHo;
    }

    @Override // com.baidu.tieba.frs.aq
    public void bPc() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bPd() {
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
        this.jCv.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aq
    public void bsD() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKJ() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(tVar);
        }
    }

    public void cKK() {
        this.jCv.cKN();
    }
}
