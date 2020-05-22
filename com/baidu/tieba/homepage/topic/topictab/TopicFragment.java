package com.baidu.tieba.homepage.topic.topictab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.topic.topictab.model.TopicModel;
import com.baidu.tieba.homepage.topic.topictab.view.TopicListView;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes9.dex */
public class TopicFragment extends BaseFragment implements f.c, aj, a {
    private boolean hWL = false;
    private TopicModel ihF;
    private TopicListView ihG;

    public TopicFragment() {
    }

    public TopicFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.ihF = new TopicModel(pageContext);
        this.ihG = new TopicListView(pageContext);
        this.ihG.bwA();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ihF.setPresenter(this);
        this.ihF.setUniqueId(getUniqueId());
        this.ihG.setPresenter(this);
        this.ihG.setListPullRefreshListener(this);
        this.ihG.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.ihG.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ihG.getParent()).removeView(this.ihG);
        }
        if (this.hWL) {
            this.ihG.bwA();
            this.hWL = false;
        }
        return this.ihG;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.ihG.setViewForeground();
            TiebaStatic.log(new an("c13349"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.ihG.fV(false);
        this.ihF.cgT();
    }

    public void brJ() {
        this.ihG.brJ();
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ho() {
        this.ihG.reload();
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqQ() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqR() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void aWq() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.ihG.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.ihF.cgT();
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.ihG.bqO();
            this.ihG.fV(false);
            this.ihF.cgT();
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void o(int i, List<o> list) {
        this.ihG.hideLoadingView();
        this.ihG.bqV();
        if (i != 0 || v.isEmpty(list)) {
            this.ihG.mq(false);
            return;
        }
        this.ihG.bqO();
        this.ihG.bvM();
        this.ihG.setData(list);
        this.ihG.brL();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(v.getItem(arrayList, arrayList.size() - 1))) {
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
        this.ihG.destroy();
        this.ihF.onDestroy();
        this.hWL = true;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ihG != null) {
            this.ihG.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }
}
