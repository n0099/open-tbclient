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
    private BdUniqueId afA;
    private int afT = -1;
    private BdTypeListView eOe;
    private PbListView ePm;
    private boolean eXG;
    private View eXZ;
    private PopupWindow eYe;
    private View eYf;
    private boolean fgK;
    private d fgS;
    private TextView fgV;
    private TextView fgW;
    private TextView fgX;
    private TextView fgY;
    private View fgZ;
    private NoNetworkView fha;
    private TextView fhb;
    private TextView fhc;
    private TextView fhd;
    private View fhe;
    private View fhf;
    private g fhg;
    private com.baidu.tieba.frs.gametab.b fhh;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.eXG = z;
        this.fgK = z2;
        this.afA = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.eXZ = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fgV = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fgW = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.eOe = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.fha = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.afA);
        this.eOe.setPullRefresh(this.mPullView);
        this.ePm = new PbListView(this.mPageContext.getPageActivity());
        this.ePm.createView();
        this.fhg = new g(this.mPageContext, this.eOe, this.eXG);
        this.fgW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.boj();
            }
        });
        if (this.fgK) {
            this.fhh = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.afA, this.fgK);
            this.eOe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.fhh.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void boi() {
        am.setViewTextColor(this.fhb, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fhc, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fhd, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.fhe, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fhf, R.color.cp_bg_line_c);
    }

    public void pG(int i) {
        if (i == 1) {
            if (this.fgW != null) {
                this.fgW.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fgW != null) {
            this.fgW.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void pk(int i) {
        if (this.fgV != null) {
            this.fgV.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fgW.setVisibility(8);
            } else {
                this.fgW.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.afT != i) {
            this.afT = i;
        }
        boi();
        am.setViewTextColor(this.fgV, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fgW, (int) R.color.cp_cont_d);
        this.fgW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boj() {
        bmy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pF(int i) {
        pG(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.eYe, this.mPageContext.getPageActivity());
        if (this.fgS != null) {
            this.fgS.pF(i);
        }
    }

    private void bok() {
        if (this.eYf == null) {
            this.eYf = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fgX = (TextView) this.eYf.findViewById(R.id.frs_game_live_hot);
            this.fgY = (TextView) this.eYf.findViewById(R.id.frs_game_live_new);
            this.fgZ = this.eYf.findViewById(R.id.frs_game_live_sort_sepline);
            this.fgX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.pF(1);
                }
            });
            this.fgY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.pF(2);
                }
            });
        }
        if (this.eYe == null) {
            this.eYe = new PopupWindow(this.mPageContext.getPageActivity());
            this.eYe.setContentView(this.eYf);
            this.eYe.setWidth(-2);
            this.eYe.setHeight(-2);
            this.eYe.setAnimationStyle(16973826);
            this.eYe.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.eYe.setOutsideTouchable(true);
            this.eYe.setFocusable(true);
            this.eYe.setTouchable(true);
            this.eYe.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bol();
                }
            });
        }
    }

    private void bmy() {
        bok();
        am.setBackgroundResource(this.eYf, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.fgX, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fgY, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fgZ, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fgX, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fgY, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fgW.getLocationOnScreen(iArr);
        int height = ((View) this.fgW.getParent()).getHeight() - this.fgW.getHeight();
        if (iArr[1] - this.eYe.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.eYe, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.eYe, this.rootView, 0, (iArr[0] - (this.fgW.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fgW.getHeight());
        this.eYe.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bol() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.eOe;
    }

    public void a(d dVar) {
        this.fgS = dVar;
    }

    public void completePullRefresh() {
        this.eOe.completePullRefresh();
    }

    public void d(List<m> list, boolean z, boolean z2) {
        if (list != null && !v.isEmpty(list)) {
            if (z) {
                this.eXZ.setVisibility(0);
            } else {
                this.eXZ.setVisibility(8);
            }
            this.fhg.setDatas(list);
            if (z2) {
                bom();
            } else {
                blp();
            }
        }
    }

    public void bom() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.eOe.setNextPage(this.ePm);
            }
            this.ePm.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.ePm.endLoadData();
        }
    }

    public void blp() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.eOe.setNextPage(this.ePm);
            }
            this.ePm.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.ePm.endLoadData();
        }
    }

    public void blq() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.eOe.setNextPage(this.ePm);
            }
            this.ePm.showLoadingViewWithoutEmptyView();
            this.ePm.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.eOe.setOnSrollToBottomListener(eVar);
        this.ePm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.fhg.b(dVar);
    }
}
