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
    private BdUniqueId ahM;
    private int aiD = -1;
    private PbListView fEa;
    private View fMP;
    private PopupWindow fMU;
    private View fMV;
    private TextView fXB;
    private TextView fXC;
    private TextView fXD;
    private TextView fXE;
    private View fXF;
    private NoNetworkView fXG;
    private TextView fXH;
    private TextView fXI;
    private TextView fXJ;
    private View fXK;
    private View fXL;
    private com.baidu.tieba.frs.gametab.b fXN;
    private BdTypeMultiColumnListView fXe;
    private boolean fXq;
    private boolean fXu;
    private d fXy;
    private View fYg;
    private i fYh;
    private com.baidu.tieba.ala.frsgamelive.a.d fYi;
    private String forumId;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.fXu = false;
        this.mPageContext = tbPageContext;
        this.fXq = z;
        this.ahM = bdUniqueId;
        this.forumId = str;
        this.fXu = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.fXu) {
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
        this.fMP = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fXB = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fXC = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.fXe = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.fXe.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.fXG = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.ahM);
        this.fXe.setPullRefresh(this.mPullView);
        this.fEa = new PbListView(this.mPageContext.getPageActivity());
        this.fEa.createView();
        this.fYi = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.fXe);
        this.fXC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bJK();
            }
        });
        if (this.fXq) {
            this.fXN = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.ahM, this.fXq);
            this.fXe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.fXN.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void tk(int i) {
        if (i == 1) {
            if (this.fXC != null) {
                this.fXC.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fXC != null) {
            this.fXC.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void sN(int i) {
        if (this.fXB != null) {
            this.fXB.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fXC.setVisibility(8);
            } else {
                this.fXC.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aiD != i) {
            this.aiD = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        ap.setViewTextColor(this.fXB, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fXC, (int) R.color.cp_cont_d);
        this.fXe.setContentBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
        this.fXC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJK() {
        bHc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(int i) {
        tk(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.fMU, this.mPageContext.getPageActivity());
        if (this.fXy != null) {
            this.fXy.tj(i);
        }
    }

    private void bJL() {
        if (this.fMV == null) {
            this.fMV = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fXD = (TextView) this.fMV.findViewById(R.id.frs_game_live_hot);
            this.fXE = (TextView) this.fMV.findViewById(R.id.frs_game_live_new);
            this.fXF = this.fMV.findViewById(R.id.frs_game_live_sort_sepline);
            this.fXD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.tj(1);
                }
            });
            this.fXE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.tj(2);
                }
            });
        }
        if (this.fMU == null) {
            this.fMU = new PopupWindow(this.mPageContext.getPageActivity());
            this.fMU.setContentView(this.fMV);
            this.fMU.setWidth(-2);
            this.fMU.setHeight(-2);
            this.fMU.setAnimationStyle(16973826);
            this.fMU.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.fMU.setOutsideTouchable(true);
            this.fMU.setFocusable(true);
            this.fMU.setTouchable(true);
            this.fMU.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bJM();
                }
            });
        }
    }

    private void bHc() {
        bJL();
        ap.setBackgroundResource(this.fMV, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.fXD, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.fXE, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.fXF, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.fXD, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.fXE, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fXC.getLocationOnScreen(iArr);
        int height = ((View) this.fXC.getParent()).getHeight() - this.fXC.getHeight();
        if (iArr[1] - this.fMU.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.fMU, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fMU, this.rootView, 0, (iArr[0] - (this.fXC.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fXC.getHeight());
        this.fMU.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJM() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bJQ() {
        return this.fXe;
    }

    public void a(d dVar) {
        this.fXy = dVar;
    }

    public void completePullRefresh() {
        this.fXe.completePullRefresh();
    }

    private void bJR() {
        if (this.fYg == null) {
            this.fYg = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.fXH = (TextView) this.fYg.findViewById(R.id.frs_game_live_recommand1);
            this.fXI = (TextView) this.fYg.findViewById(R.id.frs_game_live_recommand2);
            this.fXJ = (TextView) this.fYg.findViewById(R.id.frs_game_live_recommand3);
            this.fXK = this.fYg.findViewById(R.id.frs_game_live_recommand_line1);
            this.fXL = this.fYg.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bJJ();
    }

    private void bJJ() {
        ap.setViewTextColor(this.fXH, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fXI, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fXJ, (int) R.color.cp_cont_d);
        ap.setBackgroundResource(this.fXK, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.fXL, R.color.cp_bg_line_c);
    }

    public void d(List<q> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bJR();
            this.fMP.setVisibility(8);
            if (this.fYg != null) {
                this.fXe.removeHeaderView(this.fYg);
                this.fXe.addHeaderView(this.fYg);
            }
            this.fYi.setDatas(list);
            this.fXe.setNextPage(null);
            return;
        }
        if (this.fYg != null) {
            this.fXe.removeHeaderView(this.fYg);
        }
        if (list.size() == 0) {
            this.fMP.setVisibility(8);
            this.fYi.setDatas(list);
            this.fXe.setNextPage(null);
            return;
        }
        this.fMP.setVisibility(0);
        this.fYi.setDatas(list);
        if (z) {
            bJN();
        } else {
            bFS();
        }
    }

    public void bJN() {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.fXe.setNextPage(this.fEa);
            }
            this.fEa.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fEa.endLoadData();
        }
    }

    public void bFS() {
        if (this.fYh == null) {
            this.fYh = new i(this.mPageContext.getPageActivity());
            this.fYh.createView();
            this.fYh.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c12573").dD("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.fYh.getView().getParent() == null) {
            this.fXe.setNextPage(this.fYh);
        }
    }

    public void bFT() {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.fXe.setNextPage(this.fEa);
            }
            this.fEa.showLoadingViewWithoutEmptyView();
            this.fEa.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.fXe.setOnSrollToBottomListener(onScrollToBottomListener);
        this.fEa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.fYi.b(eVar);
    }

    public NavigationBar bJI() {
        return this.mNavigationBar;
    }

    public void bGR() {
        if (this.fXe != null && j.isNetWorkAvailable()) {
            this.fXe.startPullRefresh();
        }
    }
}
