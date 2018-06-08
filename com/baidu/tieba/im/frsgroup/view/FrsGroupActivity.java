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
import com.baidu.tbadk.core.util.w;
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
    private CustomViewPager anE;
    private NoNetworkView cRO;
    private FragmentTabWidget emb;
    private boolean emd;
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<c> emc = new ArrayList();
    private List<FragmentTabIndicator> eme = new ArrayList();
    private int mCurrentTabIndex = -1;
    private aj emf = new aj() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.1
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<h> arrayList) {
            FrsGroupActivity.this.aJb();
            if (w.z(arrayList)) {
                String str = "";
                if (apVar != null) {
                    str = apVar.errMsg;
                }
                FrsGroupActivity.this.mp(str);
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
            public void onClick(View view) {
                FrsGroupActivity.this.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cRO = (NoNetworkView) findViewById(d.g.view_no_network);
        this.emb = (FragmentTabWidget) findViewById(d.g.tab_widget);
        this.anE = (CustomViewPager) findViewById(d.g.fragment_pager);
        j(bundle);
        aJc();
        initViewPager();
        aJa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.jr()) {
            this.emc.get(0).asl();
            aJa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cRO.onChangeSkinType(getPageContext(), i);
        this.emb.onChangeSkinType(i);
        for (c cVar : this.emc) {
            cVar.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        for (c cVar : this.emc) {
            cVar.onDestroy();
        }
    }

    private void initViewPager() {
        if (this.emd) {
            this.eme.add(or(getResources().getString(d.k.frsgroup_recommend)));
        }
        this.eme.add(or(getResources().getString(d.k.frsgroup_hot)));
        this.eme.add(or(getResources().getString(d.k.frsgroup_official)));
        for (FragmentTabIndicator fragmentTabIndicator : this.eme) {
            this.emb.addView(fragmentTabIndicator);
        }
        this.emb.setShouldDrawIndicatorLine(true);
        this.anE.setAdapter(new a());
        this.emb.setCurrentTab(0, true, false);
        this.anE.setCurrentItem(0);
        this.emb.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void i(int i, boolean z) {
                FrsGroupActivity.this.anE.setCurrentItem(i);
            }
        });
        this.anE.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.im.frsgroup.view.FrsGroupActivity.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                FrsGroupActivity.this.emb.d(i, f);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                FrsGroupActivity.this.emb.setCurrentTab(i, true, false);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    private FragmentTabIndicator or(String str) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.e.ds28));
        fragmentTabIndicator.aQD = d.C0141d.s_actionbar_text_color;
        fragmentTabIndicator.setText(str);
        return fragmentTabIndicator;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("forum_name", this.mForumName);
        bundle.putBoolean(IntentConfig.SHOW_RECOMMEND, this.emd);
    }

    private void aJa() {
        this.anE.setVisibility(4);
        this.emb.setVisibility(4);
        showLoadingView(this.mRootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJb() {
        this.anE.setVisibility(0);
        this.emb.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mp(String str) {
        this.anE.setVisibility(8);
        this.emb.setVisibility(8);
        setNetRefreshViewTopMargin(BdListViewHelper.aVl);
        showNetRefreshView(this.mRootView, str, true);
    }

    private void j(Bundle bundle) {
        if (bundle == null) {
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
                this.mForumName = getIntent().getStringExtra("forum_name");
                this.emd = getIntent().getBooleanExtra(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
                return;
            }
            return;
        }
        this.mForumId = bundle.getString("forum_id", "");
        this.mForumName = bundle.getString("forum_name", "");
        this.emd = bundle.getBoolean(FrsGroupActivityConfig.SHOW_RECOMMEND_GROUP, false);
    }

    private void aJc() {
        if (this.emd) {
            c nM = nM(1);
            nM.b(this.emf);
            this.emc.add(nM);
        }
        c nM2 = nM(2);
        if (!this.emd) {
            nM2.b(this.emf);
        }
        this.emc.add(nM2);
        this.emc.add(nM(3));
    }

    private c nM(int i) {
        c cVar = new c(getPageContext());
        cVar.d(i, this.mForumId, this.mForumName);
        cVar.cm(new com.baidu.tieba.im.frsgroup.view.a.a(this).asu());
        cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.cRO.a(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            c cVar = (c) w.c(FrsGroupActivity.this.emc, i);
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
                ((c) FrsGroupActivity.this.emc.get(FrsGroupActivity.this.mCurrentTabIndex)).asl();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return FrsGroupActivity.this.emc.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }
    }
}
