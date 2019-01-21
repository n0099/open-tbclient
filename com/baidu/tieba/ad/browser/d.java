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
    protected View anA;
    private View anB;
    private View anC;
    private int anD;
    private int anE;
    private TextView anq;
    private View anr;
    private ImageView ans;
    private ImageView ant;
    private LinearLayout anv;
    private TextView anw;
    private View.OnClickListener anx;
    private View any;
    private MorePopupWindow anz;
    private AdBaseWebViewActivity bCu;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View anp = null;
    private ProgressBar mProgressBar = null;
    private boolean anF = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.bCu = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bCu.setContentView(e.h.base_webview_activity);
        this.anp = this.bCu.findViewById(e.g.root_view);
        this.mNavigationBar = (NavigationBar) this.bCu.findViewById(e.g.view_navigation_bar);
        ef("");
        this.anv = (LinearLayout) this.bCu.findViewById(e.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.anv.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.anv.setLayoutParams(layoutParams);
        this.anw = (TextView) this.bCu.findViewById(e.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.bCu.findViewById(e.g.webview_progress);
        this.anr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bCu != null) {
                    d.this.bCu.finish();
                }
            }
        });
        this.ans = (ImageView) this.anr.findViewById(e.g.widget_navi_back_button);
        this.ans.setContentDescription(this.bCu.getResources().getString(e.j.close));
        this.any = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.showPopMenu();
            }
        });
        this.ant = (ImageView) this.any.findViewById(e.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.bCu.getPageContext().getPageActivity()).inflate(e.h.tb_webview_pop_more, (ViewGroup) null);
        this.anz = new MorePopupWindow(this.bCu.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bCu.getPageContext().getResources().getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void xq() {
                d.this.showPopMenu();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void xr() {
            }
        });
        this.anA = inflate.findViewById(e.g.webview_more_pop_item_share_friend_layout);
        this.anA.setOnClickListener(this.bCu);
        if (com.baidu.tbadk.coreExtra.c.e.bL(this.bCu.getPageContext().getPageActivity())) {
            this.anA.setVisibility(0);
        } else {
            this.anA.setVisibility(8);
        }
        this.anz.refresh();
        this.anC = inflate.findViewById(e.g.webview_more_pop_item_open_browser_layout);
        this.anC.setOnClickListener(this.bCu);
        this.anB = inflate.findViewById(e.g.webview_more_pop_item_copy_link_layout);
        this.anB.setOnClickListener(this.bCu);
        xh();
    }

    private void xh() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.bCu.getPageContext().getPageActivity(), e.C0210e.ds98);
        int i = l.s(this.bCu.getPageContext().getPageActivity()).heightPixels;
        this.anD = (i - statusBarHeight) - h;
        this.anE = i - statusBarHeight;
    }

    public boolean xj() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean xl() {
        try {
            this.anv.addView(this.bCu.createWebView());
            this.anw.setVisibility(8);
            if (!this.anF) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.anw.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.anv.getLayoutParams().height = this.anD;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.anv.getLayoutParams().height = this.anE;
        this.mNavigationBar.setVisibility(8);
    }

    public void aS(boolean z) {
        if (this.anA != null) {
            if (z) {
                this.anA.setVisibility(0);
            } else {
                this.anA.setVisibility(8);
            }
            this.anz.refresh();
        }
    }

    public void aT(boolean z) {
        if (this.any != null) {
            if (z) {
                this.any.setVisibility(0);
            } else {
                this.any.setVisibility(8);
            }
        }
    }

    public void showPopMenu() {
        this.anz.showWindowInRightBottomOfHost();
    }

    public void dismissPopMenu() {
        com.baidu.adp.lib.g.g.a(this.anz, this.bCu.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.anw.setVisibility(8);
    }

    public void ef(String str) {
        this.anq = this.mNavigationBar.setTitleText(str);
        al.b(this.anq, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.bCu.getPageContext().getPageActivity(), "share", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.aB("obj_url", dVar.linkUrl);
            amVar.y("obj_type", 0);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.bCu.getPageContext().getPageActivity(), dVar, true, xo())));
        }
    }

    private SparseArray<String> xo() {
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
            this.mNavigationBar.onChangeSkinType(this.bCu.getPageContext(), i);
        }
        if (this.anz != null) {
            this.anz.onChangeSkinType(this.bCu, i, al.getDrawable(e.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bCu.getPageContext(), i);
        }
        al.a(this.ans, e.f.icon_nav_close, e.f.icon_nav_close_w, e.f.icon_nav_close, i);
        al.a(this.ant, e.f.icon_more_bg_s, e.f.icon_more_bg_s, e.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.anv.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bCu.getPageContext().getPageActivity(), this.anp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.aE(null, this.bCu.getPageContext().getString(e.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bCu.getResources().getString(e.j.refresh), this.anx)));
        }
        this.mNoDataView.onChangeSkinType(this.bCu.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.anv.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void c(View.OnClickListener onClickListener) {
        this.anx = onClickListener;
    }

    public void release() {
        if (this.anv != null) {
            this.anv.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.anz != null) {
            com.baidu.adp.lib.g.g.a(this.anz, this.bCu.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.anv.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.anv.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.i(this.ans, e.f.frs_star_navigation_bg);
        al.i(this.ant, e.f.frs_star_navigation_bg);
        ef("");
        this.bCu.getWindow().setFlags(1024, 1024);
    }

    public void xp() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.anv.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.anv.setLayoutParams(layoutParams);
        this.ans.setBackgroundDrawable(null);
        this.ant.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bCu.getWindow().clearFlags(1024);
    }

    public void aV(boolean z) {
        this.anF = z;
    }
}
