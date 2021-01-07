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
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.widget.multicolumn.BdMultiColumnListView;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    private BdUniqueId ahE;
    private int akW = -1;
    private String forumId;
    private PbListView gCf;
    private View gLh;
    private PopupWindow gLm;
    private View gLn;
    private BdTypeMultiColumnListView gWU;
    private View gXA;
    private View gXB;
    private com.baidu.tieba.frs.gametab.b gXD;
    private View gXW;
    private com.baidu.tieba.ala.frsgamelive.view.c gXX;
    private com.baidu.tieba.ala.frsgamelive.a.d gXY;
    private boolean gXg;
    private boolean gXk;
    private d gXo;
    private TextView gXr;
    private TextView gXs;
    private TextView gXt;
    private TextView gXu;
    private View gXv;
    private NoNetworkView gXw;
    private TextView gXx;
    private TextView gXy;
    private TextView gXz;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.gXk = false;
        this.mPageContext = tbPageContext;
        this.gXg = z;
        this.ahE = bdUniqueId;
        this.forumId = str;
        this.gXk = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.gXk) {
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
        this.gLh = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gXr = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gXs = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gWU = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.gWU.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.gXw = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.ahE);
        this.gWU.setPullRefresh(this.mPullView);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.createView();
        this.gXY = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.gWU);
        this.gXs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bYt();
            }
        });
        if (this.gXg) {
            this.gXD = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.ahE, this.gXg);
            this.gWU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gXD.i(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void vT(int i) {
        if (i == 1) {
            if (this.gXs != null) {
                this.gXs.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gXs != null) {
            this.gXs.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void vt(int i) {
        if (this.gXr != null) {
            this.gXr.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gXs.setVisibility(8);
            } else {
                this.gXs.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akW != i) {
            this.akW = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        ao.setViewTextColor(this.gXr, R.color.CAM_X0109);
        ao.setViewTextColor(this.gXs, R.color.CAM_X0109);
        this.gWU.setContentBackgroundColor(ao.getColor(R.color.CAM_X0201));
        this.gXs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYt() {
        bVO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(int i) {
        vT(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gLm, this.mPageContext.getPageActivity());
        if (this.gXo != null) {
            this.gXo.vS(i);
        }
    }

    private void bYu() {
        if (this.gLn == null) {
            this.gLn = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gXt = (TextView) this.gLn.findViewById(R.id.frs_game_live_hot);
            this.gXu = (TextView) this.gLn.findViewById(R.id.frs_game_live_new);
            this.gXv = this.gLn.findViewById(R.id.frs_game_live_sort_sepline);
            this.gXt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.vS(1);
                }
            });
            this.gXu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.vS(2);
                }
            });
        }
        if (this.gLm == null) {
            this.gLm = new PopupWindow(this.mPageContext.getPageActivity());
            this.gLm.setContentView(this.gLn);
            this.gLm.setWidth(-2);
            this.gLm.setHeight(-2);
            this.gLm.setAnimationStyle(16973826);
            this.gLm.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gLm.setOutsideTouchable(true);
            this.gLm.setFocusable(true);
            this.gLm.setTouchable(true);
            this.gLm.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bYv();
                }
            });
        }
    }

    private void bVO() {
        bYu();
        ao.setBackgroundResource(this.gLn, R.drawable.bg_ala_frs_game_live_sort_panel);
        ao.setBackgroundResource(this.gXt, R.drawable.ala_frs_game_live_sort_selecor);
        ao.setBackgroundResource(this.gXu, R.drawable.ala_frs_game_live_sort_selecor);
        ao.setBackgroundResource(this.gXv, R.color.CAM_X0204);
        ao.setViewTextColor(this.gXt, R.color.CAM_X0106);
        ao.setViewTextColor(this.gXu, R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gXs.getLocationOnScreen(iArr);
        int height = ((View) this.gXs.getParent()).getHeight() - this.gXs.getHeight();
        if (iArr[1] - this.gLm.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gLm, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gLm, this.rootView, 0, (iArr[0] - (this.gXs.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gXs.getHeight());
        this.gLm.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYv() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bYz() {
        return this.gWU;
    }

    public void a(d dVar) {
        this.gXo = dVar;
    }

    public void completePullRefresh() {
        this.gWU.completePullRefresh();
    }

    private void bYA() {
        if (this.gXW == null) {
            this.gXW = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.gXx = (TextView) this.gXW.findViewById(R.id.frs_game_live_recommand1);
            this.gXy = (TextView) this.gXW.findViewById(R.id.frs_game_live_recommand2);
            this.gXz = (TextView) this.gXW.findViewById(R.id.frs_game_live_recommand3);
            this.gXA = this.gXW.findViewById(R.id.frs_game_live_recommand_line1);
            this.gXB = this.gXW.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bYs();
    }

    private void bYs() {
        ao.setViewTextColor(this.gXx, R.color.CAM_X0109);
        ao.setViewTextColor(this.gXy, R.color.CAM_X0109);
        ao.setViewTextColor(this.gXz, R.color.CAM_X0109);
        ao.setBackgroundResource(this.gXA, R.color.CAM_X0204);
        ao.setBackgroundResource(this.gXB, R.color.CAM_X0204);
    }

    public void d(List<n> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bYA();
            this.gLh.setVisibility(8);
            if (this.gXW != null) {
                this.gWU.removeHeaderView(this.gXW);
                this.gWU.addHeaderView(this.gXW);
            }
            this.gXY.setDatas(list);
            this.gWU.setNextPage(null);
            return;
        }
        if (this.gXW != null) {
            this.gWU.removeHeaderView(this.gXW);
        }
        if (list.size() == 0) {
            this.gLh.setVisibility(8);
            this.gXY.setDatas(list);
            this.gWU.setNextPage(null);
            return;
        }
        this.gLh.setVisibility(0);
        this.gXY.setDatas(list);
        if (z) {
            bYw();
        } else {
            bUE();
        }
    }

    public void bYw() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gWU.setNextPage(this.gCf);
            }
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gCf.endLoadData();
        }
    }

    public void bUE() {
        if (this.gXX == null) {
            this.gXX = new com.baidu.tieba.ala.frsgamelive.view.c(this.mPageContext.getPageActivity());
            this.gXX.createView();
            this.gXX.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c12573").dX("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.gXX.getView().getParent() == null) {
            this.gWU.setNextPage(this.gXX);
        }
    }

    public void bUF() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gWU.setNextPage(this.gCf);
            }
            this.gCf.showLoadingViewWithoutEmptyView();
            this.gCf.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.gWU.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gCf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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

    public void b(com.baidu.tieba.ala.g gVar) {
        this.gXY.b(gVar);
    }

    public NavigationBar bYr() {
        return this.mNavigationBar;
    }

    public void bVF() {
        if (this.gWU != null && j.isNetWorkAvailable()) {
            this.gWU.startPullRefresh();
        }
    }
}
