package com.baidu.tieba.forumfeed;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.core.view.u;
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.data.p;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.f {
    private final RelativeLayout KP;
    private y Yg;
    private final com.baidu.tbadk.core.view.o ahX;
    private final NoNetworkView atH;
    private boolean auo;
    private final BaseFragmentActivity aye;
    private g ayq;
    private n ayr;
    private Button ays;
    private LinearLayout ayt;
    private LinearLayout ayu;
    private Handler mHandler;
    private NavigationBar mNavigationBar;
    private final View mRoot;
    private BdListView vl;

    public j(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment) {
        super(baseFragmentActivity);
        this.auo = false;
        this.aye = baseFragmentActivity;
        this.mRoot = baseFragment.getView();
        this.KP = (RelativeLayout) this.mRoot.findViewById(v.content);
        this.atH = (NoNetworkView) this.mRoot.findViewById(v.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.aye.getString(com.baidu.tieba.y.ba_dongtai));
        this.ayu = (LinearLayout) this.mRoot.findViewById(v.content_with_data);
        this.ayt = (LinearLayout) this.mRoot.findViewById(v.no_data_layout);
        this.ays = (Button) this.mRoot.findViewById(v.go_find_bar);
        this.ays.setOnClickListener(new k(this));
        this.ahX = NoDataViewFactory.a(this.aye, this.ayt, r.a(NoDataViewFactory.ImgType.FINDBAR), s.q(com.baidu.tieba.y.forum_feed_nodata_tip1, com.baidu.tieba.y.forum_feed_nodata_tip2), null);
        Ev();
        eC(TbadkApplication.m251getInst().getSkinType());
    }

    public void Eo() {
        if (this.ayq == null) {
            Et();
            Eu();
        }
        this.vl.hO();
    }

    public void e(u uVar) {
        this.atH.a(uVar);
    }

    public void Ep() {
        this.auo = false;
        Es();
        if (this.ayq == null) {
            Et();
        }
        if (this.vl != null) {
            this.vl.setBackgroundColor(0);
        }
        this.ahX.setVisibility(0);
        this.ays.setVisibility(0);
        this.ayq.a(null);
        this.ayq.notifyDataSetChanged();
        if (this.ayr != null) {
            this.ayr.hide();
        }
    }

    public void Eq() {
        if (this.vl != null) {
            this.vl.setSelection(0);
        }
    }

    public void b(com.baidu.adp.widget.ListView.f fVar) {
        this.Yg.a(fVar);
    }

    public void a(aa aaVar) {
        this.vl.setOnSrollToBottomListener(aaVar);
    }

    public void DI() {
        this.ayr.DI();
        this.vl.hN();
    }

    public void DH() {
        this.ayr.DH();
    }

    public void Er() {
        this.ayr.Er();
    }

    public void h(View.OnClickListener onClickListener) {
        this.ayr.setOnClickListener(onClickListener);
    }

    public void b(p pVar) {
        if (pVar != null) {
            if (this.ayq == null) {
                Et();
                Eu();
            }
            if (pVar.yW() == 1) {
                this.ayq.setFromCDN(true);
            } else {
                this.ayq.setFromCDN(false);
            }
            this.ahX.setVisibility(8);
            this.ays.setVisibility(8);
            this.auo = true;
            this.ayq.a(pVar);
            this.ayq.notifyDataSetChanged();
            if (this.ayr != null) {
                this.ayr.Bc();
            }
            DI();
            if (this.ayq.getCount() > 0) {
                this.ayr.Ex();
            }
        }
    }

    public void eC(int i) {
        aw.h(this.KP, com.baidu.tieba.s.forumfeed_frs_bg);
        this.aye.getLayoutMode().L(i == 1);
        this.aye.getLayoutMode().h(this.KP);
        this.vl.setBackgroundColor(0);
        if (this.ayq != null) {
            this.ayq.notifyDataSetChanged();
        }
        if (this.Yg != null) {
            this.Yg.bM(i);
        }
        if (this.ayr != null) {
            this.ayr.cu(i);
        }
        if (this.atH != null) {
            this.atH.onChangeSkinType(i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(i);
        }
        if (!this.auo) {
            Es();
        }
    }

    private void Es() {
        if (this.vl == null) {
        }
    }

    private void Et() {
        this.ayq = new g(this.aye);
        this.vl.setAdapter((ListAdapter) this.ayq);
    }

    private void Eu() {
        this.mHandler = new Handler();
        this.vl.setOnScrollListener(new l(this));
    }

    private void Ev() {
        this.Yg = new y(this.aye);
        this.vl = (BdListView) this.mRoot.findViewById(v.forum_feed_list);
        this.vl.setPullRefresh(this.Yg);
        this.ayr = new n(this, this.aye);
        this.vl.setNextPage(this.ayr);
        this.vl.setRecyclerListener(new m(this));
    }

    public BdListView uf() {
        return this.vl;
    }

    public int Ew() {
        return v.user_icon_box;
    }
}
