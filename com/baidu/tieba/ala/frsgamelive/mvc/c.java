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
import com.baidu.adp.widget.ListView.o;
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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.c.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BdUniqueId afZ;
    private int agt = -1;
    private PbListView fcj;
    private View fkZ;
    private PopupWindow fle;
    private View flf;
    private String forumId;
    private boolean fuJ;
    private boolean fuN;
    private d fuR;
    private TextView fuU;
    private TextView fuV;
    private TextView fuW;
    private TextView fuX;
    private View fuY;
    private NoNetworkView fuZ;
    private BdTypeMultiColumnListView fux;
    private i fvA;
    private com.baidu.tieba.ala.frsgamelive.a.d fvB;
    private TextView fva;
    private TextView fvb;
    private TextView fvc;
    private View fvd;
    private View fve;
    private com.baidu.tieba.frs.gametab.b fvg;
    private View fvz;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.fuN = false;
        this.mPageContext = tbPageContext;
        this.fuJ = z;
        this.afZ = bdUniqueId;
        this.forumId = str;
        this.fuN = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.fuN) {
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
        this.fkZ = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fuU = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fuV = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.fux = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.fux.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.fuZ = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.afZ);
        this.fux.setPullRefresh(this.mPullView);
        this.fcj = new PbListView(this.mPageContext.getPageActivity());
        this.fcj.createView();
        this.fvB = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.fux);
        this.fuV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.buc();
            }
        });
        if (this.fuJ) {
            this.fvg = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.afZ, this.fuJ);
            this.fux.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.fvg.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void qj(int i) {
        if (i == 1) {
            if (this.fuV != null) {
                this.fuV.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fuV != null) {
            this.fuV.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void pN(int i) {
        if (this.fuU != null) {
            this.fuU.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fuV.setVisibility(8);
            } else {
                this.fuV.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.agt != i) {
            this.agt = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        am.setViewTextColor(this.fuU, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fuV, (int) R.color.cp_cont_d);
        this.fux.setContentBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        this.fuV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buc() {
        brW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi(int i) {
        qj(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.fle, this.mPageContext.getPageActivity());
        if (this.fuR != null) {
            this.fuR.qi(i);
        }
    }

    private void bud() {
        if (this.flf == null) {
            this.flf = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fuW = (TextView) this.flf.findViewById(R.id.frs_game_live_hot);
            this.fuX = (TextView) this.flf.findViewById(R.id.frs_game_live_new);
            this.fuY = this.flf.findViewById(R.id.frs_game_live_sort_sepline);
            this.fuW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.qi(1);
                }
            });
            this.fuX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.qi(2);
                }
            });
        }
        if (this.fle == null) {
            this.fle = new PopupWindow(this.mPageContext.getPageActivity());
            this.fle.setContentView(this.flf);
            this.fle.setWidth(-2);
            this.fle.setHeight(-2);
            this.fle.setAnimationStyle(16973826);
            this.fle.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.fle.setOutsideTouchable(true);
            this.fle.setFocusable(true);
            this.fle.setTouchable(true);
            this.fle.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bue();
                }
            });
        }
    }

    private void brW() {
        bud();
        am.setBackgroundResource(this.flf, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.fuW, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fuX, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fuY, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fuW, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fuX, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fuV.getLocationOnScreen(iArr);
        int height = ((View) this.fuV.getParent()).getHeight() - this.fuV.getHeight();
        if (iArr[1] - this.fle.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.fle, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fle, this.rootView, 0, (iArr[0] - (this.fuV.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fuV.getHeight());
        this.fle.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bue() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bui() {
        return this.fux;
    }

    public void a(d dVar) {
        this.fuR = dVar;
    }

    public void completePullRefresh() {
        this.fux.completePullRefresh();
    }

    private void buj() {
        if (this.fvz == null) {
            this.fvz = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.fva = (TextView) this.fvz.findViewById(R.id.frs_game_live_recommand1);
            this.fvb = (TextView) this.fvz.findViewById(R.id.frs_game_live_recommand2);
            this.fvc = (TextView) this.fvz.findViewById(R.id.frs_game_live_recommand3);
            this.fvd = this.fvz.findViewById(R.id.frs_game_live_recommand_line1);
            this.fve = this.fvz.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bub();
    }

    private void bub() {
        am.setViewTextColor(this.fva, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fvb, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fvc, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.fvd, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fve, R.color.cp_bg_line_c);
    }

    public void e(List<o> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            buj();
            this.fkZ.setVisibility(8);
            if (this.fvz != null) {
                this.fux.removeHeaderView(this.fvz);
                this.fux.addHeaderView(this.fvz);
            }
            this.fvB.setDatas(list);
            this.fux.setNextPage(null);
            return;
        }
        if (this.fvz != null) {
            this.fux.removeHeaderView(this.fvz);
        }
        if (list.size() == 0) {
            this.fkZ.setVisibility(8);
            this.fvB.setDatas(list);
            this.fux.setNextPage(null);
            return;
        }
        this.fkZ.setVisibility(0);
        this.fvB.setDatas(list);
        if (z) {
            buf();
        } else {
            bqL();
        }
    }

    public void buf() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.fux.setNextPage(this.fcj);
            }
            this.fcj.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fcj.endLoadData();
        }
    }

    public void bqL() {
        if (this.fvA == null) {
            this.fvA = new i(this.mPageContext.getPageActivity());
            this.fvA.createView();
            this.fvA.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12573").dh("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.fvA.getView().getParent() == null) {
            this.fux.setNextPage(this.fvA);
        }
    }

    public void bqM() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.fux.setNextPage(this.fcj);
            }
            this.fcj.showLoadingViewWithoutEmptyView();
            this.fcj.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.fux.setOnSrollToBottomListener(onScrollToBottomListener);
        this.fcj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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

    public void b(com.baidu.tieba.ala.d dVar) {
        this.fvB.b(dVar);
    }

    public NavigationBar bua() {
        return this.mNavigationBar;
    }

    public void brL() {
        if (this.fux != null && j.isNetWorkAvailable()) {
            this.fux.startPullRefresh();
        }
    }
}
