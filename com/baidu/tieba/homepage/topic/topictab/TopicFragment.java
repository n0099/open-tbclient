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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.homepage.topic.topictab.model.TopicModel;
import com.baidu.tieba.homepage.topic.topictab.view.TopicListView;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes9.dex */
public class TopicFragment extends BaseFragment implements f.c, ao, a {
    private boolean ilW = false;
    private TopicModel izx;
    private TopicListView izy;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.izx.setPresenter(this);
        this.izx.setUniqueId(getUniqueId());
        this.izy.setPresenter(this);
        this.izy.setListPullRefreshListener(this);
        this.izy.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.izy.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.izy.getParent()).removeView(this.izy);
        }
        if (this.ilW) {
            this.izy.bzx();
            this.ilW = false;
        }
        return this.izy;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.izy.setViewForeground();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13349"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.izy.ga(false);
        this.izx.ckO();
    }

    @Override // com.baidu.tieba.frs.ao
    public void IB() {
        this.izy.reload();
    }

    @Override // com.baidu.tieba.frs.ao
    public void btP() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void btQ() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.ao
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void aYj() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.izy.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.izx.ckO();
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.izy.btN();
            this.izy.ga(false);
            this.izx.ckO();
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void n(int i, List<q> list) {
        this.izy.hideLoadingView();
        this.izy.btU();
        if (i != 0 || w.isEmpty(list)) {
            this.izy.mB(false);
            return;
        }
        this.izy.btN();
        this.izy.byJ();
        this.izy.setData(list);
        this.izy.buJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(w.getItem(arrayList, arrayList.size() - 1))) {
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
        this.izy.destroy();
        this.izx.onDestroy();
        this.ilW = true;
    }
}
