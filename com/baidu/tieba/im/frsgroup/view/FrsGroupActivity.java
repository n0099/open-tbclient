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
    private CustomViewPager azq;
    private NoNetworkView dop;
    private FragmentTabWidget eQX;
    private boolean eQZ;
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<c> eQY = new ArrayList();
    private List<FragmentTabIndicator> eRa = new ArrayList();
    private int mCurrentTabIndex = -1;
    private al eRb = new al() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.1
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<h> arrayList) {
            FrsGroupActivity.this.aRz();
            if (v.I(arrayList)) {
                String str = "";
                if (arVar != null) {
                    str = arVar.errMsg;
                }
                FrsGroupActivity.this.nU(str);
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
        this.dop = (NoNetworkView) findViewById(e.g.view_no_network);
        this.eQX = (FragmentTabWidget) findViewById(e.g.tab_widget);
        this.azq = (CustomViewPager) findViewById(e.g.fragment_pager);
        q(bundle);
        aRA();
        initViewPager();
        aRy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kK()) {
            this.eQY.get(0).azr();
            aRy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dop.onChangeSkinType(getPageContext(), i);
        this.eQX.onChangeSkinType(i);
        for (c cVar : this.eQY) {
            cVar.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        for (c cVar : this.eQY) {
            cVar.onDestroy();
        }
    }

    private void initViewPager() {
        if (this.eQZ) {
            this.eRa.add(qg(getResources().getString(e.j.frsgroup_recommend)));
        }
        this.eRa.add(qg(getResources().getString(e.j.frsgroup_hot)));
        this.eRa.add(qg(getResources().getString(e.j.frsgroup_official)));
        for (FragmentTabIndicator fragmentTabIndicator : this.eRa) {
            this.eQX.addView(fragmentTabIndicator);
        }
        this.eQX.setShouldDrawIndicatorLine(true);
        this.azq.setAdapter(new a());
        this.eQX.setCurrentTab(0, true, false);
        this.azq.setCurrentItem(0);
        this.eQX.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsGroupActivity.this.azq.setCurrentItem(i);
            }
        });
        this.azq.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                FrsGroupActivity.this.eQX.d(i, f);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                FrsGroupActivity.this.eQX.setCurrentTab(i, true, false);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    private FragmentTabIndicator qg(String str) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(e.C0210e.ds28));
        fragmentTabIndicator.bdy = e.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(str);
        return fragmentTabIndicator;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("forum_name", this.mForumName);
        bundle.putBoolean(IntentConfig.SHOW_RECOMMEND, this.eQZ);
    }

    private void aRy() {
        this.azq.setVisibility(4);
        this.eQX.setVisibility(4);
        showLoadingView(this.mRootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRz() {
        this.azq.setVisibility(0);
        this.eQX.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nU(String str) {
        this.azq.setVisibility(8);
        this.eQX.setVisibility(8);
        setNetRefreshViewTopMargin(BdListViewHelper.bio);
        showNetRefreshView(this.mRootView, str, true);
    }

    private void q(Bundle bundle) {
        if (bundle == null) {
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
                this.mForumName = getIntent().getStringExtra("forum_name");
                this.eQZ = getIntent().getBooleanExtra(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
                return;
            }
            return;
        }
        this.mForumId = bundle.getString("forum_id", "");
        this.mForumName = bundle.getString("forum_name", "");
        this.eQZ = bundle.getBoolean(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
    }

    private void aRA() {
        if (this.eQZ) {
            c pW = pW(1);
            pW.b(this.eRb);
            this.eQY.add(pW);
        }
        c pW2 = pW(2);
        if (!this.eQZ) {
            pW2.b(this.eRb);
        }
        this.eQY.add(pW2);
        this.eQY.add(pW(3));
    }

    private c pW(int i) {
        c cVar = new c(getPageContext());
        cVar.g(i, this.mForumId, this.mForumName);
        cVar.cI(new com.baidu.tieba.im.frsgroup.view.a.a(this).azA());
        cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dop.a(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            c cVar = (c) v.d(FrsGroupActivity.this.eQY, i);
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
                ((c) FrsGroupActivity.this.eQY.get(FrsGroupActivity.this.mCurrentTabIndex)).azr();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return FrsGroupActivity.this.eQY.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }
    }
}
