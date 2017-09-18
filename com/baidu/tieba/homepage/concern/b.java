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
    private c cYY;
    private c.a cYZ;
    private boolean cZa = false;

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.cYY = new c(context);
        this.cYY.aqj();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.cYY.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.cYY.getParent()).removeView(this.cYY);
            if (this.cYZ != null) {
                this.cYY.setCallback(this.cYZ);
            }
        }
        this.cYY.setPageUniqueId(getUniqueId());
        if (this.cZa) {
            this.cYY.aqj();
            this.cZa = false;
        }
        return this.cYY;
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
        if (this.cYY != null) {
            this.cYY.setRecommendFrsNavigationAnimDispatcher(rVar);
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
        this.cYY.setTabInForeBackgroundState(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cYY.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cYY.onDestroy();
        this.cZa = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.cYY.aqm();
            return;
        }
        this.cYY.aqn();
        completePullRefresh();
    }

    public void aqh() {
        this.cYY.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.cYY.completePullRefresh();
    }

    public void setCallback(c.a aVar) {
        this.cYZ = aVar;
        this.cYY.setCallback(aVar);
    }

    public void N(String str, int i) {
        this.cYY.N(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.cYY != null) {
            this.cYY.a(dataRes, z);
        }
    }

    public void aqi() {
        if (this.cYY != null) {
            this.cYY.aqk();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void M(Intent intent) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void ahu() {
        this.cYY.reload();
    }

    @Override // com.baidu.tieba.frs.ah
    public void ahf() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void ahg() {
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
    public ForumWriteData ahv() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cYY.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void xc() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
