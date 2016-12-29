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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f extends BaseFragment {
    private CustomViewPager YI;
    private l bpE;
    private NoNetworkView bpG;
    private PluginErrorTipView bpH;
    private View bpI;
    private ObservedChangeLinearLayout bpJ;
    private FragmentTabWidget bpK;
    private boolean bpF = false;
    private int bpL = 0;
    final CustomMessageListener bpM = new g(this, CmdConfigCustom.CMD_SYNC_FINISH);

    public ObservedChangeLinearLayout SY() {
        return this.bpJ;
    }

    public FragmentTabWidget SZ() {
        return this.bpK;
    }

    private void Y(View view) {
        this.bpI = view.findViewById(r.g.enter_root_layout);
        this.bpG = (NoNetworkView) view.findViewById(r.g.view_no_network);
        this.bpH = (PluginErrorTipView) view.findViewById(r.g.view_plugin_error_tip);
        this.YI = (CustomViewPager) view.findViewById(r.g.fragment_pager);
        this.bpK = (FragmentTabWidget) view.findViewById(r.g.tab_widget);
        this.bpJ = (ObservedChangeLinearLayout) view.findViewById(r.g.tab_layout);
        this.bpJ.setOnSizeChangeListener(new h(this));
        if (this.bpJ.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.bpJ.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.e.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        this.bpG.a(new i(this));
        Tb();
    }

    private void initViewPager() {
        if (this.YI != null) {
            this.YI.setAdapter(new a(this));
            this.YI.setOnPageChangeListener(new j(this));
        }
    }

    private void Ta() {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(r.e.ds28));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.azp = r.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(r.j.enter_forum_tab_my_bar));
        this.bpK.addView(fragmentTabIndicator);
        if (!this.bpF) {
            int i = com.baidu.tbadk.core.sharedPref.b.tW().getInt("wefan_switch", 0);
            String string = com.baidu.tbadk.core.sharedPref.b.tW().getString("wefan_tab_name", "");
            String string2 = com.baidu.tbadk.core.sharedPref.b.tW().getString("wefan_url", "");
            if (i == 1 && !StringUtils.isNull(string) && !StringUtils.isNull(string2)) {
                this.bpF = true;
                FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
                fragmentTabIndicator2.setTextSize(0, getResources().getDimension(r.e.ds28));
                fragmentTabIndicator2.setTag(1);
                fragmentTabIndicator2.setGravity(17);
                fragmentTabIndicator2.azp = r.d.s_actionbar_text_color;
                fragmentTabIndicator2.setText(string);
                this.bpK.addView(fragmentTabIndicator2);
            }
        }
        this.bpK.setTabSelectionListener(new k(this));
    }

    private void Tb() {
        initViewPager();
        Ta();
        if (this.bpL < 0) {
            this.bpL = 0;
        }
        this.bpK.g(this.bpL, true);
        this.YI.setCurrentItem(this.bpL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gD(int i) {
        gE(i);
        this.bpL = i;
        if (i == 0 && this.bpE != null) {
            this.bpE.Tj();
            if (this.bpE.Tl()) {
                this.bpE.Tk();
            }
        }
    }

    private void gE(int i) {
        boolean z = true;
        if (i != 0 && i != 1) {
            z = false;
        }
        if (this.bpE != null) {
            this.bpE.cZ(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            gD(this.bpL);
            if (this.bpL == 0 && this.bpE != null) {
                refreshImage(this.bpE.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ar.l(this.bpI, r.d.cp_bg_line_d);
        if (this.bpK != null) {
            this.bpK.onChangeSkinType(i);
        }
        if (this.bpE != null) {
            this.bpE.onChangeSkinType(i);
        }
        if (this.bpG != null) {
            this.bpG.onChangeSkinType(getPageContext(), i);
        }
        if (this.bpH != null) {
            this.bpH.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(r.h.fragment_enter_forum, viewGroup, false);
        Y(inflate);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bpM.setPriority(101);
        registerListener(this.bpM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bpE != null) {
            this.bpE.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bpE != null) {
            this.bpE.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bpG != null && this.bpG.getVisibility() == 0 && com.baidu.adp.lib.util.i.gm()) {
            this.bpG.aK(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter {
        private f bpO;

        public a(f fVar) {
            this.bpO = fVar;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = null;
            if (i == 0) {
                if (f.this.bpE == null) {
                    f.this.bpE = new l(this.bpO);
                }
                view = f.this.bpE.getView();
            }
            if (viewGroup != null && view != null) {
                viewGroup.addView(view);
                f.this.gD(f.this.bpL);
            }
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view;
            if (i != 0 || f.this.bpE == null) {
                view = null;
            } else {
                view = f.this.bpE.getView();
                f.this.bpE = null;
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
