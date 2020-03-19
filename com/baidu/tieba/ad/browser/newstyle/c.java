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
    private TextView cLd;
    private View cLe;
    private ImageView cLf;
    private ImageView cLg;
    private LinearLayout cLi;
    private TextView cLj;
    private View.OnClickListener cLl;
    private View cLm;
    private MorePopupWindow cLn;
    protected View cLo;
    private AdBaseWebViewActivity dZA;
    private ApkDownloadBannerView dZB;
    private int dZt;
    private int dZu;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey dZC = null;
    private com.baidu.tieba.ad.download.a.d dZD = null;
    private boolean cLr = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.dZA = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dZA.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.dZA.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dZA.findViewById(R.id.view_navigation_bar);
        so("");
        this.cLi = (LinearLayout) this.dZA.findViewById(R.id.webview_container);
        this.dZB = (ApkDownloadBannerView) this.dZA.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cLi.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cLi.setLayoutParams(layoutParams);
        this.cLj = (TextView) this.dZA.findViewById(R.id.webview_crash_tip);
        this.cLe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dZA != null && !c.this.dZA.webViewGoBack()) {
                    c.this.dZA.finish();
                }
            }
        });
        this.cLf = (ImageView) this.cLe.findViewById(R.id.widget_navi_back_button);
        this.cLf.setContentDescription(this.dZA.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aYj();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.aYk();
            }
        });
        aYh();
    }

    private void aYh() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.dZA.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.dZA.getPageContext().getPageActivity()).heightPixels;
        this.dZt = (i - statusBarHeight) - dimens;
        this.dZu = i - statusBarHeight;
    }

    public boolean azE() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean azG() {
        try {
            this.cLi.addView(this.dZA.createWebView());
            this.cLj.setVisibility(8);
            if (!this.cLr) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cLj.setVisibility(0);
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
        this.cLi.getLayoutParams().height = -1;
    }

    public void fq(boolean z) {
        if (this.cLo != null) {
            if (z) {
                this.cLo.setVisibility(0);
            } else {
                this.cLo.setVisibility(8);
            }
            this.cLn.refresh();
        }
    }

    public void fr(boolean z) {
        if (this.cLm != null) {
            if (z) {
                this.cLm.setVisibility(0);
            } else {
                this.cLm.setVisibility(8);
            }
        }
    }

    public void arX() {
        g.dismissPopupWindow(this.cLn, this.dZA.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.cLj.setVisibility(8);
    }

    public void so(String str) {
        this.cLd = this.mNavigationBar.setCenterTextTitle(str);
        if (this.cLf != null && this.cLf.getVisibility() == 0 && this.cLg != null && this.cLg.getVisibility() == 0) {
            this.cLd.setMaxWidth(l.getDimens(this.dZA.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.cLd, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dZA.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cx(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.X("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dZA.getPageContext().getPageActivity(), shareItem, true, azJ())));
        }
    }

    private SparseArray<String> azJ() {
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
            this.mNavigationBar.onChangeSkinType(this.dZA.getPageContext(), i);
        }
        if (this.cLn != null) {
            this.cLn.onChangeSkinType(this.dZA, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dZA.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.cLf, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.cLg, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.Lb, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cLi.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dZA.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.cz(null, this.dZA.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dZA.getResources().getString(R.string.refresh), this.cLl)));
        }
        this.mNoDataView.onChangeSkinType(this.dZA.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cLi.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cLl = onClickListener;
    }

    public void release() {
        if (this.cLi != null) {
            this.cLi.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cLn != null) {
            g.dismissPopupWindow(this.cLn, this.dZA.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cLi.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cLi.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.cLf, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cLg, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.Lb, R.drawable.frs_star_navigation_bg);
        so("");
        this.dZA.getWindow().setFlags(1024, 1024);
    }

    public void azK() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cLi.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cLi.setLayoutParams(layoutParams);
        this.cLf.setBackgroundDrawable(null);
        this.cLg.setBackgroundDrawable(null);
        this.Lb.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.dZA.getWindow().clearFlags(1024);
    }

    public void ft(boolean z) {
        this.cLr = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.dZC = downloadCacheKey;
        if (this.dZD == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYp().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.dZB, d, "LANDING_PAGE");
            this.dZD = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        aYj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYj() {
        if (this.dZC != null && this.dZD != null) {
            com.baidu.tieba.ad.download.d.aYp().a(this.dZC, this.dZD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYk() {
        com.baidu.tieba.ad.download.d.aYp().b(this.dZC, this.dZD);
    }
}
