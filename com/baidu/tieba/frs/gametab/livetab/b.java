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
import com.baidu.tieba.frs.ag;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b extends BaseFragment implements ViewPager.OnPageChangeListener {
    private FragmentTabHost bUK;
    private ImageView chj;
    private a dNT;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private NavigationBar mNavigationBar;
    private int chl = -1;
    private final Handler mHandler = new Handler();
    private CustomMessageListener dKB = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.livetab.b.1
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
    private CustomMessageListener dNU = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO) { // from class: com.baidu.tieba.frs.gametab.livetab.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.bUK != null && b.this.dNT != null && b.this.dNT.getCount() >= 2) {
                b.this.bUK.setCurrentTab(1);
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
        layoutParams.setMargins(0, 0, l.s(getPageContext().getPageActivity(), d.e.ds24), 0);
        this.chj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.chj.setLayoutParams(layoutParams);
        this.chj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.livetab.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(b.this.forumId)) {
                    b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(b.this.getPageContext().getPageActivity(), b.this.forumId, ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            }
        });
        XL();
        linearLayout.addView(this.mNavigationBar, new LinearLayout.LayoutParams(-1, -2));
        this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        aj.t(this.mNavigationBar.getBottomLine(), d.C0107d.cp_bg_line_b);
        this.bUK = new FragmentTabHost(getActivity());
        this.bUK.setup(getChildFragmentManager());
        this.bUK.setOnPageChangeListener(this);
        this.bUK.setTabWidgetViewHeight((int) getResources().getDimension(d.e.ds80));
        this.bUK.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(d.e.ds12));
        this.bUK.getFragmentTabWidget().setDviderRectWidth(l.s(getActivity(), d.e.ds64));
        this.bUK.getFragmentTabWidget().setDviderRectHeight(l.s(getActivity(), d.e.ds4));
        linearLayout.addView(this.bUK);
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
            if (this.chl < 0) {
                UX();
                this.chl = 0;
                this.bUK.setCurrentTab(0);
            }
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("square_jump_tab_name", null);
            if (!TextUtils.isEmpty(string)) {
                this.bUK.setCurrentTab(lF(string));
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("square_jump_tab_name", "");
        }
        if (isAdded() && this.bUK != null && (this.bUK.getCurrentFragment() instanceof BaseFragment)) {
            ((BaseFragment) this.bUK.getCurrentFragment()).setPrimary(isPrimary());
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
        this.dKB.setSelfListener(true);
        registerListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, this.dKB, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, this.dKB, getBaseFragmentActivity().getUniqueId());
        registerListener(this.dNU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bUK != null) {
            this.bUK.setNeedShowThemeStyle(false);
            this.bUK.getFragmentTabWidget().setDiverColor(i == 1 ? getResources().getColor(d.C0107d.cp_cont_b_1) : getResources().getColor(d.C0107d.cp_cont_b));
            this.bUK.onChangeSkinType(i);
            aj.t(this.bUK.getTabWrapper(), d.C0107d.common_color_10274);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            aj.t(this.mNavigationBar.getBottomLine(), d.C0107d.cp_bg_line_b);
        }
        if (this.chj != null) {
            aj.a(this.chj, d.f.btn_more_selector_s, d.f.btn_more_selector);
        }
        if (this.dNT != null) {
            int count = this.dNT.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.dNT.getItem(i2);
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
            public boolean Ne() {
                return true;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Nf() {
                return e.Nj().Nl();
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean a(com.baidu.tbadk.pageStayDuration.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.bUK == null) {
            return null;
        }
        Fragment currentFragment = this.bUK.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).getCurrentPageKey();
            return super.getCurrentPageKey();
        }
        return null;
    }

    private int lF(String str) {
        return (!"live".equals(str) && "dynamic".equals(str)) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jY(int i) {
        switch (i) {
            case 0:
                return getResources().getString(d.j.frsgame_title);
            case 1:
                return getResources().getString(d.j.frs_game_live_video);
            default:
                return getResources().getString(d.j.frsgame_title);
        }
    }

    private void UX() {
        this.dNT = new a(getChildFragmentManager());
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_LIVE_TAB_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.livetab.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ag)) {
                    ag agVar = (ag) customResponsedMessage.getData();
                    ArrayList arrayList = new ArrayList();
                    if (agVar.atJ() != null) {
                        for (com.baidu.tbadk.mainTab.b bVar : agVar.atJ()) {
                            if (bVar.Mn().bvG != null) {
                                arrayList.add(bVar.Mn().bvG);
                            }
                        }
                    }
                    b.this.dNT.aw(arrayList);
                    int count = b.this.dNT.getCount();
                    for (int i = 0; i < count; i++) {
                        b.this.a(b.this.dNT.getItem(i), i, b.this.jY(i));
                    }
                    b.this.bUK.Bu();
                    b.this.bUK.fx(0);
                }
            }
        };
        customMessageListener.setPriority(Integer.MAX_VALUE);
        registerListener(customMessageListener);
        ag agVar = new ag(getPageContext().getPageActivity());
        agVar.setForumId(this.forumId);
        agVar.setForumName(this.forumName);
        agVar.setForumGameLabel(this.forumGameLabel);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_LIVE_TAB_ADD_TAB, agVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.aSR = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.bvz = d.C0107d.fragment_tab_host_indicator_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.Mo();
            cVar.aSQ = fragmentTabIndicator;
            this.bUK.a(cVar);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.chl = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
        XL();
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    private void XL() {
        if (this.mNavigationBar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(d.j.forum));
            sb.append(" · ");
            sb.append(getResources().getString(d.j.ala_live));
            this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
    }

    public void XA() {
        if (this.bUK != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "LiveTab_" + this.bUK.getCurrentTabIndex()));
        }
    }
}
