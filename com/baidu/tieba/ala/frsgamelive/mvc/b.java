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
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.a.g;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdUniqueId afZ;
    private int agt = -1;
    private BdTypeListView faQ;
    private PbListView fbY;
    private View fkO;
    private PopupWindow fkT;
    private View fkU;
    private boolean fkv;
    private d fuG;
    private TextView fuJ;
    private TextView fuK;
    private TextView fuL;
    private TextView fuM;
    private View fuN;
    private NoNetworkView fuO;
    private TextView fuP;
    private TextView fuQ;
    private TextView fuR;
    private View fuS;
    private View fuT;
    private g fuU;
    private com.baidu.tieba.frs.gametab.b fuV;
    private boolean fuy;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.fkv = z;
        this.fuy = z2;
        this.afZ = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.fkO = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fuJ = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fuK = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.faQ = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.fuO = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.afZ);
        this.faQ.setPullRefresh(this.mPullView);
        this.fbY = new PbListView(this.mPageContext.getPageActivity());
        this.fbY.createView();
        this.fuU = new g(this.mPageContext, this.faQ, this.fkv);
        this.fuK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bua();
            }
        });
        if (this.fuy) {
            this.fuV = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.afZ, this.fuy);
            this.faQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.fuV.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void btZ() {
        am.setViewTextColor(this.fuP, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fuQ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fuR, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.fuS, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fuT, R.color.cp_bg_line_c);
    }

    public void qh(int i) {
        if (i == 1) {
            if (this.fuK != null) {
                this.fuK.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fuK != null) {
            this.fuK.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void pL(int i) {
        if (this.fuJ != null) {
            this.fuJ.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fuK.setVisibility(8);
            } else {
                this.fuK.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.agt != i) {
            this.agt = i;
        }
        btZ();
        am.setViewTextColor(this.fuJ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fuK, (int) R.color.cp_cont_d);
        this.fuK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bua() {
        brU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(int i) {
        qh(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.fkT, this.mPageContext.getPageActivity());
        if (this.fuG != null) {
            this.fuG.qg(i);
        }
    }

    private void bub() {
        if (this.fkU == null) {
            this.fkU = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fuL = (TextView) this.fkU.findViewById(R.id.frs_game_live_hot);
            this.fuM = (TextView) this.fkU.findViewById(R.id.frs_game_live_new);
            this.fuN = this.fkU.findViewById(R.id.frs_game_live_sort_sepline);
            this.fuL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.qg(1);
                }
            });
            this.fuM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.qg(2);
                }
            });
        }
        if (this.fkT == null) {
            this.fkT = new PopupWindow(this.mPageContext.getPageActivity());
            this.fkT.setContentView(this.fkU);
            this.fkT.setWidth(-2);
            this.fkT.setHeight(-2);
            this.fkT.setAnimationStyle(16973826);
            this.fkT.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.fkT.setOutsideTouchable(true);
            this.fkT.setFocusable(true);
            this.fkT.setTouchable(true);
            this.fkT.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.buc();
                }
            });
        }
    }

    private void brU() {
        bub();
        am.setBackgroundResource(this.fkU, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.fuL, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fuM, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fuN, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fuL, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fuM, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fuK.getLocationOnScreen(iArr);
        int height = ((View) this.fuK.getParent()).getHeight() - this.fuK.getHeight();
        if (iArr[1] - this.fkT.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.fkT, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fkT, this.rootView, 0, (iArr[0] - (this.fuK.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fuK.getHeight());
        this.fkT.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buc() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.faQ;
    }

    public void a(d dVar) {
        this.fuG = dVar;
    }

    public void completePullRefresh() {
        this.faQ.completePullRefresh();
    }

    public void d(List<o> list, boolean z, boolean z2) {
        if (list != null && !v.isEmpty(list)) {
            if (z) {
                this.fkO.setVisibility(0);
            } else {
                this.fkO.setVisibility(8);
            }
            this.fuU.setDatas(list);
            if (z2) {
                bud();
            } else {
                bqJ();
            }
        }
    }

    public void bud() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.faQ.setNextPage(this.fbY);
            }
            this.fbY.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fbY.endLoadData();
        }
    }

    public void bqJ() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.faQ.setNextPage(this.fbY);
            }
            this.fbY.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fbY.endLoadData();
        }
    }

    public void bqK() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.faQ.setNextPage(this.fbY);
            }
            this.fbY.showLoadingViewWithoutEmptyView();
            this.fbY.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.faQ.setOnSrollToBottomListener(eVar);
        this.fbY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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

    public void b(com.baidu.tieba.ala.d dVar) {
        this.fuU.b(dVar);
    }
}
