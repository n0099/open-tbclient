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
    private BdUniqueId MO;
    private int Ni = -1;
    private BdTypeMultiColumnListView eBJ;
    private boolean eBV;
    private boolean eBZ;
    private View eCL;
    private i eCM;
    private com.baidu.tieba.ala.frsgamelive.a.d eCN;
    private d eCd;
    private TextView eCg;
    private TextView eCh;
    private TextView eCi;
    private TextView eCj;
    private View eCk;
    private NoNetworkView eCl;
    private TextView eCm;
    private TextView eCn;
    private TextView eCo;
    private View eCp;
    private View eCq;
    private com.baidu.tieba.frs.gametab.b eCs;
    private PbListView elw;
    private View eui;
    private PopupWindow eun;
    private View euo;
    private String forumId;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.eBZ = false;
        this.mPageContext = tbPageContext;
        this.eBV = z;
        this.MO = bdUniqueId;
        this.forumId = str;
        this.eBZ = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.eBZ) {
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
        this.eui = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.eCg = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.eCh = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.eBJ = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.eBJ.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.eCl = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.MO);
        this.eBJ.setPullRefresh(this.mPullView);
        this.elw = new PbListView(this.mPageContext.getPageActivity());
        this.elw.createView();
        this.eCN = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.eBJ);
        this.eCh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.beO();
            }
        });
        if (this.eBV) {
            this.eCs = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.MO, this.eBV);
            this.eBJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.eCs.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void pj(int i) {
        if (i == 1) {
            if (this.eCh != null) {
                this.eCh.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.eCh != null) {
            this.eCh.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void oP(int i) {
        if (this.eCg != null) {
            this.eCg.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.eCh.setVisibility(8);
            } else {
                this.eCh.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Ni != i) {
            this.Ni = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        am.setViewTextColor(this.eCg, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCh, (int) R.color.cp_cont_d);
        this.eBJ.setContentBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        this.eCh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beO() {
        bdC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi(int i) {
        pj(i);
        g.dismissPopupWindow(this.eun, this.mPageContext.getPageActivity());
        if (this.eCd != null) {
            this.eCd.pi(i);
        }
    }

    private void beP() {
        if (this.euo == null) {
            this.euo = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.eCi = (TextView) this.euo.findViewById(R.id.frs_game_live_hot);
            this.eCj = (TextView) this.euo.findViewById(R.id.frs_game_live_new);
            this.eCk = this.euo.findViewById(R.id.frs_game_live_sort_sepline);
            this.eCi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.pi(1);
                }
            });
            this.eCj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.pi(2);
                }
            });
        }
        if (this.eun == null) {
            this.eun = new PopupWindow(this.mPageContext.getPageActivity());
            this.eun.setContentView(this.euo);
            this.eun.setWidth(-2);
            this.eun.setHeight(-2);
            this.eun.setAnimationStyle(16973826);
            this.eun.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.eun.setOutsideTouchable(true);
            this.eun.setFocusable(true);
            this.eun.setTouchable(true);
            this.eun.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.beQ();
                }
            });
        }
    }

    private void bdC() {
        beP();
        am.setBackgroundResource(this.euo, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.eCi, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eCj, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eCk, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eCi, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.eCj, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.eCh.getLocationOnScreen(iArr);
        int height = ((View) this.eCh.getParent()).getHeight() - this.eCh.getHeight();
        if (iArr[1] - this.eun.getHeight() <= 50) {
            g.dismissPopupWindow(this.eun, this.mPageContext.getPageActivity());
            return;
        }
        g.showPopupWindowAtLocation(this.eun, this.rootView, 0, (iArr[0] - (this.eCh.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.eCh.getHeight());
        this.eun.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beQ() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView beV() {
        return this.eBJ;
    }

    public void a(d dVar) {
        this.eCd = dVar;
    }

    public void completePullRefresh() {
        this.eBJ.completePullRefresh();
    }

    private void beW() {
        if (this.eCL == null) {
            this.eCL = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.eCm = (TextView) this.eCL.findViewById(R.id.frs_game_live_recommand1);
            this.eCn = (TextView) this.eCL.findViewById(R.id.frs_game_live_recommand2);
            this.eCo = (TextView) this.eCL.findViewById(R.id.frs_game_live_recommand3);
            this.eCp = this.eCL.findViewById(R.id.frs_game_live_recommand_line1);
            this.eCq = this.eCL.findViewById(R.id.frs_game_live_recommand_line2);
        }
        beN();
    }

    private void beN() {
        am.setViewTextColor(this.eCm, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCn, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCo, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.eCp, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.eCq, R.color.cp_bg_line_c);
    }

    public void e(List<m> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            beW();
            this.eui.setVisibility(8);
            if (this.eCL != null) {
                this.eBJ.removeHeaderView(this.eCL);
                this.eBJ.addHeaderView(this.eCL);
            }
            this.eCN.setDatas(list);
            this.eBJ.setNextPage(null);
            return;
        }
        if (this.eCL != null) {
            this.eBJ.removeHeaderView(this.eCL);
        }
        if (list.size() == 0) {
            this.eui.setVisibility(8);
            this.eCN.setDatas(list);
            this.eBJ.setNextPage(null);
            return;
        }
        this.eui.setVisibility(0);
        this.eCN.setDatas(list);
        if (z) {
            beR();
        } else {
            bcu();
        }
    }

    public void beR() {
        if (this.elw != null) {
            if (this.elw.getView().getParent() == null) {
                this.eBJ.setNextPage(this.elw);
            }
            this.elw.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.elw.endLoadData();
        }
    }

    public void bcu() {
        if (this.eCM == null) {
            this.eCM = new i(this.mPageContext.getPageActivity());
            this.eCM.createView();
            this.eCM.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12573").cy("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.eCM.getView().getParent() == null) {
            this.eBJ.setNextPage(this.eCM);
        }
    }

    public void bcv() {
        if (this.elw != null) {
            if (this.elw.getView().getParent() == null) {
                this.eBJ.setNextPage(this.elw);
            }
            this.elw.showLoadingViewWithoutEmptyView();
            this.elw.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.eBJ.setOnSrollToBottomListener(onScrollToBottomListener);
        this.elw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.eCN.b(dVar);
    }

    public NavigationBar beM() {
        return this.mNavigationBar;
    }

    public void bdr() {
        if (this.eBJ != null && j.isNetWorkAvailable()) {
            this.eBJ.startPullRefresh();
        }
    }
}
