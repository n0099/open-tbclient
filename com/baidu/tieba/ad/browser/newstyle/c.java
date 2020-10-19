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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
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
/* loaded from: classes21.dex */
public class c {
    private ImageView agR;
    private TextView egP;
    private View egQ;
    private ImageView egR;
    private ImageView egT;
    private LinearLayout egV;
    private TextView egW;
    private View.OnClickListener egY;
    private View egZ;
    private MorePopupWindow eha;
    protected View ehb;
    private int fDI;
    private int fDJ;
    private AdBaseWebViewActivity fDP;
    private ApkDownloadBannerView fDQ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey fDR = null;
    private com.baidu.tieba.ad.download.a.d fDS = null;
    private boolean ehe = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.fDP = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.fDP.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.fDP.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.fDP.findViewById(R.id.view_navigation_bar);
        zQ("");
        this.egV = (LinearLayout) this.fDP.findViewById(R.id.webview_container);
        this.fDQ = (ApkDownloadBannerView) this.fDP.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.egV.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.egV.setLayoutParams(layoutParams);
        this.egW = (TextView) this.fDP.findViewById(R.id.webview_crash_tip);
        this.egQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fDP != null && !c.this.fDP.webViewGoBack()) {
                    c.this.fDP.finish();
                }
            }
        });
        this.egR = (ImageView) this.egQ.findViewById(R.id.widget_navi_back_button);
        this.egR.setContentDescription(this.fDP.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.bEX();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.bEY();
            }
        });
        bEV();
    }

    private void bEV() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.fDP.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.fDP.getPageContext().getPageActivity()).heightPixels;
        this.fDI = (i - statusBarHeight) - dimens;
        this.fDJ = i - statusBarHeight;
    }

    public boolean beV() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean beX() {
        try {
            this.egV.addView(this.fDP.createWebView());
            this.egW.setVisibility(8);
            if (!this.ehe) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.egW.setVisibility(0);
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
        this.egV.getLayoutParams().height = -1;
    }

    public void hX(boolean z) {
        if (this.ehb != null) {
            if (z) {
                this.ehb.setVisibility(0);
            } else {
                this.ehb.setVisibility(8);
            }
            this.eha.refresh();
        }
    }

    public void hY(boolean z) {
        if (this.egZ != null) {
            if (z) {
                this.egZ.setVisibility(0);
            } else {
                this.egZ.setVisibility(8);
            }
        }
    }

    public void aVi() {
        g.dismissPopupWindow(this.eha, this.fDP.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.egW.setVisibility(8);
    }

    public void zQ(String str) {
        this.egP = this.mNavigationBar.setCenterTextTitle(str);
        if (this.egR != null && this.egR.getVisibility() == 0 && this.egT != null && this.egT.getVisibility() == 0) {
            this.egP.setMaxWidth(l.getDimens(this.fDP.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ap.setNavbarTitleColor(this.egP, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.fDP.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dK(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.aj("obj_type", 0);
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.fDP.getPageContext().getPageActivity(), shareItem, true, bfa())));
        }
    }

    private SparseArray<String> bfa() {
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
            this.mNavigationBar.onChangeSkinType(this.fDP.getPageContext(), i);
        }
        if (this.eha != null) {
            this.eha.onChangeSkinType(this.fDP, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fDP.getPageContext(), i);
        }
        ap.setNavbarIconSrc(this.egR, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        ap.setNavbarIconSrc(this.egT, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        ap.setNavbarIconSrc(this.agR, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.egV.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fDP.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dL(null, this.fDP.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fDP.getResources().getString(R.string.refresh), this.egY)));
        }
        this.mNoDataView.onChangeSkinType(this.fDP.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.egV.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.egY = onClickListener;
    }

    public void release() {
        if (this.egV != null) {
            this.egV.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.eha != null) {
            g.dismissPopupWindow(this.eha, this.fDP.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.egV.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.egV.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ap.setBackgroundResource(this.egR, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.egT, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agR, R.drawable.frs_star_navigation_bg);
        zQ("");
        this.fDP.getWindow().setFlags(1024, 1024);
    }

    public void bfc() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.egV.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.egV.setLayoutParams(layoutParams);
        this.egR.setBackgroundDrawable(null);
        this.egT.setBackgroundDrawable(null);
        this.agR.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.fDP.getWindow().clearFlags(1024);
    }

    public void ia(boolean z) {
        this.ehe = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.fDR = downloadCacheKey;
        if (this.fDS == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bFe().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.fDQ, d, "LANDING_PAGE");
            this.fDS = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        bEX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEX() {
        if (this.fDR != null && this.fDS != null) {
            com.baidu.tieba.ad.download.d.bFe().a(this.fDR, this.fDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEY() {
        com.baidu.tieba.ad.download.d.bFe().b(this.fDR, this.fDS);
    }
}
