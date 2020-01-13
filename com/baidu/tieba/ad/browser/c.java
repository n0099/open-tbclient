package com.baidu.tieba.ad.browser;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c {
    private ImageView KG;
    private TextView cGN;
    private View cGO;
    private ImageView cGP;
    private ImageView cGQ;
    private LinearLayout cGS;
    private TextView cGT;
    private View.OnClickListener cGV;
    private View cGW;
    private MorePopupWindow cGX;
    protected View cGY;
    private View cGZ;
    private View cHa;
    private AdBaseWebViewActivity dUK;
    private int dUL;
    private int dUM;
    private View mCloseView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean cHb = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.dUK = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dUK.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.dUK.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dUK.findViewById(R.id.view_navigation_bar);
        rY("");
        this.cGS = (LinearLayout) this.dUK.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGS.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cGS.setLayoutParams(layoutParams);
        this.cGT = (TextView) this.dUK.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.dUK.findViewById(R.id.webview_progress);
        this.cGO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dUK != null && !c.this.dUK.webViewGoBack()) {
                    c.this.dUK.finish();
                }
            }
        });
        this.cGP = (ImageView) this.cGO.findViewById(R.id.widget_navi_back_button);
        this.cGP.setContentDescription(this.dUK.getResources().getString(R.string.back));
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dUK != null) {
                    c.this.dUK.finish();
                }
            }
        });
        this.cGQ = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cGQ.setContentDescription(this.dUK.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cGQ.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.dUK.getPageContext().getPageActivity(), R.dimen.ds4);
        this.cGQ.setLayoutParams(layoutParams2);
        this.cGW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.apE();
            }
        });
        this.KG = (ImageView) this.cGW.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.dUK.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.cGX = new MorePopupWindow(this.dUK.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.dUK.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void axs() {
                c.this.apE();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void axt() {
            }
        });
        this.cGY = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.cGY.setOnClickListener(this.dUK);
        if (com.baidu.tbadk.coreExtra.share.e.dQ(this.dUK.getPageContext().getPageActivity())) {
            this.cGY.setVisibility(0);
        } else {
            this.cGY.setVisibility(8);
        }
        this.cGX.refresh();
        this.cHa = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.cHa.setOnClickListener(this.dUK);
        this.cGZ = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.cGZ.setOnClickListener(this.dUK);
        aVL();
    }

    private void aVL() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.dUK.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.dUK.getPageContext().getPageActivity()).heightPixels;
        this.dUL = (i - statusBarHeight) - dimens;
        this.dUM = i - statusBarHeight;
    }

    public boolean axl() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean axn() {
        try {
            this.cGS.addView(this.dUK.createWebView());
            this.cGT.setVisibility(8);
            if (!this.cHb) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cGT.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.cGS.getLayoutParams().height = this.dUL;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.cGS.getLayoutParams().height = this.dUM;
        this.mNavigationBar.setVisibility(8);
    }

    public void fi(boolean z) {
        if (this.cGY != null) {
            if (z) {
                this.cGY.setVisibility(0);
            } else {
                this.cGY.setVisibility(8);
            }
            this.cGX.refresh();
        }
    }

    public void fj(boolean z) {
        if (this.cGW != null) {
            if (z) {
                this.cGW.setVisibility(0);
            } else {
                this.cGW.setVisibility(8);
            }
        }
    }

    public void apE() {
        this.cGX.showWindowInRightBottomOfHost();
    }

    public void apF() {
        g.dismissPopupWindow(this.cGX, this.dUK.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.cGT.setVisibility(8);
    }

    public void rY(String str) {
        this.cGN = this.mNavigationBar.setCenterTextTitle(str);
        if (this.cGP != null && this.cGP.getVisibility() == 0 && this.cGQ != null && this.cGQ.getVisibility() == 0) {
            this.cGN.setMaxWidth(l.getDimens(this.dUK.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.cGN, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dUK.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cp(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.Z("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dUK.getPageContext().getPageActivity(), shareItem, true, axq())));
        }
    }

    private SparseArray<String> axq() {
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
            this.mNavigationBar.onChangeSkinType(this.dUK.getPageContext(), i);
        }
        if (this.cGX != null) {
            this.cGX.onChangeSkinType(this.dUK, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dUK.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.cGP, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.cGQ, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.KG, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cGS.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dUK.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.cr(null, this.dUK.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dUK.getResources().getString(R.string.refresh), this.cGV)));
        }
        this.mNoDataView.onChangeSkinType(this.dUK.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cGS.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cGV = onClickListener;
    }

    public void release() {
        if (this.cGS != null) {
            this.cGS.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cGX != null) {
            g.dismissPopupWindow(this.cGX, this.dUK.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGS.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cGS.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.cGP, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cGQ, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.KG, R.drawable.frs_star_navigation_bg);
        rY("");
        this.dUK.getWindow().setFlags(1024, 1024);
    }

    public void axr() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGS.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cGS.setLayoutParams(layoutParams);
        this.cGP.setBackgroundDrawable(null);
        this.cGQ.setBackgroundDrawable(null);
        this.KG.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.dUK.getWindow().clearFlags(1024);
    }

    public void fl(boolean z) {
        this.cHb = z;
    }
}
