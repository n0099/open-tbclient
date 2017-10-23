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
import com.baidu.tbadk.util.q;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.pb.CustomDialogData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends BaseFragment implements VoiceManager.c, ai {
    private c cYe;
    private com.baidu.tieba.homepage.framework.b cYf;
    private VoiceManager cqg;
    private boolean cVi = false;
    CustomMessageListener cYg = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_ACT_DIALOG) { // from class: com.baidu.tieba.homepage.personalize.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof CustomDialogData)) {
                com.baidu.tieba.pb.b.a(a.this.getPageContext(), (CustomDialogData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener cYh = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.isPrimary()) {
                a.this.apo();
            }
        }
    };
    private final CustomMessageListener cre = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    av.vA().c(a.this.getPageContext(), new String[]{str});
                }
            }
        }
    };

    public a() {
    }

    @SuppressLint({"ValidFragment"})
    public a(Context context) {
        this.cYe = new c(context);
        this.cYe.aoH();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.cYe.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.cYe.getParent()).removeView(this.cYe);
            if (this.cYf != null) {
                this.cYe.setCallback(this.cYf);
            }
        }
        this.cYe.setPageUniqueId(getUniqueId());
        if (this.cVi) {
            this.cYe.aoH();
            this.cVi = false;
        }
        return this.cYe;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cqg = getVoiceManager();
        if (this.cqg != null) {
            this.cqg.onCreate(getPageContext());
        }
        this.cYh.setTag(getUniqueId());
        registerListener(this.cYh);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ai
    public void setHeaderViewHeight(int i) {
        this.cYe.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ai
    public void setRecommendFrsNavigationAnimDispatcher(q qVar) {
        if (this.cYe != null) {
            this.cYe.setRecommendFrsNavigationAnimDispatcher(qVar);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void showFloatingView() {
        if (this.cYe != null) {
            this.cYe.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cqg != null) {
            this.cqg.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.cYg);
        if (this.cqg != null) {
            this.cqg.onResume(getPageContext());
        }
        this.cYe.onResume();
        this.cYe.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cre);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cYe != null) {
            this.cYe.aoM();
            this.cYe.onPause();
            this.cYe.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.cYg);
        if (this.cqg != null) {
            this.cqg.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cqg != null) {
            this.cqg.onStop(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cre);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cqg != null) {
            this.cqg.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cYh);
        this.cqg = null;
        this.cYe.onDestroy();
        this.cVi = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.cYe.aoL();
            apo();
            return;
        }
        this.cYe.aoM();
    }

    public void aoF() {
        this.cYe.setViewForeground(true);
    }

    public void apn() {
        this.cYe.apn();
    }

    public void completePullRefresh() {
        this.cYe.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cYe.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cYf = bVar;
        this.cYe.setCallback(bVar);
    }

    public void N(String str, int i) {
        this.cYe.N(str, i);
    }

    public void aoG() {
        this.cYe.aoG();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.cYe.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.ai
    public void NC() {
        this.cYe.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cqg == null) {
            this.cqg = VoiceManager.instance();
        }
        return this.cqg;
    }

    @Override // com.baidu.tieba.frs.ai
    public void ND() {
    }

    @Override // com.baidu.tieba.frs.ai
    public void NE() {
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
        this.cYe.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ai
    public void wu() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apo() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setVideoThreadId(String str) {
    }
}
