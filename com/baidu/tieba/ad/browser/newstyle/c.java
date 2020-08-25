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
/* loaded from: classes15.dex */
public class c {
    private ImageView agf;
    private View dSA;
    private ImageView dSB;
    private ImageView dSD;
    private LinearLayout dSF;
    private TextView dSG;
    private View.OnClickListener dSI;
    private View dSJ;
    private MorePopupWindow dSK;
    protected View dSL;
    private TextView dSz;
    private int fom;
    private int fon;
    private AdBaseWebViewActivity fot;
    private ApkDownloadBannerView fou;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey fov = null;
    private com.baidu.tieba.ad.download.a.d fow = null;
    private boolean dSO = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.fot = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.fot.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.fot.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.fot.findViewById(R.id.view_navigation_bar);
        yI("");
        this.dSF = (LinearLayout) this.fot.findViewById(R.id.webview_container);
        this.fou = (ApkDownloadBannerView) this.fot.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSF.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dSF.setLayoutParams(layoutParams);
        this.dSG = (TextView) this.fot.findViewById(R.id.webview_crash_tip);
        this.dSA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fot != null && !c.this.fot.webViewGoBack()) {
                    c.this.fot.finish();
                }
            }
        });
        this.dSB = (ImageView) this.dSA.findViewById(R.id.widget_navi_back_button);
        this.dSB.setContentDescription(this.fot.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.bAY();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.bAZ();
            }
        });
        bAW();
    }

    private void bAW() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.fot.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.fot.getPageContext().getPageActivity()).heightPixels;
        this.fom = (i - statusBarHeight) - dimens;
        this.fon = i - statusBarHeight;
    }

    public boolean bbt() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean bbv() {
        try {
            this.dSF.addView(this.fot.createWebView());
            this.dSG.setVisibility(8);
            if (!this.dSO) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dSG.setVisibility(0);
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
        this.dSF.getLayoutParams().height = -1;
    }

    public void hD(boolean z) {
        if (this.dSL != null) {
            if (z) {
                this.dSL.setVisibility(0);
            } else {
                this.dSL.setVisibility(8);
            }
            this.dSK.refresh();
        }
    }

    public void hE(boolean z) {
        if (this.dSJ != null) {
            if (z) {
                this.dSJ.setVisibility(0);
            } else {
                this.dSJ.setVisibility(8);
            }
        }
    }

    public void aRN() {
        g.dismissPopupWindow(this.dSK, this.fot.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.dSG.setVisibility(8);
    }

    public void yI(String str) {
        this.dSz = this.mNavigationBar.setCenterTextTitle(str);
        if (this.dSB != null && this.dSB.getVisibility() == 0 && this.dSD != null && this.dSD.getVisibility() == 0) {
            this.dSz.setMaxWidth(l.getDimens(this.fot.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ap.setNavbarTitleColor(this.dSz, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.fot.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dD(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.ai("obj_type", 0);
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.fot.getPageContext().getPageActivity(), shareItem, true, bby())));
        }
    }

    private SparseArray<String> bby() {
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
            this.mNavigationBar.onChangeSkinType(this.fot.getPageContext(), i);
        }
        if (this.dSK != null) {
            this.dSK.onChangeSkinType(this.fot, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fot.getPageContext(), i);
        }
        ap.setNavbarIconSrc(this.dSB, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        ap.setNavbarIconSrc(this.dSD, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        ap.setNavbarIconSrc(this.agf, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dSF.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fot.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dE(null, this.fot.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fot.getResources().getString(R.string.refresh), this.dSI)));
        }
        this.mNoDataView.onChangeSkinType(this.fot.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dSF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dSI = onClickListener;
    }

    public void release() {
        if (this.dSF != null) {
            this.dSF.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dSK != null) {
            g.dismissPopupWindow(this.dSK, this.fot.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSF.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dSF.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ap.setBackgroundResource(this.dSB, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.dSD, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agf, R.drawable.frs_star_navigation_bg);
        yI("");
        this.fot.getWindow().setFlags(1024, 1024);
    }

    public void bbA() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSF.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dSF.setLayoutParams(layoutParams);
        this.dSB.setBackgroundDrawable(null);
        this.dSD.setBackgroundDrawable(null);
        this.agf.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.fot.getWindow().clearFlags(1024);
    }

    public void hG(boolean z) {
        this.dSO = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.fov = downloadCacheKey;
        if (this.fow == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bBf().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.fou, d, "LANDING_PAGE");
            this.fow = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        bAY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAY() {
        if (this.fov != null && this.fow != null) {
            com.baidu.tieba.ad.download.d.bBf().a(this.fov, this.fow);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAZ() {
        com.baidu.tieba.ad.download.d.bBf().b(this.fov, this.fow);
    }
}
