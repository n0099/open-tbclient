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
import com.baidu.tieba.ala.e;
import com.baidu.tieba.ala.frsgamelive.c.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private BdUniqueId ahK;
    private int aiB = -1;
    private PbListView fDW;
    private View fML;
    private PopupWindow fMQ;
    private View fMR;
    private TextView fXA;
    private View fXB;
    private NoNetworkView fXC;
    private TextView fXD;
    private TextView fXE;
    private TextView fXF;
    private View fXG;
    private View fXH;
    private com.baidu.tieba.frs.gametab.b fXJ;
    private BdTypeMultiColumnListView fXa;
    private boolean fXm;
    private boolean fXq;
    private d fXu;
    private TextView fXx;
    private TextView fXy;
    private TextView fXz;
    private View fYc;
    private i fYd;
    private com.baidu.tieba.ala.frsgamelive.a.d fYe;
    private String forumId;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.fXq = false;
        this.mPageContext = tbPageContext;
        this.fXm = z;
        this.ahK = bdUniqueId;
        this.forumId = str;
        this.fXq = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.fXq) {
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
        this.fML = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fXx = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fXy = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.fXa = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.fXa.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.fXC = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.ahK);
        this.fXa.setPullRefresh(this.mPullView);
        this.fDW = new PbListView(this.mPageContext.getPageActivity());
        this.fDW.createView();
        this.fYe = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.fXa);
        this.fXy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bJJ();
            }
        });
        if (this.fXm) {
            this.fXJ = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.ahK, this.fXm);
            this.fXa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.fXJ.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void tk(int i) {
        if (i == 1) {
            if (this.fXy != null) {
                this.fXy.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fXy != null) {
            this.fXy.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void sN(int i) {
        if (this.fXx != null) {
            this.fXx.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fXy.setVisibility(8);
            } else {
                this.fXy.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aiB != i) {
            this.aiB = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        ap.setViewTextColor(this.fXx, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fXy, (int) R.color.cp_cont_d);
        this.fXa.setContentBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
        this.fXy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJJ() {
        bHb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(int i) {
        tk(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.fMQ, this.mPageContext.getPageActivity());
        if (this.fXu != null) {
            this.fXu.tj(i);
        }
    }

    private void bJK() {
        if (this.fMR == null) {
            this.fMR = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fXz = (TextView) this.fMR.findViewById(R.id.frs_game_live_hot);
            this.fXA = (TextView) this.fMR.findViewById(R.id.frs_game_live_new);
            this.fXB = this.fMR.findViewById(R.id.frs_game_live_sort_sepline);
            this.fXz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.tj(1);
                }
            });
            this.fXA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.tj(2);
                }
            });
        }
        if (this.fMQ == null) {
            this.fMQ = new PopupWindow(this.mPageContext.getPageActivity());
            this.fMQ.setContentView(this.fMR);
            this.fMQ.setWidth(-2);
            this.fMQ.setHeight(-2);
            this.fMQ.setAnimationStyle(16973826);
            this.fMQ.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.fMQ.setOutsideTouchable(true);
            this.fMQ.setFocusable(true);
            this.fMQ.setTouchable(true);
            this.fMQ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bJL();
                }
            });
        }
    }

    private void bHb() {
        bJK();
        ap.setBackgroundResource(this.fMR, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.fXz, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.fXA, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.fXB, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.fXz, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.fXA, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fXy.getLocationOnScreen(iArr);
        int height = ((View) this.fXy.getParent()).getHeight() - this.fXy.getHeight();
        if (iArr[1] - this.fMQ.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.fMQ, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fMQ, this.rootView, 0, (iArr[0] - (this.fXy.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fXy.getHeight());
        this.fMQ.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJL() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bJP() {
        return this.fXa;
    }

    public void a(d dVar) {
        this.fXu = dVar;
    }

    public void completePullRefresh() {
        this.fXa.completePullRefresh();
    }

    private void bJQ() {
        if (this.fYc == null) {
            this.fYc = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.fXD = (TextView) this.fYc.findViewById(R.id.frs_game_live_recommand1);
            this.fXE = (TextView) this.fYc.findViewById(R.id.frs_game_live_recommand2);
            this.fXF = (TextView) this.fYc.findViewById(R.id.frs_game_live_recommand3);
            this.fXG = this.fYc.findViewById(R.id.frs_game_live_recommand_line1);
            this.fXH = this.fYc.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bJI();
    }

    private void bJI() {
        ap.setViewTextColor(this.fXD, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fXE, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fXF, (int) R.color.cp_cont_d);
        ap.setBackgroundResource(this.fXG, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.fXH, R.color.cp_bg_line_c);
    }

    public void d(List<q> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bJQ();
            this.fML.setVisibility(8);
            if (this.fYc != null) {
                this.fXa.removeHeaderView(this.fYc);
                this.fXa.addHeaderView(this.fYc);
            }
            this.fYe.setDatas(list);
            this.fXa.setNextPage(null);
            return;
        }
        if (this.fYc != null) {
            this.fXa.removeHeaderView(this.fYc);
        }
        if (list.size() == 0) {
            this.fML.setVisibility(8);
            this.fYe.setDatas(list);
            this.fXa.setNextPage(null);
            return;
        }
        this.fML.setVisibility(0);
        this.fYe.setDatas(list);
        if (z) {
            bJM();
        } else {
            bFR();
        }
    }

    public void bJM() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.fXa.setNextPage(this.fDW);
            }
            this.fDW.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fDW.endLoadData();
        }
    }

    public void bFR() {
        if (this.fYd == null) {
            this.fYd = new i(this.mPageContext.getPageActivity());
            this.fYd.createView();
            this.fYd.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c12573").dD("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.fYd.getView().getParent() == null) {
            this.fXa.setNextPage(this.fYd);
        }
    }

    public void bFS() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.fXa.setNextPage(this.fDW);
            }
            this.fDW.showLoadingViewWithoutEmptyView();
            this.fDW.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.fXa.setOnSrollToBottomListener(onScrollToBottomListener);
        this.fDW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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

    public void b(e eVar) {
        this.fYe.b(eVar);
    }

    public NavigationBar bJH() {
        return this.mNavigationBar;
    }

    public void bGQ() {
        if (this.fXa != null && j.isNetWorkAvailable()) {
            this.fXa.startPullRefresh();
        }
    }
}
