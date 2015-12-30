package com.baidu.tieba.enterForum.home;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private CustomViewPager ZP;
    private i aUb;
    private com.baidu.tieba.enterForum.square.b aUc;
    private NoNetworkView aUd;
    private View aUe;
    private FragmentTabWidget aUf;
    private a aUg;
    private int aUh = 0;

    private void C(View view) {
        this.aUe = view.findViewById(n.g.enter_root_layout);
        this.aUd = (NoNetworkView) view.findViewById(n.g.view_no_network);
        this.ZP = (CustomViewPager) view.findViewById(n.g.fragment_pager);
        this.aUf = (FragmentTabWidget) view.findViewById(n.g.tab_widget);
        this.aUd.a(new f(this));
        Ke();
    }

    private void initViewPager() {
        this.aUg = new a(this);
        this.ZP.setAdapter(this.aUg);
        this.ZP.setOnPageChangeListener(new g(this));
    }

    private void Kd() {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(n.e.ds28));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.axk = n.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(n.j.enter_forum_tab_my_bar));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(n.e.ds28));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.axk = n.d.s_actionbar_text_color;
        fragmentTabIndicator2.setText(getResources().getString(n.j.enter_forum_tab_recommend));
        this.aUf.addView(fragmentTabIndicator);
        this.aUf.addView(fragmentTabIndicator2);
        this.aUf.setTabSelectionListener(new h(this));
    }

    private void Ke() {
        initViewPager();
        Kd();
        if (this.aUh < 0) {
            this.aUh = 0;
        }
        this.aUf.d(this.aUh, true);
        this.ZP.setCurrentItem(this.aUh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fr(int i) {
        fs(i);
        this.aUh = i;
        if (i == 0) {
            if (this.aUb != null) {
                this.aUb.Kn();
            }
            if (this.aUc != null) {
                this.aUc.onPause();
            }
        } else if (i == 1 && this.aUc != null) {
            this.aUc.Kn();
            this.aUc.onResume();
        }
    }

    private void fs(int i) {
        boolean z = i == 0;
        if (this.aUb != null) {
            this.aUb.cc(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            fr(this.aUh);
            if (this.aUh == 0 && this.aUb != null) {
                refreshImage(this.aUb.getView());
            } else if (this.aUh == 1 && this.aUc != null) {
                refreshImage(this.aUc.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        as.j(this.aUe, n.d.cp_bg_line_d);
        if (this.aUf != null) {
            this.aUf.onChangeSkinType(i);
        }
        if (this.aUb != null) {
            this.aUb.onChangeSkinType(i);
        }
        if (this.aUc != null) {
            this.aUc.onChangeSkinType(i);
        }
        if (this.aUd != null) {
            this.aUd.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.h.fragment_enter_forum, viewGroup, false);
        C(inflate);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.aUc != null) {
            this.aUc.onDestroy();
        }
        if (this.aUb != null) {
            this.aUb.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.aUc != null) {
            this.aUc.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.aUc != null) {
            this.aUc.onResume();
        }
        if (this.aUd != null && this.aUd.getVisibility() == 0 && com.baidu.adp.lib.util.i.iQ()) {
            this.aUd.aw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter {
        private e aUj;

        public a(e eVar) {
            this.aUj = eVar;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = null;
            if (i == 0) {
                if (e.this.aUb == null) {
                    e.this.aUb = new i(this.aUj);
                }
                view = e.this.aUb.getView();
            } else if (i == 1) {
                if (e.this.aUc == null) {
                    e.this.aUc = new com.baidu.tieba.enterForum.square.b(this.aUj);
                }
                view = e.this.aUc.getView();
            }
            if (viewGroup != null && view != null) {
                viewGroup.addView(view);
                e.this.fr(e.this.aUh);
            }
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view;
            if (i == 0) {
                if (e.this.aUb != null) {
                    view = e.this.aUb.getView();
                    e.this.aUb = null;
                }
                view = null;
            } else {
                if (i == 1 && e.this.aUc != null) {
                    view = e.this.aUc.getView();
                    e.this.aUc = null;
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
