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
    private BdUniqueId ahK;
    private int aiB = -1;
    private BdTypeListView fCP;
    private PbListView fDW;
    private View fML;
    private PopupWindow fMQ;
    private View fMR;
    private boolean fMs;
    private TextView fXA;
    private View fXB;
    private NoNetworkView fXC;
    private TextView fXD;
    private TextView fXE;
    private TextView fXF;
    private View fXG;
    private View fXH;
    private g fXI;
    private com.baidu.tieba.frs.gametab.b fXJ;
    private boolean fXm;
    private d fXu;
    private TextView fXx;
    private TextView fXy;
    private TextView fXz;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.fMs = z;
        this.fXm = z2;
        this.ahK = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.fML = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fXx = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fXy = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.fCP = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.fXC = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.ahK);
        this.fCP.setPullRefresh(this.mPullView);
        this.fDW = new PbListView(this.mPageContext.getPageActivity());
        this.fDW.createView();
        this.fXI = new g(this.mPageContext, this.fCP, this.fMs);
        this.fXy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bJJ();
            }
        });
        if (this.fXm) {
            this.fXJ = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.ahK, this.fXm);
            this.fCP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.fXJ.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bJI() {
        ap.setViewTextColor(this.fXD, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fXE, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fXF, (int) R.color.cp_cont_d);
        ap.setBackgroundResource(this.fXG, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.fXH, R.color.cp_bg_line_c);
    }

    public void tk(int i) {
        if (i == 1) {
            if (this.fXy != null) {
                this.fXy.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fXy != null) {
            this.fXy.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void sN(int i) {
        if (this.fXx != null) {
            this.fXx.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fXy.setVisibility(8);
            } else {
                this.fXy.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aiB != i) {
            this.aiB = i;
        }
        bJI();
        ap.setViewTextColor(this.fXx, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fXy, (int) R.color.cp_cont_d);
        this.fXy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJJ() {
        bHb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(int i) {
        tk(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.fMQ, this.mPageContext.getPageActivity());
        if (this.fXu != null) {
            this.fXu.tj(i);
        }
    }

    private void bJK() {
        if (this.fMR == null) {
            this.fMR = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fXz = (TextView) this.fMR.findViewById(R.id.frs_game_live_hot);
            this.fXA = (TextView) this.fMR.findViewById(R.id.frs_game_live_new);
            this.fXB = this.fMR.findViewById(R.id.frs_game_live_sort_sepline);
            this.fXz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.tj(1);
                }
            });
            this.fXA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.tj(2);
                }
            });
        }
        if (this.fMQ == null) {
            this.fMQ = new PopupWindow(this.mPageContext.getPageActivity());
            this.fMQ.setContentView(this.fMR);
            this.fMQ.setWidth(-2);
            this.fMQ.setHeight(-2);
            this.fMQ.setAnimationStyle(16973826);
            this.fMQ.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.fMQ.setOutsideTouchable(true);
            this.fMQ.setFocusable(true);
            this.fMQ.setTouchable(true);
            this.fMQ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bJL();
                }
            });
        }
    }

    private void bHb() {
        bJK();
        ap.setBackgroundResource(this.fMR, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.fXz, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.fXA, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.fXB, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.fXz, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.fXA, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fXy.getLocationOnScreen(iArr);
        int height = ((View) this.fXy.getParent()).getHeight() - this.fXy.getHeight();
        if (iArr[1] - this.fMQ.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.fMQ, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fMQ, this.rootView, 0, (iArr[0] - (this.fXy.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fXy.getHeight());
        this.fMQ.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJL() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.fCP;
    }

    public void a(d dVar) {
        this.fXu = dVar;
    }

    public void completePullRefresh() {
        this.fCP.completePullRefresh();
    }

    public void c(List<q> list, boolean z, boolean z2) {
        if (list != null && !y.isEmpty(list)) {
            if (z) {
                this.fML.setVisibility(0);
            } else {
                this.fML.setVisibility(8);
            }
            this.fXI.setDatas(list);
            if (z2) {
                bJM();
            } else {
                bFR();
            }
        }
    }

    public void bJM() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.fCP.setNextPage(this.fDW);
            }
            this.fDW.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fDW.endLoadData();
        }
    }

    public void bFR() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.fCP.setNextPage(this.fDW);
            }
            this.fDW.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fDW.endLoadData();
        }
    }

    public void bFS() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.fCP.setNextPage(this.fDW);
            }
            this.fDW.showLoadingViewWithoutEmptyView();
            this.fDW.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.fCP.setOnSrollToBottomListener(eVar);
        this.fDW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.fXI.b(eVar);
    }
}
