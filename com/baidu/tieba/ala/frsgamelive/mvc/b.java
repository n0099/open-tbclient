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
/* loaded from: classes9.dex */
public class b {
    private BdUniqueId agN;
    private int akf = -1;
    private View gGB;
    private PopupWindow gGG;
    private View gGH;
    private boolean gGi;
    private boolean gSA;
    private d gSI;
    private TextView gSL;
    private TextView gSM;
    private TextView gSN;
    private TextView gSO;
    private View gSP;
    private NoNetworkView gSQ;
    private TextView gSR;
    private TextView gSS;
    private TextView gST;
    private View gSU;
    private View gSV;
    private g gSW;
    private com.baidu.tieba.frs.gametab.b gSX;
    private BdTypeListView gwr;
    private PbListView gxy;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.gGi = z;
        this.gSA = z2;
        this.agN = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.gGB = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gSL = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gSM = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gwr = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.gSQ = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.agN);
        this.gwr.setPullRefresh(this.mPullView);
        this.gxy = new PbListView(this.mPageContext.getPageActivity());
        this.gxy.createView();
        this.gSW = new g(this.mPageContext, this.gwr, this.gGi);
        this.gSM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bUB();
            }
        });
        if (this.gSA) {
            this.gSX = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.agN, this.gSA);
            this.gwr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.gSX.i(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bUA() {
        ao.setViewTextColor(this.gSR, R.color.CAM_X0109);
        ao.setViewTextColor(this.gSS, R.color.CAM_X0109);
        ao.setViewTextColor(this.gST, R.color.CAM_X0109);
        ao.setBackgroundResource(this.gSU, R.color.CAM_X0204);
        ao.setBackgroundResource(this.gSV, R.color.CAM_X0204);
    }

    public void un(int i) {
        if (i == 1) {
            if (this.gSM != null) {
                this.gSM.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gSM != null) {
            this.gSM.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void tN(int i) {
        if (this.gSL != null) {
            this.gSL.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gSM.setVisibility(8);
            } else {
                this.gSM.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akf != i) {
            this.akf = i;
        }
        bUA();
        ao.setViewTextColor(this.gSL, R.color.CAM_X0109);
        ao.setViewTextColor(this.gSM, R.color.CAM_X0109);
        this.gSM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUB() {
        bRW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void um(int i) {
        un(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gGG, this.mPageContext.getPageActivity());
        if (this.gSI != null) {
            this.gSI.um(i);
        }
    }

    private void bUC() {
        if (this.gGH == null) {
            this.gGH = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gSN = (TextView) this.gGH.findViewById(R.id.frs_game_live_hot);
            this.gSO = (TextView) this.gGH.findViewById(R.id.frs_game_live_new);
            this.gSP = this.gGH.findViewById(R.id.frs_game_live_sort_sepline);
            this.gSN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.um(1);
                }
            });
            this.gSO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.um(2);
                }
            });
        }
        if (this.gGG == null) {
            this.gGG = new PopupWindow(this.mPageContext.getPageActivity());
            this.gGG.setContentView(this.gGH);
            this.gGG.setWidth(-2);
            this.gGG.setHeight(-2);
            this.gGG.setAnimationStyle(16973826);
            this.gGG.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gGG.setOutsideTouchable(true);
            this.gGG.setFocusable(true);
            this.gGG.setTouchable(true);
            this.gGG.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bUD();
                }
            });
        }
    }

    private void bRW() {
        bUC();
        ao.setBackgroundResource(this.gGH, R.drawable.bg_ala_frs_game_live_sort_panel);
        ao.setBackgroundResource(this.gSN, R.drawable.ala_frs_game_live_sort_selecor);
        ao.setBackgroundResource(this.gSO, R.drawable.ala_frs_game_live_sort_selecor);
        ao.setBackgroundResource(this.gSP, R.color.CAM_X0204);
        ao.setViewTextColor(this.gSN, R.color.CAM_X0106);
        ao.setViewTextColor(this.gSO, R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gSM.getLocationOnScreen(iArr);
        int height = ((View) this.gSM.getParent()).getHeight() - this.gSM.getHeight();
        if (iArr[1] - this.gGG.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gGG, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gGG, this.rootView, 0, (iArr[0] - (this.gSM.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gSM.getHeight());
        this.gGG.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUD() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.gwr;
    }

    public void a(d dVar) {
        this.gSI = dVar;
    }

    public void completePullRefresh() {
        this.gwr.completePullRefresh();
    }

    public void c(List<n> list, boolean z, boolean z2) {
        if (list != null && !x.isEmpty(list)) {
            if (z) {
                this.gGB.setVisibility(0);
            } else {
                this.gGB.setVisibility(8);
            }
            this.gSW.setDatas(list);
            if (z2) {
                bUE();
            } else {
                bQM();
            }
        }
    }

    public void bUE() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.gwr.setNextPage(this.gxy);
            }
            this.gxy.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gxy.endLoadData();
        }
    }

    public void bQM() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.gwr.setNextPage(this.gxy);
            }
            this.gxy.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gxy.endLoadData();
        }
    }

    public void bQN() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.gwr.setNextPage(this.gxy);
            }
            this.gxy.showLoadingViewWithoutEmptyView();
            this.gxy.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.gwr.setOnSrollToBottomListener(eVar);
        this.gxy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.gSW.b(gVar);
    }
}
