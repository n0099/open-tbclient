package com.baidu.tieba.ala.gamefrslivelist;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaGameFrsLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.k0.e;
import d.b.i0.p0.k0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveListActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    public static final int TAB_INDEX_LIVE = 0;
    public static final int TAB_INDEX_RECOMMEND = 1;
    public String forumGameLabel;
    public String forumId;
    public String forumName;
    public ImageView mForumInfoView;
    public AlaGameFrsLiveListAdapter mFragmentAdapter;
    public NavigationBar mNavigationBar;
    public View mStatusBarView;
    public FragmentTabHost mTabHost;
    public int mCurrTabIndex = -1;
    public final Handler mHandler = new Handler();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaGameFrsLiveListActivity.this.getPageContext().getPageActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (StringUtils.isNull(AlaGameFrsLiveListActivity.this.forumId)) {
                return;
            }
            AlaGameFrsLiveListActivity.this.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(AlaGameFrsLiveListActivity.this.getPageContext().getPageActivity(), AlaGameFrsLiveListActivity.this.forumId, ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.b.h0.k0.b {
        public c() {
        }

        @Override // d.b.h0.k0.b
        public boolean canStat(d.b.h0.k0.d dVar) {
            return false;
        }

        @Override // d.b.h0.k0.b
        public int getMaxCost() {
            return e.b().c();
        }

        @Override // d.b.h0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof k0)) {
                return;
            }
            k0 k0Var = (k0) customResponsedMessage.getData();
            ArrayList arrayList = new ArrayList();
            if (k0Var.e() != null) {
                for (d.b.h0.e0.b bVar : k0Var.e()) {
                    if (bVar.getFragmentTabStructure().f50155a != null) {
                        arrayList.add(bVar.getFragmentTabStructure().f50155a);
                    }
                }
            }
            AlaGameFrsLiveListActivity.this.mFragmentAdapter.c(arrayList);
            int count = AlaGameFrsLiveListActivity.this.mFragmentAdapter.getCount();
            for (int i = 0; i < count; i++) {
                AlaGameFrsLiveListActivity alaGameFrsLiveListActivity = AlaGameFrsLiveListActivity.this;
                alaGameFrsLiveListActivity.createAndAddTabSpec(alaGameFrsLiveListActivity.mFragmentAdapter.getItem(i), i, AlaGameFrsLiveListActivity.this.getTabTextByIndex(i));
            }
            AlaGameFrsLiveListActivity.this.mTabHost.l();
            AlaGameFrsLiveListActivity.this.mTabHost.d(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAndAddTabSpec(Fragment fragment, int i, String str) {
        if (fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.f13313c = fragment;
        bVar.f13311a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.l = R.color.fragment_tab_host_indicator_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setContentWidthWrapContent();
        bVar.f13312b = fragmentTabIndicator;
        this.mTabHost.a(bVar);
    }

    private String getTabNameByIndex(int i) {
        if (i != 0) {
            return getResources().getString(R.string.frs_game_live_bagame2);
        }
        return getResources().getString(R.string.frs_game_live_bagame2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTabTextByIndex(int i) {
        return getTabNameByIndex(i);
    }

    private void initTabSpec() {
        this.mFragmentAdapter = new AlaGameFrsLiveListAdapter(getSupportFragmentManager());
        d dVar = new d(2001620);
        dVar.setPriority(Integer.MAX_VALUE);
        registerListener(dVar);
        k0 k0Var = new k0(getPageContext().getPageActivity());
        k0Var.g(this.forumId);
        k0Var.h(this.forumName);
        k0Var.f(this.forumGameLabel);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001620, k0Var));
    }

    private void updateForumName() {
        if (this.mNavigationBar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        FragmentTabHost fragmentTabHost = this.mTabHost;
        if (fragmentTabHost == null) {
            return null;
        }
        Fragment currentFragment = fragmentTabHost.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).getCurrentPageKey();
            return super.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.b.h0.k0.a
    public d.b.h0.k0.b getPageStayFilter() {
        return new c();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Resources resources;
        int i2;
        FragmentTabHost fragmentTabHost = this.mTabHost;
        if (fragmentTabHost != null) {
            fragmentTabHost.setNeedShowThemeStyle(false);
            FragmentTabWidget fragmentTabWidget = this.mTabHost.getFragmentTabWidget();
            if (i == 1) {
                resources = getResources();
                i2 = R.color.CAM_X0105_1;
            } else {
                resources = getResources();
                i2 = R.color.CAM_X0105;
            }
            fragmentTabWidget.setDiverColor(resources.getColor(i2));
            this.mTabHost.o(i);
            SkinManager.setBackgroundColor(this.mTabHost.getTabWrapper(), R.color.common_color_10274);
        }
        View view = this.mStatusBarView;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.common_color_10274);
        }
        NavigationBar navigationBar = this.mNavigationBar;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        ImageView imageView = this.mForumInfoView;
        if (imageView != null) {
            SkinManager.setNavbarIconSrc(imageView, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
        }
        AlaGameFrsLiveListAdapter alaGameFrsLiveListAdapter = this.mFragmentAdapter;
        if (alaGameFrsLiveListAdapter != null) {
            int count = alaGameFrsLiveListAdapter.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.mFragmentAdapter.getItem(i3);
                if (item instanceof BaseFragment) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.forumId = bundle.getString("live_forum_id");
            this.forumName = bundle.getString("live_forum_name");
            this.forumGameLabel = bundle.getString(AlaGameFrsLiveListActivityConfig.LIVE_FORUM_GAME_LABEL);
        } else if (getIntent() != null) {
            this.forumId = getIntent().getStringExtra("live_forum_id");
            this.forumName = getIntent().getStringExtra("live_forum_name");
            this.forumGameLabel = getIntent().getStringExtra(AlaGameFrsLiveListActivityConfig.LIVE_FORUM_GAME_LABEL);
        } else {
            finish();
            return;
        }
        setContentView(onCreateView(getLayoutInflater(), new FrameLayout(getPageContext().getPageActivity()), (Bundle) null));
        initTabSpec();
        this.mCurrTabIndex = 0;
        this.mTabHost.setCurrentTab(0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(1);
        this.mStatusBarView = new View(getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = UtilHelper.getStatusBarHeight();
        }
        linearLayout.addView(this.mStatusBarView, layoutParams);
        NavigationBar navigationBar = new NavigationBar(getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        navigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, l.g(getPageContext().getPageActivity(), R.dimen.ds24), 0);
        ImageView imageView = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.ala_frs_game_tab_forum_detail, (View.OnClickListener) null);
        this.mForumInfoView = imageView;
        imageView.setLayoutParams(layoutParams2);
        this.mForumInfoView.setOnClickListener(new b());
        updateForumName();
        linearLayout.addView(this.mNavigationBar, new LinearLayout.LayoutParams(-1, -2));
        this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        SkinManager.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        FragmentTabHost fragmentTabHost = new FragmentTabHost(getActivity());
        this.mTabHost = fragmentTabHost;
        fragmentTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.setTabWidgetViewHeight(0);
        this.mTabHost.p();
        this.mTabHost.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.ds12));
        this.mTabHost.getFragmentTabWidget().setDviderRectWidth(-2);
        this.mTabHost.getFragmentTabWidget().setDviderRectHeight(l.g(getActivity(), R.dimen.ds4));
        linearLayout.addView(this.mTabHost);
        return linearLayout;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrTabIndex = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_forum_id", this.forumId);
        bundle.putString("live_forum_name", this.forumName);
        bundle.putString(AlaGameFrsLiveListActivityConfig.LIVE_FORUM_GAME_LABEL, this.forumGameLabel);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
        updateForumName();
    }
}
