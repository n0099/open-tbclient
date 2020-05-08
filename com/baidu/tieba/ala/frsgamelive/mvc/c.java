package com.baidu.tieba.ala.frsgamelive.mvc;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.widget.multicolumn.BdMultiColumnListView;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.c.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BdUniqueId afD;
    private int afW = -1;
    private PbListView ePr;
    private View eYe;
    private PopupWindow eYj;
    private View eYk;
    private BdTypeMultiColumnListView fgD;
    private boolean fgP;
    private boolean fgT;
    private d fgX;
    private View fhF;
    private i fhG;
    private com.baidu.tieba.ala.frsgamelive.a.d fhH;
    private TextView fha;
    private TextView fhb;
    private TextView fhc;
    private TextView fhd;
    private View fhe;
    private NoNetworkView fhf;
    private TextView fhg;
    private TextView fhh;
    private TextView fhi;
    private View fhj;
    private View fhk;
    private com.baidu.tieba.frs.gametab.b fhm;
    private String forumId;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.fgT = false;
        this.mPageContext = tbPageContext;
        this.fgP = z;
        this.afD = bdUniqueId;
        this.forumId = str;
        this.fgT = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.fgT) {
            this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar.showBottomLine(true);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, c.this.mPageContext.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        this.eYe = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fha = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fhb = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.fgD = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.fgD.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.fhf = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.afD);
        this.fgD.setPullRefresh(this.mPullView);
        this.ePr = new PbListView(this.mPageContext.getPageActivity());
        this.ePr.createView();
        this.fhH = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.fgD);
        this.fhb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.boh();
            }
        });
        if (this.fgP) {
            this.fhm = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.afD, this.fgP);
            this.fgD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.fhm.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void pG(int i) {
        if (i == 1) {
            if (this.fhb != null) {
                this.fhb.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fhb != null) {
            this.fhb.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void pk(int i) {
        if (this.fha != null) {
            this.fha.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fhb.setVisibility(8);
            } else {
                this.fhb.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.afW != i) {
            this.afW = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        am.setViewTextColor(this.fha, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fhb, (int) R.color.cp_cont_d);
        this.fgD.setContentBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        this.fhb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boh() {
        bmw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pF(int i) {
        pG(i);
        g.dismissPopupWindow(this.eYj, this.mPageContext.getPageActivity());
        if (this.fgX != null) {
            this.fgX.pF(i);
        }
    }

    private void boi() {
        if (this.eYk == null) {
            this.eYk = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fhc = (TextView) this.eYk.findViewById(R.id.frs_game_live_hot);
            this.fhd = (TextView) this.eYk.findViewById(R.id.frs_game_live_new);
            this.fhe = this.eYk.findViewById(R.id.frs_game_live_sort_sepline);
            this.fhc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.pF(1);
                }
            });
            this.fhd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.pF(2);
                }
            });
        }
        if (this.eYj == null) {
            this.eYj = new PopupWindow(this.mPageContext.getPageActivity());
            this.eYj.setContentView(this.eYk);
            this.eYj.setWidth(-2);
            this.eYj.setHeight(-2);
            this.eYj.setAnimationStyle(16973826);
            this.eYj.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.eYj.setOutsideTouchable(true);
            this.eYj.setFocusable(true);
            this.eYj.setTouchable(true);
            this.eYj.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.boj();
                }
            });
        }
    }

    private void bmw() {
        boi();
        am.setBackgroundResource(this.eYk, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.fhc, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fhd, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fhe, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fhc, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fhd, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fhb.getLocationOnScreen(iArr);
        int height = ((View) this.fhb.getParent()).getHeight() - this.fhb.getHeight();
        if (iArr[1] - this.eYj.getHeight() <= 50) {
            g.dismissPopupWindow(this.eYj, this.mPageContext.getPageActivity());
            return;
        }
        g.showPopupWindowAtLocation(this.eYj, this.rootView, 0, (iArr[0] - (this.fhb.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fhb.getHeight());
        this.eYj.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boj() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView boo() {
        return this.fgD;
    }

    public void a(d dVar) {
        this.fgX = dVar;
    }

    public void completePullRefresh() {
        this.fgD.completePullRefresh();
    }

    private void bop() {
        if (this.fhF == null) {
            this.fhF = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.fhg = (TextView) this.fhF.findViewById(R.id.frs_game_live_recommand1);
            this.fhh = (TextView) this.fhF.findViewById(R.id.frs_game_live_recommand2);
            this.fhi = (TextView) this.fhF.findViewById(R.id.frs_game_live_recommand3);
            this.fhj = this.fhF.findViewById(R.id.frs_game_live_recommand_line1);
            this.fhk = this.fhF.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bog();
    }

    private void bog() {
        am.setViewTextColor(this.fhg, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fhh, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fhi, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.fhj, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fhk, R.color.cp_bg_line_c);
    }

    public void e(List<m> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bop();
            this.eYe.setVisibility(8);
            if (this.fhF != null) {
                this.fgD.removeHeaderView(this.fhF);
                this.fgD.addHeaderView(this.fhF);
            }
            this.fhH.setDatas(list);
            this.fgD.setNextPage(null);
            return;
        }
        if (this.fhF != null) {
            this.fgD.removeHeaderView(this.fhF);
        }
        if (list.size() == 0) {
            this.eYe.setVisibility(8);
            this.fhH.setDatas(list);
            this.fgD.setNextPage(null);
            return;
        }
        this.eYe.setVisibility(0);
        this.fhH.setDatas(list);
        if (z) {
            bok();
        } else {
            bln();
        }
    }

    public void bok() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.fgD.setNextPage(this.ePr);
            }
            this.ePr.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.ePr.endLoadData();
        }
    }

    public void bln() {
        if (this.fhG == null) {
            this.fhG = new i(this.mPageContext.getPageActivity());
            this.fhG.createView();
            this.fhG.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12573").cI("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.fhG.getView().getParent() == null) {
            this.fgD.setNextPage(this.fhG);
        }
    }

    public void blo() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.fgD.setNextPage(this.ePr);
            }
            this.ePr.showLoadingViewWithoutEmptyView();
            this.ePr.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.fgD.setOnSrollToBottomListener(onScrollToBottomListener);
        this.ePr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        this.fhH.b(dVar);
    }

    public NavigationBar bof() {
        return this.mNavigationBar;
    }

    public void bml() {
        if (this.fgD != null && j.isNetWorkAvailable()) {
            this.fgD.startPullRefresh();
        }
    }
}
