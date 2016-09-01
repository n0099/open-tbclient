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
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private CustomViewPager YD;
    private ObservedChangeLinearLayout bGA;
    private FragmentTabWidget bGB;
    private a bGC;
    private l bGw;
    private PluginErrorTipView bGy;
    private View bGz;
    private NoNetworkView blV;
    private boolean bGx = false;
    private int bGD = 0;
    final bi.a bGE = new f(this);
    final CustomMessageListener bGF = new g(this, CmdConfigCustom.CMD_SYNC_FINISH);

    public ObservedChangeLinearLayout Xr() {
        return this.bGA;
    }

    public FragmentTabWidget Xs() {
        return this.bGB;
    }

    private void X(View view) {
        this.bGz = view.findViewById(t.g.enter_root_layout);
        this.blV = (NoNetworkView) view.findViewById(t.g.view_no_network);
        this.bGy = (PluginErrorTipView) view.findViewById(t.g.view_plugin_error_tip);
        this.YD = (CustomViewPager) view.findViewById(t.g.fragment_pager);
        this.bGB = (FragmentTabWidget) view.findViewById(t.g.tab_widget);
        this.bGA = (ObservedChangeLinearLayout) view.findViewById(t.g.tab_layout);
        this.bGA.setOnSizeChangeListener(new h(this));
        if (this.bGA.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.bGA.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), t.e.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        this.blV.a(new i(this));
        if (this.bGE != null) {
            bi.vx().a(this.bGE);
        }
        Xu();
    }

    private void initViewPager() {
        this.bGC = new a(this);
        if (this.YD != null) {
            this.YD.setAdapter(this.bGC);
            this.YD.setOnPageChangeListener(new j(this));
        }
    }

    private void Xt() {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.e.ds28));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.azx = t.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(t.j.enter_forum_tab_my_bar));
        this.bGB.addView(fragmentTabIndicator);
        if (!this.bGx) {
            int i = com.baidu.tbadk.core.sharedPref.b.tS().getInt("wefan_switch", 0);
            String string = com.baidu.tbadk.core.sharedPref.b.tS().getString("wefan_tab_name", "");
            String string2 = com.baidu.tbadk.core.sharedPref.b.tS().getString("wefan_url", "");
            if (i == 1 && !StringUtils.isNull(string) && !StringUtils.isNull(string2)) {
                this.bGx = true;
                FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
                fragmentTabIndicator2.setTextSize(0, getResources().getDimension(t.e.ds28));
                fragmentTabIndicator2.setTag(3);
                fragmentTabIndicator2.setGravity(17);
                fragmentTabIndicator2.azx = t.d.s_actionbar_text_color;
                fragmentTabIndicator2.setText(string);
                this.bGB.addView(fragmentTabIndicator2);
            }
        }
        this.bGB.setTabSelectionListener(new k(this));
    }

    private void Xu() {
        initViewPager();
        Xt();
        if (this.bGD < 0) {
            this.bGD = 0;
        }
        this.bGB.g(this.bGD, true);
        this.YD.setCurrentItem(this.bGD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ho(int i) {
        hp(i);
        this.bGD = i;
        if (i == 0 && this.bGw != null) {
            this.bGw.Rt();
            if (this.bGw.XC()) {
                this.bGw.XB();
            }
        }
    }

    private void hp(int i) {
        boolean z = i == 0 || i == 3;
        if (this.bGw != null) {
            this.bGw.dl(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            ho(this.bGD);
            if (this.bGD == 0 && this.bGw != null) {
                refreshImage(this.bGw.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.l(this.bGz, t.d.cp_bg_line_d);
        if (this.bGB != null) {
            this.bGB.onChangeSkinType(i);
        }
        if (this.bGw != null) {
            this.bGw.onChangeSkinType(i);
        }
        if (this.blV != null) {
            this.blV.onChangeSkinType(getPageContext(), i);
        }
        if (this.bGy != null) {
            this.bGy.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(t.h.fragment_enter_forum, viewGroup, false);
        X(inflate);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bGF.setPriority(101);
        registerListener(this.bGF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bGw != null) {
            this.bGw.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bGw != null) {
            this.bGw.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.blV != null && this.blV.getVisibility() == 0 && com.baidu.adp.lib.util.i.gm()) {
            this.blV.aG(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter {
        private e bGH;

        public a(e eVar) {
            this.bGH = eVar;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = null;
            if (i == 0) {
                if (e.this.bGw == null) {
                    e.this.bGw = new l(this.bGH);
                }
                view = e.this.bGw.getView();
            }
            if (viewGroup != null && view != null) {
                viewGroup.addView(view);
                e.this.ho(e.this.bGD);
            }
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view;
            if (i != 0 || e.this.bGw == null) {
                view = null;
            } else {
                view = e.this.bGw.getView();
                e.this.bGw = null;
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
