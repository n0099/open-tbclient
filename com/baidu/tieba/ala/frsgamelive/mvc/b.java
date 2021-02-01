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
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.a.g;
import com.baidu.tieba.ala.h;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private BdUniqueId agC;
    private int ajU = -1;
    private PbListView gAi;
    private boolean gIS;
    private View gJl;
    private PopupWindow gJq;
    private View gJr;
    private NoNetworkView gVA;
    private TextView gVB;
    private TextView gVC;
    private TextView gVD;
    private View gVE;
    private View gVF;
    private g gVG;
    private com.baidu.tieba.frs.gametab.b gVH;
    private boolean gVk;
    private d gVs;
    private TextView gVv;
    private TextView gVw;
    private TextView gVx;
    private TextView gVy;
    private View gVz;
    private BdTypeListView gzb;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.gIS = z;
        this.gVk = z2;
        this.agC = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.gJl = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gVv = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gVw = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gzb = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.gVA = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.agC);
        this.gzb.setPullRefresh(this.mPullView);
        this.gAi = new PbListView(this.mPageContext.getPageActivity());
        this.gAi.createView();
        this.gVG = new g(this.mPageContext, this.gzb, this.gIS);
        this.gVw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bVf();
            }
        });
        if (this.gVk) {
            this.gVH = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.agC, this.gVk);
            this.gzb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.gVH.i(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bVe() {
        ap.setViewTextColor(this.gVB, R.color.CAM_X0109);
        ap.setViewTextColor(this.gVC, R.color.CAM_X0109);
        ap.setViewTextColor(this.gVD, R.color.CAM_X0109);
        ap.setBackgroundResource(this.gVE, R.color.CAM_X0204);
        ap.setBackgroundResource(this.gVF, R.color.CAM_X0204);
    }

    public void ut(int i) {
        if (i == 1) {
            if (this.gVw != null) {
                this.gVw.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gVw != null) {
            this.gVw.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void tT(int i) {
        if (this.gVv != null) {
            this.gVv.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, au.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gVw.setVisibility(8);
            } else {
                this.gVw.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajU != i) {
            this.ajU = i;
        }
        bVe();
        ap.setViewTextColor(this.gVv, R.color.CAM_X0109);
        ap.setViewTextColor(this.gVw, R.color.CAM_X0109);
        this.gVw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVf() {
        bSz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void us(int i) {
        ut(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gJq, this.mPageContext.getPageActivity());
        if (this.gVs != null) {
            this.gVs.us(i);
        }
    }

    private void bVg() {
        if (this.gJr == null) {
            this.gJr = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gVx = (TextView) this.gJr.findViewById(R.id.frs_game_live_hot);
            this.gVy = (TextView) this.gJr.findViewById(R.id.frs_game_live_new);
            this.gVz = this.gJr.findViewById(R.id.frs_game_live_sort_sepline);
            this.gVx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.us(1);
                }
            });
            this.gVy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.us(2);
                }
            });
        }
        if (this.gJq == null) {
            this.gJq = new PopupWindow(this.mPageContext.getPageActivity());
            this.gJq.setContentView(this.gJr);
            this.gJq.setWidth(-2);
            this.gJq.setHeight(-2);
            this.gJq.setAnimationStyle(16973826);
            this.gJq.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gJq.setOutsideTouchable(true);
            this.gJq.setFocusable(true);
            this.gJq.setTouchable(true);
            this.gJq.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bVh();
                }
            });
        }
    }

    private void bSz() {
        bVg();
        ap.setBackgroundResource(this.gJr, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gVx, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gVy, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gVz, R.color.CAM_X0204);
        ap.setViewTextColor(this.gVx, R.color.CAM_X0106);
        ap.setViewTextColor(this.gVy, R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gVw.getLocationOnScreen(iArr);
        int height = ((View) this.gVw.getParent()).getHeight() - this.gVw.getHeight();
        if (iArr[1] - this.gJq.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gJq, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gJq, this.rootView, 0, (iArr[0] - (this.gVw.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gVw.getHeight());
        this.gJq.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVh() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.gzb;
    }

    public void a(d dVar) {
        this.gVs = dVar;
    }

    public void completePullRefresh() {
        this.gzb.completePullRefresh();
    }

    public void c(List<n> list, boolean z, boolean z2) {
        if (list != null && !y.isEmpty(list)) {
            if (z) {
                this.gJl.setVisibility(0);
            } else {
                this.gJl.setVisibility(8);
            }
            this.gVG.setDatas(list);
            if (z2) {
                bVi();
            } else {
                bRq();
            }
        }
    }

    public void bVi() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.gzb.setNextPage(this.gAi);
            }
            this.gAi.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gAi.endLoadData();
        }
    }

    public void bRq() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.gzb.setNextPage(this.gAi);
            }
            this.gAi.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gAi.endLoadData();
        }
    }

    public void bRr() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.gzb.setNextPage(this.gAi);
            }
            this.gAi.showLoadingViewWithoutEmptyView();
            this.gAi.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.gzb.setOnSrollToBottomListener(eVar);
        this.gAi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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

    public void b(h hVar) {
        this.gVG.b(hVar);
    }
}
