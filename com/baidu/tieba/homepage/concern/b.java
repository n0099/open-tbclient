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
    private c cPN;
    private c.a cPO;
    private boolean cPP = false;

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.cPN = new c(context);
        this.cPN.anP();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.cPN.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.cPN.getParent()).removeView(this.cPN);
            if (this.cPO != null) {
                this.cPN.setCallback(this.cPO);
            }
        }
        this.cPN.setPageUniqueId(getUniqueId());
        if (this.cPP) {
            this.cPN.anP();
            this.cPP = false;
        }
        return this.cPN;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.cPN != null) {
            this.cPN.setRecommendFrsNavigationAnimDispatcher(rVar);
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
        this.cPN.setTabInForeBackgroundState(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cPN.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cPN.onDestroy();
        this.cPP = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.cPN.anS();
            return;
        }
        this.cPN.anT();
        completePullRefresh();
    }

    public void anN() {
        this.cPN.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.cPN.completePullRefresh();
    }

    public void setCallback(c.a aVar) {
        this.cPO = aVar;
        this.cPN.setCallback(aVar);
    }

    public void N(String str, int i) {
        this.cPN.N(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.cPN != null) {
            this.cPN.a(dataRes, z);
        }
    }

    public void anO() {
        if (this.cPN != null) {
            this.cPN.anQ();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void L(Intent intent) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void afu() {
        this.cPN.reload();
    }

    @Override // com.baidu.tieba.frs.ah
    public void afg() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void afh() {
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
    public ForumWriteData afv() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cPN.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void xd() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
