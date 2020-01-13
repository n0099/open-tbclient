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
    private int MH = -1;
    private BdUniqueId Mm;
    private PbListView ehe;
    private View epJ;
    private PopupWindow epO;
    private View epP;
    private boolean exC;
    private d exG;
    private TextView exJ;
    private TextView exK;
    private TextView exL;
    private TextView exM;
    private View exN;
    private NoNetworkView exO;
    private TextView exP;
    private TextView exQ;
    private TextView exR;
    private View exS;
    private View exT;
    private com.baidu.tieba.frs.gametab.b exV;
    private BdTypeMultiColumnListView exl;
    private boolean exy;
    private View eyq;
    private i eyr;
    private com.baidu.tieba.ala.frsgamelive.a.d eys;
    private String forumId;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.exC = false;
        this.mPageContext = tbPageContext;
        this.exy = z;
        this.Mm = bdUniqueId;
        this.forumId = str;
        this.exC = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.exC) {
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
        this.epJ = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.exJ = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.exK = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.exl = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.exl.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.exO = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.Mm);
        this.exl.setPullRefresh(this.mPullView);
        this.ehe = new PbListView(this.mPageContext.getPageActivity());
        this.ehe.createView();
        this.eys = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.exl);
        this.exK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bcy();
            }
        });
        if (this.exy) {
            this.exV = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.Mm, this.exy);
            this.exl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.exV.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void oT(int i) {
        if (i == 1) {
            if (this.exK != null) {
                this.exK.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.exK != null) {
            this.exK.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void oy(int i) {
        if (this.exJ != null) {
            this.exJ.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.exK.setVisibility(8);
            } else {
                this.exK.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.MH != i) {
            this.MH = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        am.setViewTextColor(this.exJ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.exK, (int) R.color.cp_cont_d);
        this.exl.setContentBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        this.exK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcy() {
        bbk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oS(int i) {
        oT(i);
        g.dismissPopupWindow(this.epO, this.mPageContext.getPageActivity());
        if (this.exG != null) {
            this.exG.oS(i);
        }
    }

    private void bcz() {
        if (this.epP == null) {
            this.epP = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.exL = (TextView) this.epP.findViewById(R.id.frs_game_live_hot);
            this.exM = (TextView) this.epP.findViewById(R.id.frs_game_live_new);
            this.exN = this.epP.findViewById(R.id.frs_game_live_sort_sepline);
            this.exL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.oS(1);
                }
            });
            this.exM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.oS(2);
                }
            });
        }
        if (this.epO == null) {
            this.epO = new PopupWindow(this.mPageContext.getPageActivity());
            this.epO.setContentView(this.epP);
            this.epO.setWidth(-2);
            this.epO.setHeight(-2);
            this.epO.setAnimationStyle(16973826);
            this.epO.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.epO.setOutsideTouchable(true);
            this.epO.setFocusable(true);
            this.epO.setTouchable(true);
            this.epO.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bcA();
                }
            });
        }
    }

    private void bbk() {
        bcz();
        am.setBackgroundResource(this.epP, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.exL, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.exM, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.exN, R.color.cp_bg_line_c);
        am.setViewTextColor(this.exL, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.exM, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.exK.getLocationOnScreen(iArr);
        int height = ((View) this.exK.getParent()).getHeight() - this.exK.getHeight();
        if (iArr[1] - this.epO.getHeight() <= 50) {
            g.dismissPopupWindow(this.epO, this.mPageContext.getPageActivity());
            return;
        }
        g.showPopupWindowAtLocation(this.epO, this.rootView, 0, (iArr[0] - (this.exK.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.exK.getHeight());
        this.epO.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcA() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bcF() {
        return this.exl;
    }

    public void a(d dVar) {
        this.exG = dVar;
    }

    public void completePullRefresh() {
        this.exl.completePullRefresh();
    }

    private void bcG() {
        if (this.eyq == null) {
            this.eyq = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.exP = (TextView) this.eyq.findViewById(R.id.frs_game_live_recommand1);
            this.exQ = (TextView) this.eyq.findViewById(R.id.frs_game_live_recommand2);
            this.exR = (TextView) this.eyq.findViewById(R.id.frs_game_live_recommand3);
            this.exS = this.eyq.findViewById(R.id.frs_game_live_recommand_line1);
            this.exT = this.eyq.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bcx();
    }

    private void bcx() {
        am.setViewTextColor(this.exP, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.exQ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.exR, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.exS, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.exT, R.color.cp_bg_line_c);
    }

    public void e(List<m> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bcG();
            this.epJ.setVisibility(8);
            if (this.eyq != null) {
                this.exl.removeHeaderView(this.eyq);
                this.exl.addHeaderView(this.eyq);
            }
            this.eys.setDatas(list);
            this.exl.setNextPage(null);
            return;
        }
        if (this.eyq != null) {
            this.exl.removeHeaderView(this.eyq);
        }
        if (list.size() == 0) {
            this.epJ.setVisibility(8);
            this.eys.setDatas(list);
            this.exl.setNextPage(null);
            return;
        }
        this.epJ.setVisibility(0);
        this.eys.setDatas(list);
        if (z) {
            bcB();
        } else {
            bab();
        }
    }

    public void bcB() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.exl.setNextPage(this.ehe);
            }
            this.ehe.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.ehe.endLoadData();
        }
    }

    public void bab() {
        if (this.eyr == null) {
            this.eyr = new i(this.mPageContext.getPageActivity());
            this.eyr.createView();
            this.eyr.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12573").cp("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.eyr.getView().getParent() == null) {
            this.exl.setNextPage(this.eyr);
        }
    }

    public void bac() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.exl.setNextPage(this.ehe);
            }
            this.ehe.showLoadingViewWithoutEmptyView();
            this.ehe.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.exl.setOnSrollToBottomListener(onScrollToBottomListener);
        this.ehe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.eys.b(dVar);
    }

    public NavigationBar bcw() {
        return this.mNavigationBar;
    }

    public void baZ() {
        if (this.exl != null && j.isNetWorkAvailable()) {
            this.exl.startPullRefresh();
        }
    }
}
