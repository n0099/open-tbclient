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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d {
    private TextView aaW;
    private View aaX;
    private ImageView aaY;
    private ImageView aaZ;
    private LinearLayout abb;
    private TextView abd;
    private View.OnClickListener abe;
    private View abf;
    private MorePopupWindow abg;
    protected View abh;
    private View abi;
    private View abj;
    private int abk;
    private int abl;
    private AdBaseWebViewActivity bnx;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View aaV = null;
    private ProgressBar mProgressBar = null;
    private boolean abm = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.bnx = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bnx.setContentView(d.h.base_webview_activity);
        this.aaV = this.bnx.findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) this.bnx.findViewById(d.g.view_navigation_bar);
        cV("");
        this.abb = (LinearLayout) this.bnx.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abb.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.abb.setLayoutParams(layoutParams);
        this.abd = (TextView) this.bnx.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.bnx.findViewById(d.g.webview_progress);
        this.aaX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bnx != null) {
                    d.this.bnx.finish();
                }
            }
        });
        this.aaY = (ImageView) this.aaX.findViewById(d.g.widget_navi_back_button);
        this.aaY.setContentDescription(this.bnx.getResources().getString(d.j.close));
        this.abf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.sy();
            }
        });
        this.aaZ = (ImageView) this.abf.findViewById(d.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.bnx.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.abg = new MorePopupWindow(this.bnx.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bnx.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void sC() {
                d.this.sy();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void sD() {
            }
        });
        this.abh = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.abh.setOnClickListener(this.bnx);
        if (com.baidu.tbadk.coreExtra.c.e.aY(this.bnx.getPageContext().getPageActivity())) {
            this.abh.setVisibility(0);
        } else {
            this.abh.setVisibility(8);
        }
        this.abg.refresh();
        this.abj = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.abj.setOnClickListener(this.bnx);
        this.abi = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.abi.setOnClickListener(this.bnx);
        sr();
    }

    private void sr() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int f = l.f(this.bnx.getPageContext().getPageActivity(), d.e.ds98);
        int i = l.p(this.bnx.getPageContext().getPageActivity()).heightPixels;
        this.abk = (i - statusBarHeight) - f;
        this.abl = i - statusBarHeight;
    }

    public boolean st() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean sv() {
        try {
            this.abb.addView(this.bnx.createWebView());
            this.abd.setVisibility(8);
            if (!this.abm) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.abd.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.abb.getLayoutParams().height = this.abk;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.abb.getLayoutParams().height = this.abl;
        this.mNavigationBar.setVisibility(8);
    }

    public void af(boolean z) {
        if (this.abh != null) {
            if (z) {
                this.abh.setVisibility(0);
            } else {
                this.abh.setVisibility(8);
            }
            this.abg.refresh();
        }
    }

    public void ag(boolean z) {
        if (this.abf != null) {
            if (z) {
                this.abf.setVisibility(0);
            } else {
                this.abf.setVisibility(8);
            }
        }
    }

    public void sy() {
        this.abg.showWindowInRightBottomOfHost();
    }

    public void sz() {
        com.baidu.adp.lib.g.g.a(this.abg, this.bnx.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.abd.setVisibility(8);
    }

    public void cV(String str) {
        this.aaW = this.mNavigationBar.setTitleText(str);
        am.b(this.aaW, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.bnx.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            an anVar = new an("c10898");
            anVar.af("obj_url", dVar.linkUrl);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.bnx.getPageContext().getPageActivity(), dVar, true, sA())));
        }
    }

    private SparseArray<String> sA() {
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
            this.mNavigationBar.onChangeSkinType(this.bnx.getPageContext(), i);
        }
        if (this.abg != null) {
            this.abg.onChangeSkinType(this.bnx, i, am.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bnx.getPageContext(), i);
        }
        am.a(this.aaY, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        am.a(this.aaZ, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.abb.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bnx.getPageContext().getPageActivity(), this.aaV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ah(null, this.bnx.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bnx.getResources().getString(d.j.refresh), this.abe)));
        }
        this.mNoDataView.onChangeSkinType(this.bnx.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.abb.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.abe = onClickListener;
    }

    public void release() {
        if (this.abb != null) {
            this.abb.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.abg != null) {
            com.baidu.adp.lib.g.g.a(this.abg, this.bnx.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abb.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.abb.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.i(this.aaY, d.f.frs_star_navigation_bg);
        am.i(this.aaZ, d.f.frs_star_navigation_bg);
        cV("");
        this.bnx.getWindow().setFlags(1024, 1024);
    }

    public void sB() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abb.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.abb.setLayoutParams(layoutParams);
        this.aaY.setBackgroundDrawable(null);
        this.aaZ.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bnx.getWindow().clearFlags(1024);
    }

    public void ai(boolean z) {
        this.abm = z;
    }
}
