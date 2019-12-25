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
/* loaded from: classes5.dex */
public class c {
    private ImageView KA;
    private TextView cGB;
    private View cGC;
    private ImageView cGD;
    private ImageView cGE;
    private LinearLayout cGG;
    private TextView cGH;
    private View.OnClickListener cGJ;
    private View cGK;
    private MorePopupWindow cGL;
    protected View cGM;
    private int dUC;
    private int dUD;
    private AdBaseWebViewActivity dUJ;
    private ApkDownloadBannerView dUK;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey dUL = null;
    private com.baidu.tieba.ad.download.a.d dUM = null;
    private boolean cGP = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.dUJ = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dUJ.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.dUJ.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dUJ.findViewById(R.id.view_navigation_bar);
        rV("");
        this.cGG = (LinearLayout) this.dUJ.findViewById(R.id.webview_container);
        this.dUK = (ApkDownloadBannerView) this.dUJ.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGG.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cGG.setLayoutParams(layoutParams);
        this.cGH = (TextView) this.dUJ.findViewById(R.id.webview_crash_tip);
        this.cGC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dUJ != null && !c.this.dUJ.webViewGoBack()) {
                    c.this.dUJ.finish();
                }
            }
        });
        this.cGD = (ImageView) this.cGC.findViewById(R.id.widget_navi_back_button);
        this.cGD.setContentDescription(this.dUJ.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aVu();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.aVv();
            }
        });
        aVs();
    }

    private void aVs() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.dUJ.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.dUJ.getPageContext().getPageActivity()).heightPixels;
        this.dUC = (i - statusBarHeight) - dimens;
        this.dUD = i - statusBarHeight;
    }

    public boolean awS() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean awU() {
        try {
            this.cGG.addView(this.dUJ.createWebView());
            this.cGH.setVisibility(8);
            if (!this.cGP) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cGH.setVisibility(0);
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
        this.cGG.getLayoutParams().height = -1;
    }

    public void fd(boolean z) {
        if (this.cGM != null) {
            if (z) {
                this.cGM.setVisibility(0);
            } else {
                this.cGM.setVisibility(8);
            }
            this.cGL.refresh();
        }
    }

    public void fe(boolean z) {
        if (this.cGK != null) {
            if (z) {
                this.cGK.setVisibility(0);
            } else {
                this.cGK.setVisibility(8);
            }
        }
    }

    public void apm() {
        g.dismissPopupWindow(this.cGL, this.dUJ.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.cGH.setVisibility(8);
    }

    public void rV(String str) {
        this.cGB = this.mNavigationBar.setCenterTextTitle(str);
        if (this.cGD != null && this.cGD.getVisibility() == 0 && this.cGE != null && this.cGE.getVisibility() == 0) {
            this.cGB.setMaxWidth(l.getDimens(this.dUJ.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.cGB, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dUJ.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cp(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.Z("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dUJ.getPageContext().getPageActivity(), shareItem, true, awX())));
        }
    }

    private SparseArray<String> awX() {
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
            this.mNavigationBar.onChangeSkinType(this.dUJ.getPageContext(), i);
        }
        if (this.cGL != null) {
            this.cGL.onChangeSkinType(this.dUJ, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dUJ.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.cGD, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.cGE, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.KA, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cGG.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dUJ.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.cr(null, this.dUJ.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dUJ.getResources().getString(R.string.refresh), this.cGJ)));
        }
        this.mNoDataView.onChangeSkinType(this.dUJ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cGG.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.cGJ = onClickListener;
    }

    public void release() {
        if (this.cGG != null) {
            this.cGG.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cGL != null) {
            g.dismissPopupWindow(this.cGL, this.dUJ.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGG.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cGG.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.cGD, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cGE, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.KA, R.drawable.frs_star_navigation_bg);
        rV("");
        this.dUJ.getWindow().setFlags(1024, 1024);
    }

    public void awY() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGG.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cGG.setLayoutParams(layoutParams);
        this.cGD.setBackgroundDrawable(null);
        this.cGE.setBackgroundDrawable(null);
        this.KA.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.dUJ.getWindow().clearFlags(1024);
    }

    public void fg(boolean z) {
        this.cGP = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.dUL = downloadCacheKey;
        if (this.dUM == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.aVA().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.dUK, d, "LANDING_PAGE");
            this.dUM = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        aVu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVu() {
        if (this.dUL != null && this.dUM != null) {
            com.baidu.tieba.ad.download.d.aVA().a(this.dUL, this.dUM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVv() {
        com.baidu.tieba.ad.download.d.aVA().b(this.dUL, this.dUM);
    }
}
