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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.concern.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class b extends BaseFragment implements ah {
    private c cYe;
    private c.a cYf;
    private boolean cYg = false;

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.cYe = new c(context);
        this.cYe.apY();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.cYe.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.cYe.getParent()).removeView(this.cYe);
            if (this.cYf != null) {
                this.cYe.setCallback(this.cYf);
            }
        }
        this.cYe.setPageUniqueId(getUniqueId());
        if (this.cYg) {
            this.cYe.apY();
            this.cYg = false;
        }
        return this.cYe;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.cYe != null) {
            this.cYe.setRecommendFrsNavigationAnimDispatcher(rVar);
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
        this.cYe.setTabInForeBackgroundState(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cYe.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cYe.onDestroy();
        this.cYg = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.cYe.aqb();
            return;
        }
        this.cYe.aqc();
        completePullRefresh();
    }

    public void apW() {
        this.cYe.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.cYe.completePullRefresh();
    }

    public void setCallback(c.a aVar) {
        this.cYf = aVar;
        this.cYe.setCallback(aVar);
    }

    public void N(String str, int i) {
        this.cYe.N(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.cYe != null) {
            this.cYe.a(dataRes, z);
        }
    }

    public void apX() {
        if (this.cYe != null) {
            this.cYe.apZ();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void N(Intent intent) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void ahj() {
        this.cYe.reload();
    }

    @Override // com.baidu.tieba.frs.ah
    public void agU() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void agV() {
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
        return "a038";
    }

    @Override // com.baidu.tieba.frs.ah
    public ForumWriteData ahk() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cYe.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void xc() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
