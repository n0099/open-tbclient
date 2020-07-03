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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.im.frsgroup.view.a.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class FrsGroupActivity extends BaseActivity<FrsGroupActivity> {
    private CustomViewPager dSy;
    private NoNetworkView flI;
    private FragmentTabWidget iTC;
    private boolean iTE;
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<c> iTD = new ArrayList();
    private List<FragmentTabIndicator> ioR = new ArrayList();
    private int mCurrentTabIndex = -1;
    private at iTF = new at() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.1
        @Override // com.baidu.tieba.frs.at
        public void a(int i, int i2, bb bbVar, ArrayList<q> arrayList) {
            FrsGroupActivity.this.cqJ();
            if (w.isEmpty(arrayList)) {
                String str = "";
                if (bbVar != null) {
                    str = bbVar.errMsg;
                }
                FrsGroupActivity.this.EZ(str);
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
        this.flI = (NoNetworkView) findViewById(R.id.view_no_network);
        this.iTC = (FragmentTabWidget) findViewById(R.id.tab_widget);
        this.dSy = (CustomViewPager) findViewById(R.id.fragment_pager);
        initBundle(bundle);
        cqK();
        initViewPager();
        cqI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            this.iTD.get(0).bWu();
            cqI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.flI.onChangeSkinType(getPageContext(), i);
        this.iTC.onChangeSkinType(i);
        for (c cVar : this.iTD) {
            cVar.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        for (c cVar : this.iTD) {
            cVar.onDestroy();
        }
    }

    private void initViewPager() {
        if (this.iTE) {
            this.ioR.add(Hc(getResources().getString(R.string.frsgroup_recommend)));
        }
        this.ioR.add(Hc(getResources().getString(R.string.frsgroup_hot)));
        this.ioR.add(Hc(getResources().getString(R.string.frsgroup_official)));
        for (FragmentTabIndicator fragmentTabIndicator : this.ioR) {
            this.iTC.addView(fragmentTabIndicator);
        }
        this.iTC.setShouldDrawIndicatorLine(true);
        this.dSy.setAdapter(new a());
        this.iTC.setCurrentTab(0, true, false);
        this.dSy.setCurrentItem(0);
        this.iTC.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.2
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsGroupActivity.this.dSy.setCurrentItem(i);
            }
        });
        this.dSy.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.3
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                FrsGroupActivity.this.iTC.changeLeft(i, f);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                FrsGroupActivity.this.iTC.setCurrentTab(i, true, false);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    private FragmentTabIndicator Hc(String str) {
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
        bundle.putBoolean("show_recommend", this.iTE);
    }

    private void cqI() {
        this.dSy.setVisibility(4);
        this.iTC.setVisibility(4);
        showLoadingView(this.mRootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqJ() {
        this.dSy.setVisibility(0);
        this.iTC.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EZ(String str) {
        this.dSy.setVisibility(8);
        this.iTC.setVisibility(8);
        setNetRefreshViewTopMargin(BdListViewHelper.eDT);
        showNetRefreshView(this.mRootView, str, true);
    }

    private void initBundle(Bundle bundle) {
        if (bundle == null) {
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
                this.mForumName = getIntent().getStringExtra("forum_name");
                this.iTE = getIntent().getBooleanExtra(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
                return;
            }
            return;
        }
        this.mForumId = bundle.getString("forum_id", "");
        this.mForumName = bundle.getString("forum_name", "");
        this.iTE = bundle.getBoolean(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
    }

    private void cqK() {
        if (this.iTE) {
            c yu = yu(1);
            yu.b(this.iTF);
            this.iTD.add(yu);
        }
        c yu2 = yu(2);
        if (!this.iTE) {
            yu2.b(this.iTF);
        }
        this.iTD.add(yu2);
        this.iTD.add(yu(3));
    }

    private c yu(int i) {
        c cVar = new c(getPageContext());
        cVar.j(i, this.mForumId, this.mForumName);
        cVar.dy(new com.baidu.tieba.im.frsgroup.view.a.a(this).btV());
        cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.flI.a(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            c cVar = (c) w.getItem(FrsGroupActivity.this.iTD, i);
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
                ((c) FrsGroupActivity.this.iTD.get(FrsGroupActivity.this.mCurrentTabIndex)).bWu();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return FrsGroupActivity.this.iTD.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }
    }
}
