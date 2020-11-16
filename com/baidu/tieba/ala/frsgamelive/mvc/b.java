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
/* loaded from: classes4.dex */
public class b {
    private BdUniqueId aiE;
    private int ajv = -1;
    private d gCD;
    private TextView gCG;
    private TextView gCH;
    private TextView gCI;
    private TextView gCJ;
    private View gCK;
    private NoNetworkView gCL;
    private TextView gCM;
    private TextView gCN;
    private TextView gCO;
    private View gCP;
    private View gCQ;
    private g gCR;
    private com.baidu.tieba.frs.gametab.b gCS;
    private boolean gCv;
    private BdTypeListView ghN;
    private PbListView giV;
    private boolean grA;
    private View grT;
    private PopupWindow grY;
    private View grZ;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.grA = z;
        this.gCv = z2;
        this.aiE = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.grT = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gCG = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gCH = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.ghN = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.gCL = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.aiE);
        this.ghN.setPullRefresh(this.mPullView);
        this.giV = new PbListView(this.mPageContext.getPageActivity());
        this.giV.createView();
        this.gCR = new g(this.mPageContext, this.ghN, this.grA);
        this.gCH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bSc();
            }
        });
        if (this.gCv) {
            this.gCS = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.aiE, this.gCv);
            this.ghN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.gCS.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bSb() {
        ap.setViewTextColor(this.gCM, R.color.CAM_X0109);
        ap.setViewTextColor(this.gCN, R.color.CAM_X0109);
        ap.setViewTextColor(this.gCO, R.color.CAM_X0109);
        ap.setBackgroundResource(this.gCP, R.color.CAM_X0204);
        ap.setBackgroundResource(this.gCQ, R.color.CAM_X0204);
    }

    public void vb(int i) {
        if (i == 1) {
            if (this.gCH != null) {
                this.gCH.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gCH != null) {
            this.gCH.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void uE(int i) {
        if (this.gCG != null) {
            this.gCG.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, au.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gCH.setVisibility(8);
            } else {
                this.gCH.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajv != i) {
            this.ajv = i;
        }
        bSb();
        ap.setViewTextColor(this.gCG, R.color.CAM_X0109);
        ap.setViewTextColor(this.gCH, R.color.CAM_X0109);
        this.gCH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSc() {
        bPx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void va(int i) {
        vb(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.grY, this.mPageContext.getPageActivity());
        if (this.gCD != null) {
            this.gCD.va(i);
        }
    }

    private void bSd() {
        if (this.grZ == null) {
            this.grZ = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gCI = (TextView) this.grZ.findViewById(R.id.frs_game_live_hot);
            this.gCJ = (TextView) this.grZ.findViewById(R.id.frs_game_live_new);
            this.gCK = this.grZ.findViewById(R.id.frs_game_live_sort_sepline);
            this.gCI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.va(1);
                }
            });
            this.gCJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.va(2);
                }
            });
        }
        if (this.grY == null) {
            this.grY = new PopupWindow(this.mPageContext.getPageActivity());
            this.grY.setContentView(this.grZ);
            this.grY.setWidth(-2);
            this.grY.setHeight(-2);
            this.grY.setAnimationStyle(16973826);
            this.grY.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.grY.setOutsideTouchable(true);
            this.grY.setFocusable(true);
            this.grY.setTouchable(true);
            this.grY.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bSe();
                }
            });
        }
    }

    private void bPx() {
        bSd();
        ap.setBackgroundResource(this.grZ, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gCI, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gCJ, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gCK, R.color.CAM_X0204);
        ap.setViewTextColor(this.gCI, R.color.CAM_X0106);
        ap.setViewTextColor(this.gCJ, R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gCH.getLocationOnScreen(iArr);
        int height = ((View) this.gCH.getParent()).getHeight() - this.gCH.getHeight();
        if (iArr[1] - this.grY.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.grY, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.grY, this.rootView, 0, (iArr[0] - (this.gCH.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gCH.getHeight());
        this.grY.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSe() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.ghN;
    }

    public void a(d dVar) {
        this.gCD = dVar;
    }

    public void completePullRefresh() {
        this.ghN.completePullRefresh();
    }

    public void c(List<q> list, boolean z, boolean z2) {
        if (list != null && !y.isEmpty(list)) {
            if (z) {
                this.grT.setVisibility(0);
            } else {
                this.grT.setVisibility(8);
            }
            this.gCR.setDatas(list);
            if (z2) {
                bSf();
            } else {
                bOp();
            }
        }
    }

    public void bSf() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.ghN.setNextPage(this.giV);
            }
            this.giV.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.giV.endLoadData();
        }
    }

    public void bOp() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.ghN.setNextPage(this.giV);
            }
            this.giV.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.giV.endLoadData();
        }
    }

    public void bOq() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.ghN.setNextPage(this.giV);
            }
            this.giV.showLoadingViewWithoutEmptyView();
            this.giV.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.ghN.setOnSrollToBottomListener(eVar);
        this.giV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.gCR.b(fVar);
    }
}
