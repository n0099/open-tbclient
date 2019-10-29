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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.a.g;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private BdUniqueId Hx;
    private int csX = -1;
    private boolean dDV;
    private View dEo;
    private PopupWindow dEt;
    private View dEu;
    private boolean dIR;
    private d dIY;
    private TextView dJb;
    private TextView dJc;
    private TextView dJd;
    private TextView dJe;
    private View dJf;
    private NoNetworkView dJg;
    private TextView dJh;
    private TextView dJi;
    private TextView dJj;
    private View dJk;
    private View dJl;
    private g dJm;
    private com.baidu.tieba.frs.gametab.b dJn;
    private BdTypeListView dvB;
    private PbListView dwJ;
    private TbPageContext mPageContext;
    private i mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.dDV = z;
        this.dIR = z2;
        this.Hx = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.dEo = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.dJb = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.dJc = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.dvB = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.dJg = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.Hx);
        this.dvB.setPullRefresh(this.mPullView);
        this.dwJ = new PbListView(this.mPageContext.getPageActivity());
        this.dwJ.createView();
        this.dJm = new g(this.mPageContext, this.dvB, this.dDV);
        this.dJc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aKT();
            }
        });
        if (this.dIR) {
            this.dJn = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.Hx, this.dIR);
            this.dvB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.dJn.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void aKS() {
        am.setViewTextColor(this.dJh, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dJi, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dJj, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.dJk, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dJl, R.color.cp_bg_line_c);
    }

    public void mD(int i) {
        if (i == 1) {
            if (this.dJc != null) {
                this.dJc.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.dJc != null) {
            this.dJc.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void mp(int i) {
        if (this.dJb != null) {
            this.dJb.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.dJc.setVisibility(8);
            } else {
                this.dJc.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.csX != i) {
            this.csX = i;
        }
        aKS();
        am.setViewTextColor(this.dJb, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dJc, (int) R.color.cp_cont_d);
        this.dJc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKT() {
        aKs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mC(int i) {
        mD(i);
        com.baidu.adp.lib.g.g.dismissPopupWindow(this.dEt, this.mPageContext.getPageActivity());
        if (this.dIY != null) {
            this.dIY.mC(i);
        }
    }

    private void aKU() {
        if (this.dEu == null) {
            this.dEu = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.dJd = (TextView) this.dEu.findViewById(R.id.frs_game_live_hot);
            this.dJe = (TextView) this.dEu.findViewById(R.id.frs_game_live_new);
            this.dJf = this.dEu.findViewById(R.id.frs_game_live_sort_sepline);
            this.dJd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.mC(1);
                }
            });
            this.dJe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.mC(2);
                }
            });
        }
        if (this.dEt == null) {
            this.dEt = new PopupWindow(this.mPageContext.getPageActivity());
            this.dEt.setContentView(this.dEu);
            this.dEt.setWidth(-2);
            this.dEt.setHeight(-2);
            this.dEt.setAnimationStyle(16973826);
            this.dEt.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.dEt.setOutsideTouchable(true);
            this.dEt.setFocusable(true);
            this.dEt.setTouchable(true);
            this.dEt.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.aKV();
                }
            });
        }
    }

    private void aKs() {
        aKU();
        am.setBackgroundResource(this.dEu, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.dJd, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.dJe, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.dJf, R.color.cp_bg_line_c);
        am.setViewTextColor(this.dJd, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dJe, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.dJc.getLocationOnScreen(iArr);
        int height = ((View) this.dJc.getParent()).getHeight() - this.dJc.getHeight();
        if (iArr[1] - this.dEt.getHeight() <= 50) {
            com.baidu.adp.lib.g.g.dismissPopupWindow(this.dEt, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dEt, this.rootView, 0, (iArr[0] - (this.dJc.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.dJc.getHeight());
        this.dEt.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKV() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.dvB;
    }

    public void a(d dVar) {
        this.dIY = dVar;
    }

    public void completePullRefresh() {
        this.dvB.completePullRefresh();
    }

    public void d(List<m> list, boolean z, boolean z2) {
        if (list != null && !v.isEmpty(list)) {
            if (z) {
                this.dEo.setVisibility(0);
            } else {
                this.dEo.setVisibility(8);
            }
            this.dJm.setDatas(list);
            if (z2) {
                aKW();
            } else {
                aJk();
            }
        }
    }

    public void aKW() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.dvB.setNextPage(this.dwJ);
            }
            this.dwJ.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.dwJ.endLoadData();
        }
    }

    public void aJk() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.dvB.setNextPage(this.dwJ);
            }
            this.dwJ.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.dwJ.endLoadData();
        }
    }

    public void aJl() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.dvB.setNextPage(this.dwJ);
            }
            this.dwJ.showLoadingViewWithoutEmptyView();
            this.dwJ.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.dvB.setOnSrollToBottomListener(eVar);
        this.dwJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (eVar != null) {
                    eVar.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        this.dJm.b(dVar);
    }
}
