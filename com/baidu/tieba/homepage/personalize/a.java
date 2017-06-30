package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends BaseFragment implements VoiceManager.c, by {
    private i cIt;
    private com.baidu.tieba.homepage.framework.b cIu;
    private VoiceManager cci;
    private boolean cIv = false;
    CustomMessageListener cIw = new b(this, CmdConfigCustom.CMD_SHOW_NICK_NAME_ACT);
    private CustomMessageListener cIx = new c(this, CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL);
    private final CustomMessageListener cdd = new d(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);

    public a() {
    }

    public a(Context context) {
        this.cIt = new i(context);
        this.cIt.amu();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.cIt.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.cIt.getParent()).removeView(this.cIt);
            if (this.cIu != null) {
                this.cIt.setCallback(this.cIu);
            }
        }
        this.cIt.setPageUniqueId(getUniqueId());
        if (this.cIv) {
            this.cIt.amu();
            this.cIv = false;
        }
        return this.cIt;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cci = getVoiceManager();
        if (this.cci != null) {
            this.cci.onCreate(getPageContext());
        }
        this.cIx.setTag(getUniqueId());
        registerListener(this.cIx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.by
    public void setHeaderViewHeight(int i) {
        this.cIt.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.by
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.u uVar) {
        if (this.cIt != null) {
            this.cIt.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    @Override // com.baidu.tieba.frs.by
    public void showFloatingView() {
        if (this.cIt != null) {
            this.cIt.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cci != null) {
            this.cci.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.cIw);
        if (this.cci != null) {
            this.cci.onResume(getPageContext());
        }
        this.cIt.onResume();
        this.cIt.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cdd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.cIw);
        if (this.cci != null) {
            this.cci.onPause(getPageContext());
        }
        this.cIt.onPause();
        this.cIt.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cci != null) {
            this.cci.onStop(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cdd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cci != null) {
            this.cci.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cIx);
        this.cci = null;
        this.cIt.onDestroy();
        this.cIv = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.cIt.amw();
            amt();
            return;
        }
        this.cIt.amx();
    }

    public void aml() {
        this.cIt.setViewForeground(true);
    }

    public void ams() {
        this.cIt.ams();
    }

    public void completePullRefresh() {
        this.cIt.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cIt.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cIu = bVar;
        this.cIt.setCallback(bVar);
    }

    public void O(String str, int i) {
        this.cIt.O(str, i);
    }

    public void amj() {
        this.cIt.amj();
    }

    public long getTagCode() {
        return this.cIt.getTagCode();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.cIt.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.by
    public void K(Intent intent) {
    }

    @Override // com.baidu.tieba.frs.by
    public void aen() {
        this.cIt.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cci == null) {
            this.cci = VoiceManager.instance();
        }
        return this.cci;
    }

    @Override // com.baidu.tieba.frs.by
    public void aeb() {
    }

    @Override // com.baidu.tieba.frs.by
    public void aec() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(com.baidu.tbadk.core.util.z.c(arrayList, arrayList.size() - 1))) {
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

    @Override // com.baidu.tieba.frs.by
    public ForumWriteData aeo() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cIt.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.by
    public void wK() {
        changeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amt() {
        if (TbadkCoreApplication.m9getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }
}
