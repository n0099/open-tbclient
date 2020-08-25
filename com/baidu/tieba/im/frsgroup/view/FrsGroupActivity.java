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
/* loaded from: classes17.dex */
public class FrsGroupActivity extends BaseActivity<FrsGroupActivity> {
    private CustomViewPager eiw;
    private NoNetworkView fCm;
    private FragmentTabWidget jqO;
    private boolean jqQ;
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<c> jqP = new ArrayList();
    private List<FragmentTabIndicator> iJm = new ArrayList();
    private int mCurrentTabIndex = -1;
    private av jqR = new av() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.1
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
            FrsGroupActivity.this.cFz();
            if (y.isEmpty(arrayList)) {
                String str = "";
                if (bdVar != null) {
                    str = bdVar.errMsg;
                }
                FrsGroupActivity.this.Il(str);
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
        this.fCm = (NoNetworkView) findViewById(R.id.view_no_network);
        this.jqO = (FragmentTabWidget) findViewById(R.id.tab_widget);
        this.eiw = (CustomViewPager) findViewById(R.id.fragment_pager);
        initBundle(bundle);
        cFA();
        initViewPager();
        cFy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            this.jqP.get(0).ckk();
            cFy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fCm.onChangeSkinType(getPageContext(), i);
        this.jqO.onChangeSkinType(i);
        for (c cVar : this.jqP) {
            cVar.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        for (c cVar : this.jqP) {
            cVar.onDestroy();
        }
    }

    private void initViewPager() {
        if (this.jqQ) {
            this.iJm.add(KJ(getResources().getString(R.string.frsgroup_recommend)));
        }
        this.iJm.add(KJ(getResources().getString(R.string.frsgroup_hot)));
        this.iJm.add(KJ(getResources().getString(R.string.frsgroup_official)));
        for (FragmentTabIndicator fragmentTabIndicator : this.iJm) {
            this.jqO.addView(fragmentTabIndicator);
        }
        this.jqO.setShouldDrawIndicatorLine(true);
        this.eiw.setAdapter(new a());
        this.jqO.setCurrentTab(0, true, false);
        this.eiw.setCurrentItem(0);
        this.jqO.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.2
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsGroupActivity.this.eiw.setCurrentItem(i);
            }
        });
        this.eiw.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.3
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                FrsGroupActivity.this.jqO.changeLeft(i, f);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                FrsGroupActivity.this.jqO.setCurrentTab(i, true, false);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    private FragmentTabIndicator KJ(String str) {
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
        bundle.putBoolean("show_recommend", this.jqQ);
    }

    private void cFy() {
        this.eiw.setVisibility(4);
        this.jqO.setVisibility(4);
        showLoadingView(this.mRootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFz() {
        this.eiw.setVisibility(0);
        this.jqO.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Il(String str) {
        this.eiw.setVisibility(8);
        this.jqO.setVisibility(8);
        setNetRefreshViewTopMargin(BdListViewHelper.eUU);
        showNetRefreshView(this.mRootView, str, true);
    }

    private void initBundle(Bundle bundle) {
        if (bundle == null) {
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
                this.mForumName = getIntent().getStringExtra("forum_name");
                this.jqQ = getIntent().getBooleanExtra(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
                return;
            }
            return;
        }
        this.mForumId = bundle.getString("forum_id", "");
        this.mForumName = bundle.getString("forum_name", "");
        this.jqQ = bundle.getBoolean(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
    }

    private void cFA() {
        if (this.jqQ) {
            c Bl = Bl(1);
            Bl.b(this.jqR);
            this.jqP.add(Bl);
        }
        c Bl2 = Bl(2);
        if (!this.jqQ) {
            Bl2.b(this.jqR);
        }
        this.jqP.add(Bl2);
        this.jqP.add(Bl(3));
    }

    private c Bl(int i) {
        c cVar = new c(getPageContext());
        cVar.j(i, this.mForumId, this.mForumName);
        cVar.dM(new com.baidu.tieba.im.frsgroup.view.a.a(this).bGe());
        cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fCm.a(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            c cVar = (c) y.getItem(FrsGroupActivity.this.jqP, i);
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
                ((c) FrsGroupActivity.this.jqP.get(FrsGroupActivity.this.mCurrentTabIndex)).ckk();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return FrsGroupActivity.this.jqP.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }
    }
}
