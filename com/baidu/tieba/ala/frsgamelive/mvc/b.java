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
/* loaded from: classes2.dex */
public class b {
    private int MA = -1;
    private BdUniqueId Mh;
    private BdTypeListView efM;
    private PbListView egU;
    private PopupWindow eoB;
    private View eoC;
    private boolean eoc;
    private View eow;
    private TextView ewA;
    private View ewB;
    private NoNetworkView ewC;
    private TextView ewD;
    private TextView ewE;
    private TextView ewF;
    private View ewG;
    private View ewH;
    private g ewI;
    private com.baidu.tieba.frs.gametab.b ewJ;
    private boolean ewm;
    private d ewu;
    private TextView ewx;
    private TextView ewy;
    private TextView ewz;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.eoc = z;
        this.ewm = z2;
        this.Mh = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.eow = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.ewx = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.ewy = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.efM = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.ewC = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.Mh);
        this.efM.setPullRefresh(this.mPullView);
        this.egU = new PbListView(this.mPageContext.getPageActivity());
        this.egU.createView();
        this.ewI = new g(this.mPageContext, this.efM, this.eoc);
        this.ewy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bcd();
            }
        });
        if (this.ewm) {
            this.ewJ = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.Mh, this.ewm);
            this.efM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.ewJ.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bcc() {
        am.setViewTextColor(this.ewD, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.ewE, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.ewF, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.ewG, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.ewH, R.color.cp_bg_line_c);
    }

    public void oS(int i) {
        if (i == 1) {
            if (this.ewy != null) {
                this.ewy.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.ewy != null) {
            this.ewy.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void ox(int i) {
        if (this.ewx != null) {
            this.ewx.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.ewy.setVisibility(8);
            } else {
                this.ewy.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.MA != i) {
            this.MA = i;
        }
        bcc();
        am.setViewTextColor(this.ewx, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.ewy, (int) R.color.cp_cont_d);
        this.ewy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcd() {
        baP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR(int i) {
        oS(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.eoB, this.mPageContext.getPageActivity());
        if (this.ewu != null) {
            this.ewu.oR(i);
        }
    }

    private void bce() {
        if (this.eoC == null) {
            this.eoC = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.ewz = (TextView) this.eoC.findViewById(R.id.frs_game_live_hot);
            this.ewA = (TextView) this.eoC.findViewById(R.id.frs_game_live_new);
            this.ewB = this.eoC.findViewById(R.id.frs_game_live_sort_sepline);
            this.ewz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.oR(1);
                }
            });
            this.ewA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.oR(2);
                }
            });
        }
        if (this.eoB == null) {
            this.eoB = new PopupWindow(this.mPageContext.getPageActivity());
            this.eoB.setContentView(this.eoC);
            this.eoB.setWidth(-2);
            this.eoB.setHeight(-2);
            this.eoB.setAnimationStyle(16973826);
            this.eoB.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.eoB.setOutsideTouchable(true);
            this.eoB.setFocusable(true);
            this.eoB.setTouchable(true);
            this.eoB.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bcf();
                }
            });
        }
    }

    private void baP() {
        bce();
        am.setBackgroundResource(this.eoC, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.ewz, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.ewA, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.ewB, R.color.cp_bg_line_c);
        am.setViewTextColor(this.ewz, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.ewA, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.ewy.getLocationOnScreen(iArr);
        int height = ((View) this.ewy.getParent()).getHeight() - this.ewy.getHeight();
        if (iArr[1] - this.eoB.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.eoB, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.eoB, this.rootView, 0, (iArr[0] - (this.ewy.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.ewy.getHeight());
        this.eoB.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcf() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.efM;
    }

    public void a(d dVar) {
        this.ewu = dVar;
    }

    public void completePullRefresh() {
        this.efM.completePullRefresh();
    }

    public void d(List<m> list, boolean z, boolean z2) {
        if (list != null && !v.isEmpty(list)) {
            if (z) {
                this.eow.setVisibility(0);
            } else {
                this.eow.setVisibility(8);
            }
            this.ewI.setDatas(list);
            if (z2) {
                bcg();
            } else {
                aZG();
            }
        }
    }

    public void bcg() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.efM.setNextPage(this.egU);
            }
            this.egU.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.egU.endLoadData();
        }
    }

    public void aZG() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.efM.setNextPage(this.egU);
            }
            this.egU.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.egU.endLoadData();
        }
    }

    public void aZH() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.efM.setNextPage(this.egU);
            }
            this.egU.showLoadingViewWithoutEmptyView();
            this.egU.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.efM.setOnSrollToBottomListener(eVar);
        this.egU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.ewI.b(dVar);
    }
}
