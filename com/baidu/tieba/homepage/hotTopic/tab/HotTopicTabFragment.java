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
    private HotTopicTabModel jvn;
    private HotTopicTabView jvo;
    private FrsTabItemData jvp;
    private TabLayout.OnTabSelectedListener jvq = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.1
        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (HotTopicTabFragment.this.jvp != null && HotTopicTabFragment.this.jvp.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    HotTopicTabFragment.this.jvn.setTabCode(str);
                    if (HotTopicTabFragment.this.jvn.LoadData()) {
                        HotTopicTabFragment.this.jvo.bMH();
                        HotTopicTabFragment.this.jvo.hideLoadingView();
                        HotTopicTabFragment.this.jvo.TK();
                        HotTopicTabFragment.this.cHV();
                    } else {
                        HotTopicTabFragment.this.jvo.bMH();
                        HotTopicTabFragment.this.jvo.hideLoadingView();
                        List<q> Lx = HotTopicTabFragment.this.jvn.Lx(str);
                        if (!y.isEmpty(Lx)) {
                            HotTopicTabFragment.this.jvo.setListData(Lx);
                        } else {
                            HotTopicTabFragment.this.bME();
                        }
                    }
                }
                HotTopicTabFragment.this.jvp = frsTabItemData;
            }
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.jvo.bMH();
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
    private f<Object> jvr = new f<Object>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.2
        @Override // com.baidu.tbadk.h.f
        public void a(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, i + 1, HotTopicTabFragment.this.bse());
            }
        }

        @Override // com.baidu.tbadk.h.f
        public void b(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, HotTopicTabFragment.this.bse());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public String bse() {
        return this.jvn != null ? this.jvn.bse() : "";
    }

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.jvn = new HotTopicTabModel(pageContext);
        this.jvo = new HotTopicTabView(pageContext);
        this.jvo.setOnTabSelectedListener(this.jvq);
        this.jvo.setOnItemCoverListener(this.jvr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jvn.setPresenter(this);
        this.jvn.setUniqueId(getUniqueId());
        this.jvo.setPresenter(this);
        this.jvo.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.jvo.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jvo.getParent()).removeView(this.jvo);
        }
        return this.jvo;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.jvo.setViewForeground();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.aq
    public void Rd() {
        this.jvo.reload();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bMC() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bMD() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bqd() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.jvo.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jvo != null) {
            this.jvo.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.jvn.LoadData();
        List<q> Lx = this.jvn.Lx(this.jvn.bse());
        if (LoadData) {
            if (y.isEmpty(Lx) && !this.jvo.cHZ()) {
                this.jvo.bMH();
                this.jvo.TK();
                showLoadingView();
                return;
            }
            return;
        }
        this.jvo.bMH();
        this.jvo.hideLoadingView();
        if (!y.isEmpty(Lx)) {
            this.jvo.setListData(Lx);
        } else if (!j.isNetworkAvailableForImmediately()) {
            bME();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void a(int i, com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        this.jvo.hideLoadingView();
        this.jvo.TK();
        this.jvo.bMH();
        if (aVar == null || i != 0 || y.isEmpty(aVar.getDataList())) {
            if (y.isEmpty(this.jvn.cHX())) {
                bME();
                return;
            } else {
                this.jvo.setListData(this.jvn.cHX());
                return;
            }
        }
        this.jvo.setData(aVar);
        this.jvo.TJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bME() {
        if (this.jvo.cHZ()) {
            this.jvo.TK();
            cHW();
            return;
        }
        this.jvo.oP(false);
    }

    private void showLoadingView() {
        if (this.jvo.cHZ()) {
            this.jvo.hideLoadingView();
            cHV();
            return;
        }
        this.jvo.hA(false);
    }

    public void cHV() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new x());
        this.jvo.cIa();
        this.jvo.setListData(arrayList);
    }

    public void cHW() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.resId = R.drawable.new_pic_emotion_05;
        zVar.showText = getString(R.string.no_data_common_txt);
        arrayList.add(zVar);
        this.jvo.cIa();
        this.jvo.setListData(arrayList);
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
        this.jvo.destroy();
        this.jvn.onDestroy();
    }
}
