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
    private NoNetworkView drf;
    private FragmentTabWidget eTO;
    private boolean eTQ;
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<c> eTP = new ArrayList();
    private List<FragmentTabIndicator> eTR = new ArrayList();
    private int mCurrentTabIndex = -1;
    private al eTS = new al() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.1
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<h> arrayList) {
            FrsGroupActivity.this.aSm();
            if (v.I(arrayList)) {
                String str = "";
                if (arVar != null) {
                    str = arVar.errMsg;
                }
                FrsGroupActivity.this.nX(str);
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
        this.drf = (NoNetworkView) findViewById(e.g.view_no_network);
        this.eTO = (FragmentTabWidget) findViewById(e.g.tab_widget);
        this.azq = (CustomViewPager) findViewById(e.g.fragment_pager);
        q(bundle);
        aSn();
        initViewPager();
        aSl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kK()) {
            this.eTP.get(0).aAg();
            aSl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.drf.onChangeSkinType(getPageContext(), i);
        this.eTO.onChangeSkinType(i);
        for (c cVar : this.eTP) {
            cVar.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        for (c cVar : this.eTP) {
            cVar.onDestroy();
        }
    }

    private void initViewPager() {
        if (this.eTQ) {
            this.eTR.add(qj(getResources().getString(e.j.frsgroup_recommend)));
        }
        this.eTR.add(qj(getResources().getString(e.j.frsgroup_hot)));
        this.eTR.add(qj(getResources().getString(e.j.frsgroup_official)));
        for (FragmentTabIndicator fragmentTabIndicator : this.eTR) {
            this.eTO.addView(fragmentTabIndicator);
        }
        this.eTO.setShouldDrawIndicatorLine(true);
        this.azq.setAdapter(new a());
        this.eTO.setCurrentTab(0, true, false);
        this.azq.setCurrentItem(0);
        this.eTO.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsGroupActivity.this.azq.setCurrentItem(i);
            }
        });
        this.azq.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                FrsGroupActivity.this.eTO.d(i, f);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                FrsGroupActivity.this.eTO.setCurrentTab(i, true, false);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    private FragmentTabIndicator qj(String str) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(e.C0210e.ds28));
        fragmentTabIndicator.bdB = e.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(str);
        return fragmentTabIndicator;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("forum_name", this.mForumName);
        bundle.putBoolean(IntentConfig.SHOW_RECOMMEND, this.eTQ);
    }

    private void aSl() {
        this.azq.setVisibility(4);
        this.eTO.setVisibility(4);
        showLoadingView(this.mRootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSm() {
        this.azq.setVisibility(0);
        this.eTO.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nX(String str) {
        this.azq.setVisibility(8);
        this.eTO.setVisibility(8);
        setNetRefreshViewTopMargin(BdListViewHelper.bir);
        showNetRefreshView(this.mRootView, str, true);
    }

    private void q(Bundle bundle) {
        if (bundle == null) {
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
                this.mForumName = getIntent().getStringExtra("forum_name");
                this.eTQ = getIntent().getBooleanExtra(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
                return;
            }
            return;
        }
        this.mForumId = bundle.getString("forum_id", "");
        this.mForumName = bundle.getString("forum_name", "");
        this.eTQ = bundle.getBoolean(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
    }

    private void aSn() {
        if (this.eTQ) {
            c qj = qj(1);
            qj.b(this.eTS);
            this.eTP.add(qj);
        }
        c qj2 = qj(2);
        if (!this.eTQ) {
            qj2.b(this.eTS);
        }
        this.eTP.add(qj2);
        this.eTP.add(qj(3));
    }

    private c qj(int i) {
        c cVar = new c(getPageContext());
        cVar.g(i, this.mForumId, this.mForumName);
        cVar.cJ(new com.baidu.tieba.im.frsgroup.view.a.a(this).aAp());
        cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.drf.a(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            c cVar = (c) v.d(FrsGroupActivity.this.eTP, i);
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
                ((c) FrsGroupActivity.this.eTP.get(FrsGroupActivity.this.mCurrentTabIndex)).aAg();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return FrsGroupActivity.this.eTP.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }
    }
}
