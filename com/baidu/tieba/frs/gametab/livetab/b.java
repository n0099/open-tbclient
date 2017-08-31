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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.pageStayDuration.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ae;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseFragment implements ViewPager.OnPageChangeListener {
    private FragmentTabHost bbL;
    private TextView bjP;
    private a cCD;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private NavigationBar mNavigationBar;
    private int bcj = -1;
    private final Handler mHandler = new Handler();
    private CustomMessageListener cAt = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.livetab.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (b.this.mNavigationBar != null) {
                        b.this.mNavigationBar.showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && b.this.mNavigationBar != null) {
                    b.this.mNavigationBar.hideNavigationBarWithAnimation();
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
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.livetab.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.getPageContext().getPageActivity().finish();
            }
        });
        ImageView imageView = (ImageView) addSystemImageButton.findViewById(d.h.widget_navi_back_button);
        new LinearLayout.LayoutParams(-2, -2).setMargins(0, 0, k.g(getPageContext().getPageActivity(), d.f.ds24), 0);
        this.bjP = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.all), new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.livetab.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.sendMessage(new CustomMessage(2913033, new IntentConfig(b.this.getPageContext().getPageActivity())));
            }
        });
        OE();
        linearLayout.addView(this.mNavigationBar, new LinearLayout.LayoutParams(-1, -2));
        this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        aj.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        this.bbL = new FragmentTabHost(getActivity());
        this.bbL.setup(getChildFragmentManager());
        this.bbL.setOnPageChangeListener(this);
        this.bbL.setTabWidgetViewHeight((int) getResources().getDimension(d.f.ds80));
        this.bbL.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(d.f.ds12));
        this.bbL.getFragmentTabWidget().setDviderRectWidth(-2);
        this.bbL.getFragmentTabWidget().setDviderRectHeight(k.g(getActivity(), d.f.ds4));
        linearLayout.addView(this.bbL);
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
            if (this.bcj < 0) {
                MA();
                this.bcj = 0;
                this.bbL.setCurrentTab(0);
            }
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("square_jump_tab_name", null);
            if (!TextUtils.isEmpty(string)) {
                this.bbL.setCurrentTab(id(string));
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("square_jump_tab_name", "");
        }
        if (isAdded() && this.bbL != null && (this.bbL.getCurrentFragment() instanceof BaseFragment)) {
            ((BaseFragment) this.bbL.getCurrentFragment()).setPrimary(isPrimary());
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
        this.cAt.setSelfListener(true);
        registerListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, this.cAt, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, this.cAt, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bbL != null) {
            this.bbL.setNeedShowThemeStyle(false);
            this.bbL.getFragmentTabWidget().setDiverColor(i == 1 ? getResources().getColor(d.e.cp_cont_b_1) : getResources().getColor(d.e.cp_cont_b));
            this.bbL.onChangeSkinType(i);
            aj.k(this.bbL.getTabWrapper(), d.e.common_color_10274);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            aj.k(this.mNavigationBar.getBottomLine(), d.e.cp_bg_line_b);
        }
        if (this.bjP != null) {
            aj.i(this.bjP, d.e.cp_cont_f);
        }
        if (this.cCD != null) {
            int count = this.cCD.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.cCD.getItem(i2);
                if (item instanceof BaseFragment) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.frs.gametab.livetab.b.4
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean FM() {
                return true;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int FN() {
                return e.FS().FU();
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean a(com.baidu.tbadk.pageStayDuration.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.bbL == null) {
            return null;
        }
        Fragment currentFragment = this.bbL.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).getCurrentPageKey();
            return super.getCurrentPageKey();
        }
        return null;
    }

    private int id(String str) {
        if ("live".equals(str)) {
            return 0;
        }
        if ("recommend".equals(str)) {
            return 1;
        }
        return "dynamic".equals(str) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fZ(int i) {
        switch (i) {
            case 0:
                return getResources().getString(d.l.frsgame_title);
            case 1:
                return getResources().getString(d.l.frs_game_live_bayou);
            case 2:
                return getResources().getString(d.l.frs_game_live_video);
            default:
                return getResources().getString(d.l.frsgame_title);
        }
    }

    private void MA() {
        this.cCD = new a(getChildFragmentManager());
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_LIVE_TAB_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.livetab.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ae)) {
                    ae aeVar = (ae) customResponsedMessage.getData();
                    ArrayList arrayList = new ArrayList();
                    if (aeVar.ahX() != null) {
                        for (com.baidu.tbadk.mainTab.b bVar : aeVar.ahX()) {
                            if (bVar.EV().aGX != null) {
                                arrayList.add(bVar.EV().aGX);
                            }
                        }
                    }
                    b.this.cCD.aa(arrayList);
                    int count = b.this.cCD.getCount();
                    for (int i = 0; i < count; i++) {
                        b.this.a(b.this.cCD.getItem(i), i, b.this.fZ(i));
                    }
                    b.this.bbL.uz();
                    b.this.bbL.cC(0);
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
            cVar.aeH = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.aGQ = d.e.fragment_tab_host_indicator_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.f.fontsize32));
            fragmentTabIndicator.EW();
            cVar.aeG = fragmentTabIndicator;
            this.bbL.a(cVar);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bcj = i;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
        OE();
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    private void OE() {
        if (this.mNavigationBar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(d.l.forum));
            sb.append(" · ");
            sb.append(getResources().getString(d.l.ala_live));
            this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
    }
}
