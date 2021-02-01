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
    private HotTopicTabModel kfX;
    private HotTopicTabView kfY;
    private FrsTabItemData kfZ;
    private TabLayout.OnTabSelectedListener kga = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.1
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (HotTopicTabFragment.this.kfZ != null && HotTopicTabFragment.this.kfZ.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    HotTopicTabFragment.this.kfX.setTabCode(str);
                    if (HotTopicTabFragment.this.kfX.LoadData()) {
                        HotTopicTabFragment.this.kfY.bRB();
                        HotTopicTabFragment.this.kfY.hideLoadingView();
                        HotTopicTabFragment.this.kfY.WZ();
                        HotTopicTabFragment.this.cQD();
                    } else {
                        HotTopicTabFragment.this.kfY.bRB();
                        HotTopicTabFragment.this.kfY.hideLoadingView();
                        List<n> LY = HotTopicTabFragment.this.kfX.LY(str);
                        if (!y.isEmpty(LY)) {
                            HotTopicTabFragment.this.kfY.setListData(LY);
                        } else {
                            HotTopicTabFragment.this.bRy();
                        }
                    }
                }
                HotTopicTabFragment.this.kfZ = frsTabItemData;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.kfY.bRB();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
    private f<Object> kgb = new f<Object>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.2
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
        return this.kfX != null ? this.kfX.getTabCode() : "";
    }

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.kfX = new HotTopicTabModel(pageContext);
        this.kfY = new HotTopicTabView(pageContext);
        this.kfY.setOnTabSelectedListener(this.kga);
        this.kfY.setOnItemCoverListener(this.kgb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kfX.setPresenter(this);
        this.kfX.setUniqueId(getUniqueId());
        this.kfY.setPresenter(this);
        this.kfY.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.kfY.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.kfY.getParent()).removeView(this.kfY);
        }
        return this.kfY;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.kfY.setViewForeground();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.am
    public void Ut() {
        this.kfY.reload();
    }

    @Override // com.baidu.tieba.frs.am
    public void bRw() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bRx() {
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
        this.kfY.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.kfY != null) {
            this.kfY.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.kfX.LoadData();
        List<n> LY = this.kfX.LY(this.kfX.getTabCode());
        if (LoadData) {
            if (y.isEmpty(LY) && !this.kfY.cQH()) {
                this.kfY.bRB();
                this.kfY.WZ();
                showLoadingView();
                return;
            }
            return;
        }
        this.kfY.bRB();
        this.kfY.hideLoadingView();
        if (!y.isEmpty(LY)) {
            this.kfY.setListData(LY);
        } else if (!j.isNetworkAvailableForImmediately()) {
            bRy();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void a(int i, com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        this.kfY.hideLoadingView();
        this.kfY.WZ();
        this.kfY.bRB();
        if (aVar == null || i != 0 || y.isEmpty(aVar.getDataList())) {
            if (y.isEmpty(this.kfX.cQF())) {
                bRy();
                return;
            } else {
                this.kfY.setListData(this.kfX.cQF());
                return;
            }
        }
        this.kfY.setData(aVar);
        this.kfY.WY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRy() {
        if (this.kfY.cQH()) {
            this.kfY.WZ();
            cQE();
            return;
        }
        this.kfY.qa(false);
    }

    private void showLoadingView() {
        if (this.kfY.cQH()) {
            this.kfY.hideLoadingView();
            cQD();
            return;
        }
        this.kfY.ir(false);
    }

    public void cQD() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.kfY.cQI();
        this.kfY.setListData(arrayList);
    }

    public void cQE() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.resId = R.drawable.new_pic_emotion_05;
        vVar.showText = getString(R.string.no_data_common_txt);
        arrayList.add(vVar);
        this.kfY.cQI();
        this.kfY.setListData(arrayList);
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
        this.kfY.destroy();
        this.kfX.onDestroy();
    }
}
