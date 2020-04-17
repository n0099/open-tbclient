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
    private BdUniqueId afA;
    private int afT = -1;
    private PbListView ePm;
    private View eXZ;
    private PopupWindow eYe;
    private View eYf;
    private boolean fgK;
    private boolean fgO;
    private d fgS;
    private TextView fgV;
    private TextView fgW;
    private TextView fgX;
    private TextView fgY;
    private View fgZ;
    private BdTypeMultiColumnListView fgy;
    private View fhA;
    private i fhB;
    private com.baidu.tieba.ala.frsgamelive.a.d fhC;
    private NoNetworkView fha;
    private TextView fhb;
    private TextView fhc;
    private TextView fhd;
    private View fhe;
    private View fhf;
    private com.baidu.tieba.frs.gametab.b fhh;
    private String forumId;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.fgO = false;
        this.mPageContext = tbPageContext;
        this.fgK = z;
        this.afA = bdUniqueId;
        this.forumId = str;
        this.fgO = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.fgO) {
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
        this.eXZ = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fgV = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fgW = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.fgy = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.fgy.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.fha = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.afA);
        this.fgy.setPullRefresh(this.mPullView);
        this.ePm = new PbListView(this.mPageContext.getPageActivity());
        this.ePm.createView();
        this.fhC = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.fgy);
        this.fgW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.boj();
            }
        });
        if (this.fgK) {
            this.fhh = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.afA, this.fgK);
            this.fgy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.fhh.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void pG(int i) {
        if (i == 1) {
            if (this.fgW != null) {
                this.fgW.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fgW != null) {
            this.fgW.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void pk(int i) {
        if (this.fgV != null) {
            this.fgV.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fgW.setVisibility(8);
            } else {
                this.fgW.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.afT != i) {
            this.afT = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        am.setViewTextColor(this.fgV, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fgW, (int) R.color.cp_cont_d);
        this.fgy.setContentBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        this.fgW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boj() {
        bmy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pF(int i) {
        pG(i);
        g.dismissPopupWindow(this.eYe, this.mPageContext.getPageActivity());
        if (this.fgS != null) {
            this.fgS.pF(i);
        }
    }

    private void bok() {
        if (this.eYf == null) {
            this.eYf = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fgX = (TextView) this.eYf.findViewById(R.id.frs_game_live_hot);
            this.fgY = (TextView) this.eYf.findViewById(R.id.frs_game_live_new);
            this.fgZ = this.eYf.findViewById(R.id.frs_game_live_sort_sepline);
            this.fgX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.pF(1);
                }
            });
            this.fgY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.pF(2);
                }
            });
        }
        if (this.eYe == null) {
            this.eYe = new PopupWindow(this.mPageContext.getPageActivity());
            this.eYe.setContentView(this.eYf);
            this.eYe.setWidth(-2);
            this.eYe.setHeight(-2);
            this.eYe.setAnimationStyle(16973826);
            this.eYe.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.eYe.setOutsideTouchable(true);
            this.eYe.setFocusable(true);
            this.eYe.setTouchable(true);
            this.eYe.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bol();
                }
            });
        }
    }

    private void bmy() {
        bok();
        am.setBackgroundResource(this.eYf, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.fgX, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fgY, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fgZ, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fgX, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fgY, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fgW.getLocationOnScreen(iArr);
        int height = ((View) this.fgW.getParent()).getHeight() - this.fgW.getHeight();
        if (iArr[1] - this.eYe.getHeight() <= 50) {
            g.dismissPopupWindow(this.eYe, this.mPageContext.getPageActivity());
            return;
        }
        g.showPopupWindowAtLocation(this.eYe, this.rootView, 0, (iArr[0] - (this.fgW.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fgW.getHeight());
        this.eYe.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bol() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView boq() {
        return this.fgy;
    }

    public void a(d dVar) {
        this.fgS = dVar;
    }

    public void completePullRefresh() {
        this.fgy.completePullRefresh();
    }

    private void bor() {
        if (this.fhA == null) {
            this.fhA = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.fhb = (TextView) this.fhA.findViewById(R.id.frs_game_live_recommand1);
            this.fhc = (TextView) this.fhA.findViewById(R.id.frs_game_live_recommand2);
            this.fhd = (TextView) this.fhA.findViewById(R.id.frs_game_live_recommand3);
            this.fhe = this.fhA.findViewById(R.id.frs_game_live_recommand_line1);
            this.fhf = this.fhA.findViewById(R.id.frs_game_live_recommand_line2);
        }
        boi();
    }

    private void boi() {
        am.setViewTextColor(this.fhb, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fhc, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fhd, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.fhe, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fhf, R.color.cp_bg_line_c);
    }

    public void e(List<m> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bor();
            this.eXZ.setVisibility(8);
            if (this.fhA != null) {
                this.fgy.removeHeaderView(this.fhA);
                this.fgy.addHeaderView(this.fhA);
            }
            this.fhC.setDatas(list);
            this.fgy.setNextPage(null);
            return;
        }
        if (this.fhA != null) {
            this.fgy.removeHeaderView(this.fhA);
        }
        if (list.size() == 0) {
            this.eXZ.setVisibility(8);
            this.fhC.setDatas(list);
            this.fgy.setNextPage(null);
            return;
        }
        this.eXZ.setVisibility(0);
        this.fhC.setDatas(list);
        if (z) {
            bom();
        } else {
            blp();
        }
    }

    public void bom() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.fgy.setNextPage(this.ePm);
            }
            this.ePm.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.ePm.endLoadData();
        }
    }

    public void blp() {
        if (this.fhB == null) {
            this.fhB = new i(this.mPageContext.getPageActivity());
            this.fhB.createView();
            this.fhB.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12573").cI("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.fhB.getView().getParent() == null) {
            this.fgy.setNextPage(this.fhB);
        }
    }

    public void blq() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.fgy.setNextPage(this.ePm);
            }
            this.ePm.showLoadingViewWithoutEmptyView();
            this.ePm.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.fgy.setOnSrollToBottomListener(onScrollToBottomListener);
        this.ePm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.fhC.b(dVar);
    }

    public NavigationBar boh() {
        return this.mNavigationBar;
    }

    public void bmn() {
        if (this.fgy != null && j.isNetWorkAvailable()) {
            this.fgy.startPullRefresh();
        }
    }
}
