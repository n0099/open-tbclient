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
    private ImageView agf;
    private View dSA;
    private ImageView dSB;
    private View dSC;
    private ImageView dSD;
    private LinearLayout dSF;
    private TextView dSG;
    private View.OnClickListener dSI;
    private View dSJ;
    private MorePopupWindow dSK;
    protected View dSL;
    private View dSM;
    private View dSN;
    private TextView dSz;
    private AdBaseWebViewActivity fol;
    private int fom;
    private int fon;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean dSO = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.fol = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.fol.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.fol.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.fol.findViewById(R.id.view_navigation_bar);
        yI("");
        this.dSF = (LinearLayout) this.fol.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSF.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dSF.setLayoutParams(layoutParams);
        this.dSG = (TextView) this.fol.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.fol.findViewById(R.id.webview_progress);
        this.dSA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fol != null && !c.this.fol.webViewGoBack()) {
                    c.this.fol.finish();
                }
            }
        });
        this.dSB = (ImageView) this.dSA.findViewById(R.id.widget_navi_back_button);
        this.dSB.setContentDescription(this.fol.getResources().getString(R.string.back));
        this.dSC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fol != null) {
                    c.this.fol.finish();
                }
            }
        });
        this.dSD = (ImageView) this.dSC.findViewById(R.id.widget_navi_back_button);
        this.dSD.setContentDescription(this.fol.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dSD.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.fol.getPageContext().getPageActivity(), R.dimen.ds4);
        this.dSD.setLayoutParams(layoutParams2);
        this.dSJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aRM();
            }
        });
        this.agf = (ImageView) this.dSJ.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.fol.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.dSK = new MorePopupWindow(this.fol.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.fol.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bbC() {
                c.this.aRM();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bbD() {
            }
        });
        this.dSL = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.dSL.setOnClickListener(this.fol);
        if (g.eb(this.fol.getPageContext().getPageActivity())) {
            this.dSL.setVisibility(0);
        } else {
            this.dSL.setVisibility(8);
        }
        this.dSK.refresh();
        this.dSN = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.dSN.setOnClickListener(this.fol);
        this.dSM = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.dSM.setOnClickListener(this.fol);
        bAW();
    }

    private void bAW() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.fol.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.fol.getPageContext().getPageActivity()).heightPixels;
        this.fom = (i - statusBarHeight) - dimens;
        this.fon = i - statusBarHeight;
    }

    public boolean bbt() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean bbv() {
        try {
            this.dSF.addView(this.fol.createWebView());
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
            this.dSF.getLayoutParams().height = this.fom;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.dSF.getLayoutParams().height = this.fon;
        this.mNavigationBar.setVisibility(8);
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

    public void aRM() {
        this.dSK.showWindowInRightBottomOfHost();
    }

    public void aRN() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.dSK, this.fol.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.dSG.setVisibility(8);
    }

    public void yI(String str) {
        this.dSz = this.mNavigationBar.setCenterTextTitle(str);
        if (this.dSB != null && this.dSB.getVisibility() == 0 && this.dSD != null && this.dSD.getVisibility() == 0) {
            this.dSz.setMaxWidth(l.getDimens(this.fol.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ap.setNavbarTitleColor(this.dSz, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.fol.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dD(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.ai("obj_type", 0);
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.fol.getPageContext().getPageActivity(), shareItem, true, bby())));
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
            this.mNavigationBar.onChangeSkinType(this.fol.getPageContext(), i);
        }
        if (this.dSK != null) {
            this.dSK.onChangeSkinType(this.fol, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fol.getPageContext(), i);
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
            this.mNoDataView = NoDataViewFactory.a(this.fol.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dE(null, this.fol.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fol.getResources().getString(R.string.refresh), this.dSI)));
        }
        this.mNoDataView.onChangeSkinType(this.fol.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
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
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.dSK, this.fol.getPageContext().getPageActivity());
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
        this.fol.getWindow().setFlags(1024, 1024);
    }

    public void bbA() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSF.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dSF.setLayoutParams(layoutParams);
        this.dSB.setBackgroundDrawable(null);
        this.dSD.setBackgroundDrawable(null);
        this.agf.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.fol.getWindow().clearFlags(1024);
    }

    public void hG(boolean z) {
        this.dSO = z;
    }
}
