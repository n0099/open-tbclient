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
    private CustomViewPager adl;
    private View bEA;
    private ObservedChangeLinearLayout bEB;
    private FragmentTabWidget bEC;
    private l bEw;
    private NoNetworkView bEy;
    private PluginErrorTipView bEz;
    private boolean bEx = false;
    private int bED = 0;
    final CustomMessageListener bEE = new g(this, CmdConfigCustom.CMD_SYNC_FINISH);

    public ObservedChangeLinearLayout Vr() {
        return this.bEB;
    }

    public FragmentTabWidget Vs() {
        return this.bEC;
    }

    private void ab(View view) {
        this.bEA = view.findViewById(w.h.enter_root_layout);
        this.bEy = (NoNetworkView) view.findViewById(w.h.view_no_network);
        this.bEz = (PluginErrorTipView) view.findViewById(w.h.view_plugin_error_tip);
        this.adl = (CustomViewPager) view.findViewById(w.h.fragment_pager);
        this.bEC = (FragmentTabWidget) view.findViewById(w.h.tab_widget);
        this.bEB = (ObservedChangeLinearLayout) view.findViewById(w.h.tab_layout);
        this.bEB.setOnSizeChangeListener(new h(this));
        if (this.bEB.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.bEB.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        this.bEy.a(new i(this));
        Vu();
    }

    private void initViewPager() {
        if (this.adl != null) {
            this.adl.setAdapter(new a(this));
            this.adl.setOnPageChangeListener(new j(this));
        }
    }

    private void Vt() {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(w.f.ds28));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.aDE = w.e.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(w.l.enter_forum_tab_my_bar));
        this.bEC.addView(fragmentTabIndicator);
        if (!this.bEx) {
            int i = com.baidu.tbadk.core.sharedPref.b.uo().getInt("wefan_switch", 0);
            String string = com.baidu.tbadk.core.sharedPref.b.uo().getString("wefan_tab_name", "");
            String string2 = com.baidu.tbadk.core.sharedPref.b.uo().getString("wefan_url", "");
            if (i == 1 && !StringUtils.isNull(string) && !StringUtils.isNull(string2)) {
                this.bEx = true;
                FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
                fragmentTabIndicator2.setTextSize(0, getResources().getDimension(w.f.ds28));
                fragmentTabIndicator2.setTag(1);
                fragmentTabIndicator2.setGravity(17);
                fragmentTabIndicator2.aDE = w.e.s_actionbar_text_color;
                fragmentTabIndicator2.setText(string);
                this.bEC.addView(fragmentTabIndicator2);
            }
        }
        this.bEC.setTabSelectionListener(new k(this));
    }

    private void Vu() {
        initViewPager();
        Vt();
        if (this.bED < 0) {
            this.bED = 0;
        }
        this.bEC.g(this.bED, true);
        this.adl.setCurrentItem(this.bED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hl(int i) {
        hm(i);
        this.bED = i;
        if (i == 0 && this.bEw != null) {
            this.bEw.NE();
            if (this.bEw.VC()) {
                this.bEw.VB();
            }
        }
    }

    private void hm(int i) {
        boolean z = true;
        if (i != 0 && i != 1) {
            z = false;
        }
        if (this.bEw != null) {
            this.bEw.dg(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            hl(this.bED);
            if (this.bED == 0 && this.bEw != null) {
                refreshImage(this.bEw.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aq.k(this.bEA, w.e.cp_bg_line_d);
        if (this.bEC != null) {
            this.bEC.onChangeSkinType(i);
        }
        if (this.bEw != null) {
            this.bEw.onChangeSkinType(i);
        }
        if (this.bEy != null) {
            this.bEy.onChangeSkinType(getPageContext(), i);
        }
        if (this.bEz != null) {
            this.bEz.onChangeSkinType(getPageContext(), i);
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
        this.bEE.setPriority(101);
        registerListener(this.bEE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bEw != null) {
            this.bEw.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bEw != null) {
            this.bEw.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bEy != null && this.bEy.getVisibility() == 0 && com.baidu.adp.lib.util.i.he()) {
            this.bEy.aJ(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter {
        private f bEG;

        public a(f fVar) {
            this.bEG = fVar;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = null;
            if (i == 0) {
                if (f.this.bEw == null) {
                    f.this.bEw = new l(this.bEG);
                }
                view = f.this.bEw.getView();
            }
            if (viewGroup != null && view != null) {
                viewGroup.addView(view);
                f.this.hl(f.this.bED);
            }
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view;
            if (i != 0 || f.this.bEw == null) {
                view = null;
            } else {
                view = f.this.bEw.getView();
                f.this.bEw = null;
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
