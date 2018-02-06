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
    private VoiceManager dEw;
    private d eiL;
    private com.baidu.tieba.homepage.framework.b eiM;
    private boolean efK = false;
    private CustomMessageListener eiN = new CustomMessageListener(2921029) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.isPrimary()) {
                b.this.aCI();
            }
        }
    };
    private final CustomMessageListener dFB = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.homepage.personalize.b.2
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
    private final CustomMessageListener eiO = new CustomMessageListener(2921313) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && b.this.eiL != null) {
                b.this.eiL.e(l);
            }
        }
    };
    private final CustomMessageListener dpB = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.personalize.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.eiL.aCJ();
            }
        }
    };

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.eiL = new d(context);
        this.eiL.ayf();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.eiL.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.eiL.getParent()).removeView(this.eiL);
            if (this.eiM != null) {
                this.eiL.setCallback(this.eiM);
            }
        }
        this.eiL.setPageUniqueId(getUniqueId());
        if (this.efK) {
            this.eiL.ayf();
            this.efK = false;
        }
        return this.eiL;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dEw = getVoiceManager();
        if (this.dEw != null) {
            this.dEw.onCreate(getPageContext());
        }
        this.eiN.setTag(getUniqueId());
        registerListener(this.eiN);
        registerListener(this.eiO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        this.eiL.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.eiL != null) {
            this.eiL.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.eiL != null) {
            this.eiL.showFloatingView();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dEw != null) {
            this.dEw.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dEw != null) {
            this.dEw.onResume(getPageContext());
        }
        this.eiL.onResume();
        this.eiL.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.dFB);
        MessageManager.getInstance().registerListener(this.dpB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eiL != null) {
            this.eiL.aCj();
            this.eiL.onPause();
            this.eiL.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.dpB);
        if (this.dEw != null) {
            this.dEw.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dEw != null) {
            this.dEw.onStop(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dFB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dEw != null) {
            this.dEw.onDestory(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.eiN);
        MessageManager.getInstance().unRegisterListener(this.eiO);
        this.dEw = null;
        this.eiL.onDestroy();
        this.efK = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.eiL.aCi();
            aCI();
            return;
        }
        this.eiL.aCj();
    }

    public void XL() {
        this.eiL.setViewForeground(true);
    }

    public void aCH() {
        this.eiL.aCH();
    }

    public void completePullRefresh() {
        this.eiL.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eiL.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.eiM = bVar;
        this.eiL.setCallback(bVar);
    }

    public void Y(String str, int i) {
        this.eiL.Y(str, i);
    }

    public void aCe() {
        this.eiL.aCe();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.eiL.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xp() {
        this.eiL.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dEw == null) {
            this.dEw = VoiceManager.instance();
        }
        return this.dEw;
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
        this.eiL.onChangeSkinType(i);
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
