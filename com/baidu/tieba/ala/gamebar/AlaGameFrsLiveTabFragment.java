package com.baidu.tieba.ala.gamebar;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.o.d;
import com.baidu.tbadk.o.e;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ah;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class AlaGameFrsLiveTabFragment extends BaseFragment implements ViewPager.OnPageChangeListener, ah {
    private ImageView dJC;
    private AlaGameFrsLiveTabAdapter dJD;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private NavigationBar mNavigationBar;
    private FragmentTabHost mTabHost;
    private int dJE = -1;
    private final Handler mHandler = new Handler();
    private CustomMessageListener dJF = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment.1
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
    private CustomMessageListener dJG = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO) { // from class: com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaGameFrsLiveTabFragment.this.mTabHost != null && AlaGameFrsLiveTabFragment.this.dJD != null && AlaGameFrsLiveTabFragment.this.dJD.getCount() >= 2) {
                AlaGameFrsLiveTabFragment.this.mTabHost.setCurrentTab(1);
            }
        }
    };
    private CustomMessageListener dAQ = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGameLive".equals(split[0]) && 2 == Integer.valueOf(split[1]).intValue()) {
                    AlaGameFrsLiveTabFragment.this.aKf();
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
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
        this.dJC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.dJC.setLayoutParams(layoutParams);
        this.dJC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(AlaGameFrsLiveTabFragment.this.forumId)) {
                    AlaGameFrsLiveTabFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(AlaGameFrsLiveTabFragment.this.getPageContext().getPageActivity(), AlaGameFrsLiveTabFragment.this.forumId, ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            }
        });
        aKO();
        linearLayout.addView(this.mNavigationBar, new LinearLayout.LayoutParams(-1, -2));
        this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
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
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.dAQ, getBaseFragmentActivity().getUniqueId());
    }

    public void aKf() {
        if (this.mTabHost != null) {
            FragmentTabHost.b il = this.mTabHost.il(this.mTabHost.getCurrentTabIndex());
            if (il != null) {
                if (il.mType == 3) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGameLiveLive_3"));
                } else if (il.mType == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGameLiveLive_2"));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.dJE < 0) {
                initTabSpec();
                this.dJE = 0;
                this.mTabHost.setCurrentTab(0);
            }
            String string = b.alP().getString(SharedPrefConfig.SQUARE_JUMP_TAB_NAME, null);
            if (!TextUtils.isEmpty(string)) {
                this.mTabHost.setCurrentTab(sX(string));
            }
            b.alP().putString(SharedPrefConfig.SQUARE_JUMP_TAB_NAME, "");
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
        this.dJF.setSelfListener(true);
        registerListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, this.dJF, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, this.dJF, getBaseFragmentActivity().getUniqueId());
        registerListener(this.dJG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mTabHost != null) {
            this.mTabHost.setNeedShowThemeStyle(false);
            this.mTabHost.getFragmentTabWidget().setDiverColor(i == 1 ? getResources().getColor(R.color.cp_cont_b_1) : getResources().getColor(R.color.cp_cont_b));
            this.mTabHost.onChangeSkinType(i);
            am.setBackgroundColor(this.mTabHost.getTabWrapper(), R.color.common_color_10274);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.dJC != null) {
            am.setNavbarIconSrc(this.dJC, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
        }
        if (this.dJD != null) {
            int count = this.dJD.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.dJD.getItem(i2);
                if (item instanceof BaseFragment) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return new com.baidu.tbadk.o.b() { // from class: com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment.6
            @Override // com.baidu.tbadk.o.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return true;
            }

            @Override // com.baidu.tbadk.o.b
            public int getMaxCost() {
                return e.awx().getMaxCostFromServer();
            }

            @Override // com.baidu.tbadk.o.b
            public boolean a(d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
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

    private int sX(String str) {
        return (!"live".equals(str) && "dynamic".equals(str)) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String mE(int i) {
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
        this.dJD = new AlaGameFrsLiveTabAdapter(getChildFragmentManager());
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_LIVE_TAB_ADD_TAB) { // from class: com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ac) && AlaGameFrsLiveTabFragment.this.dJD.getCount() <= 0) {
                    ac acVar = (ac) customResponsedMessage.getData();
                    Message<?> message = customResponsedMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(AlaGameFrsLiveTabFragment.this.getUniqueId())) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        if (acVar.bju() != null) {
                            for (com.baidu.tbadk.mainTab.b bVar : acVar.bju()) {
                                if (bVar.avx().frag != null) {
                                    arrayList.add(bVar.avx().frag);
                                    arrayList2.add(Integer.valueOf(bVar.avx().type));
                                }
                            }
                        }
                        AlaGameFrsLiveTabFragment.this.dJD.bs(arrayList);
                        int count = AlaGameFrsLiveTabFragment.this.dJD.getCount();
                        for (int i = 0; i < count; i++) {
                            AlaGameFrsLiveTabFragment.this.a(AlaGameFrsLiveTabFragment.this.dJD.getItem(i), ((Integer) arrayList2.get(i)).intValue(), AlaGameFrsLiveTabFragment.this.mE(i));
                        }
                        AlaGameFrsLiveTabFragment.this.mTabHost.initViewPagerWithNoType();
                        AlaGameFrsLiveTabFragment.this.mTabHost.changeStyle(0);
                    }
                }
            }
        };
        customMessageListener.setTag(getUniqueId());
        customMessageListener.setPriority(Integer.MAX_VALUE);
        registerListener(customMessageListener);
        ac acVar = new ac(getPageContext().getPageActivity());
        acVar.setForumId(this.forumId);
        acVar.setForumName(this.forumName);
        acVar.setForumGameLabel(this.forumGameLabel);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_LIVE_TAB_ADD_TAB, acVar);
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
            bVar.chu = fragmentTabIndicator;
            fragmentTabIndicator.setContentTvTopMargin(9);
            this.mTabHost.a(bVar);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.dJE = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
        aKO();
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    private void aKO() {
        if (this.mNavigationBar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aKP() {
        return this.mNavigationBar;
    }
}
