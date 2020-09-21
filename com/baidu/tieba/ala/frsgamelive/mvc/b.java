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
    private int aiX = -1;
    private BdUniqueId aih;
    private BdTypeListView fGf;
    private PbListView fHm;
    private boolean fPK;
    private View fQd;
    private PopupWindow fQi;
    private View fQj;
    private boolean gaE;
    private d gaM;
    private TextView gaP;
    private TextView gaQ;
    private TextView gaR;
    private TextView gaS;
    private View gaT;
    private NoNetworkView gaU;
    private TextView gaV;
    private TextView gaW;
    private TextView gaX;
    private View gaY;
    private View gaZ;
    private g gba;
    private com.baidu.tieba.frs.gametab.b gbb;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.fPK = z;
        this.gaE = z2;
        this.aih = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.fQd = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gaP = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gaQ = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.fGf = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.gaU = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.aih);
        this.fGf.setPullRefresh(this.mPullView);
        this.fHm = new PbListView(this.mPageContext.getPageActivity());
        this.fHm.createView();
        this.gba = new g(this.mPageContext, this.fGf, this.fPK);
        this.gaQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bKU();
            }
        });
        if (this.gaE) {
            this.gbb = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.aih, this.gaE);
            this.fGf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.gbb.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bKT() {
        ap.setViewTextColor(this.gaV, R.color.cp_cont_d);
        ap.setViewTextColor(this.gaW, R.color.cp_cont_d);
        ap.setViewTextColor(this.gaX, R.color.cp_cont_d);
        ap.setBackgroundResource(this.gaY, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.gaZ, R.color.cp_bg_line_c);
    }

    public void tD(int i) {
        if (i == 1) {
            if (this.gaQ != null) {
                this.gaQ.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gaQ != null) {
            this.gaQ.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void tf(int i) {
        if (this.gaP != null) {
            this.gaP.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gaQ.setVisibility(8);
            } else {
                this.gaQ.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aiX != i) {
            this.aiX = i;
        }
        bKT();
        ap.setViewTextColor(this.gaP, R.color.cp_cont_d);
        ap.setViewTextColor(this.gaQ, R.color.cp_cont_d);
        this.gaQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKU() {
        bIs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tC(int i) {
        tD(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.fQi, this.mPageContext.getPageActivity());
        if (this.gaM != null) {
            this.gaM.tC(i);
        }
    }

    private void bKV() {
        if (this.fQj == null) {
            this.fQj = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gaR = (TextView) this.fQj.findViewById(R.id.frs_game_live_hot);
            this.gaS = (TextView) this.fQj.findViewById(R.id.frs_game_live_new);
            this.gaT = this.fQj.findViewById(R.id.frs_game_live_sort_sepline);
            this.gaR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.tC(1);
                }
            });
            this.gaS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.tC(2);
                }
            });
        }
        if (this.fQi == null) {
            this.fQi = new PopupWindow(this.mPageContext.getPageActivity());
            this.fQi.setContentView(this.fQj);
            this.fQi.setWidth(-2);
            this.fQi.setHeight(-2);
            this.fQi.setAnimationStyle(16973826);
            this.fQi.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.fQi.setOutsideTouchable(true);
            this.fQi.setFocusable(true);
            this.fQi.setTouchable(true);
            this.fQi.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bKW();
                }
            });
        }
    }

    private void bIs() {
        bKV();
        ap.setBackgroundResource(this.fQj, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gaR, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gaS, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gaT, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.gaR, R.color.cp_cont_f);
        ap.setViewTextColor(this.gaS, R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.gaQ.getLocationOnScreen(iArr);
        int height = ((View) this.gaQ.getParent()).getHeight() - this.gaQ.getHeight();
        if (iArr[1] - this.fQi.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.fQi, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fQi, this.rootView, 0, (iArr[0] - (this.gaQ.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gaQ.getHeight());
        this.fQi.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKW() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.fGf;
    }

    public void a(d dVar) {
        this.gaM = dVar;
    }

    public void completePullRefresh() {
        this.fGf.completePullRefresh();
    }

    public void c(List<q> list, boolean z, boolean z2) {
        if (list != null && !y.isEmpty(list)) {
            if (z) {
                this.fQd.setVisibility(0);
            } else {
                this.fQd.setVisibility(8);
            }
            this.gba.setDatas(list);
            if (z2) {
                bKX();
            } else {
                bHi();
            }
        }
    }

    public void bKX() {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.fGf.setNextPage(this.fHm);
            }
            this.fHm.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fHm.endLoadData();
        }
    }

    public void bHi() {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.fGf.setNextPage(this.fHm);
            }
            this.fHm.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fHm.endLoadData();
        }
    }

    public void bHj() {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.fGf.setNextPage(this.fHm);
            }
            this.fHm.showLoadingViewWithoutEmptyView();
            this.fHm.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.fGf.setOnSrollToBottomListener(eVar);
        this.fHm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.gba.b(fVar);
    }
}
