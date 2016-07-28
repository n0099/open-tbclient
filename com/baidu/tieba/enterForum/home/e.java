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
    private CustomViewPager VQ;
    private NoNetworkView bmB;
    private k bvj;
    private com.baidu.tieba.enterForum.d.c bvk;
    private PluginErrorTipView bvl;
    private View bvm;
    private ObservedChangeLinearLayout bvn;
    private FragmentTabWidget bvo;
    private a bvp;
    private int bvq = 0;
    final CustomMessageListener bvr = new f(this, CmdConfigCustom.CMD_ENTER_FORUM_ADD_TOGETHERHI_TAB);

    public ObservedChangeLinearLayout SF() {
        return this.bvn;
    }

    public FragmentTabWidget SG() {
        return this.bvo;
    }

    private void X(View view) {
        this.bvm = view.findViewById(u.g.enter_root_layout);
        this.bmB = (NoNetworkView) view.findViewById(u.g.view_no_network);
        this.bvl = (PluginErrorTipView) view.findViewById(u.g.view_plugin_error_tip);
        this.VQ = (CustomViewPager) view.findViewById(u.g.fragment_pager);
        this.bvo = (FragmentTabWidget) view.findViewById(u.g.tab_widget);
        this.bvn = (ObservedChangeLinearLayout) view.findViewById(u.g.tab_layout);
        this.bvn.setOnSizeChangeListener(new g(this));
        if (this.bvn.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.bvn.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), u.e.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        this.bmB.a(new h(this));
        SI();
    }

    private void initViewPager() {
        this.bvp = new a(this);
        if (this.VQ != null) {
            this.VQ.setAdapter(this.bvp);
            this.VQ.setOnPageChangeListener(new i(this));
        }
    }

    private void SH() {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(u.e.ds28));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.awq = u.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(u.j.enter_forum_tab_my_bar));
        this.bvo.addView(fragmentTabIndicator);
        if (this.bvk != null) {
            FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
            fragmentTabIndicator2.setTextSize(0, getResources().getDimension(u.e.ds28));
            fragmentTabIndicator2.setGravity(17);
            fragmentTabIndicator2.awq = u.d.s_actionbar_text_color;
            if (this.bvk.bwv != 0) {
                fragmentTabIndicator2.setText(getResources().getString(this.bvk.bwv));
            } else {
                fragmentTabIndicator2.setText(getResources().getString(u.j.enter_forum_tab_togetherhi));
            }
            this.bvo.addView(fragmentTabIndicator2);
        }
        this.bvo.setTabSelectionListener(new j(this));
    }

    private void SI() {
        initViewPager();
        SH();
        if (this.bvq < 0) {
            this.bvq = 0;
        }
        this.bvo.g(this.bvq, true);
        this.VQ.setCurrentItem(this.bvq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gM(int i) {
        gN(i);
        this.bvq = i;
        if (i == 0) {
            if (this.bvj != null) {
                this.bvj.MI();
                if (this.bvj.SR()) {
                    this.bvj.SQ();
                }
            }
        } else if (this.bvk != null && i == this.bvk.bwu && this.bvk.bww != null) {
            this.bvk.bww.MI();
            if (this.bvj != null && this.bvj.SR()) {
                this.bvj.SP();
            }
        }
    }

    private void gN(int i) {
        boolean z = i == 0;
        if (this.bvj != null) {
            this.bvj.cR(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            gM(this.bvq);
            if (this.bvq == 0 && this.bvj != null) {
                refreshImage(this.bvj.getView());
            } else if (this.bvk != null && this.bvq == this.bvk.bwu && this.bvk.bww != null) {
                refreshImage(this.bvk.bww.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.l(this.bvm, u.d.cp_bg_line_d);
        if (this.bvo != null) {
            this.bvo.onChangeSkinType(i);
        }
        if (this.bvj != null) {
            this.bvj.onChangeSkinType(i);
        }
        if (this.bvk != null && this.bvk.bww != null) {
            this.bvk.bww.onChangeSkinType(i);
        }
        if (this.bmB != null) {
            this.bmB.onChangeSkinType(getPageContext(), i);
        }
        if (this.bvl != null) {
            this.bvl.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(u.h.fragment_enter_forum, viewGroup, false);
        X(inflate);
        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bvr.setPriority(101);
        registerListener(this.bvr);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM_ADD_TOGETHERHI_TAB, new com.baidu.tieba.enterForum.d.a()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bvj != null) {
            this.bvj.onDestroy();
        }
        if (this.bvk != null && this.bvk.bww != null) {
            this.bvk.bww.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bvj != null) {
            this.bvj.onPause();
        }
        if (this.bvk != null && this.bvk.bww != null) {
            this.bvk.bww.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bmB != null && this.bmB.getVisibility() == 0 && com.baidu.adp.lib.util.i.fq()) {
            this.bmB.aF(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter {
        private e bvt;

        public a(e eVar) {
            this.bvt = eVar;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return e.this.bvk == null ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = null;
            if (i == 0) {
                if (e.this.bvj == null) {
                    e.this.bvj = new k(this.bvt);
                }
                view = e.this.bvj.getView();
            } else if (e.this.bvk != null && i == e.this.bvk.bwu && e.this.bvk.bww != null) {
                view = e.this.bvk.bww.getView();
            }
            if (viewGroup != null && view != null) {
                viewGroup.addView(view);
                e.this.gM(e.this.bvq);
            }
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view;
            if (i == 0) {
                if (e.this.bvj != null) {
                    view = e.this.bvj.getView();
                    e.this.bvj = null;
                }
                view = null;
            } else {
                if (e.this.bvk != null && i == e.this.bvk.bwu && e.this.bvk.bww != null) {
                    view = e.this.bvk.bww.getView();
                    e.this.bvk = null;
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
