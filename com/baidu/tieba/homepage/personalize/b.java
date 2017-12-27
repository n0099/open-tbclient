package com.baidu.tieba.homepage.personalize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes2.dex */
public class b extends BaseFragment implements VoiceManager.c, aj {
    private VoiceManager dwG;
    private d ecT;
    private com.baidu.tieba.homepage.framework.b ecU;
    private boolean dZS = false;
    private CustomMessageListener ecV = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.isPrimary()) {
                b.this.aBh();
            }
        }
    };
    private final CustomMessageListener dxH = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.homepage.personalize.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    av.Di().c(b.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    private final CustomMessageListener ecW = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GOD_REPLY) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && b.this.ecT != null) {
                b.this.ecT.e(l);
            }
        }
    };
    private final CustomMessageListener dhO = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.ecT.aBi();
            }
        }
    };

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.ecT = new d(context);
        this.ecT.avZ();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.ecT.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ecT.getParent()).removeView(this.ecT);
            if (this.ecU != null) {
                this.ecT.setCallback(this.ecU);
            }
        }
        this.ecT.setPageUniqueId(getUniqueId());
        if (this.dZS) {
            this.ecT.avZ();
            this.dZS = false;
        }
        return this.ecT;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dwG = getVoiceManager();
        if (this.dwG != null) {
            this.dwG.onCreate(getPageContext());
        }
        this.ecV.setTag(getUniqueId());
        registerListener(this.ecV);
        registerListener(this.ecW);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        this.ecT.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.ecT != null) {
            this.ecT.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.ecT != null) {
            this.ecT.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dwG != null) {
            this.dwG.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dwG != null) {
            this.dwG.onResume(getPageContext());
        }
        this.ecT.onResume();
        this.ecT.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.dxH);
        MessageManager.getInstance().registerListener(this.dhO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ecT != null) {
            this.ecT.aAI();
            this.ecT.onPause();
            this.ecT.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.dhO);
        if (this.dwG != null) {
            this.dwG.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dwG != null) {
            this.dwG.onStop(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dxH);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dwG != null) {
            this.dwG.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.ecV);
        MessageManager.getInstance().unRegisterListener(this.ecW);
        this.dwG = null;
        this.ecT.onDestroy();
        this.dZS = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.ecT.aAH();
            aBh();
            return;
        }
        this.ecT.aAI();
    }

    public void XM() {
        this.ecT.setViewForeground(true);
    }

    public void aBg() {
        this.ecT.aBg();
    }

    public void completePullRefresh() {
        this.ecT.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ecT.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.ecU = bVar;
        this.ecT.setCallback(bVar);
    }

    public void Y(String str, int i) {
        this.ecT.Y(str, i);
    }

    public void aAD() {
        this.ecT.aAD();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        Log.e("guomingop", "mCurrent:" + this.ecT);
        this.ecT.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.aj
    public void WI() {
        this.ecT.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dwG == null) {
            this.dwG = VoiceManager.instance();
        }
        return this.dwG;
    }

    @Override // com.baidu.tieba.frs.aj
    public void WJ() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void WK() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(v.f(arrayList, arrayList.size() - 1))) {
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
        this.ecT.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ea() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBh() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }
}
