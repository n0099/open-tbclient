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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.e;
import com.baidu.tieba.ala.frsgamelive.a.g;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private BdUniqueId agB;
    private int aho = -1;
    private boolean fBa;
    private View fBt;
    private PopupWindow fBy;
    private View fBz;
    private TextView fLA;
    private TextView fLB;
    private TextView fLC;
    private View fLD;
    private NoNetworkView fLE;
    private TextView fLF;
    private TextView fLG;
    private TextView fLH;
    private View fLI;
    private View fLJ;
    private g fLK;
    private com.baidu.tieba.frs.gametab.b fLL;
    private boolean fLo;
    private d fLw;
    private TextView fLz;
    private BdTypeListView frv;
    private PbListView fsC;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.fBa = z;
        this.fLo = z2;
        this.agB = bdUniqueId;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.fBt = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fLz = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fLA = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.frv = (BdTypeListView) this.rootView.findViewById(R.id.listView);
        this.fLE = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.agB);
        this.frv.setPullRefresh(this.mPullView);
        this.fsC = new PbListView(this.mPageContext.getPageActivity());
        this.fsC.createView();
        this.fLK = new g(this.mPageContext, this.frv, this.fBa);
        this.fLA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bAo();
            }
        });
        if (this.fLo) {
            this.fLL = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.agB, this.fLo);
            this.frv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.fLL.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    private void bAn() {
        ao.setViewTextColor(this.fLF, R.color.cp_cont_d);
        ao.setViewTextColor(this.fLG, R.color.cp_cont_d);
        ao.setViewTextColor(this.fLH, R.color.cp_cont_d);
        ao.setBackgroundResource(this.fLI, R.color.cp_bg_line_c);
        ao.setBackgroundResource(this.fLJ, R.color.cp_bg_line_c);
    }

    public void qY(int i) {
        if (i == 1) {
            if (this.fLA != null) {
                this.fLA.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fLA != null) {
            this.fLA.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void qB(int i) {
        if (this.fLz != null) {
            this.fLz.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, as.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fLA.setVisibility(8);
            } else {
                this.fLA.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aho != i) {
            this.aho = i;
        }
        bAn();
        ao.setViewTextColor(this.fLz, R.color.cp_cont_d);
        ao.setViewTextColor(this.fLA, R.color.cp_cont_d);
        this.fLA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAo() {
        byc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX(int i) {
        qY(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.fBy, this.mPageContext.getPageActivity());
        if (this.fLw != null) {
            this.fLw.qX(i);
        }
    }

    private void bAp() {
        if (this.fBz == null) {
            this.fBz = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fLB = (TextView) this.fBz.findViewById(R.id.frs_game_live_hot);
            this.fLC = (TextView) this.fBz.findViewById(R.id.frs_game_live_new);
            this.fLD = this.fBz.findViewById(R.id.frs_game_live_sort_sepline);
            this.fLB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.qX(1);
                }
            });
            this.fLC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.qX(2);
                }
            });
        }
        if (this.fBy == null) {
            this.fBy = new PopupWindow(this.mPageContext.getPageActivity());
            this.fBy.setContentView(this.fBz);
            this.fBy.setWidth(-2);
            this.fBy.setHeight(-2);
            this.fBy.setAnimationStyle(16973826);
            this.fBy.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.fBy.setOutsideTouchable(true);
            this.fBy.setFocusable(true);
            this.fBy.setTouchable(true);
            this.fBy.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.bAq();
                }
            });
        }
    }

    private void byc() {
        bAp();
        ao.setBackgroundResource(this.fBz, R.drawable.bg_ala_frs_game_live_sort_panel);
        ao.setBackgroundResource(this.fLB, R.drawable.ala_frs_game_live_sort_selecor);
        ao.setBackgroundResource(this.fLC, R.drawable.ala_frs_game_live_sort_selecor);
        ao.setBackgroundResource(this.fLD, R.color.cp_bg_line_c);
        ao.setViewTextColor(this.fLB, R.color.cp_cont_f);
        ao.setViewTextColor(this.fLC, R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fLA.getLocationOnScreen(iArr);
        int height = ((View) this.fLA.getParent()).getHeight() - this.fLA.getHeight();
        if (iArr[1] - this.fBy.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.fBy, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fBy, this.rootView, 0, (iArr[0] - (this.fLA.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fLA.getHeight());
        this.fBy.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAq() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeListView getListView() {
        return this.frv;
    }

    public void a(d dVar) {
        this.fLw = dVar;
    }

    public void completePullRefresh() {
        this.frv.completePullRefresh();
    }

    public void c(List<q> list, boolean z, boolean z2) {
        if (list != null && !x.isEmpty(list)) {
            if (z) {
                this.fBt.setVisibility(0);
            } else {
                this.fBt.setVisibility(8);
            }
            this.fLK.setDatas(list);
            if (z2) {
                bAr();
            } else {
                bwS();
            }
        }
    }

    public void bAr() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.frv.setNextPage(this.fsC);
            }
            this.fsC.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fsC.endLoadData();
        }
    }

    public void bwS() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.frv.setNextPage(this.fsC);
            }
            this.fsC.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fsC.endLoadData();
        }
    }

    public void bwT() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.frv.setNextPage(this.fsC);
            }
            this.fsC.showLoadingViewWithoutEmptyView();
            this.fsC.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdListView.e eVar) {
        this.frv.setOnSrollToBottomListener(eVar);
        this.fsC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.b.6
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

    public void b(e eVar) {
        this.fLK.b(eVar);
    }
}
