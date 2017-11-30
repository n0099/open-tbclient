package com.baidu.tieba.homepage.personalize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class b extends BaseFragment implements VoiceManager.c, ai {
    private VoiceManager cGZ;
    private d dpE;
    private com.baidu.tieba.homepage.framework.b dpF;
    private boolean dmB = false;
    private CustomMessageListener dpG = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.isPrimary()) {
                b.this.atW();
            }
        }
    };
    private final CustomMessageListener cHX = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.homepage.personalize.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    av.vL().c(b.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    private final CustomMessageListener dpH = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && b.this.dpE != null) {
                b.this.dpE.e(l);
            }
        }
    };
    private final CustomMessageListener ctd = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.dpE.atX();
            }
        }
    };

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.dpE = new d(context);
        this.dpE.aoQ();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dpE.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dpE.getParent()).removeView(this.dpE);
            if (this.dpF != null) {
                this.dpE.setCallback(this.dpF);
            }
        }
        this.dpE.setPageUniqueId(getUniqueId());
        if (this.dmB) {
            this.dpE.aoQ();
            this.dmB = false;
        }
        return this.dpE;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cGZ = getVoiceManager();
        if (this.cGZ != null) {
            this.cGZ.onCreate(getPageContext());
        }
        this.dpG.setTag(getUniqueId());
        registerListener(this.dpG);
        registerListener(this.dpH);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ai
    public void setHeaderViewHeight(int i) {
        this.dpE.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ai
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dpE != null) {
            this.dpE.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void showFloatingView() {
        if (this.dpE != null) {
            this.dpE.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cGZ != null) {
            this.cGZ.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cGZ != null) {
            this.cGZ.onResume(getPageContext());
        }
        this.dpE.onResume();
        this.dpE.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cHX);
        MessageManager.getInstance().registerListener(this.ctd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dpE != null) {
            this.dpE.atv();
            this.dpE.onPause();
            this.dpE.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.ctd);
        if (this.cGZ != null) {
            this.cGZ.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cGZ != null) {
            this.cGZ.onStop(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cHX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cGZ != null) {
            this.cGZ.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dpG);
        MessageManager.getInstance().unRegisterListener(this.dpH);
        this.cGZ = null;
        this.dpE.onDestroy();
        this.dmB = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.dpE.att();
            atW();
            return;
        }
        this.dpE.atv();
    }

    public void Qo() {
        this.dpE.setViewForeground(true);
    }

    public void atV() {
        this.dpE.atV();
    }

    public void completePullRefresh() {
        this.dpE.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dpE.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dpF = bVar;
        this.dpE.setCallback(bVar);
    }

    public void V(String str, int i) {
        this.dpE.V(str, i);
    }

    public void atp() {
        this.dpE.atp();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.dpE.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.ai
    public void Pj() {
        this.dpE.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cGZ == null) {
            this.cGZ = VoiceManager.instance();
        }
        return this.cGZ;
    }

    @Override // com.baidu.tieba.frs.ai
    public void Pk() {
    }

    @Override // com.baidu.tieba.frs.ai
    public void Pl() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(v.c(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a002";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dpE.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ai
    public void wE() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atW() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setVideoThreadId(String str) {
    }
}
