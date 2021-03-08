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
/* loaded from: classes9.dex */
public class c {
    private BdUniqueId ahU;
    private int aln = -1;
    private String forumId;
    private PbListView gCf;
    private View gLi;
    private PopupWindow gLn;
    private View gLo;
    private BdTypeMultiColumnListView gWV;
    private TextView gXA;
    private View gXB;
    private View gXC;
    private com.baidu.tieba.frs.gametab.b gXE;
    private View gXX;
    private com.baidu.tieba.ala.frsgamelive.view.c gXY;
    private com.baidu.tieba.ala.frsgamelive.a.d gXZ;
    private boolean gXh;
    private boolean gXl;
    private d gXp;
    private TextView gXs;
    private TextView gXt;
    private TextView gXu;
    private TextView gXv;
    private View gXw;
    private NoNetworkView gXx;
    private TextView gXy;
    private TextView gXz;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private g mPullView;
    private View rootView;

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.gXl = false;
        this.mPageContext = tbPageContext;
        this.gXh = z;
        this.ahU = bdUniqueId;
        this.forumId = str;
        this.gXl = z2;
    }

    public void initView() {
        this.rootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        if (this.gXl) {
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
        this.gLi = this.rootView.findViewById(R.id.frs_game_live_topinfo);
        this.gXs = (TextView) this.rootView.findViewById(R.id.frs_game_live_num);
        this.gXt = (TextView) this.rootView.findViewById(R.id.frs_game_live_sort);
        this.gWV = (BdTypeMultiColumnListView) this.rootView.findViewById(R.id.listView);
        this.gWV.setColumnDiv((int) this.mPageContext.getResources().getDimension(R.dimen.ds16));
        this.gXx = (NoNetworkView) this.rootView.findViewById(R.id.vNoNetwork);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.ahU);
        this.gWV.setPullRefresh(this.mPullView);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.createView();
        this.gXZ = new com.baidu.tieba.ala.frsgamelive.a.d(this.mPageContext, this.gWV);
        this.gXt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bVs();
            }
        });
        if (this.gXh) {
            this.gXE = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.ahU, this.gXh);
            this.gWV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gXE.i(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void uv(int i) {
        if (i == 1) {
            if (this.gXt != null) {
                this.gXt.setText(this.mPageContext.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i == 2 && this.gXt != null) {
            this.gXt.setText(this.mPageContext.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void tV(int i) {
        if (this.gXs != null) {
            this.gXs.setText(this.mPageContext.getResources().getString(R.string.frs_game_live_num, au.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.gXt.setVisibility(8);
            } else {
                this.gXt.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aln != i) {
            this.aln = i;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        ap.setViewTextColor(this.gXs, R.color.CAM_X0109);
        ap.setViewTextColor(this.gXt, R.color.CAM_X0109);
        this.gWV.setContentBackgroundColor(ap.getColor(R.color.CAM_X0201));
        this.gXt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVs() {
        bSM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uu(int i) {
        uv(i);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gLn, this.mPageContext.getPageActivity());
        if (this.gXp != null) {
            this.gXp.uu(i);
        }
    }

    private void bVt() {
        if (this.gLo == null) {
            this.gLo = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.gXu = (TextView) this.gLo.findViewById(R.id.frs_game_live_hot);
            this.gXv = (TextView) this.gLo.findViewById(R.id.frs_game_live_new);
            this.gXw = this.gLo.findViewById(R.id.frs_game_live_sort_sepline);
            this.gXu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.uu(1);
                }
            });
            this.gXv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.uu(2);
                }
            });
        }
        if (this.gLn == null) {
            this.gLn = new PopupWindow(this.mPageContext.getPageActivity());
            this.gLn.setContentView(this.gLo);
            this.gLn.setWidth(-2);
            this.gLn.setHeight(-2);
            this.gLn.setAnimationStyle(16973826);
            this.gLn.setBackgroundDrawable(this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.gLn.setOutsideTouchable(true);
            this.gLn.setFocusable(true);
            this.gLn.setTouchable(true);
            this.gLn.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.bVu();
                }
            });
        }
    }

    private void bSM() {
        bVt();
        ap.setBackgroundResource(this.gLo, R.drawable.bg_ala_frs_game_live_sort_panel);
        ap.setBackgroundResource(this.gXu, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gXv, R.drawable.ala_frs_game_live_sort_selecor);
        ap.setBackgroundResource(this.gXw, R.color.CAM_X0204);
        ap.setViewTextColor(this.gXu, R.color.CAM_X0106);
        ap.setViewTextColor(this.gXv, R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.gXt.getLocationOnScreen(iArr);
        int height = ((View) this.gXt.getParent()).getHeight() - this.gXt.getHeight();
        if (iArr[1] - this.gLn.getHeight() <= 50) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.gLn, this.mPageContext.getPageActivity());
            return;
        }
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gLn, this.rootView, 0, (iArr[0] - (this.gXt.getWidth() / 2)) - this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gXt.getHeight());
        this.gLn.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVu() {
    }

    public View getRootView() {
        return this.rootView;
    }

    public BdTypeMultiColumnListView bVz() {
        return this.gWV;
    }

    public void a(d dVar) {
        this.gXp = dVar;
    }

    public void completePullRefresh() {
        this.gWV.completePullRefresh();
    }

    private void bVA() {
        if (this.gXX == null) {
            this.gXX = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.gXy = (TextView) this.gXX.findViewById(R.id.frs_game_live_recommand1);
            this.gXz = (TextView) this.gXX.findViewById(R.id.frs_game_live_recommand2);
            this.gXA = (TextView) this.gXX.findViewById(R.id.frs_game_live_recommand3);
            this.gXB = this.gXX.findViewById(R.id.frs_game_live_recommand_line1);
            this.gXC = this.gXX.findViewById(R.id.frs_game_live_recommand_line2);
        }
        bVr();
    }

    private void bVr() {
        ap.setViewTextColor(this.gXy, R.color.CAM_X0109);
        ap.setViewTextColor(this.gXz, R.color.CAM_X0109);
        ap.setViewTextColor(this.gXA, R.color.CAM_X0109);
        ap.setBackgroundResource(this.gXB, R.color.CAM_X0204);
        ap.setBackgroundResource(this.gXC, R.color.CAM_X0204);
    }

    public void d(List<n> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            bVA();
            this.gLi.setVisibility(8);
            if (this.gXX != null) {
                this.gWV.removeHeaderView(this.gXX);
                this.gWV.addHeaderView(this.gXX);
            }
            this.gXZ.setDatas(list);
            this.gWV.setNextPage(null);
            return;
        }
        if (this.gXX != null) {
            this.gWV.removeHeaderView(this.gXX);
        }
        if (list.size() == 0) {
            this.gLi.setVisibility(8);
            this.gXZ.setDatas(list);
            this.gWV.setNextPage(null);
            return;
        }
        this.gLi.setVisibility(0);
        this.gXZ.setDatas(list);
        if (z) {
            bVv();
        } else {
            bRD();
        }
    }

    public void bVv() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gWV.setNextPage(this.gCf);
            }
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.load_more));
            this.gCf.endLoadData();
        }
    }

    public void bRD() {
        if (this.gXY == null) {
            this.gXY = new com.baidu.tieba.ala.frsgamelive.view.c(this.mPageContext.getPageActivity());
            this.gXY.createView();
            this.gXY.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c12573").dR("fid", c.this.forumId));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.mPageContext.getPageActivity())));
                }
            });
        }
        if (this.gXY.getView().getParent() == null) {
            this.gWV.setNextPage(this.gXY);
        }
    }

    public void bRE() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gWV.setNextPage(this.gCf);
            }
            this.gCf.showLoadingViewWithoutEmptyView();
            this.gCf.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(final BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.gWV.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gCf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.c.8
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
        this.gXZ.b(hVar);
    }

    public NavigationBar bVq() {
        return this.mNavigationBar;
    }

    public void bSD() {
        if (this.gWV != null && j.isNetWorkAvailable()) {
            this.gWV.startPullRefresh();
        }
    }
}
