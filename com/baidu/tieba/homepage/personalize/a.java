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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
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
    private VoiceManager cpV;
    private c dbY;
    private com.baidu.tieba.homepage.framework.b dbZ;
    private boolean cZa = false;
    CustomMessageListener dca = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_ACT_DIALOG) { // from class: com.baidu.tieba.homepage.personalize.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof CustomDialogData)) {
                com.baidu.tieba.pb.c.a(a.this.getPageContext(), (CustomDialogData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dcb = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.isPrimary()) {
                a.this.aqO();
            }
        }
    };
    private final CustomMessageListener cqT = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    au.wd().c(a.this.getPageContext(), new String[]{str});
                }
            }
        }
    };

    public a() {
    }

    @SuppressLint({"ValidFragment"})
    public a(Context context) {
        this.dbY = new c(context);
        this.dbY.aqj();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dbY.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dbY.getParent()).removeView(this.dbY);
            if (this.dbZ != null) {
                this.dbY.setCallback(this.dbZ);
            }
        }
        this.dbY.setPageUniqueId(getUniqueId());
        if (this.cZa) {
            this.dbY.aqj();
            this.cZa = false;
        }
        return this.dbY;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cpV = getVoiceManager();
        if (this.cpV != null) {
            this.cpV.onCreate(getPageContext());
        }
        this.dcb.setTag(getUniqueId());
        registerListener(this.dcb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dbY.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.dbY != null) {
            this.dbY.setRecommendFrsNavigationAnimDispatcher(rVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.dbY != null) {
            this.dbY.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cpV != null) {
            this.cpV.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.dca);
        if (this.cpV != null) {
            this.cpV.onResume(getPageContext());
        }
        this.dbY.onResume();
        this.dbY.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cqT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dbY != null) {
            this.dbY.aqn();
        }
        MessageManager.getInstance().unRegisterListener(this.dca);
        if (this.cpV != null) {
            this.cpV.onPause(getPageContext());
        }
        this.dbY.onPause();
        this.dbY.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cpV != null) {
            this.cpV.onStop(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cqT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cpV != null) {
            this.cpV.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dcb);
        this.cpV = null;
        this.dbY.onDestroy();
        this.cZa = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.dbY.aqm();
            aqO();
            return;
        }
        this.dbY.aqn();
    }

    public void aqh() {
        this.dbY.setViewForeground(true);
    }

    public void aqN() {
        this.dbY.aqN();
    }

    public void completePullRefresh() {
        this.dbY.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dbY.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dbZ = bVar;
        this.dbY.setCallback(bVar);
    }

    public void N(String str, int i) {
        this.dbY.N(str, i);
    }

    public void aqi() {
        this.dbY.aqi();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.dbY.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.ah
    public void M(Intent intent) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void ahu() {
        this.dbY.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cpV == null) {
            this.cpV = VoiceManager.instance();
        }
        return this.cpV;
    }

    @Override // com.baidu.tieba.frs.ah
    public void ahf() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void ahg() {
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

    @Override // com.baidu.tieba.frs.ah
    public ForumWriteData ahv() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dbY.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void xc() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqO() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }
}
