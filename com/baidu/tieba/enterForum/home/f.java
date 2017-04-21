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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f extends BaseFragment {
    private CustomViewPager adA;
    private l bGG;
    private NoNetworkView bGI;
    private PluginErrorTipView bGJ;
    private View bGK;
    private ObservedChangeLinearLayout bGL;
    private FragmentTabWidget bGM;
    private boolean bGH = false;
    private int bGN = 0;
    final CustomMessageListener bGO = new g(this, CmdConfigCustom.CMD_SYNC_FINISH);

    public ObservedChangeLinearLayout WQ() {
        return this.bGL;
    }

    public FragmentTabWidget WR() {
        return this.bGM;
    }

    private void ab(View view) {
        this.bGK = view.findViewById(w.h.enter_root_layout);
        this.bGI = (NoNetworkView) view.findViewById(w.h.view_no_network);
        this.bGJ = (PluginErrorTipView) view.findViewById(w.h.view_plugin_error_tip);
        this.adA = (CustomViewPager) view.findViewById(w.h.fragment_pager);
        this.bGM = (FragmentTabWidget) view.findViewById(w.h.tab_widget);
        this.bGL = (ObservedChangeLinearLayout) view.findViewById(w.h.tab_layout);
        this.bGL.setOnSizeChangeListener(new h(this));
        if (this.bGL.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.bGL.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        this.bGI.a(new i(this));
        WT();
    }

    private void initViewPager() {
        if (this.adA != null) {
            this.adA.setAdapter(new a(this));
            this.adA.setOnPageChangeListener(new j(this));
        }
    }

    private void WS() {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(w.f.ds28));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.aDW = w.e.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(w.l.enter_forum_tab_my_bar));
        this.bGM.addView(fragmentTabIndicator);
        if (!this.bGH) {
            int i = com.baidu.tbadk.core.sharedPref.b.uL().getInt("wefan_switch", 0);
            String string = com.baidu.tbadk.core.sharedPref.b.uL().getString("wefan_tab_name", "");
            String string2 = com.baidu.tbadk.core.sharedPref.b.uL().getString("wefan_url", "");
            if (i == 1 && !StringUtils.isNull(string) && !StringUtils.isNull(string2)) {
                this.bGH = true;
                FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
                fragmentTabIndicator2.setTextSize(0, getResources().getDimension(w.f.ds28));
                fragmentTabIndicator2.setTag(1);
                fragmentTabIndicator2.setGravity(17);
                fragmentTabIndicator2.aDW = w.e.s_actionbar_text_color;
                fragmentTabIndicator2.setText(string);
                this.bGM.addView(fragmentTabIndicator2);
            }
        }
        this.bGM.setTabSelectionListener(new k(this));
    }

    private void WT() {
        initViewPager();
        WS();
        if (this.bGN < 0) {
            this.bGN = 0;
        }
        this.bGM.g(this.bGN, true);
        this.adA.setCurrentItem(this.bGN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu(int i) {
        hv(i);
        this.bGN = i;
        if (i == 0 && this.bGG != null) {
            this.bGG.Ol();
            if (this.bGG.Xb()) {
                this.bGG.Xa();
            }
        }
    }

    private void hv(int i) {
        boolean z = true;
        if (i != 0 && i != 1) {
            z = false;
        }
        if (this.bGG != null) {
            this.bGG.ds(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            hu(this.bGN);
            if (this.bGN == 0 && this.bGG != null) {
                refreshImage(this.bGG.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aq.k(this.bGK, w.e.cp_bg_line_d);
        if (this.bGM != null) {
            this.bGM.onChangeSkinType(i);
        }
        if (this.bGG != null) {
            this.bGG.onChangeSkinType(i);
        }
        if (this.bGI != null) {
            this.bGI.onChangeSkinType(getPageContext(), i);
        }
        if (this.bGJ != null) {
            this.bGJ.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(w.j.fragment_enter_forum, viewGroup, false);
        ab(inflate);
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
        if (this.bGG != null) {
            this.bGG.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bGG != null) {
            this.bGG.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bGI != null && this.bGI.getVisibility() == 0 && com.baidu.adp.lib.util.i.hk()) {
            this.bGI.aL(false);
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
                if (f.this.bGG == null) {
                    f.this.bGG = new l(this.bGQ);
                }
                view = f.this.bGG.getView();
            }
            if (viewGroup != null && view != null) {
                viewGroup.addView(view);
                f.this.hu(f.this.bGN);
            }
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view;
            if (i != 0 || f.this.bGG == null) {
                view = null;
            } else {
                view = f.this.bGG.getView();
                f.this.bGG = null;
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
