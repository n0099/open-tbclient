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
    private HotTopicTabModel jiQ;
    private HotTopicTabView jiR;
    private FrsTabItemData jiS;
    private TabLayout.OnTabSelectedListener jiT = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.1
        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (HotTopicTabFragment.this.jiS != null && HotTopicTabFragment.this.jiS.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    HotTopicTabFragment.this.jiQ.setTabCode(str);
                    if (HotTopicTabFragment.this.jiQ.LoadData()) {
                        HotTopicTabFragment.this.jiR.bKf();
                        HotTopicTabFragment.this.jiR.hideLoadingView();
                        HotTopicTabFragment.this.jiR.SK();
                        HotTopicTabFragment.this.cEO();
                    } else {
                        HotTopicTabFragment.this.jiR.bKf();
                        HotTopicTabFragment.this.jiR.hideLoadingView();
                        List<q> KZ = HotTopicTabFragment.this.jiQ.KZ(str);
                        if (!y.isEmpty(KZ)) {
                            HotTopicTabFragment.this.jiR.setListData(KZ);
                        } else {
                            HotTopicTabFragment.this.bKc();
                        }
                    }
                }
                HotTopicTabFragment.this.jiS = frsTabItemData;
            }
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.jiR.bKf();
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
    private f<Object> jiU = new f<Object>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.2
        @Override // com.baidu.tbadk.h.f
        public void a(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, i + 1, HotTopicTabFragment.this.bql());
            }
        }

        @Override // com.baidu.tbadk.h.f
        public void b(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, HotTopicTabFragment.this.bql());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public String bql() {
        return this.jiQ != null ? this.jiQ.bql() : "";
    }

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.jiQ = new HotTopicTabModel(pageContext);
        this.jiR = new HotTopicTabView(pageContext);
        this.jiR.setOnTabSelectedListener(this.jiT);
        this.jiR.setOnItemCoverListener(this.jiU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jiQ.setPresenter(this);
        this.jiQ.setUniqueId(getUniqueId());
        this.jiR.setPresenter(this);
        this.jiR.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.jiR.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jiR.getParent()).removeView(this.jiR);
        }
        return this.jiR;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.jiR.setViewForeground();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.aq
    public void Qi() {
        this.jiR.reload();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bKa() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bKb() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bok() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.jiR.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jiR != null) {
            this.jiR.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.jiQ.LoadData();
        List<q> KZ = this.jiQ.KZ(this.jiQ.bql());
        if (LoadData) {
            if (y.isEmpty(KZ) && !this.jiR.cES()) {
                this.jiR.bKf();
                this.jiR.SK();
                showLoadingView();
                return;
            }
            return;
        }
        this.jiR.bKf();
        this.jiR.hideLoadingView();
        if (!y.isEmpty(KZ)) {
            this.jiR.setListData(KZ);
        } else if (!j.isNetworkAvailableForImmediately()) {
            bKc();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void a(int i, com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        this.jiR.hideLoadingView();
        this.jiR.SK();
        this.jiR.bKf();
        if (aVar == null || i != 0 || y.isEmpty(aVar.getDataList())) {
            if (y.isEmpty(this.jiQ.cEQ())) {
                bKc();
                return;
            } else {
                this.jiR.setListData(this.jiQ.cEQ());
                return;
            }
        }
        this.jiR.setData(aVar);
        this.jiR.SJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKc() {
        if (this.jiR.cES()) {
            this.jiR.SK();
            cEP();
            return;
        }
        this.jiR.ox(false);
    }

    private void showLoadingView() {
        if (this.jiR.cES()) {
            this.jiR.hideLoadingView();
            cEO();
            return;
        }
        this.jiR.hn(false);
    }

    public void cEO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new x());
        this.jiR.cET();
        this.jiR.setListData(arrayList);
    }

    public void cEP() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.resId = R.drawable.new_pic_emotion_05;
        zVar.showText = getString(R.string.no_data_common_txt);
        arrayList.add(zVar);
        this.jiR.cET();
        this.jiR.setListData(arrayList);
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
        this.jiR.destroy();
        this.jiQ.onDestroy();
    }
}
