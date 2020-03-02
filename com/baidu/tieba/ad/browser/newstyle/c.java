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
    private TextView cKR;
    private View cKS;
    private ImageView cKT;
    private ImageView cKU;
    private LinearLayout cKW;
    private TextView cKX;
    private View.OnClickListener cKZ;
    private View cLa;
    private MorePopupWindow cLb;
    protected View cLc;
    private int dYQ;
    private int dYR;
    private AdBaseWebViewActivity dYX;
    private ApkDownloadBannerView dYY;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey dYZ = null;
    private com.baidu.tieba.ad.download.a.d dZa = null;
    private boolean cLf = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.dYX = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dYX.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.dYX.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dYX.findViewById(R.id.view_navigation_bar);
        so("");
        this.cKW = (LinearLayout) this.dYX.findViewById(R.id.webview_container);
        this.dYY = (ApkDownloadBannerView) this.dYX.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKW.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKW.setLayoutParams(layoutParams);
        this.cKX = (TextView) this.dYX.findViewById(R.id.webview_crash_tip);
        this.cKS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dYX != null && !c.this.dYX.webViewGoBack()) {
                    c.this.dYX.finish();
                }
            }
        });
        this.cKT = (ImageView) this.cKS.findViewById(R.id.widget_navi_back_button);
        this.cKT.setContentDescription(this.dYX.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aYe();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.aYf();
            }
        });
        aYc();
    }

    private void aYc() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.dYX.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.dYX.getPageContext().getPageActivity()).heightPixels;
        this.dYQ = (i - statusBarHeight) - dimens;
        this.dYR = i - statusBarHeight;
    }

    public boolean azB() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean azD() {
        try {
            this.cKW.addView(this.dYX.createWebView());
            this.cKX.setVisibility(8);
            if (!this.cLf) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cKX.setVisibility(0);
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
        this.cKW.getLayoutParams().height = -1;
    }

    public void fp(boolean z) {
        if (this.cLc != null) {
            if (z) {
                this.cLc.setVisibility(0);
            } else {
                this.cLc.setVisibility(8);
            }
            this.cLb.refresh();
        }
    }

    public void fq(boolean z) {
        if (this.cLa != null) {
            if (z) {
                this.cLa.setVisibility(0);
            } else {
                this.cLa.setVisibility(8);
            }
        }
    }

    public void arU() {
        g.dismissPopupWindow(this.cLb, this.dYX.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.cKX.setVisibility(8);
    }

    public void so(String str) {
        this.cKR = this.mNavigationBar.setCenterTextTitle(str);
        if (this.cKT != null && this.cKT.getVisibility() == 0 && this.cKU != null && this.cKU.getVisibility() == 0) {
            this.cKR.setMaxWidth(l.getDimens(this.dYX.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.cKR, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dYX.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cy(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.X("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dYX.getPageContext().getPageActivity(), shareItem, true, azG())));
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
            this.mNavigationBar.onChangeSkinType(this.dYX.getPageContext(), i);
        }
        if (this.cLb != null) {
            this.cLb.onChangeSkinType(this.dYX, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dYX.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.cKT, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.cKU, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.Lb, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cKW.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dYX.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.cA(null, this.dYX.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dYX.getResources().getString(R.string.refresh), this.cKZ)));
        }
        this.mNoDataView.onChangeSkinType(this.dYX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cKW.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cKZ = onClickListener;
    }

    public void release() {
        if (this.cKW != null) {
            this.cKW.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cLb != null) {
            g.dismissPopupWindow(this.cLb, this.dYX.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKW.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cKW.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.cKT, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cKU, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.Lb, R.drawable.frs_star_navigation_bg);
        so("");
        this.dYX.getWindow().setFlags(1024, 1024);
    }

    public void azH() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKW.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKW.setLayoutParams(layoutParams);
        this.cKT.setBackgroundDrawable(null);
        this.cKU.setBackgroundDrawable(null);
        this.Lb.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.dYX.getWindow().clearFlags(1024);
    }

    public void fs(boolean z) {
        this.cLf = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.dYZ = downloadCacheKey;
        if (this.dZa == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYk().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.dYY, d, "LANDING_PAGE");
            this.dZa = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        aYe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYe() {
        if (this.dYZ != null && this.dZa != null) {
            com.baidu.tieba.ad.download.d.aYk().a(this.dYZ, this.dZa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYf() {
        com.baidu.tieba.ad.download.d.aYk().b(this.dYZ, this.dZa);
    }
}
