package com.baidu.tieba.ad.browser;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d {
    private TextView amN;
    private View amO;
    private ImageView amP;
    private ImageView amQ;
    private LinearLayout amS;
    private TextView amT;
    private View.OnClickListener amU;
    private View amV;
    private MorePopupWindow amW;
    protected View amX;
    private View amY;
    private View amZ;
    private int ana;
    private int anb;
    private AdBaseWebViewActivity bBD;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View amM = null;
    private ProgressBar mProgressBar = null;
    private boolean anc = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.bBD = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bBD.setContentView(e.h.base_webview_activity);
        this.amM = this.bBD.findViewById(e.g.root_view);
        this.mNavigationBar = (NavigationBar) this.bBD.findViewById(e.g.view_navigation_bar);
        dW("");
        this.amS = (LinearLayout) this.bBD.findViewById(e.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.amS.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.amS.setLayoutParams(layoutParams);
        this.amT = (TextView) this.bBD.findViewById(e.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.bBD.findViewById(e.g.webview_progress);
        this.amO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bBD != null) {
                    d.this.bBD.finish();
                }
            }
        });
        this.amP = (ImageView) this.amO.findViewById(e.g.widget_navi_back_button);
        this.amP.setContentDescription(this.bBD.getResources().getString(e.j.close));
        this.amV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.showPopMenu();
            }
        });
        this.amQ = (ImageView) this.amV.findViewById(e.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.bBD.getPageContext().getPageActivity()).inflate(e.h.tb_webview_pop_more, (ViewGroup) null);
        this.amW = new MorePopupWindow(this.bBD.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bBD.getPageContext().getResources().getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void xd() {
                d.this.showPopMenu();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void xe() {
            }
        });
        this.amX = inflate.findViewById(e.g.webview_more_pop_item_share_friend_layout);
        this.amX.setOnClickListener(this.bBD);
        if (com.baidu.tbadk.coreExtra.c.e.bL(this.bBD.getPageContext().getPageActivity())) {
            this.amX.setVisibility(0);
        } else {
            this.amX.setVisibility(8);
        }
        this.amW.refresh();
        this.amZ = inflate.findViewById(e.g.webview_more_pop_item_open_browser_layout);
        this.amZ.setOnClickListener(this.bBD);
        this.amY = inflate.findViewById(e.g.webview_more_pop_item_copy_link_layout);
        this.amY.setOnClickListener(this.bBD);
        wU();
    }

    private void wU() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.bBD.getPageContext().getPageActivity(), e.C0210e.ds98);
        int i = l.s(this.bBD.getPageContext().getPageActivity()).heightPixels;
        this.ana = (i - statusBarHeight) - h;
        this.anb = i - statusBarHeight;
    }

    public boolean wW() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean wY() {
        try {
            this.amS.addView(this.bBD.createWebView());
            this.amT.setVisibility(8);
            if (!this.anc) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.amT.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.amS.getLayoutParams().height = this.ana;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.amS.getLayoutParams().height = this.anb;
        this.mNavigationBar.setVisibility(8);
    }

    public void aR(boolean z) {
        if (this.amX != null) {
            if (z) {
                this.amX.setVisibility(0);
            } else {
                this.amX.setVisibility(8);
            }
            this.amW.refresh();
        }
    }

    public void aS(boolean z) {
        if (this.amV != null) {
            if (z) {
                this.amV.setVisibility(0);
            } else {
                this.amV.setVisibility(8);
            }
        }
    }

    public void showPopMenu() {
        this.amW.showWindowInRightBottomOfHost();
    }

    public void dismissPopMenu() {
        com.baidu.adp.lib.g.g.a(this.amW, this.bBD.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.amT.setVisibility(8);
    }

    public void dW(String str) {
        this.amN = this.mNavigationBar.setTitleText(str);
        al.b(this.amN, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.bBD.getPageContext().getPageActivity(), "share", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.aA("obj_url", dVar.linkUrl);
            amVar.x("obj_type", 0);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.bBD.getPageContext().getPageActivity(), dVar, true, xb())));
        }
    }

    private SparseArray<String> xb() {
        if (0 != 0) {
            return null;
        }
        SparseArray<String> sparseArray = new SparseArray<>(8);
        sparseArray.put(2, "pb_wx_timeline");
        sparseArray.put(3, "pb_wx_friend");
        sparseArray.put(4, "pb_qq_zone");
        sparseArray.put(5, "pb_tencent_weibo");
        sparseArray.put(6, "pb_sina_weibo");
        sparseArray.put(7, "pb_renren");
        return sparseArray;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bBD.getPageContext(), i);
        }
        if (this.amW != null) {
            this.amW.onChangeSkinType(this.bBD, i, al.getDrawable(e.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bBD.getPageContext(), i);
        }
        al.a(this.amP, e.f.icon_nav_close, e.f.icon_nav_close_w, e.f.icon_nav_close, i);
        al.a(this.amQ, e.f.icon_more_bg_s, e.f.icon_more_bg_s, e.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.amS.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bBD.getPageContext().getPageActivity(), this.amM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.aD(null, this.bBD.getPageContext().getString(e.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bBD.getResources().getString(e.j.refresh), this.amU)));
        }
        this.mNoDataView.onChangeSkinType(this.bBD.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.amS.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void c(View.OnClickListener onClickListener) {
        this.amU = onClickListener;
    }

    public void release() {
        if (this.amS != null) {
            this.amS.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.amW != null) {
            com.baidu.adp.lib.g.g.a(this.amW, this.bBD.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.amS.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.amS.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.i(this.amP, e.f.frs_star_navigation_bg);
        al.i(this.amQ, e.f.frs_star_navigation_bg);
        dW("");
        this.bBD.getWindow().setFlags(1024, 1024);
    }

    public void xc() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.amS.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.amS.setLayoutParams(layoutParams);
        this.amP.setBackgroundDrawable(null);
        this.amQ.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bBD.getWindow().clearFlags(1024);
    }

    public void aU(boolean z) {
        this.anc = z;
    }
}
