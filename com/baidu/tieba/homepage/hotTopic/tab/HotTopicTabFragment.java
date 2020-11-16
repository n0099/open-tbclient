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
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class HotTopicTabFragment extends BaseFragment implements aq, b {
    private HotTopicTabModel jCh;
    private HotTopicTabView jCi;
    private FrsTabItemData jCj;
    private TabLayout.OnTabSelectedListener jCk = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.1
        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (HotTopicTabFragment.this.jCj != null && HotTopicTabFragment.this.jCj.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    HotTopicTabFragment.this.jCh.setTabCode(str);
                    if (HotTopicTabFragment.this.jCh.LoadData()) {
                        HotTopicTabFragment.this.jCi.bOA();
                        HotTopicTabFragment.this.jCi.hideLoadingView();
                        HotTopicTabFragment.this.jCi.VB();
                        HotTopicTabFragment.this.cKb();
                    } else {
                        HotTopicTabFragment.this.jCi.bOA();
                        HotTopicTabFragment.this.jCi.hideLoadingView();
                        List<q> Lp = HotTopicTabFragment.this.jCh.Lp(str);
                        if (!y.isEmpty(Lp)) {
                            HotTopicTabFragment.this.jCi.setListData(Lp);
                        } else {
                            HotTopicTabFragment.this.bOx();
                        }
                    }
                }
                HotTopicTabFragment.this.jCj = frsTabItemData;
            }
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.jCi.bOA();
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
    private f<Object> jCl = new f<Object>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.2
        @Override // com.baidu.tbadk.h.f
        public void a(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, i + 1, HotTopicTabFragment.this.btU());
            }
        }

        @Override // com.baidu.tbadk.h.f
        public void b(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, HotTopicTabFragment.this.btU());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public String btU() {
        return this.jCh != null ? this.jCh.btU() : "";
    }

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.jCh = new HotTopicTabModel(pageContext);
        this.jCi = new HotTopicTabView(pageContext);
        this.jCi.setOnTabSelectedListener(this.jCk);
        this.jCi.setOnItemCoverListener(this.jCl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jCh.setPresenter(this);
        this.jCh.setUniqueId(getUniqueId());
        this.jCi.setPresenter(this);
        this.jCi.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.jCi.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jCi.getParent()).removeView(this.jCi);
        }
        return this.jCi;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.jCi.setViewForeground();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.aq
    public void Tc() {
        this.jCi.reload();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bOv() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bOw() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void brT() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.jCi.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jCi != null) {
            this.jCi.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.jCh.LoadData();
        List<q> Lp = this.jCh.Lp(this.jCh.btU());
        if (LoadData) {
            if (y.isEmpty(Lp) && !this.jCi.cKf()) {
                this.jCi.bOA();
                this.jCi.VB();
                showLoadingView();
                return;
            }
            return;
        }
        this.jCi.bOA();
        this.jCi.hideLoadingView();
        if (!y.isEmpty(Lp)) {
            this.jCi.setListData(Lp);
        } else if (!j.isNetworkAvailableForImmediately()) {
            bOx();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void a(int i, com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        this.jCi.hideLoadingView();
        this.jCi.VB();
        this.jCi.bOA();
        if (aVar == null || i != 0 || y.isEmpty(aVar.getDataList())) {
            if (y.isEmpty(this.jCh.cKd())) {
                bOx();
                return;
            } else {
                this.jCi.setListData(this.jCh.cKd());
                return;
            }
        }
        this.jCi.setData(aVar);
        this.jCi.VA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOx() {
        if (this.jCi.cKf()) {
            this.jCi.VB();
            cKc();
            return;
        }
        this.jCi.pb(false);
    }

    private void showLoadingView() {
        if (this.jCi.cKf()) {
            this.jCi.hideLoadingView();
            cKb();
            return;
        }
        this.jCi.hM(false);
    }

    public void cKb() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new x());
        this.jCi.cKg();
        this.jCi.setListData(arrayList);
    }

    public void cKc() {
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.ListView.z zVar = new com.baidu.adp.widget.ListView.z();
        zVar.resId = R.drawable.new_pic_emotion_05;
        zVar.showText = getString(R.string.no_data_common_txt);
        arrayList.add(zVar);
        this.jCi.cKg();
        this.jCi.setListData(arrayList);
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
        this.jCi.destroy();
        this.jCh.onDestroy();
    }
}
