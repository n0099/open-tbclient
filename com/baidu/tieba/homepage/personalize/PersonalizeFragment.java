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
    private VoiceManager jgu;
    private PersonalizePageView khX;
    private com.baidu.tieba.homepage.framework.b khY;
    private boolean kab = false;
    private CustomMessageListener khZ = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.cQZ();
            }
        }
    };
    private final CustomMessageListener kia = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && PersonalizeFragment.this.khX != null) {
                PersonalizeFragment.this.khX.h(l);
            }
        }
    };
    private final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                PersonalizeFragment.this.khX.cRc();
            }
        }
    };
    private final CustomMessageListener jhX = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.homepage.personalize.PersonalizeFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.cQY();
            }
        }
    };

    public PersonalizeFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        this.khX = new PersonalizePageView(context);
        this.khX.bZl();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMz().A(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.khX.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.khX.getParent()).removeView(this.khX);
            if (this.khY != null) {
                this.khX.setCallback(this.khY);
            }
        }
        this.khX.setPageUniqueId(getUniqueId());
        if (this.kab) {
            this.khX.bZl();
            this.kab = false;
        }
        return this.khX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onCreate(getPageContext());
        }
        this.khZ.setTag(getUniqueId());
        registerListener(this.khZ);
        registerListener(this.kia);
        registerListener(this.jhX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.khX != null) {
            this.khX.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
        if (this.khX != null) {
            this.khX.showFloatingView();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.jgu != null) {
            this.jgu.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.core.bigday.b.blb().jp(true);
        if (this.jgu != null) {
            this.jgu.onResume(getPageContext());
        }
        this.khX.onResume();
        this.khX.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        cQY();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.khX != null) {
            this.khX.cOU();
            this.khX.onPause();
            this.khX.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        if (this.jgu != null) {
            this.jgu.onPause(getPageContext());
        }
        com.baidu.tbadk.BdToken.c.bhn().bhy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dMz().b(getUniqueId(), false);
        if (this.jgu != null) {
            this.jgu.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jgu != null) {
            this.jgu.onDestory(getPageContext());
        }
        com.baidu.tieba.s.c.dMz().B(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.khZ);
        MessageManager.getInstance().unRegisterListener(this.kia);
        MessageManager.getInstance().unRegisterListener(this.jhX);
        this.jgu = null;
        this.khX.onDestroy();
        this.kab = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.khX.setViewForeground();
            cQW();
            cQZ();
            com.baidu.tieba.a.d.bKU().onPageStart("page_recommend");
            return;
        }
        this.khX.cOU();
        com.baidu.tieba.a.d.bKU().onPageEnd("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.Du(TbadkCoreApplication.getInst().getAdAdSense().fqv);
        }
        return pageStayDurationItem;
    }

    private void cQW() {
        if (c.aq(getBaseFragmentActivity()) && this.khX != null) {
            this.khX.cRf();
        }
    }

    public void bSx() {
        this.khX.setViewForeground(true);
    }

    public void cQX() {
        this.khX.cQX();
    }

    public void completePullRefresh() {
        this.khX.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.khX != null) {
            this.khX.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.khY = bVar;
        this.khX.setCallback(bVar);
    }

    public void bd(String str, int i) {
        this.khX.bd(str, i);
    }

    public void cPJ() {
        this.khX.cPJ();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.khX.d(dataRes, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQY() {
        com.baidu.tbadk.BdToken.c.bhn().mG(com.baidu.tbadk.BdToken.b.eCh);
    }

    @Override // com.baidu.tieba.frs.am
    public void Ut() {
        this.khX.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jgu == null) {
            this.jgu = VoiceManager.instance();
        }
        return this.jgu;
    }

    @Override // com.baidu.tieba.frs.am
    public void bRD() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bRE() {
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
        this.khX.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.am
    public void bup() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQZ() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.i
    public void onPreLoad(q qVar) {
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(qVar);
        }
    }

    public void cRa() {
        this.khX.cRd();
    }
}
