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
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes21.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, aq {
    private VoiceManager iIc;
    private PersonalizePageView jDt;
    private com.baidu.tieba.homepage.framework.b jDu;
    private boolean jwd = false;
    private CustomMessageListener jDv = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.cKo();
            }
        }
    };
    private final CustomMessageListener jDw = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.jDt != null) {
                PersonalizeFragment.this.jDt.h(l);
            }
        }
    };
    private final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.jDt.cKr();
            }
        }
    };
    private final CustomMessageListener iJE = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.cKn();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.jDt = new PersonalizePageView(context);
        this.jDt.bVF();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.t.c.dIO().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.jDt.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jDt.getParent()).removeView(this.jDt);
            if (this.jDu != null) {
                this.jDt.setCallback(this.jDu);
            }
        }
        this.jDt.setPageUniqueId(getUniqueId());
        if (this.jwd) {
            this.jDt.bVF();
            this.jwd = false;
        }
        return this.jDt;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.iIc = getVoiceManager();
        if (this.iIc != null) {
            this.iIc.onCreate(getPageContext());
        }
        this.jDv.setTag(getUniqueId());
        registerListener(this.jDv);
        registerListener(this.jDw);
        registerListener(this.iJE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.jDt != null) {
            this.jDt.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
        if (this.jDt != null) {
            this.jDt.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iIc != null) {
            this.iIc.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.biT().iH(true);
        if (this.iIc != null) {
            this.iIc.onResume(getPageContext());
        }
        this.jDt.onResume();
        this.jDt.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        cKn();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jDt != null) {
            this.jDt.cIl();
            this.jDt.onPause();
            this.jDt.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        if (this.iIc != null) {
            this.iIc.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.bfy().bfJ();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.t.c.dIO().b(getUniqueId(), false);
        if (this.iIc != null) {
            this.iIc.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iIc != null) {
            this.iIc.onDestory(getPageContext());
        }
        com.baidu.tieba.t.c.dIO().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.jDv);
        MessageManager.getInstance().unRegisterListener(this.jDw);
        MessageManager.getInstance().unRegisterListener(this.iJE);
        this.iIc = null;
        this.jDt.onDestroy();
        this.jwd = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.jDt.setViewForeground();
            cKl();
            cKo();
            com.baidu.tieba.a.d.bIl().onPageStart("page_recommend");
            return;
        }
        this.jDt.cIl();
        com.baidu.tieba.a.d.bIl().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.DJ(TbadkCoreApplication.getInst().getAdAdSense().fbE);
        }
        return pageStayDurationItem;
    }

    private void cKl() {
        if (c.at(getBaseFragmentActivity()) && this.jDt != null) {
            this.jDt.cKu();
        }
    }

    public void bPo() {
        this.jDt.setViewForeground(true);
    }

    public void cKm() {
        this.jDt.cKm();
    }

    public void completePullRefresh() {
        this.jDt.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jDt != null) {
            this.jDt.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.jDu = bVar;
        this.jDt.setCallback(bVar);
    }

    public void aT(String str, int i) {
        this.jDt.aT(str, i);
    }

    public void cJa() {
        this.jDt.cJa();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.jDt.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKn() {
        com.baidu.tbadk.BdToken.c.bfy().nC(com.baidu.tbadk.BdToken.b.eoy);
    }

    @Override // com.baidu.tieba.frs.aq
    public void Tc() {
        this.jDt.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iIc == null) {
            this.iIc = VoiceManager.instance();
        }
        return this.iIc;
    }

    @Override // com.baidu.tieba.frs.aq
    public void bOv() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bOw() {
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
        this.jDt.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aq
    public void brT() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKo() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(tVar);
        }
    }

    public void cKp() {
        this.jDt.cKs();
    }
}
