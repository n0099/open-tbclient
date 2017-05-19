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
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends BaseFragment implements VoiceManager.c, bw {
    private VoiceManager bOm;
    private b cup;
    private com.baidu.tieba.homepage.framework.b cuq;
    private boolean cur = false;

    public a() {
    }

    public a(Context context) {
        this.cup = new b(context);
        this.cup.aht();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.cup.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.cup.getParent()).removeView(this.cup);
            if (this.cuq != null) {
                this.cup.setCallback(this.cuq);
            }
        }
        this.cup.setPageUniqueId(getUniqueId());
        if (this.cur) {
            this.cup.aht();
            this.cur = false;
        }
        return this.cup;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bOm = getVoiceManager();
        if (this.bOm != null) {
            this.bOm.onCreate(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.bw
    public void setHeaderViewHeight(int i) {
        this.cup.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.bw
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.t tVar) {
        if (this.cup != null) {
            this.cup.setRecommendFrsNavigationAnimDispatcher(tVar);
        }
    }

    @Override // com.baidu.tieba.frs.bw
    public void Xb() {
        if (this.cup != null) {
            this.cup.Xb();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.bOm != null) {
            this.bOm.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bOm != null) {
            this.bOm.onResume(getPageContext());
        }
        this.cup.onResume();
        this.cup.setTabInForeBackgroundState(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bOm != null) {
            this.bOm.onPause(getPageContext());
        }
        this.cup.onPause();
        this.cup.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.bOm != null) {
            this.bOm.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bOm != null) {
            this.bOm.onDestory(getPageContext());
        }
        this.bOm = null;
        this.cup.onDestroy();
        this.cur = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.cup.ahv();
        } else {
            this.cup.ahw();
        }
    }

    public void ahl() {
        this.cup.setViewForeground(true);
    }

    public void ahs() {
        this.cup.ahs();
    }

    public void completePullRefresh() {
        this.cup.completePullRefresh();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cup.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cuq = bVar;
        this.cup.setCallback(bVar);
    }

    public void M(String str, int i) {
        this.cup.M(str, i);
    }

    public void ahj() {
        this.cup.ahj();
    }

    public long getTagCode() {
        return this.cup.getTagCode();
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        this.cup.d(dataRes, z, z2);
    }

    @Override // com.baidu.tieba.frs.bw
    public void K(Intent intent) {
    }

    @Override // com.baidu.tieba.frs.bw
    public void Zu() {
        this.cup.reload();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bOm == null) {
            this.bOm = VoiceManager.instance();
        }
        return this.bOm;
    }

    @Override // com.baidu.tieba.frs.bw
    public void Zg() {
    }

    @Override // com.baidu.tieba.frs.bw
    public void Zh() {
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

    @Override // com.baidu.tieba.frs.bw
    public ForumWriteData Zv() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cup.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.bw
    public void ww() {
        changeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }
}
