package com.baidu.tieba.homepage.concern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.concern.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class b extends BaseFragment implements ah {
    private c cOs;
    private c.a cOt;
    private boolean cOu = false;

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.cOs = new c(context);
        this.cOs.anC();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.cOs.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.cOs.getParent()).removeView(this.cOs);
            if (this.cOt != null) {
                this.cOs.setCallback(this.cOt);
            }
        }
        this.cOs.setPageUniqueId(getUniqueId());
        if (this.cOu) {
            this.cOs.anC();
            this.cOu = false;
        }
        return this.cOs;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (this.cOs != null) {
            this.cOs.onLazyLoad();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.cOs != null) {
            this.cOs.setRecommendFrsNavigationAnimDispatcher(rVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.cOs.setTabInForeBackgroundState(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cOs.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cOs.onDestroy();
        this.cOu = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.cOs.anG();
            return;
        }
        this.cOs.anH();
        completePullRefresh();
    }

    public void anA() {
        this.cOs.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.cOs.completePullRefresh();
    }

    public void setCallback(c.a aVar) {
        this.cOt = aVar;
        this.cOs.setCallback(aVar);
    }

    public void N(String str, int i) {
        this.cOs.N(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.cOs != null) {
            this.cOs.a(dataRes, z);
        }
    }

    public void anB() {
        if (this.cOs != null) {
            this.cOs.anE();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void L(Intent intent) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void afp() {
        this.cOs.reload();
    }

    @Override // com.baidu.tieba.frs.ah
    public void afb() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void afc() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(u.c(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a038";
    }

    @Override // com.baidu.tieba.frs.ah
    public ForumWriteData afq() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cOs.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void wV() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
