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
/* loaded from: classes3.dex */
public class b {
    private BdUniqueId MO;
    private int Ni = -1;
    private boolean eBH;
    private d eBP;
    private TextView eBS;
    private TextView eBT;
    private TextView eBU;
    private TextView eBV;
    private View eBW;
    private NoNetworkView eBX;
    private TextView eBY;
    private TextView eBZ;
    private TextView eCa;
    private View eCb;
    private View eCc;
    private g eCd;
    private com.baidu.tieba.frs.gametab.b eCe;
    private BdTypeListView eka;
    private PbListView eli;
    private boolean etB;
    private View etU;
    private PopupWindow etZ;
    private View eua;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.etB = z;
        this.eBH = z2;
        this.MO = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.etU = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.eBS = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.eBT = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.eka = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.eBX = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.MO);
        this.eka.setPullRefresh(this.mPullView);
        this.eli = new PbListView(this.mPageContext.getPageActivity());
        this.eli.createView();
        this.eCd = new g(this.mPageContext, this.eka, this.etB);
        this.eBT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.beL();
            }
        });
        if (this.eBH) {
            this.eCe = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.MO, this.eBH);
            this.eka.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.eCe.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void beK() {
        am.setViewTextColor(this.eBY, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eBZ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCa, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.eCb, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.eCc, R.color.cp_bg_line_c);
    }

    public void pj(int i) {
        if (i == 1) {
            if (this.eBT != null) {
                this.eBT.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.eBT != null) {
            this.eBT.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void oP(int i) {
        if (this.eBS != null) {
            this.eBS.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.eBT.setVisibility(8);
            } else {
                this.eBT.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Ni != i) {
            this.Ni = i;
        }
        beK();
        am.setViewTextColor(this.eBS, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eBT, (int) R.color.cp_cont_d);
        this.eBT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beL() {
        bdz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi(int i) {
        pj(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.etZ, this.mPageContext.getPageActivity());
        if (this.eBP != null) {
            this.eBP.pi(i);
        }
    }

    private void beM() {
        if (this.eua == null) {
            this.eua = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.eBU = (TextView) this.eua.findViewById(R.id.frs_game_live_hot);
            this.eBV = (TextView) this.eua.findViewById(R.id.frs_game_live_new);
            this.eBW = this.eua.findViewById(R.id.frs_game_live_sort_sepline);
            this.eBU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.pi(1);
                }
            });
            this.eBV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.pi(2);
                }
            });
        }
        if (this.etZ == null) {
            this.etZ = new PopupWindow(this.mPageContext.getPageActivity());
            this.etZ.setContentView(this.eua);
            this.etZ.setWidth(-2);
            this.etZ.setHeight(-2);
            this.etZ.setAnimationStyle(16973826);
            this.etZ.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.etZ.setOutsideTouchable(true);
            this.etZ.setFocusable(true);
            this.etZ.setTouchable(true);
            this.etZ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.beN();
                }
            });
        }
    }

    private void bdz() {
        beM();
        am.setBackgroundResource(this.eua, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.eBU, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eBV, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eBW, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eBU, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.eBV, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.eBT.getLocationOnScreen(iArr);
        int height = ((View) this.eBT.getParent()).getHeight() - this.eBT.getHeight();
        if (iArr[1] - this.etZ.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.etZ, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.etZ, this.rootView, 0, (iArr[0] - (this.eBT.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.eBT.getHeight());
        this.etZ.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beN() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.eka;
    }

    public void a(d dVar) {
        this.eBP = dVar;
    }

    public void completePullRefresh() {
        this.eka.completePullRefresh();
    }

    public void d(List<m> list, boolean z, boolean z2) {
        if (list != null && !v.isEmpty(list)) {
            if (z) {
                this.etU.setVisibility(0);
            } else {
                this.etU.setVisibility(8);
            }
            this.eCd.setDatas(list);
            if (z2) {
                beO();
            } else {
                bcr();
            }
        }
    }

    public void beO() {
        if (this.eli != null) {
            if (this.eli.getView().getParent() == null) {
                this.eka.setNextPage(this.eli);
            }
            this.eli.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.eli.endLoadData();
        }
    }

    public void bcr() {
        if (this.eli != null) {
            if (this.eli.getView().getParent() == null) {
                this.eka.setNextPage(this.eli);
            }
            this.eli.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.eli.endLoadData();
        }
    }

    public void bcs() {
        if (this.eli != null) {
            if (this.eli.getView().getParent() == null) {
                this.eka.setNextPage(this.eli);
            }
            this.eli.showLoadingViewWithoutEmptyView();
            this.eli.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.eka.setOnSrollToBottomListener(eVar);
        this.eli.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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
        this.eCd.b(dVar);
    }
}
