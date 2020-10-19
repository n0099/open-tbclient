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
    private BdUniqueId aiy;
    private int ajp = -1;
    private BdTypeListView fSo;
    private PbListView fTv;
    private PopupWindow gcA;
    private View gcB;
    private boolean gcc;
    private View gcv;
    private boolean gmV;
    private d gnd;
    private TextView gng;
    private TextView gnh;
    private TextView gni;
    private TextView gnj;
    private View gnk;
    private NoNetworkView gnl;
    private TextView gnm;
    private TextView gnn;
    private TextView gno;
    private View gnp;
    private View gnq;
    private g gnr;
    private com.baidu.tieba.frs.gametab.b gns;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.gcc = z;
        this.gmV = z2;
        this.aiy = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.gcv = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gng = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gnh = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.fSo = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.gnl = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.aiy);
        this.fSo.setPullRefresh(this.mPullView);
        this.fTv = new PbListView(this.mPageContext.getPageActivity());
        this.fTv.createView();
        this.gnr = new g(this.mPageContext, this.fSo, this.gcc);
        this.gnh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bNE();
            }
        });
        if (this.gmV) {
            this.gns = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.aiy, this.gmV);
            this.fSo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.gns.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bND() {
        ap.setViewTextColor(this.gnm, R.color.cp_cont_d);
        ap.setViewTextColor(this.gnn, R.color.cp_cont_d);
        ap.setViewTextColor(this.gno, R.color.cp_cont_d);
        ap.setBackgroundResource(this.gnp, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.gnq, R.color.cp_bg_line_c);
    }

    public void ub(int i) {
        if (i == 1) {
            if (this.gnh != null) {
                this.gnh.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gnh != null) {
            this.gnh.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void tD(int i) {
        if (this.gng != null) {
            this.gng.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gnh.setVisibility(8);
            } else {
                this.gnh.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajp != i) {
            this.ajp = i;
        }
        bND();
        ap.setViewTextColor(this.gng, R.color.cp_cont_d);
        ap.setViewTextColor(this.gnh, R.color.cp_cont_d);
        this.gnh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNE() {
        bLc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ua(int i) {
        ub(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gcA, this.mPageContext.getPageActivity());
        if (this.gnd != null) {
            this.gnd.ua(i);
        }
    }

    private void bNF() {
        if (this.gcB == null) {
            this.gcB = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gni = (TextView) this.gcB.findViewById(R.id.frs_game_live_hot);
            this.gnj = (TextView) this.gcB.findViewById(R.id.frs_game_live_new);
            this.gnk = this.gcB.findViewById(R.id.frs_game_live_sort_sepline);
            this.gni.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.ua(1);
                }
            });
            this.gnj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.ua(2);
                }
            });
        }
        if (this.gcA == null) {
            this.gcA = new PopupWindow(this.mPageContext.getPageActivity());
            this.gcA.setContentView(this.gcB);
            this.gcA.setWidth(-2);
            this.gcA.setHeight(-2);
            this.gcA.setAnimationStyle(16973826);
            this.gcA.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gcA.setOutsideTouchable(true);
            this.gcA.setFocusable(true);
            this.gcA.setTouchable(true);
            this.gcA.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bNG();
                }
            });
        }
    }

    private void bLc() {
        bNF();
        ap.setBackgroundResource(this.gcB, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gni, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gnj, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gnk, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.gni, R.color.cp_cont_f);
        ap.setViewTextColor(this.gnj, R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.gnh.getLocationOnScreen(iArr);
        int height = ((View) this.gnh.getParent()).getHeight() - this.gnh.getHeight();
        if (iArr[1] - this.gcA.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gcA, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gcA, this.rootView, 0, (iArr[0] - (this.gnh.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gnh.getHeight());
        this.gcA.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNG() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.fSo;
    }

    public void a(d dVar) {
        this.gnd = dVar;
    }

    public void completePullRefresh() {
        this.fSo.completePullRefresh();
    }

    public void c(List<q> list, boolean z, boolean z2) {
        if (list != null && !y.isEmpty(list)) {
            if (z) {
                this.gcv.setVisibility(0);
            } else {
                this.gcv.setVisibility(8);
            }
            this.gnr.setDatas(list);
            if (z2) {
                bNH();
            } else {
                bJU();
            }
        }
    }

    public void bNH() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.fSo.setNextPage(this.fTv);
            }
            this.fTv.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fTv.endLoadData();
        }
    }

    public void bJU() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.fSo.setNextPage(this.fTv);
            }
            this.fTv.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fTv.endLoadData();
        }
    }

    public void bJV() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.fSo.setNextPage(this.fTv);
            }
            this.fTv.showLoadingViewWithoutEmptyView();
            this.fTv.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.fSo.setOnSrollToBottomListener(eVar);
        this.fTv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.gnr.b(fVar);
    }
}
