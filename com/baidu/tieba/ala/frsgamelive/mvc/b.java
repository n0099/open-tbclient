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
    private BdUniqueId MO;
    private int Ni = -1;
    private boolean eBV;
    private d eCd;
    private TextView eCg;
    private TextView eCh;
    private TextView eCi;
    private TextView eCj;
    private View eCk;
    private NoNetworkView eCl;
    private TextView eCm;
    private TextView eCn;
    private TextView eCo;
    private View eCp;
    private View eCq;
    private g eCr;
    private com.baidu.tieba.frs.gametab.b eCs;
    private BdTypeListView eko;
    private PbListView elw;
    private boolean etP;
    private View eui;
    private PopupWindow eun;
    private View euo;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.etP = z;
        this.eBV = z2;
        this.MO = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.eui = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.eCg = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.eCh = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.eko = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.eCl = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.MO);
        this.eko.setPullRefresh(this.mPullView);
        this.elw = new PbListView(this.mPageContext.getPageActivity());
        this.elw.createView();
        this.eCr = new g(this.mPageContext, this.eko, this.etP);
        this.eCh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.beO();
            }
        });
        if (this.eBV) {
            this.eCs = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.MO, this.eBV);
            this.eko.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.eCs.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void beN() {
        am.setViewTextColor(this.eCm, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCn, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCo, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.eCp, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.eCq, R.color.cp_bg_line_c);
    }

    public void pj(int i) {
        if (i == 1) {
            if (this.eCh != null) {
                this.eCh.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.eCh != null) {
            this.eCh.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void oP(int i) {
        if (this.eCg != null) {
            this.eCg.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.eCh.setVisibility(8);
            } else {
                this.eCh.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Ni != i) {
            this.Ni = i;
        }
        beN();
        am.setViewTextColor(this.eCg, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCh, (int) R.color.cp_cont_d);
        this.eCh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beO() {
        bdC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi(int i) {
        pj(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.eun, this.mPageContext.getPageActivity());
        if (this.eCd != null) {
            this.eCd.pi(i);
        }
    }

    private void beP() {
        if (this.euo == null) {
            this.euo = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.eCi = (TextView) this.euo.findViewById(R.id.frs_game_live_hot);
            this.eCj = (TextView) this.euo.findViewById(R.id.frs_game_live_new);
            this.eCk = this.euo.findViewById(R.id.frs_game_live_sort_sepline);
            this.eCi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.pi(1);
                }
            });
            this.eCj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.pi(2);
                }
            });
        }
        if (this.eun == null) {
            this.eun = new PopupWindow(this.mPageContext.getPageActivity());
            this.eun.setContentView(this.euo);
            this.eun.setWidth(-2);
            this.eun.setHeight(-2);
            this.eun.setAnimationStyle(16973826);
            this.eun.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.eun.setOutsideTouchable(true);
            this.eun.setFocusable(true);
            this.eun.setTouchable(true);
            this.eun.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.beQ();
                }
            });
        }
    }

    private void bdC() {
        beP();
        am.setBackgroundResource(this.euo, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.eCi, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eCj, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eCk, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eCi, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.eCj, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.eCh.getLocationOnScreen(iArr);
        int height = ((View) this.eCh.getParent()).getHeight() - this.eCh.getHeight();
        if (iArr[1] - this.eun.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.eun, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.eun, this.rootView, 0, (iArr[0] - (this.eCh.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.eCh.getHeight());
        this.eun.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beQ() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.eko;
    }

    public void a(d dVar) {
        this.eCd = dVar;
    }

    public void completePullRefresh() {
        this.eko.completePullRefresh();
    }

    public void d(List<m> list, boolean z, boolean z2) {
        if (list != null && !v.isEmpty(list)) {
            if (z) {
                this.eui.setVisibility(0);
            } else {
                this.eui.setVisibility(8);
            }
            this.eCr.setDatas(list);
            if (z2) {
                beR();
            } else {
                bcu();
            }
        }
    }

    public void beR() {
        if (this.elw != null) {
            if (this.elw.getView().getParent() == null) {
                this.eko.setNextPage(this.elw);
            }
            this.elw.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.elw.endLoadData();
        }
    }

    public void bcu() {
        if (this.elw != null) {
            if (this.elw.getView().getParent() == null) {
                this.eko.setNextPage(this.elw);
            }
            this.elw.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.elw.endLoadData();
        }
    }

    public void bcv() {
        if (this.elw != null) {
            if (this.elw.getView().getParent() == null) {
                this.eko.setNextPage(this.elw);
            }
            this.elw.showLoadingViewWithoutEmptyView();
            this.elw.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.eko.setOnSrollToBottomListener(eVar);
        this.elw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.eCr.b(dVar);
    }
}
