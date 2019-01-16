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
    private View anA;
    private View anB;
    private int anC;
    private int anD;
    private TextView anp;
    private View anq;
    private ImageView anr;
    private ImageView ans;
    private LinearLayout anu;
    private TextView anv;
    private View.OnClickListener anw;
    private View anx;
    private MorePopupWindow any;
    protected View anz;
    private AdBaseWebViewActivity bCt;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View ano = null;
    private ProgressBar mProgressBar = null;
    private boolean anE = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.bCt = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bCt.setContentView(e.h.base_webview_activity);
        this.ano = this.bCt.findViewById(e.g.root_view);
        this.mNavigationBar = (NavigationBar) this.bCt.findViewById(e.g.view_navigation_bar);
        ef("");
        this.anu = (LinearLayout) this.bCt.findViewById(e.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.anu.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.anu.setLayoutParams(layoutParams);
        this.anv = (TextView) this.bCt.findViewById(e.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.bCt.findViewById(e.g.webview_progress);
        this.anq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bCt != null) {
                    d.this.bCt.finish();
                }
            }
        });
        this.anr = (ImageView) this.anq.findViewById(e.g.widget_navi_back_button);
        this.anr.setContentDescription(this.bCt.getResources().getString(e.j.close));
        this.anx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.showPopMenu();
            }
        });
        this.ans = (ImageView) this.anx.findViewById(e.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.bCt.getPageContext().getPageActivity()).inflate(e.h.tb_webview_pop_more, (ViewGroup) null);
        this.any = new MorePopupWindow(this.bCt.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bCt.getPageContext().getResources().getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void xq() {
                d.this.showPopMenu();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void xr() {
            }
        });
        this.anz = inflate.findViewById(e.g.webview_more_pop_item_share_friend_layout);
        this.anz.setOnClickListener(this.bCt);
        if (com.baidu.tbadk.coreExtra.c.e.bL(this.bCt.getPageContext().getPageActivity())) {
            this.anz.setVisibility(0);
        } else {
            this.anz.setVisibility(8);
        }
        this.any.refresh();
        this.anB = inflate.findViewById(e.g.webview_more_pop_item_open_browser_layout);
        this.anB.setOnClickListener(this.bCt);
        this.anA = inflate.findViewById(e.g.webview_more_pop_item_copy_link_layout);
        this.anA.setOnClickListener(this.bCt);
        xh();
    }

    private void xh() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.bCt.getPageContext().getPageActivity(), e.C0210e.ds98);
        int i = l.s(this.bCt.getPageContext().getPageActivity()).heightPixels;
        this.anC = (i - statusBarHeight) - h;
        this.anD = i - statusBarHeight;
    }

    public boolean xj() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean xl() {
        try {
            this.anu.addView(this.bCt.createWebView());
            this.anv.setVisibility(8);
            if (!this.anE) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.anv.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.anu.getLayoutParams().height = this.anC;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.anu.getLayoutParams().height = this.anD;
        this.mNavigationBar.setVisibility(8);
    }

    public void aS(boolean z) {
        if (this.anz != null) {
            if (z) {
                this.anz.setVisibility(0);
            } else {
                this.anz.setVisibility(8);
            }
            this.any.refresh();
        }
    }

    public void aT(boolean z) {
        if (this.anx != null) {
            if (z) {
                this.anx.setVisibility(0);
            } else {
                this.anx.setVisibility(8);
            }
        }
    }

    public void showPopMenu() {
        this.any.showWindowInRightBottomOfHost();
    }

    public void dismissPopMenu() {
        com.baidu.adp.lib.g.g.a(this.any, this.bCt.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.anv.setVisibility(8);
    }

    public void ef(String str) {
        this.anp = this.mNavigationBar.setTitleText(str);
        al.b(this.anp, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.bCt.getPageContext().getPageActivity(), "share", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.aB("obj_url", dVar.linkUrl);
            amVar.y("obj_type", 0);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.bCt.getPageContext().getPageActivity(), dVar, true, xo())));
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
            this.mNavigationBar.onChangeSkinType(this.bCt.getPageContext(), i);
        }
        if (this.any != null) {
            this.any.onChangeSkinType(this.bCt, i, al.getDrawable(e.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bCt.getPageContext(), i);
        }
        al.a(this.anr, e.f.icon_nav_close, e.f.icon_nav_close_w, e.f.icon_nav_close, i);
        al.a(this.ans, e.f.icon_more_bg_s, e.f.icon_more_bg_s, e.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.anu.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bCt.getPageContext().getPageActivity(), this.ano, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.aE(null, this.bCt.getPageContext().getString(e.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bCt.getResources().getString(e.j.refresh), this.anw)));
        }
        this.mNoDataView.onChangeSkinType(this.bCt.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.anu.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void c(View.OnClickListener onClickListener) {
        this.anw = onClickListener;
    }

    public void release() {
        if (this.anu != null) {
            this.anu.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.any != null) {
            com.baidu.adp.lib.g.g.a(this.any, this.bCt.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.anu.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.anu.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.i(this.anr, e.f.frs_star_navigation_bg);
        al.i(this.ans, e.f.frs_star_navigation_bg);
        ef("");
        this.bCt.getWindow().setFlags(1024, 1024);
    }

    public void xp() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.anu.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.anu.setLayoutParams(layoutParams);
        this.anr.setBackgroundDrawable(null);
        this.ans.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bCt.getWindow().clearFlags(1024);
    }

    public void aV(boolean z) {
        this.anE = z;
    }
}
