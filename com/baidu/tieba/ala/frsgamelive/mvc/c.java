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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.c.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private BdUniqueId ajD;
    private int aku = -1;
    private String forumId;
    private View gAe;
    private PopupWindow gAj;
    private View gAk;
    private d gLC;
    private TextView gLF;
    private TextView gLG;
    private TextView gLH;
    private TextView gLI;
    private View gLJ;
    private NoNetworkView gLK;
    private TextView gLL;
    private TextView gLM;
    private TextView gLN;
    private View gLO;
    private View gLP;
    private com.baidu.tieba.frs.gametab.b gLR;
    private BdTypeMultiColumnListView gLi;
    private boolean gLu;
    private boolean gLy;
    private View gMk;
    private i gMl;
    private com.baidu.tieba.ala.frsgamelive.a.d gMm;
    private PbListView grg;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.gLy = false;
        this.mPageContext = tbPageContext;
        this.gLu = z;
        this.ajD = bdUniqueId;
        this.forumId = str;
        this.gLy = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.gLy) {
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
        this.gAe = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gLF = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gLG = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gLi = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.gLi.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.gLK = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.ajD);
        this.gLi.setPullRefresh(this.mPullView);
        this.grg = new PbListView(this.mPageContext.getPageActivity());
        this.grg.createView();
        this.gMm = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.gLi);
        this.gLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bVN();
            }
        });
        if (this.gLu) {
            this.gLR = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.ajD, this.gLu);
            this.gLi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gLR.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void vI(int i) {
        if (i == 1) {
            if (this.gLG != null) {
                this.gLG.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gLG != null) {
            this.gLG.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void vi(int i) {
        if (this.gLF != null) {
            this.gLF.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, au.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gLG.setVisibility(8);
            } else {
                this.gLG.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aku != i) {
            this.aku = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        ap.setViewTextColor(this.gLF, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gLG, (int) R.color.CAM_X0109);
        this.gLi.setContentBackgroundColor(ap.getColor(R.color.CAM_X0201));
        this.gLG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVN() {
        bTj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vH(int i) {
        vI(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gAj, this.mPageContext.getPageActivity());
        if (this.gLC != null) {
            this.gLC.vH(i);
        }
    }

    private void bVO() {
        if (this.gAk == null) {
            this.gAk = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gLH = (TextView) this.gAk.findViewById(R.id.frs_game_live_hot);
            this.gLI = (TextView) this.gAk.findViewById(R.id.frs_game_live_new);
            this.gLJ = this.gAk.findViewById(R.id.frs_game_live_sort_sepline);
            this.gLH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.vH(1);
                }
            });
            this.gLI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.vH(2);
                }
            });
        }
        if (this.gAj == null) {
            this.gAj = new PopupWindow(this.mPageContext.getPageActivity());
            this.gAj.setContentView(this.gAk);
            this.gAj.setWidth(-2);
            this.gAj.setHeight(-2);
            this.gAj.setAnimationStyle(16973826);
            this.gAj.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gAj.setOutsideTouchable(true);
            this.gAj.setFocusable(true);
            this.gAj.setTouchable(true);
            this.gAj.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bVP();
                }
            });
        }
    }

    private void bTj() {
        bVO();
        ap.setBackgroundResource(this.gAk, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gLH, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gLI, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gLJ, R.color.CAM_X0204);
        ap.setViewTextColor(this.gLH, (int) R.color.CAM_X0106);
        ap.setViewTextColor(this.gLI, (int) R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gLG.getLocationOnScreen(iArr);
        int height = ((View) this.gLG.getParent()).getHeight() - this.gLG.getHeight();
        if (iArr[1] - this.gAj.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gAj, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gAj, this.rootView, 0, (iArr[0] - (this.gLG.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gLG.getHeight());
        this.gAj.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVP() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bVT() {
        return this.gLi;
    }

    public void a(d dVar) {
        this.gLC = dVar;
    }

    public void completePullRefresh() {
        this.gLi.completePullRefresh();
    }

    private void bVU() {
        if (this.gMk == null) {
            this.gMk = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.gLL = (TextView) this.gMk.findViewById(R.id.frs_game_live_recommand1);
            this.gLM = (TextView) this.gMk.findViewById(R.id.frs_game_live_recommand2);
            this.gLN = (TextView) this.gMk.findViewById(R.id.frs_game_live_recommand3);
            this.gLO = this.gMk.findViewById(R.id.frs_game_live_recommand_line1);
            this.gLP = this.gMk.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bVM();
    }

    private void bVM() {
        ap.setViewTextColor(this.gLL, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gLM, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gLN, (int) R.color.CAM_X0109);
        ap.setBackgroundResource(this.gLO, R.color.CAM_X0204);
        ap.setBackgroundResource(this.gLP, R.color.CAM_X0204);
    }

    public void d(List<q> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bVU();
            this.gAe.setVisibility(8);
            if (this.gMk != null) {
                this.gLi.removeHeaderView(this.gMk);
                this.gLi.addHeaderView(this.gMk);
            }
            this.gMm.setDatas(list);
            this.gLi.setNextPage(null);
            return;
        }
        if (this.gMk != null) {
            this.gLi.removeHeaderView(this.gMk);
        }
        if (list.size() == 0) {
            this.gAe.setVisibility(8);
            this.gMm.setDatas(list);
            this.gLi.setNextPage(null);
            return;
        }
        this.gAe.setVisibility(0);
        this.gMm.setDatas(list);
        if (z) {
            bVQ();
        } else {
            bSb();
        }
    }

    public void bVQ() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.gLi.setNextPage(this.grg);
            }
            this.grg.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.grg.endLoadData();
        }
    }

    public void bSb() {
        if (this.gMl == null) {
            this.gMl = new i(this.mPageContext.getPageActivity());
            this.gMl.createView();
            this.gMl.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c12573").dY("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.gMl.getView().getParent() == null) {
            this.gLi.setNextPage(this.gMl);
        }
    }

    public void bSc() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.gLi.setNextPage(this.grg);
            }
            this.grg.showLoadingViewWithoutEmptyView();
            this.grg.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.gLi.setOnSrollToBottomListener(onScrollToBottomListener);
        this.grg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.gMm.b(fVar);
    }

    public NavigationBar bVL() {
        return this.mNavigationBar;
    }

    public void bTa() {
        if (this.gLi != null && j.isNetWorkAvailable()) {
            this.gLi.startPullRefresh();
        }
    }
}
