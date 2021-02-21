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
    private PbListView gAw;
    private PopupWindow gJE;
    private View gJF;
    private View gJz;
    private boolean gVC;
    private d gVG;
    private TextView gVJ;
    private TextView gVK;
    private TextView gVL;
    private TextView gVM;
    private View gVN;
    private NoNetworkView gVO;
    private TextView gVP;
    private TextView gVQ;
    private TextView gVR;
    private View gVS;
    private View gVT;
    private com.baidu.tieba.frs.gametab.b gVV;
    private BdTypeMultiColumnListView gVm;
    private boolean gVy;
    private View gWo;
    private com.baidu.tieba.ala.frsgamelive.view.c gWp;
    private com.baidu.tieba.ala.frsgamelive.a.d gWq;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.gVC = false;
        this.mPageContext = tbPageContext;
        this.gVy = z;
        this.agC = bdUniqueId;
        this.forumId = str;
        this.gVC = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.gVC) {
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
        this.gJz = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gVJ = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gVK = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gVm = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.gVm.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.gVO = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.agC);
        this.gVm.setPullRefresh(this.mPullView);
        this.gAw = new PbListView(this.mPageContext.getPageActivity());
        this.gAw.createView();
        this.gWq = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.gVm);
        this.gVK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bVm();
            }
        });
        if (this.gVy) {
            this.gVV = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.agC, this.gVy);
            this.gVm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gVV.i(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void ut(int i) {
        if (i == 1) {
            if (this.gVK != null) {
                this.gVK.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gVK != null) {
            this.gVK.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void tT(int i) {
        if (this.gVJ != null) {
            this.gVJ.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, au.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gVK.setVisibility(8);
            } else {
                this.gVK.setVisibility(0);
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
        ap.setViewTextColor(this.gVJ, R.color.CAM_X0109);
        ap.setViewTextColor(this.gVK, R.color.CAM_X0109);
        this.gVm.setContentBackgroundColor(ap.getColor(R.color.CAM_X0201));
        this.gVK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVm() {
        bSG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void us(int i) {
        ut(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gJE, this.mPageContext.getPageActivity());
        if (this.gVG != null) {
            this.gVG.us(i);
        }
    }

    private void bVn() {
        if (this.gJF == null) {
            this.gJF = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gVL = (TextView) this.gJF.findViewById(R.id.frs_game_live_hot);
            this.gVM = (TextView) this.gJF.findViewById(R.id.frs_game_live_new);
            this.gVN = this.gJF.findViewById(R.id.frs_game_live_sort_sepline);
            this.gVL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.us(1);
                }
            });
            this.gVM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.us(2);
                }
            });
        }
        if (this.gJE == null) {
            this.gJE = new PopupWindow(this.mPageContext.getPageActivity());
            this.gJE.setContentView(this.gJF);
            this.gJE.setWidth(-2);
            this.gJE.setHeight(-2);
            this.gJE.setAnimationStyle(16973826);
            this.gJE.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gJE.setOutsideTouchable(true);
            this.gJE.setFocusable(true);
            this.gJE.setTouchable(true);
            this.gJE.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bVo();
                }
            });
        }
    }

    private void bSG() {
        bVn();
        ap.setBackgroundResource(this.gJF, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gVL, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gVM, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gVN, R.color.CAM_X0204);
        ap.setViewTextColor(this.gVL, R.color.CAM_X0106);
        ap.setViewTextColor(this.gVM, R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gVK.getLocationOnScreen(iArr);
        int height = ((View) this.gVK.getParent()).getHeight() - this.gVK.getHeight();
        if (iArr[1] - this.gJE.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gJE, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gJE, this.rootView, 0, (iArr[0] - (this.gVK.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gVK.getHeight());
        this.gJE.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVo() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bVt() {
        return this.gVm;
    }

    public void a(d dVar) {
        this.gVG = dVar;
    }

    public void completePullRefresh() {
        this.gVm.completePullRefresh();
    }

    private void bVu() {
        if (this.gWo == null) {
            this.gWo = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.gVP = (TextView) this.gWo.findViewById(R.id.frs_game_live_recommand1);
            this.gVQ = (TextView) this.gWo.findViewById(R.id.frs_game_live_recommand2);
            this.gVR = (TextView) this.gWo.findViewById(R.id.frs_game_live_recommand3);
            this.gVS = this.gWo.findViewById(R.id.frs_game_live_recommand_line1);
            this.gVT = this.gWo.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bVl();
    }

    private void bVl() {
        ap.setViewTextColor(this.gVP, R.color.CAM_X0109);
        ap.setViewTextColor(this.gVQ, R.color.CAM_X0109);
        ap.setViewTextColor(this.gVR, R.color.CAM_X0109);
        ap.setBackgroundResource(this.gVS, R.color.CAM_X0204);
        ap.setBackgroundResource(this.gVT, R.color.CAM_X0204);
    }

    public void d(List<n> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bVu();
            this.gJz.setVisibility(8);
            if (this.gWo != null) {
                this.gVm.removeHeaderView(this.gWo);
                this.gVm.addHeaderView(this.gWo);
            }
            this.gWq.setDatas(list);
            this.gVm.setNextPage(null);
            return;
        }
        if (this.gWo != null) {
            this.gVm.removeHeaderView(this.gWo);
        }
        if (list.size() == 0) {
            this.gJz.setVisibility(8);
            this.gWq.setDatas(list);
            this.gVm.setNextPage(null);
            return;
        }
        this.gJz.setVisibility(0);
        this.gWq.setDatas(list);
        if (z) {
            bVp();
        } else {
            bRx();
        }
    }

    public void bVp() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.gVm.setNextPage(this.gAw);
            }
            this.gAw.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gAw.endLoadData();
        }
    }

    public void bRx() {
        if (this.gWp == null) {
            this.gWp = new com.baidu.tieba.ala.frsgamelive.view.c(this.mPageContext.getPageActivity());
            this.gWp.createView();
            this.gWp.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c12573").dR("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.gWp.getView().getParent() == null) {
            this.gVm.setNextPage(this.gWp);
        }
    }

    public void bRy() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.gVm.setNextPage(this.gAw);
            }
            this.gAw.showLoadingViewWithoutEmptyView();
            this.gAw.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.gVm.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gAw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.gWq.b(hVar);
    }

    public NavigationBar bVk() {
        return this.mNavigationBar;
    }

    public void bSx() {
        if (this.gVm != null && j.isNetWorkAvailable()) {
            this.gVm.startPullRefresh();
        }
    }
}
