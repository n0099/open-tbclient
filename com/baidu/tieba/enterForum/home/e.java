package com.baidu.tieba.enterForum.home;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private i aWi;
    private com.baidu.tieba.enterForum.square.b aWj;
    private NoNetworkView aWk;
    private View aWl;
    private FragmentTabWidget aWm;
    private a aWn;
    private int aWo = 0;
    private CustomViewPager aam;

    private void P(View view) {
        this.aWl = view.findViewById(t.g.enter_root_layout);
        this.aWk = (NoNetworkView) view.findViewById(t.g.view_no_network);
        this.aam = (CustomViewPager) view.findViewById(t.g.fragment_pager);
        this.aWm = (FragmentTabWidget) view.findViewById(t.g.tab_widget);
        this.aWk.a(new f(this));
        LW();
    }

    private void initViewPager() {
        this.aWn = new a(this);
        this.aam.setAdapter(this.aWn);
        this.aam.setOnPageChangeListener(new g(this));
    }

    private void LV() {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.e.ds28));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.ayd = t.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(t.j.enter_forum_tab_my_bar));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(t.e.ds28));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.ayd = t.d.s_actionbar_text_color;
        fragmentTabIndicator2.setText(getResources().getString(t.j.enter_forum_tab_recommend));
        this.aWm.addView(fragmentTabIndicator);
        this.aWm.addView(fragmentTabIndicator2);
        this.aWm.setTabSelectionListener(new h(this));
    }

    private void LW() {
        initViewPager();
        LV();
        if (this.aWo < 0) {
            this.aWo = 0;
        }
        this.aWm.d(this.aWo, true);
        this.aam.setCurrentItem(this.aWo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fQ(int i) {
        fR(i);
        this.aWo = i;
        if (i == 0) {
            if (this.aWi != null) {
                this.aWi.Me();
            }
            if (this.aWj != null) {
                this.aWj.onPause();
            }
        } else if (i == 1 && this.aWj != null) {
            this.aWj.Me();
            this.aWj.onResume();
        }
    }

    private void fR(int i) {
        boolean z = i == 0;
        if (this.aWi != null) {
            this.aWi.ca(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            fQ(this.aWo);
            if (this.aWo == 0 && this.aWi != null) {
                refreshImage(this.aWi.getView());
            } else if (this.aWo == 1 && this.aWj != null) {
                refreshImage(this.aWj.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ar.l(this.aWl, t.d.cp_bg_line_d);
        if (this.aWm != null) {
            this.aWm.onChangeSkinType(i);
        }
        if (this.aWi != null) {
            this.aWi.onChangeSkinType(i);
        }
        if (this.aWj != null) {
            this.aWj.onChangeSkinType(i);
        }
        if (this.aWk != null) {
            this.aWk.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(t.h.fragment_enter_forum, viewGroup, false);
        P(inflate);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.aWj != null) {
            this.aWj.onDestroy();
        }
        if (this.aWi != null) {
            this.aWi.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.aWj != null) {
            this.aWj.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.aWj != null) {
            this.aWj.onResume();
        }
        if (this.aWk != null && this.aWk.getVisibility() == 0 && com.baidu.adp.lib.util.i.iZ()) {
            this.aWk.ax(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter {
        private e aWq;

        public a(e eVar) {
            this.aWq = eVar;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = null;
            if (i == 0) {
                if (e.this.aWi == null) {
                    e.this.aWi = new i(this.aWq);
                }
                view = e.this.aWi.getView();
            } else if (i == 1) {
                if (e.this.aWj == null) {
                    e.this.aWj = new com.baidu.tieba.enterForum.square.b(this.aWq);
                }
                view = e.this.aWj.getView();
            }
            if (viewGroup != null && view != null) {
                viewGroup.addView(view);
                e.this.fQ(e.this.aWo);
            }
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view;
            if (i == 0) {
                if (e.this.aWi != null) {
                    view = e.this.aWi.getView();
                    e.this.aWi = null;
                }
                view = null;
            } else {
                if (i == 1 && e.this.aWj != null) {
                    view = e.this.aWj.getView();
                    e.this.aWj = null;
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
