package com.baidu.tieba.im.frsgroup.view;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.im.frsgroup.view.a.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGroupActivity extends BaseActivity<FrsGroupActivity> {
    private CustomViewPager avd;
    private NoNetworkView dgC;
    private FragmentTabWidget eIP;
    private boolean eIR;
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<c> eIQ = new ArrayList();
    private List<FragmentTabIndicator> eIS = new ArrayList();
    private int mCurrentTabIndex = -1;
    private al eIT = new al() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.1
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<h> arrayList) {
            FrsGroupActivity.this.aQk();
            if (v.J(arrayList)) {
                String str = "";
                if (arVar != null) {
                    str = arVar.errMsg;
                }
                FrsGroupActivity.this.nu(str);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mRootView = LayoutInflater.from(getActivity()).inflate(e.h.frs_group_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.groups).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsGroupActivity.this.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dgC = (NoNetworkView) findViewById(e.g.view_no_network);
        this.eIP = (FragmentTabWidget) findViewById(e.g.tab_widget);
        this.avd = (CustomViewPager) findViewById(e.g.fragment_pager);
        k(bundle);
        aQl();
        initViewPager();
        aQj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kM()) {
            this.eIQ.get(0).ayj();
            aQj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dgC.onChangeSkinType(getPageContext(), i);
        this.eIP.onChangeSkinType(i);
        for (c cVar : this.eIQ) {
            cVar.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        for (c cVar : this.eIQ) {
            cVar.onDestroy();
        }
    }

    private void initViewPager() {
        if (this.eIR) {
            this.eIS.add(pD(getResources().getString(e.j.frsgroup_recommend)));
        }
        this.eIS.add(pD(getResources().getString(e.j.frsgroup_hot)));
        this.eIS.add(pD(getResources().getString(e.j.frsgroup_official)));
        for (FragmentTabIndicator fragmentTabIndicator : this.eIS) {
            this.eIP.addView(fragmentTabIndicator);
        }
        this.eIP.setShouldDrawIndicatorLine(true);
        this.avd.setAdapter(new a());
        this.eIP.setCurrentTab(0, true, false);
        this.avd.setCurrentItem(0);
        this.eIP.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsGroupActivity.this.avd.setCurrentItem(i);
            }
        });
        this.avd.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                FrsGroupActivity.this.eIP.d(i, f);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                FrsGroupActivity.this.eIP.setCurrentTab(i, true, false);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    private FragmentTabIndicator pD(String str) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(e.C0175e.ds28));
        fragmentTabIndicator.aZn = e.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(str);
        return fragmentTabIndicator;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("forum_name", this.mForumName);
        bundle.putBoolean(IntentConfig.SHOW_RECOMMEND, this.eIR);
    }

    private void aQj() {
        this.avd.setVisibility(4);
        this.eIP.setVisibility(4);
        showLoadingView(this.mRootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQk() {
        this.avd.setVisibility(0);
        this.eIP.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu(String str) {
        this.avd.setVisibility(8);
        this.eIP.setVisibility(8);
        setNetRefreshViewTopMargin(BdListViewHelper.bdY);
        showNetRefreshView(this.mRootView, str, true);
    }

    private void k(Bundle bundle) {
        if (bundle == null) {
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
                this.mForumName = getIntent().getStringExtra("forum_name");
                this.eIR = getIntent().getBooleanExtra(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
                return;
            }
            return;
        }
        this.mForumId = bundle.getString("forum_id", "");
        this.mForumName = bundle.getString("forum_name", "");
        this.eIR = bundle.getBoolean(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
    }

    private void aQl() {
        if (this.eIR) {
            c pj = pj(1);
            pj.b(this.eIT);
            this.eIQ.add(pj);
        }
        c pj2 = pj(2);
        if (!this.eIR) {
            pj2.b(this.eIT);
        }
        this.eIQ.add(pj2);
        this.eIQ.add(pj(3));
    }

    private c pj(int i) {
        c cVar = new c(getPageContext());
        cVar.f(i, this.mForumId, this.mForumName);
        cVar.cG(new com.baidu.tieba.im.frsgroup.view.a.a(this).ays());
        cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dgC.a(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            c cVar = (c) v.d(FrsGroupActivity.this.eIQ, i);
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
                ((c) FrsGroupActivity.this.eIQ.get(FrsGroupActivity.this.mCurrentTabIndex)).ayj();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return FrsGroupActivity.this.eIQ.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }
    }
}
