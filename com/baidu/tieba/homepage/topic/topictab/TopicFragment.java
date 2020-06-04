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
    private boolean hXy = false;
    private TopicModel iis;
    private TopicListView iit;

    public TopicFragment() {
    }

    public TopicFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.iis = new TopicModel(pageContext);
        this.iit = new TopicListView(pageContext);
        this.iit.bwC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iis.setPresenter(this);
        this.iis.setUniqueId(getUniqueId());
        this.iit.setPresenter(this);
        this.iit.setListPullRefreshListener(this);
        this.iit.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iit.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iit.getParent()).removeView(this.iit);
        }
        if (this.hXy) {
            this.iit.bwC();
            this.hXy = false;
        }
        return this.iit;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.iit.setViewForeground();
            TiebaStatic.log(new an("c13349"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.iit.fV(false);
        this.iis.chc();
    }

    public void brL() {
        this.iit.brL();
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ho() {
        this.iit.reload();
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqS() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqT() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void aWr() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.iit.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.iis.chc();
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.iit.bqQ();
            this.iit.fV(false);
            this.iis.chc();
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void o(int i, List<o> list) {
        this.iit.hideLoadingView();
        this.iit.bqX();
        if (i != 0 || v.isEmpty(list)) {
            this.iit.mq(false);
            return;
        }
        this.iit.bqQ();
        this.iit.bvO();
        this.iit.setData(list);
        this.iit.brN();
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
        this.iit.destroy();
        this.iis.onDestroy();
        this.hXy = true;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.iit != null) {
            this.iit.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }
}
