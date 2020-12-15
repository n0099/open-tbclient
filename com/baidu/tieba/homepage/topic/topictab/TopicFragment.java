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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.homepage.topic.topictab.model.TopicModel;
import com.baidu.tieba.homepage.topic.topictab.view.TopicListView;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes22.dex */
public class TopicFragment extends BaseFragment implements f.c, ap, a {
    private boolean jJG = false;
    private TopicModel jZa;
    private TopicListView jZb;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jZa.setPresenter(this);
        this.jZa.setUniqueId(getUniqueId());
        this.jZb.setPresenter(this);
        this.jZb.setListPullRefreshListener(this);
        this.jZb.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.jZb.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jZb.getParent()).removeView(this.jZb);
        }
        if (this.jJG) {
            this.jZb.bZq();
            this.jJG = false;
        }
        return this.jZb;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.jZb.setViewForeground();
            TiebaStatic.log(new ar("c13349"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.jZb.ib(false);
        this.jZa.cRd();
    }

    @Override // com.baidu.tieba.frs.ap
    public void VC() {
        this.jZb.reload();
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSh() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSi() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
    }

    @Override // com.baidu.tieba.frs.ap
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void bvt() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.jZb.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.jZa.cRd();
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.jZb.Yb();
            this.jZb.ib(false);
            this.jZa.cRd();
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void o(int i, List<q> list) {
        this.jZb.hideLoadingView();
        this.jZb.bSm();
        if (i != 0 || y.isEmpty(list)) {
            this.jZb.px(false);
            return;
        }
        this.jZb.Yb();
        this.jZb.bYt();
        this.jZb.setData(list);
        this.jZb.Ya();
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
        this.jZb.destroy();
        this.jZa.onDestroy();
        this.jJG = true;
    }
}
