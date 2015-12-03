package com.baidu.tieba.enterForum.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private h aQj;
    private com.baidu.tieba.enterForum.square.b aQk;
    private NoNetworkView aQl;
    private View aQm;
    private FragmentTabWidget aQn;
    private FrameLayout aQo;
    private FrameLayout aQp;
    private int aQq = 0;
    private int aQr = this.aQq;

    private void B(View view) {
        this.aQm = view.findViewById(n.f.enter_root_layout);
        this.aQl = (NoNetworkView) view.findViewById(n.f.view_no_network);
        this.aQn = (FragmentTabWidget) view.findViewById(n.f.tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(n.d.ds28));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.avG = n.c.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(n.i.enter_forum_tab_my_bar));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(n.d.ds28));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.avG = n.c.s_actionbar_text_color;
        fragmentTabIndicator2.setText(getResources().getString(n.i.enter_forum_tab_recommend));
        this.aQn.addView(fragmentTabIndicator);
        this.aQn.addView(fragmentTabIndicator2);
        this.aQn.d(this.aQq, true);
        this.aQn.setTabSelectionListener(new f(this));
        this.aQl.a(new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw(int i) {
        fx(i);
        if (i == 0) {
            if (this.aQj == null) {
                this.aQj = new h(this);
                this.aQo.addView(this.aQj.getView());
            }
            this.aQj.JU();
            this.aQp.setVisibility(8);
            this.aQo.setVisibility(0);
            if (this.aQk != null) {
                this.aQk.onPause();
            }
        } else if (i == 1) {
            TiebaStatic.log("c10584");
            if (this.aQk == null) {
                this.aQk = new com.baidu.tieba.enterForum.square.b(this);
                this.aQp.addView(this.aQk.getView());
                this.aQk.JU();
            }
            this.aQo.setVisibility(8);
            this.aQp.setVisibility(0);
            this.aQk.onResume();
        }
        this.aQr = i;
    }

    private void fx(int i) {
        boolean z = i == 0;
        if (this.aQj != null) {
            this.aQj.cb(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            fw(this.aQr);
        }
        fx(this.aQr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        as.j(this.aQm, n.c.cp_bg_line_d);
        if (this.aQn != null) {
            this.aQn.onChangeSkinType(i);
        }
        if (this.aQj != null) {
            this.aQj.onChangeSkinType(i);
        }
        if (this.aQk != null) {
            this.aQk.onChangeSkinType(i);
        }
        if (this.aQl != null) {
            this.aQl.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.g.fragment_enter_forum, viewGroup, false);
        this.aQo = (FrameLayout) inflate.findViewById(n.f.frame_container);
        this.aQp = (FrameLayout) inflate.findViewById(n.f.frame_container_2);
        B(inflate);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.aQk != null) {
            this.aQk.onDestroy();
        }
        if (this.aQj != null) {
            this.aQj.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.aQk != null) {
            this.aQk.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.aQk != null) {
            this.aQk.onResume();
        }
        if (this.aQl != null && this.aQl.getVisibility() == 0 && com.baidu.adp.lib.util.i.iP()) {
            this.aQl.az(false);
        }
    }
}
