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
/* loaded from: classes9.dex */
public class TopicFragment extends BaseFragment implements g.c, af, a {
    private boolean gWL = false;
    private TopicModel hht;
    private TopicListView hhu;

    public TopicFragment() {
    }

    public TopicFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.hht = new TopicModel(pageContext);
        this.hhu = new TopicListView(pageContext);
        this.hhu.initListeners();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hht.setPresenter(this);
        this.hht.setUniqueId(getUniqueId());
        this.hhu.setPresenter(this);
        this.hhu.setListPullRefreshListener(this);
        this.hhu.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.hhu.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.hhu.getParent()).removeView(this.hhu);
        }
        if (this.gWL) {
            this.hhu.initListeners();
            this.gWL = false;
        }
        return this.hhu;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.hhu.setViewForeground();
            TiebaStatic.log(new an("c13349"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.hhu.eM(false);
        this.hht.bPC();
    }

    public void bdq() {
        this.hhu.bdq();
    }

    @Override // com.baidu.tieba.frs.af
    public void AC() {
        this.hhu.reload();
    }

    @Override // com.baidu.tieba.frs.af
    public void bcz() {
    }

    @Override // com.baidu.tieba.frs.af
    public void bcA() {
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.af
    public void aHN() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.hhu.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        this.hht.bPC();
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.hhu.bcx();
            this.hhu.eM(false);
            this.hht.bPC();
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void n(int i, List<m> list) {
        this.hhu.hideLoadingView();
        this.hhu.bcD();
        if (i != 0 || v.isEmpty(list)) {
            this.hhu.kN(false);
            return;
        }
        this.hhu.bcx();
        this.hhu.bgy();
        this.hhu.setData(list);
        this.hhu.bds();
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
        this.hhu.destroy();
        this.hht.onDestroy();
        this.gWL = true;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.hhu != null) {
            this.hhu.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }
}
