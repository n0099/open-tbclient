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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.a.g;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdUniqueId agK;
    private int ahx = -1;
    private boolean fFT;
    private d fGb;
    private TextView fGe;
    private TextView fGf;
    private TextView fGg;
    private TextView fGh;
    private View fGi;
    private NoNetworkView fGj;
    private TextView fGk;
    private TextView fGl;
    private TextView fGm;
    private View fGn;
    private View fGo;
    private g fGp;
    private com.baidu.tieba.frs.gametab.b fGq;
    private BdTypeListView fml;
    private PbListView fnt;
    private boolean fvT;
    private View fwm;
    private PopupWindow fwr;
    private View fws;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.fvT = z;
        this.fFT = z2;
        this.agK = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.fwm = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fGe = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fGf = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.fml = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.fGj = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.agK);
        this.fml.setPullRefresh(this.mPullView);
        this.fnt = new PbListView(this.mPageContext.getPageActivity());
        this.fnt.createView();
        this.fGp = new g(this.mPageContext, this.fml, this.fvT);
        this.fGf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bwX();
            }
        });
        if (this.fFT) {
            this.fGq = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.agK, this.fFT);
            this.fml.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.fGq.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bwW() {
        an.setViewTextColor(this.fGk, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.fGl, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.fGm, (int) R.color.cp_cont_d);
        an.setBackgroundResource(this.fGn, R.color.cp_bg_line_c);
        an.setBackgroundResource(this.fGo, R.color.cp_bg_line_c);
    }

    public void qI(int i) {
        if (i == 1) {
            if (this.fGf != null) {
                this.fGf.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fGf != null) {
            this.fGf.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void qm(int i) {
        if (this.fGe != null) {
            this.fGe.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, ar.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fGf.setVisibility(8);
            } else {
                this.fGf.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ahx != i) {
            this.ahx = i;
        }
        bwW();
        an.setViewTextColor(this.fGe, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.fGf, (int) R.color.cp_cont_d);
        this.fGf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwX() {
        buS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qH(int i) {
        qI(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.fwr, this.mPageContext.getPageActivity());
        if (this.fGb != null) {
            this.fGb.qH(i);
        }
    }

    private void bwY() {
        if (this.fws == null) {
            this.fws = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fGg = (TextView) this.fws.findViewById(R.id.frs_game_live_hot);
            this.fGh = (TextView) this.fws.findViewById(R.id.frs_game_live_new);
            this.fGi = this.fws.findViewById(R.id.frs_game_live_sort_sepline);
            this.fGg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.qH(1);
                }
            });
            this.fGh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.qH(2);
                }
            });
        }
        if (this.fwr == null) {
            this.fwr = new PopupWindow(this.mPageContext.getPageActivity());
            this.fwr.setContentView(this.fws);
            this.fwr.setWidth(-2);
            this.fwr.setHeight(-2);
            this.fwr.setAnimationStyle(16973826);
            this.fwr.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.fwr.setOutsideTouchable(true);
            this.fwr.setFocusable(true);
            this.fwr.setTouchable(true);
            this.fwr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bwZ();
                }
            });
        }
    }

    private void buS() {
        bwY();
        an.setBackgroundResource(this.fws, R.drawable.bg_ala_frs_game_live_sort_panel);
        an.setBackgroundResource(this.fGg, R.drawable.ala_frs_game_live_sort_selecor);
        an.setBackgroundResource(this.fGh, R.drawable.ala_frs_game_live_sort_selecor);
        an.setBackgroundResource(this.fGi, R.color.cp_bg_line_c);
        an.setViewTextColor(this.fGg, (int) R.color.cp_cont_f);
        an.setViewTextColor(this.fGh, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fGf.getLocationOnScreen(iArr);
        int height = ((View) this.fGf.getParent()).getHeight() - this.fGf.getHeight();
        if (iArr[1] - this.fwr.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.fwr, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fwr, this.rootView, 0, (iArr[0] - (this.fGf.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fGf.getHeight());
        this.fwr.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwZ() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.fml;
    }

    public void a(d dVar) {
        this.fGb = dVar;
    }

    public void completePullRefresh() {
        this.fml.completePullRefresh();
    }

    public void d(List<q> list, boolean z, boolean z2) {
        if (list != null && !w.isEmpty(list)) {
            if (z) {
                this.fwm.setVisibility(0);
            } else {
                this.fwm.setVisibility(8);
            }
            this.fGp.setDatas(list);
            if (z2) {
                bxa();
            } else {
                btI();
            }
        }
    }

    public void bxa() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.fml.setNextPage(this.fnt);
            }
            this.fnt.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fnt.endLoadData();
        }
    }

    public void btI() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.fml.setNextPage(this.fnt);
            }
            this.fnt.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fnt.endLoadData();
        }
    }

    public void btJ() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.fml.setNextPage(this.fnt);
            }
            this.fnt.showLoadingViewWithoutEmptyView();
            this.fnt.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.fml.setOnSrollToBottomListener(eVar);
        this.fnt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.fGp.b(dVar);
    }
}
