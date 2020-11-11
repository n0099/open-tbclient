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
import com.baidu.adp.widget.ListView.z;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class HotTopicTabFragment extends BaseFragment implements aq, b {
    private HotTopicTabModel jBk;
    private HotTopicTabView jBl;
    private FrsTabItemData jBm;
    private TabLayout.OnTabSelectedListener jBn = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.1
        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (HotTopicTabFragment.this.jBm != null && HotTopicTabFragment.this.jBm.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    HotTopicTabFragment.this.jBk.setTabCode(str);
                    if (HotTopicTabFragment.this.jBk.LoadData()) {
                        HotTopicTabFragment.this.jBl.bPh();
                        HotTopicTabFragment.this.jBl.hideLoadingView();
                        HotTopicTabFragment.this.jBl.Wk();
                        HotTopicTabFragment.this.cKw();
                    } else {
                        HotTopicTabFragment.this.jBl.bPh();
                        HotTopicTabFragment.this.jBl.hideLoadingView();
                        List<q> LO = HotTopicTabFragment.this.jBk.LO(str);
                        if (!y.isEmpty(LO)) {
                            HotTopicTabFragment.this.jBl.setListData(LO);
                        } else {
                            HotTopicTabFragment.this.bPe();
                        }
                    }
                }
                HotTopicTabFragment.this.jBm = frsTabItemData;
            }
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.jBl.bPh();
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
    private f<Object> jBo = new f<Object>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.2
        @Override // com.baidu.tbadk.h.f
        public void a(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, i + 1, HotTopicTabFragment.this.buE());
            }
        }

        @Override // com.baidu.tbadk.h.f
        public void b(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, HotTopicTabFragment.this.buE());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public String buE() {
        return this.jBk != null ? this.jBk.buE() : "";
    }

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.jBk = new HotTopicTabModel(pageContext);
        this.jBl = new HotTopicTabView(pageContext);
        this.jBl.setOnTabSelectedListener(this.jBn);
        this.jBl.setOnItemCoverListener(this.jBo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jBk.setPresenter(this);
        this.jBk.setUniqueId(getUniqueId());
        this.jBl.setPresenter(this);
        this.jBl.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.jBl.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jBl.getParent()).removeView(this.jBl);
        }
        return this.jBl;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.jBl.setViewForeground();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.aq
    public void TL() {
        this.jBl.reload();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bPc() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bPd() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bsD() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.jBl.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jBl != null) {
            this.jBl.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.jBk.LoadData();
        List<q> LO = this.jBk.LO(this.jBk.buE());
        if (LoadData) {
            if (y.isEmpty(LO) && !this.jBl.cKA()) {
                this.jBl.bPh();
                this.jBl.Wk();
                showLoadingView();
                return;
            }
            return;
        }
        this.jBl.bPh();
        this.jBl.hideLoadingView();
        if (!y.isEmpty(LO)) {
            this.jBl.setListData(LO);
        } else if (!j.isNetworkAvailableForImmediately()) {
            bPe();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void a(int i, com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        this.jBl.hideLoadingView();
        this.jBl.Wk();
        this.jBl.bPh();
        if (aVar == null || i != 0 || y.isEmpty(aVar.getDataList())) {
            if (y.isEmpty(this.jBk.cKy())) {
                bPe();
                return;
            } else {
                this.jBl.setListData(this.jBk.cKy());
                return;
            }
        }
        this.jBl.setData(aVar);
        this.jBl.Wj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPe() {
        if (this.jBl.cKA()) {
            this.jBl.Wk();
            cKx();
            return;
        }
        this.jBl.oY(false);
    }

    private void showLoadingView() {
        if (this.jBl.cKA()) {
            this.jBl.hideLoadingView();
            cKw();
            return;
        }
        this.jBl.hJ(false);
    }

    public void cKw() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new x());
        this.jBl.cKB();
        this.jBl.setListData(arrayList);
    }

    public void cKx() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.resId = R.drawable.new_pic_emotion_05;
        zVar.showText = getString(R.string.no_data_common_txt);
        arrayList.add(zVar);
        this.jBl.cKB();
        this.jBl.setListData(arrayList);
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
        this.jBl.destroy();
        this.jBk.onDestroy();
    }
}
