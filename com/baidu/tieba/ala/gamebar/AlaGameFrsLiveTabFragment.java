package com.baidu.tieba.ala.gamebar;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.m.d;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.at;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveTabFragment extends BaseFragment implements ViewPager.OnPageChangeListener, at {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private ImageView gch;
    private AlaGameFrsLiveTabAdapter gci;
    private NavigationBar mNavigationBar;
    private FragmentTabHost mTabHost;
    private int gcj = -1;
    private final Handler mHandler = new Handler();
    private CustomMessageListener gck = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (AlaGameFrsLiveTabFragment.this.mNavigationBar != null && !AlaGameFrsLiveTabFragment.this.mNavigationBar.getNavBarIsShow()) {
                        AlaGameFrsLiveTabFragment.this.mNavigationBar.showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && AlaGameFrsLiveTabFragment.this.mNavigationBar != null && AlaGameFrsLiveTabFragment.this.mNavigationBar.getNavBarIsShow()) {
                    AlaGameFrsLiveTabFragment.this.mNavigationBar.hideNavigationBarWithAnimation();
                }
            }
        }
    };
    private CustomMessageListener gcl = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO) { // from class: com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaGameFrsLiveTabFragment.this.mTabHost != null && AlaGameFrsLiveTabFragment.this.gci != null && AlaGameFrsLiveTabFragment.this.gci.getCount() >= 2) {
                AlaGameFrsLiveTabFragment.this.mTabHost.setCurrentTab(1);
            }
        }
    };
    private CustomMessageListener fNj = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGameLive".equals(split[0]) && 2 == Integer.valueOf(split[1]).intValue()) {
                    AlaGameFrsLiveTabFragment.this.bIh();
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(1);
        this.mNavigationBar = new NavigationBar(getPageContext().getPageActivity());
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, AlaGameFrsLiveTabFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds24), 0);
        this.gch = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.gch.setLayoutParams(layoutParams);
        this.gch.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(AlaGameFrsLiveTabFragment.this.forumId)) {
                    AlaGameFrsLiveTabFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(AlaGameFrsLiveTabFragment.this.getPageContext().getPageActivity(), AlaGameFrsLiveTabFragment.this.forumId, ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            }
        });
        bKR();
        linearLayout.addView(this.mNavigationBar, new LinearLayout.LayoutParams(-1, -2));
        this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        this.mTabHost = new FragmentTabHost(getActivity());
        this.mTabHost.setup(getChildFragmentManager());
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.tbds104));
        this.mTabHost.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.ds12));
        this.mTabHost.getFragmentTabWidget().setDviderRectWidth(l.getDimens(getActivity(), R.dimen.tbds84));
        this.mTabHost.getFragmentTabWidget().setDviderRectHeight(l.getDimens(getActivity(), R.dimen.tbds4));
        linearLayout.addView(this.mTabHost);
        return linearLayout;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.fNj, getBaseFragmentActivity().getUniqueId());
    }

    public void bIh() {
        if (this.mTabHost != null) {
            FragmentTabHost.b nX = this.mTabHost.nX(this.mTabHost.getCurrentTabIndex());
            if (nX != null) {
                if (nX.mType == 3) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGameLiveLive_3"));
                } else if (nX.mType == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGameLiveLive_2"));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.gcj < 0) {
                initTabSpec();
                this.gcj = 0;
                this.mTabHost.setCurrentTab(0);
            }
            String string = b.bjf().getString(SharedPrefConfig.SQUARE_JUMP_TAB_NAME, null);
            if (!TextUtils.isEmpty(string)) {
                this.mTabHost.setCurrentTab(FF(string));
            }
            b.bjf().putString(SharedPrefConfig.SQUARE_JUMP_TAB_NAME, "");
        }
        if (isAdded() && this.mTabHost != null && (this.mTabHost.getCurrentFragment() instanceof BaseFragment)) {
            ((BaseFragment) this.mTabHost.getCurrentFragment()).setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gck.setSelfListener(true);
        registerListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, this.gck, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, this.gck, getBaseFragmentActivity().getUniqueId());
        registerListener(this.gcl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mTabHost != null) {
            this.mTabHost.setNeedShowThemeStyle(false);
            this.mTabHost.getFragmentTabWidget().setDiverColor(i == 1 ? getResources().getColor(R.color.cp_cont_b_1) : getResources().getColor(R.color.cp_cont_b));
            this.mTabHost.onChangeSkinType(i);
            ap.setBackgroundColor(this.mTabHost.getTabWrapper(), R.color.common_color_10274);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.gch != null) {
            ap.setNavbarIconSrc(this.gch, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
        }
        if (this.gci != null) {
            int count = this.gci.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.gci.getItem(i2);
                if (item instanceof BaseFragment) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment.6
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

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
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

    private int FF(String str) {
        return (!"live".equals(str) && PraiseUBCHelper.SOURCE_DYNAMIC.equals(str)) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tF(int i) {
        switch (i) {
            case 0:
                return getResources().getString(R.string.frsgame_title);
            case 1:
                return getResources().getString(R.string.frs_game_live_video);
            default:
                return getResources().getString(R.string.frsgame_title);
        }
    }

    private void initTabSpec() {
        this.gci = new AlaGameFrsLiveTabAdapter(getChildFragmentManager());
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_LIVE_TAB_ADD_TAB) { // from class: com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof an) && AlaGameFrsLiveTabFragment.this.gci.getCount() <= 0) {
                    an anVar = (an) customResponsedMessage.getData();
                    Message<?> message = customResponsedMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(AlaGameFrsLiveTabFragment.this.getUniqueId())) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        if (anVar.coK() != null) {
                            for (com.baidu.tbadk.mainTab.b bVar : anVar.coK()) {
                                if (bVar.getFragmentTabStructure().frag != null) {
                                    arrayList.add(bVar.getFragmentTabStructure().frag);
                                    arrayList2.add(Integer.valueOf(bVar.getFragmentTabStructure().type));
                                }
                            }
                        }
                        AlaGameFrsLiveTabFragment.this.gci.bQ(arrayList);
                        int count = AlaGameFrsLiveTabFragment.this.gci.getCount();
                        for (int i = 0; i < count; i++) {
                            AlaGameFrsLiveTabFragment.this.a(AlaGameFrsLiveTabFragment.this.gci.getItem(i), ((Integer) arrayList2.get(i)).intValue(), AlaGameFrsLiveTabFragment.this.tF(i));
                        }
                        AlaGameFrsLiveTabFragment.this.mTabHost.initViewPagerWithNoType();
                        AlaGameFrsLiveTabFragment.this.mTabHost.changeStyle(0);
                    }
                }
            }
        };
        customMessageListener.setTag(getUniqueId());
        customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerListener(customMessageListener);
        an anVar = new an(getPageContext().getPageActivity());
        anVar.setForumId(this.forumId);
        anVar.setForumName(this.forumName);
        anVar.setForumGameLabel(this.forumGameLabel);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_LIVE_TAB_ADD_TAB, anVar);
        customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
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
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.tbds42));
            fragmentTabIndicator.setContentWidthWrapContent();
            bVar.ekW = fragmentTabIndicator;
            fragmentTabIndicator.setContentTvTopMargin(9);
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

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
        bKR();
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    private void bKR() {
        if (this.mNavigationBar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bKS() {
        return this.mNavigationBar;
    }
}
