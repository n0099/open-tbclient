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
import com.baidu.tieba.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d {
    private TextView aaX;
    private View aaY;
    private ImageView aaZ;
    private ImageView aba;
    private LinearLayout abd;
    private TextView abe;
    private View.OnClickListener abf;
    private View abg;
    private MorePopupWindow abh;
    protected View abi;
    private View abj;
    private View abk;
    private int abl;
    private int abm;
    private AdBaseWebViewActivity bnA;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View aaW = null;
    private ProgressBar mProgressBar = null;
    private boolean abn = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.bnA = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bnA.setContentView(f.h.base_webview_activity);
        this.aaW = this.bnA.findViewById(f.g.root_view);
        this.mNavigationBar = (NavigationBar) this.bnA.findViewById(f.g.view_navigation_bar);
        cW("");
        this.abd = (LinearLayout) this.bnA.findViewById(f.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abd.getLayoutParams();
        layoutParams.addRule(3, f.g.view_navigation_bar);
        this.abd.setLayoutParams(layoutParams);
        this.abe = (TextView) this.bnA.findViewById(f.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.bnA.findViewById(f.g.webview_progress);
        this.aaY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, f.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bnA != null) {
                    d.this.bnA.finish();
                }
            }
        });
        this.aaZ = (ImageView) this.aaY.findViewById(f.g.widget_navi_back_button);
        this.aaZ.setContentDescription(this.bnA.getResources().getString(f.j.close));
        this.abg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.sx();
            }
        });
        this.aba = (ImageView) this.abg.findViewById(f.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.bnA.getPageContext().getPageActivity()).inflate(f.h.tb_webview_pop_more, (ViewGroup) null);
        this.abh = new MorePopupWindow(this.bnA.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bnA.getPageContext().getResources().getDrawable(f.C0146f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void sB() {
                d.this.sx();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void sC() {
            }
        });
        this.abi = inflate.findViewById(f.g.webview_more_pop_item_share_friend_layout);
        this.abi.setOnClickListener(this.bnA);
        if (com.baidu.tbadk.coreExtra.c.e.aX(this.bnA.getPageContext().getPageActivity())) {
            this.abi.setVisibility(0);
        } else {
            this.abi.setVisibility(8);
        }
        this.abh.refresh();
        this.abk = inflate.findViewById(f.g.webview_more_pop_item_open_browser_layout);
        this.abk.setOnClickListener(this.bnA);
        this.abj = inflate.findViewById(f.g.webview_more_pop_item_copy_link_layout);
        this.abj.setOnClickListener(this.bnA);
        sq();
    }

    private void sq() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int f = l.f(this.bnA.getPageContext().getPageActivity(), f.e.ds98);
        int i = l.o(this.bnA.getPageContext().getPageActivity()).heightPixels;
        this.abl = (i - statusBarHeight) - f;
        this.abm = i - statusBarHeight;
    }

    public boolean ss() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean su() {
        try {
            this.abd.addView(this.bnA.createWebView());
            this.abe.setVisibility(8);
            if (!this.abn) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.abe.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.abd.getLayoutParams().height = this.abl;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.abd.getLayoutParams().height = this.abm;
        this.mNavigationBar.setVisibility(8);
    }

    public void ag(boolean z) {
        if (this.abi != null) {
            if (z) {
                this.abi.setVisibility(0);
            } else {
                this.abi.setVisibility(8);
            }
            this.abh.refresh();
        }
    }

    public void ah(boolean z) {
        if (this.abg != null) {
            if (z) {
                this.abg.setVisibility(0);
            } else {
                this.abg.setVisibility(8);
            }
        }
    }

    public void sx() {
        this.abh.showWindowInRightBottomOfHost();
    }

    public void sy() {
        com.baidu.adp.lib.g.g.a(this.abh, this.bnA.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.abe.setVisibility(8);
    }

    public void cW(String str) {
        this.aaX = this.mNavigationBar.setTitleText(str);
        am.b(this.aaX, f.d.cp_cont_b, f.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.bnA.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            an anVar = new an("c10898");
            anVar.ae("obj_url", dVar.linkUrl);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.bnA.getPageContext().getPageActivity(), dVar, true, sz())));
        }
    }

    private SparseArray<String> sz() {
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
            this.mNavigationBar.onChangeSkinType(this.bnA.getPageContext(), i);
        }
        if (this.abh != null) {
            this.abh.onChangeSkinType(this.bnA, i, am.getDrawable(f.C0146f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bnA.getPageContext(), i);
        }
        am.a(this.aaZ, f.C0146f.icon_nav_close, f.C0146f.icon_nav_close_w, f.C0146f.icon_nav_close, i);
        am.a(this.aba, f.C0146f.icon_more_bg_s, f.C0146f.icon_more_bg_s, f.C0146f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.abd.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bnA.getPageContext().getPageActivity(), this.aaW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ag(null, this.bnA.getPageContext().getString(f.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bnA.getResources().getString(f.j.refresh), this.abf)));
        }
        this.mNoDataView.onChangeSkinType(this.bnA.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.abd.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.abf = onClickListener;
    }

    public void release() {
        if (this.abd != null) {
            this.abd.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.abh != null) {
            com.baidu.adp.lib.g.g.a(this.abh, this.bnA.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abd.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.abd.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.i(this.aaZ, f.C0146f.frs_star_navigation_bg);
        am.i(this.aba, f.C0146f.frs_star_navigation_bg);
        cW("");
        this.bnA.getWindow().setFlags(1024, 1024);
    }

    public void sA() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abd.getLayoutParams();
        layoutParams.addRule(3, f.g.view_navigation_bar);
        this.abd.setLayoutParams(layoutParams);
        this.aaZ.setBackgroundDrawable(null);
        this.aba.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bnA.getWindow().clearFlags(1024);
    }

    public void aj(boolean z) {
        this.abn = z;
    }
}
