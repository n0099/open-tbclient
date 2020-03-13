package com.baidu.tieba.ad.browser.newstyle;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.browser.newstyle.view.ApkDownloadBannerView;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c {
    private ImageView Lb;
    private TextView cKS;
    private View cKT;
    private ImageView cKU;
    private ImageView cKV;
    private LinearLayout cKX;
    private TextView cKY;
    private View.OnClickListener cLa;
    private View cLb;
    private MorePopupWindow cLc;
    protected View cLd;
    private int dZd;
    private int dZe;
    private AdBaseWebViewActivity dZk;
    private ApkDownloadBannerView dZl;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey dZm = null;
    private com.baidu.tieba.ad.download.a.d dZn = null;
    private boolean cLg = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.dZk = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dZk.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.dZk.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dZk.findViewById(R.id.view_navigation_bar);
        so("");
        this.cKX = (LinearLayout) this.dZk.findViewById(R.id.webview_container);
        this.dZl = (ApkDownloadBannerView) this.dZk.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKX.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKX.setLayoutParams(layoutParams);
        this.cKY = (TextView) this.dZk.findViewById(R.id.webview_crash_tip);
        this.cKT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dZk != null && !c.this.dZk.webViewGoBack()) {
                    c.this.dZk.finish();
                }
            }
        });
        this.cKU = (ImageView) this.cKT.findViewById(R.id.widget_navi_back_button);
        this.cKU.setContentDescription(this.dZk.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aYf();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.aYg();
            }
        });
        aYd();
    }

    private void aYd() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.dZk.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.dZk.getPageContext().getPageActivity()).heightPixels;
        this.dZd = (i - statusBarHeight) - dimens;
        this.dZe = i - statusBarHeight;
    }

    public boolean azB() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean azD() {
        try {
            this.cKX.addView(this.dZk.createWebView());
            this.cKY.setVisibility(8);
            if (!this.cLg) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cKY.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.mNavigationBar.setVisibility(0);
        } else {
            this.mNavigationBar.setVisibility(8);
        }
        this.cKX.getLayoutParams().height = -1;
    }

    public void fp(boolean z) {
        if (this.cLd != null) {
            if (z) {
                this.cLd.setVisibility(0);
            } else {
                this.cLd.setVisibility(8);
            }
            this.cLc.refresh();
        }
    }

    public void fq(boolean z) {
        if (this.cLb != null) {
            if (z) {
                this.cLb.setVisibility(0);
            } else {
                this.cLb.setVisibility(8);
            }
        }
    }

    public void arU() {
        g.dismissPopupWindow(this.cLc, this.dZk.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.cKY.setVisibility(8);
    }

    public void so(String str) {
        this.cKS = this.mNavigationBar.setCenterTextTitle(str);
        if (this.cKU != null && this.cKU.getVisibility() == 0 && this.cKV != null && this.cKV.getVisibility() == 0) {
            this.cKS.setMaxWidth(l.getDimens(this.dZk.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.cKS, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dZk.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cy(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.X("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dZk.getPageContext().getPageActivity(), shareItem, true, azG())));
        }
    }

    private SparseArray<String> azG() {
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
            this.mNavigationBar.onChangeSkinType(this.dZk.getPageContext(), i);
        }
        if (this.cLc != null) {
            this.cLc.onChangeSkinType(this.dZk, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dZk.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.cKU, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.cKV, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.Lb, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cKX.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dZk.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.cA(null, this.dZk.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dZk.getResources().getString(R.string.refresh), this.cLa)));
        }
        this.mNoDataView.onChangeSkinType(this.dZk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cKX.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cLa = onClickListener;
    }

    public void release() {
        if (this.cKX != null) {
            this.cKX.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cLc != null) {
            g.dismissPopupWindow(this.cLc, this.dZk.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKX.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cKX.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.cKU, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cKV, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.Lb, R.drawable.frs_star_navigation_bg);
        so("");
        this.dZk.getWindow().setFlags(1024, 1024);
    }

    public void azH() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKX.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKX.setLayoutParams(layoutParams);
        this.cKU.setBackgroundDrawable(null);
        this.cKV.setBackgroundDrawable(null);
        this.Lb.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.dZk.getWindow().clearFlags(1024);
    }

    public void fs(boolean z) {
        this.cLg = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.dZm = downloadCacheKey;
        if (this.dZn == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYl().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.dZl, d, "LANDING_PAGE");
            this.dZn = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        aYf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYf() {
        if (this.dZm != null && this.dZn != null) {
            com.baidu.tieba.ad.download.d.aYl().a(this.dZm, this.dZn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYg() {
        com.baidu.tieba.ad.download.d.aYl().b(this.dZm, this.dZn);
    }
}
