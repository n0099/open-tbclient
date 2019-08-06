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
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d {
    private TextView bCd;
    private View bCe;
    private ImageView bCf;
    private View bCg;
    private ImageView bCh;
    private ImageView bCi;
    private LinearLayout bCk;
    private TextView bCl;
    private View.OnClickListener bCn;
    private View bCo;
    private MorePopupWindow bCp;
    protected View bCq;
    private View bCr;
    private View bCs;
    private int bCt;
    private int bCu;
    private AdBaseWebViewActivity cXr;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean bCv = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.cXr = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.cXr.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.cXr.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.cXr.findViewById(R.id.view_navigation_bar);
        me("");
        this.bCk = (LinearLayout) this.cXr.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCk.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bCk.setLayoutParams(layoutParams);
        this.bCl = (TextView) this.cXr.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.cXr.findViewById(R.id.webview_progress);
        this.bCe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cXr != null && !d.this.cXr.webViewGoBack()) {
                    d.this.cXr.finish();
                }
            }
        });
        this.bCf = (ImageView) this.bCe.findViewById(R.id.widget_navi_back_button);
        this.bCf.setContentDescription(this.cXr.getResources().getString(R.string.back));
        this.bCg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cXr != null) {
                    d.this.cXr.finish();
                }
            }
        });
        this.bCh = (ImageView) this.bCg.findViewById(R.id.widget_navi_back_button);
        this.bCh.setContentDescription(this.cXr.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bCh.getLayoutParams();
        layoutParams2.leftMargin = l.g(this.cXr.getPageContext().getPageActivity(), R.dimen.ds4);
        this.bCh.setLayoutParams(layoutParams2);
        this.bCo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.UL();
            }
        });
        this.bCi = (ImageView) this.bCo.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.cXr.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.bCp = new MorePopupWindow(this.cXr.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.cXr.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void abz() {
                d.this.UL();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void abA() {
            }
        });
        this.bCq = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.bCq.setOnClickListener(this.cXr);
        if (com.baidu.tbadk.coreExtra.c.f.cJ(this.cXr.getPageContext().getPageActivity())) {
            this.bCq.setVisibility(0);
        } else {
            this.bCq.setVisibility(8);
        }
        this.bCp.refresh();
        this.bCs = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.bCs.setOnClickListener(this.cXr);
        this.bCr = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.bCr.setOnClickListener(this.cXr);
        abq();
    }

    private void abq() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = l.g(this.cXr.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.v(this.cXr.getPageContext().getPageActivity()).heightPixels;
        this.bCt = (i - statusBarHeight) - g;
        this.bCu = i - statusBarHeight;
    }

    public boolean abs() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean abu() {
        try {
            this.bCk.addView(this.cXr.createWebView());
            this.bCl.setVisibility(8);
            if (!this.bCv) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bCl.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.bCk.getLayoutParams().height = this.bCt;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.bCk.getLayoutParams().height = this.bCu;
        this.mNavigationBar.setVisibility(8);
    }

    public void dA(boolean z) {
        if (this.bCq != null) {
            if (z) {
                this.bCq.setVisibility(0);
            } else {
                this.bCq.setVisibility(8);
            }
            this.bCp.refresh();
        }
    }

    public void dB(boolean z) {
        if (this.bCo != null) {
            if (z) {
                this.bCo.setVisibility(0);
            } else {
                this.bCo.setVisibility(8);
            }
        }
    }

    public void UL() {
        this.bCp.showWindowInRightBottomOfHost();
    }

    public void UM() {
        com.baidu.adp.lib.g.g.a(this.bCp, this.cXr.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.bCl.setVisibility(8);
    }

    public void me(String str) {
        this.bCd = this.mNavigationBar.setCenterTextTitle(str);
        if (this.bCf != null && this.bCf.getVisibility() == 0 && this.bCh != null && this.bCh.getVisibility() == 0) {
            this.bCd.setMaxWidth(l.g(this.cXr.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.e(this.bCd, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.cXr.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an("c10898");
            anVar.bT("obj_url", eVar.linkUrl);
            anVar.P("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.cXr.getPageContext().getPageActivity(), eVar, true, abx())));
        }
    }

    private SparseArray<String> abx() {
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
            this.mNavigationBar.onChangeSkinType(this.cXr.getPageContext(), i);
        }
        if (this.bCp != null) {
            this.bCp.onChangeSkinType(this.cXr, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cXr.getPageContext(), i);
        }
        am.a(this.bCf, (int) R.drawable.selector_web_topbar_return_black, (int) R.drawable.selector_web_topbar_return_white, i);
        am.a(this.bCh, (int) R.drawable.selector_web_topbar_close_black, (int) R.drawable.selector_web_topbar_close_white, i);
        am.a(this.bCi, (int) R.drawable.selector_web_topbar_more_black, (int) R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bCk.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cXr.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.bX(null, this.cXr.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cXr.getResources().getString(R.string.refresh), this.bCn)));
        }
        this.mNoDataView.onChangeSkinType(this.cXr.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bCk.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.bCn = onClickListener;
    }

    public void release() {
        if (this.bCk != null) {
            this.bCk.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.bCp != null) {
            com.baidu.adp.lib.g.g.a(this.bCp, this.cXr.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCk.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.bCk.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.k(this.bCf, R.drawable.frs_star_navigation_bg);
        am.k(this.bCh, R.drawable.frs_star_navigation_bg);
        am.k(this.bCi, R.drawable.frs_star_navigation_bg);
        me("");
        this.cXr.getWindow().setFlags(1024, 1024);
    }

    public void aby() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCk.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bCk.setLayoutParams(layoutParams);
        this.bCf.setBackgroundDrawable(null);
        this.bCh.setBackgroundDrawable(null);
        this.bCi.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.cXr.getWindow().clearFlags(1024);
    }

    public void dD(boolean z) {
        this.bCv = z;
    }
}
