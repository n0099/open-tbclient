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
import com.baidu.tieba.pb.CustomDialogData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends BaseFragment implements VoiceManager.c, ai {
    private VoiceManager cxA;
    private c dgw;
    private com.baidu.tieba.homepage.framework.b dgx;
    private boolean ddB = false;
    CustomMessageListener dgy = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_ACT_DIALOG) { // from class: com.baidu.tieba.homepage.personalize.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof CustomDialogData)) {
                com.baidu.tieba.pb.b.a(a.this.getPageContext(), (CustomDialogData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dgz = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.isPrimary()) {
                a.this.arN();
            }
        }
    };
    private final CustomMessageListener cyz = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    av.vI().c(a.this.getPageContext(), new String[]{str});
                }
            }
        }
    };

    public a() {
    }

    @SuppressLint({"ValidFragment"})
    public a(Context context) {
        this.dgw = new c(context);
        this.dgw.amI();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dgw.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dgw.getParent()).removeView(this.dgw);
            if (this.dgx != null) {
                this.dgw.setCallback(this.dgx);
            }
        }
        this.dgw.setPageUniqueId(getUniqueId());
        if (this.ddB) {
            this.dgw.amI();
            this.ddB = false;
        }
        return this.dgw;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cxA = getVoiceManager();
        if (this.cxA != null) {
            this.cxA.onCreate(getPageContext());
        }
        this.dgz.setTag(getUniqueId());
        registerListener(this.dgz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ai
    public void setHeaderViewHeight(int i) {
        this.dgw.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ai
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dgw != null) {
            this.dgw.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void showFloatingView() {
        if (this.dgw != null) {
            this.dgw.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cxA != null) {
            this.cxA.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.dgy);
        if (this.cxA != null) {
            this.cxA.onResume(getPageContext());
        }
        this.dgw.onResume();
        this.dgw.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cyz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dgw != null) {
            this.dgw.arl();
            this.dgw.onPause();
            this.dgw.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.dgy);
        if (this.cxA != null) {
            this.cxA.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cxA != null) {
            this.cxA.onStop(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cyz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cxA != null) {
            this.cxA.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dgz);
        this.cxA = null;
        this.dgw.onDestroy();
        this.ddB = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.dgw.ark();
            arN();
            return;
        }
        this.dgw.arl();
    }

    public void OQ() {
        this.dgw.setViewForeground(true);
    }

    public void arM() {
        this.dgw.arM();
    }

    public void completePullRefresh() {
        this.dgw.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dgw.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dgx = bVar;
        this.dgw.setCallback(bVar);
    }

    public void T(String str, int i) {
        this.dgw.T(str, i);
    }

    public void arg() {
        this.dgw.arg();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.dgw.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.ai
    public void NP() {
        this.dgw.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cxA == null) {
            this.cxA = VoiceManager.instance();
        }
        return this.cxA;
    }

    @Override // com.baidu.tieba.frs.ai
    public void NQ() {
    }

    @Override // com.baidu.tieba.frs.ai
    public void NR() {
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
        this.dgw.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ai
    public void wB() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arN() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setVideoThreadId(String str) {
    }
}
