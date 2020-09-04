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
    private HotTopicTabModel iLm;
    private HotTopicTabView iLn;
    private FrsTabItemData iLo;
    private TabLayout.OnTabSelectedListener iLp = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.1
        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (HotTopicTabFragment.this.iLo != null && HotTopicTabFragment.this.iLo.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    HotTopicTabFragment.this.iLm.setTabCode(str);
                    if (HotTopicTabFragment.this.iLm.LoadData()) {
                        HotTopicTabFragment.this.iLn.bGe();
                        HotTopicTabFragment.this.iLn.hideLoadingView();
                        HotTopicTabFragment.this.iLn.bFX();
                        HotTopicTabFragment.this.cxz();
                    } else {
                        HotTopicTabFragment.this.iLn.bGe();
                        HotTopicTabFragment.this.iLn.hideLoadingView();
                        List<q> JI = HotTopicTabFragment.this.iLm.JI(str);
                        if (!y.isEmpty(JI)) {
                            HotTopicTabFragment.this.iLn.setListData(JI);
                        } else {
                            HotTopicTabFragment.this.bGb();
                        }
                    }
                }
                HotTopicTabFragment.this.iLo = frsTabItemData;
            }
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.iLn.bGe();
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
    private f<Object> iLq = new f<Object>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.2
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
        return this.iLm != null ? this.iLm.bmH() : "";
    }

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.iLm = new HotTopicTabModel(pageContext);
        this.iLn = new HotTopicTabView(pageContext);
        this.iLn.setOnTabSelectedListener(this.iLp);
        this.iLn.setOnItemCoverListener(this.iLq);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iLm.setPresenter(this);
        this.iLm.setUniqueId(getUniqueId());
        this.iLn.setPresenter(this);
        this.iLn.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iLn.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iLn.getParent()).removeView(this.iLn);
        }
        return this.iLn;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.iLn.setViewForeground();
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13740");
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.ai("obj_type", cwI() ? 1 : 0);
            aqVar.bjn();
        }
    }

    private static boolean cwI() {
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
        this.iLn.reload();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bFZ() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bGa() {
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
        this.iLn.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.iLn != null) {
            this.iLn.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.iLm.LoadData();
        List<q> JI = this.iLm.JI(this.iLm.bmH());
        if (LoadData) {
            if (y.isEmpty(JI) && !this.iLn.cxD()) {
                this.iLn.bGe();
                this.iLn.bFX();
                showLoadingView();
                return;
            }
            return;
        }
        this.iLn.bGe();
        this.iLn.hideLoadingView();
        if (!y.isEmpty(JI)) {
            this.iLn.setListData(JI);
        } else if (!j.isNetworkAvailableForImmediately()) {
            bGb();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void a(int i, com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        this.iLn.hideLoadingView();
        this.iLn.bFX();
        this.iLn.bGe();
        if (aVar == null || i != 0 || y.isEmpty(aVar.getDataList())) {
            if (y.isEmpty(this.iLm.cxB())) {
                bGb();
                return;
            } else {
                this.iLn.setListData(this.iLm.cxB());
                return;
            }
        }
        this.iLn.setData(aVar);
        this.iLn.bGT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGb() {
        if (this.iLn.cxD()) {
            this.iLn.bFX();
            cxA();
            return;
        }
        this.iLn.nM(false);
    }

    private void showLoadingView() {
        if (this.iLn.cxD()) {
            this.iLn.hideLoadingView();
            cxz();
            return;
        }
        this.iLn.gT(false);
    }

    public void cxz() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new x());
        this.iLn.cxE();
        this.iLn.setListData(arrayList);
    }

    public void cxA() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.resId = R.drawable.new_pic_emotion_05;
        zVar.showText = getString(R.string.no_data_common_txt);
        arrayList.add(zVar);
        this.iLn.cxE();
        this.iLn.setListData(arrayList);
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
        this.iLn.destroy();
        this.iLm.onDestroy();
    }
}
