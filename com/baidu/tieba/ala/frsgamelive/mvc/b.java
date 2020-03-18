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
    private BdUniqueId MP;
    private int Nj = -1;
    private TextView eCC;
    private TextView eCD;
    private TextView eCE;
    private TextView eCF;
    private View eCG;
    private NoNetworkView eCH;
    private TextView eCI;
    private TextView eCJ;
    private TextView eCK;
    private View eCL;
    private View eCM;
    private g eCN;
    private com.baidu.tieba.frs.gametab.b eCO;
    private boolean eCr;
    private d eCz;
    private BdTypeListView ekE;
    private PbListView elM;
    private View euE;
    private PopupWindow euJ;
    private View euK;
    private boolean eul;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.eul = z;
        this.eCr = z2;
        this.MP = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.euE = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.eCC = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.eCD = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.ekE = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.eCH = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.MP);
        this.ekE.setPullRefresh(this.mPullView);
        this.elM = new PbListView(this.mPageContext.getPageActivity());
        this.elM.createView();
        this.eCN = new g(this.mPageContext, this.ekE, this.eul);
        this.eCD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.beT();
            }
        });
        if (this.eCr) {
            this.eCO = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.MP, this.eCr);
            this.ekE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.eCO.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void beS() {
        am.setViewTextColor(this.eCI, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCJ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCK, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.eCL, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.eCM, R.color.cp_bg_line_c);
    }

    public void pl(int i) {
        if (i == 1) {
            if (this.eCD != null) {
                this.eCD.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.eCD != null) {
            this.eCD.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void oR(int i) {
        if (this.eCC != null) {
            this.eCC.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.eCD.setVisibility(8);
            } else {
                this.eCD.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Nj != i) {
            this.Nj = i;
        }
        beS();
        am.setViewTextColor(this.eCC, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCD, (int) R.color.cp_cont_d);
        this.eCD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beT() {
        bdH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pk(int i) {
        pl(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.euJ, this.mPageContext.getPageActivity());
        if (this.eCz != null) {
            this.eCz.pk(i);
        }
    }

    private void beU() {
        if (this.euK == null) {
            this.euK = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.eCE = (TextView) this.euK.findViewById(R.id.frs_game_live_hot);
            this.eCF = (TextView) this.euK.findViewById(R.id.frs_game_live_new);
            this.eCG = this.euK.findViewById(R.id.frs_game_live_sort_sepline);
            this.eCE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.pk(1);
                }
            });
            this.eCF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.pk(2);
                }
            });
        }
        if (this.euJ == null) {
            this.euJ = new PopupWindow(this.mPageContext.getPageActivity());
            this.euJ.setContentView(this.euK);
            this.euJ.setWidth(-2);
            this.euJ.setHeight(-2);
            this.euJ.setAnimationStyle(16973826);
            this.euJ.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.euJ.setOutsideTouchable(true);
            this.euJ.setFocusable(true);
            this.euJ.setTouchable(true);
            this.euJ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.beV();
                }
            });
        }
    }

    private void bdH() {
        beU();
        am.setBackgroundResource(this.euK, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.eCE, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eCF, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eCG, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eCE, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.eCF, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.eCD.getLocationOnScreen(iArr);
        int height = ((View) this.eCD.getParent()).getHeight() - this.eCD.getHeight();
        if (iArr[1] - this.euJ.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.euJ, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.euJ, this.rootView, 0, (iArr[0] - (this.eCD.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.eCD.getHeight());
        this.euJ.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beV() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.ekE;
    }

    public void a(d dVar) {
        this.eCz = dVar;
    }

    public void completePullRefresh() {
        this.ekE.completePullRefresh();
    }

    public void d(List<m> list, boolean z, boolean z2) {
        if (list != null && !v.isEmpty(list)) {
            if (z) {
                this.euE.setVisibility(0);
            } else {
                this.euE.setVisibility(8);
            }
            this.eCN.setDatas(list);
            if (z2) {
                beW();
            } else {
                bcy();
            }
        }
    }

    public void beW() {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.ekE.setNextPage(this.elM);
            }
            this.elM.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.elM.endLoadData();
        }
    }

    public void bcy() {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.ekE.setNextPage(this.elM);
            }
            this.elM.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.elM.endLoadData();
        }
    }

    public void bcz() {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.ekE.setNextPage(this.elM);
            }
            this.elM.showLoadingViewWithoutEmptyView();
            this.elM.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.ekE.setOnSrollToBottomListener(eVar);
        this.elM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.eCN.b(dVar);
    }
}
