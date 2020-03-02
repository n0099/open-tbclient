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
    private boolean eBI;
    private d eBQ;
    private TextView eBT;
    private TextView eBU;
    private TextView eBV;
    private TextView eBW;
    private View eBX;
    private NoNetworkView eBY;
    private TextView eBZ;
    private TextView eCa;
    private TextView eCb;
    private View eCc;
    private View eCd;
    private g eCe;
    private com.baidu.tieba.frs.gametab.b eCf;
    private BdTypeListView ekb;
    private PbListView elj;
    private boolean etC;
    private View etV;
    private PopupWindow eua;
    private View eub;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.etC = z;
        this.eBI = z2;
        this.MO = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.etV = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.eBT = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.eBU = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.ekb = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.eBY = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.MO);
        this.ekb.setPullRefresh(this.mPullView);
        this.elj = new PbListView(this.mPageContext.getPageActivity());
        this.elj.createView();
        this.eCe = new g(this.mPageContext, this.ekb, this.etC);
        this.eBU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.beN();
            }
        });
        if (this.eBI) {
            this.eCf = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.MO, this.eBI);
            this.ekb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.eCf.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void beM() {
        am.setViewTextColor(this.eBZ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCa, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCb, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.eCc, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.eCd, R.color.cp_bg_line_c);
    }

    public void pj(int i) {
        if (i == 1) {
            if (this.eBU != null) {
                this.eBU.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.eBU != null) {
            this.eBU.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void oP(int i) {
        if (this.eBT != null) {
            this.eBT.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.eBU.setVisibility(8);
            } else {
                this.eBU.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Ni != i) {
            this.Ni = i;
        }
        beM();
        am.setViewTextColor(this.eBT, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eBU, (int) R.color.cp_cont_d);
        this.eBU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beN() {
        bdB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi(int i) {
        pj(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.eua, this.mPageContext.getPageActivity());
        if (this.eBQ != null) {
            this.eBQ.pi(i);
        }
    }

    private void beO() {
        if (this.eub == null) {
            this.eub = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.eBV = (TextView) this.eub.findViewById(R.id.frs_game_live_hot);
            this.eBW = (TextView) this.eub.findViewById(R.id.frs_game_live_new);
            this.eBX = this.eub.findViewById(R.id.frs_game_live_sort_sepline);
            this.eBV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.pi(1);
                }
            });
            this.eBW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.pi(2);
                }
            });
        }
        if (this.eua == null) {
            this.eua = new PopupWindow(this.mPageContext.getPageActivity());
            this.eua.setContentView(this.eub);
            this.eua.setWidth(-2);
            this.eua.setHeight(-2);
            this.eua.setAnimationStyle(16973826);
            this.eua.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.eua.setOutsideTouchable(true);
            this.eua.setFocusable(true);
            this.eua.setTouchable(true);
            this.eua.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.beP();
                }
            });
        }
    }

    private void bdB() {
        beO();
        am.setBackgroundResource(this.eub, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.eBV, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eBW, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eBX, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eBV, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.eBW, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.eBU.getLocationOnScreen(iArr);
        int height = ((View) this.eBU.getParent()).getHeight() - this.eBU.getHeight();
        if (iArr[1] - this.eua.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.eua, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.eua, this.rootView, 0, (iArr[0] - (this.eBU.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.eBU.getHeight());
        this.eua.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beP() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.ekb;
    }

    public void a(d dVar) {
        this.eBQ = dVar;
    }

    public void completePullRefresh() {
        this.ekb.completePullRefresh();
    }

    public void d(List<m> list, boolean z, boolean z2) {
        if (list != null && !v.isEmpty(list)) {
            if (z) {
                this.etV.setVisibility(0);
            } else {
                this.etV.setVisibility(8);
            }
            this.eCe.setDatas(list);
            if (z2) {
                beQ();
            } else {
                bct();
            }
        }
    }

    public void beQ() {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.ekb.setNextPage(this.elj);
            }
            this.elj.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.elj.endLoadData();
        }
    }

    public void bct() {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.ekb.setNextPage(this.elj);
            }
            this.elj.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.elj.endLoadData();
        }
    }

    public void bcu() {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.ekb.setNextPage(this.elj);
            }
            this.elj.showLoadingViewWithoutEmptyView();
            this.elj.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.ekb.setOnSrollToBottomListener(eVar);
        this.elj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.eCe.b(dVar);
    }
}
