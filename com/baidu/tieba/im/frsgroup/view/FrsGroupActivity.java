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
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.im.frsgroup.view.a.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class FrsGroupActivity extends BaseActivity<FrsGroupActivity> {
    private CustomViewPager eLl;
    private NoNetworkView ghD;
    private FragmentTabWidget kgP;
    private boolean kgR;
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<c> kgQ = new ArrayList();
    private List<FragmentTabIndicator> jzk = new ArrayList();
    private int mCurrentTabIndex = -1;
    private av kgS = new av() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.1
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
            FrsGroupActivity.this.cSx();
            if (y.isEmpty(arrayList)) {
                String str = "";
                if (bdVar != null) {
                    str = bdVar.errMsg;
                }
                FrsGroupActivity.this.Km(str);
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
        this.ghD = (NoNetworkView) findViewById(R.id.view_no_network);
        this.kgP = (FragmentTabWidget) findViewById(R.id.tab_widget);
        this.eLl = (CustomViewPager) findViewById(R.id.fragment_pager);
        initBundle(bundle);
        cSy();
        initViewPager();
        cSw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            this.kgQ.get(0).cwE();
            cSw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ghD.onChangeSkinType(getPageContext(), i);
        this.kgP.onChangeSkinType(i);
        for (c cVar : this.kgQ) {
            cVar.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        for (c cVar : this.kgQ) {
            cVar.onDestroy();
        }
    }

    private void initViewPager() {
        if (this.kgR) {
            this.jzk.add(MQ(getResources().getString(R.string.frsgroup_recommend)));
        }
        this.jzk.add(MQ(getResources().getString(R.string.frsgroup_hot)));
        this.jzk.add(MQ(getResources().getString(R.string.frsgroup_official)));
        for (FragmentTabIndicator fragmentTabIndicator : this.jzk) {
            this.kgP.addView(fragmentTabIndicator);
        }
        this.kgP.setShouldDrawIndicatorLine(true);
        this.eLl.setAdapter(new a());
        this.kgP.setCurrentTab(0, true, false);
        this.eLl.setCurrentItem(0);
        this.kgP.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.2
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsGroupActivity.this.eLl.setCurrentItem(i);
            }
        });
        this.eLl.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.3
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                FrsGroupActivity.this.kgP.changeLeft(i, f);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                FrsGroupActivity.this.kgP.setCurrentTab(i, true, false);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    private FragmentTabIndicator MQ(String str) {
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
        bundle.putBoolean("show_recommend", this.kgR);
    }

    private void cSw() {
        this.eLl.setVisibility(4);
        this.kgP.setVisibility(4);
        showLoadingView(this.mRootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSx() {
        this.eLl.setVisibility(0);
        this.kgP.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km(String str) {
        this.eLl.setVisibility(8);
        this.kgP.setVisibility(8);
        setNetRefreshViewTopMargin(BdListViewHelper.fys);
        showNetRefreshView(this.mRootView, str, true);
    }

    private void initBundle(Bundle bundle) {
        if (bundle == null) {
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
                this.mForumName = getIntent().getStringExtra("forum_name");
                this.kgR = getIntent().getBooleanExtra(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
                return;
            }
            return;
        }
        this.mForumId = bundle.getString("forum_id", "");
        this.mForumName = bundle.getString("forum_name", "");
        this.kgR = bundle.getBoolean(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
    }

    private void cSy() {
        if (this.kgR) {
            c CY = CY(1);
            CY.b(this.kgS);
            this.kgQ.add(CY);
        }
        c CY2 = CY(2);
        if (!this.kgR) {
            CY2.b(this.kgS);
        }
        this.kgQ.add(CY2);
        this.kgQ.add(CY(3));
    }

    private c CY(int i) {
        c cVar = new c(getPageContext());
        cVar.k(i, this.mForumId, this.mForumName);
        cVar.eo(new com.baidu.tieba.im.frsgroup.view.a.a(this).bPj());
        cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.ghD.a(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            c cVar = (c) y.getItem(FrsGroupActivity.this.kgQ, i);
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
                ((c) FrsGroupActivity.this.kgQ.get(FrsGroupActivity.this.mCurrentTabIndex)).cwE();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return FrsGroupActivity.this.kgQ.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }
    }
}
