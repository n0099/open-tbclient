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
import com.baidu.tbadk.core.util.ar;
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
import com.baidu.tieba.ad.download.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    private ImageView ahC;
    private ImageView eHB;
    private LinearLayout eHD;
    private TextView eHE;
    private View.OnClickListener eHG;
    private View eHH;
    private MorePopupWindow eHI;
    protected View eHJ;
    private TextView eHx;
    private View eHy;
    private ImageView eHz;
    private AdBaseWebViewActivity ggN;
    private ApkDownloadBannerView ggO;
    private int ggR;
    private int ggS;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey ggP = null;
    private d ggQ = null;
    private boolean eHM = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.ggN = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.ggN.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.ggN.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.ggN.findViewById(R.id.view_navigation_bar);
        zD("");
        this.eHD = (LinearLayout) this.ggN.findViewById(R.id.webview_container);
        this.ggO = (ApkDownloadBannerView) this.ggN.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eHD.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eHD.setLayoutParams(layoutParams);
        this.eHE = (TextView) this.ggN.findViewById(R.id.webview_crash_tip);
        this.eHy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ggN != null && !c.this.ggN.webViewGoBack()) {
                    c.this.ggN.finish();
                }
            }
        });
        this.eHz = (ImageView) this.eHy.findViewById(R.id.widget_navi_back_button);
        this.eHz.setContentDescription(this.ggN.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.bLl();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.bLm();
            }
        });
        bLk();
    }

    private void bLk() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.ggN.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.ggN.getPageContext().getPageActivity()).heightPixels;
        this.ggR = (i - statusBarHeight) - dimens;
        this.ggS = i - statusBarHeight;
    }

    public boolean bkA() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean bkC() {
        try {
            this.eHD.addView(this.ggN.createWebView());
            this.eHE.setVisibility(8);
            if (!this.eHM) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.eHE.setVisibility(0);
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
        this.eHD.getLayoutParams().height = -1;
    }

    public void jc(boolean z) {
        if (this.eHJ != null) {
            if (z) {
                this.eHJ.setVisibility(0);
            } else {
                this.eHJ.setVisibility(8);
            }
            this.eHI.refresh();
        }
    }

    public void jd(boolean z) {
        if (this.eHH != null) {
            if (z) {
                this.eHH.setVisibility(0);
            } else {
                this.eHH.setVisibility(8);
            }
        }
    }

    public void baM() {
        g.dismissPopupWindow(this.eHI, this.ggN.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.eHE.setVisibility(8);
    }

    public void zD(String str) {
        this.eHx = this.mNavigationBar.setCenterTextTitle(str);
        if (this.eHz != null && this.eHz.getVisibility() == 0 && this.eHB != null && this.eHB.getVisibility() == 0) {
            this.eHx.setMaxWidth(l.getDimens(this.ggN.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ap.setNavbarTitleColor(this.eHx, R.color.CAM_X0105, R.color.s_navbar_title_color);
    }

    public void showShareDialog(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.ggN.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ar arVar = new ar(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            arVar.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            arVar.ap("obj_type", 0);
            TiebaStatic.log(arVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.ggN.getPageContext().getPageActivity(), shareItem, true, bkF())));
        }
    }

    private SparseArray<String> bkF() {
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
            this.mNavigationBar.onChangeSkinType(this.ggN.getPageContext(), i);
        }
        if (this.eHI != null) {
            this.eHI.onChangeSkinType(this.ggN, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ggN.getPageContext(), i);
        }
        ap.setNavbarIconSrc(this.eHz, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        ap.setNavbarIconSrc(this.eHB, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        ap.setNavbarIconSrc(this.ahC, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.eHD.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ggN.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dS(null, this.ggN.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ggN.getResources().getString(R.string.refresh), this.eHG)));
        }
        this.mNoDataView.onChangeSkinType(this.ggN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.eHD.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void h(View.OnClickListener onClickListener) {
        this.eHG = onClickListener;
    }

    public void release() {
        if (this.eHD != null) {
            this.eHD.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.eHI != null) {
            g.dismissPopupWindow(this.eHI, this.ggN.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eHD.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.eHD.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ap.setBackgroundResource(this.eHz, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.eHB, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.ahC, R.drawable.frs_star_navigation_bg);
        zD("");
        this.ggN.getWindow().setFlags(1024, 1024);
    }

    public void bkH() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eHD.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eHD.setLayoutParams(layoutParams);
        this.eHz.setBackgroundDrawable(null);
        this.eHB.setBackgroundDrawable(null);
        this.ahC.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.ggN.getWindow().clearFlags(1024);
    }

    public void jf(boolean z) {
        this.eHM = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.ggP = downloadCacheKey;
        if (this.ggQ == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLt().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.ggO, d, "LANDING_PAGE");
            this.ggQ = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        bLl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLl() {
        if (this.ggP != null && this.ggQ != null) {
            com.baidu.tieba.ad.download.d.bLt().a(this.ggP, this.ggQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLm() {
        com.baidu.tieba.ad.download.d.bLt().b(this.ggP, this.ggQ);
    }
}
