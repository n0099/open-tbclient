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
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.topic.topictab.model.TopicModel;
import com.baidu.tieba.homepage.topic.topictab.view.TopicListView;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes16.dex */
public class TopicFragment extends BaseFragment implements f.c, aq, a {
    private boolean iGq = false;
    private TopicModel iUB;
    private TopicListView iUC;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iUB.setPresenter(this);
        this.iUB.setUniqueId(getUniqueId());
        this.iUC.setPresenter(this);
        this.iUC.setListPullRefreshListener(this);
        this.iUC.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iUC.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iUC.getParent()).removeView(this.iUC);
        }
        if (this.iGq) {
            this.iUC.bMg();
            this.iGq = false;
        }
        return this.iUC;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.iUC.setViewForeground();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13349"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.iUC.gS(false);
        this.iUB.czi();
    }

    @Override // com.baidu.tieba.frs.aq
    public void OA() {
        this.iUC.reload();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bFY() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bFZ() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bkF() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.iUC.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.iUB.czi();
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.iUC.bFW();
            this.iUC.gS(false);
            this.iUB.czi();
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void o(int i, List<q> list) {
        this.iUC.hideLoadingView();
        this.iUC.bGd();
        if (i != 0 || y.isEmpty(list)) {
            this.iUC.nK(false);
            return;
        }
        this.iUC.bFW();
        this.iUC.bLs();
        this.iUC.setData(list);
        this.iUC.bGS();
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
        this.iUC.destroy();
        this.iUB.onDestroy();
        this.iGq = true;
    }
}
