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
    private VoiceManager cxT;
    private c dgQ;
    private com.baidu.tieba.homepage.framework.b dgR;
    private boolean ddV = false;
    CustomMessageListener dgS = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_ACT_DIALOG) { // from class: com.baidu.tieba.homepage.personalize.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof CustomDialogData)) {
                com.baidu.tieba.pb.b.a(a.this.getPageContext(), (CustomDialogData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dgT = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.isPrimary()) {
                a.this.asd();
            }
        }
    };
    private final CustomMessageListener cyS = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.homepage.personalize.a.3
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
    private final CustomMessageListener ckz = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.dgQ.ase();
            }
        }
    };

    public a() {
    }

    @SuppressLint({"ValidFragment"})
    public a(Context context) {
        this.dgQ = new c(context);
        this.dgQ.amW();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dgQ.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dgQ.getParent()).removeView(this.dgQ);
            if (this.dgR != null) {
                this.dgQ.setCallback(this.dgR);
            }
        }
        this.dgQ.setPageUniqueId(getUniqueId());
        if (this.ddV) {
            this.dgQ.amW();
            this.ddV = false;
        }
        return this.dgQ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cxT = getVoiceManager();
        if (this.cxT != null) {
            this.cxT.onCreate(getPageContext());
        }
        this.dgT.setTag(getUniqueId());
        registerListener(this.dgT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ai
    public void setHeaderViewHeight(int i) {
        this.dgQ.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ai
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dgQ != null) {
            this.dgQ.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void showFloatingView() {
        if (this.dgQ != null) {
            this.dgQ.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cxT != null) {
            this.cxT.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.dgS);
        if (this.cxT != null) {
            this.cxT.onResume(getPageContext());
        }
        this.dgQ.onResume();
        this.dgQ.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cyS);
        MessageManager.getInstance().registerListener(this.ckz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dgQ != null) {
            this.dgQ.arB();
            this.dgQ.onPause();
            this.dgQ.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.dgS);
        MessageManager.getInstance().unRegisterListener(this.ckz);
        if (this.cxT != null) {
            this.cxT.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cxT != null) {
            this.cxT.onStop(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cyS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cxT != null) {
            this.cxT.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dgT);
        this.cxT = null;
        this.dgQ.onDestroy();
        this.ddV = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.dgQ.arA();
            asd();
            return;
        }
        this.dgQ.arB();
    }

    public void Pb() {
        this.dgQ.setViewForeground(true);
    }

    public void asc() {
        this.dgQ.asc();
    }

    public void completePullRefresh() {
        this.dgQ.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dgQ.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dgR = bVar;
        this.dgQ.setCallback(bVar);
    }

    public void T(String str, int i) {
        this.dgQ.T(str, i);
    }

    public void arw() {
        this.dgQ.arw();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.dgQ.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.ai
    public void Oa() {
        this.dgQ.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cxT == null) {
            this.cxT = VoiceManager.instance();
        }
        return this.cxT;
    }

    @Override // com.baidu.tieba.frs.ai
    public void Ob() {
    }

    @Override // com.baidu.tieba.frs.ai
    public void Oc() {
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
        this.dgQ.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ai
    public void wB() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asd() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setVideoThreadId(String str) {
    }
}
