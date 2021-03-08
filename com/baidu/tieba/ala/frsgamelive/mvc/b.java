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
/* loaded from: classes9.dex */
public class b {
    private BdUniqueId ahU;
    private int aln = -1;
    private BdTypeListView gAY;
    private PbListView gCf;
    private boolean gKP;
    private View gLi;
    private PopupWindow gLn;
    private View gLo;
    private TextView gXA;
    private View gXB;
    private View gXC;
    private g gXD;
    private com.baidu.tieba.frs.gametab.b gXE;
    private boolean gXh;
    private d gXp;
    private TextView gXs;
    private TextView gXt;
    private TextView gXu;
    private TextView gXv;
    private View gXw;
    private NoNetworkView gXx;
    private TextView gXy;
    private TextView gXz;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.gKP = z;
        this.gXh = z2;
        this.ahU = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.gLi = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gXs = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gXt = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gAY = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.gXx = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.ahU);
        this.gAY.setPullRefresh(this.mPullView);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.createView();
        this.gXD = new g(this.mPageContext, this.gAY, this.gKP);
        this.gXt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bVs();
            }
        });
        if (this.gXh) {
            this.gXE = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.ahU, this.gXh);
            this.gAY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.gXE.i(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bVr() {
        ap.setViewTextColor(this.gXy, R.color.CAM_X0109);
        ap.setViewTextColor(this.gXz, R.color.CAM_X0109);
        ap.setViewTextColor(this.gXA, R.color.CAM_X0109);
        ap.setBackgroundResource(this.gXB, R.color.CAM_X0204);
        ap.setBackgroundResource(this.gXC, R.color.CAM_X0204);
    }

    public void uv(int i) {
        if (i == 1) {
            if (this.gXt != null) {
                this.gXt.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gXt != null) {
            this.gXt.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void tV(int i) {
        if (this.gXs != null) {
            this.gXs.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, au.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gXt.setVisibility(8);
            } else {
                this.gXt.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aln != i) {
            this.aln = i;
        }
        bVr();
        ap.setViewTextColor(this.gXs, R.color.CAM_X0109);
        ap.setViewTextColor(this.gXt, R.color.CAM_X0109);
        this.gXt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVs() {
        bSM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uu(int i) {
        uv(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gLn, this.mPageContext.getPageActivity());
        if (this.gXp != null) {
            this.gXp.uu(i);
        }
    }

    private void bVt() {
        if (this.gLo == null) {
            this.gLo = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gXu = (TextView) this.gLo.findViewById(R.id.frs_game_live_hot);
            this.gXv = (TextView) this.gLo.findViewById(R.id.frs_game_live_new);
            this.gXw = this.gLo.findViewById(R.id.frs_game_live_sort_sepline);
            this.gXu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.uu(1);
                }
            });
            this.gXv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.uu(2);
                }
            });
        }
        if (this.gLn == null) {
            this.gLn = new PopupWindow(this.mPageContext.getPageActivity());
            this.gLn.setContentView(this.gLo);
            this.gLn.setWidth(-2);
            this.gLn.setHeight(-2);
            this.gLn.setAnimationStyle(16973826);
            this.gLn.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gLn.setOutsideTouchable(true);
            this.gLn.setFocusable(true);
            this.gLn.setTouchable(true);
            this.gLn.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bVu();
                }
            });
        }
    }

    private void bSM() {
        bVt();
        ap.setBackgroundResource(this.gLo, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gXu, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gXv, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gXw, R.color.CAM_X0204);
        ap.setViewTextColor(this.gXu, R.color.CAM_X0106);
        ap.setViewTextColor(this.gXv, R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gXt.getLocationOnScreen(iArr);
        int height = ((View) this.gXt.getParent()).getHeight() - this.gXt.getHeight();
        if (iArr[1] - this.gLn.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gLn, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gLn, this.rootView, 0, (iArr[0] - (this.gXt.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gXt.getHeight());
        this.gLn.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVu() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.gAY;
    }

    public void a(d dVar) {
        this.gXp = dVar;
    }

    public void completePullRefresh() {
        this.gAY.completePullRefresh();
    }

    public void c(List<n> list, boolean z, boolean z2) {
        if (list != null && !y.isEmpty(list)) {
            if (z) {
                this.gLi.setVisibility(0);
            } else {
                this.gLi.setVisibility(8);
            }
            this.gXD.setDatas(list);
            if (z2) {
                bVv();
            } else {
                bRD();
            }
        }
    }

    public void bVv() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gAY.setNextPage(this.gCf);
            }
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gCf.endLoadData();
        }
    }

    public void bRD() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gAY.setNextPage(this.gCf);
            }
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gCf.endLoadData();
        }
    }

    public void bRE() {
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

    public void b(h hVar) {
        this.gXD.b(hVar);
    }
}
