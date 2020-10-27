package com.baidu.tieba.ala.frsgamelive.mvc;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.a.g;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private BdUniqueId aiz;
    private int ajq = -1;
    private BdTypeListView gcr;
    private PbListView gdy;
    private PopupWindow gmE;
    private View gmF;
    private boolean gmg;
    private View gmz;
    private boolean gxa;
    private d gxi;
    private TextView gxl;
    private TextView gxm;
    private TextView gxn;
    private TextView gxo;
    private View gxp;
    private NoNetworkView gxq;
    private TextView gxr;
    private TextView gxs;
    private TextView gxt;
    private View gxu;
    private View gxv;
    private g gxw;
    private com.baidu.tieba.frs.gametab.b gxx;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.gmg = z;
        this.gxa = z2;
        this.aiz = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.gmz = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gxl = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gxm = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gcr = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.gxq = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.aiz);
        this.gcr.setPullRefresh(this.mPullView);
        this.gdy = new PbListView(this.mPageContext.getPageActivity());
        this.gdy.createView();
        this.gxw = new g(this.mPageContext, this.gcr, this.gmg);
        this.gxm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bQj();
            }
        });
        if (this.gxa) {
            this.gxx = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.aiz, this.gxa);
            this.gcr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.gxx.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bQi() {
        ap.setViewTextColor(this.gxr, R.color.cp_cont_d);
        ap.setViewTextColor(this.gxs, R.color.cp_cont_d);
        ap.setViewTextColor(this.gxt, R.color.cp_cont_d);
        ap.setBackgroundResource(this.gxu, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.gxv, R.color.cp_bg_line_c);
    }

    public void ut(int i) {
        if (i == 1) {
            if (this.gxm != null) {
                this.gxm.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gxm != null) {
            this.gxm.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void tW(int i) {
        if (this.gxl != null) {
            this.gxl.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gxm.setVisibility(8);
            } else {
                this.gxm.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajq != i) {
            this.ajq = i;
        }
        bQi();
        ap.setViewTextColor(this.gxl, R.color.cp_cont_d);
        ap.setViewTextColor(this.gxm, R.color.cp_cont_d);
        this.gxm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQj() {
        bNE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void us(int i) {
        ut(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gmE, this.mPageContext.getPageActivity());
        if (this.gxi != null) {
            this.gxi.us(i);
        }
    }

    private void bQk() {
        if (this.gmF == null) {
            this.gmF = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gxn = (TextView) this.gmF.findViewById(R.id.frs_game_live_hot);
            this.gxo = (TextView) this.gmF.findViewById(R.id.frs_game_live_new);
            this.gxp = this.gmF.findViewById(R.id.frs_game_live_sort_sepline);
            this.gxn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.us(1);
                }
            });
            this.gxo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.us(2);
                }
            });
        }
        if (this.gmE == null) {
            this.gmE = new PopupWindow(this.mPageContext.getPageActivity());
            this.gmE.setContentView(this.gmF);
            this.gmE.setWidth(-2);
            this.gmE.setHeight(-2);
            this.gmE.setAnimationStyle(16973826);
            this.gmE.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gmE.setOutsideTouchable(true);
            this.gmE.setFocusable(true);
            this.gmE.setTouchable(true);
            this.gmE.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bQl();
                }
            });
        }
    }

    private void bNE() {
        bQk();
        ap.setBackgroundResource(this.gmF, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gxn, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gxo, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gxp, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.gxn, R.color.cp_cont_f);
        ap.setViewTextColor(this.gxo, R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.gxm.getLocationOnScreen(iArr);
        int height = ((View) this.gxm.getParent()).getHeight() - this.gxm.getHeight();
        if (iArr[1] - this.gmE.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gmE, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gmE, this.rootView, 0, (iArr[0] - (this.gxm.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gxm.getHeight());
        this.gmE.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQl() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.gcr;
    }

    public void a(d dVar) {
        this.gxi = dVar;
    }

    public void completePullRefresh() {
        this.gcr.completePullRefresh();
    }

    public void c(List<q> list, boolean z, boolean z2) {
        if (list != null && !y.isEmpty(list)) {
            if (z) {
                this.gmz.setVisibility(0);
            } else {
                this.gmz.setVisibility(8);
            }
            this.gxw.setDatas(list);
            if (z2) {
                bQm();
            } else {
                bMw();
            }
        }
    }

    public void bQm() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.gcr.setNextPage(this.gdy);
            }
            this.gdy.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gdy.endLoadData();
        }
    }

    public void bMw() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.gcr.setNextPage(this.gdy);
            }
            this.gdy.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gdy.endLoadData();
        }
    }

    public void bMx() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.gcr.setNextPage(this.gdy);
            }
            this.gdy.showLoadingViewWithoutEmptyView();
            this.gdy.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.gcr.setOnSrollToBottomListener(eVar);
        this.gdy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (eVar != null) {
                    eVar.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        this.gxw.b(fVar);
    }
}
