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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.a.g;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private BdUniqueId ajD;
    private int aku = -1;
    private View gAe;
    private PopupWindow gAj;
    private View gAk;
    private d gLC;
    private TextView gLF;
    private TextView gLG;
    private TextView gLH;
    private TextView gLI;
    private View gLJ;
    private NoNetworkView gLK;
    private TextView gLL;
    private TextView gLM;
    private TextView gLN;
    private View gLO;
    private View gLP;
    private g gLQ;
    private com.baidu.tieba.frs.gametab.b gLR;
    private boolean gLu;
    private BdTypeListView gpZ;
    private PbListView grg;
    private boolean gzL;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.gzL = z;
        this.gLu = z2;
        this.ajD = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.gAe = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gLF = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gLG = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gpZ = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.gLK = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.ajD);
        this.gpZ.setPullRefresh(this.mPullView);
        this.grg = new PbListView(this.mPageContext.getPageActivity());
        this.grg.createView();
        this.gLQ = new g(this.mPageContext, this.gpZ, this.gzL);
        this.gLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bVN();
            }
        });
        if (this.gLu) {
            this.gLR = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.ajD, this.gLu);
            this.gpZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.gLR.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bVM() {
        ap.setViewTextColor(this.gLL, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gLM, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gLN, (int) R.color.CAM_X0109);
        ap.setBackgroundResource(this.gLO, R.color.CAM_X0204);
        ap.setBackgroundResource(this.gLP, R.color.CAM_X0204);
    }

    public void vI(int i) {
        if (i == 1) {
            if (this.gLG != null) {
                this.gLG.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gLG != null) {
            this.gLG.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void vi(int i) {
        if (this.gLF != null) {
            this.gLF.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, au.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gLG.setVisibility(8);
            } else {
                this.gLG.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aku != i) {
            this.aku = i;
        }
        bVM();
        ap.setViewTextColor(this.gLF, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gLG, (int) R.color.CAM_X0109);
        this.gLG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVN() {
        bTj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vH(int i) {
        vI(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gAj, this.mPageContext.getPageActivity());
        if (this.gLC != null) {
            this.gLC.vH(i);
        }
    }

    private void bVO() {
        if (this.gAk == null) {
            this.gAk = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gLH = (TextView) this.gAk.findViewById(R.id.frs_game_live_hot);
            this.gLI = (TextView) this.gAk.findViewById(R.id.frs_game_live_new);
            this.gLJ = this.gAk.findViewById(R.id.frs_game_live_sort_sepline);
            this.gLH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.vH(1);
                }
            });
            this.gLI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.vH(2);
                }
            });
        }
        if (this.gAj == null) {
            this.gAj = new PopupWindow(this.mPageContext.getPageActivity());
            this.gAj.setContentView(this.gAk);
            this.gAj.setWidth(-2);
            this.gAj.setHeight(-2);
            this.gAj.setAnimationStyle(16973826);
            this.gAj.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gAj.setOutsideTouchable(true);
            this.gAj.setFocusable(true);
            this.gAj.setTouchable(true);
            this.gAj.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bVP();
                }
            });
        }
    }

    private void bTj() {
        bVO();
        ap.setBackgroundResource(this.gAk, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gLH, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gLI, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gLJ, R.color.CAM_X0204);
        ap.setViewTextColor(this.gLH, (int) R.color.CAM_X0106);
        ap.setViewTextColor(this.gLI, (int) R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gLG.getLocationOnScreen(iArr);
        int height = ((View) this.gLG.getParent()).getHeight() - this.gLG.getHeight();
        if (iArr[1] - this.gAj.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gAj, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gAj, this.rootView, 0, (iArr[0] - (this.gLG.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gLG.getHeight());
        this.gAj.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVP() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.gpZ;
    }

    public void a(d dVar) {
        this.gLC = dVar;
    }

    public void completePullRefresh() {
        this.gpZ.completePullRefresh();
    }

    public void c(List<q> list, boolean z, boolean z2) {
        if (list != null && !y.isEmpty(list)) {
            if (z) {
                this.gAe.setVisibility(0);
            } else {
                this.gAe.setVisibility(8);
            }
            this.gLQ.setDatas(list);
            if (z2) {
                bVQ();
            } else {
                bSb();
            }
        }
    }

    public void bVQ() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.gpZ.setNextPage(this.grg);
            }
            this.grg.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.grg.endLoadData();
        }
    }

    public void bSb() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.gpZ.setNextPage(this.grg);
            }
            this.grg.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.grg.endLoadData();
        }
    }

    public void bSc() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.gpZ.setNextPage(this.grg);
            }
            this.grg.showLoadingViewWithoutEmptyView();
            this.grg.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.gpZ.setOnSrollToBottomListener(eVar);
        this.grg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.gLQ.b(fVar);
    }
}
