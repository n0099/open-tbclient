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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.h;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    private BdUniqueId agC;
    private int ajU = -1;
    private String forumId;
    private PbListView gAi;
    private View gJl;
    private PopupWindow gJq;
    private View gJr;
    private BdTypeMultiColumnListView gUY;
    private NoNetworkView gVA;
    private TextView gVB;
    private TextView gVC;
    private TextView gVD;
    private View gVE;
    private View gVF;
    private com.baidu.tieba.frs.gametab.b gVH;
    private boolean gVk;
    private boolean gVo;
    private d gVs;
    private TextView gVv;
    private TextView gVw;
    private TextView gVx;
    private TextView gVy;
    private View gVz;
    private View gWa;
    private com.baidu.tieba.ala.frsgamelive.view.c gWb;
    private com.baidu.tieba.ala.frsgamelive.a.d gWc;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.gVo = false;
        this.mPageContext = tbPageContext;
        this.gVk = z;
        this.agC = bdUniqueId;
        this.forumId = str;
        this.gVo = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.gVo) {
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
        this.gJl = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gVv = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gVw = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gUY = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.gUY.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.gVA = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.agC);
        this.gUY.setPullRefresh(this.mPullView);
        this.gAi = new PbListView(this.mPageContext.getPageActivity());
        this.gAi.createView();
        this.gWc = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.gUY);
        this.gVw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bVf();
            }
        });
        if (this.gVk) {
            this.gVH = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.agC, this.gVk);
            this.gUY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gVH.i(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void ut(int i) {
        if (i == 1) {
            if (this.gVw != null) {
                this.gVw.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gVw != null) {
            this.gVw.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void tT(int i) {
        if (this.gVv != null) {
            this.gVv.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, au.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gVw.setVisibility(8);
            } else {
                this.gVw.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajU != i) {
            this.ajU = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        ap.setViewTextColor(this.gVv, R.color.CAM_X0109);
        ap.setViewTextColor(this.gVw, R.color.CAM_X0109);
        this.gUY.setContentBackgroundColor(ap.getColor(R.color.CAM_X0201));
        this.gVw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVf() {
        bSz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void us(int i) {
        ut(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gJq, this.mPageContext.getPageActivity());
        if (this.gVs != null) {
            this.gVs.us(i);
        }
    }

    private void bVg() {
        if (this.gJr == null) {
            this.gJr = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gVx = (TextView) this.gJr.findViewById(R.id.frs_game_live_hot);
            this.gVy = (TextView) this.gJr.findViewById(R.id.frs_game_live_new);
            this.gVz = this.gJr.findViewById(R.id.frs_game_live_sort_sepline);
            this.gVx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.us(1);
                }
            });
            this.gVy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.us(2);
                }
            });
        }
        if (this.gJq == null) {
            this.gJq = new PopupWindow(this.mPageContext.getPageActivity());
            this.gJq.setContentView(this.gJr);
            this.gJq.setWidth(-2);
            this.gJq.setHeight(-2);
            this.gJq.setAnimationStyle(16973826);
            this.gJq.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gJq.setOutsideTouchable(true);
            this.gJq.setFocusable(true);
            this.gJq.setTouchable(true);
            this.gJq.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bVh();
                }
            });
        }
    }

    private void bSz() {
        bVg();
        ap.setBackgroundResource(this.gJr, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gVx, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gVy, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gVz, R.color.CAM_X0204);
        ap.setViewTextColor(this.gVx, R.color.CAM_X0106);
        ap.setViewTextColor(this.gVy, R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gVw.getLocationOnScreen(iArr);
        int height = ((View) this.gVw.getParent()).getHeight() - this.gVw.getHeight();
        if (iArr[1] - this.gJq.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gJq, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gJq, this.rootView, 0, (iArr[0] - (this.gVw.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gVw.getHeight());
        this.gJq.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVh() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bVm() {
        return this.gUY;
    }

    public void a(d dVar) {
        this.gVs = dVar;
    }

    public void completePullRefresh() {
        this.gUY.completePullRefresh();
    }

    private void bVn() {
        if (this.gWa == null) {
            this.gWa = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.gVB = (TextView) this.gWa.findViewById(R.id.frs_game_live_recommand1);
            this.gVC = (TextView) this.gWa.findViewById(R.id.frs_game_live_recommand2);
            this.gVD = (TextView) this.gWa.findViewById(R.id.frs_game_live_recommand3);
            this.gVE = this.gWa.findViewById(R.id.frs_game_live_recommand_line1);
            this.gVF = this.gWa.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bVe();
    }

    private void bVe() {
        ap.setViewTextColor(this.gVB, R.color.CAM_X0109);
        ap.setViewTextColor(this.gVC, R.color.CAM_X0109);
        ap.setViewTextColor(this.gVD, R.color.CAM_X0109);
        ap.setBackgroundResource(this.gVE, R.color.CAM_X0204);
        ap.setBackgroundResource(this.gVF, R.color.CAM_X0204);
    }

    public void d(List<n> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bVn();
            this.gJl.setVisibility(8);
            if (this.gWa != null) {
                this.gUY.removeHeaderView(this.gWa);
                this.gUY.addHeaderView(this.gWa);
            }
            this.gWc.setDatas(list);
            this.gUY.setNextPage(null);
            return;
        }
        if (this.gWa != null) {
            this.gUY.removeHeaderView(this.gWa);
        }
        if (list.size() == 0) {
            this.gJl.setVisibility(8);
            this.gWc.setDatas(list);
            this.gUY.setNextPage(null);
            return;
        }
        this.gJl.setVisibility(0);
        this.gWc.setDatas(list);
        if (z) {
            bVi();
        } else {
            bRq();
        }
    }

    public void bVi() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.gUY.setNextPage(this.gAi);
            }
            this.gAi.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gAi.endLoadData();
        }
    }

    public void bRq() {
        if (this.gWb == null) {
            this.gWb = new com.baidu.tieba.ala.frsgamelive.view.c(this.mPageContext.getPageActivity());
            this.gWb.createView();
            this.gWb.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c12573").dR("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.gWb.getView().getParent() == null) {
            this.gUY.setNextPage(this.gWb);
        }
    }

    public void bRr() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.gUY.setNextPage(this.gAi);
            }
            this.gAi.showLoadingViewWithoutEmptyView();
            this.gAi.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.gUY.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gAi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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

    public void b(h hVar) {
        this.gWc.b(hVar);
    }

    public NavigationBar bVd() {
        return this.mNavigationBar;
    }

    public void bSq() {
        if (this.gUY != null && j.isNetWorkAvailable()) {
            this.gUY.startPullRefresh();
        }
    }
}
