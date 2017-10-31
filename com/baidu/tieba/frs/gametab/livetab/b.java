package com.baidu.tieba.frs.gametab.livetab;

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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.pageStayDuration.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.af;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseFragment implements ViewPager.OnPageChangeListener {
    private FragmentTabHost bdS;
    private ImageView bmS;
    private a cNi;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private NavigationBar mNavigationBar;
    private int bey = -1;
    private final Handler mHandler = new Handler();
    private CustomMessageListener cJH = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.livetab.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (b.this.mNavigationBar != null && !b.this.mNavigationBar.getNavBarIsShow()) {
                        b.this.mNavigationBar.showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && b.this.mNavigationBar != null && b.this.mNavigationBar.getNavBarIsShow()) {
                    b.this.mNavigationBar.hideNavigationBarWithAnimation();
                }
            }
        }
    };
    private CustomMessageListener cNj = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO) { // from class: com.baidu.tieba.frs.gametab.livetab.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.bdS != null && b.this.cNi != null && b.this.cNi.getCount() >= 2) {
                b.this.bdS.setCurrentTab(1);
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
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.livetab.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.getPageContext().getPageActivity().finish();
            }
        });
        ImageView imageView = (ImageView) addSystemImageButton.findViewById(d.g.widget_navi_back_button);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.f(getPageContext().getPageActivity(), d.e.ds24), 0);
        this.bmS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.bmS.setLayoutParams(layoutParams);
        this.bmS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.livetab.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(b.this.forumId)) {
                    b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(b.this.getPageContext().getPageActivity(), b.this.forumId, ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            }
        });
        Pf();
        linearLayout.addView(this.mNavigationBar, new LinearLayout.LayoutParams(-1, -2));
        this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        aj.k(this.mNavigationBar.getBottomLine(), d.C0080d.cp_bg_line_b);
        this.bdS = new FragmentTabHost(getActivity());
        this.bdS.setup(getChildFragmentManager());
        this.bdS.setOnPageChangeListener(this);
        this.bdS.setTabWidgetViewHeight((int) getResources().getDimension(d.e.ds80));
        this.bdS.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(d.e.ds12));
        this.bdS.getFragmentTabWidget().setDviderRectWidth(l.f(getActivity(), d.e.ds64));
        this.bdS.getFragmentTabWidget().setDviderRectHeight(l.f(getActivity(), d.e.ds4));
        linearLayout.addView(this.bdS);
        return linearLayout;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.bey < 0) {
                MV();
                this.bey = 0;
                this.bdS.setCurrentTab(0);
            }
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("square_jump_tab_name", null);
            if (!TextUtils.isEmpty(string)) {
                this.bdS.setCurrentTab(lh(string));
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("square_jump_tab_name", "");
        }
        if (isAdded() && this.bdS != null && (this.bdS.getCurrentFragment() instanceof BaseFragment)) {
            ((BaseFragment) this.bdS.getCurrentFragment()).setPrimary(isPrimary());
        }
        if (!isAdded() || isPrimary()) {
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
        this.cJH.setSelfListener(true);
        registerListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, this.cJH, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, this.cJH, getBaseFragmentActivity().getUniqueId());
        registerListener(this.cNj);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bdS != null) {
            this.bdS.setNeedShowThemeStyle(false);
            this.bdS.getFragmentTabWidget().setDiverColor(i == 1 ? getResources().getColor(d.C0080d.cp_cont_b_1) : getResources().getColor(d.C0080d.cp_cont_b));
            this.bdS.onChangeSkinType(i);
            aj.k(this.bdS.getTabWrapper(), d.C0080d.common_color_10274);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            aj.k(this.mNavigationBar.getBottomLine(), d.C0080d.cp_bg_line_b);
        }
        if (this.bmS != null) {
            aj.a(this.bmS, d.f.btn_more_selector_s, d.f.btn_more_selector);
        }
        if (this.cNi != null) {
            int count = this.cNi.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.cNi.getItem(i2);
                if (item instanceof BaseFragment) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.frs.gametab.livetab.b.5
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Fx() {
                return true;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Fy() {
                return e.FD().FF();
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean a(com.baidu.tbadk.pageStayDuration.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.bdS == null) {
            return null;
        }
        Fragment currentFragment = this.bdS.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).getCurrentPageKey();
            return super.getCurrentPageKey();
        }
        return null;
    }

    private int lh(String str) {
        return (!"live".equals(str) && "dynamic".equals(str)) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gv(int i) {
        switch (i) {
            case 0:
                return getResources().getString(d.j.frsgame_title);
            case 1:
                return getResources().getString(d.j.frs_game_live_video);
            default:
                return getResources().getString(d.j.frsgame_title);
        }
    }

    private void MV() {
        this.cNi = new a(getChildFragmentManager());
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_LIVE_TAB_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.livetab.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof af)) {
                    af afVar = (af) customResponsedMessage.getData();
                    ArrayList arrayList = new ArrayList();
                    if (afVar.akj() != null) {
                        for (com.baidu.tbadk.mainTab.b bVar : afVar.akj()) {
                            if (bVar.EG().aGS != null) {
                                arrayList.add(bVar.EG().aGS);
                            }
                        }
                    }
                    b.this.cNi.ab(arrayList);
                    int count = b.this.cNi.getCount();
                    for (int i = 0; i < count; i++) {
                        b.this.a(b.this.cNi.getItem(i), i, b.this.gv(i));
                    }
                    b.this.bdS.uc();
                    b.this.bdS.cA(0);
                }
            }
        };
        customMessageListener.setPriority(Integer.MAX_VALUE);
        registerListener(customMessageListener);
        af afVar = new af(getPageContext().getPageActivity());
        afVar.setForumId(this.forumId);
        afVar.setForumName(this.forumName);
        afVar.setForumGameLabel(this.forumGameLabel);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_LIVE_TAB_ADD_TAB, afVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.aeo = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.aGL = d.C0080d.fragment_tab_host_indicator_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.EH();
            cVar.aen = fragmentTabIndicator;
            this.bdS.a(cVar);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bey = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
        Pf();
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    private void Pf() {
        if (this.mNavigationBar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(d.j.forum));
            sb.append(" · ");
            sb.append(getResources().getString(d.j.ala_live));
            this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
    }
}
