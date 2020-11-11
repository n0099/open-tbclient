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
    private boolean gCO;
    private d gCW;
    private TextView gCZ;
    private TextView gDa;
    private TextView gDb;
    private TextView gDc;
    private View gDd;
    private NoNetworkView gDe;
    private TextView gDf;
    private TextView gDg;
    private TextView gDh;
    private View gDi;
    private View gDj;
    private g gDk;
    private com.baidu.tieba.frs.gametab.b gDl;
    private BdTypeListView gih;
    private PbListView gjo;
    private boolean grT;
    private View gsm;
    private PopupWindow gsr;
    private View gss;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.grT = z;
        this.gCO = z2;
        this.aiz = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.gsm = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gCZ = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gDa = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gih = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.gDe = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.aiz);
        this.gih.setPullRefresh(this.mPullView);
        this.gjo = new PbListView(this.mPageContext.getPageActivity());
        this.gjo.createView();
        this.gDk = new g(this.mPageContext, this.gih, this.grT);
        this.gDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bSJ();
            }
        });
        if (this.gCO) {
            this.gDl = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.aiz, this.gCO);
            this.gih.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.gDl.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bSI() {
        ap.setViewTextColor(this.gDf, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.gDg, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.gDh, (int) R.color.cp_cont_d);
        ap.setBackgroundResource(this.gDi, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.gDj, R.color.cp_bg_line_c);
    }

    public void uD(int i) {
        if (i == 1) {
            if (this.gDa != null) {
                this.gDa.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gDa != null) {
            this.gDa.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void ug(int i) {
        if (this.gCZ != null) {
            this.gCZ.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gDa.setVisibility(8);
            } else {
                this.gDa.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajq != i) {
            this.ajq = i;
        }
        bSI();
        ap.setViewTextColor(this.gCZ, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.gDa, (int) R.color.cp_cont_d);
        this.gDa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSJ() {
        bQe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uC(int i) {
        uD(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gsr, this.mPageContext.getPageActivity());
        if (this.gCW != null) {
            this.gCW.uC(i);
        }
    }

    private void bSK() {
        if (this.gss == null) {
            this.gss = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gDb = (TextView) this.gss.findViewById(R.id.frs_game_live_hot);
            this.gDc = (TextView) this.gss.findViewById(R.id.frs_game_live_new);
            this.gDd = this.gss.findViewById(R.id.frs_game_live_sort_sepline);
            this.gDb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.uC(1);
                }
            });
            this.gDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.uC(2);
                }
            });
        }
        if (this.gsr == null) {
            this.gsr = new PopupWindow(this.mPageContext.getPageActivity());
            this.gsr.setContentView(this.gss);
            this.gsr.setWidth(-2);
            this.gsr.setHeight(-2);
            this.gsr.setAnimationStyle(16973826);
            this.gsr.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gsr.setOutsideTouchable(true);
            this.gsr.setFocusable(true);
            this.gsr.setTouchable(true);
            this.gsr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bSL();
                }
            });
        }
    }

    private void bQe() {
        bSK();
        ap.setBackgroundResource(this.gss, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gDb, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gDc, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gDd, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.gDb, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.gDc, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.gDa.getLocationOnScreen(iArr);
        int height = ((View) this.gDa.getParent()).getHeight() - this.gDa.getHeight();
        if (iArr[1] - this.gsr.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gsr, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gsr, this.rootView, 0, (iArr[0] - (this.gDa.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gDa.getHeight());
        this.gsr.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSL() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.gih;
    }

    public void a(d dVar) {
        this.gCW = dVar;
    }

    public void completePullRefresh() {
        this.gih.completePullRefresh();
    }

    public void c(List<q> list, boolean z, boolean z2) {
        if (list != null && !y.isEmpty(list)) {
            if (z) {
                this.gsm.setVisibility(0);
            } else {
                this.gsm.setVisibility(8);
            }
            this.gDk.setDatas(list);
            if (z2) {
                bSM();
            } else {
                bOW();
            }
        }
    }

    public void bSM() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.gih.setNextPage(this.gjo);
            }
            this.gjo.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gjo.endLoadData();
        }
    }

    public void bOW() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.gih.setNextPage(this.gjo);
            }
            this.gjo.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gjo.endLoadData();
        }
    }

    public void bOX() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.gih.setNextPage(this.gjo);
            }
            this.gjo.showLoadingViewWithoutEmptyView();
            this.gjo.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.gih.setOnSrollToBottomListener(eVar);
        this.gjo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.gDk.b(fVar);
    }
}
