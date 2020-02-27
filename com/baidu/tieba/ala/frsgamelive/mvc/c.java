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
    private boolean eBH;
    private boolean eBL;
    private d eBP;
    private TextView eBS;
    private TextView eBT;
    private TextView eBU;
    private TextView eBV;
    private View eBW;
    private NoNetworkView eBX;
    private TextView eBY;
    private TextView eBZ;
    private BdTypeMultiColumnListView eBv;
    private TextView eCa;
    private View eCb;
    private View eCc;
    private com.baidu.tieba.frs.gametab.b eCe;
    private View eCx;
    private i eCy;
    private com.baidu.tieba.ala.frsgamelive.a.d eCz;
    private PbListView eli;
    private View etU;
    private PopupWindow etZ;
    private View eua;
    private String forumId;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private h mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.eBL = false;
        this.mPageContext = tbPageContext;
        this.eBH = z;
        this.MO = bdUniqueId;
        this.forumId = str;
        this.eBL = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.eBL) {
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
        this.etU = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.eBS = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.eBT = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.eBv = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.eBv.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.eBX = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.MO);
        this.eBv.setPullRefresh(this.mPullView);
        this.eli = new PbListView(this.mPageContext.getPageActivity());
        this.eli.createView();
        this.eCz = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.eBv);
        this.eBT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.beL();
            }
        });
        if (this.eBH) {
            this.eCe = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.MO, this.eBH);
            this.eBv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.eCe.c(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void pj(int i) {
        if (i == 1) {
            if (this.eBT != null) {
                this.eBT.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.eBT != null) {
            this.eBT.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void oP(int i) {
        if (this.eBS != null) {
            this.eBS.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, aq.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.eBT.setVisibility(8);
            } else {
                this.eBT.setVisibility(0);
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
        am.setViewTextColor(this.eBS, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eBT, (int) R.color.cp_cont_d);
        this.eBv.setContentBackgroundColor(am.getColor(R.color.cp_bg_line_d));
        this.eBT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beL() {
        bdz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi(int i) {
        pj(i);
        g.dismissPopupWindow(this.etZ, this.mPageContext.getPageActivity());
        if (this.eBP != null) {
            this.eBP.pi(i);
        }
    }

    private void beM() {
        if (this.eua == null) {
            this.eua = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.eBU = (TextView) this.eua.findViewById(R.id.frs_game_live_hot);
            this.eBV = (TextView) this.eua.findViewById(R.id.frs_game_live_new);
            this.eBW = this.eua.findViewById(R.id.frs_game_live_sort_sepline);
            this.eBU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.pi(1);
                }
            });
            this.eBV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.pi(2);
                }
            });
        }
        if (this.etZ == null) {
            this.etZ = new PopupWindow(this.mPageContext.getPageActivity());
            this.etZ.setContentView(this.eua);
            this.etZ.setWidth(-2);
            this.etZ.setHeight(-2);
            this.etZ.setAnimationStyle(16973826);
            this.etZ.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.etZ.setOutsideTouchable(true);
            this.etZ.setFocusable(true);
            this.etZ.setTouchable(true);
            this.etZ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.beN();
                }
            });
        }
    }

    private void bdz() {
        beM();
        am.setBackgroundResource(this.eua, R.drawable.bg_ala_frs_game_live_sort_panel);
        am.setBackgroundResource(this.eBU, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eBV, R.drawable.ala_frs_game_live_sort_selecor);
        am.setBackgroundResource(this.eBW, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eBU, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.eBV, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.eBT.getLocationOnScreen(iArr);
        int height = ((View) this.eBT.getParent()).getHeight() - this.eBT.getHeight();
        if (iArr[1] - this.etZ.getHeight() <= 50) {
            g.dismissPopupWindow(this.etZ, this.mPageContext.getPageActivity());
            return;
        }
        g.showPopupWindowAtLocation(this.etZ, this.rootView, 0, (iArr[0] - (this.eBT.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.eBT.getHeight());
        this.etZ.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beN() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView beS() {
        return this.eBv;
    }

    public void a(d dVar) {
        this.eBP = dVar;
    }

    public void completePullRefresh() {
        this.eBv.completePullRefresh();
    }

    private void beT() {
        if (this.eCx == null) {
            this.eCx = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.eBY = (TextView) this.eCx.findViewById(R.id.frs_game_live_recommand1);
            this.eBZ = (TextView) this.eCx.findViewById(R.id.frs_game_live_recommand2);
            this.eCa = (TextView) this.eCx.findViewById(R.id.frs_game_live_recommand3);
            this.eCb = this.eCx.findViewById(R.id.frs_game_live_recommand_line1);
            this.eCc = this.eCx.findViewById(R.id.frs_game_live_recommand_line2);
        }
        beK();
    }

    private void beK() {
        am.setViewTextColor(this.eBY, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eBZ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eCa, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.eCb, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.eCc, R.color.cp_bg_line_c);
    }

    public void e(List<m> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            beT();
            this.etU.setVisibility(8);
            if (this.eCx != null) {
                this.eBv.removeHeaderView(this.eCx);
                this.eBv.addHeaderView(this.eCx);
            }
            this.eCz.setDatas(list);
            this.eBv.setNextPage(null);
            return;
        }
        if (this.eCx != null) {
            this.eBv.removeHeaderView(this.eCx);
        }
        if (list.size() == 0) {
            this.etU.setVisibility(8);
            this.eCz.setDatas(list);
            this.eBv.setNextPage(null);
            return;
        }
        this.etU.setVisibility(0);
        this.eCz.setDatas(list);
        if (z) {
            beO();
        } else {
            bcr();
        }
    }

    public void beO() {
        if (this.eli != null) {
            if (this.eli.getView().getParent() == null) {
                this.eBv.setNextPage(this.eli);
            }
            this.eli.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.eli.endLoadData();
        }
    }

    public void bcr() {
        if (this.eCy == null) {
            this.eCy = new i(this.mPageContext.getPageActivity());
            this.eCy.createView();
            this.eCy.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12573").cy("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.eCy.getView().getParent() == null) {
            this.eBv.setNextPage(this.eCy);
        }
    }

    public void bcs() {
        if (this.eli != null) {
            if (this.eli.getView().getParent() == null) {
                this.eBv.setNextPage(this.eli);
            }
            this.eli.showLoadingViewWithoutEmptyView();
            this.eli.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.eBv.setOnSrollToBottomListener(onScrollToBottomListener);
        this.eli.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.eCz.b(dVar);
    }

    public NavigationBar beJ() {
        return this.mNavigationBar;
    }

    public void bdo() {
        if (this.eBv != null && j.isNetWorkAvailable()) {
            this.eBv.startPullRefresh();
        }
    }
}
