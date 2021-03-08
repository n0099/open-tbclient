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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class PersonalizeFragment extends BaseFragment implements VoiceManager.c, am {
    private VoiceManager jie;
    private PersonalizePageView kka;
    private com.baidu.tieba.homepage.framework.b kkb;
    private boolean kcd = false;
    private CustomMessageListener kkc = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.cRg();
            }
        }
    };
    private final CustomMessageListener kkd = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.kka != null) {
                PersonalizeFragment.this.kka.h(l);
            }
        }
    };
    private final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.kka.cRj();
            }
        }
    };
    private final CustomMessageListener jjH = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.cRf();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.kka = new PersonalizePageView(context);
        this.kka.bZr();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMH().B(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.kka.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.kka.getParent()).removeView(this.kka);
            if (this.kkb != null) {
                this.kka.setCallback(this.kkb);
            }
        }
        this.kka.setPageUniqueId(getUniqueId());
        if (this.kcd) {
            this.kka.bZr();
            this.kcd = false;
        }
        return this.kka;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.jie = getVoiceManager();
        if (this.jie != null) {
            this.jie.onCreate(getPageContext());
        }
        this.kkc.setTag(getUniqueId());
        registerListener(this.kkc);
        registerListener(this.kkd);
        registerListener(this.jjH);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.kka != null) {
            this.kka.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
        if (this.kka != null) {
            this.kka.showFloatingView();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.jie != null) {
            this.jie.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.bld().jp(true);
        if (this.jie != null) {
            this.jie.onResume(getPageContext());
        }
        this.kka.onResume();
        this.kka.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        cRf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.kka != null) {
            this.kka.cPb();
            this.kka.onPause();
            this.kka.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        if (this.jie != null) {
            this.jie.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.bhp().bhA();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dMH().b(getUniqueId(), false);
        if (this.jie != null) {
            this.jie.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jie != null) {
            this.jie.onDestory(getPageContext());
        }
        com.baidu.tieba.s.c.dMH().C(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.kkc);
        MessageManager.getInstance().unRegisterListener(this.kkd);
        MessageManager.getInstance().unRegisterListener(this.jjH);
        this.jie = null;
        this.kka.onDestroy();
        this.kcd = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.kka.setViewForeground();
            cRd();
            cRg();
            com.baidu.tieba.a.d.bKY().onPageStart("page_recommend");
            return;
        }
        this.kka.cPb();
        com.baidu.tieba.a.d.bKY().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.DB(TbadkCoreApplication.getInst().getAdAdSense().frW);
        }
        return pageStayDurationItem;
    }

    private void cRd() {
        if (c.ar(getBaseFragmentActivity()) && this.kka != null) {
            this.kka.cRm();
        }
    }

    public void bSD() {
        this.kka.setViewForeground(true);
    }

    public void cRe() {
        this.kka.cRe();
    }

    public void completePullRefresh() {
        this.kka.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.kka != null) {
            this.kka.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.kkb = bVar;
        this.kka.setCallback(bVar);
    }

    public void bd(String str, int i) {
        this.kka.bd(str, i);
    }

    public void cPQ() {
        this.kka.cPQ();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.kka.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRf() {
        com.baidu.tbadk.BdToken.c.bhp().mH(com.baidu.tbadk.BdToken.b.eDI);
    }

    @Override // com.baidu.tieba.frs.am
    public void Uw() {
        this.kka.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jie == null) {
            this.jie = VoiceManager.instance();
        }
        return this.jie;
    }

    @Override // com.baidu.tieba.frs.am
    public void bRJ() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bRK() {
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
        this.kka.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.am
    public void bus() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRg() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.i
    public void onPreLoad(q qVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(qVar);
        }
    }

    public void cRh() {
        this.kka.cRk();
    }
}
