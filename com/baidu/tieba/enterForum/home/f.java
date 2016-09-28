package com.baidu.tieba.enterForum.home;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f extends BaseFragment {
    private CustomViewPager YQ;
    private l bGH;
    private PluginErrorTipView bGJ;
    private View bGK;
    private ObservedChangeLinearLayout bGL;
    private FragmentTabWidget bGM;
    private NoNetworkView bmi;
    private boolean bGI = false;
    private int bGN = 0;
    final CustomMessageListener bGO = new g(this, CmdConfigCustom.CMD_SYNC_FINISH);

    public ObservedChangeLinearLayout XL() {
        return this.bGL;
    }

    public FragmentTabWidget XM() {
        return this.bGM;
    }

    private void X(View view) {
        this.bGK = view.findViewById(r.g.enter_root_layout);
        this.bmi = (NoNetworkView) view.findViewById(r.g.view_no_network);
        this.bGJ = (PluginErrorTipView) view.findViewById(r.g.view_plugin_error_tip);
        this.YQ = (CustomViewPager) view.findViewById(r.g.fragment_pager);
        this.bGM = (FragmentTabWidget) view.findViewById(r.g.tab_widget);
        this.bGL = (ObservedChangeLinearLayout) view.findViewById(r.g.tab_layout);
        this.bGL.setOnSizeChangeListener(new h(this));
        if (this.bGL.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.bGL.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.e.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        this.bmi.a(new i(this));
        XO();
    }

    private void initViewPager() {
        if (this.YQ != null) {
            this.YQ.setAdapter(new a(this));
            this.YQ.setOnPageChangeListener(new j(this));
        }
    }

    private void XN() {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(r.e.ds28));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.aza = r.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(r.j.enter_forum_tab_my_bar));
        this.bGM.addView(fragmentTabIndicator);
        if (!this.bGI) {
            int i = com.baidu.tbadk.core.sharedPref.b.uh().getInt("wefan_switch", 0);
            String string = com.baidu.tbadk.core.sharedPref.b.uh().getString("wefan_tab_name", "");
            String string2 = com.baidu.tbadk.core.sharedPref.b.uh().getString("wefan_url", "");
            if (i == 1 && !StringUtils.isNull(string) && !StringUtils.isNull(string2)) {
                this.bGI = true;
                FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
                fragmentTabIndicator2.setTextSize(0, getResources().getDimension(r.e.ds28));
                fragmentTabIndicator2.setTag(1);
                fragmentTabIndicator2.setGravity(17);
                fragmentTabIndicator2.aza = r.d.s_actionbar_text_color;
                fragmentTabIndicator2.setText(string);
                this.bGM.addView(fragmentTabIndicator2);
            }
        }
        this.bGM.setTabSelectionListener(new k(this));
    }

    private void XO() {
        initViewPager();
        XN();
        if (this.bGN < 0) {
            this.bGN = 0;
        }
        this.bGM.g(this.bGN, true);
        this.YQ.setCurrentItem(this.bGN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hs(int i) {
        ht(i);
        this.bGN = i;
        if (i == 0 && this.bGH != null) {
            this.bGH.RL();
            if (this.bGH.XW()) {
                this.bGH.XV();
            }
        }
    }

    private void ht(int i) {
        boolean z = true;
        if (i != 0 && i != 1) {
            z = false;
        }
        if (this.bGH != null) {
            this.bGH.dm(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            hs(this.bGN);
            if (this.bGN == 0 && this.bGH != null) {
                refreshImage(this.bGH.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.l(this.bGK, r.d.cp_bg_line_d);
        if (this.bGM != null) {
            this.bGM.onChangeSkinType(i);
        }
        if (this.bGH != null) {
            this.bGH.onChangeSkinType(i);
        }
        if (this.bmi != null) {
            this.bmi.onChangeSkinType(getPageContext(), i);
        }
        if (this.bGJ != null) {
            this.bGJ.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(r.h.fragment_enter_forum, viewGroup, false);
        X(inflate);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bGO.setPriority(101);
        registerListener(this.bGO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bGH != null) {
            this.bGH.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bGH != null) {
            this.bGH.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bmi != null && this.bmi.getVisibility() == 0 && com.baidu.adp.lib.util.i.gm()) {
            this.bmi.aG(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter {
        private f bGQ;

        public a(f fVar) {
            this.bGQ = fVar;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = null;
            if (i == 0) {
                if (f.this.bGH == null) {
                    f.this.bGH = new l(this.bGQ);
                }
                view = f.this.bGH.getView();
            }
            if (viewGroup != null && view != null) {
                viewGroup.addView(view);
                f.this.hs(f.this.bGN);
            }
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view;
            if (i != 0 || f.this.bGH == null) {
                view = null;
            } else {
                view = f.this.bGH.getView();
                f.this.bGH = null;
            }
            if (viewGroup != null && view != null) {
                viewGroup.removeView(view);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
