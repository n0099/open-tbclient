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
    private boolean eBI;
    private boolean eBM;
    private d eBQ;
    private TextView eBT;
    private TextView eBU;
    private TextView eBV;
    private TextView eBW;
    private View eBX;
    private NoNetworkView eBY;
    private TextView eBZ;
    private BdTypeMultiColumnListView eBw;
    private com.baidu.tieba.ala.frsgamelive.a.d eCA;
    private TextView eCa;
    private TextView eCb;
    private View eCc;
    private View eCd;
    private com.baidu.tieba.frs.gametab.b eCf;
    private View eCy;
    private i eCz;
    private PbListView elj;
    private View etV;
    private PopupWindow eua;
    private View eub;
    private String forumId;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.eBM = false;
        this.mPageContext = tbPageContext;
        this.eBI = z;
        this.MO = bdUniqueId;
        this.forumId = str;
        this.eBM = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.eBM) {
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
        this.etV = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.eBT = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.eBU = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.eBw = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.eBw.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.eBY = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.MO);
        this.eBw.setPullRefresh(this.mPullView);
        this.elj = new PbListView(this.mPageContext.getPageActivity());
        this.elj.createView();
        this.eCA = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.eBw);
        this.eBU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.beN();
            }
        });
        if (this.eBI) {
            this.eCf = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.MO, this.eBI);
            this.eBw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.eCf.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void pj(int i) {
        if (i == 1) {
            if (this.eBU != null) {
                this.eBU.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.eBU != null) {
            this.eBU.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void oP(int i) {
        if (this.eBT != null) {
            this.eBT.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.eBU.setVisibility(8);
            } else {
                this.eBU.setVisibility(0);
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
        am.setViewTextColor(this.eBT, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eBU, (int) R.color.cp_cont_d);
        this.eBw.setContentBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        this.eBU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beN() {
        bdB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi(int i) {
        pj(i);
        g.dismissPopupWindow(this.eua, this.mPageContext.getPageActivity());
        if (this.eBQ != null) {
            this.eBQ.pi(i);
        }
    }

    private void beO() {
        if (this.eub == null) {
            this.eub = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.eBV = (TextView) this.eub.findViewById(R.id.frs_game_live_hot);
            this.eBW = (TextView) this.eub.findViewById(R.id.frs_game_live_new);
            this.eBX = this.eub.findViewById(R.id.frs_game_live_sort_sepline);
            this.eBV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.pi(1);
                }
            });
            this.eBW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.pi(2);
                }
            });
        }
        if (this.eua == null) {
            this.eua = new PopupWindow(this.mPageContext.getPageActivity());
            this.eua.setContentView(this.eub);
            this.eua.setWidth(-2);
            this.eua.setHeight(-2);
            this.eua.setAnimationStyle(16973826);
            this.eua.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.eua.setOutsideTouchable(true);
            this.eua.setFocusable(true);
            this.eua.setTouchable(true);
            this.eua.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.beP();
                }
            });
        }
    }

    private void bdB() {
        beO();
        am.setBackgroundResource(this.eub, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.eBV, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eBW, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eBX, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eBV, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.eBW, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.eBU.getLocationOnScreen(iArr);
        int height = ((View) this.eBU.getParent()).getHeight() - this.eBU.getHeight();
        if (iArr[1] - this.eua.getHeight() <= 50) {
            g.dismissPopupWindow(this.eua, this.mPageContext.getPageActivity());
            return;
        }
        g.showPopupWindowAtLocation(this.eua, this.rootView, 0, (iArr[0] - (this.eBU.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.eBU.getHeight());
        this.eua.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beP() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView beU() {
        return this.eBw;
    }

    public void a(d dVar) {
        this.eBQ = dVar;
    }

    public void completePullRefresh() {
        this.eBw.completePullRefresh();
    }

    private void beV() {
        if (this.eCy == null) {
            this.eCy = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.eBZ = (TextView) this.eCy.findViewById(R.id.frs_game_live_recommand1);
            this.eCa = (TextView) this.eCy.findViewById(R.id.frs_game_live_recommand2);
            this.eCb = (TextView) this.eCy.findViewById(R.id.frs_game_live_recommand3);
            this.eCc = this.eCy.findViewById(R.id.frs_game_live_recommand_line1);
            this.eCd = this.eCy.findViewById(R.id.frs_game_live_recommand_line2);
        }
        beM();
    }

    private void beM() {
        am.setViewTextColor(this.eBZ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCa, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCb, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.eCc, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.eCd, R.color.cp_bg_line_c);
    }

    public void e(List<m> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            beV();
            this.etV.setVisibility(8);
            if (this.eCy != null) {
                this.eBw.removeHeaderView(this.eCy);
                this.eBw.addHeaderView(this.eCy);
            }
            this.eCA.setDatas(list);
            this.eBw.setNextPage(null);
            return;
        }
        if (this.eCy != null) {
            this.eBw.removeHeaderView(this.eCy);
        }
        if (list.size() == 0) {
            this.etV.setVisibility(8);
            this.eCA.setDatas(list);
            this.eBw.setNextPage(null);
            return;
        }
        this.etV.setVisibility(0);
        this.eCA.setDatas(list);
        if (z) {
            beQ();
        } else {
            bct();
        }
    }

    public void beQ() {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.eBw.setNextPage(this.elj);
            }
            this.elj.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.elj.endLoadData();
        }
    }

    public void bct() {
        if (this.eCz == null) {
            this.eCz = new i(this.mPageContext.getPageActivity());
            this.eCz.createView();
            this.eCz.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12573").cy("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.eCz.getView().getParent() == null) {
            this.eBw.setNextPage(this.eCz);
        }
    }

    public void bcu() {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.eBw.setNextPage(this.elj);
            }
            this.elj.showLoadingViewWithoutEmptyView();
            this.elj.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.eBw.setOnSrollToBottomListener(onScrollToBottomListener);
        this.elj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.eCA.b(dVar);
    }

    public NavigationBar beL() {
        return this.mNavigationBar;
    }

    public void bdq() {
        if (this.eBw != null && j.isNetWorkAvailable()) {
            this.eBw.startPullRefresh();
        }
    }
}
