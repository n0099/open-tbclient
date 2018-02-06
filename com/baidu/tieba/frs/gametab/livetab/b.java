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
    private FragmentTabHost bWZ;
    private ImageView clk;
    private a dRp;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private NavigationBar mNavigationBar;
    private int clm = -1;
    private final Handler mHandler = new Handler();
    private CustomMessageListener dNV = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.livetab.b.1
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
    private CustomMessageListener dRq = new CustomMessageListener(2001621) { // from class: com.baidu.tieba.frs.gametab.livetab.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.bWZ != null && b.this.dRp != null && b.this.dRp.getCount() >= 2) {
                b.this.bWZ.setCurrentTab(1);
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
        layoutParams.setMargins(0, 0, l.t(getPageContext().getPageActivity(), d.e.ds24), 0);
        this.clk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.clk.setLayoutParams(layoutParams);
        this.clk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.livetab.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(b.this.forumId)) {
                    b.this.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(b.this.getPageContext().getPageActivity(), b.this.forumId, ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            }
        });
        YS();
        linearLayout.addView(this.mNavigationBar, new LinearLayout.LayoutParams(-1, -2));
        this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        aj.t(this.mNavigationBar.getBottomLine(), d.C0140d.cp_bg_line_b);
        this.bWZ = new FragmentTabHost(getActivity());
        this.bWZ.setup(getChildFragmentManager());
        this.bWZ.setOnPageChangeListener(this);
        this.bWZ.setTabWidgetViewHeight((int) getResources().getDimension(d.e.tbds104));
        this.bWZ.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(d.e.ds12));
        this.bWZ.getFragmentTabWidget().setDviderRectWidth(l.t(getActivity(), d.e.tbds84));
        this.bWZ.getFragmentTabWidget().setDviderRectHeight(l.t(getActivity(), d.e.tbds4));
        linearLayout.addView(this.bWZ);
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
            if (this.clm < 0) {
                VR();
                this.clm = 0;
                this.bWZ.setCurrentTab(0);
            }
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("square_jump_tab_name", null);
            if (!TextUtils.isEmpty(string)) {
                this.bWZ.setCurrentTab(lX(string));
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("square_jump_tab_name", "");
        }
        if (isAdded() && this.bWZ != null && (this.bWZ.getCurrentFragment() instanceof BaseFragment)) {
            ((BaseFragment) this.bWZ.getCurrentFragment()).setPrimary(isPrimary());
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
        this.dNV.setSelfListener(true);
        registerListener(2001617, this.dNV, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.dNV, getBaseFragmentActivity().getUniqueId());
        registerListener(this.dRq);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bWZ != null) {
            this.bWZ.setNeedShowThemeStyle(false);
            this.bWZ.getFragmentTabWidget().setDiverColor(i == 1 ? getResources().getColor(d.C0140d.cp_cont_b_1) : getResources().getColor(d.C0140d.cp_cont_b));
            this.bWZ.onChangeSkinType(i);
            aj.t(this.bWZ.getTabWrapper(), d.C0140d.common_color_10274);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            aj.t(this.mNavigationBar.getBottomLine(), d.C0140d.cp_bg_line_b);
        }
        if (this.clk != null) {
            aj.a(this.clk, d.f.btn_more_selector_s, d.f.btn_more_selector);
        }
        if (this.dRp != null) {
            int count = this.dRp.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.dRp.getItem(i2);
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
            public boolean NM() {
                return true;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int NN() {
                return e.NR().NT();
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean a(com.baidu.tbadk.pageStayDuration.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.bWZ == null) {
            return null;
        }
        Fragment currentFragment = this.bWZ.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).getCurrentPageKey();
            return super.getCurrentPageKey();
        }
        return null;
    }

    private int lX(String str) {
        return (!"live".equals(str) && "dynamic".equals(str)) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jV(int i) {
        switch (i) {
            case 0:
                return getResources().getString(d.j.frsgame_title);
            case 1:
                return getResources().getString(d.j.frs_game_live_video);
            default:
                return getResources().getString(d.j.frsgame_title);
        }
    }

    private void VR() {
        this.dRp = new a(getChildFragmentManager());
        CustomMessageListener customMessageListener = new CustomMessageListener(2001619) { // from class: com.baidu.tieba.frs.gametab.livetab.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ag)) {
                    ag agVar = (ag) customResponsedMessage.getData();
                    ArrayList arrayList = new ArrayList();
                    if (agVar.auE() != null) {
                        for (com.baidu.tbadk.mainTab.b bVar : agVar.auE()) {
                            if (bVar.MV().bxZ != null) {
                                arrayList.add(bVar.MV().bxZ);
                            }
                        }
                    }
                    b.this.dRp.az(arrayList);
                    int count = b.this.dRp.getCount();
                    for (int i = 0; i < count; i++) {
                        b.this.a(b.this.dRp.getItem(i), i, b.this.jV(i));
                    }
                    b.this.bWZ.BO();
                    b.this.bWZ.fx(0);
                }
            }
        };
        customMessageListener.setPriority(Integer.MAX_VALUE);
        registerListener(customMessageListener);
        ag agVar = new ag(getPageContext().getPageActivity());
        agVar.setForumId(this.forumId);
        agVar.setForumName(this.forumName);
        agVar.setForumGameLabel(this.forumGameLabel);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001619, agVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.aUz = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.bxS = d.C0140d.fragment_tab_host_indicator_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.e.tbds42));
            fragmentTabIndicator.MW();
            cVar.aUy = fragmentTabIndicator;
            fragmentTabIndicator.setContentTvTopMargin(9);
            this.bWZ.a(cVar);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.clm = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
        YS();
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    private void YS() {
        if (this.mNavigationBar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(d.j.forum));
            this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
    }

    public void lY(String str) {
        if (this.bWZ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, str + "_" + this.bWZ.getCurrentTabIndex()));
        }
    }
}
