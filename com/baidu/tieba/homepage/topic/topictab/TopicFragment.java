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
import com.baidu.tbadk.core.util.an;
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
    private boolean gbR = false;
    private TopicModel gmW;
    private TopicListView gmX;

    public TopicFragment() {
    }

    public TopicFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.gmW = new TopicModel(pageContext);
        this.gmX = new TopicListView(pageContext);
        this.gmX.bpT();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gmW.setPresenter(this);
        this.gmW.setUniqueId(getUniqueId());
        this.gmX.setPresenter(this);
        this.gmX.setListPullRefreshListener(this);
        this.gmX.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.gmX.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gmX.getParent()).removeView(this.gmX);
        }
        if (this.gbR) {
            this.gmX.bpT();
            this.gbR = false;
        }
        return this.gmX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.gmX.setViewForeground();
            TiebaStatic.log(new an("c13349"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.gmX.cY(false);
        this.gmW.bxy();
    }

    public void aKh() {
        this.gmX.aKh();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJi() {
        this.gmX.reload();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJj() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJk() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void akL() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.gmX.onChangeSkinType();
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        this.gmW.bxy();
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void loadData() {
        if (j.kc()) {
            this.gmX.aJh();
            this.gmX.cY(false);
            this.gmW.bxy();
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void i(int i, List<m> list) {
        this.gmX.hideLoadingView();
        this.gmX.aJB();
        if (i != 0 || v.aa(list)) {
            this.gmX.ju(false);
            return;
        }
        this.gmX.aJh();
        this.gmX.aVP();
        this.gmX.setData(list);
        this.gmX.aKj();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
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

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a021";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.gmX.destroy();
        this.gmW.onDestroy();
        this.gbR = true;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gmX != null) {
            this.gmX.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }
}
