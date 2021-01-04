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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.a.g;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private BdUniqueId ahE;
    private int akW = -1;
    private BdTypeListView gAY;
    private PbListView gCf;
    private boolean gKO;
    private View gLh;
    private PopupWindow gLm;
    private View gLn;
    private View gXA;
    private View gXB;
    private g gXC;
    private com.baidu.tieba.frs.gametab.b gXD;
    private boolean gXg;
    private d gXo;
    private TextView gXr;
    private TextView gXs;
    private TextView gXt;
    private TextView gXu;
    private View gXv;
    private NoNetworkView gXw;
    private TextView gXx;
    private TextView gXy;
    private TextView gXz;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.gKO = z;
        this.gXg = z2;
        this.ahE = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.gLh = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gXr = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gXs = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gAY = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.gXw = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.ahE);
        this.gAY.setPullRefresh(this.mPullView);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.createView();
        this.gXC = new g(this.mPageContext, this.gAY, this.gKO);
        this.gXs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bYs();
            }
        });
        if (this.gXg) {
            this.gXD = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.ahE, this.gXg);
            this.gAY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.gXD.i(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bYr() {
        ao.setViewTextColor(this.gXx, R.color.CAM_X0109);
        ao.setViewTextColor(this.gXy, R.color.CAM_X0109);
        ao.setViewTextColor(this.gXz, R.color.CAM_X0109);
        ao.setBackgroundResource(this.gXA, R.color.CAM_X0204);
        ao.setBackgroundResource(this.gXB, R.color.CAM_X0204);
    }

    public void vT(int i) {
        if (i == 1) {
            if (this.gXs != null) {
                this.gXs.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gXs != null) {
            this.gXs.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void vt(int i) {
        if (this.gXr != null) {
            this.gXr.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gXs.setVisibility(8);
            } else {
                this.gXs.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akW != i) {
            this.akW = i;
        }
        bYr();
        ao.setViewTextColor(this.gXr, R.color.CAM_X0109);
        ao.setViewTextColor(this.gXs, R.color.CAM_X0109);
        this.gXs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYs() {
        bVN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(int i) {
        vT(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gLm, this.mPageContext.getPageActivity());
        if (this.gXo != null) {
            this.gXo.vS(i);
        }
    }

    private void bYt() {
        if (this.gLn == null) {
            this.gLn = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gXt = (TextView) this.gLn.findViewById(R.id.frs_game_live_hot);
            this.gXu = (TextView) this.gLn.findViewById(R.id.frs_game_live_new);
            this.gXv = this.gLn.findViewById(R.id.frs_game_live_sort_sepline);
            this.gXt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.vS(1);
                }
            });
            this.gXu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.vS(2);
                }
            });
        }
        if (this.gLm == null) {
            this.gLm = new PopupWindow(this.mPageContext.getPageActivity());
            this.gLm.setContentView(this.gLn);
            this.gLm.setWidth(-2);
            this.gLm.setHeight(-2);
            this.gLm.setAnimationStyle(16973826);
            this.gLm.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gLm.setOutsideTouchable(true);
            this.gLm.setFocusable(true);
            this.gLm.setTouchable(true);
            this.gLm.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bYu();
                }
            });
        }
    }

    private void bVN() {
        bYt();
        ao.setBackgroundResource(this.gLn, R.drawable.bg_ala_frs_game_live_sort_panel);
        ao.setBackgroundResource(this.gXt, R.drawable.ala_frs_game_live_sort_selecor);
        ao.setBackgroundResource(this.gXu, R.drawable.ala_frs_game_live_sort_selecor);
        ao.setBackgroundResource(this.gXv, R.color.CAM_X0204);
        ao.setViewTextColor(this.gXt, R.color.CAM_X0106);
        ao.setViewTextColor(this.gXu, R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gXs.getLocationOnScreen(iArr);
        int height = ((View) this.gXs.getParent()).getHeight() - this.gXs.getHeight();
        if (iArr[1] - this.gLm.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gLm, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gLm, this.rootView, 0, (iArr[0] - (this.gXs.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gXs.getHeight());
        this.gLm.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYu() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.gAY;
    }

    public void a(d dVar) {
        this.gXo = dVar;
    }

    public void completePullRefresh() {
        this.gAY.completePullRefresh();
    }

    public void c(List<n> list, boolean z, boolean z2) {
        if (list != null && !x.isEmpty(list)) {
            if (z) {
                this.gLh.setVisibility(0);
            } else {
                this.gLh.setVisibility(8);
            }
            this.gXC.setDatas(list);
            if (z2) {
                bYv();
            } else {
                bUD();
            }
        }
    }

    public void bYv() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gAY.setNextPage(this.gCf);
            }
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gCf.endLoadData();
        }
    }

    public void bUD() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gAY.setNextPage(this.gCf);
            }
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gCf.endLoadData();
        }
    }

    public void bUE() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gAY.setNextPage(this.gCf);
            }
            this.gCf.showLoadingViewWithoutEmptyView();
            this.gCf.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.gAY.setOnSrollToBottomListener(eVar);
        this.gCf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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

    public void b(com.baidu.tieba.ala.g gVar) {
        this.gXC.b(gVar);
    }
}
