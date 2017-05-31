package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends BaseFragment implements VoiceManager.c, bx {
    private VoiceManager bTZ;
    private b cAH;
    private com.baidu.tieba.homepage.framework.b cAI;
    private boolean cAJ = false;

    public a() {
    }

    public a(Context context) {
        this.cAH = new b(context);
        this.cAH.aiI();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.cAH.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.cAH.getParent()).removeView(this.cAH);
            if (this.cAI != null) {
                this.cAH.setCallback(this.cAI);
            }
        }
        this.cAH.setPageUniqueId(getUniqueId());
        if (this.cAJ) {
            this.cAH.aiI();
            this.cAJ = false;
        }
        return this.cAH;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bTZ = getVoiceManager();
        if (this.bTZ != null) {
            this.bTZ.onCreate(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.bx
    public void setHeaderViewHeight(int i) {
        this.cAH.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.bx
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.t tVar) {
        if (this.cAH != null) {
            this.cAH.setRecommendFrsNavigationAnimDispatcher(tVar);
        }
    }

    @Override // com.baidu.tieba.frs.bx
    public void Ye() {
        if (this.cAH != null) {
            this.cAH.Ye();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.bTZ != null) {
            this.bTZ.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bTZ != null) {
            this.bTZ.onResume(getPageContext());
        }
        this.cAH.onResume();
        this.cAH.setTabInForeBackgroundState(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bTZ != null) {
            this.bTZ.onPause(getPageContext());
        }
        this.cAH.onPause();
        this.cAH.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.bTZ != null) {
            this.bTZ.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bTZ != null) {
            this.bTZ.onDestory(getPageContext());
        }
        this.bTZ = null;
        this.cAH.onDestroy();
        this.cAJ = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.cAH.aiK();
        } else {
            this.cAH.aiL();
        }
    }

    public void aiA() {
        this.cAH.setViewForeground(true);
    }

    public void aiH() {
        this.cAH.aiH();
    }

    public void completePullRefresh() {
        this.cAH.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cAH.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cAI = bVar;
        this.cAH.setCallback(bVar);
    }

    public void M(String str, int i) {
        this.cAH.M(str, i);
    }

    public void aiy() {
        this.cAH.aiy();
    }

    public long getTagCode() {
        return this.cAH.getTagCode();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.cAH.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.bx
    public void K(Intent intent) {
    }

    @Override // com.baidu.tieba.frs.bx
    public void aax() {
        this.cAH.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bTZ == null) {
            this.bTZ = VoiceManager.instance();
        }
        return this.bTZ;
    }

    @Override // com.baidu.tieba.frs.bx
    public void aak() {
    }

    @Override // com.baidu.tieba.frs.bx
    public void aal() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(com.baidu.tbadk.core.util.x.c(arrayList, arrayList.size() - 1))) {
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

    @Override // com.baidu.tieba.frs.bx
    public ForumWriteData aay() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cAH.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.bx
    public void ws() {
        changeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }
}
