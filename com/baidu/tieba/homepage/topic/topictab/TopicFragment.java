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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.topic.topictab.model.TopicModel;
import com.baidu.tieba.homepage.topic.topictab.view.TopicListView;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes4.dex */
public class TopicFragment extends BaseFragment implements h.c, ae, a {
    private TopicModel fPL;
    private TopicListView fPM;

    public TopicFragment() {
    }

    public TopicFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.fPL = new TopicModel(pageContext);
        this.fPM = new TopicListView(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fPL.setPresenter(this);
        this.fPL.setUniqueId(getUniqueId());
        this.fPM.setPresenter(this);
        this.fPM.setListPullRefreshListener(this);
        this.fPM.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.fPM.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.fPM.getParent()).removeView(this.fPM);
        }
        return this.fPM;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            TiebaStatic.log(new am("c13349"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.fPM.cE(false);
        this.fPL.bnq();
    }

    public void aCt() {
        this.fPM.aCt();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBu() {
        this.fPM.reload();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBv() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBw() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setHeaderViewHeight(int i) {
        this.fPM.setHeaderViewHeight(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aeK() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.fPM.onChangeSkinType();
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        this.fPL.bnq();
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void loadData() {
        if (j.kY()) {
            this.fPM.aBt();
            this.fPM.cE(false);
            this.fPL.bnq();
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void i(int i, List<m> list) {
        this.fPM.hideLoadingView();
        this.fPM.aBM();
        if (i != 0 || v.T(list)) {
            this.fPM.iD(false);
            return;
        }
        this.fPM.aBt();
        this.fPM.aOA();
        this.fPM.setData(list);
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
        return "a021";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.fPM.destroy();
        this.fPL.onDestroy();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.fPM != null) {
            this.fPM.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }
}
