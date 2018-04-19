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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.im.frsgroup.view.a.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGroupActivity extends BaseActivity<FrsGroupActivity> {
    private CustomViewPager afB;
    private NoNetworkView cHB;
    private FragmentTabWidget dZK;
    private boolean dZM;
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<c> dZL = new ArrayList();
    private List<FragmentTabIndicator> dZN = new ArrayList();
    private int mCurrentTabIndex = -1;
    private aj dZO = new aj() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.1
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<h> arrayList) {
            FrsGroupActivity.this.aEi();
            if (v.w(arrayList)) {
                String str = "";
                if (apVar != null) {
                    str = apVar.errMsg;
                }
                FrsGroupActivity.this.lF(str);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.i.frs_group_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.k.groups).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FrsGroupActivity.this.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cHB = (NoNetworkView) findViewById(d.g.view_no_network);
        this.dZK = (FragmentTabWidget) findViewById(d.g.tab_widget);
        this.afB = (CustomViewPager) findViewById(d.g.fragment_pager);
        j(bundle);
        aEj();
        initViewPager();
        aEh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.gD()) {
            this.dZL.get(0).aoh();
            aEh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cHB.onChangeSkinType(getPageContext(), i);
        this.dZK.onChangeSkinType(i);
        for (c cVar : this.dZL) {
            cVar.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        for (c cVar : this.dZL) {
            cVar.onDestroy();
        }
    }

    private void initViewPager() {
        if (this.dZM) {
            this.dZN.add(nA(getResources().getString(d.k.frsgroup_recommend)));
        }
        this.dZN.add(nA(getResources().getString(d.k.frsgroup_hot)));
        this.dZN.add(nA(getResources().getString(d.k.frsgroup_official)));
        for (FragmentTabIndicator fragmentTabIndicator : this.dZN) {
            this.dZK.addView(fragmentTabIndicator);
        }
        this.dZK.setShouldDrawIndicatorLine(true);
        this.afB.setAdapter(new a());
        this.dZK.setCurrentTab(0, true, false);
        this.afB.setCurrentItem(0);
        this.dZK.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void i(int i, boolean z) {
                FrsGroupActivity.this.afB.setCurrentItem(i);
            }
        });
        this.afB.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                FrsGroupActivity.this.dZK.b(i, f);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                FrsGroupActivity.this.dZK.setCurrentTab(i, true, false);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    private FragmentTabIndicator nA(String str) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.e.ds28));
        fragmentTabIndicator.aIf = d.C0126d.s_actionbar_text_color;
        fragmentTabIndicator.setText(str);
        return fragmentTabIndicator;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("forum_name", this.mForumName);
        bundle.putBoolean(IntentConfig.SHOW_RECOMMEND, this.dZM);
    }

    private void aEh() {
        this.afB.setVisibility(4);
        this.dZK.setVisibility(4);
        showLoadingView(this.mRootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEi() {
        this.afB.setVisibility(0);
        this.dZK.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(String str) {
        this.afB.setVisibility(8);
        this.dZK.setVisibility(8);
        setNetRefreshViewTopMargin(BdListViewHelper.aNm);
        showNetRefreshView(this.mRootView, str, true);
    }

    private void j(Bundle bundle) {
        if (bundle == null) {
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
                this.mForumName = getIntent().getStringExtra("forum_name");
                this.dZM = getIntent().getBooleanExtra(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
                return;
            }
            return;
        }
        this.mForumId = bundle.getString("forum_id", "");
        this.mForumName = bundle.getString("forum_name", "");
        this.dZM = bundle.getBoolean(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
    }

    private void aEj() {
        if (this.dZM) {
            c nB = nB(1);
            nB.b(this.dZO);
            this.dZL.add(nB);
        }
        c nB2 = nB(2);
        if (!this.dZM) {
            nB2.b(this.dZO);
        }
        this.dZL.add(nB2);
        this.dZL.add(nB(3));
    }

    private c nB(int i) {
        c cVar = new c(getPageContext());
        cVar.d(i, this.mForumId, this.mForumName);
        cVar.ce(new com.baidu.tieba.im.frsgroup.view.a.a(this).aoq());
        cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.cHB.a(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            c cVar = (c) v.c(FrsGroupActivity.this.dZL, i);
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
                ((c) FrsGroupActivity.this.dZL.get(FrsGroupActivity.this.mCurrentTabIndex)).aoh();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            return view2 == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return FrsGroupActivity.this.dZL.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }
    }
}
