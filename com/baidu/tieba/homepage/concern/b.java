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
    private c cRK;
    private c.a cRL;
    private boolean cRM = false;

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.cRK = new c(context);
        this.cRK.aop();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.cRK.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.cRK.getParent()).removeView(this.cRK);
            if (this.cRL != null) {
                this.cRK.setCallback(this.cRL);
            }
        }
        this.cRK.setPageUniqueId(getUniqueId());
        if (this.cRM) {
            this.cRK.aop();
            this.cRM = false;
        }
        return this.cRK;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (this.cRK != null) {
            this.cRK.onLazyLoad();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.cRK != null) {
            this.cRK.setRecommendFrsNavigationAnimDispatcher(rVar);
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
        this.cRK.setTabInForeBackgroundState(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cRK.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cRK.onDestroy();
        this.cRM = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.cRK.aot();
            return;
        }
        this.cRK.aou();
        completePullRefresh();
    }

    public void aon() {
        this.cRK.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.cRK.completePullRefresh();
    }

    public void setCallback(c.a aVar) {
        this.cRL = aVar;
        this.cRK.setCallback(aVar);
    }

    public void N(String str, int i) {
        this.cRK.N(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.cRK != null) {
            this.cRK.a(dataRes, z);
        }
    }

    public void aoo() {
        if (this.cRK != null) {
            this.cRK.aor();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void N(Intent intent) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void afL() {
        this.cRK.reload();
    }

    @Override // com.baidu.tieba.frs.ah
    public void afw() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void afx() {
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
    public ForumWriteData afM() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cRK.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void xd() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
