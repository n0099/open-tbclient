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
    private View gAc;
    private PopupWindow gAh;
    private View gAi;
    private d gLA;
    private TextView gLD;
    private TextView gLE;
    private TextView gLF;
    private TextView gLG;
    private View gLH;
    private NoNetworkView gLI;
    private TextView gLJ;
    private TextView gLK;
    private TextView gLL;
    private View gLM;
    private View gLN;
    private com.baidu.tieba.frs.gametab.b gLP;
    private BdTypeMultiColumnListView gLg;
    private boolean gLs;
    private boolean gLw;
    private View gMi;
    private i gMj;
    private com.baidu.tieba.ala.frsgamelive.a.d gMk;
    private PbListView gre;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.gLw = false;
        this.mPageContext = tbPageContext;
        this.gLs = z;
        this.ajD = bdUniqueId;
        this.forumId = str;
        this.gLw = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.gLw) {
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
        this.gAc = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gLD = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gLE = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gLg = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.gLg.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.gLI = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.ajD);
        this.gLg.setPullRefresh(this.mPullView);
        this.gre = new PbListView(this.mPageContext.getPageActivity());
        this.gre.createView();
        this.gMk = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.gLg);
        this.gLE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bVM();
            }
        });
        if (this.gLs) {
            this.gLP = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.ajD, this.gLs);
            this.gLg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gLP.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void vI(int i) {
        if (i == 1) {
            if (this.gLE != null) {
                this.gLE.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gLE != null) {
            this.gLE.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void vi(int i) {
        if (this.gLD != null) {
            this.gLD.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, au.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gLE.setVisibility(8);
            } else {
                this.gLE.setVisibility(0);
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
        ap.setViewTextColor(this.gLD, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gLE, (int) R.color.CAM_X0109);
        this.gLg.setContentBackgroundColor(ap.getColor(R.color.CAM_X0201));
        this.gLE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVM() {
        bTi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vH(int i) {
        vI(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gAh, this.mPageContext.getPageActivity());
        if (this.gLA != null) {
            this.gLA.vH(i);
        }
    }

    private void bVN() {
        if (this.gAi == null) {
            this.gAi = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gLF = (TextView) this.gAi.findViewById(R.id.frs_game_live_hot);
            this.gLG = (TextView) this.gAi.findViewById(R.id.frs_game_live_new);
            this.gLH = this.gAi.findViewById(R.id.frs_game_live_sort_sepline);
            this.gLF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.vH(1);
                }
            });
            this.gLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.vH(2);
                }
            });
        }
        if (this.gAh == null) {
            this.gAh = new PopupWindow(this.mPageContext.getPageActivity());
            this.gAh.setContentView(this.gAi);
            this.gAh.setWidth(-2);
            this.gAh.setHeight(-2);
            this.gAh.setAnimationStyle(16973826);
            this.gAh.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gAh.setOutsideTouchable(true);
            this.gAh.setFocusable(true);
            this.gAh.setTouchable(true);
            this.gAh.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bVO();
                }
            });
        }
    }

    private void bTi() {
        bVN();
        ap.setBackgroundResource(this.gAi, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gLF, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gLG, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gLH, R.color.CAM_X0204);
        ap.setViewTextColor(this.gLF, (int) R.color.CAM_X0106);
        ap.setViewTextColor(this.gLG, (int) R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gLE.getLocationOnScreen(iArr);
        int height = ((View) this.gLE.getParent()).getHeight() - this.gLE.getHeight();
        if (iArr[1] - this.gAh.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gAh, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gAh, this.rootView, 0, (iArr[0] - (this.gLE.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gLE.getHeight());
        this.gAh.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVO() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bVS() {
        return this.gLg;
    }

    public void a(d dVar) {
        this.gLA = dVar;
    }

    public void completePullRefresh() {
        this.gLg.completePullRefresh();
    }

    private void bVT() {
        if (this.gMi == null) {
            this.gMi = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.gLJ = (TextView) this.gMi.findViewById(R.id.frs_game_live_recommand1);
            this.gLK = (TextView) this.gMi.findViewById(R.id.frs_game_live_recommand2);
            this.gLL = (TextView) this.gMi.findViewById(R.id.frs_game_live_recommand3);
            this.gLM = this.gMi.findViewById(R.id.frs_game_live_recommand_line1);
            this.gLN = this.gMi.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bVL();
    }

    private void bVL() {
        ap.setViewTextColor(this.gLJ, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gLK, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gLL, (int) R.color.CAM_X0109);
        ap.setBackgroundResource(this.gLM, R.color.CAM_X0204);
        ap.setBackgroundResource(this.gLN, R.color.CAM_X0204);
    }

    public void d(List<q> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bVT();
            this.gAc.setVisibility(8);
            if (this.gMi != null) {
                this.gLg.removeHeaderView(this.gMi);
                this.gLg.addHeaderView(this.gMi);
            }
            this.gMk.setDatas(list);
            this.gLg.setNextPage(null);
            return;
        }
        if (this.gMi != null) {
            this.gLg.removeHeaderView(this.gMi);
        }
        if (list.size() == 0) {
            this.gAc.setVisibility(8);
            this.gMk.setDatas(list);
            this.gLg.setNextPage(null);
            return;
        }
        this.gAc.setVisibility(0);
        this.gMk.setDatas(list);
        if (z) {
            bVP();
        } else {
            bSa();
        }
    }

    public void bVP() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.gLg.setNextPage(this.gre);
            }
            this.gre.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gre.endLoadData();
        }
    }

    public void bSa() {
        if (this.gMj == null) {
            this.gMj = new i(this.mPageContext.getPageActivity());
            this.gMj.createView();
            this.gMj.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c12573").dY("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.gMj.getView().getParent() == null) {
            this.gLg.setNextPage(this.gMj);
        }
    }

    public void bSb() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.gLg.setNextPage(this.gre);
            }
            this.gre.showLoadingViewWithoutEmptyView();
            this.gre.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.gLg.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gre.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.gMk.b(fVar);
    }

    public NavigationBar bVK() {
        return this.mNavigationBar;
    }

    public void bSZ() {
        if (this.gLg != null && j.isNetWorkAvailable()) {
            this.gLg.startPullRefresh();
        }
    }
}
