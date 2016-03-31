package com.baidu.tieba.enterForum.home;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private CustomViewPager Zy;
    private i baR;
    private com.baidu.tieba.enterForum.square.b baS;
    private NoNetworkView baT;
    private View baU;
    private FragmentTabWidget baV;
    private a baW;
    private int baX = 0;

    private void T(View view) {
        this.baU = view.findViewById(t.g.enter_root_layout);
        this.baT = (NoNetworkView) view.findViewById(t.g.view_no_network);
        this.Zy = (CustomViewPager) view.findViewById(t.g.fragment_pager);
        this.baV = (FragmentTabWidget) view.findViewById(t.g.tab_widget);
        this.baT.a(new f(this));
        NK();
    }

    private void initViewPager() {
        this.baW = new a(this);
        this.Zy.setAdapter(this.baW);
        this.Zy.setOnPageChangeListener(new g(this));
    }

    private void NJ() {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.e.ds28));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.ayK = t.d.s_actionbar_text_color;
        fragmentTabIndicator.setText(getResources().getString(t.j.enter_forum_tab_my_bar));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(t.e.ds28));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.ayK = t.d.s_actionbar_text_color;
        fragmentTabIndicator2.setText(getResources().getString(t.j.enter_forum_tab_recommend));
        this.baV.addView(fragmentTabIndicator);
        this.baV.addView(fragmentTabIndicator2);
        this.baV.setTabSelectionListener(new h(this));
    }

    private void NK() {
        initViewPager();
        NJ();
        if (this.baX < 0) {
            this.baX = 0;
        }
        this.baV.d(this.baX, true);
        this.Zy.setCurrentItem(this.baX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(int i) {
        gh(i);
        this.baX = i;
        if (i == 0) {
            if (this.baR != null) {
                this.baR.NS();
            }
            if (this.baS != null) {
                this.baS.onPause();
            }
        } else if (i == 1 && this.baS != null) {
            this.baS.NS();
            this.baS.onResume();
        }
    }

    private void gh(int i) {
        boolean z = i == 0;
        if (this.baR != null) {
            this.baR.cm(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            gg(this.baX);
            if (this.baX == 0 && this.baR != null) {
                refreshImage(this.baR.getView());
            } else if (this.baX == 1 && this.baS != null) {
                refreshImage(this.baS.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        at.l(this.baU, t.d.cp_bg_line_d);
        if (this.baV != null) {
            this.baV.onChangeSkinType(i);
        }
        if (this.baR != null) {
            this.baR.onChangeSkinType(i);
        }
        if (this.baS != null) {
            this.baS.onChangeSkinType(i);
        }
        if (this.baT != null) {
            this.baT.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(t.h.fragment_enter_forum, viewGroup, false);
        T(inflate);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.baS != null) {
            this.baS.onDestroy();
        }
        if (this.baR != null) {
            this.baR.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.baS != null) {
            this.baS.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.baS != null) {
            this.baS.onResume();
        }
        if (this.baT != null && this.baT.getVisibility() == 0 && com.baidu.adp.lib.util.i.jf()) {
            this.baT.az(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter {
        private e baZ;

        public a(e eVar) {
            this.baZ = eVar;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = null;
            if (i == 0) {
                if (e.this.baR == null) {
                    e.this.baR = new i(this.baZ);
                }
                view = e.this.baR.getView();
            } else if (i == 1) {
                if (e.this.baS == null) {
                    e.this.baS = new com.baidu.tieba.enterForum.square.b(this.baZ);
                }
                view = e.this.baS.getView();
            }
            if (viewGroup != null && view != null) {
                viewGroup.addView(view);
                e.this.gg(e.this.baX);
            }
            return view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view;
            if (i == 0) {
                if (e.this.baR != null) {
                    view = e.this.baR.getView();
                    e.this.baR = null;
                }
                view = null;
            } else {
                if (i == 1 && e.this.baS != null) {
                    view = e.this.baS.getView();
                    e.this.baS = null;
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
