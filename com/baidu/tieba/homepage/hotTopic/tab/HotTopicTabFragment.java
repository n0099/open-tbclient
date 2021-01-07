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
    private HotTopicTabModel kcZ;
    private HotTopicTabView kda;
    private FrsTabItemData kdb;
    private TabLayout.OnTabSelectedListener kdc = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.1
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (HotTopicTabFragment.this.kdb != null && HotTopicTabFragment.this.kdb.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    HotTopicTabFragment.this.kcZ.setTabCode(str);
                    if (HotTopicTabFragment.this.kcZ.LoadData()) {
                        HotTopicTabFragment.this.kda.bUP();
                        HotTopicTabFragment.this.kda.hideLoadingView();
                        HotTopicTabFragment.this.kda.Zj();
                        HotTopicTabFragment.this.cSy();
                    } else {
                        HotTopicTabFragment.this.kda.bUP();
                        HotTopicTabFragment.this.kda.hideLoadingView();
                        List<n> Mv = HotTopicTabFragment.this.kcZ.Mv(str);
                        if (!x.isEmpty(Mv)) {
                            HotTopicTabFragment.this.kda.setListData(Mv);
                        } else {
                            HotTopicTabFragment.this.bUM();
                        }
                    }
                }
                HotTopicTabFragment.this.kdb = frsTabItemData;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.kda.bUP();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
    private f<Object> kdd = new f<Object>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.2
        @Override // com.baidu.tbadk.h.f
        public void a(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, i + 1, HotTopicTabFragment.this.bzP());
            }
        }

        @Override // com.baidu.tbadk.h.f
        public void b(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, HotTopicTabFragment.this.bzP());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public String bzP() {
        return this.kcZ != null ? this.kcZ.bzP() : "";
    }

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.kcZ = new HotTopicTabModel(pageContext);
        this.kda = new HotTopicTabView(pageContext);
        this.kda.setOnTabSelectedListener(this.kdc);
        this.kda.setOnItemCoverListener(this.kdd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kcZ.setPresenter(this);
        this.kcZ.setUniqueId(getUniqueId());
        this.kda.setPresenter(this);
        this.kda.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.kda.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.kda.getParent()).removeView(this.kda);
        }
        return this.kda;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.kda.setViewForeground();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.am
    public void WF() {
        this.kda.reload();
    }

    @Override // com.baidu.tieba.frs.am
    public void bUK() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bUL() {
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(y yVar) {
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bxP() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.kda.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.kda != null) {
            this.kda.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.kcZ.LoadData();
        List<n> Mv = this.kcZ.Mv(this.kcZ.bzP());
        if (LoadData) {
            if (x.isEmpty(Mv) && !this.kda.cSC()) {
                this.kda.bUP();
                this.kda.Zj();
                showLoadingView();
                return;
            }
            return;
        }
        this.kda.bUP();
        this.kda.hideLoadingView();
        if (!x.isEmpty(Mv)) {
            this.kda.setListData(Mv);
        } else if (!j.isNetworkAvailableForImmediately()) {
            bUM();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void a(int i, com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        this.kda.hideLoadingView();
        this.kda.Zj();
        this.kda.bUP();
        if (aVar == null || i != 0 || x.isEmpty(aVar.getDataList())) {
            if (x.isEmpty(this.kcZ.cSA())) {
                bUM();
                return;
            } else {
                this.kda.setListData(this.kcZ.cSA());
                return;
            }
        }
        this.kda.setData(aVar);
        this.kda.Zi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUM() {
        if (this.kda.cSC()) {
            this.kda.Zj();
            cSz();
            return;
        }
        this.kda.pU(false);
    }

    private void showLoadingView() {
        if (this.kda.cSC()) {
            this.kda.hideLoadingView();
            cSy();
            return;
        }
        this.kda.it(false);
    }

    public void cSy() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.kda.cSD();
        this.kda.setListData(arrayList);
    }

    public void cSz() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.resId = R.drawable.new_pic_emotion_05;
        vVar.showText = getString(R.string.no_data_common_txt);
        arrayList.add(vVar);
        this.kda.cSD();
        this.kda.setListData(arrayList);
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
        this.kda.destroy();
        this.kcZ.onDestroy();
    }
}
