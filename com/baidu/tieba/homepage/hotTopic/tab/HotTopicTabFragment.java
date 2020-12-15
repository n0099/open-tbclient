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
    private HotTopicTabModel jPL;
    private HotTopicTabView jPM;
    private FrsTabItemData jPN;
    private TabLayout.OnTabSelectedListener jPO = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.1
        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (HotTopicTabFragment.this.jPN != null && HotTopicTabFragment.this.jPN.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    HotTopicTabFragment.this.jPL.setTabCode(str);
                    if (HotTopicTabFragment.this.jPL.LoadData()) {
                        HotTopicTabFragment.this.jPM.bSm();
                        HotTopicTabFragment.this.jPM.hideLoadingView();
                        HotTopicTabFragment.this.jPM.Yb();
                        HotTopicTabFragment.this.cPr();
                    } else {
                        HotTopicTabFragment.this.jPM.bSm();
                        HotTopicTabFragment.this.jPM.hideLoadingView();
                        List<q> Mw = HotTopicTabFragment.this.jPL.Mw(str);
                        if (!y.isEmpty(Mw)) {
                            HotTopicTabFragment.this.jPM.setListData(Mw);
                        } else {
                            HotTopicTabFragment.this.bSj();
                        }
                    }
                }
                HotTopicTabFragment.this.jPN = frsTabItemData;
            }
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.jPM.bSm();
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
    private f<Object> jPP = new f<Object>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.2
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
        return this.jPL != null ? this.jPL.bxu() : "";
    }

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.jPL = new HotTopicTabModel(pageContext);
        this.jPM = new HotTopicTabView(pageContext);
        this.jPM.setOnTabSelectedListener(this.jPO);
        this.jPM.setOnItemCoverListener(this.jPP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jPL.setPresenter(this);
        this.jPL.setUniqueId(getUniqueId());
        this.jPM.setPresenter(this);
        this.jPM.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.jPM.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jPM.getParent()).removeView(this.jPM);
        }
        return this.jPM;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.jPM.setViewForeground();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.ap
    public void VC() {
        this.jPM.reload();
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSh() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSi() {
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
        this.jPM.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jPM != null) {
            this.jPM.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.jPL.LoadData();
        List<q> Mw = this.jPL.Mw(this.jPL.bxu());
        if (LoadData) {
            if (y.isEmpty(Mw) && !this.jPM.cPv()) {
                this.jPM.bSm();
                this.jPM.Yb();
                showLoadingView();
                return;
            }
            return;
        }
        this.jPM.bSm();
        this.jPM.hideLoadingView();
        if (!y.isEmpty(Mw)) {
            this.jPM.setListData(Mw);
        } else if (!j.isNetworkAvailableForImmediately()) {
            bSj();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void a(int i, com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        this.jPM.hideLoadingView();
        this.jPM.Yb();
        this.jPM.bSm();
        if (aVar == null || i != 0 || y.isEmpty(aVar.getDataList())) {
            if (y.isEmpty(this.jPL.cPt())) {
                bSj();
                return;
            } else {
                this.jPM.setListData(this.jPL.cPt());
                return;
            }
        }
        this.jPM.setData(aVar);
        this.jPM.Ya();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSj() {
        if (this.jPM.cPv()) {
            this.jPM.Yb();
            cPs();
            return;
        }
        this.jPM.px(false);
    }

    private void showLoadingView() {
        if (this.jPM.cPv()) {
            this.jPM.hideLoadingView();
            cPr();
            return;
        }
        this.jPM.ib(false);
    }

    public void cPr() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new x());
        this.jPM.cPw();
        this.jPM.setListData(arrayList);
    }

    public void cPs() {
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.ListView.z zVar = new com.baidu.adp.widget.ListView.z();
        zVar.resId = R.drawable.new_pic_emotion_05;
        zVar.showText = getString(R.string.no_data_common_txt);
        arrayList.add(zVar);
        this.jPM.cPw();
        this.jPM.setListData(arrayList);
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
        this.jPM.destroy();
        this.jPL.onDestroy();
    }
}
