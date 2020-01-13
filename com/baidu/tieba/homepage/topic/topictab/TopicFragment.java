package com.baidu.tieba.homepage.topic.topictab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.topic.topictab.model.TopicModel;
import com.baidu.tieba.homepage.topic.topictab.view.TopicListView;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes7.dex */
public class TopicFragment extends BaseFragment implements g.c, af, a {
    private boolean gUI = false;
    private TopicModel hfr;
    private TopicListView hfs;

    public TopicFragment() {
    }

    public TopicFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.hfr = new TopicModel(pageContext);
        this.hfs = new TopicListView(pageContext);
        this.hfs.initListeners();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hfr.setPresenter(this);
        this.hfr.setUniqueId(getUniqueId());
        this.hfs.setPresenter(this);
        this.hfs.setListPullRefreshListener(this);
        this.hfs.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.hfs.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.hfs.getParent()).removeView(this.hfs);
        }
        if (this.gUI) {
            this.hfs.initListeners();
            this.gUI = false;
        }
        return this.hfs;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.hfs.setViewForeground();
            TiebaStatic.log(new an("c13349"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.hfs.eF(false);
        this.hfr.bNY();
    }

    public void baZ() {
        this.hfs.baZ();
    }

    @Override // com.baidu.tieba.frs.af
    public void yj() {
        this.hfs.reload();
    }

    @Override // com.baidu.tieba.frs.af
    public void bah() {
    }

    @Override // com.baidu.tieba.frs.af
    public void bai() {
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.af
    public void aFw() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.hfs.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        this.hfr.bNY();
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.hfs.baf();
            this.hfs.eF(false);
            this.hfr.bNY();
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void n(int i, List<m> list) {
        this.hfs.hideLoadingView();
        this.hfs.bam();
        if (i != 0 || v.isEmpty(list)) {
            this.hfs.kJ(false);
            return;
        }
        this.hfs.baf();
        this.hfs.bem();
        this.hfs.setData(list);
        this.hfs.bbb();
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
        this.hfs.destroy();
        this.hfr.onDestroy();
        this.gUI = true;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.hfs != null) {
            this.hfs.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }
}
