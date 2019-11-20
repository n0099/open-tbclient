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
import com.baidu.adp.lib.g.g;
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
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.c.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private BdUniqueId GX;
    private int csg = -1;
    private PopupWindow dDC;
    private View dDD;
    private View dDx;
    private BdTypeMultiColumnListView dHO;
    private View dIP;
    private i dIQ;
    private com.baidu.tieba.ala.frsgamelive.a.d dIR;
    private boolean dIa;
    private boolean dId;
    private d dIh;
    private TextView dIk;
    private TextView dIl;
    private TextView dIm;
    private TextView dIn;
    private View dIo;
    private NoNetworkView dIp;
    private TextView dIq;
    private TextView dIr;
    private TextView dIs;
    private View dIt;
    private View dIu;
    private com.baidu.tieba.frs.gametab.b dIw;
    private PbListView dvS;
    private String forumId;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.dId = false;
        this.mPageContext = tbPageContext;
        this.dIa = z;
        this.GX = bdUniqueId;
        this.forumId = str;
        this.dId = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.dId) {
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
        this.dDx = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.dIk = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.dIl = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.dHO = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.dHO.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.dIp = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.mPageContext);
        this.mPullView.setTag(this.GX);
        this.dHO.setPullRefresh(this.mPullView);
        this.dvS = new PbListView(this.mPageContext.getPageActivity());
        this.dvS.createView();
        this.dIR = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.dHO);
        this.dIl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aKR();
            }
        });
        if (this.dIa) {
            this.dIw = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.GX, this.dIa);
            this.dHO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.dIw.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void mC(int i) {
        if (i == 1) {
            if (this.dIl != null) {
                this.dIl.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.dIl != null) {
            this.dIl.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void mo(int i) {
        if (this.dIk != null) {
            this.dIk.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.dIl.setVisibility(8);
            } else {
                this.dIl.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.csg != i) {
            this.csg = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        am.setViewTextColor(this.dIk, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dIl, (int) R.color.cp_cont_d);
        this.dHO.setContentBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        this.dIl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKR() {
        aKq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mB(int i) {
        mC(i);
        g.dismissPopupWindow(this.dDC, this.mPageContext.getPageActivity());
        if (this.dIh != null) {
            this.dIh.mB(i);
        }
    }

    private void aKS() {
        if (this.dDD == null) {
            this.dDD = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.dIm = (TextView) this.dDD.findViewById(R.id.frs_game_live_hot);
            this.dIn = (TextView) this.dDD.findViewById(R.id.frs_game_live_new);
            this.dIo = this.dDD.findViewById(R.id.frs_game_live_sort_sepline);
            this.dIm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mB(1);
                }
            });
            this.dIn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mB(2);
                }
            });
        }
        if (this.dDC == null) {
            this.dDC = new PopupWindow(this.mPageContext.getPageActivity());
            this.dDC.setContentView(this.dDD);
            this.dDC.setWidth(-2);
            this.dDC.setHeight(-2);
            this.dDC.setAnimationStyle(16973826);
            this.dDC.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.dDC.setOutsideTouchable(true);
            this.dDC.setFocusable(true);
            this.dDC.setTouchable(true);
            this.dDC.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.aKT();
                }
            });
        }
    }

    private void aKq() {
        aKS();
        am.setBackgroundResource(this.dDD, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.dIm, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.dIn, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.dIo, R.color.cp_bg_line_c);
        am.setViewTextColor(this.dIm, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dIn, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.dIl.getLocationOnScreen(iArr);
        int height = ((View) this.dIl.getParent()).getHeight() - this.dIl.getHeight();
        if (iArr[1] - this.dDC.getHeight() <= 50) {
            g.dismissPopupWindow(this.dDC, this.mPageContext.getPageActivity());
            return;
        }
        g.showPopupWindowAtLocation(this.dDC, this.rootView, 0, (iArr[0] - (this.dIl.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.dIl.getHeight());
        this.dDC.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKT() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView aKY() {
        return this.dHO;
    }

    public void a(d dVar) {
        this.dIh = dVar;
    }

    public void completePullRefresh() {
        this.dHO.completePullRefresh();
    }

    private void aKZ() {
        if (this.dIP == null) {
            this.dIP = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.dIq = (TextView) this.dIP.findViewById(R.id.frs_game_live_recommand1);
            this.dIr = (TextView) this.dIP.findViewById(R.id.frs_game_live_recommand2);
            this.dIs = (TextView) this.dIP.findViewById(R.id.frs_game_live_recommand3);
            this.dIt = this.dIP.findViewById(R.id.frs_game_live_recommand_line1);
            this.dIu = this.dIP.findViewById(R.id.frs_game_live_recommand_line2);
        }
        aKQ();
    }

    private void aKQ() {
        am.setViewTextColor(this.dIq, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dIr, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dIs, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.dIt, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dIu, R.color.cp_bg_line_c);
    }

    public void e(List<m> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            aKZ();
            this.dDx.setVisibility(8);
            if (this.dIP != null) {
                this.dHO.removeHeaderView(this.dIP);
                this.dHO.addHeaderView(this.dIP);
            }
            this.dIR.setDatas(list);
            this.dHO.setNextPage(null);
            return;
        }
        if (this.dIP != null) {
            this.dHO.removeHeaderView(this.dIP);
        }
        if (list.size() == 0) {
            this.dDx.setVisibility(8);
            this.dIR.setDatas(list);
            this.dHO.setNextPage(null);
            return;
        }
        this.dDx.setVisibility(0);
        this.dIR.setDatas(list);
        if (z) {
            aKU();
        } else {
            aJi();
        }
    }

    public void aKU() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.dHO.setNextPage(this.dvS);
            }
            this.dvS.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.dvS.endLoadData();
        }
    }

    public void aJi() {
        if (this.dIQ == null) {
            this.dIQ = new i(this.mPageContext.getPageActivity());
            this.dIQ.createView();
            this.dIQ.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12573").bS("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.dIQ.getView().getParent() == null) {
            this.dHO.setNextPage(this.dIQ);
        }
    }

    public void aJj() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.dHO.setNextPage(this.dvS);
            }
            this.dvS.showLoadingViewWithoutEmptyView();
            this.dvS.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.dHO.setOnSrollToBottomListener(onScrollToBottomListener);
        this.dvS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        this.dIR.b(dVar);
    }

    public NavigationBar aKP() {
        return this.mNavigationBar;
    }

    public void aKf() {
        if (this.dHO != null && j.isNetWorkAvailable()) {
            this.dHO.startPullRefresh();
        }
    }
}
