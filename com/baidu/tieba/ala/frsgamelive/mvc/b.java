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
    private BdTypeListView fbb;
    private PbListView fcj;
    private boolean fkG;
    private View fkZ;
    private PopupWindow fle;
    private View flf;
    private boolean fuJ;
    private d fuR;
    private TextView fuU;
    private TextView fuV;
    private TextView fuW;
    private TextView fuX;
    private View fuY;
    private NoNetworkView fuZ;
    private TextView fva;
    private TextView fvb;
    private TextView fvc;
    private View fvd;
    private View fve;
    private g fvf;
    private com.baidu.tieba.frs.gametab.b fvg;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.fkG = z;
        this.fuJ = z2;
        this.afZ = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.fkZ = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fuU = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fuV = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.fbb = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.fuZ = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.afZ);
        this.fbb.setPullRefresh(this.mPullView);
        this.fcj = new PbListView(this.mPageContext.getPageActivity());
        this.fcj.createView();
        this.fvf = new g(this.mPageContext, this.fbb, this.fkG);
        this.fuV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.buc();
            }
        });
        if (this.fuJ) {
            this.fvg = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.afZ, this.fuJ);
            this.fbb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.fvg.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bub() {
        am.setViewTextColor(this.fva, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fvb, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fvc, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.fvd, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fve, R.color.cp_bg_line_c);
    }

    public void qj(int i) {
        if (i == 1) {
            if (this.fuV != null) {
                this.fuV.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fuV != null) {
            this.fuV.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void pN(int i) {
        if (this.fuU != null) {
            this.fuU.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fuV.setVisibility(8);
            } else {
                this.fuV.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.agt != i) {
            this.agt = i;
        }
        bub();
        am.setViewTextColor(this.fuU, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fuV, (int) R.color.cp_cont_d);
        this.fuV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buc() {
        brW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi(int i) {
        qj(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.fle, this.mPageContext.getPageActivity());
        if (this.fuR != null) {
            this.fuR.qi(i);
        }
    }

    private void bud() {
        if (this.flf == null) {
            this.flf = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fuW = (TextView) this.flf.findViewById(R.id.frs_game_live_hot);
            this.fuX = (TextView) this.flf.findViewById(R.id.frs_game_live_new);
            this.fuY = this.flf.findViewById(R.id.frs_game_live_sort_sepline);
            this.fuW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.qi(1);
                }
            });
            this.fuX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.qi(2);
                }
            });
        }
        if (this.fle == null) {
            this.fle = new PopupWindow(this.mPageContext.getPageActivity());
            this.fle.setContentView(this.flf);
            this.fle.setWidth(-2);
            this.fle.setHeight(-2);
            this.fle.setAnimationStyle(16973826);
            this.fle.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.fle.setOutsideTouchable(true);
            this.fle.setFocusable(true);
            this.fle.setTouchable(true);
            this.fle.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bue();
                }
            });
        }
    }

    private void brW() {
        bud();
        am.setBackgroundResource(this.flf, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.fuW, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fuX, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fuY, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fuW, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fuX, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fuV.getLocationOnScreen(iArr);
        int height = ((View) this.fuV.getParent()).getHeight() - this.fuV.getHeight();
        if (iArr[1] - this.fle.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.fle, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fle, this.rootView, 0, (iArr[0] - (this.fuV.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fuV.getHeight());
        this.fle.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bue() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.fbb;
    }

    public void a(d dVar) {
        this.fuR = dVar;
    }

    public void completePullRefresh() {
        this.fbb.completePullRefresh();
    }

    public void d(List<o> list, boolean z, boolean z2) {
        if (list != null && !v.isEmpty(list)) {
            if (z) {
                this.fkZ.setVisibility(0);
            } else {
                this.fkZ.setVisibility(8);
            }
            this.fvf.setDatas(list);
            if (z2) {
                buf();
            } else {
                bqL();
            }
        }
    }

    public void buf() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.fbb.setNextPage(this.fcj);
            }
            this.fcj.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fcj.endLoadData();
        }
    }

    public void bqL() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.fbb.setNextPage(this.fcj);
            }
            this.fcj.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fcj.endLoadData();
        }
    }

    public void bqM() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.fbb.setNextPage(this.fcj);
            }
            this.fcj.showLoadingViewWithoutEmptyView();
            this.fcj.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.fbb.setOnSrollToBottomListener(eVar);
        this.fcj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.fvf.b(dVar);
    }
}
