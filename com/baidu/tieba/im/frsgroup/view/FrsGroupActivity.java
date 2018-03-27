package com.baidu.tieba.im.frsgroup.view;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.i;
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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.im.frsgroup.view.a.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGroupActivity extends BaseActivity<FrsGroupActivity> {
    private CustomViewPager aUh;
    private NoNetworkView dpl;
    private FragmentTabWidget eFf;
    private boolean eFh;
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<c> eFg = new ArrayList();
    private List<FragmentTabIndicator> eFi = new ArrayList();
    private int mCurrentTabIndex = -1;
    private an eFj = new an() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.1
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<i> arrayList) {
            FrsGroupActivity.this.aJl();
            if (v.E(arrayList)) {
                String str = "";
                if (atVar != null) {
                    str = atVar.errMsg;
                }
                FrsGroupActivity.this.lC(str);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.frs_group_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.groups).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsGroupActivity.this.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dpl = (NoNetworkView) findViewById(d.g.view_no_network);
        this.eFf = (FragmentTabWidget) findViewById(d.g.tab_widget);
        this.aUh = (CustomViewPager) findViewById(d.g.fragment_pager);
        m(bundle);
        aJm();
        initViewPager();
        aJk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.ox()) {
            this.eFg.get(0).atS();
            aJk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dpl.onChangeSkinType(getPageContext(), i);
        this.eFf.onChangeSkinType(i);
        for (c cVar : this.eFg) {
            cVar.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        for (c cVar : this.eFg) {
            cVar.onDestroy();
        }
    }

    private void initViewPager() {
        if (this.eFh) {
            this.eFi.add(nw(getResources().getString(d.j.frsgroup_recommend)));
        }
        this.eFi.add(nw(getResources().getString(d.j.frsgroup_hot)));
        this.eFi.add(nw(getResources().getString(d.j.frsgroup_official)));
        for (FragmentTabIndicator fragmentTabIndicator : this.eFi) {
            this.eFf.addView(fragmentTabIndicator);
        }
        this.eFf.setShouldDrawIndicatorLine(true);
        this.aUh.setAdapter(new a());
        this.eFf.a(0, true, false);
        this.aUh.setCurrentItem(0);
        this.eFf.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void u(int i, boolean z) {
                FrsGroupActivity.this.aUh.setCurrentItem(i);
            }
        });
        this.aUh.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                FrsGroupActivity.this.eFf.g(i, f);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                FrsGroupActivity.this.eFf.a(i, true, false);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    private FragmentTabIndicator nw(String str) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.e.ds28));
        fragmentTabIndicator.bxI = d.C0141d.s_actionbar_text_color;
        fragmentTabIndicator.setText(str);
        return fragmentTabIndicator;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("forum_name", this.mForumName);
        bundle.putBoolean(IntentConfig.SHOW_RECOMMEND, this.eFh);
    }

    private void aJk() {
        this.aUh.setVisibility(4);
        this.eFf.setVisibility(4);
        showLoadingView(this.mRootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJl() {
        this.aUh.setVisibility(0);
        this.eFf.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lC(String str) {
        this.aUh.setVisibility(8);
        this.eFf.setVisibility(8);
        setNetRefreshViewTopMargin(BdListViewHelper.bCM);
        showNetRefreshView(this.mRootView, str, true);
    }

    private void m(Bundle bundle) {
        if (bundle == null) {
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
                this.mForumName = getIntent().getStringExtra("forum_name");
                this.eFh = getIntent().getBooleanExtra(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
                return;
            }
            return;
        }
        this.mForumId = bundle.getString("forum_id", "");
        this.mForumName = bundle.getString("forum_name", "");
        this.eFh = bundle.getBoolean(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
    }

    private void aJm() {
        if (this.eFh) {
            c qe = qe(1);
            qe.b(this.eFj);
            this.eFg.add(qe);
        }
        c qe2 = qe(2);
        if (!this.eFh) {
            qe2.b(this.eFj);
        }
        this.eFg.add(qe2);
        this.eFg.add(qe(3));
    }

    private c qe(int i) {
        c cVar = new c(getPageContext());
        cVar.e(i, this.mForumId, this.mForumName);
        cVar.cl(new com.baidu.tieba.im.frsgroup.view.a.a(this).aub());
        cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dpl.a(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            c cVar = (c) v.f(FrsGroupActivity.this.eFg, i);
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
                ((c) FrsGroupActivity.this.eFg.get(FrsGroupActivity.this.mCurrentTabIndex)).atS();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return FrsGroupActivity.this.eFg.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }
    }
}
