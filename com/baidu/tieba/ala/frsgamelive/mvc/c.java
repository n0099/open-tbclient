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
    private PbListView gdy;
    private PopupWindow gmE;
    private View gmF;
    private View gmz;
    private BdTypeMultiColumnListView gwO;
    private View gxQ;
    private i gxR;
    private com.baidu.tieba.ala.frsgamelive.a.d gxS;
    private boolean gxa;
    private boolean gxe;
    private d gxi;
    private TextView gxl;
    private TextView gxm;
    private TextView gxn;
    private TextView gxo;
    private View gxp;
    private NoNetworkView gxq;
    private TextView gxr;
    private TextView gxs;
    private TextView gxt;
    private View gxu;
    private View gxv;
    private com.baidu.tieba.frs.gametab.b gxx;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.gxe = false;
        this.mPageContext = tbPageContext;
        this.gxa = z;
        this.aiz = bdUniqueId;
        this.forumId = str;
        this.gxe = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.gxe) {
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
        this.gmz = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gxl = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gxm = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gwO = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.gwO.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.gxq = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.aiz);
        this.gwO.setPullRefresh(this.mPullView);
        this.gdy = new PbListView(this.mPageContext.getPageActivity());
        this.gdy.createView();
        this.gxS = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.gwO);
        this.gxm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bQj();
            }
        });
        if (this.gxa) {
            this.gxx = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.aiz, this.gxa);
            this.gwO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gxx.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void ut(int i) {
        if (i == 1) {
            if (this.gxm != null) {
                this.gxm.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gxm != null) {
            this.gxm.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void tW(int i) {
        if (this.gxl != null) {
            this.gxl.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gxm.setVisibility(8);
            } else {
                this.gxm.setVisibility(0);
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
        ap.setViewTextColor(this.gxl, R.color.cp_cont_d);
        ap.setViewTextColor(this.gxm, R.color.cp_cont_d);
        this.gwO.setContentBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
        this.gxm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQj() {
        bNE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void us(int i) {
        ut(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gmE, this.mPageContext.getPageActivity());
        if (this.gxi != null) {
            this.gxi.us(i);
        }
    }

    private void bQk() {
        if (this.gmF == null) {
            this.gmF = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gxn = (TextView) this.gmF.findViewById(R.id.frs_game_live_hot);
            this.gxo = (TextView) this.gmF.findViewById(R.id.frs_game_live_new);
            this.gxp = this.gmF.findViewById(R.id.frs_game_live_sort_sepline);
            this.gxn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.us(1);
                }
            });
            this.gxo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.us(2);
                }
            });
        }
        if (this.gmE == null) {
            this.gmE = new PopupWindow(this.mPageContext.getPageActivity());
            this.gmE.setContentView(this.gmF);
            this.gmE.setWidth(-2);
            this.gmE.setHeight(-2);
            this.gmE.setAnimationStyle(16973826);
            this.gmE.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gmE.setOutsideTouchable(true);
            this.gmE.setFocusable(true);
            this.gmE.setTouchable(true);
            this.gmE.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bQl();
                }
            });
        }
    }

    private void bNE() {
        bQk();
        ap.setBackgroundResource(this.gmF, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gxn, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gxo, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gxp, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.gxn, R.color.cp_cont_f);
        ap.setViewTextColor(this.gxo, R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.gxm.getLocationOnScreen(iArr);
        int height = ((View) this.gxm.getParent()).getHeight() - this.gxm.getHeight();
        if (iArr[1] - this.gmE.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gmE, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gmE, this.rootView, 0, (iArr[0] - (this.gxm.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gxm.getHeight());
        this.gmE.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQl() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bQp() {
        return this.gwO;
    }

    public void a(d dVar) {
        this.gxi = dVar;
    }

    public void completePullRefresh() {
        this.gwO.completePullRefresh();
    }

    private void bQq() {
        if (this.gxQ == null) {
            this.gxQ = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.gxr = (TextView) this.gxQ.findViewById(R.id.frs_game_live_recommand1);
            this.gxs = (TextView) this.gxQ.findViewById(R.id.frs_game_live_recommand2);
            this.gxt = (TextView) this.gxQ.findViewById(R.id.frs_game_live_recommand3);
            this.gxu = this.gxQ.findViewById(R.id.frs_game_live_recommand_line1);
            this.gxv = this.gxQ.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bQi();
    }

    private void bQi() {
        ap.setViewTextColor(this.gxr, R.color.cp_cont_d);
        ap.setViewTextColor(this.gxs, R.color.cp_cont_d);
        ap.setViewTextColor(this.gxt, R.color.cp_cont_d);
        ap.setBackgroundResource(this.gxu, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.gxv, R.color.cp_bg_line_c);
    }

    public void d(List<q> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bQq();
            this.gmz.setVisibility(8);
            if (this.gxQ != null) {
                this.gwO.removeHeaderView(this.gxQ);
                this.gwO.addHeaderView(this.gxQ);
            }
            this.gxS.setDatas(list);
            this.gwO.setNextPage(null);
            return;
        }
        if (this.gxQ != null) {
            this.gwO.removeHeaderView(this.gxQ);
        }
        if (list.size() == 0) {
            this.gmz.setVisibility(8);
            this.gxS.setDatas(list);
            this.gwO.setNextPage(null);
            return;
        }
        this.gmz.setVisibility(0);
        this.gxS.setDatas(list);
        if (z) {
            bQm();
        } else {
            bMw();
        }
    }

    public void bQm() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.gwO.setNextPage(this.gdy);
            }
            this.gdy.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gdy.endLoadData();
        }
    }

    public void bMw() {
        if (this.gxR == null) {
            this.gxR = new i(this.mPageContext.getPageActivity());
            this.gxR.createView();
            this.gxR.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c12573").dR("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.gxR.getView().getParent() == null) {
            this.gwO.setNextPage(this.gxR);
        }
    }

    public void bMx() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.gwO.setNextPage(this.gdy);
            }
            this.gdy.showLoadingViewWithoutEmptyView();
            this.gdy.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.gwO.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gdy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.gxS.b(fVar);
    }

    public NavigationBar bQh() {
        return this.mNavigationBar;
    }

    public void bNv() {
        if (this.gwO != null && j.isNetWorkAvailable()) {
            this.gwO.startPullRefresh();
        }
    }
}
