package com.baidu.tieba.enterForum.home;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private CustomViewPager UR;
    private k aWX;
    private com.baidu.tieba.enterForum.d.c aWY;
    private NoNetworkView aWZ;
    private PluginErrorTipView aXa;
    private View aXb;
    private ObservedChangeLinearLayout aXc;
    private FragmentTabWidget aXd;
    private a aXe;
    private int aXf = 0;
    final CustomMessageListener aXg = new f(this, CmdConfigCustom.CMD_ENTER_FORUM_ADD_TOGETHERHI_TAB);

    public ObservedChangeLinearLayout Mr() {
        return this.aXc;
    }

    public FragmentTabWidget Ms() {
        return this.aXd;
    }

    private void V(View view) {
        this.aXb = view.findViewById(t.g.enter_root_layout);
        this.aWZ = (NoNetworkView) view.findViewById(t.g.view_no_network);
        this.aXa = (PluginErrorTipView) view.findViewById(t.g.view_plugin_error_tip);
        this.UR = (CustomViewPager) view.findViewById(t.g.fragment_pager);
        this.aXd = (FragmentTabWidget) view.findViewById(t.g.tab_widget);
        this.aXc = (ObservedChangeLinearLayout) view.findViewById(t.g.tab_layout);
        this.aXc.setOnSizeChangeListener(new g(this));
        if (this.aXc.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.aXc.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        this.aWZ.a(new h(this));
        Mu();
    }

    private void initViewPager() {
        this.aXe = new a(this);
        this.UR.setAdapter(this.aXe);
        this.UR.setOnPageChangeListener(new i(this));
    }

    private void Mt() {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.e.ds28));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.auL = t.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(t.j.enter_forum_tab_my_bar));
        this.aXd.addView(fragmentTabIndicator);
        if (this.aWY != null) {
            FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
            fragmentTabIndicator2.setTextSize(0, getResources().getDimension(t.e.ds28));
            fragmentTabIndicator2.setGravity(17);
            fragmentTabIndicator2.auL = t.d.s_actionbar_text_color;
            if (this.aWY.aYp != 0) {
                fragmentTabIndicator2.setText(getResources().getString(this.aWY.aYp));
            } else {
                fragmentTabIndicator2.setText(getResources().getString(t.j.enter_forum_tab_togetherhi));
            }
            this.aXd.addView(fragmentTabIndicator2);
        }
        this.aXd.setTabSelectionListener(new j(this));
    }

    private void Mu() {
        initViewPager();
        Mt();
        if (this.aXf < 0) {
            this.aXf = 0;
        }
        this.aXd.f(this.aXf, true);
        this.UR.setCurrentItem(this.aXf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(int i) {
        fO(i);
        this.aXf = i;
        if (i == 0) {
            if (this.aWX != null) {
                this.aWX.MC();
                if (this.aWX.MF()) {
                    this.aWX.ME();
                }
            }
        } else if (this.aWY != null && i == this.aWY.aYo && this.aWY.aYq != null) {
            this.aWY.aYq.MC();
            if (this.aWX != null && this.aWX.MF()) {
                this.aWX.MD();
            }
        }
    }

    private void fO(int i) {
        boolean z = i == 0;
        if (this.aWX != null) {
            this.aWX.ct(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            fN(this.aXf);
            if (this.aXf == 0 && this.aWX != null) {
                refreshImage(this.aWX.getView());
            } else if (this.aWY != null && this.aXf == this.aWY.aYo && this.aWY.aYq != null) {
                refreshImage(this.aWY.aYq.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        at.l(this.aXb, t.d.cp_bg_line_d);
        if (this.aXd != null) {
            this.aXd.onChangeSkinType(i);
        }
        if (this.aWX != null) {
            this.aWX.onChangeSkinType(i);
        }
        if (this.aWY != null && this.aWY.aYq != null) {
            this.aWY.aYq.onChangeSkinType(i);
        }
        if (this.aWZ != null) {
            this.aWZ.onChangeSkinType(getPageContext(), i);
        }
        if (this.aXa != null) {
            this.aXa.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(t.h.fragment_enter_forum, viewGroup, false);
        V(inflate);
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aXg.setPriority(101);
        registerListener(this.aXg);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM_ADD_TOGETHERHI_TAB, new com.baidu.tieba.enterForum.d.a()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.aWX != null) {
            this.aWX.onDestroy();
        }
        if (this.aWY != null && this.aWY.aYq != null) {
            this.aWY.aYq.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.aWX != null) {
            this.aWX.onPause();
        }
        if (this.aWY != null && this.aWY.aYq != null) {
            this.aWY.aYq.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.aWZ != null && this.aWZ.getVisibility() == 0 && com.baidu.adp.lib.util.i.fq()) {
            this.aWZ.aE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter {
        private e aXi;

        public a(e eVar) {
            this.aXi = eVar;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return e.this.aWY == null ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = null;
            if (i == 0) {
                if (e.this.aWX == null) {
                    e.this.aWX = new k(this.aXi);
                }
                view = e.this.aWX.getView();
            } else if (e.this.aWY != null && i == e.this.aWY.aYo && e.this.aWY.aYq != null) {
                view = e.this.aWY.aYq.getView();
            }
            if (viewGroup != null && view != null) {
                viewGroup.addView(view);
                e.this.fN(e.this.aXf);
            }
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view;
            if (i == 0) {
                if (e.this.aWX != null) {
                    view = e.this.aWX.getView();
                    e.this.aWX = null;
                }
                view = null;
            } else {
                if (e.this.aWY != null && i == e.this.aWY.aYo && e.this.aWY.aYq != null) {
                    view = e.this.aWY.aYq.getView();
                    e.this.aWY = null;
                }
                view = null;
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
}
