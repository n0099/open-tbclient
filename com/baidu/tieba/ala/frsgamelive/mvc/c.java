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
    private BdUniqueId Hx;
    private int csX = -1;
    private View dEo;
    private PopupWindow dEt;
    private View dEu;
    private BdTypeMultiColumnListView dIF;
    private boolean dIR;
    private boolean dIU;
    private d dIY;
    private View dJG;
    private i dJH;
    private com.baidu.tieba.ala.frsgamelive.a.d dJI;
    private TextView dJb;
    private TextView dJc;
    private TextView dJd;
    private TextView dJe;
    private View dJf;
    private NoNetworkView dJg;
    private TextView dJh;
    private TextView dJi;
    private TextView dJj;
    private View dJk;
    private View dJl;
    private com.baidu.tieba.frs.gametab.b dJn;
    private PbListView dwJ;
    private String forumId;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.dIU = false;
        this.mPageContext = tbPageContext;
        this.dIR = z;
        this.Hx = bdUniqueId;
        this.forumId = str;
        this.dIU = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.dIU) {
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
        this.dEo = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.dJb = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.dJc = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.dIF = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.dIF.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.dJg = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.mPageContext);
        this.mPullView.setTag(this.Hx);
        this.dIF.setPullRefresh(this.mPullView);
        this.dwJ = new PbListView(this.mPageContext.getPageActivity());
        this.dwJ.createView();
        this.dJI = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.dIF);
        this.dJc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aKT();
            }
        });
        if (this.dIR) {
            this.dJn = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.Hx, this.dIR);
            this.dIF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.dJn.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void mD(int i) {
        if (i == 1) {
            if (this.dJc != null) {
                this.dJc.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.dJc != null) {
            this.dJc.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void mp(int i) {
        if (this.dJb != null) {
            this.dJb.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.dJc.setVisibility(8);
            } else {
                this.dJc.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.csX != i) {
            this.csX = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        am.setViewTextColor(this.dJb, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dJc, (int) R.color.cp_cont_d);
        this.dIF.setContentBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        this.dJc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKT() {
        aKs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mC(int i) {
        mD(i);
        g.dismissPopupWindow(this.dEt, this.mPageContext.getPageActivity());
        if (this.dIY != null) {
            this.dIY.mC(i);
        }
    }

    private void aKU() {
        if (this.dEu == null) {
            this.dEu = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.dJd = (TextView) this.dEu.findViewById(R.id.frs_game_live_hot);
            this.dJe = (TextView) this.dEu.findViewById(R.id.frs_game_live_new);
            this.dJf = this.dEu.findViewById(R.id.frs_game_live_sort_sepline);
            this.dJd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mC(1);
                }
            });
            this.dJe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mC(2);
                }
            });
        }
        if (this.dEt == null) {
            this.dEt = new PopupWindow(this.mPageContext.getPageActivity());
            this.dEt.setContentView(this.dEu);
            this.dEt.setWidth(-2);
            this.dEt.setHeight(-2);
            this.dEt.setAnimationStyle(16973826);
            this.dEt.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.dEt.setOutsideTouchable(true);
            this.dEt.setFocusable(true);
            this.dEt.setTouchable(true);
            this.dEt.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.aKV();
                }
            });
        }
    }

    private void aKs() {
        aKU();
        am.setBackgroundResource(this.dEu, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.dJd, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.dJe, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.dJf, R.color.cp_bg_line_c);
        am.setViewTextColor(this.dJd, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dJe, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.dJc.getLocationOnScreen(iArr);
        int height = ((View) this.dJc.getParent()).getHeight() - this.dJc.getHeight();
        if (iArr[1] - this.dEt.getHeight() <= 50) {
            g.dismissPopupWindow(this.dEt, this.mPageContext.getPageActivity());
            return;
        }
        g.showPopupWindowAtLocation(this.dEt, this.rootView, 0, (iArr[0] - (this.dJc.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.dJc.getHeight());
        this.dEt.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKV() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView aLa() {
        return this.dIF;
    }

    public void a(d dVar) {
        this.dIY = dVar;
    }

    public void completePullRefresh() {
        this.dIF.completePullRefresh();
    }

    private void aLb() {
        if (this.dJG == null) {
            this.dJG = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.dJh = (TextView) this.dJG.findViewById(R.id.frs_game_live_recommand1);
            this.dJi = (TextView) this.dJG.findViewById(R.id.frs_game_live_recommand2);
            this.dJj = (TextView) this.dJG.findViewById(R.id.frs_game_live_recommand3);
            this.dJk = this.dJG.findViewById(R.id.frs_game_live_recommand_line1);
            this.dJl = this.dJG.findViewById(R.id.frs_game_live_recommand_line2);
        }
        aKS();
    }

    private void aKS() {
        am.setViewTextColor(this.dJh, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dJi, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dJj, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.dJk, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dJl, R.color.cp_bg_line_c);
    }

    public void e(List<m> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            aLb();
            this.dEo.setVisibility(8);
            if (this.dJG != null) {
                this.dIF.removeHeaderView(this.dJG);
                this.dIF.addHeaderView(this.dJG);
            }
            this.dJI.setDatas(list);
            this.dIF.setNextPage(null);
            return;
        }
        if (this.dJG != null) {
            this.dIF.removeHeaderView(this.dJG);
        }
        if (list.size() == 0) {
            this.dEo.setVisibility(8);
            this.dJI.setDatas(list);
            this.dIF.setNextPage(null);
            return;
        }
        this.dEo.setVisibility(0);
        this.dJI.setDatas(list);
        if (z) {
            aKW();
        } else {
            aJk();
        }
    }

    public void aKW() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.dIF.setNextPage(this.dwJ);
            }
            this.dwJ.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.dwJ.endLoadData();
        }
    }

    public void aJk() {
        if (this.dJH == null) {
            this.dJH = new i(this.mPageContext.getPageActivity());
            this.dJH.createView();
            this.dJH.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12573").bS("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.dJH.getView().getParent() == null) {
            this.dIF.setNextPage(this.dJH);
        }
    }

    public void aJl() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.dIF.setNextPage(this.dwJ);
            }
            this.dwJ.showLoadingViewWithoutEmptyView();
            this.dwJ.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.dIF.setOnSrollToBottomListener(onScrollToBottomListener);
        this.dwJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.dJI.b(dVar);
    }

    public NavigationBar aKR() {
        return this.mNavigationBar;
    }

    public void aKh() {
        if (this.dIF != null && j.isNetWorkAvailable()) {
            this.dIF.startPullRefresh();
        }
    }
}
