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
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.a.g;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private int MH = -1;
    private BdUniqueId Mm;
    private BdTypeListView efW;
    private PbListView ehe;
    private View epJ;
    private PopupWindow epO;
    private View epP;
    private boolean epq;
    private d exG;
    private TextView exJ;
    private TextView exK;
    private TextView exL;
    private TextView exM;
    private View exN;
    private NoNetworkView exO;
    private TextView exP;
    private TextView exQ;
    private TextView exR;
    private View exS;
    private View exT;
    private g exU;
    private com.baidu.tieba.frs.gametab.b exV;
    private boolean exy;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.epq = z;
        this.exy = z2;
        this.Mm = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.epJ = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.exJ = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.exK = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.efW = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.exO = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.Mm);
        this.efW.setPullRefresh(this.mPullView);
        this.ehe = new PbListView(this.mPageContext.getPageActivity());
        this.ehe.createView();
        this.exU = new g(this.mPageContext, this.efW, this.epq);
        this.exK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bcy();
            }
        });
        if (this.exy) {
            this.exV = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.Mm, this.exy);
            this.efW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.exV.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bcx() {
        am.setViewTextColor(this.exP, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.exQ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.exR, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.exS, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.exT, R.color.cp_bg_line_c);
    }

    public void oT(int i) {
        if (i == 1) {
            if (this.exK != null) {
                this.exK.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.exK != null) {
            this.exK.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void oy(int i) {
        if (this.exJ != null) {
            this.exJ.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.exK.setVisibility(8);
            } else {
                this.exK.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.MH != i) {
            this.MH = i;
        }
        bcx();
        am.setViewTextColor(this.exJ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.exK, (int) R.color.cp_cont_d);
        this.exK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcy() {
        bbk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oS(int i) {
        oT(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.epO, this.mPageContext.getPageActivity());
        if (this.exG != null) {
            this.exG.oS(i);
        }
    }

    private void bcz() {
        if (this.epP == null) {
            this.epP = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.exL = (TextView) this.epP.findViewById(R.id.frs_game_live_hot);
            this.exM = (TextView) this.epP.findViewById(R.id.frs_game_live_new);
            this.exN = this.epP.findViewById(R.id.frs_game_live_sort_sepline);
            this.exL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.oS(1);
                }
            });
            this.exM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.oS(2);
                }
            });
        }
        if (this.epO == null) {
            this.epO = new PopupWindow(this.mPageContext.getPageActivity());
            this.epO.setContentView(this.epP);
            this.epO.setWidth(-2);
            this.epO.setHeight(-2);
            this.epO.setAnimationStyle(16973826);
            this.epO.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.epO.setOutsideTouchable(true);
            this.epO.setFocusable(true);
            this.epO.setTouchable(true);
            this.epO.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bcA();
                }
            });
        }
    }

    private void bbk() {
        bcz();
        am.setBackgroundResource(this.epP, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.exL, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.exM, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.exN, R.color.cp_bg_line_c);
        am.setViewTextColor(this.exL, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.exM, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.exK.getLocationOnScreen(iArr);
        int height = ((View) this.exK.getParent()).getHeight() - this.exK.getHeight();
        if (iArr[1] - this.epO.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.epO, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.epO, this.rootView, 0, (iArr[0] - (this.exK.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.exK.getHeight());
        this.epO.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcA() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.efW;
    }

    public void a(d dVar) {
        this.exG = dVar;
    }

    public void completePullRefresh() {
        this.efW.completePullRefresh();
    }

    public void d(List<m> list, boolean z, boolean z2) {
        if (list != null && !v.isEmpty(list)) {
            if (z) {
                this.epJ.setVisibility(0);
            } else {
                this.epJ.setVisibility(8);
            }
            this.exU.setDatas(list);
            if (z2) {
                bcB();
            } else {
                bab();
            }
        }
    }

    public void bcB() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.efW.setNextPage(this.ehe);
            }
            this.ehe.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.ehe.endLoadData();
        }
    }

    public void bab() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.efW.setNextPage(this.ehe);
            }
            this.ehe.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.ehe.endLoadData();
        }
    }

    public void bac() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.efW.setNextPage(this.ehe);
            }
            this.ehe.showLoadingViewWithoutEmptyView();
            this.ehe.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.efW.setOnSrollToBottomListener(eVar);
        this.ehe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (eVar != null) {
                    eVar.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        this.exU.b(dVar);
    }
}
