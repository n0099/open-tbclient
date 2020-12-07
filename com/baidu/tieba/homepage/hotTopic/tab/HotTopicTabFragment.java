package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.x;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class HotTopicTabFragment extends BaseFragment implements ap, b {
    private HotTopicTabModel jPJ;
    private HotTopicTabView jPK;
    private FrsTabItemData jPL;
    private TabLayout.OnTabSelectedListener jPM = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.1
        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (HotTopicTabFragment.this.jPL != null && HotTopicTabFragment.this.jPL.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    HotTopicTabFragment.this.jPJ.setTabCode(str);
                    if (HotTopicTabFragment.this.jPJ.LoadData()) {
                        HotTopicTabFragment.this.jPK.bSl();
                        HotTopicTabFragment.this.jPK.hideLoadingView();
                        HotTopicTabFragment.this.jPK.Yb();
                        HotTopicTabFragment.this.cPq();
                    } else {
                        HotTopicTabFragment.this.jPK.bSl();
                        HotTopicTabFragment.this.jPK.hideLoadingView();
                        List<q> Mw = HotTopicTabFragment.this.jPJ.Mw(str);
                        if (!y.isEmpty(Mw)) {
                            HotTopicTabFragment.this.jPK.setListData(Mw);
                        } else {
                            HotTopicTabFragment.this.bSi();
                        }
                    }
                }
                HotTopicTabFragment.this.jPL = frsTabItemData;
            }
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.jPK.bSl();
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
    private f<Object> jPN = new f<Object>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.2
        @Override // com.baidu.tbadk.h.f
        public void a(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, i + 1, HotTopicTabFragment.this.bxu());
            }
        }

        @Override // com.baidu.tbadk.h.f
        public void b(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, HotTopicTabFragment.this.bxu());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public String bxu() {
        return this.jPJ != null ? this.jPJ.bxu() : "";
    }

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.jPJ = new HotTopicTabModel(pageContext);
        this.jPK = new HotTopicTabView(pageContext);
        this.jPK.setOnTabSelectedListener(this.jPM);
        this.jPK.setOnItemCoverListener(this.jPN);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jPJ.setPresenter(this);
        this.jPJ.setUniqueId(getUniqueId());
        this.jPK.setPresenter(this);
        this.jPK.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.jPK.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jPK.getParent()).removeView(this.jPK);
        }
        return this.jPK;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.jPK.setViewForeground();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.ap
    public void VC() {
        this.jPK.reload();
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSg() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSh() {
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
        this.jPK.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jPK != null) {
            this.jPK.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.jPJ.LoadData();
        List<q> Mw = this.jPJ.Mw(this.jPJ.bxu());
        if (LoadData) {
            if (y.isEmpty(Mw) && !this.jPK.cPu()) {
                this.jPK.bSl();
                this.jPK.Yb();
                showLoadingView();
                return;
            }
            return;
        }
        this.jPK.bSl();
        this.jPK.hideLoadingView();
        if (!y.isEmpty(Mw)) {
            this.jPK.setListData(Mw);
        } else if (!j.isNetworkAvailableForImmediately()) {
            bSi();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void a(int i, com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        this.jPK.hideLoadingView();
        this.jPK.Yb();
        this.jPK.bSl();
        if (aVar == null || i != 0 || y.isEmpty(aVar.getDataList())) {
            if (y.isEmpty(this.jPJ.cPs())) {
                bSi();
                return;
            } else {
                this.jPK.setListData(this.jPJ.cPs());
                return;
            }
        }
        this.jPK.setData(aVar);
        this.jPK.Ya();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSi() {
        if (this.jPK.cPu()) {
            this.jPK.Yb();
            cPr();
            return;
        }
        this.jPK.px(false);
    }

    private void showLoadingView() {
        if (this.jPK.cPu()) {
            this.jPK.hideLoadingView();
            cPq();
            return;
        }
        this.jPK.ib(false);
    }

    public void cPq() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new x());
        this.jPK.cPv();
        this.jPK.setListData(arrayList);
    }

    public void cPr() {
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.ListView.z zVar = new com.baidu.adp.widget.ListView.z();
        zVar.resId = R.drawable.new_pic_emotion_05;
        zVar.showText = getString(R.string.no_data_common_txt);
        arrayList.add(zVar);
        this.jPK.cPv();
        this.jPK.setListData(arrayList);
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
        return "a076";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.jPK.destroy();
        this.jPJ.onDestroy();
    }
}
