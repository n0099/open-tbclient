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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdUniqueId agN;
    private int akf = -1;
    private String forumId;
    private View gGB;
    private PopupWindow gGG;
    private View gGH;
    private boolean gSA;
    private boolean gSE;
    private d gSI;
    private TextView gSL;
    private TextView gSM;
    private TextView gSN;
    private TextView gSO;
    private View gSP;
    private NoNetworkView gSQ;
    private TextView gSR;
    private TextView gSS;
    private TextView gST;
    private View gSU;
    private View gSV;
    private com.baidu.tieba.frs.gametab.b gSX;
    private BdTypeMultiColumnListView gSo;
    private View gTq;
    private com.baidu.tieba.ala.frsgamelive.view.c gTr;
    private com.baidu.tieba.ala.frsgamelive.a.d gTs;
    private PbListView gxy;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.gSE = false;
        this.mPageContext = tbPageContext;
        this.gSA = z;
        this.agN = bdUniqueId;
        this.forumId = str;
        this.gSE = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.gSE) {
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
        this.gGB = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gSL = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gSM = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gSo = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.gSo.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.gSQ = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.agN);
        this.gSo.setPullRefresh(this.mPullView);
        this.gxy = new PbListView(this.mPageContext.getPageActivity());
        this.gxy.createView();
        this.gTs = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.gSo);
        this.gSM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bUB();
            }
        });
        if (this.gSA) {
            this.gSX = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.agN, this.gSA);
            this.gSo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gSX.i(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void un(int i) {
        if (i == 1) {
            if (this.gSM != null) {
                this.gSM.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gSM != null) {
            this.gSM.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void tN(int i) {
        if (this.gSL != null) {
            this.gSL.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, at.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gSM.setVisibility(8);
            } else {
                this.gSM.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akf != i) {
            this.akf = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        ao.setViewTextColor(this.gSL, R.color.CAM_X0109);
        ao.setViewTextColor(this.gSM, R.color.CAM_X0109);
        this.gSo.setContentBackgroundColor(ao.getColor(R.color.CAM_X0201));
        this.gSM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUB() {
        bRW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void um(int i) {
        un(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gGG, this.mPageContext.getPageActivity());
        if (this.gSI != null) {
            this.gSI.um(i);
        }
    }

    private void bUC() {
        if (this.gGH == null) {
            this.gGH = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gSN = (TextView) this.gGH.findViewById(R.id.frs_game_live_hot);
            this.gSO = (TextView) this.gGH.findViewById(R.id.frs_game_live_new);
            this.gSP = this.gGH.findViewById(R.id.frs_game_live_sort_sepline);
            this.gSN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.um(1);
                }
            });
            this.gSO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.um(2);
                }
            });
        }
        if (this.gGG == null) {
            this.gGG = new PopupWindow(this.mPageContext.getPageActivity());
            this.gGG.setContentView(this.gGH);
            this.gGG.setWidth(-2);
            this.gGG.setHeight(-2);
            this.gGG.setAnimationStyle(16973826);
            this.gGG.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gGG.setOutsideTouchable(true);
            this.gGG.setFocusable(true);
            this.gGG.setTouchable(true);
            this.gGG.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bUD();
                }
            });
        }
    }

    private void bRW() {
        bUC();
        ao.setBackgroundResource(this.gGH, R.drawable.bg_ala_frs_game_live_sort_panel);
        ao.setBackgroundResource(this.gSN, R.drawable.ala_frs_game_live_sort_selecor);
        ao.setBackgroundResource(this.gSO, R.drawable.ala_frs_game_live_sort_selecor);
        ao.setBackgroundResource(this.gSP, R.color.CAM_X0204);
        ao.setViewTextColor(this.gSN, R.color.CAM_X0106);
        ao.setViewTextColor(this.gSO, R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gSM.getLocationOnScreen(iArr);
        int height = ((View) this.gSM.getParent()).getHeight() - this.gSM.getHeight();
        if (iArr[1] - this.gGG.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gGG, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gGG, this.rootView, 0, (iArr[0] - (this.gSM.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gSM.getHeight());
        this.gGG.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUD() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bUH() {
        return this.gSo;
    }

    public void a(d dVar) {
        this.gSI = dVar;
    }

    public void completePullRefresh() {
        this.gSo.completePullRefresh();
    }

    private void bUI() {
        if (this.gTq == null) {
            this.gTq = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.gSR = (TextView) this.gTq.findViewById(R.id.frs_game_live_recommand1);
            this.gSS = (TextView) this.gTq.findViewById(R.id.frs_game_live_recommand2);
            this.gST = (TextView) this.gTq.findViewById(R.id.frs_game_live_recommand3);
            this.gSU = this.gTq.findViewById(R.id.frs_game_live_recommand_line1);
            this.gSV = this.gTq.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bUA();
    }

    private void bUA() {
        ao.setViewTextColor(this.gSR, R.color.CAM_X0109);
        ao.setViewTextColor(this.gSS, R.color.CAM_X0109);
        ao.setViewTextColor(this.gST, R.color.CAM_X0109);
        ao.setBackgroundResource(this.gSU, R.color.CAM_X0204);
        ao.setBackgroundResource(this.gSV, R.color.CAM_X0204);
    }

    public void d(List<n> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bUI();
            this.gGB.setVisibility(8);
            if (this.gTq != null) {
                this.gSo.removeHeaderView(this.gTq);
                this.gSo.addHeaderView(this.gTq);
            }
            this.gTs.setDatas(list);
            this.gSo.setNextPage(null);
            return;
        }
        if (this.gTq != null) {
            this.gSo.removeHeaderView(this.gTq);
        }
        if (list.size() == 0) {
            this.gGB.setVisibility(8);
            this.gTs.setDatas(list);
            this.gSo.setNextPage(null);
            return;
        }
        this.gGB.setVisibility(0);
        this.gTs.setDatas(list);
        if (z) {
            bUE();
        } else {
            bQM();
        }
    }

    public void bUE() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.gSo.setNextPage(this.gxy);
            }
            this.gxy.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gxy.endLoadData();
        }
    }

    public void bQM() {
        if (this.gTr == null) {
            this.gTr = new com.baidu.tieba.ala.frsgamelive.view.c(this.mPageContext.getPageActivity());
            this.gTr.createView();
            this.gTr.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c12573").dW("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.gTr.getView().getParent() == null) {
            this.gSo.setNextPage(this.gTr);
        }
    }

    public void bQN() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.gSo.setNextPage(this.gxy);
            }
            this.gxy.showLoadingViewWithoutEmptyView();
            this.gxy.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.gSo.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gxy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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

    public void b(com.baidu.tieba.ala.g gVar) {
        this.gTs.b(gVar);
    }

    public NavigationBar bUz() {
        return this.mNavigationBar;
    }

    public void bRN() {
        if (this.gSo != null && j.isNetWorkAvailable()) {
            this.gSo.startPullRefresh();
        }
    }
}
