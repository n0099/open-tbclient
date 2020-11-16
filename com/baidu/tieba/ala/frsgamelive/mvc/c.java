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
/* loaded from: classes4.dex */
public class c {
    private BdUniqueId aiE;
    private int ajv = -1;
    private String forumId;
    private d gCD;
    private TextView gCG;
    private TextView gCH;
    private TextView gCI;
    private TextView gCJ;
    private View gCK;
    private NoNetworkView gCL;
    private TextView gCM;
    private TextView gCN;
    private TextView gCO;
    private View gCP;
    private View gCQ;
    private com.baidu.tieba.frs.gametab.b gCS;
    private BdTypeMultiColumnListView gCj;
    private boolean gCv;
    private boolean gCz;
    private View gDl;
    private i gDm;
    private com.baidu.tieba.ala.frsgamelive.a.d gDn;
    private PbListView giV;
    private View grT;
    private PopupWindow grY;
    private View grZ;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.gCz = false;
        this.mPageContext = tbPageContext;
        this.gCv = z;
        this.aiE = bdUniqueId;
        this.forumId = str;
        this.gCz = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.gCz) {
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
        this.grT = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gCG = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gCH = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gCj = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.gCj.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.gCL = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.aiE);
        this.gCj.setPullRefresh(this.mPullView);
        this.giV = new PbListView(this.mPageContext.getPageActivity());
        this.giV.createView();
        this.gDn = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.gCj);
        this.gCH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bSc();
            }
        });
        if (this.gCv) {
            this.gCS = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.aiE, this.gCv);
            this.gCj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gCS.b(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void vb(int i) {
        if (i == 1) {
            if (this.gCH != null) {
                this.gCH.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gCH != null) {
            this.gCH.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void uE(int i) {
        if (this.gCG != null) {
            this.gCG.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, au.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gCH.setVisibility(8);
            } else {
                this.gCH.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajv != i) {
            this.ajv = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        ap.setViewTextColor(this.gCG, R.color.CAM_X0109);
        ap.setViewTextColor(this.gCH, R.color.CAM_X0109);
        this.gCj.setContentBackgroundColor(ap.getColor(R.color.CAM_X0201));
        this.gCH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSc() {
        bPx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void va(int i) {
        vb(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.grY, this.mPageContext.getPageActivity());
        if (this.gCD != null) {
            this.gCD.va(i);
        }
    }

    private void bSd() {
        if (this.grZ == null) {
            this.grZ = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gCI = (TextView) this.grZ.findViewById(R.id.frs_game_live_hot);
            this.gCJ = (TextView) this.grZ.findViewById(R.id.frs_game_live_new);
            this.gCK = this.grZ.findViewById(R.id.frs_game_live_sort_sepline);
            this.gCI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.va(1);
                }
            });
            this.gCJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.va(2);
                }
            });
        }
        if (this.grY == null) {
            this.grY = new PopupWindow(this.mPageContext.getPageActivity());
            this.grY.setContentView(this.grZ);
            this.grY.setWidth(-2);
            this.grY.setHeight(-2);
            this.grY.setAnimationStyle(16973826);
            this.grY.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.grY.setOutsideTouchable(true);
            this.grY.setFocusable(true);
            this.grY.setTouchable(true);
            this.grY.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bSe();
                }
            });
        }
    }

    private void bPx() {
        bSd();
        ap.setBackgroundResource(this.grZ, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gCI, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gCJ, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gCK, R.color.CAM_X0204);
        ap.setViewTextColor(this.gCI, R.color.CAM_X0106);
        ap.setViewTextColor(this.gCJ, R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gCH.getLocationOnScreen(iArr);
        int height = ((View) this.gCH.getParent()).getHeight() - this.gCH.getHeight();
        if (iArr[1] - this.grY.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.grY, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.grY, this.rootView, 0, (iArr[0] - (this.gCH.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gCH.getHeight());
        this.grY.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSe() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bSi() {
        return this.gCj;
    }

    public void a(d dVar) {
        this.gCD = dVar;
    }

    public void completePullRefresh() {
        this.gCj.completePullRefresh();
    }

    private void bSj() {
        if (this.gDl == null) {
            this.gDl = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.gCM = (TextView) this.gDl.findViewById(R.id.frs_game_live_recommand1);
            this.gCN = (TextView) this.gDl.findViewById(R.id.frs_game_live_recommand2);
            this.gCO = (TextView) this.gDl.findViewById(R.id.frs_game_live_recommand3);
            this.gCP = this.gDl.findViewById(R.id.frs_game_live_recommand_line1);
            this.gCQ = this.gDl.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bSb();
    }

    private void bSb() {
        ap.setViewTextColor(this.gCM, R.color.CAM_X0109);
        ap.setViewTextColor(this.gCN, R.color.CAM_X0109);
        ap.setViewTextColor(this.gCO, R.color.CAM_X0109);
        ap.setBackgroundResource(this.gCP, R.color.CAM_X0204);
        ap.setBackgroundResource(this.gCQ, R.color.CAM_X0204);
    }

    public void d(List<q> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bSj();
            this.grT.setVisibility(8);
            if (this.gDl != null) {
                this.gCj.removeHeaderView(this.gDl);
                this.gCj.addHeaderView(this.gDl);
            }
            this.gDn.setDatas(list);
            this.gCj.setNextPage(null);
            return;
        }
        if (this.gDl != null) {
            this.gCj.removeHeaderView(this.gDl);
        }
        if (list.size() == 0) {
            this.grT.setVisibility(8);
            this.gDn.setDatas(list);
            this.gCj.setNextPage(null);
            return;
        }
        this.grT.setVisibility(0);
        this.gDn.setDatas(list);
        if (z) {
            bSf();
        } else {
            bOp();
        }
    }

    public void bSf() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.gCj.setNextPage(this.giV);
            }
            this.giV.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.giV.endLoadData();
        }
    }

    public void bOp() {
        if (this.gDm == null) {
            this.gDm = new i(this.mPageContext.getPageActivity());
            this.gDm.createView();
            this.gDm.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c12573").dR("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.gDm.getView().getParent() == null) {
            this.gCj.setNextPage(this.gDm);
        }
    }

    public void bOq() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.gCj.setNextPage(this.giV);
            }
            this.giV.showLoadingViewWithoutEmptyView();
            this.giV.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.gCj.setOnSrollToBottomListener(onScrollToBottomListener);
        this.giV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.gDn.b(fVar);
    }

    public NavigationBar bSa() {
        return this.mNavigationBar;
    }

    public void bPo() {
        if (this.gCj != null && j.isNetWorkAvailable()) {
            this.gCj.startPullRefresh();
        }
    }
}
