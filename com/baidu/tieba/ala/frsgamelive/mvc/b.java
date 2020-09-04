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
import com.baidu.tieba.ala.e;
import com.baidu.tieba.ala.frsgamelive.a.g;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private BdUniqueId ahM;
    private int aiD = -1;
    private BdTypeListView fCT;
    private PbListView fEa;
    private View fMP;
    private PopupWindow fMU;
    private View fMV;
    private boolean fMw;
    private TextView fXB;
    private TextView fXC;
    private TextView fXD;
    private TextView fXE;
    private View fXF;
    private NoNetworkView fXG;
    private TextView fXH;
    private TextView fXI;
    private TextView fXJ;
    private View fXK;
    private View fXL;
    private g fXM;
    private com.baidu.tieba.frs.gametab.b fXN;
    private boolean fXq;
    private d fXy;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.fMw = z;
        this.fXq = z2;
        this.ahM = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.fMP = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fXB = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fXC = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.fCT = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.fXG = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.ahM);
        this.fCT.setPullRefresh(this.mPullView);
        this.fEa = new PbListView(this.mPageContext.getPageActivity());
        this.fEa.createView();
        this.fXM = new g(this.mPageContext, this.fCT, this.fMw);
        this.fXC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bJK();
            }
        });
        if (this.fXq) {
            this.fXN = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.ahM, this.fXq);
            this.fCT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.fXN.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bJJ() {
        ap.setViewTextColor(this.fXH, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fXI, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fXJ, (int) R.color.cp_cont_d);
        ap.setBackgroundResource(this.fXK, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.fXL, R.color.cp_bg_line_c);
    }

    public void tk(int i) {
        if (i == 1) {
            if (this.fXC != null) {
                this.fXC.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fXC != null) {
            this.fXC.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void sN(int i) {
        if (this.fXB != null) {
            this.fXB.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fXC.setVisibility(8);
            } else {
                this.fXC.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aiD != i) {
            this.aiD = i;
        }
        bJJ();
        ap.setViewTextColor(this.fXB, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fXC, (int) R.color.cp_cont_d);
        this.fXC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJK() {
        bHc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(int i) {
        tk(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.fMU, this.mPageContext.getPageActivity());
        if (this.fXy != null) {
            this.fXy.tj(i);
        }
    }

    private void bJL() {
        if (this.fMV == null) {
            this.fMV = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fXD = (TextView) this.fMV.findViewById(R.id.frs_game_live_hot);
            this.fXE = (TextView) this.fMV.findViewById(R.id.frs_game_live_new);
            this.fXF = this.fMV.findViewById(R.id.frs_game_live_sort_sepline);
            this.fXD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.tj(1);
                }
            });
            this.fXE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.tj(2);
                }
            });
        }
        if (this.fMU == null) {
            this.fMU = new PopupWindow(this.mPageContext.getPageActivity());
            this.fMU.setContentView(this.fMV);
            this.fMU.setWidth(-2);
            this.fMU.setHeight(-2);
            this.fMU.setAnimationStyle(16973826);
            this.fMU.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.fMU.setOutsideTouchable(true);
            this.fMU.setFocusable(true);
            this.fMU.setTouchable(true);
            this.fMU.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bJM();
                }
            });
        }
    }

    private void bHc() {
        bJL();
        ap.setBackgroundResource(this.fMV, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.fXD, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.fXE, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.fXF, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.fXD, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.fXE, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fXC.getLocationOnScreen(iArr);
        int height = ((View) this.fXC.getParent()).getHeight() - this.fXC.getHeight();
        if (iArr[1] - this.fMU.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.fMU, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fMU, this.rootView, 0, (iArr[0] - (this.fXC.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fXC.getHeight());
        this.fMU.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJM() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.fCT;
    }

    public void a(d dVar) {
        this.fXy = dVar;
    }

    public void completePullRefresh() {
        this.fCT.completePullRefresh();
    }

    public void c(List<q> list, boolean z, boolean z2) {
        if (list != null && !y.isEmpty(list)) {
            if (z) {
                this.fMP.setVisibility(0);
            } else {
                this.fMP.setVisibility(8);
            }
            this.fXM.setDatas(list);
            if (z2) {
                bJN();
            } else {
                bFS();
            }
        }
    }

    public void bJN() {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.fCT.setNextPage(this.fEa);
            }
            this.fEa.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fEa.endLoadData();
        }
    }

    public void bFS() {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.fCT.setNextPage(this.fEa);
            }
            this.fEa.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fEa.endLoadData();
        }
    }

    public void bFT() {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.fCT.setNextPage(this.fEa);
            }
            this.fEa.showLoadingViewWithoutEmptyView();
            this.fEa.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.fCT.setOnSrollToBottomListener(eVar);
        this.fEa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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

    public void b(e eVar) {
        this.fXM.b(eVar);
    }
}
