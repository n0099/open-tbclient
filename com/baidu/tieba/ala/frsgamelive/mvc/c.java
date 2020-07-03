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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
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
    private BdUniqueId agK;
    private int ahx = -1;
    private BdTypeMultiColumnListView fFH;
    private boolean fFT;
    private boolean fFX;
    private View fGJ;
    private i fGK;
    private com.baidu.tieba.ala.frsgamelive.a.d fGL;
    private d fGb;
    private TextView fGe;
    private TextView fGf;
    private TextView fGg;
    private TextView fGh;
    private View fGi;
    private NoNetworkView fGj;
    private TextView fGk;
    private TextView fGl;
    private TextView fGm;
    private View fGn;
    private View fGo;
    private com.baidu.tieba.frs.gametab.b fGq;
    private PbListView fnt;
    private String forumId;
    private View fwm;
    private PopupWindow fwr;
    private View fws;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.fFX = false;
        this.mPageContext = tbPageContext;
        this.fFT = z;
        this.agK = bdUniqueId;
        this.forumId = str;
        this.fFX = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.fFX) {
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
        this.fwm = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fGe = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fGf = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.fFH = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.fFH.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.fGj = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.agK);
        this.fFH.setPullRefresh(this.mPullView);
        this.fnt = new PbListView(this.mPageContext.getPageActivity());
        this.fnt.createView();
        this.fGL = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.fFH);
        this.fGf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bwX();
            }
        });
        if (this.fFT) {
            this.fGq = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.agK, this.fFT);
            this.fFH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.fGq.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void qI(int i) {
        if (i == 1) {
            if (this.fGf != null) {
                this.fGf.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fGf != null) {
            this.fGf.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void qm(int i) {
        if (this.fGe != null) {
            this.fGe.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, ar.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fGf.setVisibility(8);
            } else {
                this.fGf.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ahx != i) {
            this.ahx = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        an.setViewTextColor(this.fGe, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.fGf, (int) R.color.cp_cont_d);
        this.fFH.setContentBackgroundColor(an.getColor(R.color.cp_bg_line_d));
        this.fGf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwX() {
        buS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qH(int i) {
        qI(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.fwr, this.mPageContext.getPageActivity());
        if (this.fGb != null) {
            this.fGb.qH(i);
        }
    }

    private void bwY() {
        if (this.fws == null) {
            this.fws = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fGg = (TextView) this.fws.findViewById(R.id.frs_game_live_hot);
            this.fGh = (TextView) this.fws.findViewById(R.id.frs_game_live_new);
            this.fGi = this.fws.findViewById(R.id.frs_game_live_sort_sepline);
            this.fGg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.qH(1);
                }
            });
            this.fGh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.qH(2);
                }
            });
        }
        if (this.fwr == null) {
            this.fwr = new PopupWindow(this.mPageContext.getPageActivity());
            this.fwr.setContentView(this.fws);
            this.fwr.setWidth(-2);
            this.fwr.setHeight(-2);
            this.fwr.setAnimationStyle(16973826);
            this.fwr.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.fwr.setOutsideTouchable(true);
            this.fwr.setFocusable(true);
            this.fwr.setTouchable(true);
            this.fwr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bwZ();
                }
            });
        }
    }

    private void buS() {
        bwY();
        an.setBackgroundResource(this.fws, R.drawable.bg_ala_frs_game_live_sort_panel);
        an.setBackgroundResource(this.fGg, R.drawable.ala_frs_game_live_sort_selecor);
        an.setBackgroundResource(this.fGh, R.drawable.ala_frs_game_live_sort_selecor);
        an.setBackgroundResource(this.fGi, R.color.cp_bg_line_c);
        an.setViewTextColor(this.fGg, (int) R.color.cp_cont_f);
        an.setViewTextColor(this.fGh, (int) R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fGf.getLocationOnScreen(iArr);
        int height = ((View) this.fGf.getParent()).getHeight() - this.fGf.getHeight();
        if (iArr[1] - this.fwr.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.fwr, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fwr, this.rootView, 0, (iArr[0] - (this.fGf.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fGf.getHeight());
        this.fwr.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwZ() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bxd() {
        return this.fFH;
    }

    public void a(d dVar) {
        this.fGb = dVar;
    }

    public void completePullRefresh() {
        this.fFH.completePullRefresh();
    }

    private void bxe() {
        if (this.fGJ == null) {
            this.fGJ = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.fGk = (TextView) this.fGJ.findViewById(R.id.frs_game_live_recommand1);
            this.fGl = (TextView) this.fGJ.findViewById(R.id.frs_game_live_recommand2);
            this.fGm = (TextView) this.fGJ.findViewById(R.id.frs_game_live_recommand3);
            this.fGn = this.fGJ.findViewById(R.id.frs_game_live_recommand_line1);
            this.fGo = this.fGJ.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bwW();
    }

    private void bwW() {
        an.setViewTextColor(this.fGk, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.fGl, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.fGm, (int) R.color.cp_cont_d);
        an.setBackgroundResource(this.fGn, R.color.cp_bg_line_c);
        an.setBackgroundResource(this.fGo, R.color.cp_bg_line_c);
    }

    public void e(List<q> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bxe();
            this.fwm.setVisibility(8);
            if (this.fGJ != null) {
                this.fFH.removeHeaderView(this.fGJ);
                this.fFH.addHeaderView(this.fGJ);
            }
            this.fGL.setDatas(list);
            this.fFH.setNextPage(null);
            return;
        }
        if (this.fGJ != null) {
            this.fFH.removeHeaderView(this.fGJ);
        }
        if (list.size() == 0) {
            this.fwm.setVisibility(8);
            this.fGL.setDatas(list);
            this.fFH.setNextPage(null);
            return;
        }
        this.fwm.setVisibility(0);
        this.fGL.setDatas(list);
        if (z) {
            bxa();
        } else {
            btI();
        }
    }

    public void bxa() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.fFH.setNextPage(this.fnt);
            }
            this.fnt.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fnt.endLoadData();
        }
    }

    public void btI() {
        if (this.fGK == null) {
            this.fGK = new i(this.mPageContext.getPageActivity());
            this.fGK.createView();
            this.fGK.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ao("c12573").dk("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.fGK.getView().getParent() == null) {
            this.fFH.setNextPage(this.fGK);
        }
    }

    public void btJ() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.fFH.setNextPage(this.fnt);
            }
            this.fnt.showLoadingViewWithoutEmptyView();
            this.fnt.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.fFH.setOnSrollToBottomListener(onScrollToBottomListener);
        this.fnt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.fGL.b(dVar);
    }

    public NavigationBar bwV() {
        return this.mNavigationBar;
    }

    public void buH() {
        if (this.fFH != null && j.isNetWorkAvailable()) {
            this.fFH.startPullRefresh();
        }
    }
}
