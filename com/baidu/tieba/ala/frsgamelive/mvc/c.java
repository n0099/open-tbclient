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
/* loaded from: classes2.dex */
public class c {
    private int MA = -1;
    private BdUniqueId Mh;
    private PbListView egU;
    private PopupWindow eoB;
    private View eoC;
    private View eow;
    private TextView ewA;
    private View ewB;
    private NoNetworkView ewC;
    private TextView ewD;
    private TextView ewE;
    private TextView ewF;
    private View ewG;
    private View ewH;
    private com.baidu.tieba.frs.gametab.b ewJ;
    private BdTypeMultiColumnListView ewa;
    private boolean ewm;
    private boolean ewq;
    private d ewu;
    private TextView ewx;
    private TextView ewy;
    private TextView ewz;
    private View exc;
    private i exd;
    private com.baidu.tieba.ala.frsgamelive.a.d exe;
    private String forumId;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.ewq = false;
        this.mPageContext = tbPageContext;
        this.ewm = z;
        this.Mh = bdUniqueId;
        this.forumId = str;
        this.ewq = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.ewq) {
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
        this.eow = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.ewx = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.ewy = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.ewa = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.ewa.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.ewC = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.Mh);
        this.ewa.setPullRefresh(this.mPullView);
        this.egU = new PbListView(this.mPageContext.getPageActivity());
        this.egU.createView();
        this.exe = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.ewa);
        this.ewy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bcd();
            }
        });
        if (this.ewm) {
            this.ewJ = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.Mh, this.ewm);
            this.ewa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.ewJ.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void oS(int i) {
        if (i == 1) {
            if (this.ewy != null) {
                this.ewy.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.ewy != null) {
            this.ewy.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void ox(int i) {
        if (this.ewx != null) {
            this.ewx.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.ewy.setVisibility(8);
            } else {
                this.ewy.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.MA != i) {
            this.MA = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        am.setViewTextColor(this.ewx, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.ewy, (int) R.color.cp_cont_d);
        this.ewa.setContentBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        this.ewy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcd() {
        baP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR(int i) {
        oS(i);
        g.dismissPopupWindow(this.eoB, this.mPageContext.getPageActivity());
        if (this.ewu != null) {
            this.ewu.oR(i);
        }
    }

    private void bce() {
        if (this.eoC == null) {
            this.eoC = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.ewz = (TextView) this.eoC.findViewById(R.id.frs_game_live_hot);
            this.ewA = (TextView) this.eoC.findViewById(R.id.frs_game_live_new);
            this.ewB = this.eoC.findViewById(R.id.frs_game_live_sort_sepline);
            this.ewz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.oR(1);
                }
            });
            this.ewA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.oR(2);
                }
            });
        }
        if (this.eoB == null) {
            this.eoB = new PopupWindow(this.mPageContext.getPageActivity());
            this.eoB.setContentView(this.eoC);
            this.eoB.setWidth(-2);
            this.eoB.setHeight(-2);
            this.eoB.setAnimationStyle(16973826);
            this.eoB.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.eoB.setOutsideTouchable(true);
            this.eoB.setFocusable(true);
            this.eoB.setTouchable(true);
            this.eoB.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bcf();
                }
            });
        }
    }

    private void baP() {
        bce();
        am.setBackgroundResource(this.eoC, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.ewz, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.ewA, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.ewB, R.color.cp_bg_line_c);
        am.setViewTextColor(this.ewz, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.ewA, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.ewy.getLocationOnScreen(iArr);
        int height = ((View) this.ewy.getParent()).getHeight() - this.ewy.getHeight();
        if (iArr[1] - this.eoB.getHeight() <= 50) {
            g.dismissPopupWindow(this.eoB, this.mPageContext.getPageActivity());
            return;
        }
        g.showPopupWindowAtLocation(this.eoB, this.rootView, 0, (iArr[0] - (this.ewy.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.ewy.getHeight());
        this.eoB.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcf() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bck() {
        return this.ewa;
    }

    public void a(d dVar) {
        this.ewu = dVar;
    }

    public void completePullRefresh() {
        this.ewa.completePullRefresh();
    }

    private void bcl() {
        if (this.exc == null) {
            this.exc = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.ewD = (TextView) this.exc.findViewById(R.id.frs_game_live_recommand1);
            this.ewE = (TextView) this.exc.findViewById(R.id.frs_game_live_recommand2);
            this.ewF = (TextView) this.exc.findViewById(R.id.frs_game_live_recommand3);
            this.ewG = this.exc.findViewById(R.id.frs_game_live_recommand_line1);
            this.ewH = this.exc.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bcc();
    }

    private void bcc() {
        am.setViewTextColor(this.ewD, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.ewE, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.ewF, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.ewG, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.ewH, R.color.cp_bg_line_c);
    }

    public void e(List<m> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bcl();
            this.eow.setVisibility(8);
            if (this.exc != null) {
                this.ewa.removeHeaderView(this.exc);
                this.ewa.addHeaderView(this.exc);
            }
            this.exe.setDatas(list);
            this.ewa.setNextPage(null);
            return;
        }
        if (this.exc != null) {
            this.ewa.removeHeaderView(this.exc);
        }
        if (list.size() == 0) {
            this.eow.setVisibility(8);
            this.exe.setDatas(list);
            this.ewa.setNextPage(null);
            return;
        }
        this.eow.setVisibility(0);
        this.exe.setDatas(list);
        if (z) {
            bcg();
        } else {
            aZG();
        }
    }

    public void bcg() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.ewa.setNextPage(this.egU);
            }
            this.egU.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.egU.endLoadData();
        }
    }

    public void aZG() {
        if (this.exd == null) {
            this.exd = new i(this.mPageContext.getPageActivity());
            this.exd.createView();
            this.exd.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12573").cp("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.exd.getView().getParent() == null) {
            this.ewa.setNextPage(this.exd);
        }
    }

    public void aZH() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.ewa.setNextPage(this.egU);
            }
            this.egU.showLoadingViewWithoutEmptyView();
            this.egU.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.ewa.setOnSrollToBottomListener(onScrollToBottomListener);
        this.egU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.exe.b(dVar);
    }

    public NavigationBar bcb() {
        return this.mNavigationBar;
    }

    public void baE() {
        if (this.ewa != null && j.isNetWorkAvailable()) {
            this.ewa.startPullRefresh();
        }
    }
}
