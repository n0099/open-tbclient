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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f extends BaseFragment {
    private CustomViewPager Zo;
    private l bJB;
    private PluginErrorTipView bJD;
    private View bJE;
    private ObservedChangeLinearLayout bJF;
    private FragmentTabWidget bJG;
    private NoNetworkView bpe;
    private boolean bJC = false;
    private int bJH = 0;
    final CustomMessageListener bJI = new g(this, CmdConfigCustom.CMD_SYNC_FINISH);

    public ObservedChangeLinearLayout YN() {
        return this.bJF;
    }

    public FragmentTabWidget YO() {
        return this.bJG;
    }

    private void Y(View view) {
        this.bJE = view.findViewById(r.g.enter_root_layout);
        this.bpe = (NoNetworkView) view.findViewById(r.g.view_no_network);
        this.bJD = (PluginErrorTipView) view.findViewById(r.g.view_plugin_error_tip);
        this.Zo = (CustomViewPager) view.findViewById(r.g.fragment_pager);
        this.bJG = (FragmentTabWidget) view.findViewById(r.g.tab_widget);
        this.bJF = (ObservedChangeLinearLayout) view.findViewById(r.g.tab_layout);
        this.bJF.setOnSizeChangeListener(new h(this));
        if (this.bJF.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.bJF.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.e.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        this.bpe.a(new i(this));
        YQ();
    }

    private void initViewPager() {
        if (this.Zo != null) {
            this.Zo.setAdapter(new a(this));
            this.Zo.setOnPageChangeListener(new j(this));
        }
    }

    private void YP() {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(r.e.ds28));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.azS = r.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(r.j.enter_forum_tab_my_bar));
        this.bJG.addView(fragmentTabIndicator);
        if (!this.bJC) {
            int i = com.baidu.tbadk.core.sharedPref.b.um().getInt("wefan_switch", 0);
            String string = com.baidu.tbadk.core.sharedPref.b.um().getString("wefan_tab_name", "");
            String string2 = com.baidu.tbadk.core.sharedPref.b.um().getString("wefan_url", "");
            if (i == 1 && !StringUtils.isNull(string) && !StringUtils.isNull(string2)) {
                this.bJC = true;
                FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
                fragmentTabIndicator2.setTextSize(0, getResources().getDimension(r.e.ds28));
                fragmentTabIndicator2.setTag(1);
                fragmentTabIndicator2.setGravity(17);
                fragmentTabIndicator2.azS = r.d.s_actionbar_text_color;
                fragmentTabIndicator2.setText(string);
                this.bJG.addView(fragmentTabIndicator2);
            }
        }
        this.bJG.setTabSelectionListener(new k(this));
    }

    private void YQ() {
        initViewPager();
        YP();
        if (this.bJH < 0) {
            this.bJH = 0;
        }
        this.bJG.g(this.bJH, true);
        this.Zo.setCurrentItem(this.bJH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ht(int i) {
        hu(i);
        this.bJH = i;
        if (i == 0 && this.bJB != null) {
            this.bJB.SN();
            if (this.bJB.YY()) {
                this.bJB.YX();
            }
        }
    }

    private void hu(int i) {
        boolean z = true;
        if (i != 0 && i != 1) {
            z = false;
        }
        if (this.bJB != null) {
            this.bJB.dr(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            ht(this.bJH);
            if (this.bJH == 0 && this.bJB != null) {
                refreshImage(this.bJB.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        at.l(this.bJE, r.d.cp_bg_line_d);
        if (this.bJG != null) {
            this.bJG.onChangeSkinType(i);
        }
        if (this.bJB != null) {
            this.bJB.onChangeSkinType(i);
        }
        if (this.bpe != null) {
            this.bpe.onChangeSkinType(getPageContext(), i);
        }
        if (this.bJD != null) {
            this.bJD.onChangeSkinType(getPageContext(), i);
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
        this.bJI.setPriority(101);
        registerListener(this.bJI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bJB != null) {
            this.bJB.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bJB != null) {
            this.bJB.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bpe != null && this.bpe.getVisibility() == 0 && com.baidu.adp.lib.util.i.gm()) {
            this.bpe.aJ(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter {
        private f bJK;

        public a(f fVar) {
            this.bJK = fVar;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = null;
            if (i == 0) {
                if (f.this.bJB == null) {
                    f.this.bJB = new l(this.bJK);
                }
                view = f.this.bJB.getView();
            }
            if (viewGroup != null && view != null) {
                viewGroup.addView(view);
                f.this.ht(f.this.bJH);
            }
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view;
            if (i != 0 || f.this.bJB == null) {
                view = null;
            } else {
                view = f.this.bJB.getView();
                f.this.bJB = null;
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
