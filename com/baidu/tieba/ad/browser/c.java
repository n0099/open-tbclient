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
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class c {
    private ImageView agh;
    private TextView dSD;
    private View dSE;
    private ImageView dSF;
    private View dSG;
    private ImageView dSH;
    private LinearLayout dSJ;
    private TextView dSK;
    private View.OnClickListener dSM;
    private View dSN;
    private MorePopupWindow dSO;
    protected View dSP;
    private View dSQ;
    private View dSR;
    private AdBaseWebViewActivity fop;
    private int foq;

    /* renamed from: for  reason: not valid java name */
    private int f2for;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean dSS = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.fop = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.fop.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.fop.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.fop.findViewById(R.id.view_navigation_bar);
        yJ("");
        this.dSJ = (LinearLayout) this.fop.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSJ.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dSJ.setLayoutParams(layoutParams);
        this.dSK = (TextView) this.fop.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.fop.findViewById(R.id.webview_progress);
        this.dSE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fop != null && !c.this.fop.webViewGoBack()) {
                    c.this.fop.finish();
                }
            }
        });
        this.dSF = (ImageView) this.dSE.findViewById(R.id.widget_navi_back_button);
        this.dSF.setContentDescription(this.fop.getResources().getString(R.string.back));
        this.dSG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fop != null) {
                    c.this.fop.finish();
                }
            }
        });
        this.dSH = (ImageView) this.dSG.findViewById(R.id.widget_navi_back_button);
        this.dSH.setContentDescription(this.fop.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dSH.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.fop.getPageContext().getPageActivity(), R.dimen.ds4);
        this.dSH.setLayoutParams(layoutParams2);
        this.dSN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aRM();
            }
        });
        this.agh = (ImageView) this.dSN.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.fop.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.dSO = new MorePopupWindow(this.fop.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.fop.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bbC() {
                c.this.aRM();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bbD() {
            }
        });
        this.dSP = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.dSP.setOnClickListener(this.fop);
        if (g.eb(this.fop.getPageContext().getPageActivity())) {
            this.dSP.setVisibility(0);
        } else {
            this.dSP.setVisibility(8);
        }
        this.dSO.refresh();
        this.dSR = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.dSR.setOnClickListener(this.fop);
        this.dSQ = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.dSQ.setOnClickListener(this.fop);
        bAX();
    }

    private void bAX() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.fop.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.fop.getPageContext().getPageActivity()).heightPixels;
        this.foq = (i - statusBarHeight) - dimens;
        this.f2for = i - statusBarHeight;
    }

    public boolean bbt() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean bbv() {
        try {
            this.dSJ.addView(this.fop.createWebView());
            this.dSK.setVisibility(8);
            if (!this.dSS) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dSK.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.dSJ.getLayoutParams().height = this.foq;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.dSJ.getLayoutParams().height = this.f2for;
        this.mNavigationBar.setVisibility(8);
    }

    public void hE(boolean z) {
        if (this.dSP != null) {
            if (z) {
                this.dSP.setVisibility(0);
            } else {
                this.dSP.setVisibility(8);
            }
            this.dSO.refresh();
        }
    }

    public void hF(boolean z) {
        if (this.dSN != null) {
            if (z) {
                this.dSN.setVisibility(0);
            } else {
                this.dSN.setVisibility(8);
            }
        }
    }

    public void aRM() {
        this.dSO.showWindowInRightBottomOfHost();
    }

    public void aRN() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.dSO, this.fop.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.dSK.setVisibility(8);
    }

    public void yJ(String str) {
        this.dSD = this.mNavigationBar.setCenterTextTitle(str);
        if (this.dSF != null && this.dSF.getVisibility() == 0 && this.dSH != null && this.dSH.getVisibility() == 0) {
            this.dSD.setMaxWidth(l.getDimens(this.fop.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ap.setNavbarTitleColor(this.dSD, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.fop.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dD(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.ai("obj_type", 0);
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.fop.getPageContext().getPageActivity(), shareItem, true, bby())));
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
            this.mNavigationBar.onChangeSkinType(this.fop.getPageContext(), i);
        }
        if (this.dSO != null) {
            this.dSO.onChangeSkinType(this.fop, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fop.getPageContext(), i);
        }
        ap.setNavbarIconSrc(this.dSF, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        ap.setNavbarIconSrc(this.dSH, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        ap.setNavbarIconSrc(this.agh, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dSJ.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fop.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dE(null, this.fop.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fop.getResources().getString(R.string.refresh), this.dSM)));
        }
        this.mNoDataView.onChangeSkinType(this.fop.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dSJ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dSM = onClickListener;
    }

    public void release() {
        if (this.dSJ != null) {
            this.dSJ.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dSO != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.dSO, this.fop.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSJ.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dSJ.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ap.setBackgroundResource(this.dSF, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.dSH, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agh, R.drawable.frs_star_navigation_bg);
        yJ("");
        this.fop.getWindow().setFlags(1024, 1024);
    }

    public void bbA() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSJ.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dSJ.setLayoutParams(layoutParams);
        this.dSF.setBackgroundDrawable(null);
        this.dSH.setBackgroundDrawable(null);
        this.agh.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.fop.getWindow().clearFlags(1024);
    }

    public void hH(boolean z) {
        this.dSS = z;
    }
}
