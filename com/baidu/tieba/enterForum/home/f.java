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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f extends BaseFragment {
    private CustomViewPager XW;
    private l bxq;
    private NoNetworkView bxs;
    private PluginErrorTipView bxt;
    private View bxu;
    private ObservedChangeLinearLayout bxv;
    private FragmentTabWidget bxw;
    private boolean bxr = false;
    private int bxx = 0;
    final CustomMessageListener bxy = new g(this, CmdConfigCustom.CMD_SYNC_FINISH);

    public ObservedChangeLinearLayout Ut() {
        return this.bxv;
    }

    public FragmentTabWidget Uu() {
        return this.bxw;
    }

    private void ad(View view) {
        this.bxu = view.findViewById(r.h.enter_root_layout);
        this.bxs = (NoNetworkView) view.findViewById(r.h.view_no_network);
        this.bxt = (PluginErrorTipView) view.findViewById(r.h.view_plugin_error_tip);
        this.XW = (CustomViewPager) view.findViewById(r.h.fragment_pager);
        this.bxw = (FragmentTabWidget) view.findViewById(r.h.tab_widget);
        this.bxv = (ObservedChangeLinearLayout) view.findViewById(r.h.tab_layout);
        this.bxv.setOnSizeChangeListener(new h(this));
        if (this.bxv.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.bxv.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.f.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        this.bxs.a(new i(this));
        Uw();
    }

    private void initViewPager() {
        if (this.XW != null) {
            this.XW.setAdapter(new a(this));
            this.XW.setOnPageChangeListener(new j(this));
        }
    }

    private void Uv() {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(r.f.ds28));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.ayk = r.e.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(r.l.enter_forum_tab_my_bar));
        this.bxw.addView(fragmentTabIndicator);
        if (!this.bxr) {
            int i = com.baidu.tbadk.core.sharedPref.b.tQ().getInt("wefan_switch", 0);
            String string = com.baidu.tbadk.core.sharedPref.b.tQ().getString("wefan_tab_name", "");
            String string2 = com.baidu.tbadk.core.sharedPref.b.tQ().getString("wefan_url", "");
            if (i == 1 && !StringUtils.isNull(string) && !StringUtils.isNull(string2)) {
                this.bxr = true;
                FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
                fragmentTabIndicator2.setTextSize(0, getResources().getDimension(r.f.ds28));
                fragmentTabIndicator2.setTag(1);
                fragmentTabIndicator2.setGravity(17);
                fragmentTabIndicator2.ayk = r.e.s_actionbar_text_color;
                fragmentTabIndicator2.setText(string);
                this.bxw.addView(fragmentTabIndicator2);
            }
        }
        this.bxw.setTabSelectionListener(new k(this));
    }

    private void Uw() {
        initViewPager();
        Uv();
        if (this.bxx < 0) {
            this.bxx = 0;
        }
        this.bxw.g(this.bxx, true);
        this.XW.setCurrentItem(this.bxx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hp(int i) {
        hq(i);
        this.bxx = i;
        if (i == 0 && this.bxq != null) {
            this.bxq.MR();
            if (this.bxq.UE()) {
                this.bxq.UD();
            }
        }
    }

    private void hq(int i) {
        boolean z = true;
        if (i != 0 && i != 1) {
            z = false;
        }
        if (this.bxq != null) {
            this.bxq.dg(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            hp(this.bxx);
            if (this.bxx == 0 && this.bxq != null) {
                refreshImage(this.bxq.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.k(this.bxu, r.e.cp_bg_line_d);
        if (this.bxw != null) {
            this.bxw.onChangeSkinType(i);
        }
        if (this.bxq != null) {
            this.bxq.onChangeSkinType(i);
        }
        if (this.bxs != null) {
            this.bxs.onChangeSkinType(getPageContext(), i);
        }
        if (this.bxt != null) {
            this.bxt.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(r.j.fragment_enter_forum, viewGroup, false);
        ad(inflate);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bxy.setPriority(101);
        registerListener(this.bxy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bxq != null) {
            this.bxq.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bxq != null) {
            this.bxq.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bxs != null && this.bxs.getVisibility() == 0 && com.baidu.adp.lib.util.i.gk()) {
            this.bxs.aK(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter {
        private f bxA;

        public a(f fVar) {
            this.bxA = fVar;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = null;
            if (i == 0) {
                if (f.this.bxq == null) {
                    f.this.bxq = new l(this.bxA);
                }
                view = f.this.bxq.getView();
            }
            if (viewGroup != null && view != null) {
                viewGroup.addView(view);
                f.this.hp(f.this.bxx);
            }
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view;
            if (i != 0 || f.this.bxq == null) {
                view = null;
            } else {
                view = f.this.bxq.getView();
                f.this.bxq = null;
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
