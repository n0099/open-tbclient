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
    private TextView cKQ;
    private View cKR;
    private ImageView cKS;
    private ImageView cKT;
    private LinearLayout cKV;
    private TextView cKW;
    private View.OnClickListener cKY;
    private View cKZ;
    private MorePopupWindow cLa;
    protected View cLb;
    private int dYP;
    private int dYQ;
    private AdBaseWebViewActivity dYW;
    private ApkDownloadBannerView dYX;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey dYY = null;
    private com.baidu.tieba.ad.download.a.d dYZ = null;
    private boolean cLe = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.dYW = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dYW.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.dYW.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dYW.findViewById(R.id.view_navigation_bar);
        so("");
        this.cKV = (LinearLayout) this.dYW.findViewById(R.id.webview_container);
        this.dYX = (ApkDownloadBannerView) this.dYW.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKV.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKV.setLayoutParams(layoutParams);
        this.cKW = (TextView) this.dYW.findViewById(R.id.webview_crash_tip);
        this.cKR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dYW != null && !c.this.dYW.webViewGoBack()) {
                    c.this.dYW.finish();
                }
            }
        });
        this.cKS = (ImageView) this.cKR.findViewById(R.id.widget_navi_back_button);
        this.cKS.setContentDescription(this.dYW.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aYc();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.aYd();
            }
        });
        aYa();
    }

    private void aYa() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.dYW.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.dYW.getPageContext().getPageActivity()).heightPixels;
        this.dYP = (i - statusBarHeight) - dimens;
        this.dYQ = i - statusBarHeight;
    }

    public boolean azz() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean azB() {
        try {
            this.cKV.addView(this.dYW.createWebView());
            this.cKW.setVisibility(8);
            if (!this.cLe) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cKW.setVisibility(0);
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
        this.cKV.getLayoutParams().height = -1;
    }

    public void fp(boolean z) {
        if (this.cLb != null) {
            if (z) {
                this.cLb.setVisibility(0);
            } else {
                this.cLb.setVisibility(8);
            }
            this.cLa.refresh();
        }
    }

    public void fq(boolean z) {
        if (this.cKZ != null) {
            if (z) {
                this.cKZ.setVisibility(0);
            } else {
                this.cKZ.setVisibility(8);
            }
        }
    }

    public void arS() {
        g.dismissPopupWindow(this.cLa, this.dYW.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.cKW.setVisibility(8);
    }

    public void so(String str) {
        this.cKQ = this.mNavigationBar.setCenterTextTitle(str);
        if (this.cKS != null && this.cKS.getVisibility() == 0 && this.cKT != null && this.cKT.getVisibility() == 0) {
            this.cKQ.setMaxWidth(l.getDimens(this.dYW.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.cKQ, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dYW.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cy(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.X("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dYW.getPageContext().getPageActivity(), shareItem, true, azE())));
        }
    }

    private SparseArray<String> azE() {
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
            this.mNavigationBar.onChangeSkinType(this.dYW.getPageContext(), i);
        }
        if (this.cLa != null) {
            this.cLa.onChangeSkinType(this.dYW, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dYW.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.cKS, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.cKT, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.Lb, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cKV.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dYW.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.cA(null, this.dYW.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dYW.getResources().getString(R.string.refresh), this.cKY)));
        }
        this.mNoDataView.onChangeSkinType(this.dYW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cKV.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cKY = onClickListener;
    }

    public void release() {
        if (this.cKV != null) {
            this.cKV.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cLa != null) {
            g.dismissPopupWindow(this.cLa, this.dYW.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKV.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cKV.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.cKS, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cKT, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.Lb, R.drawable.frs_star_navigation_bg);
        so("");
        this.dYW.getWindow().setFlags(1024, 1024);
    }

    public void azF() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKV.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKV.setLayoutParams(layoutParams);
        this.cKS.setBackgroundDrawable(null);
        this.cKT.setBackgroundDrawable(null);
        this.Lb.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.dYW.getWindow().clearFlags(1024);
    }

    public void fs(boolean z) {
        this.cLe = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.dYY = downloadCacheKey;
        if (this.dYZ == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYi().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.dYX, d, "LANDING_PAGE");
            this.dYZ = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        aYc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYc() {
        if (this.dYY != null && this.dYZ != null) {
            com.baidu.tieba.ad.download.d.aYi().a(this.dYY, this.dYZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYd() {
        com.baidu.tieba.ad.download.d.aYi().b(this.dYY, this.dYZ);
    }
}
