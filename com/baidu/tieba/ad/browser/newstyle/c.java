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
    private ImageView aiV;
    private TextView eIY;
    private View eIZ;
    private ImageView eJa;
    private ImageView eJc;
    private LinearLayout eJe;
    private TextView eJf;
    private View.OnClickListener eJh;
    private View eJi;
    private MorePopupWindow eJj;
    protected View eJk;
    private int giB;
    private int giC;
    private AdBaseWebViewActivity gix;
    private ApkDownloadBannerView giy;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey giz = null;
    private d giA = null;
    private boolean eJn = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.gix = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.gix.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.gix.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.gix.findViewById(R.id.view_navigation_bar);
        zK("");
        this.eJe = (LinearLayout) this.gix.findViewById(R.id.webview_container);
        this.giy = (ApkDownloadBannerView) this.gix.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJe.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eJe.setLayoutParams(layoutParams);
        this.eJf = (TextView) this.gix.findViewById(R.id.webview_crash_tip);
        this.eIZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gix != null && !c.this.gix.webViewGoBack()) {
                    c.this.gix.finish();
                }
            }
        });
        this.eJa = (ImageView) this.eIZ.findViewById(R.id.widget_navi_back_button);
        this.eJa.setContentDescription(this.gix.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.bLu();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.bLv();
            }
        });
        bLt();
    }

    private void bLt() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.gix.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.gix.getPageContext().getPageActivity()).heightPixels;
        this.giB = (i - statusBarHeight) - dimens;
        this.giC = i - statusBarHeight;
    }

    public boolean bkC() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean bkE() {
        try {
            this.eJe.addView(this.gix.createWebView());
            this.eJf.setVisibility(8);
            if (!this.eJn) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.eJf.setVisibility(0);
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
        this.eJe.getLayoutParams().height = -1;
    }

    public void jc(boolean z) {
        if (this.eJk != null) {
            if (z) {
                this.eJk.setVisibility(0);
            } else {
                this.eJk.setVisibility(8);
            }
            this.eJj.refresh();
        }
    }

    public void jd(boolean z) {
        if (this.eJi != null) {
            if (z) {
                this.eJi.setVisibility(0);
            } else {
                this.eJi.setVisibility(8);
            }
        }
    }

    public void baP() {
        g.dismissPopupWindow(this.eJj, this.gix.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.eJf.setVisibility(8);
    }

    public void zK(String str) {
        this.eIY = this.mNavigationBar.setCenterTextTitle(str);
        if (this.eJa != null && this.eJa.getVisibility() == 0 && this.eJc != null && this.eJc.getVisibility() == 0) {
            this.eIY.setMaxWidth(l.getDimens(this.gix.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ap.setNavbarTitleColor(this.eIY, R.color.CAM_X0105, R.color.s_navbar_title_color);
    }

    public void showShareDialog(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.gix.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ar arVar = new ar(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            arVar.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            arVar.aq("obj_type", 0);
            TiebaStatic.log(arVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.gix.getPageContext().getPageActivity(), shareItem, true, bkH())));
        }
    }

    private SparseArray<String> bkH() {
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
            this.mNavigationBar.onChangeSkinType(this.gix.getPageContext(), i);
        }
        if (this.eJj != null) {
            this.eJj.onChangeSkinType(this.gix, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gix.getPageContext(), i);
        }
        ap.setNavbarIconSrc(this.eJa, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        ap.setNavbarIconSrc(this.eJc, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        ap.setNavbarIconSrc(this.aiV, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.eJe.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gix.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dS(null, this.gix.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gix.getResources().getString(R.string.refresh), this.eJh)));
        }
        this.mNoDataView.onChangeSkinType(this.gix.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.eJe.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void h(View.OnClickListener onClickListener) {
        this.eJh = onClickListener;
    }

    public void release() {
        if (this.eJe != null) {
            this.eJe.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.eJj != null) {
            g.dismissPopupWindow(this.eJj, this.gix.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJe.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.eJe.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ap.setBackgroundResource(this.eJa, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.eJc, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.aiV, R.drawable.frs_star_navigation_bg);
        zK("");
        this.gix.getWindow().setFlags(1024, 1024);
    }

    public void bkJ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJe.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eJe.setLayoutParams(layoutParams);
        this.eJa.setBackgroundDrawable(null);
        this.eJc.setBackgroundDrawable(null);
        this.aiV.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.gix.getWindow().clearFlags(1024);
    }

    public void jf(boolean z) {
        this.eJn = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.giz = downloadCacheKey;
        if (this.giA == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLC().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.giy, d, "LANDING_PAGE");
            this.giA = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.c((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        bLu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLu() {
        if (this.giz != null && this.giA != null) {
            com.baidu.tieba.ad.download.d.bLC().a(this.giz, this.giA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLv() {
        com.baidu.tieba.ad.download.d.bLC().b(this.giz, this.giA);
    }
}
