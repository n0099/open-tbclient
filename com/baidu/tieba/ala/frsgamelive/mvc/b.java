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
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.a.g;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdUniqueId afD;
    private int afW = -1;
    private BdTypeListView eOj;
    private PbListView ePr;
    private boolean eXL;
    private View eYe;
    private PopupWindow eYj;
    private View eYk;
    private boolean fgP;
    private d fgX;
    private TextView fha;
    private TextView fhb;
    private TextView fhc;
    private TextView fhd;
    private View fhe;
    private NoNetworkView fhf;
    private TextView fhg;
    private TextView fhh;
    private TextView fhi;
    private View fhj;
    private View fhk;
    private g fhl;
    private com.baidu.tieba.frs.gametab.b fhm;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.eXL = z;
        this.fgP = z2;
        this.afD = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.eYe = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fha = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fhb = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.eOj = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.fhf = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.afD);
        this.eOj.setPullRefresh(this.mPullView);
        this.ePr = new PbListView(this.mPageContext.getPageActivity());
        this.ePr.createView();
        this.fhl = new g(this.mPageContext, this.eOj, this.eXL);
        this.fhb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.boh();
            }
        });
        if (this.fgP) {
            this.fhm = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.afD, this.fgP);
            this.eOj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.fhm.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bog() {
        am.setViewTextColor(this.fhg, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fhh, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fhi, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.fhj, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fhk, R.color.cp_bg_line_c);
    }

    public void pG(int i) {
        if (i == 1) {
            if (this.fhb != null) {
                this.fhb.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fhb != null) {
            this.fhb.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void pk(int i) {
        if (this.fha != null) {
            this.fha.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fhb.setVisibility(8);
            } else {
                this.fhb.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.afW != i) {
            this.afW = i;
        }
        bog();
        am.setViewTextColor(this.fha, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fhb, (int) R.color.cp_cont_d);
        this.fhb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boh() {
        bmw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pF(int i) {
        pG(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.eYj, this.mPageContext.getPageActivity());
        if (this.fgX != null) {
            this.fgX.pF(i);
        }
    }

    private void boi() {
        if (this.eYk == null) {
            this.eYk = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fhc = (TextView) this.eYk.findViewById(R.id.frs_game_live_hot);
            this.fhd = (TextView) this.eYk.findViewById(R.id.frs_game_live_new);
            this.fhe = this.eYk.findViewById(R.id.frs_game_live_sort_sepline);
            this.fhc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.pF(1);
                }
            });
            this.fhd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.pF(2);
                }
            });
        }
        if (this.eYj == null) {
            this.eYj = new PopupWindow(this.mPageContext.getPageActivity());
            this.eYj.setContentView(this.eYk);
            this.eYj.setWidth(-2);
            this.eYj.setHeight(-2);
            this.eYj.setAnimationStyle(16973826);
            this.eYj.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.eYj.setOutsideTouchable(true);
            this.eYj.setFocusable(true);
            this.eYj.setTouchable(true);
            this.eYj.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.boj();
                }
            });
        }
    }

    private void bmw() {
        boi();
        am.setBackgroundResource(this.eYk, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.fhc, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fhd, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fhe, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fhc, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fhd, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fhb.getLocationOnScreen(iArr);
        int height = ((View) this.fhb.getParent()).getHeight() - this.fhb.getHeight();
        if (iArr[1] - this.eYj.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.eYj, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.eYj, this.rootView, 0, (iArr[0] - (this.fhb.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fhb.getHeight());
        this.eYj.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boj() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.eOj;
    }

    public void a(d dVar) {
        this.fgX = dVar;
    }

    public void completePullRefresh() {
        this.eOj.completePullRefresh();
    }

    public void d(List<m> list, boolean z, boolean z2) {
        if (list != null && !v.isEmpty(list)) {
            if (z) {
                this.eYe.setVisibility(0);
            } else {
                this.eYe.setVisibility(8);
            }
            this.fhl.setDatas(list);
            if (z2) {
                bok();
            } else {
                bln();
            }
        }
    }

    public void bok() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.eOj.setNextPage(this.ePr);
            }
            this.ePr.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.ePr.endLoadData();
        }
    }

    public void bln() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.eOj.setNextPage(this.ePr);
            }
            this.ePr.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.ePr.endLoadData();
        }
    }

    public void blo() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.eOj.setNextPage(this.ePr);
            }
            this.ePr.showLoadingViewWithoutEmptyView();
            this.ePr.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.eOj.setOnSrollToBottomListener(eVar);
        this.ePr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (eVar != null) {
                    eVar.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        this.fhl.b(dVar);
    }
}
