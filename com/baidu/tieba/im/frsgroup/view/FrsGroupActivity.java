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
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes17.dex */
public class FrsGroupActivity extends BaseActivity<FrsGroupActivity> {
    private CustomViewPager dYQ;
    private NoNetworkView fqQ;
    private FragmentTabWidget jbO;
    private boolean jbQ;
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<c> jbP = new ArrayList();
    private List<FragmentTabIndicator> iuX = new ArrayList();
    private int mCurrentTabIndex = -1;
    private at jbR = new at() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.1
        @Override // com.baidu.tieba.frs.at
        public void a(int i, int i2, bb bbVar, ArrayList<q> arrayList) {
            FrsGroupActivity.this.cuI();
            if (x.isEmpty(arrayList)) {
                String str = "";
                if (bbVar != null) {
                    str = bbVar.errMsg;
                }
                FrsGroupActivity.this.FK(str);
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
        this.fqQ = (NoNetworkView) findViewById(R.id.view_no_network);
        this.jbO = (FragmentTabWidget) findViewById(R.id.tab_widget);
        this.dYQ = (CustomViewPager) findViewById(R.id.fragment_pager);
        initBundle(bundle);
        cuJ();
        initViewPager();
        cuH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            this.jbP.get(0).bZO();
            cuH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fqQ.onChangeSkinType(getPageContext(), i);
        this.jbO.onChangeSkinType(i);
        for (c cVar : this.jbP) {
            cVar.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        for (c cVar : this.jbP) {
            cVar.onDestroy();
        }
    }

    private void initViewPager() {
        if (this.jbQ) {
            this.iuX.add(HR(getResources().getString(R.string.frsgroup_recommend)));
        }
        this.iuX.add(HR(getResources().getString(R.string.frsgroup_hot)));
        this.iuX.add(HR(getResources().getString(R.string.frsgroup_official)));
        for (FragmentTabIndicator fragmentTabIndicator : this.iuX) {
            this.jbO.addView(fragmentTabIndicator);
        }
        this.jbO.setShouldDrawIndicatorLine(true);
        this.dYQ.setAdapter(new a());
        this.jbO.setCurrentTab(0, true, false);
        this.dYQ.setCurrentItem(0);
        this.jbO.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.2
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsGroupActivity.this.dYQ.setCurrentItem(i);
            }
        });
        this.dYQ.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.3
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                FrsGroupActivity.this.jbO.changeLeft(i, f);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                FrsGroupActivity.this.jbO.setCurrentTab(i, true, false);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    private FragmentTabIndicator HR(String str) {
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
        bundle.putBoolean("show_recommend", this.jbQ);
    }

    private void cuH() {
        this.dYQ.setVisibility(4);
        this.jbO.setVisibility(4);
        showLoadingView(this.mRootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuI() {
        this.dYQ.setVisibility(0);
        this.jbO.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FK(String str) {
        this.dYQ.setVisibility(8);
        this.jbO.setVisibility(8);
        setNetRefreshViewTopMargin(BdListViewHelper.eKp);
        showNetRefreshView(this.mRootView, str, true);
    }

    private void initBundle(Bundle bundle) {
        if (bundle == null) {
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
                this.mForumName = getIntent().getStringExtra("forum_name");
                this.jbQ = getIntent().getBooleanExtra(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
                return;
            }
            return;
        }
        this.mForumId = bundle.getString("forum_id", "");
        this.mForumName = bundle.getString("forum_name", "");
        this.jbQ = bundle.getBoolean(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
    }

    private void cuJ() {
        if (this.jbQ) {
            c yS = yS(1);
            yS.b(this.jbR);
            this.jbP.add(yS);
        }
        c yS2 = yS(2);
        if (!this.jbQ) {
            yS2.b(this.jbR);
        }
        this.jbP.add(yS2);
        this.jbP.add(yS(3));
    }

    private c yS(int i) {
        c cVar = new c(getPageContext());
        cVar.j(i, this.mForumId, this.mForumName);
        cVar.dF(new com.baidu.tieba.im.frsgroup.view.a.a(this).bxf());
        cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fqQ.a(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            c cVar = (c) x.getItem(FrsGroupActivity.this.jbP, i);
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
                ((c) FrsGroupActivity.this.jbP.get(FrsGroupActivity.this.mCurrentTabIndex)).bZO();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return FrsGroupActivity.this.jbP.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }
    }
}
