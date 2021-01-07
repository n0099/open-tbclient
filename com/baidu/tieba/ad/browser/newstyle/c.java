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
    private ImageView aiG;
    private TextView eKc;
    private View eKd;
    private ImageView eKe;
    private ImageView eKg;
    private LinearLayout eKi;
    private TextView eKj;
    private View.OnClickListener eKl;
    private View eKm;
    private MorePopupWindow eKn;
    protected View eKo;
    private AdBaseWebViewActivity gjh;
    private ApkDownloadBannerView gji;
    private int gjl;
    private int gjm;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey gjj = null;
    private d gjk = null;
    private boolean eKr = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.gjh = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.gjh.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.gjh.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.gjh.findViewById(R.id.view_navigation_bar);
        Ax("");
        this.eKi = (LinearLayout) this.gjh.findViewById(R.id.webview_container);
        this.gji = (ApkDownloadBannerView) this.gjh.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKi.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eKi.setLayoutParams(layoutParams);
        this.eKj = (TextView) this.gjh.findViewById(R.id.webview_crash_tip);
        this.eKd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gjh != null && !c.this.gjh.webViewGoBack()) {
                    c.this.gjh.finish();
                }
            }
        });
        this.eKe = (ImageView) this.eKd.findViewById(R.id.widget_navi_back_button);
        this.eKe.setContentDescription(this.gjh.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.bOJ();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.bOK();
            }
        });
        bOI();
    }

    private void bOI() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.gjh.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.gjh.getPageContext().getPageActivity()).heightPixels;
        this.gjl = (i - statusBarHeight) - dimens;
        this.gjm = i - statusBarHeight;
    }

    public boolean boc() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean boe() {
        try {
            this.eKi.addView(this.gjh.createWebView());
            this.eKj.setVisibility(8);
            if (!this.eKr) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.eKj.setVisibility(0);
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
        this.eKi.getLayoutParams().height = -1;
    }

    public void je(boolean z) {
        if (this.eKo != null) {
            if (z) {
                this.eKo.setVisibility(0);
            } else {
                this.eKo.setVisibility(8);
            }
            this.eKn.refresh();
        }
    }

    public void jf(boolean z) {
        if (this.eKm != null) {
            if (z) {
                this.eKm.setVisibility(0);
            } else {
                this.eKm.setVisibility(8);
            }
        }
    }

    public void bet() {
        g.dismissPopupWindow(this.eKn, this.gjh.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.eKj.setVisibility(8);
    }

    public void Ax(String str) {
        this.eKc = this.mNavigationBar.setCenterTextTitle(str);
        if (this.eKe != null && this.eKe.getVisibility() == 0 && this.eKg != null && this.eKg.getVisibility() == 0) {
            this.eKc.setMaxWidth(l.getDimens(this.gjh.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ao.setNavbarTitleColor(this.eKc, R.color.CAM_X0105, R.color.s_navbar_title_color);
    }

    public void showShareDialog(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.gjh.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dX(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.an("obj_type", 0);
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.gjh.getPageContext().getPageActivity(), shareItem, true, boh())));
        }
    }

    private SparseArray<String> boh() {
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
            this.mNavigationBar.onChangeSkinType(this.gjh.getPageContext(), i);
        }
        if (this.eKn != null) {
            this.eKn.onChangeSkinType(this.gjh, i, ao.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gjh.getPageContext(), i);
        }
        ao.setNavbarIconSrc(this.eKe, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        ao.setNavbarIconSrc(this.eKg, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        ao.setNavbarIconSrc(this.aiG, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.eKi.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gjh.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dY(null, this.gjh.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gjh.getResources().getString(R.string.refresh), this.eKl)));
        }
        this.mNoDataView.onChangeSkinType(this.gjh.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.eKi.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void h(View.OnClickListener onClickListener) {
        this.eKl = onClickListener;
    }

    public void release() {
        if (this.eKi != null) {
            this.eKi.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.eKn != null) {
            g.dismissPopupWindow(this.eKn, this.gjh.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKi.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.eKi.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ao.setBackgroundResource(this.eKe, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.eKg, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.aiG, R.drawable.frs_star_navigation_bg);
        Ax("");
        this.gjh.getWindow().setFlags(1024, 1024);
    }

    public void boj() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKi.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eKi.setLayoutParams(layoutParams);
        this.eKe.setBackgroundDrawable(null);
        this.eKg.setBackgroundDrawable(null);
        this.aiG.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.gjh.getWindow().clearFlags(1024);
    }

    public void jh(boolean z) {
        this.eKr = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.gjj = downloadCacheKey;
        if (this.gjk == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bOR().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.gji, d, "LANDING_PAGE");
            this.gjk = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        bOJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOJ() {
        if (this.gjj != null && this.gjk != null) {
            com.baidu.tieba.ad.download.d.bOR().a(this.gjj, this.gjk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOK() {
        com.baidu.tieba.ad.download.d.bOR().b(this.gjj, this.gjk);
    }
}
