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
    private final RelativeLayout KO;
    private y Yc;
    private final com.baidu.tbadk.core.view.o ahO;
    private final NoNetworkView aty;
    private boolean auf;
    private final BaseFragmentActivity axV;
    private g ayh;
    private n ayi;
    private Button ayj;
    private LinearLayout ayk;
    private LinearLayout ayl;
    private Handler mHandler;
    private NavigationBar mNavigationBar;
    private final View mRoot;
    private BdListView vl;

    public j(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment) {
        super(baseFragmentActivity);
        this.auf = false;
        this.axV = baseFragmentActivity;
        this.mRoot = baseFragment.getView();
        this.KO = (RelativeLayout) this.mRoot.findViewById(v.content);
        this.aty = (NoNetworkView) this.mRoot.findViewById(v.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.axV.getString(com.baidu.tieba.y.ba_dongtai));
        this.ayl = (LinearLayout) this.mRoot.findViewById(v.content_with_data);
        this.ayk = (LinearLayout) this.mRoot.findViewById(v.no_data_layout);
        this.ayj = (Button) this.mRoot.findViewById(v.go_find_bar);
        this.ayj.setOnClickListener(new k(this));
        this.ahO = NoDataViewFactory.a(this.axV, this.ayk, r.a(NoDataViewFactory.ImgType.FINDBAR), s.q(com.baidu.tieba.y.forum_feed_nodata_tip1, com.baidu.tieba.y.forum_feed_nodata_tip2), null);
        Et();
        eC(TbadkApplication.m251getInst().getSkinType());
    }

    public void Em() {
        if (this.ayh == null) {
            Er();
            Es();
        }
        this.vl.hO();
    }

    public void e(u uVar) {
        this.aty.a(uVar);
    }

    public void En() {
        this.auf = false;
        Eq();
        if (this.ayh == null) {
            Er();
        }
        if (this.vl != null) {
            this.vl.setBackgroundColor(0);
        }
        this.ahO.setVisibility(0);
        this.ayj.setVisibility(0);
        this.ayh.a(null);
        this.ayh.notifyDataSetChanged();
        if (this.ayi != null) {
            this.ayi.hide();
        }
    }

    public void Eo() {
        if (this.vl != null) {
            this.vl.setSelection(0);
        }
    }

    public void b(com.baidu.adp.widget.ListView.f fVar) {
        this.Yc.a(fVar);
    }

    public void a(aa aaVar) {
        this.vl.setOnSrollToBottomListener(aaVar);
    }

    public void DG() {
        this.ayi.DG();
        this.vl.hN();
    }

    public void DF() {
        this.ayi.DF();
    }

    public void Ep() {
        this.ayi.Ep();
    }

    public void h(View.OnClickListener onClickListener) {
        this.ayi.setOnClickListener(onClickListener);
    }

    public void b(p pVar) {
        if (pVar != null) {
            if (this.ayh == null) {
                Er();
                Es();
            }
            if (pVar.yU() == 1) {
                this.ayh.setFromCDN(true);
            } else {
                this.ayh.setFromCDN(false);
            }
            this.ahO.setVisibility(8);
            this.ayj.setVisibility(8);
            this.auf = true;
            this.ayh.a(pVar);
            this.ayh.notifyDataSetChanged();
            if (this.ayi != null) {
                this.ayi.Ba();
            }
            DG();
            if (this.ayh.getCount() > 0) {
                this.ayi.Ev();
            }
        }
    }

    public void eC(int i) {
        aw.h(this.KO, com.baidu.tieba.s.forumfeed_frs_bg);
        this.axV.getLayoutMode().L(i == 1);
        this.axV.getLayoutMode().h(this.KO);
        this.vl.setBackgroundColor(0);
        if (this.ayh != null) {
            this.ayh.notifyDataSetChanged();
        }
        if (this.Yc != null) {
            this.Yc.bM(i);
        }
        if (this.ayi != null) {
            this.ayi.cu(i);
        }
        if (this.aty != null) {
            this.aty.onChangeSkinType(i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(i);
        }
        if (!this.auf) {
            Eq();
        }
    }

    private void Eq() {
        if (this.vl == null) {
        }
    }

    private void Er() {
        this.ayh = new g(this.axV);
        this.vl.setAdapter((ListAdapter) this.ayh);
    }

    private void Es() {
        this.mHandler = new Handler();
        this.vl.setOnScrollListener(new l(this));
    }

    private void Et() {
        this.Yc = new y(this.axV);
        this.vl = (BdListView) this.mRoot.findViewById(v.forum_feed_list);
        this.vl.setPullRefresh(this.Yc);
        this.ayi = new n(this, this.axV);
        this.vl.setNextPage(this.ayi);
        this.vl.setRecyclerListener(new m(this));
    }

    public BdListView ud() {
        return this.vl;
    }

    public int Eu() {
        return v.user_icon_box;
    }
}
