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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.widget.multicolumn.BdMultiColumnListView;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.c.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private BdUniqueId aiz;
    private int ajq = -1;
    private String forumId;
    private BdTypeMultiColumnListView gCC;
    private boolean gCO;
    private boolean gCS;
    private d gCW;
    private TextView gCZ;
    private View gDE;
    private i gDF;
    private com.baidu.tieba.ala.frsgamelive.a.d gDG;
    private TextView gDa;
    private TextView gDb;
    private TextView gDc;
    private View gDd;
    private NoNetworkView gDe;
    private TextView gDf;
    private TextView gDg;
    private TextView gDh;
    private View gDi;
    private View gDj;
    private com.baidu.tieba.frs.gametab.b gDl;
    private PbListView gjo;
    private View gsm;
    private PopupWindow gsr;
    private View gss;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.gCS = false;
        this.mPageContext = tbPageContext;
        this.gCO = z;
        this.aiz = bdUniqueId;
        this.forumId = str;
        this.gCS = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.gCS) {
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
        this.gsm = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gCZ = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gDa = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gCC = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.gCC.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.gDe = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.aiz);
        this.gCC.setPullRefresh(this.mPullView);
        this.gjo = new PbListView(this.mPageContext.getPageActivity());
        this.gjo.createView();
        this.gDG = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.gCC);
        this.gDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bSJ();
            }
        });
        if (this.gCO) {
            this.gDl = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.aiz, this.gCO);
            this.gCC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gDl.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void uD(int i) {
        if (i == 1) {
            if (this.gDa != null) {
                this.gDa.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gDa != null) {
            this.gDa.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void ug(int i) {
        if (this.gCZ != null) {
            this.gCZ.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gDa.setVisibility(8);
            } else {
                this.gDa.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajq != i) {
            this.ajq = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        ap.setViewTextColor(this.gCZ, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.gDa, (int) R.color.cp_cont_d);
        this.gCC.setContentBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
        this.gDa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSJ() {
        bQe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uC(int i) {
        uD(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gsr, this.mPageContext.getPageActivity());
        if (this.gCW != null) {
            this.gCW.uC(i);
        }
    }

    private void bSK() {
        if (this.gss == null) {
            this.gss = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gDb = (TextView) this.gss.findViewById(R.id.frs_game_live_hot);
            this.gDc = (TextView) this.gss.findViewById(R.id.frs_game_live_new);
            this.gDd = this.gss.findViewById(R.id.frs_game_live_sort_sepline);
            this.gDb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.uC(1);
                }
            });
            this.gDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.uC(2);
                }
            });
        }
        if (this.gsr == null) {
            this.gsr = new PopupWindow(this.mPageContext.getPageActivity());
            this.gsr.setContentView(this.gss);
            this.gsr.setWidth(-2);
            this.gsr.setHeight(-2);
            this.gsr.setAnimationStyle(16973826);
            this.gsr.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gsr.setOutsideTouchable(true);
            this.gsr.setFocusable(true);
            this.gsr.setTouchable(true);
            this.gsr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bSL();
                }
            });
        }
    }

    private void bQe() {
        bSK();
        ap.setBackgroundResource(this.gss, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gDb, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gDc, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gDd, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.gDb, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.gDc, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.gDa.getLocationOnScreen(iArr);
        int height = ((View) this.gDa.getParent()).getHeight() - this.gDa.getHeight();
        if (iArr[1] - this.gsr.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gsr, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gsr, this.rootView, 0, (iArr[0] - (this.gDa.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gDa.getHeight());
        this.gsr.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSL() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bSP() {
        return this.gCC;
    }

    public void a(d dVar) {
        this.gCW = dVar;
    }

    public void completePullRefresh() {
        this.gCC.completePullRefresh();
    }

    private void bSQ() {
        if (this.gDE == null) {
            this.gDE = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.gDf = (TextView) this.gDE.findViewById(R.id.frs_game_live_recommand1);
            this.gDg = (TextView) this.gDE.findViewById(R.id.frs_game_live_recommand2);
            this.gDh = (TextView) this.gDE.findViewById(R.id.frs_game_live_recommand3);
            this.gDi = this.gDE.findViewById(R.id.frs_game_live_recommand_line1);
            this.gDj = this.gDE.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bSI();
    }

    private void bSI() {
        ap.setViewTextColor(this.gDf, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.gDg, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.gDh, (int) R.color.cp_cont_d);
        ap.setBackgroundResource(this.gDi, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.gDj, R.color.cp_bg_line_c);
    }

    public void d(List<q> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bSQ();
            this.gsm.setVisibility(8);
            if (this.gDE != null) {
                this.gCC.removeHeaderView(this.gDE);
                this.gCC.addHeaderView(this.gDE);
            }
            this.gDG.setDatas(list);
            this.gCC.setNextPage(null);
            return;
        }
        if (this.gDE != null) {
            this.gCC.removeHeaderView(this.gDE);
        }
        if (list.size() == 0) {
            this.gsm.setVisibility(8);
            this.gDG.setDatas(list);
            this.gCC.setNextPage(null);
            return;
        }
        this.gsm.setVisibility(0);
        this.gDG.setDatas(list);
        if (z) {
            bSM();
        } else {
            bOW();
        }
    }

    public void bSM() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.gCC.setNextPage(this.gjo);
            }
            this.gjo.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gjo.endLoadData();
        }
    }

    public void bOW() {
        if (this.gDF == null) {
            this.gDF = new i(this.mPageContext.getPageActivity());
            this.gDF.createView();
            this.gDF.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c12573").dR("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.gDF.getView().getParent() == null) {
            this.gCC.setNextPage(this.gDF);
        }
    }

    public void bOX() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.gCC.setNextPage(this.gjo);
            }
            this.gjo.showLoadingViewWithoutEmptyView();
            this.gjo.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.gCC.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gjo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        this.gDG.b(fVar);
    }

    public NavigationBar bSH() {
        return this.mNavigationBar;
    }

    public void bPV() {
        if (this.gCC != null && j.isNetWorkAvailable()) {
            this.gCC.startPullRefresh();
        }
    }
}
