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
    private BdUniqueId MP;
    private int Nj = -1;
    private TextView eCC;
    private TextView eCD;
    private TextView eCE;
    private TextView eCF;
    private View eCG;
    private NoNetworkView eCH;
    private TextView eCI;
    private TextView eCJ;
    private TextView eCK;
    private View eCL;
    private View eCM;
    private com.baidu.tieba.frs.gametab.b eCO;
    private BdTypeMultiColumnListView eCf;
    private boolean eCr;
    private boolean eCv;
    private d eCz;
    private View eDh;
    private i eDi;
    private com.baidu.tieba.ala.frsgamelive.a.d eDj;
    private PbListView elM;
    private View euE;
    private PopupWindow euJ;
    private View euK;
    private String forumId;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.eCv = false;
        this.mPageContext = tbPageContext;
        this.eCr = z;
        this.MP = bdUniqueId;
        this.forumId = str;
        this.eCv = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.eCv) {
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
        this.euE = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.eCC = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.eCD = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.eCf = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.eCf.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.eCH = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.MP);
        this.eCf.setPullRefresh(this.mPullView);
        this.elM = new PbListView(this.mPageContext.getPageActivity());
        this.elM.createView();
        this.eDj = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.eCf);
        this.eCD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.beT();
            }
        });
        if (this.eCr) {
            this.eCO = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.MP, this.eCr);
            this.eCf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.eCO.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void pl(int i) {
        if (i == 1) {
            if (this.eCD != null) {
                this.eCD.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.eCD != null) {
            this.eCD.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void oR(int i) {
        if (this.eCC != null) {
            this.eCC.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.eCD.setVisibility(8);
            } else {
                this.eCD.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Nj != i) {
            this.Nj = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        am.setViewTextColor(this.eCC, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCD, (int) R.color.cp_cont_d);
        this.eCf.setContentBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        this.eCD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beT() {
        bdH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pk(int i) {
        pl(i);
        g.dismissPopupWindow(this.euJ, this.mPageContext.getPageActivity());
        if (this.eCz != null) {
            this.eCz.pk(i);
        }
    }

    private void beU() {
        if (this.euK == null) {
            this.euK = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.eCE = (TextView) this.euK.findViewById(R.id.frs_game_live_hot);
            this.eCF = (TextView) this.euK.findViewById(R.id.frs_game_live_new);
            this.eCG = this.euK.findViewById(R.id.frs_game_live_sort_sepline);
            this.eCE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.pk(1);
                }
            });
            this.eCF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.pk(2);
                }
            });
        }
        if (this.euJ == null) {
            this.euJ = new PopupWindow(this.mPageContext.getPageActivity());
            this.euJ.setContentView(this.euK);
            this.euJ.setWidth(-2);
            this.euJ.setHeight(-2);
            this.euJ.setAnimationStyle(16973826);
            this.euJ.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.euJ.setOutsideTouchable(true);
            this.euJ.setFocusable(true);
            this.euJ.setTouchable(true);
            this.euJ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.beV();
                }
            });
        }
    }

    private void bdH() {
        beU();
        am.setBackgroundResource(this.euK, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.eCE, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eCF, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eCG, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eCE, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.eCF, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.eCD.getLocationOnScreen(iArr);
        int height = ((View) this.eCD.getParent()).getHeight() - this.eCD.getHeight();
        if (iArr[1] - this.euJ.getHeight() <= 50) {
            g.dismissPopupWindow(this.euJ, this.mPageContext.getPageActivity());
            return;
        }
        g.showPopupWindowAtLocation(this.euJ, this.rootView, 0, (iArr[0] - (this.eCD.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.eCD.getHeight());
        this.euJ.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beV() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bfa() {
        return this.eCf;
    }

    public void a(d dVar) {
        this.eCz = dVar;
    }

    public void completePullRefresh() {
        this.eCf.completePullRefresh();
    }

    private void bfb() {
        if (this.eDh == null) {
            this.eDh = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.eCI = (TextView) this.eDh.findViewById(R.id.frs_game_live_recommand1);
            this.eCJ = (TextView) this.eDh.findViewById(R.id.frs_game_live_recommand2);
            this.eCK = (TextView) this.eDh.findViewById(R.id.frs_game_live_recommand3);
            this.eCL = this.eDh.findViewById(R.id.frs_game_live_recommand_line1);
            this.eCM = this.eDh.findViewById(R.id.frs_game_live_recommand_line2);
        }
        beS();
    }

    private void beS() {
        am.setViewTextColor(this.eCI, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCJ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCK, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.eCL, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.eCM, R.color.cp_bg_line_c);
    }

    public void e(List<m> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bfb();
            this.euE.setVisibility(8);
            if (this.eDh != null) {
                this.eCf.removeHeaderView(this.eDh);
                this.eCf.addHeaderView(this.eDh);
            }
            this.eDj.setDatas(list);
            this.eCf.setNextPage(null);
            return;
        }
        if (this.eDh != null) {
            this.eCf.removeHeaderView(this.eDh);
        }
        if (list.size() == 0) {
            this.euE.setVisibility(8);
            this.eDj.setDatas(list);
            this.eCf.setNextPage(null);
            return;
        }
        this.euE.setVisibility(0);
        this.eDj.setDatas(list);
        if (z) {
            beW();
        } else {
            bcy();
        }
    }

    public void beW() {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.eCf.setNextPage(this.elM);
            }
            this.elM.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.elM.endLoadData();
        }
    }

    public void bcy() {
        if (this.eDi == null) {
            this.eDi = new i(this.mPageContext.getPageActivity());
            this.eDi.createView();
            this.eDi.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12573").cx("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.eDi.getView().getParent() == null) {
            this.eCf.setNextPage(this.eDi);
        }
    }

    public void bcz() {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.eCf.setNextPage(this.elM);
            }
            this.elM.showLoadingViewWithoutEmptyView();
            this.elM.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.eCf.setOnSrollToBottomListener(onScrollToBottomListener);
        this.elM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.eDj.b(dVar);
    }

    public NavigationBar beR() {
        return this.mNavigationBar;
    }

    public void bdw() {
        if (this.eCf != null && j.isNetWorkAvailable()) {
            this.eCf.startPullRefresh();
        }
    }
}
