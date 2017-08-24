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
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.pageStayDuration.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ae;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseFragment implements ViewPager.OnPageChangeListener {
    private FragmentTabHost bco;
    private TextView bjz;
    private a cvZ;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private int bcq = -1;
    private final Handler mHandler = new Handler();

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
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
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.livetab.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.getPageContext().getPageActivity().finish();
            }
        });
        ImageView imageView = (ImageView) addSystemImageButton.findViewById(d.h.widget_navi_back_button);
        new LinearLayout.LayoutParams(-2, -2).setMargins(0, 0, k.g(getPageContext().getPageActivity(), d.f.ds24), 0);
        this.bjz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.frs_game_live_all2), new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.livetab.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.sendMessage(new CustomMessage(2913033, new IntentConfig(b.this.getPageContext().getPageActivity())));
            }
        });
        Oo();
        linearLayout.addView(this.mNavigationBar, new LinearLayout.LayoutParams(-1, -2));
        this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        ai.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        this.bco = new FragmentTabHost(getActivity());
        this.bco.setup(getChildFragmentManager());
        this.bco.setOnPageChangeListener(this);
        this.bco.setTabWidgetViewHeight((int) getResources().getDimension(d.f.ds80));
        this.bco.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(d.f.ds12));
        this.bco.getFragmentTabWidget().setDviderRectWidth(-2);
        this.bco.getFragmentTabWidget().setDviderRectHeight(k.g(getActivity(), d.f.ds4));
        linearLayout.addView(this.bco);
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
            if (this.bcq < 0) {
                Mx();
                this.bcq = 0;
                this.bco.setCurrentTab(0);
            }
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("square_jump_tab_name", null);
            if (!TextUtils.isEmpty(string)) {
                this.bco.setCurrentTab(m12if(string));
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("square_jump_tab_name", "");
        }
        if (isAdded() && this.bco != null && (this.bco.getCurrentFragment() instanceof BaseFragment)) {
            ((BaseFragment) this.bco.getCurrentFragment()).setPrimary(isPrimary());
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
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bco != null) {
            this.bco.setNeedShowThemeStyle(false);
            this.bco.getFragmentTabWidget().setDiverColor(i == 1 ? getResources().getColor(d.e.cp_cont_b_1) : getResources().getColor(d.e.cp_cont_b));
            this.bco.onChangeSkinType(i);
            ai.k(this.bco.getTabWrapper(), d.e.common_color_10274);
        }
        if (this.mStatusBarView != null) {
            ai.k(this.mStatusBarView, d.e.common_color_10274);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            ai.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.bjz != null) {
            ai.i(this.bjz, d.e.cp_cont_f);
        }
        if (this.cvZ != null) {
            int count = this.cvZ.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.cvZ.getItem(i2);
                if (item instanceof BaseFragment) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.frs.gametab.livetab.b.3
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean FO() {
                return true;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int FP() {
                return e.FU().FW();
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean a(com.baidu.tbadk.pageStayDuration.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.bco == null) {
            return null;
        }
        Fragment currentFragment = this.bco.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).getCurrentPageKey();
            return super.getCurrentPageKey();
        }
        return null;
    }

    /* renamed from: if  reason: not valid java name */
    private int m12if(String str) {
        if ("live".equals(str)) {
            return 0;
        }
        if ("recommend".equals(str)) {
            return 1;
        }
        return "dynamic".equals(str) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fX(int i) {
        switch (i) {
            case 0:
                return getResources().getString(d.l.frs_game_live_bagame);
            case 1:
                return getResources().getString(d.l.frs_game_live_bayou);
            case 2:
                return getResources().getString(d.l.frs_game_live_video);
            default:
                return getResources().getString(d.l.frs_game_live_bagame);
        }
    }

    private void Mx() {
        this.cvZ = new a(getChildFragmentManager());
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_LIVE_TAB_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.livetab.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ae)) {
                    ae aeVar = (ae) customResponsedMessage.getData();
                    ArrayList arrayList = new ArrayList();
                    if (aeVar.agz() != null) {
                        for (com.baidu.tbadk.mainTab.b bVar : aeVar.agz()) {
                            if (bVar.EX().aHI != null) {
                                arrayList.add(bVar.EX().aHI);
                            }
                        }
                    }
                    b.this.cvZ.aa(arrayList);
                    int count = b.this.cvZ.getCount();
                    for (int i = 0; i < count; i++) {
                        b.this.a(b.this.cvZ.getItem(i), i, b.this.fX(i));
                    }
                    b.this.bco.uE();
                    b.this.bco.cC(0);
                }
            }
        };
        customMessageListener.setPriority(Integer.MAX_VALUE);
        registerListener(customMessageListener);
        ae aeVar = new ae(getPageContext().getPageActivity());
        aeVar.setForumId(this.forumId);
        aeVar.setForumName(this.forumName);
        aeVar.setForumGameLabel(this.forumGameLabel);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_LIVE_TAB_ADD_TAB, aeVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.afy = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.aHx = d.e.fragment_tab_host_indicator_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.f.fontsize32));
            fragmentTabIndicator.EY();
            cVar.afx = fragmentTabIndicator;
            this.bco.a(cVar);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bcq = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
        Oo();
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    private void Oo() {
        if (this.mNavigationBar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(d.l.forum));
            sb.append(" · ");
            sb.append(getResources().getString(d.l.frs_live));
            this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
    }
}
