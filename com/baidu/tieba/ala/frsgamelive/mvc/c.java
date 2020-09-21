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
    private int aiX = -1;
    private BdUniqueId aih;
    private PbListView fHm;
    private View fQd;
    private PopupWindow fQi;
    private View fQj;
    private String forumId;
    private boolean gaE;
    private boolean gaI;
    private d gaM;
    private TextView gaP;
    private TextView gaQ;
    private TextView gaR;
    private TextView gaS;
    private View gaT;
    private NoNetworkView gaU;
    private TextView gaV;
    private TextView gaW;
    private TextView gaX;
    private View gaY;
    private View gaZ;
    private BdTypeMultiColumnListView gas;
    private com.baidu.tieba.frs.gametab.b gbb;
    private View gbu;
    private i gbv;
    private com.baidu.tieba.ala.frsgamelive.a.d gbw;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.gaI = false;
        this.mPageContext = tbPageContext;
        this.gaE = z;
        this.aih = bdUniqueId;
        this.forumId = str;
        this.gaI = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.gaI) {
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
        this.fQd = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gaP = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gaQ = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gas = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.gas.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.gaU = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.aih);
        this.gas.setPullRefresh(this.mPullView);
        this.fHm = new PbListView(this.mPageContext.getPageActivity());
        this.fHm.createView();
        this.gbw = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.gas);
        this.gaQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bKU();
            }
        });
        if (this.gaE) {
            this.gbb = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.aih, this.gaE);
            this.gas.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gbb.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void tD(int i) {
        if (i == 1) {
            if (this.gaQ != null) {
                this.gaQ.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gaQ != null) {
            this.gaQ.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void tf(int i) {
        if (this.gaP != null) {
            this.gaP.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gaQ.setVisibility(8);
            } else {
                this.gaQ.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aiX != i) {
            this.aiX = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        ap.setViewTextColor(this.gaP, R.color.cp_cont_d);
        ap.setViewTextColor(this.gaQ, R.color.cp_cont_d);
        this.gas.setContentBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
        this.gaQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKU() {
        bIs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tC(int i) {
        tD(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.fQi, this.mPageContext.getPageActivity());
        if (this.gaM != null) {
            this.gaM.tC(i);
        }
    }

    private void bKV() {
        if (this.fQj == null) {
            this.fQj = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gaR = (TextView) this.fQj.findViewById(R.id.frs_game_live_hot);
            this.gaS = (TextView) this.fQj.findViewById(R.id.frs_game_live_new);
            this.gaT = this.fQj.findViewById(R.id.frs_game_live_sort_sepline);
            this.gaR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.tC(1);
                }
            });
            this.gaS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.tC(2);
                }
            });
        }
        if (this.fQi == null) {
            this.fQi = new PopupWindow(this.mPageContext.getPageActivity());
            this.fQi.setContentView(this.fQj);
            this.fQi.setWidth(-2);
            this.fQi.setHeight(-2);
            this.fQi.setAnimationStyle(16973826);
            this.fQi.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.fQi.setOutsideTouchable(true);
            this.fQi.setFocusable(true);
            this.fQi.setTouchable(true);
            this.fQi.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bKW();
                }
            });
        }
    }

    private void bIs() {
        bKV();
        ap.setBackgroundResource(this.fQj, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gaR, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gaS, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gaT, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.gaR, R.color.cp_cont_f);
        ap.setViewTextColor(this.gaS, R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.gaQ.getLocationOnScreen(iArr);
        int height = ((View) this.gaQ.getParent()).getHeight() - this.gaQ.getHeight();
        if (iArr[1] - this.fQi.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.fQi, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fQi, this.rootView, 0, (iArr[0] - (this.gaQ.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gaQ.getHeight());
        this.fQi.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKW() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bLa() {
        return this.gas;
    }

    public void a(d dVar) {
        this.gaM = dVar;
    }

    public void completePullRefresh() {
        this.gas.completePullRefresh();
    }

    private void bLb() {
        if (this.gbu == null) {
            this.gbu = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.gaV = (TextView) this.gbu.findViewById(R.id.frs_game_live_recommand1);
            this.gaW = (TextView) this.gbu.findViewById(R.id.frs_game_live_recommand2);
            this.gaX = (TextView) this.gbu.findViewById(R.id.frs_game_live_recommand3);
            this.gaY = this.gbu.findViewById(R.id.frs_game_live_recommand_line1);
            this.gaZ = this.gbu.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bKT();
    }

    private void bKT() {
        ap.setViewTextColor(this.gaV, R.color.cp_cont_d);
        ap.setViewTextColor(this.gaW, R.color.cp_cont_d);
        ap.setViewTextColor(this.gaX, R.color.cp_cont_d);
        ap.setBackgroundResource(this.gaY, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.gaZ, R.color.cp_bg_line_c);
    }

    public void d(List<q> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bLb();
            this.fQd.setVisibility(8);
            if (this.gbu != null) {
                this.gas.removeHeaderView(this.gbu);
                this.gas.addHeaderView(this.gbu);
            }
            this.gbw.setDatas(list);
            this.gas.setNextPage(null);
            return;
        }
        if (this.gbu != null) {
            this.gas.removeHeaderView(this.gbu);
        }
        if (list.size() == 0) {
            this.fQd.setVisibility(8);
            this.gbw.setDatas(list);
            this.gas.setNextPage(null);
            return;
        }
        this.fQd.setVisibility(0);
        this.gbw.setDatas(list);
        if (z) {
            bKX();
        } else {
            bHi();
        }
    }

    public void bKX() {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.gas.setNextPage(this.fHm);
            }
            this.fHm.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fHm.endLoadData();
        }
    }

    public void bHi() {
        if (this.gbv == null) {
            this.gbv = new i(this.mPageContext.getPageActivity());
            this.gbv.createView();
            this.gbv.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c12573").dF("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.gbv.getView().getParent() == null) {
            this.gas.setNextPage(this.gbv);
        }
    }

    public void bHj() {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.gas.setNextPage(this.fHm);
            }
            this.fHm.showLoadingViewWithoutEmptyView();
            this.fHm.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.gas.setOnSrollToBottomListener(onScrollToBottomListener);
        this.fHm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.gbw.b(fVar);
    }

    public NavigationBar bKS() {
        return this.mNavigationBar;
    }

    public void bIh() {
        if (this.gas != null && j.isNetWorkAvailable()) {
            this.gas.startPullRefresh();
        }
    }
}
