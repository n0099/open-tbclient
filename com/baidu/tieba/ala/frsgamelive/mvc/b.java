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
    private PbListView gAw;
    private PopupWindow gJE;
    private View gJF;
    private boolean gJg;
    private View gJz;
    private d gVG;
    private TextView gVJ;
    private TextView gVK;
    private TextView gVL;
    private TextView gVM;
    private View gVN;
    private NoNetworkView gVO;
    private TextView gVP;
    private TextView gVQ;
    private TextView gVR;
    private View gVS;
    private View gVT;
    private g gVU;
    private com.baidu.tieba.frs.gametab.b gVV;
    private boolean gVy;
    private BdTypeListView gzp;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.gJg = z;
        this.gVy = z2;
        this.agC = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.gJz = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gVJ = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gVK = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gzp = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.gVO = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.agC);
        this.gzp.setPullRefresh(this.mPullView);
        this.gAw = new PbListView(this.mPageContext.getPageActivity());
        this.gAw.createView();
        this.gVU = new g(this.mPageContext, this.gzp, this.gJg);
        this.gVK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bVm();
            }
        });
        if (this.gVy) {
            this.gVV = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.agC, this.gVy);
            this.gzp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.gVV.i(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bVl() {
        ap.setViewTextColor(this.gVP, R.color.CAM_X0109);
        ap.setViewTextColor(this.gVQ, R.color.CAM_X0109);
        ap.setViewTextColor(this.gVR, R.color.CAM_X0109);
        ap.setBackgroundResource(this.gVS, R.color.CAM_X0204);
        ap.setBackgroundResource(this.gVT, R.color.CAM_X0204);
    }

    public void ut(int i) {
        if (i == 1) {
            if (this.gVK != null) {
                this.gVK.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gVK != null) {
            this.gVK.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void tT(int i) {
        if (this.gVJ != null) {
            this.gVJ.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, au.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gVK.setVisibility(8);
            } else {
                this.gVK.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajU != i) {
            this.ajU = i;
        }
        bVl();
        ap.setViewTextColor(this.gVJ, R.color.CAM_X0109);
        ap.setViewTextColor(this.gVK, R.color.CAM_X0109);
        this.gVK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVm() {
        bSG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void us(int i) {
        ut(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gJE, this.mPageContext.getPageActivity());
        if (this.gVG != null) {
            this.gVG.us(i);
        }
    }

    private void bVn() {
        if (this.gJF == null) {
            this.gJF = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gVL = (TextView) this.gJF.findViewById(R.id.frs_game_live_hot);
            this.gVM = (TextView) this.gJF.findViewById(R.id.frs_game_live_new);
            this.gVN = this.gJF.findViewById(R.id.frs_game_live_sort_sepline);
            this.gVL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.us(1);
                }
            });
            this.gVM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.us(2);
                }
            });
        }
        if (this.gJE == null) {
            this.gJE = new PopupWindow(this.mPageContext.getPageActivity());
            this.gJE.setContentView(this.gJF);
            this.gJE.setWidth(-2);
            this.gJE.setHeight(-2);
            this.gJE.setAnimationStyle(16973826);
            this.gJE.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gJE.setOutsideTouchable(true);
            this.gJE.setFocusable(true);
            this.gJE.setTouchable(true);
            this.gJE.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bVo();
                }
            });
        }
    }

    private void bSG() {
        bVn();
        ap.setBackgroundResource(this.gJF, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gVL, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gVM, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gVN, R.color.CAM_X0204);
        ap.setViewTextColor(this.gVL, R.color.CAM_X0106);
        ap.setViewTextColor(this.gVM, R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gVK.getLocationOnScreen(iArr);
        int height = ((View) this.gVK.getParent()).getHeight() - this.gVK.getHeight();
        if (iArr[1] - this.gJE.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gJE, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gJE, this.rootView, 0, (iArr[0] - (this.gVK.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gVK.getHeight());
        this.gJE.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVo() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.gzp;
    }

    public void a(d dVar) {
        this.gVG = dVar;
    }

    public void completePullRefresh() {
        this.gzp.completePullRefresh();
    }

    public void c(List<n> list, boolean z, boolean z2) {
        if (list != null && !y.isEmpty(list)) {
            if (z) {
                this.gJz.setVisibility(0);
            } else {
                this.gJz.setVisibility(8);
            }
            this.gVU.setDatas(list);
            if (z2) {
                bVp();
            } else {
                bRx();
            }
        }
    }

    public void bVp() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.gzp.setNextPage(this.gAw);
            }
            this.gAw.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gAw.endLoadData();
        }
    }

    public void bRx() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.gzp.setNextPage(this.gAw);
            }
            this.gAw.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gAw.endLoadData();
        }
    }

    public void bRy() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.gzp.setNextPage(this.gAw);
            }
            this.gAw.showLoadingViewWithoutEmptyView();
            this.gAw.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.gzp.setOnSrollToBottomListener(eVar);
        this.gAw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.gVU.b(hVar);
    }
}
