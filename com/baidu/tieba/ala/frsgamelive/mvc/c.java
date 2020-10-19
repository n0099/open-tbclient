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
    private BdUniqueId aiy;
    private int ajp = -1;
    private PbListView fTv;
    private String forumId;
    private PopupWindow gcA;
    private View gcB;
    private View gcv;
    private BdTypeMultiColumnListView gmJ;
    private boolean gmV;
    private boolean gmZ;
    private View gnL;
    private i gnM;
    private com.baidu.tieba.ala.frsgamelive.a.d gnN;
    private d gnd;
    private TextView gng;
    private TextView gnh;
    private TextView gni;
    private TextView gnj;
    private View gnk;
    private NoNetworkView gnl;
    private TextView gnm;
    private TextView gnn;
    private TextView gno;
    private View gnp;
    private View gnq;
    private com.baidu.tieba.frs.gametab.b gns;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.gmZ = false;
        this.mPageContext = tbPageContext;
        this.gmV = z;
        this.aiy = bdUniqueId;
        this.forumId = str;
        this.gmZ = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.gmZ) {
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
        this.gcv = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gng = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gnh = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gmJ = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.gmJ.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.gnl = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.aiy);
        this.gmJ.setPullRefresh(this.mPullView);
        this.fTv = new PbListView(this.mPageContext.getPageActivity());
        this.fTv.createView();
        this.gnN = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.gmJ);
        this.gnh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bNE();
            }
        });
        if (this.gmV) {
            this.gns = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.aiy, this.gmV);
            this.gmJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gns.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void ub(int i) {
        if (i == 1) {
            if (this.gnh != null) {
                this.gnh.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gnh != null) {
            this.gnh.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void tD(int i) {
        if (this.gng != null) {
            this.gng.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gnh.setVisibility(8);
            } else {
                this.gnh.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajp != i) {
            this.ajp = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        ap.setViewTextColor(this.gng, R.color.cp_cont_d);
        ap.setViewTextColor(this.gnh, R.color.cp_cont_d);
        this.gmJ.setContentBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
        this.gnh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNE() {
        bLc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ua(int i) {
        ub(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gcA, this.mPageContext.getPageActivity());
        if (this.gnd != null) {
            this.gnd.ua(i);
        }
    }

    private void bNF() {
        if (this.gcB == null) {
            this.gcB = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gni = (TextView) this.gcB.findViewById(R.id.frs_game_live_hot);
            this.gnj = (TextView) this.gcB.findViewById(R.id.frs_game_live_new);
            this.gnk = this.gcB.findViewById(R.id.frs_game_live_sort_sepline);
            this.gni.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.ua(1);
                }
            });
            this.gnj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.ua(2);
                }
            });
        }
        if (this.gcA == null) {
            this.gcA = new PopupWindow(this.mPageContext.getPageActivity());
            this.gcA.setContentView(this.gcB);
            this.gcA.setWidth(-2);
            this.gcA.setHeight(-2);
            this.gcA.setAnimationStyle(16973826);
            this.gcA.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gcA.setOutsideTouchable(true);
            this.gcA.setFocusable(true);
            this.gcA.setTouchable(true);
            this.gcA.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bNG();
                }
            });
        }
    }

    private void bLc() {
        bNF();
        ap.setBackgroundResource(this.gcB, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gni, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gnj, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gnk, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.gni, R.color.cp_cont_f);
        ap.setViewTextColor(this.gnj, R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.gnh.getLocationOnScreen(iArr);
        int height = ((View) this.gnh.getParent()).getHeight() - this.gnh.getHeight();
        if (iArr[1] - this.gcA.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gcA, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gcA, this.rootView, 0, (iArr[0] - (this.gnh.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gnh.getHeight());
        this.gcA.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNG() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bNK() {
        return this.gmJ;
    }

    public void a(d dVar) {
        this.gnd = dVar;
    }

    public void completePullRefresh() {
        this.gmJ.completePullRefresh();
    }

    private void bNL() {
        if (this.gnL == null) {
            this.gnL = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.gnm = (TextView) this.gnL.findViewById(R.id.frs_game_live_recommand1);
            this.gnn = (TextView) this.gnL.findViewById(R.id.frs_game_live_recommand2);
            this.gno = (TextView) this.gnL.findViewById(R.id.frs_game_live_recommand3);
            this.gnp = this.gnL.findViewById(R.id.frs_game_live_recommand_line1);
            this.gnq = this.gnL.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bND();
    }

    private void bND() {
        ap.setViewTextColor(this.gnm, R.color.cp_cont_d);
        ap.setViewTextColor(this.gnn, R.color.cp_cont_d);
        ap.setViewTextColor(this.gno, R.color.cp_cont_d);
        ap.setBackgroundResource(this.gnp, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.gnq, R.color.cp_bg_line_c);
    }

    public void d(List<q> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bNL();
            this.gcv.setVisibility(8);
            if (this.gnL != null) {
                this.gmJ.removeHeaderView(this.gnL);
                this.gmJ.addHeaderView(this.gnL);
            }
            this.gnN.setDatas(list);
            this.gmJ.setNextPage(null);
            return;
        }
        if (this.gnL != null) {
            this.gmJ.removeHeaderView(this.gnL);
        }
        if (list.size() == 0) {
            this.gcv.setVisibility(8);
            this.gnN.setDatas(list);
            this.gmJ.setNextPage(null);
            return;
        }
        this.gcv.setVisibility(0);
        this.gnN.setDatas(list);
        if (z) {
            bNH();
        } else {
            bJU();
        }
    }

    public void bNH() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.gmJ.setNextPage(this.fTv);
            }
            this.fTv.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fTv.endLoadData();
        }
    }

    public void bJU() {
        if (this.gnM == null) {
            this.gnM = new i(this.mPageContext.getPageActivity());
            this.gnM.createView();
            this.gnM.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c12573").dK("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.gnM.getView().getParent() == null) {
            this.gmJ.setNextPage(this.gnM);
        }
    }

    public void bJV() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.gmJ.setNextPage(this.fTv);
            }
            this.fTv.showLoadingViewWithoutEmptyView();
            this.fTv.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.gmJ.setOnSrollToBottomListener(onScrollToBottomListener);
        this.fTv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.gnN.b(fVar);
    }

    public NavigationBar bNC() {
        return this.mNavigationBar;
    }

    public void bKT() {
        if (this.gmJ != null && j.isNetWorkAvailable()) {
            this.gmJ.startPullRefresh();
        }
    }
}
