package com.baidu.tieba.im.frsgroup.view;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.im.frsgroup.view.a.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class FrsGroupActivity extends BaseActivity<FrsGroupActivity> {
    private CustomViewPager eRw;
    private NoNetworkView gpw;
    private FragmentTabWidget kuY;
    private boolean kva;
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<c> kuZ = new ArrayList();
    private List<FragmentTabIndicator> jNG = new ArrayList();
    private int mCurrentTabIndex = -1;
    private au kvb = new au() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.1
        @Override // com.baidu.tieba.frs.au
        public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
            FrsGroupActivity.this.cXq();
            if (y.isEmpty(arrayList)) {
                String str = "";
                if (bdVar != null) {
                    str = bdVar.errMsg;
                }
                FrsGroupActivity.this.KD(str);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.frs_group_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.group_for_this_bar));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gpw = (NoNetworkView) findViewById(R.id.view_no_network);
        this.kuY = (FragmentTabWidget) findViewById(R.id.tab_widget);
        this.eRw = (CustomViewPager) findViewById(R.id.fragment_pager);
        initBundle(bundle);
        cXr();
        initViewPager();
        cXp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            this.kuZ.get(0).cAx();
            cXp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gpw.onChangeSkinType(getPageContext(), i);
        this.kuY.onChangeSkinType(i);
        for (c cVar : this.kuZ) {
            cVar.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        for (c cVar : this.kuZ) {
            cVar.onDestroy();
        }
    }

    private void initViewPager() {
        if (this.kva) {
            this.jNG.add(Nz(getResources().getString(R.string.frsgroup_recommend)));
        }
        this.jNG.add(Nz(getResources().getString(R.string.frsgroup_hot)));
        this.jNG.add(Nz(getResources().getString(R.string.frsgroup_official)));
        for (FragmentTabIndicator fragmentTabIndicator : this.jNG) {
            this.kuY.addView(fragmentTabIndicator);
        }
        this.kuY.setShouldDrawIndicatorLine(true);
        this.eRw.setAdapter(new a());
        this.kuY.setCurrentTab(0, true, false);
        this.eRw.setCurrentItem(0);
        this.kuY.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.2
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsGroupActivity.this.eRw.setCurrentItem(i);
            }
        });
        this.eRw.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.3
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                FrsGroupActivity.this.kuY.changeLeft(i, f);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                FrsGroupActivity.this.kuY.setCurrentTab(i, true, false);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    private FragmentTabIndicator Nz(String str) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.ds28));
        fragmentTabIndicator.dayTextColorResId = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setText(str);
        return fragmentTabIndicator;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("forum_name", this.mForumName);
        bundle.putBoolean("show_recommend", this.kva);
    }

    private void cXp() {
        this.eRw.setVisibility(4);
        this.kuY.setVisibility(4);
        showLoadingView(this.mRootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXq() {
        this.eRw.setVisibility(0);
        this.kuY.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KD(String str) {
        this.eRw.setVisibility(8);
        this.kuY.setVisibility(8);
        setNetRefreshViewTopMargin(BdListViewHelper.fFw);
        showNetRefreshView(this.mRootView, str, true);
    }

    private void initBundle(Bundle bundle) {
        if (bundle == null) {
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
                this.mForumName = getIntent().getStringExtra("forum_name");
                this.kva = getIntent().getBooleanExtra(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
                return;
            }
            return;
        }
        this.mForumId = bundle.getString("forum_id", "");
        this.mForumName = bundle.getString("forum_name", "");
        this.kva = bundle.getBoolean(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
    }

    private void cXr() {
        if (this.kva) {
            c El = El(1);
            El.b(this.kvb);
            this.kuZ.add(El);
        }
        c El2 = El(2);
        if (!this.kva) {
            El2.b(this.kvb);
        }
        this.kuZ.add(El2);
        this.kuZ.add(El(3));
    }

    private c El(int i) {
        c cVar = new c(getPageContext());
        cVar.m(i, this.mForumId, this.mForumName);
        cVar.ez(new com.baidu.tieba.im.frsgroup.view.a.a(this).bSo());
        cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gpw.a(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            c cVar = (c) y.getItem(FrsGroupActivity.this.kuZ, i);
            if (cVar == null) {
                return new View(FrsGroupActivity.this.getActivity());
            }
            if (cVar.getView().getParent() == null) {
                viewGroup.addView(cVar.getView());
            }
            return cVar.getView();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (FrsGroupActivity.this.mCurrentTabIndex != i) {
                FrsGroupActivity.this.mCurrentTabIndex = i;
                ((c) FrsGroupActivity.this.kuZ.get(FrsGroupActivity.this.mCurrentTabIndex)).cAx();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return FrsGroupActivity.this.kuZ.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }
    }
}
