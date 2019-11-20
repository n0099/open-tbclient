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
    private BdUniqueId GX;
    private int csg = -1;
    private PopupWindow dDC;
    private View dDD;
    private boolean dDe;
    private View dDx;
    private boolean dIa;
    private d dIh;
    private TextView dIk;
    private TextView dIl;
    private TextView dIm;
    private TextView dIn;
    private View dIo;
    private NoNetworkView dIp;
    private TextView dIq;
    private TextView dIr;
    private TextView dIs;
    private View dIt;
    private View dIu;
    private g dIv;
    private com.baidu.tieba.frs.gametab.b dIw;
    private BdTypeListView duK;
    private PbListView dvS;
    private TbPageContext mPageContext;
    private i mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.dDe = z;
        this.dIa = z2;
        this.GX = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.dDx = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.dIk = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.dIl = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.duK = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.dIp = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.GX);
        this.duK.setPullRefresh(this.mPullView);
        this.dvS = new PbListView(this.mPageContext.getPageActivity());
        this.dvS.createView();
        this.dIv = new g(this.mPageContext, this.duK, this.dDe);
        this.dIl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aKR();
            }
        });
        if (this.dIa) {
            this.dIw = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.GX, this.dIa);
            this.duK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.dIw.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void aKQ() {
        am.setViewTextColor(this.dIq, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dIr, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dIs, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.dIt, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dIu, R.color.cp_bg_line_c);
    }

    public void mC(int i) {
        if (i == 1) {
            if (this.dIl != null) {
                this.dIl.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.dIl != null) {
            this.dIl.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void mo(int i) {
        if (this.dIk != null) {
            this.dIk.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.dIl.setVisibility(8);
            } else {
                this.dIl.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.csg != i) {
            this.csg = i;
        }
        aKQ();
        am.setViewTextColor(this.dIk, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dIl, (int) R.color.cp_cont_d);
        this.dIl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKR() {
        aKq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mB(int i) {
        mC(i);
        com.baidu.adp.lib.g.g.dismissPopupWindow(this.dDC, this.mPageContext.getPageActivity());
        if (this.dIh != null) {
            this.dIh.mB(i);
        }
    }

    private void aKS() {
        if (this.dDD == null) {
            this.dDD = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.dIm = (TextView) this.dDD.findViewById(R.id.frs_game_live_hot);
            this.dIn = (TextView) this.dDD.findViewById(R.id.frs_game_live_new);
            this.dIo = this.dDD.findViewById(R.id.frs_game_live_sort_sepline);
            this.dIm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.mB(1);
                }
            });
            this.dIn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.mB(2);
                }
            });
        }
        if (this.dDC == null) {
            this.dDC = new PopupWindow(this.mPageContext.getPageActivity());
            this.dDC.setContentView(this.dDD);
            this.dDC.setWidth(-2);
            this.dDC.setHeight(-2);
            this.dDC.setAnimationStyle(16973826);
            this.dDC.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.dDC.setOutsideTouchable(true);
            this.dDC.setFocusable(true);
            this.dDC.setTouchable(true);
            this.dDC.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.aKT();
                }
            });
        }
    }

    private void aKq() {
        aKS();
        am.setBackgroundResource(this.dDD, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.dIm, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.dIn, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.dIo, R.color.cp_bg_line_c);
        am.setViewTextColor(this.dIm, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dIn, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.dIl.getLocationOnScreen(iArr);
        int height = ((View) this.dIl.getParent()).getHeight() - this.dIl.getHeight();
        if (iArr[1] - this.dDC.getHeight() <= 50) {
            com.baidu.adp.lib.g.g.dismissPopupWindow(this.dDC, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dDC, this.rootView, 0, (iArr[0] - (this.dIl.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.dIl.getHeight());
        this.dDC.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKT() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.duK;
    }

    public void a(d dVar) {
        this.dIh = dVar;
    }

    public void completePullRefresh() {
        this.duK.completePullRefresh();
    }

    public void d(List<m> list, boolean z, boolean z2) {
        if (list != null && !v.isEmpty(list)) {
            if (z) {
                this.dDx.setVisibility(0);
            } else {
                this.dDx.setVisibility(8);
            }
            this.dIv.setDatas(list);
            if (z2) {
                aKU();
            } else {
                aJi();
            }
        }
    }

    public void aKU() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.duK.setNextPage(this.dvS);
            }
            this.dvS.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.dvS.endLoadData();
        }
    }

    public void aJi() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.duK.setNextPage(this.dvS);
            }
            this.dvS.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.dvS.endLoadData();
        }
    }

    public void aJj() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.duK.setNextPage(this.dvS);
            }
            this.dvS.showLoadingViewWithoutEmptyView();
            this.dvS.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.duK.setOnSrollToBottomListener(eVar);
        this.dvS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.dIv.b(dVar);
    }
}
