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
    private ImageView agS;
    private TextView evg;
    private View evh;
    private ImageView evi;
    private ImageView evk;
    private LinearLayout evm;
    private TextView evn;
    private View.OnClickListener evp;
    private View evq;
    private MorePopupWindow evr;
    protected View evs;
    private int fRT;
    private int fRU;
    private AdBaseWebViewActivity fSa;
    private ApkDownloadBannerView fSb;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey fSc = null;
    private com.baidu.tieba.ad.download.a.d fSd = null;
    private boolean evv = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.fSa = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.fSa.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.fSa.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.fSa.findViewById(R.id.view_navigation_bar);
        Ax("");
        this.evm = (LinearLayout) this.fSa.findViewById(R.id.webview_container);
        this.fSb = (ApkDownloadBannerView) this.fSa.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evm.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.evm.setLayoutParams(layoutParams);
        this.evn = (TextView) this.fSa.findViewById(R.id.webview_crash_tip);
        this.evh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fSa != null && !c.this.fSa.webViewGoBack()) {
                    c.this.fSa.finish();
                }
            }
        });
        this.evi = (ImageView) this.evh.findViewById(R.id.widget_navi_back_button);
        this.evi.setContentDescription(this.fSa.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.bJp();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.bJq();
            }
        });
        bJn();
    }

    private void bJn() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.fSa.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.fSa.getPageContext().getPageActivity()).heightPixels;
        this.fRT = (i - statusBarHeight) - dimens;
        this.fRU = i - statusBarHeight;
    }

    public boolean bjo() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean bjq() {
        try {
            this.evm.addView(this.fSa.createWebView());
            this.evn.setVisibility(8);
            if (!this.evv) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.evn.setVisibility(0);
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
        this.evm.getLayoutParams().height = -1;
    }

    public void it(boolean z) {
        if (this.evs != null) {
            if (z) {
                this.evs.setVisibility(0);
            } else {
                this.evs.setVisibility(8);
            }
            this.evr.refresh();
        }
    }

    public void iu(boolean z) {
        if (this.evq != null) {
            if (z) {
                this.evq.setVisibility(0);
            } else {
                this.evq.setVisibility(8);
            }
        }
    }

    public void aZC() {
        g.dismissPopupWindow(this.evr, this.fSa.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.evn.setVisibility(8);
    }

    public void Ax(String str) {
        this.evg = this.mNavigationBar.setCenterTextTitle(str);
        if (this.evi != null && this.evi.getVisibility() == 0 && this.evk != null && this.evk.getVisibility() == 0) {
            this.evg.setMaxWidth(l.getDimens(this.fSa.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ap.setNavbarTitleColor(this.evg, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.fSa.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.al("obj_type", 0);
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.fSa.getPageContext().getPageActivity(), shareItem, true, bjt())));
        }
    }

    private SparseArray<String> bjt() {
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
            this.mNavigationBar.onChangeSkinType(this.fSa.getPageContext(), i);
        }
        if (this.evr != null) {
            this.evr.onChangeSkinType(this.fSa, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fSa.getPageContext(), i);
        }
        ap.setNavbarIconSrc(this.evi, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        ap.setNavbarIconSrc(this.evk, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        ap.setNavbarIconSrc(this.agS, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.evm.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fSa.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dS(null, this.fSa.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fSa.getResources().getString(R.string.refresh), this.evp)));
        }
        this.mNoDataView.onChangeSkinType(this.fSa.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.evm.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.evp = onClickListener;
    }

    public void release() {
        if (this.evm != null) {
            this.evm.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.evr != null) {
            g.dismissPopupWindow(this.evr, this.fSa.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evm.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.evm.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ap.setBackgroundResource(this.evi, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.evk, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agS, R.drawable.frs_star_navigation_bg);
        Ax("");
        this.fSa.getWindow().setFlags(1024, 1024);
    }

    public void bjv() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evm.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.evm.setLayoutParams(layoutParams);
        this.evi.setBackgroundDrawable(null);
        this.evk.setBackgroundDrawable(null);
        this.agS.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.fSa.getWindow().clearFlags(1024);
    }

    public void iw(boolean z) {
        this.evv = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.fSc = downloadCacheKey;
        if (this.fSd == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bJw().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.fSb, d, "LANDING_PAGE");
            this.fSd = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        bJp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJp() {
        if (this.fSc != null && this.fSd != null) {
            com.baidu.tieba.ad.download.d.bJw().a(this.fSc, this.fSd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJq() {
        com.baidu.tieba.ad.download.d.bJw().b(this.fSc, this.fSd);
    }
}
