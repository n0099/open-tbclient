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
    private VoiceManager dEn;
    private d eiP;
    private com.baidu.tieba.homepage.framework.b eiQ;
    private boolean efO = false;
    private CustomMessageListener eiR = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.isPrimary()) {
                b.this.aCI();
            }
        }
    };
    private final CustomMessageListener dFt = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.homepage.personalize.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    aw.Du().c(b.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    private final CustomMessageListener eiS = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && b.this.eiP != null) {
                b.this.eiP.e(l);
            }
        }
    };
    private final CustomMessageListener dps = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.eiP.aCJ();
            }
        }
    };

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.eiP = new d(context);
        this.eiP.ayg();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.eiP.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.eiP.getParent()).removeView(this.eiP);
            if (this.eiQ != null) {
                this.eiP.setCallback(this.eiQ);
            }
        }
        this.eiP.setPageUniqueId(getUniqueId());
        if (this.efO) {
            this.eiP.ayg();
            this.efO = false;
        }
        return this.eiP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dEn = getVoiceManager();
        if (this.dEn != null) {
            this.dEn.onCreate(getPageContext());
        }
        this.eiR.setTag(getUniqueId());
        registerListener(this.eiR);
        registerListener(this.eiS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        this.eiP.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.eiP != null) {
            this.eiP.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.eiP != null) {
            this.eiP.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dEn != null) {
            this.dEn.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dEn != null) {
            this.dEn.onResume(getPageContext());
        }
        this.eiP.onResume();
        this.eiP.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.dFt);
        MessageManager.getInstance().registerListener(this.dps);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eiP != null) {
            this.eiP.aCj();
            this.eiP.onPause();
            this.eiP.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.dps);
        if (this.dEn != null) {
            this.dEn.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dEn != null) {
            this.dEn.onStop(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dFt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dEn != null) {
            this.dEn.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.eiR);
        MessageManager.getInstance().unRegisterListener(this.eiS);
        this.dEn = null;
        this.eiP.onDestroy();
        this.efO = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.eiP.aCi();
            aCI();
            return;
        }
        this.eiP.aCj();
    }

    public void XL() {
        this.eiP.setViewForeground(true);
    }

    public void aCH() {
        this.eiP.aCH();
    }

    public void completePullRefresh() {
        this.eiP.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eiP.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.eiQ = bVar;
        this.eiP.setCallback(bVar);
    }

    public void Y(String str, int i) {
        this.eiP.Y(str, i);
    }

    public void aCe() {
        this.eiP.aCe();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.eiP.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xp() {
        this.eiP.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dEn == null) {
            this.dEn = VoiceManager.instance();
        }
        return this.dEn;
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xq() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xr() {
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
        this.eiP.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aj
    public void En() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCI() {
        if (TbadkCoreApplication.getInst().isFirstTimeMotivate() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }
}
