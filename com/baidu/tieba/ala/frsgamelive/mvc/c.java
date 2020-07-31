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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.e;
import com.baidu.tieba.ala.frsgamelive.c.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private BdUniqueId agB;
    private int aho = -1;
    private View fBt;
    private PopupWindow fBy;
    private View fBz;
    private TextView fLA;
    private TextView fLB;
    private TextView fLC;
    private View fLD;
    private NoNetworkView fLE;
    private TextView fLF;
    private TextView fLG;
    private TextView fLH;
    private View fLI;
    private View fLJ;
    private com.baidu.tieba.frs.gametab.b fLL;
    private BdTypeMultiColumnListView fLc;
    private boolean fLo;
    private boolean fLs;
    private d fLw;
    private TextView fLz;
    private View fMe;
    private i fMf;
    private com.baidu.tieba.ala.frsgamelive.a.d fMg;
    private String forumId;
    private PbListView fsC;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.fLs = false;
        this.mPageContext = tbPageContext;
        this.fLo = z;
        this.agB = bdUniqueId;
        this.forumId = str;
        this.fLs = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.fLs) {
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
        this.fBt = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.fLz = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.fLA = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.fLc = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.fLc.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.fLE = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.agB);
        this.fLc.setPullRefresh(this.mPullView);
        this.fsC = new PbListView(this.mPageContext.getPageActivity());
        this.fsC.createView();
        this.fMg = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.fLc);
        this.fLA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bAo();
            }
        });
        if (this.fLo) {
            this.fLL = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.agB, this.fLo);
            this.fLc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.fLL.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void qY(int i) {
        if (i == 1) {
            if (this.fLA != null) {
                this.fLA.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.fLA != null) {
            this.fLA.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void qB(int i) {
        if (this.fLz != null) {
            this.fLz.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, as.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.fLA.setVisibility(8);
            } else {
                this.fLA.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aho != i) {
            this.aho = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        ao.setViewTextColor(this.fLz, R.color.cp_cont_d);
        ao.setViewTextColor(this.fLA, R.color.cp_cont_d);
        this.fLc.setContentBackgroundColor(ao.getColor(R.color.cp_bg_line_d));
        this.fLA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAo() {
        byc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX(int i) {
        qY(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.fBy, this.mPageContext.getPageActivity());
        if (this.fLw != null) {
            this.fLw.qX(i);
        }
    }

    private void bAp() {
        if (this.fBz == null) {
            this.fBz = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.fLB = (TextView) this.fBz.findViewById(R.id.frs_game_live_hot);
            this.fLC = (TextView) this.fBz.findViewById(R.id.frs_game_live_new);
            this.fLD = this.fBz.findViewById(R.id.frs_game_live_sort_sepline);
            this.fLB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.qX(1);
                }
            });
            this.fLC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.qX(2);
                }
            });
        }
        if (this.fBy == null) {
            this.fBy = new PopupWindow(this.mPageContext.getPageActivity());
            this.fBy.setContentView(this.fBz);
            this.fBy.setWidth(-2);
            this.fBy.setHeight(-2);
            this.fBy.setAnimationStyle(16973826);
            this.fBy.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.fBy.setOutsideTouchable(true);
            this.fBy.setFocusable(true);
            this.fBy.setTouchable(true);
            this.fBy.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bAq();
                }
            });
        }
    }

    private void byc() {
        bAp();
        ao.setBackgroundResource(this.fBz, R.drawable.bg_ala_frs_game_live_sort_panel);
        ao.setBackgroundResource(this.fLB, R.drawable.ala_frs_game_live_sort_selecor);
        ao.setBackgroundResource(this.fLC, R.drawable.ala_frs_game_live_sort_selecor);
        ao.setBackgroundResource(this.fLD, R.color.cp_bg_line_c);
        ao.setViewTextColor(this.fLB, R.color.cp_cont_f);
        ao.setViewTextColor(this.fLC, R.color.cp_cont_f);
        int[] iArr = new int[2];
        this.fLA.getLocationOnScreen(iArr);
        int height = ((View) this.fLA.getParent()).getHeight() - this.fLA.getHeight();
        if (iArr[1] - this.fBy.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.fBy, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fBy, this.rootView, 0, (iArr[0] - (this.fLA.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fLA.getHeight());
        this.fBy.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAq() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bAu() {
        return this.fLc;
    }

    public void a(d dVar) {
        this.fLw = dVar;
    }

    public void completePullRefresh() {
        this.fLc.completePullRefresh();
    }

    private void bAv() {
        if (this.fMe == null) {
            this.fMe = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.fLF = (TextView) this.fMe.findViewById(R.id.frs_game_live_recommand1);
            this.fLG = (TextView) this.fMe.findViewById(R.id.frs_game_live_recommand2);
            this.fLH = (TextView) this.fMe.findViewById(R.id.frs_game_live_recommand3);
            this.fLI = this.fMe.findViewById(R.id.frs_game_live_recommand_line1);
            this.fLJ = this.fMe.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bAn();
    }

    private void bAn() {
        ao.setViewTextColor(this.fLF, R.color.cp_cont_d);
        ao.setViewTextColor(this.fLG, R.color.cp_cont_d);
        ao.setViewTextColor(this.fLH, R.color.cp_cont_d);
        ao.setBackgroundResource(this.fLI, R.color.cp_bg_line_c);
        ao.setBackgroundResource(this.fLJ, R.color.cp_bg_line_c);
    }

    public void d(List<q> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bAv();
            this.fBt.setVisibility(8);
            if (this.fMe != null) {
                this.fLc.removeHeaderView(this.fMe);
                this.fLc.addHeaderView(this.fMe);
            }
            this.fMg.setDatas(list);
            this.fLc.setNextPage(null);
            return;
        }
        if (this.fMe != null) {
            this.fLc.removeHeaderView(this.fMe);
        }
        if (list.size() == 0) {
            this.fBt.setVisibility(8);
            this.fMg.setDatas(list);
            this.fLc.setNextPage(null);
            return;
        }
        this.fBt.setVisibility(0);
        this.fMg.setDatas(list);
        if (z) {
            bAr();
        } else {
            bwS();
        }
    }

    public void bAr() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.fLc.setNextPage(this.fsC);
            }
            this.fsC.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.fsC.endLoadData();
        }
    }

    public void bwS() {
        if (this.fMf == null) {
            this.fMf = new i(this.mPageContext.getPageActivity());
            this.fMf.createView();
            this.fMf.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ap("c12573").dn("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.fMf.getView().getParent() == null) {
            this.fLc.setNextPage(this.fMf);
        }
    }

    public void bwT() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.fLc.setNextPage(this.fsC);
            }
            this.fsC.showLoadingViewWithoutEmptyView();
            this.fsC.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.fLc.setOnSrollToBottomListener(onScrollToBottomListener);
        this.fsC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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

    public void b(e eVar) {
        this.fMg.b(eVar);
    }

    public NavigationBar bAm() {
        return this.mNavigationBar;
    }

    public void bxR() {
        if (this.fLc != null && j.isNetWorkAvailable()) {
            this.fLc.startPullRefresh();
        }
    }
}
