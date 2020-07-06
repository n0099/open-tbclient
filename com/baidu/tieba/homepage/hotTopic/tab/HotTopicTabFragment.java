package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.x;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class HotTopicTabFragment extends BaseFragment implements ao, b {
    private HotTopicTabModel iqG;
    private HotTopicTabView iqH;
    private List<q> iqI;

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.iqG = new HotTopicTabModel(pageContext);
        this.iqH = new HotTopicTabView(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iqG.setPresenter(this);
        this.iqG.setUniqueId(getUniqueId());
        this.iqH.setPresenter(this);
        this.iqH.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iqH.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iqH.getParent()).removeView(this.iqH);
        }
        return this.iqH;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.iqH.setViewForeground();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13740"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.ao
    public void IB() {
        this.iqH.reload();
    }

    @Override // com.baidu.tieba.frs.ao
    public void btQ() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void btR() {
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
        this.iqH.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.iqH != null) {
            this.iqH.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.iqG.LoadData();
        if (w.isEmpty(this.iqI)) {
            if (LoadData) {
                this.iqH.ga(false);
                this.iqH.btO();
                return;
            }
            this.iqH.hideLoadingView();
            this.iqH.mB(false);
        } else if (!LoadData) {
            this.iqH.hideLoadingView();
            this.iqH.btV();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void n(int i, List<q> list) {
        this.iqH.hideLoadingView();
        this.iqH.btV();
        if (i != 0 || w.isEmpty(list)) {
            if (w.isEmpty(this.iqI)) {
                this.iqH.mB(false);
                return;
            }
            return;
        }
        this.iqH.setData(list);
        if (list.get(list.size() - 1) instanceof x) {
            this.iqH.cjp();
        } else {
            this.iqH.buK();
        }
        this.iqI = list;
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
        this.iqH.destroy();
        this.iqG.onDestroy();
    }
}
