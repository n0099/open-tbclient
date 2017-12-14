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
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class b extends BaseFragment implements VoiceManager.c, aj {
    private VoiceManager cHh;
    private d dqJ;
    private com.baidu.tieba.homepage.framework.b dqK;
    private boolean dnG = false;
    private CustomMessageListener dqL = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.isPrimary()) {
                b.this.auf();
            }
        }
    };
    private final CustomMessageListener cIg = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.homepage.personalize.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    av.vI().c(b.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    private final CustomMessageListener dqM = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && b.this.dqJ != null) {
                b.this.dqJ.e(l);
            }
        }
    };
    private final CustomMessageListener ctm = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.dqJ.aug();
            }
        }
    };

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.dqJ = new d(context);
        this.dqJ.aoZ();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dqJ.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dqJ.getParent()).removeView(this.dqJ);
            if (this.dqK != null) {
                this.dqJ.setCallback(this.dqK);
            }
        }
        this.dqJ.setPageUniqueId(getUniqueId());
        if (this.dnG) {
            this.dqJ.aoZ();
            this.dnG = false;
        }
        return this.dqJ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cHh = getVoiceManager();
        if (this.cHh != null) {
            this.cHh.onCreate(getPageContext());
        }
        this.dqL.setTag(getUniqueId());
        registerListener(this.dqL);
        registerListener(this.dqM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        this.dqJ.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dqJ != null) {
            this.dqJ.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.dqJ != null) {
            this.dqJ.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cHh != null) {
            this.cHh.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cHh != null) {
            this.cHh.onResume(getPageContext());
        }
        this.dqJ.onResume();
        this.dqJ.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.cIg);
        MessageManager.getInstance().registerListener(this.ctm);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dqJ != null) {
            this.dqJ.atE();
            this.dqJ.onPause();
            this.dqJ.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.ctm);
        if (this.cHh != null) {
            this.cHh.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cHh != null) {
            this.cHh.onStop(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cIg);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cHh != null) {
            this.cHh.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dqL);
        MessageManager.getInstance().unRegisterListener(this.dqM);
        this.cHh = null;
        this.dqJ.onDestroy();
        this.dnG = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.dqJ.atC();
            auf();
            return;
        }
        this.dqJ.atE();
    }

    public void Qo() {
        this.dqJ.setViewForeground(true);
    }

    public void aue() {
        this.dqJ.aue();
    }

    public void completePullRefresh() {
        this.dqJ.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dqJ.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dqK = bVar;
        this.dqJ.setCallback(bVar);
    }

    public void W(String str, int i) {
        this.dqJ.W(str, i);
    }

    public void aty() {
        this.dqJ.aty();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.dqJ.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Pj() {
        this.dqJ.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cHh == null) {
            this.cHh = VoiceManager.instance();
        }
        return this.cHh;
    }

    @Override // com.baidu.tieba.frs.aj
    public void Pk() {
    }

    @Override // com.baidu.tieba.frs.aj
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
        this.dqJ.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aj
    public void wC() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auf() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }
}
