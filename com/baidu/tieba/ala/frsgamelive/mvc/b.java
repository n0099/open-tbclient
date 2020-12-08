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
    private View gAc;
    private PopupWindow gAh;
    private View gAi;
    private d gLA;
    private TextView gLD;
    private TextView gLE;
    private TextView gLF;
    private TextView gLG;
    private View gLH;
    private NoNetworkView gLI;
    private TextView gLJ;
    private TextView gLK;
    private TextView gLL;
    private View gLM;
    private View gLN;
    private g gLO;
    private com.baidu.tieba.frs.gametab.b gLP;
    private boolean gLs;
    private BdTypeListView gpX;
    private PbListView gre;
    private boolean gzJ;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.gzJ = z;
        this.gLs = z2;
        this.ajD = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.gAc = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gLD = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gLE = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gpX = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.gLI = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.ajD);
        this.gpX.setPullRefresh(this.mPullView);
        this.gre = new PbListView(this.mPageContext.getPageActivity());
        this.gre.createView();
        this.gLO = new g(this.mPageContext, this.gpX, this.gzJ);
        this.gLE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bVM();
            }
        });
        if (this.gLs) {
            this.gLP = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.ajD, this.gLs);
            this.gpX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.gLP.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bVL() {
        ap.setViewTextColor(this.gLJ, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gLK, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gLL, (int) R.color.CAM_X0109);
        ap.setBackgroundResource(this.gLM, R.color.CAM_X0204);
        ap.setBackgroundResource(this.gLN, R.color.CAM_X0204);
    }

    public void vI(int i) {
        if (i == 1) {
            if (this.gLE != null) {
                this.gLE.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gLE != null) {
            this.gLE.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void vi(int i) {
        if (this.gLD != null) {
            this.gLD.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, au.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gLE.setVisibility(8);
            } else {
                this.gLE.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aku != i) {
            this.aku = i;
        }
        bVL();
        ap.setViewTextColor(this.gLD, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gLE, (int) R.color.CAM_X0109);
        this.gLE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVM() {
        bTi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vH(int i) {
        vI(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gAh, this.mPageContext.getPageActivity());
        if (this.gLA != null) {
            this.gLA.vH(i);
        }
    }

    private void bVN() {
        if (this.gAi == null) {
            this.gAi = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gLF = (TextView) this.gAi.findViewById(R.id.frs_game_live_hot);
            this.gLG = (TextView) this.gAi.findViewById(R.id.frs_game_live_new);
            this.gLH = this.gAi.findViewById(R.id.frs_game_live_sort_sepline);
            this.gLF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.vH(1);
                }
            });
            this.gLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.vH(2);
                }
            });
        }
        if (this.gAh == null) {
            this.gAh = new PopupWindow(this.mPageContext.getPageActivity());
            this.gAh.setContentView(this.gAi);
            this.gAh.setWidth(-2);
            this.gAh.setHeight(-2);
            this.gAh.setAnimationStyle(16973826);
            this.gAh.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gAh.setOutsideTouchable(true);
            this.gAh.setFocusable(true);
            this.gAh.setTouchable(true);
            this.gAh.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bVO();
                }
            });
        }
    }

    private void bTi() {
        bVN();
        ap.setBackgroundResource(this.gAi, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gLF, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gLG, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gLH, R.color.CAM_X0204);
        ap.setViewTextColor(this.gLF, (int) R.color.CAM_X0106);
        ap.setViewTextColor(this.gLG, (int) R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gLE.getLocationOnScreen(iArr);
        int height = ((View) this.gLE.getParent()).getHeight() - this.gLE.getHeight();
        if (iArr[1] - this.gAh.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gAh, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gAh, this.rootView, 0, (iArr[0] - (this.gLE.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gLE.getHeight());
        this.gAh.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVO() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.gpX;
    }

    public void a(d dVar) {
        this.gLA = dVar;
    }

    public void completePullRefresh() {
        this.gpX.completePullRefresh();
    }

    public void c(List<q> list, boolean z, boolean z2) {
        if (list != null && !y.isEmpty(list)) {
            if (z) {
                this.gAc.setVisibility(0);
            } else {
                this.gAc.setVisibility(8);
            }
            this.gLO.setDatas(list);
            if (z2) {
                bVP();
            } else {
                bSa();
            }
        }
    }

    public void bVP() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.gpX.setNextPage(this.gre);
            }
            this.gre.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gre.endLoadData();
        }
    }

    public void bSa() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.gpX.setNextPage(this.gre);
            }
            this.gre.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gre.endLoadData();
        }
    }

    public void bSb() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.gpX.setNextPage(this.gre);
            }
            this.gre.showLoadingViewWithoutEmptyView();
            this.gre.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.gpX.setOnSrollToBottomListener(eVar);
        this.gre.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.gLO.b(fVar);
    }
}
