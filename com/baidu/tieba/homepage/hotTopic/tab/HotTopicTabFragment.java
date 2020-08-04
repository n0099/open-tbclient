package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class HotTopicTabFragment extends BaseFragment implements ao, b {
    private HotTopicTabModel iwM;
    private HotTopicTabView iwN;
    private List<q> iwO;

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.iwM = new HotTopicTabModel(pageContext);
        this.iwN = new HotTopicTabView(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iwM.setPresenter(this);
        this.iwM.setUniqueId(getUniqueId());
        this.iwN.setPresenter(this);
        this.iwN.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iwN.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iwN.getParent()).removeView(this.iwN);
        }
        return this.iwN;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.iwN.setViewForeground();
            TiebaStatic.log(new ap("c13740"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.ao
    public void IH() {
        this.iwN.reload();
    }

    @Override // com.baidu.tieba.frs.ao
    public void bwZ() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void bxa() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.ao
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void bci() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.iwN.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.iwN != null) {
            this.iwN.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.iwM.LoadData();
        if (x.isEmpty(this.iwO)) {
            if (LoadData) {
                this.iwN.gw(false);
                this.iwN.bwX();
                return;
            }
            this.iwN.hideLoadingView();
            this.iwN.ng(false);
        } else if (!LoadData) {
            this.iwN.hideLoadingView();
            this.iwN.bxe();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void n(int i, List<q> list) {
        this.iwN.hideLoadingView();
        this.iwN.bxe();
        if (i != 0 || x.isEmpty(list)) {
            if (x.isEmpty(this.iwO)) {
                this.iwN.ng(false);
                return;
            }
            return;
        }
        this.iwN.setData(list);
        if (list.get(list.size() - 1) instanceof com.baidu.adp.widget.ListView.x) {
            this.iwN.cmQ();
        } else {
            this.iwN.bxT();
        }
        this.iwO = list;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(x.getItem(arrayList, arrayList.size() - 1))) {
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
        this.iwN.destroy();
        this.iwM.onDestroy();
    }
}
