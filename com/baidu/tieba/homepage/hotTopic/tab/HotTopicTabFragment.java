package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.t;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class HotTopicTabFragment extends BaseFragment implements am, b {
    private HotTopicTabModel kgl;
    private HotTopicTabView kgm;
    private FrsTabItemData kgn;
    private TabLayout.OnTabSelectedListener kgo = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.1
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (HotTopicTabFragment.this.kgn != null && HotTopicTabFragment.this.kgn.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    HotTopicTabFragment.this.kgl.setTabCode(str);
                    if (HotTopicTabFragment.this.kgl.LoadData()) {
                        HotTopicTabFragment.this.kgm.bRI();
                        HotTopicTabFragment.this.kgm.hideLoadingView();
                        HotTopicTabFragment.this.kgm.WZ();
                        HotTopicTabFragment.this.cQK();
                    } else {
                        HotTopicTabFragment.this.kgm.bRI();
                        HotTopicTabFragment.this.kgm.hideLoadingView();
                        List<n> LZ = HotTopicTabFragment.this.kgl.LZ(str);
                        if (!y.isEmpty(LZ)) {
                            HotTopicTabFragment.this.kgm.setListData(LZ);
                        } else {
                            HotTopicTabFragment.this.bRF();
                        }
                    }
                }
                HotTopicTabFragment.this.kgn = frsTabItemData;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.kgm.bRI();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
    private f<Object> kgp = new f<Object>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.2
        @Override // com.baidu.tbadk.h.f
        public void a(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, i + 1, HotTopicTabFragment.this.getTabCode());
            }
        }

        @Override // com.baidu.tbadk.h.f
        public void b(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, HotTopicTabFragment.this.getTabCode());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public String getTabCode() {
        return this.kgl != null ? this.kgl.getTabCode() : "";
    }

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.kgl = new HotTopicTabModel(pageContext);
        this.kgm = new HotTopicTabView(pageContext);
        this.kgm.setOnTabSelectedListener(this.kgo);
        this.kgm.setOnItemCoverListener(this.kgp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kgl.setPresenter(this);
        this.kgl.setUniqueId(getUniqueId());
        this.kgm.setPresenter(this);
        this.kgm.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.kgm.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.kgm.getParent()).removeView(this.kgm);
        }
        return this.kgm;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.kgm.setViewForeground();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.am
    public void Ut() {
        this.kgm.reload();
    }

    @Override // com.baidu.tieba.frs.am
    public void bRD() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bRE() {
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bup() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.kgm.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.kgm != null) {
            this.kgm.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.kgl.LoadData();
        List<n> LZ = this.kgl.LZ(this.kgl.getTabCode());
        if (LoadData) {
            if (y.isEmpty(LZ) && !this.kgm.cQO()) {
                this.kgm.bRI();
                this.kgm.WZ();
                showLoadingView();
                return;
            }
            return;
        }
        this.kgm.bRI();
        this.kgm.hideLoadingView();
        if (!y.isEmpty(LZ)) {
            this.kgm.setListData(LZ);
        } else if (!j.isNetworkAvailableForImmediately()) {
            bRF();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void a(int i, com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        this.kgm.hideLoadingView();
        this.kgm.WZ();
        this.kgm.bRI();
        if (aVar == null || i != 0 || y.isEmpty(aVar.getDataList())) {
            if (y.isEmpty(this.kgl.cQM())) {
                bRF();
                return;
            } else {
                this.kgm.setListData(this.kgl.cQM());
                return;
            }
        }
        this.kgm.setData(aVar);
        this.kgm.WY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRF() {
        if (this.kgm.cQO()) {
            this.kgm.WZ();
            cQL();
            return;
        }
        this.kgm.qa(false);
    }

    private void showLoadingView() {
        if (this.kgm.cQO()) {
            this.kgm.hideLoadingView();
            cQK();
            return;
        }
        this.kgm.ir(false);
    }

    public void cQK() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.kgm.cQP();
        this.kgm.setListData(arrayList);
    }

    public void cQL() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.resId = R.drawable.new_pic_emotion_05;
        vVar.showText = getString(R.string.no_data_common_txt);
        arrayList.add(vVar);
        this.kgm.cQP();
        this.kgm.setListData(arrayList);
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.kgm.destroy();
        this.kgl.onDestroy();
    }
}
