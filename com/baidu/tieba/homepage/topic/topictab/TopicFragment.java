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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.topic.topictab.model.TopicModel;
import com.baidu.tieba.homepage.topic.topictab.view.TopicListView;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes22.dex */
public class TopicFragment extends BaseFragment implements f.c, aq, a {
    private TopicModel jKK;
    private TopicListView jKL;
    private boolean jvr = false;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jKK.setPresenter(this);
        this.jKK.setUniqueId(getUniqueId());
        this.jKL.setPresenter(this);
        this.jKL.setListPullRefreshListener(this);
        this.jKL.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.jKL.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jKL.getParent()).removeView(this.jKL);
        }
        if (this.jvr) {
            this.jKL.bWm();
            this.jvr = false;
        }
        return this.jKL;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.jKL.setViewForeground();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13349"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.jKL.hJ(false);
        this.jKK.cMh();
    }

    @Override // com.baidu.tieba.frs.aq
    public void TL() {
        this.jKL.reload();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bPc() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bPd() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bsD() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.jKL.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.jKK.cMh();
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.jKL.Wk();
            this.jKL.hJ(false);
            this.jKK.cMh();
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void o(int i, List<q> list) {
        this.jKL.hideLoadingView();
        this.jKL.bPh();
        if (i != 0 || y.isEmpty(list)) {
            this.jKL.oY(false);
            return;
        }
        this.jKL.Wk();
        this.jKL.bVq();
        this.jKL.setData(list);
        this.jKL.Wj();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(y.getItem(arrayList, arrayList.size() - 1))) {
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
        this.jKL.destroy();
        this.jKK.onDestroy();
        this.jvr = true;
    }
}
