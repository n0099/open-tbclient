package com.baidu.tieba.homepage.personalize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.pb.CustomDialogData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends BaseFragment implements VoiceManager.c, ah {
    private c cUB;
    private com.baidu.tieba.homepage.framework.b cUC;
    private VoiceManager cjK;
    private boolean cRM = false;
    CustomMessageListener cUD = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_ACT_DIALOG) { // from class: com.baidu.tieba.homepage.personalize.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof CustomDialogData)) {
                com.baidu.tieba.pb.c.a(a.this.getPageContext(), (CustomDialogData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener cUE = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.isPrimary()) {
                a.this.aoT();
            }
        }
    };
    private final CustomMessageListener ckI = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    at.wg().c(a.this.getPageContext(), new String[]{str});
                }
            }
        }
    };

    public a() {
    }

    @SuppressLint({"ValidFragment"})
    public a(Context context) {
        this.cUB = new c(context);
        this.cUB.aop();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.cUB.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.cUB.getParent()).removeView(this.cUB);
            if (this.cUC != null) {
                this.cUB.setCallback(this.cUC);
            }
        }
        this.cUB.setPageUniqueId(getUniqueId());
        if (this.cRM) {
            this.cUB.aop();
            this.cRM = false;
        }
        return this.cUB;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cjK = getVoiceManager();
        if (this.cjK != null) {
            this.cjK.onCreate(getPageContext());
        }
        this.cUE.setTag(getUniqueId());
        registerListener(this.cUE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.cUB.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.cUB != null) {
            this.cUB.setRecommendFrsNavigationAnimDispatcher(rVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.cUB != null) {
            this.cUB.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cjK != null) {
            this.cjK.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.cUD);
        if (this.cjK != null) {
            this.cjK.onResume(getPageContext());
        }
        this.cUB.onResume();
        this.cUB.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.ckI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.cUD);
        if (this.cjK != null) {
            this.cjK.onPause(getPageContext());
        }
        this.cUB.onPause();
        this.cUB.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cjK != null) {
            this.cjK.onStop(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.ckI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cjK != null) {
            this.cjK.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cUE);
        this.cjK = null;
        this.cUB.onDestroy();
        this.cRM = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.cUB.aot();
            aoT();
            return;
        }
        this.cUB.aou();
    }

    public void aon() {
        this.cUB.setViewForeground(true);
    }

    public void aoS() {
        this.cUB.aoS();
    }

    public void completePullRefresh() {
        this.cUB.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cUB.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cUC = bVar;
        this.cUB.setCallback(bVar);
    }

    public void N(String str, int i) {
        this.cUB.N(str, i);
    }

    public void aoo() {
        this.cUB.aoo();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.cUB.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.ah
    public void N(Intent intent) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void afL() {
        this.cUB.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cjK == null) {
            this.cjK = VoiceManager.instance();
        }
        return this.cjK;
    }

    @Override // com.baidu.tieba.frs.ah
    public void afw() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void afx() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(u.c(arrayList, arrayList.size() - 1))) {
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

    @Override // com.baidu.tieba.frs.ah
    public ForumWriteData afM() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cUB.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void xd() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoT() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }
}
