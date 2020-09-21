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
/* loaded from: classes21.dex */
public class HotTopicTabFragment extends BaseFragment implements aq, b {
    private HotTopicTabModel iTS;
    private HotTopicTabView iTT;
    private FrsTabItemData iTU;
    private TabLayout.OnTabSelectedListener iTV = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.1
        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (HotTopicTabFragment.this.iTU != null && HotTopicTabFragment.this.iTU.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    HotTopicTabFragment.this.iTS.setTabCode(str);
                    if (HotTopicTabFragment.this.iTS.LoadData()) {
                        HotTopicTabFragment.this.iTT.bHu();
                        HotTopicTabFragment.this.iTT.hideLoadingView();
                        HotTopicTabFragment.this.iTT.bHn();
                        HotTopicTabFragment.this.cBh();
                    } else {
                        HotTopicTabFragment.this.iTT.bHu();
                        HotTopicTabFragment.this.iTT.hideLoadingView();
                        List<q> Kk = HotTopicTabFragment.this.iTS.Kk(str);
                        if (!y.isEmpty(Kk)) {
                            HotTopicTabFragment.this.iTT.setListData(Kk);
                        } else {
                            HotTopicTabFragment.this.bHr();
                        }
                    }
                }
                HotTopicTabFragment.this.iTU = frsTabItemData;
            }
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.iTT.bHu();
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
    private f<Object> iTW = new f<Object>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment.2
        @Override // com.baidu.tbadk.h.f
        public void a(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, i + 1, HotTopicTabFragment.this.bnB());
            }
        }

        @Override // com.baidu.tbadk.h.f
        public void b(View view, Object obj, int i, long j) {
            if (obj != null) {
                a.a(view, obj, HotTopicTabFragment.this.bnB());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public String bnB() {
        return this.iTS != null ? this.iTS.bnB() : "";
    }

    public HotTopicTabFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.iTS = new HotTopicTabModel(pageContext);
        this.iTT = new HotTopicTabView(pageContext);
        this.iTT.setOnTabSelectedListener(this.iTV);
        this.iTT.setOnItemCoverListener(this.iTW);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iTS.setPresenter(this);
        this.iTS.setUniqueId(getUniqueId());
        this.iTT.setPresenter(this);
        this.iTT.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iTT.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iTT.getParent()).removeView(this.iTT);
        }
        return this.iTT;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.iTT.setViewForeground();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tieba.frs.aq
    public void Pd() {
        this.iTT.reload();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bHp() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bHq() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void blA() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.iTT.onChangeSkinType();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.iTT != null) {
            this.iTT.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void loadData() {
        boolean LoadData = this.iTS.LoadData();
        List<q> Kk = this.iTS.Kk(this.iTS.bnB());
        if (LoadData) {
            if (y.isEmpty(Kk) && !this.iTT.cBl()) {
                this.iTT.bHu();
                this.iTT.bHn();
                showLoadingView();
                return;
            }
            return;
        }
        this.iTT.bHu();
        this.iTT.hideLoadingView();
        if (!y.isEmpty(Kk)) {
            this.iTT.setListData(Kk);
        } else if (!j.isNetworkAvailableForImmediately()) {
            bHr();
        }
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b
    public void a(int i, com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        this.iTT.hideLoadingView();
        this.iTT.bHn();
        this.iTT.bHu();
        if (aVar == null || i != 0 || y.isEmpty(aVar.getDataList())) {
            if (y.isEmpty(this.iTS.cBj())) {
                bHr();
                return;
            } else {
                this.iTT.setListData(this.iTS.cBj());
                return;
            }
        }
        this.iTT.setData(aVar);
        this.iTT.bIj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHr() {
        if (this.iTT.cBl()) {
            this.iTT.bHn();
            cBi();
            return;
        }
        this.iTT.nS(false);
    }

    private void showLoadingView() {
        if (this.iTT.cBl()) {
            this.iTT.hideLoadingView();
            cBh();
            return;
        }
        this.iTT.gR(false);
    }

    public void cBh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new x());
        this.iTT.cBm();
        this.iTT.setListData(arrayList);
    }

    public void cBi() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.resId = R.drawable.new_pic_emotion_05;
        zVar.showText = getString(R.string.no_data_common_txt);
        arrayList.add(zVar);
        this.iTT.cBm();
        this.iTT.setListData(arrayList);
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
        this.iTT.destroy();
        this.iTS.onDestroy();
    }
}
