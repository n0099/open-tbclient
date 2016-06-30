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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private CustomViewPager Vh;
    private NoNetworkView bkT;
    private k bsU;
    private com.baidu.tieba.enterForum.d.c bsV;
    private PluginErrorTipView bsW;
    private View bsX;
    private ObservedChangeLinearLayout bsY;
    private FragmentTabWidget bsZ;
    private a bta;
    private int btb = 0;
    final CustomMessageListener btc = new f(this, CmdConfigCustom.CMD_ENTER_FORUM_ADD_TOGETHERHI_TAB);

    public ObservedChangeLinearLayout RX() {
        return this.bsY;
    }

    public FragmentTabWidget RY() {
        return this.bsZ;
    }

    private void X(View view) {
        this.bsX = view.findViewById(u.g.enter_root_layout);
        this.bkT = (NoNetworkView) view.findViewById(u.g.view_no_network);
        this.bsW = (PluginErrorTipView) view.findViewById(u.g.view_plugin_error_tip);
        this.Vh = (CustomViewPager) view.findViewById(u.g.fragment_pager);
        this.bsZ = (FragmentTabWidget) view.findViewById(u.g.tab_widget);
        this.bsY = (ObservedChangeLinearLayout) view.findViewById(u.g.tab_layout);
        this.bsY.setOnSizeChangeListener(new g(this));
        if (this.bsY.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.bsY.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), u.e.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        this.bkT.a(new h(this));
        Sa();
    }

    private void initViewPager() {
        this.bta = new a(this);
        this.Vh.setAdapter(this.bta);
        this.Vh.setOnPageChangeListener(new i(this));
    }

    private void RZ() {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(u.e.ds28));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.avB = u.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(u.j.enter_forum_tab_my_bar));
        this.bsZ.addView(fragmentTabIndicator);
        if (this.bsV != null) {
            FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
            fragmentTabIndicator2.setTextSize(0, getResources().getDimension(u.e.ds28));
            fragmentTabIndicator2.setGravity(17);
            fragmentTabIndicator2.avB = u.d.s_actionbar_text_color;
            if (this.bsV.buh != 0) {
                fragmentTabIndicator2.setText(getResources().getString(this.bsV.buh));
            } else {
                fragmentTabIndicator2.setText(getResources().getString(u.j.enter_forum_tab_togetherhi));
            }
            this.bsZ.addView(fragmentTabIndicator2);
        }
        this.bsZ.setTabSelectionListener(new j(this));
    }

    private void Sa() {
        initViewPager();
        RZ();
        if (this.btb < 0) {
            this.btb = 0;
        }
        this.bsZ.f(this.btb, true);
        this.Vh.setCurrentItem(this.btb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gM(int i) {
        gN(i);
        this.btb = i;
        if (i == 0) {
            if (this.bsU != null) {
                this.bsU.MJ();
                if (this.bsU.Sj()) {
                    this.bsU.Si();
                }
            }
        } else if (this.bsV != null && i == this.bsV.bug && this.bsV.bui != null) {
            this.bsV.bui.MJ();
            if (this.bsU != null && this.bsU.Sj()) {
                this.bsU.Sh();
            }
        }
    }

    private void gN(int i) {
        boolean z = i == 0;
        if (this.bsU != null) {
            this.bsU.cO(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            gM(this.btb);
            if (this.btb == 0 && this.bsU != null) {
                refreshImage(this.bsU.getView());
            } else if (this.bsV != null && this.btb == this.bsV.bug && this.bsV.bui != null) {
                refreshImage(this.bsV.bui.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.l(this.bsX, u.d.cp_bg_line_d);
        if (this.bsZ != null) {
            this.bsZ.onChangeSkinType(i);
        }
        if (this.bsU != null) {
            this.bsU.onChangeSkinType(i);
        }
        if (this.bsV != null && this.bsV.bui != null) {
            this.bsV.bui.onChangeSkinType(i);
        }
        if (this.bkT != null) {
            this.bkT.onChangeSkinType(getPageContext(), i);
        }
        if (this.bsW != null) {
            this.bsW.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(u.h.fragment_enter_forum, viewGroup, false);
        X(inflate);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.btc.setPriority(101);
        registerListener(this.btc);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM_ADD_TOGETHERHI_TAB, new com.baidu.tieba.enterForum.d.a()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bsU != null) {
            this.bsU.onDestroy();
        }
        if (this.bsV != null && this.bsV.bui != null) {
            this.bsV.bui.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bsU != null) {
            this.bsU.onPause();
        }
        if (this.bsV != null && this.bsV.bui != null) {
            this.bsV.bui.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bkT != null && this.bkT.getVisibility() == 0 && com.baidu.adp.lib.util.i.fr()) {
            this.bkT.aC(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter {
        private e bte;

        public a(e eVar) {
            this.bte = eVar;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return e.this.bsV == null ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = null;
            if (i == 0) {
                if (e.this.bsU == null) {
                    e.this.bsU = new k(this.bte);
                }
                view = e.this.bsU.getView();
            } else if (e.this.bsV != null && i == e.this.bsV.bug && e.this.bsV.bui != null) {
                view = e.this.bsV.bui.getView();
            }
            if (viewGroup != null && view != null) {
                viewGroup.addView(view);
                e.this.gM(e.this.btb);
            }
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view;
            if (i == 0) {
                if (e.this.bsU != null) {
                    view = e.this.bsU.getView();
                    e.this.bsU = null;
                }
                view = null;
            } else {
                if (e.this.bsV != null && i == e.this.bsV.bug && e.this.bsV.bui != null) {
                    view = e.this.bsV.bui.getView();
                    e.this.bsV = null;
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
