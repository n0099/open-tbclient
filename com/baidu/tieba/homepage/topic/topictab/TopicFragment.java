package com.baidu.tieba.homepage.topic.topictab;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.homepage.topic.topictab.model.TopicModel;
import com.baidu.tieba.homepage.topic.topictab.view.TopicListView;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes16.dex */
public class TopicFragment extends BaseFragment implements f.c, ao, a {
    private TopicModel iFD;
    private TopicListView iFE;
    private boolean isb = false;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iFD.setPresenter(this);
        this.iFD.setUniqueId(getUniqueId());
        this.iFE.setPresenter(this);
        this.iFE.setListPullRefreshListener(this);
        this.iFE.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iFE.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iFE.getParent()).removeView(this.iFE);
        }
        if (this.isb) {
            this.iFE.bCM();
            this.isb = false;
        }
        return this.iFE;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.iFE.setViewForeground();
            TiebaStatic.log(new ap("c13349"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.iFE.gw(false);
        this.iFD.cop();
    }

    @Override // com.baidu.tieba.frs.ao
    public void IH() {
        this.iFE.reload();
    }

    @Override // com.baidu.tieba.frs.ao
    public void bwZ() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void bxa() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.ao
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void bci() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.iFE.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.iFD.cop();
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.iFE.bwX();
            this.iFE.gw(false);
            this.iFD.cop();
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void n(int i, List<q> list) {
        this.iFE.hideLoadingView();
        this.iFE.bxe();
        if (i != 0 || x.isEmpty(list)) {
            this.iFE.ng(false);
            return;
        }
        this.iFE.bwX();
        this.iFE.bBY();
        this.iFE.setData(list);
        this.iFE.bxT();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(x.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a021";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.iFE.destroy();
        this.iFD.onDestroy();
        this.isb = true;
    }
}
