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
import com.baidu.tbadk.core.util.ao;
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
import com.baidu.tieba.ad.download.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    private ImageView ahO;
    private View.OnClickListener eFA;
    private View eFB;
    private MorePopupWindow eFC;
    protected View eFD;
    private TextView eFr;
    private View eFs;
    private ImageView eFt;
    private ImageView eFv;
    private LinearLayout eFx;
    private TextView eFy;
    private ApkDownloadBannerView geA;
    private int geD;
    private int geE;
    private AdBaseWebViewActivity gez;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey geB = null;
    private d geC = null;
    private boolean eFG = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.gez = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.gez.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.gez.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.gez.findViewById(R.id.view_navigation_bar);
        zm("");
        this.eFx = (LinearLayout) this.gez.findViewById(R.id.webview_container);
        this.geA = (ApkDownloadBannerView) this.gez.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eFx.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eFx.setLayoutParams(layoutParams);
        this.eFy = (TextView) this.gez.findViewById(R.id.webview_crash_tip);
        this.eFs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gez != null && !c.this.gez.webViewGoBack()) {
                    c.this.gez.finish();
                }
            }
        });
        this.eFt = (ImageView) this.eFs.findViewById(R.id.widget_navi_back_button);
        this.eFt.setContentDescription(this.gez.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.bKR();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.bKS();
            }
        });
        bKQ();
    }

    private void bKQ() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.gez.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.gez.getPageContext().getPageActivity()).heightPixels;
        this.geD = (i - statusBarHeight) - dimens;
        this.geE = i - statusBarHeight;
    }

    public boolean bki() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean bkk() {
        try {
            this.eFx.addView(this.gez.createWebView());
            this.eFy.setVisibility(8);
            if (!this.eFG) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.eFy.setVisibility(0);
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
        this.eFx.getLayoutParams().height = -1;
    }

    public void ja(boolean z) {
        if (this.eFD != null) {
            if (z) {
                this.eFD.setVisibility(0);
            } else {
                this.eFD.setVisibility(8);
            }
            this.eFC.refresh();
        }
    }

    public void jb(boolean z) {
        if (this.eFB != null) {
            if (z) {
                this.eFB.setVisibility(0);
            } else {
                this.eFB.setVisibility(8);
            }
        }
    }

    public void baz() {
        g.dismissPopupWindow(this.eFC, this.gez.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.eFy.setVisibility(8);
    }

    public void zm(String str) {
        this.eFr = this.mNavigationBar.setCenterTextTitle(str);
        if (this.eFt != null && this.eFt.getVisibility() == 0 && this.eFv != null && this.eFv.getVisibility() == 0) {
            this.eFr.setMaxWidth(l.getDimens(this.gez.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ao.setNavbarTitleColor(this.eFr, R.color.CAM_X0105, R.color.s_navbar_title_color);
    }

    public void showShareDialog(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.gez.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dW(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.an("obj_type", 0);
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.gez.getPageContext().getPageActivity(), shareItem, true, bkn())));
        }
    }

    private SparseArray<String> bkn() {
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
            this.mNavigationBar.onChangeSkinType(this.gez.getPageContext(), i);
        }
        if (this.eFC != null) {
            this.eFC.onChangeSkinType(this.gez, i, ao.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gez.getPageContext(), i);
        }
        ao.setNavbarIconSrc(this.eFt, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        ao.setNavbarIconSrc(this.eFv, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        ao.setNavbarIconSrc(this.ahO, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.eFx.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gez.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dX(null, this.gez.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gez.getResources().getString(R.string.refresh), this.eFA)));
        }
        this.mNoDataView.onChangeSkinType(this.gez.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.eFx.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void h(View.OnClickListener onClickListener) {
        this.eFA = onClickListener;
    }

    public void release() {
        if (this.eFx != null) {
            this.eFx.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.eFC != null) {
            g.dismissPopupWindow(this.eFC, this.gez.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eFx.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.eFx.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ao.setBackgroundResource(this.eFt, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.eFv, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.ahO, R.drawable.frs_star_navigation_bg);
        zm("");
        this.gez.getWindow().setFlags(1024, 1024);
    }

    public void bkp() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eFx.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eFx.setLayoutParams(layoutParams);
        this.eFt.setBackgroundDrawable(null);
        this.eFv.setBackgroundDrawable(null);
        this.ahO.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.gez.getWindow().clearFlags(1024);
    }

    public void jd(boolean z) {
        this.eFG = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.geB = downloadCacheKey;
        if (this.geC == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bKZ().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.geA, d, "LANDING_PAGE");
            this.geC = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        bKR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKR() {
        if (this.geB != null && this.geC != null) {
            com.baidu.tieba.ad.download.d.bKZ().a(this.geB, this.geC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKS() {
        com.baidu.tieba.ad.download.d.bKZ().b(this.geB, this.geC);
    }
}
