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
    private PbListView fbY;
    private View fkO;
    private PopupWindow fkT;
    private View fkU;
    private String forumId;
    private boolean fuC;
    private d fuG;
    private TextView fuJ;
    private TextView fuK;
    private TextView fuL;
    private TextView fuM;
    private View fuN;
    private NoNetworkView fuO;
    private TextView fuP;
    private TextView fuQ;
    private TextView fuR;
    private View fuS;
    private View fuT;
    private com.baidu.tieba.frs.gametab.b fuV;
    private BdTypeMultiColumnListView fum;
    private boolean fuy;
    private View fvo;
    private i fvp;
    private com.baidu.tieba.ala.frsgamelive.a.d fvq;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.fuC = false;
        this.mPageContext = tbPageContext;
        this.fuy = z;
        this.afZ = bdUniqueId;
        this.forumId = str;
        this.fuC = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.fuC) {
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
        this.fkO = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fuJ = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fuK = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.fum = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.fum.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.fuO = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.afZ);
        this.fum.setPullRefresh(this.mPullView);
        this.fbY = new PbListView(this.mPageContext.getPageActivity());
        this.fbY.createView();
        this.fvq = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.fum);
        this.fuK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bua();
            }
        });
        if (this.fuy) {
            this.fuV = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.afZ, this.fuy);
            this.fum.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.fuV.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void qh(int i) {
        if (i == 1) {
            if (this.fuK != null) {
                this.fuK.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fuK != null) {
            this.fuK.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void pL(int i) {
        if (this.fuJ != null) {
            this.fuJ.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fuK.setVisibility(8);
            } else {
                this.fuK.setVisibility(0);
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
        am.setViewTextColor(this.fuJ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fuK, (int) R.color.cp_cont_d);
        this.fum.setContentBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        this.fuK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bua() {
        brU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(int i) {
        qh(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.fkT, this.mPageContext.getPageActivity());
        if (this.fuG != null) {
            this.fuG.qg(i);
        }
    }

    private void bub() {
        if (this.fkU == null) {
            this.fkU = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fuL = (TextView) this.fkU.findViewById(R.id.frs_game_live_hot);
            this.fuM = (TextView) this.fkU.findViewById(R.id.frs_game_live_new);
            this.fuN = this.fkU.findViewById(R.id.frs_game_live_sort_sepline);
            this.fuL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.qg(1);
                }
            });
            this.fuM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.qg(2);
                }
            });
        }
        if (this.fkT == null) {
            this.fkT = new PopupWindow(this.mPageContext.getPageActivity());
            this.fkT.setContentView(this.fkU);
            this.fkT.setWidth(-2);
            this.fkT.setHeight(-2);
            this.fkT.setAnimationStyle(16973826);
            this.fkT.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.fkT.setOutsideTouchable(true);
            this.fkT.setFocusable(true);
            this.fkT.setTouchable(true);
            this.fkT.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.buc();
                }
            });
        }
    }

    private void brU() {
        bub();
        am.setBackgroundResource(this.fkU, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.fuL, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fuM, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.fuN, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fuL, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fuM, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fuK.getLocationOnScreen(iArr);
        int height = ((View) this.fuK.getParent()).getHeight() - this.fuK.getHeight();
        if (iArr[1] - this.fkT.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.fkT, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fkT, this.rootView, 0, (iArr[0] - (this.fuK.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fuK.getHeight());
        this.fkT.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buc() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bug() {
        return this.fum;
    }

    public void a(d dVar) {
        this.fuG = dVar;
    }

    public void completePullRefresh() {
        this.fum.completePullRefresh();
    }

    private void buh() {
        if (this.fvo == null) {
            this.fvo = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.fuP = (TextView) this.fvo.findViewById(R.id.frs_game_live_recommand1);
            this.fuQ = (TextView) this.fvo.findViewById(R.id.frs_game_live_recommand2);
            this.fuR = (TextView) this.fvo.findViewById(R.id.frs_game_live_recommand3);
            this.fuS = this.fvo.findViewById(R.id.frs_game_live_recommand_line1);
            this.fuT = this.fvo.findViewById(R.id.frs_game_live_recommand_line2);
        }
        btZ();
    }

    private void btZ() {
        am.setViewTextColor(this.fuP, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fuQ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fuR, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.fuS, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fuT, R.color.cp_bg_line_c);
    }

    public void e(List<o> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            buh();
            this.fkO.setVisibility(8);
            if (this.fvo != null) {
                this.fum.removeHeaderView(this.fvo);
                this.fum.addHeaderView(this.fvo);
            }
            this.fvq.setDatas(list);
            this.fum.setNextPage(null);
            return;
        }
        if (this.fvo != null) {
            this.fum.removeHeaderView(this.fvo);
        }
        if (list.size() == 0) {
            this.fkO.setVisibility(8);
            this.fvq.setDatas(list);
            this.fum.setNextPage(null);
            return;
        }
        this.fkO.setVisibility(0);
        this.fvq.setDatas(list);
        if (z) {
            bud();
        } else {
            bqJ();
        }
    }

    public void bud() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.fum.setNextPage(this.fbY);
            }
            this.fbY.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fbY.endLoadData();
        }
    }

    public void bqJ() {
        if (this.fvp == null) {
            this.fvp = new i(this.mPageContext.getPageActivity());
            this.fvp.createView();
            this.fvp.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12573").dh("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.fvp.getView().getParent() == null) {
            this.fum.setNextPage(this.fvp);
        }
    }

    public void bqK() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.fum.setNextPage(this.fbY);
            }
            this.fbY.showLoadingViewWithoutEmptyView();
            this.fbY.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.fum.setOnSrollToBottomListener(onScrollToBottomListener);
        this.fbY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.fvq.b(dVar);
    }

    public NavigationBar btY() {
        return this.mNavigationBar;
    }

    public void brJ() {
        if (this.fum != null && j.isNetWorkAvailable()) {
            this.fum.startPullRefresh();
        }
    }
}
