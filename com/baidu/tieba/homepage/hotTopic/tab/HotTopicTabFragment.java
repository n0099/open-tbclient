package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.z;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class HotTopicTabFragment extends BaseFragment implements aq, b {
    private HotTopicTabModel iLg;
    private HotTopicTabView iLh;
    private FrsTabItemData iLi;
    private TabLayout.OnTabSelectedListener iLj = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.1
        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (HotTopicTabFragment.this.iLi != null && HotTopicTabFragment.this.iLi.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    HotTopicTabFragment.this.iLg.setTabCode(str);
                    if (HotTopicTabFragment.this.iLg.LoadData()) {
                        HotTopicTabFragment.this.iLh.bGd();
                        HotTopicTabFragment.this.iLh.hideLoadingView();
                        HotTopicTabFragment.this.iLh.bFW();
                        HotTopicTabFragment.this.cxy();
                    } else {
                        HotTopicTabFragment.this.iLh.bGd();
                        HotTopicTabFragment.this.iLh.hideLoadingView();
                        List<q> JH = HotTopicTabFragment.this.iLg.JH(str);
                        if (!y.isEmpty(JH)) {
                            HotTopicTabFragment.this.iLh.setListData(JH);
                        } else {
                            HotTopicTabFragment.this.bGa();
                        }
                    }
                }
                HotTopicTabFragment.this.iLi = frsTabItemData;
            }
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.iLh.bGd();
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
    private f<Object> iLk = new f<Object>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.2
        @Override // com.baidu.tbadk.h.f
        public void a(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, i + 1, HotTopicTabFragment.this.bmH());
            }
        }

        @Override // com.baidu.tbadk.h.f
        public void b(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, HotTopicTabFragment.this.bmH());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public String bmH() {
        return this.iLg != null ? this.iLg.bmH() : "";
    }

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.iLg = new HotTopicTabModel(pageContext);
        this.iLh = new HotTopicTabView(pageContext);
        this.iLh.setOnTabSelectedListener(this.iLj);
        this.iLh.setOnItemCoverListener(this.iLk);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iLg.setPresenter(this);
        this.iLg.setUniqueId(getUniqueId());
        this.iLh.setPresenter(this);
        this.iLh.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iLh.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iLh.getParent()).removeView(this.iLh);
        }
        return this.iLh;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.iLh.setViewForeground();
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13740");
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.ai("obj_type", cwH() ? 1 : 0);
            aqVar.bjn();
        }
    }

    private static boolean cwH() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            if (currentTimeMillis - com.baidu.tbadk.core.sharedPref.b.bik().getLong("unlogin_hot_top_timestamp", 0L) >= 86400000) {
                return true;
            }
        } else {
            long j = com.baidu.tbadk.core.sharedPref.b.bik().getLong(TbadkApplication.getCurrentAccount(), 0L);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && currentTimeMillis - j >= 86400000) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.aq
    public void OA() {
        this.iLh.reload();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bFY() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bFZ() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bkF() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.iLh.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.iLh != null) {
            this.iLh.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.iLg.LoadData();
        List<q> JH = this.iLg.JH(this.iLg.bmH());
        if (LoadData) {
            if (y.isEmpty(JH) && !this.iLh.cxC()) {
                this.iLh.bGd();
                this.iLh.bFW();
                showLoadingView();
                return;
            }
            return;
        }
        this.iLh.bGd();
        this.iLh.hideLoadingView();
        if (!y.isEmpty(JH)) {
            this.iLh.setListData(JH);
        } else if (!j.isNetworkAvailableForImmediately()) {
            bGa();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void a(int i, com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        this.iLh.hideLoadingView();
        this.iLh.bFW();
        this.iLh.bGd();
        if (aVar == null || i != 0 || y.isEmpty(aVar.getDataList())) {
            if (y.isEmpty(this.iLg.cxA())) {
                bGa();
                return;
            } else {
                this.iLh.setListData(this.iLg.cxA());
                return;
            }
        }
        this.iLh.setData(aVar);
        this.iLh.bGS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGa() {
        if (this.iLh.cxC()) {
            this.iLh.bFW();
            cxz();
            return;
        }
        this.iLh.nK(false);
    }

    private void showLoadingView() {
        if (this.iLh.cxC()) {
            this.iLh.hideLoadingView();
            cxy();
            return;
        }
        this.iLh.gS(false);
    }

    public void cxy() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new x());
        this.iLh.cxD();
        this.iLh.setListData(arrayList);
    }

    public void cxz() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.resId = R.drawable.new_pic_emotion_05;
        zVar.showText = getString(R.string.no_data_common_txt);
        arrayList.add(zVar);
        this.iLh.cxD();
        this.iLh.setListData(arrayList);
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
        return "a021";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.iLh.destroy();
        this.iLg.onDestroy();
    }
}
