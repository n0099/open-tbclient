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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class HotTopicTabFragment extends BaseFragment implements am, b {
    private HotTopicTabModel jYu;
    private HotTopicTabView jYv;
    private FrsTabItemData jYw;
    private TabLayout.OnTabSelectedListener jYx = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.1
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (HotTopicTabFragment.this.jYw != null && HotTopicTabFragment.this.jYw.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    HotTopicTabFragment.this.jYu.setTabCode(str);
                    if (HotTopicTabFragment.this.jYu.LoadData()) {
                        HotTopicTabFragment.this.jYv.bQX();
                        HotTopicTabFragment.this.jYv.hideLoadingView();
                        HotTopicTabFragment.this.jYv.Vq();
                        HotTopicTabFragment.this.cOG();
                    } else {
                        HotTopicTabFragment.this.jYv.bQX();
                        HotTopicTabFragment.this.jYv.hideLoadingView();
                        List<n> Ln = HotTopicTabFragment.this.jYu.Ln(str);
                        if (!x.isEmpty(Ln)) {
                            HotTopicTabFragment.this.jYv.setListData(Ln);
                        } else {
                            HotTopicTabFragment.this.bQU();
                        }
                    }
                }
                HotTopicTabFragment.this.jYw = frsTabItemData;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.jYv.bQX();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
    private f<Object> jYy = new f<Object>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.2
        @Override // com.baidu.tbadk.h.f
        public void a(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, i + 1, HotTopicTabFragment.this.bvV());
            }
        }

        @Override // com.baidu.tbadk.h.f
        public void b(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, HotTopicTabFragment.this.bvV());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public String bvV() {
        return this.jYu != null ? this.jYu.bvV() : "";
    }

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.jYu = new HotTopicTabModel(pageContext);
        this.jYv = new HotTopicTabView(pageContext);
        this.jYv.setOnTabSelectedListener(this.jYx);
        this.jYv.setOnItemCoverListener(this.jYy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jYu.setPresenter(this);
        this.jYu.setUniqueId(getUniqueId());
        this.jYv.setPresenter(this);
        this.jYv.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.jYv.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jYv.getParent()).removeView(this.jYv);
        }
        return this.jYv;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.jYv.setViewForeground();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.am
    public void SM() {
        this.jYv.reload();
    }

    @Override // com.baidu.tieba.frs.am
    public void bQS() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bQT() {
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(y yVar) {
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.am
    public void btV() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.jYv.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jYv != null) {
            this.jYv.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.jYu.LoadData();
        List<n> Ln = this.jYu.Ln(this.jYu.bvV());
        if (LoadData) {
            if (x.isEmpty(Ln) && !this.jYv.cOK()) {
                this.jYv.bQX();
                this.jYv.Vq();
                showLoadingView();
                return;
            }
            return;
        }
        this.jYv.bQX();
        this.jYv.hideLoadingView();
        if (!x.isEmpty(Ln)) {
            this.jYv.setListData(Ln);
        } else if (!j.isNetworkAvailableForImmediately()) {
            bQU();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void a(int i, com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        this.jYv.hideLoadingView();
        this.jYv.Vq();
        this.jYv.bQX();
        if (aVar == null || i != 0 || x.isEmpty(aVar.getDataList())) {
            if (x.isEmpty(this.jYu.cOI())) {
                bQU();
                return;
            } else {
                this.jYv.setListData(this.jYu.cOI());
                return;
            }
        }
        this.jYv.setData(aVar);
        this.jYv.Vp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQU() {
        if (this.jYv.cOK()) {
            this.jYv.Vq();
            cOH();
            return;
        }
        this.jYv.pQ(false);
    }

    private void showLoadingView() {
        if (this.jYv.cOK()) {
            this.jYv.hideLoadingView();
            cOG();
            return;
        }
        this.jYv.ip(false);
    }

    public void cOG() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.jYv.cOL();
        this.jYv.setListData(arrayList);
    }

    public void cOH() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.resId = R.drawable.new_pic_emotion_05;
        vVar.showText = getString(R.string.no_data_common_txt);
        arrayList.add(vVar);
        this.jYv.cOL();
        this.jYv.setListData(arrayList);
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
        return "a076";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.jYv.destroy();
        this.jYu.onDestroy();
    }
}
