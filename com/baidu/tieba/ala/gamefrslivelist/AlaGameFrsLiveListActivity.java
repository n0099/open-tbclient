package com.baidu.tieba.ala.gamefrslivelist;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ActivityChooserView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaGameFrsLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.m.b;
import com.baidu.tbadk.m.d;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.an;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveListActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private ImageView gch;
    private AlaGameFrsLiveListAdapter gco;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private FragmentTabHost mTabHost;
    private int gcj = -1;
    private final Handler mHandler = new Handler();

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_forum_id", this.forumId);
        bundle.putString("live_forum_name", this.forumName);
        bundle.putString(AlaGameFrsLiveListActivityConfig.LIVE_FORUM_GAME_LABEL, this.forumGameLabel);
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
        this.mNavigationBar = new NavigationBar(getPageContext().getPageActivity());
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamefrslivelist.AlaGameFrsLiveListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGameFrsLiveListActivity.this.getPageContext().getPageActivity().finish();
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds24), 0);
        this.gch = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.ala_frs_game_tab_forum_detail, (View.OnClickListener) null);
        this.gch.setLayoutParams(layoutParams2);
        this.gch.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamefrslivelist.AlaGameFrsLiveListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(AlaGameFrsLiveListActivity.this.forumId)) {
                    AlaGameFrsLiveListActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(AlaGameFrsLiveListActivity.this.getPageContext().getPageActivity(), AlaGameFrsLiveListActivity.this.forumId, ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            }
        });
        bKR();
        linearLayout.addView(this.mNavigationBar, new LinearLayout.LayoutParams(-1, -2));
        this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        this.mTabHost = new FragmentTabHost(getActivity());
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.setTabWidgetViewHeight(0);
        this.mTabHost.reset();
        this.mTabHost.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.ds12));
        this.mTabHost.getFragmentTabWidget().setDviderRectWidth(-2);
        this.mTabHost.getFragmentTabWidget().setDviderRectHeight(l.getDimens(getActivity(), R.dimen.ds4));
        linearLayout.addView(this.mTabHost);
        return linearLayout;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
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
        this.gcj = 0;
        this.mTabHost.setCurrentTab(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.setNeedShowThemeStyle(false);
            this.mTabHost.getFragmentTabWidget().setDiverColor(i == 1 ? getResources().getColor(R.color.cp_cont_b_1) : getResources().getColor(R.color.cp_cont_b));
            this.mTabHost.onChangeSkinType(i);
            ap.setBackgroundColor(this.mTabHost.getTabWrapper(), R.color.common_color_10274);
        }
        if (this.mStatusBarView != null) {
            ap.setBackgroundColor(this.mStatusBarView, R.color.common_color_10274);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.gch != null) {
            ap.setNavbarIconSrc(this.gch, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
        }
        if (this.gco != null) {
            int count = this.gco.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.gco.getItem(i2);
                if (item instanceof BaseFragment) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public b getPageStayFilter() {
        return new b() { // from class: com.baidu.tieba.ala.gamefrslivelist.AlaGameFrsLiveListActivity.3
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return true;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return e.bve().getMaxCostFromServer();
            }

            @Override // com.baidu.tbadk.m.b
            public boolean canStat(d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.mTabHost == null) {
            return null;
        }
        Fragment currentFragment = this.mTabHost.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).getCurrentPageKey();
            return super.getCurrentPageKey();
        }
        return null;
    }

    private String tG(int i) {
        switch (i) {
            case 0:
                return getResources().getString(R.string.frs_game_live_bagame2);
            default:
                return getResources().getString(R.string.frs_game_live_bagame2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tF(int i) {
        return tG(i);
    }

    private void initTabSpec() {
        this.gco = new AlaGameFrsLiveListAdapter(getSupportFragmentManager());
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_LIVE_ADD_TAB) { // from class: com.baidu.tieba.ala.gamefrslivelist.AlaGameFrsLiveListActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof an)) {
                    an anVar = (an) customResponsedMessage.getData();
                    ArrayList arrayList = new ArrayList();
                    if (anVar.coK() != null) {
                        for (com.baidu.tbadk.mainTab.b bVar : anVar.coK()) {
                            if (bVar.getFragmentTabStructure().frag != null) {
                                arrayList.add(bVar.getFragmentTabStructure().frag);
                            }
                        }
                    }
                    AlaGameFrsLiveListActivity.this.gco.bQ(arrayList);
                    int count = AlaGameFrsLiveListActivity.this.gco.getCount();
                    for (int i = 0; i < count; i++) {
                        AlaGameFrsLiveListActivity.this.a(AlaGameFrsLiveListActivity.this.gco.getItem(i), i, AlaGameFrsLiveListActivity.this.tF(i));
                    }
                    AlaGameFrsLiveListActivity.this.mTabHost.initViewPagerWithNoType();
                    AlaGameFrsLiveListActivity.this.mTabHost.changeStyle(0);
                }
            }
        };
        customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(customMessageListener);
        an anVar = new an(getPageContext().getPageActivity());
        anVar.setForumId(this.forumId);
        anVar.setForumName(this.forumName);
        anVar.setForumGameLabel(this.forumGameLabel);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_LIVE_ADD_TAB, anVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.mContentFragment = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.dayTextColorResId = R.color.fragment_tab_host_indicator_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setContentWidthWrapContent();
            bVar.ekW = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.gcj = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    private void bKR() {
        if (this.mNavigationBar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
    }
}
