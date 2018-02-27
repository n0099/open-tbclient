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
import com.baidu.tbadk.core.util.aw;
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
    private VoiceManager dEk;
    private com.baidu.tieba.homepage.framework.b eiA;
    private d eiz;
    private boolean efy = false;
    private CustomMessageListener eiB = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.isPrimary()) {
                b.this.aCH();
            }
        }
    };
    private final CustomMessageListener dFp = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.homepage.personalize.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    aw.Dt().c(b.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    private final CustomMessageListener eiC = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && b.this.eiz != null) {
                b.this.eiz.e(l);
            }
        }
    };
    private final CustomMessageListener dpp = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.eiz.aCI();
            }
        }
    };

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.eiz = new d(context);
        this.eiz.aye();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.eiz.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.eiz.getParent()).removeView(this.eiz);
            if (this.eiA != null) {
                this.eiz.setCallback(this.eiA);
            }
        }
        this.eiz.setPageUniqueId(getUniqueId());
        if (this.efy) {
            this.eiz.aye();
            this.efy = false;
        }
        return this.eiz;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dEk = getVoiceManager();
        if (this.dEk != null) {
            this.dEk.onCreate(getPageContext());
        }
        this.eiB.setTag(getUniqueId());
        registerListener(this.eiB);
        registerListener(this.eiC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        this.eiz.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.eiz != null) {
            this.eiz.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.eiz != null) {
            this.eiz.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dEk != null) {
            this.dEk.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dEk != null) {
            this.dEk.onResume(getPageContext());
        }
        this.eiz.onResume();
        this.eiz.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.dFp);
        MessageManager.getInstance().registerListener(this.dpp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eiz != null) {
            this.eiz.aCi();
            this.eiz.onPause();
            this.eiz.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.dpp);
        if (this.dEk != null) {
            this.dEk.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dEk != null) {
            this.dEk.onStop(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dFp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dEk != null) {
            this.dEk.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.eiB);
        MessageManager.getInstance().unRegisterListener(this.eiC);
        this.dEk = null;
        this.eiz.onDestroy();
        this.efy = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.eiz.aCh();
            aCH();
            return;
        }
        this.eiz.aCi();
    }

    public void XK() {
        this.eiz.setViewForeground(true);
    }

    public void aCG() {
        this.eiz.aCG();
    }

    public void completePullRefresh() {
        this.eiz.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eiz.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.eiA = bVar;
        this.eiz.setCallback(bVar);
    }

    public void Y(String str, int i) {
        this.eiz.Y(str, i);
    }

    public void aCd() {
        this.eiz.aCd();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.eiz.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xo() {
        this.eiz.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dEk == null) {
            this.dEk = VoiceManager.instance();
        }
        return this.dEk;
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xp() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xq() {
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
        this.eiz.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Em() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCH() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }
}
