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
    private HotTopicTabModel kio;
    private HotTopicTabView kip;
    private FrsTabItemData kiq;
    private TabLayout.OnTabSelectedListener kir = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.1
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (HotTopicTabFragment.this.kiq != null && HotTopicTabFragment.this.kiq.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    HotTopicTabFragment.this.kio.setTabCode(str);
                    if (HotTopicTabFragment.this.kio.LoadData()) {
                        HotTopicTabFragment.this.kip.bRO();
                        HotTopicTabFragment.this.kip.hideLoadingView();
                        HotTopicTabFragment.this.kip.Xc();
                        HotTopicTabFragment.this.cQR();
                    } else {
                        HotTopicTabFragment.this.kip.bRO();
                        HotTopicTabFragment.this.kip.hideLoadingView();
                        List<n> Mf = HotTopicTabFragment.this.kio.Mf(str);
                        if (!y.isEmpty(Mf)) {
                            HotTopicTabFragment.this.kip.setListData(Mf);
                        } else {
                            HotTopicTabFragment.this.bRL();
                        }
                    }
                }
                HotTopicTabFragment.this.kiq = frsTabItemData;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.kip.bRO();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
    private f<Object> kis = new f<Object>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.2
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
        return this.kio != null ? this.kio.getTabCode() : "";
    }

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.kio = new HotTopicTabModel(pageContext);
        this.kip = new HotTopicTabView(pageContext);
        this.kip.setOnTabSelectedListener(this.kir);
        this.kip.setOnItemCoverListener(this.kis);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kio.setPresenter(this);
        this.kio.setUniqueId(getUniqueId());
        this.kip.setPresenter(this);
        this.kip.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.kip.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.kip.getParent()).removeView(this.kip);
        }
        return this.kip;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.kip.setViewForeground();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.am
    public void Uw() {
        this.kip.reload();
    }

    @Override // com.baidu.tieba.frs.am
    public void bRJ() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bRK() {
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bus() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.kip.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.kip != null) {
            this.kip.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.kio.LoadData();
        List<n> Mf = this.kio.Mf(this.kio.getTabCode());
        if (LoadData) {
            if (y.isEmpty(Mf) && !this.kip.cQV()) {
                this.kip.bRO();
                this.kip.Xc();
                showLoadingView();
                return;
            }
            return;
        }
        this.kip.bRO();
        this.kip.hideLoadingView();
        if (!y.isEmpty(Mf)) {
            this.kip.setListData(Mf);
        } else if (!j.isNetworkAvailableForImmediately()) {
            bRL();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void a(int i, com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        this.kip.hideLoadingView();
        this.kip.Xc();
        this.kip.bRO();
        if (aVar == null || i != 0 || y.isEmpty(aVar.getDataList())) {
            if (y.isEmpty(this.kio.cQT())) {
                bRL();
                return;
            } else {
                this.kip.setListData(this.kio.cQT());
                return;
            }
        }
        this.kip.setData(aVar);
        this.kip.Xb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRL() {
        if (this.kip.cQV()) {
            this.kip.Xc();
            cQS();
            return;
        }
        this.kip.qa(false);
    }

    private void showLoadingView() {
        if (this.kip.cQV()) {
            this.kip.hideLoadingView();
            cQR();
            return;
        }
        this.kip.ir(false);
    }

    public void cQR() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.kip.cQW();
        this.kip.setListData(arrayList);
    }

    public void cQS() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.resId = R.drawable.new_pic_emotion_05;
        vVar.showText = getString(R.string.no_data_common_txt);
        arrayList.add(vVar);
        this.kip.cQW();
        this.kip.setListData(arrayList);
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
        this.kip.destroy();
        this.kio.onDestroy();
    }
}
