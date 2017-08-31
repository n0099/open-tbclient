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
    private VoiceManager cpd;
    private c dbe;
    private com.baidu.tieba.homepage.framework.b dbf;
    private boolean cYg = false;
    CustomMessageListener dbg = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_ACT_DIALOG) { // from class: com.baidu.tieba.homepage.personalize.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof CustomDialogData)) {
                com.baidu.tieba.pb.c.a(a.this.getPageContext(), (CustomDialogData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dbh = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.isPrimary()) {
                a.this.aqD();
            }
        }
    };
    private final CustomMessageListener cqb = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.homepage.personalize.a.3
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
        this.dbe = new c(context);
        this.dbe.apY();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dbe.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dbe.getParent()).removeView(this.dbe);
            if (this.dbf != null) {
                this.dbe.setCallback(this.dbf);
            }
        }
        this.dbe.setPageUniqueId(getUniqueId());
        if (this.cYg) {
            this.dbe.apY();
            this.cYg = false;
        }
        return this.dbe;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cpd = getVoiceManager();
        if (this.cpd != null) {
            this.cpd.onCreate(getPageContext());
        }
        this.dbh.setTag(getUniqueId());
        registerListener(this.dbh);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dbe.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.dbe != null) {
            this.dbe.setRecommendFrsNavigationAnimDispatcher(rVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.dbe != null) {
            this.dbe.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cpd != null) {
            this.cpd.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.dbg);
        if (this.cpd != null) {
            this.cpd.onResume(getPageContext());
        }
        this.dbe.onResume();
        this.dbe.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cqb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.dbg);
        if (this.cpd != null) {
            this.cpd.onPause(getPageContext());
        }
        this.dbe.onPause();
        this.dbe.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cpd != null) {
            this.cpd.onStop(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cqb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cpd != null) {
            this.cpd.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dbh);
        this.cpd = null;
        this.dbe.onDestroy();
        this.cYg = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.dbe.aqb();
            aqD();
            return;
        }
        this.dbe.aqc();
    }

    public void apW() {
        this.dbe.setViewForeground(true);
    }

    public void aqC() {
        this.dbe.aqC();
    }

    public void completePullRefresh() {
        this.dbe.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dbe.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dbf = bVar;
        this.dbe.setCallback(bVar);
    }

    public void N(String str, int i) {
        this.dbe.N(str, i);
    }

    public void apX() {
        this.dbe.apX();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.dbe.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.ah
    public void N(Intent intent) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void ahj() {
        this.dbe.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cpd == null) {
            this.cpd = VoiceManager.instance();
        }
        return this.cpd;
    }

    @Override // com.baidu.tieba.frs.ah
    public void agU() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void agV() {
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
    public ForumWriteData ahk() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dbe.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void xc() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqD() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }
}
