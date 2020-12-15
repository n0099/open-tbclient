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
import com.baidu.tbadk.core.util.ar;
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
/* loaded from: classes21.dex */
public class c {
    private ImageView ahT;
    private View eAA;
    private ImageView eAB;
    private View eAC;
    private ImageView eAD;
    private LinearLayout eAF;
    private TextView eAG;
    private View.OnClickListener eAI;
    private View eAJ;
    private MorePopupWindow eAK;
    protected View eAL;
    private View eAM;
    private View eAN;
    private TextView eAz;
    private AdBaseWebViewActivity fZL;
    private int fZM;
    private int fZN;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean eAO = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.fZL = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.fZL.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.fZL.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.fZL.findViewById(R.id.view_navigation_bar);
        Az("");
        this.eAF = (LinearLayout) this.fZL.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eAF.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eAF.setLayoutParams(layoutParams);
        this.eAG = (TextView) this.fZL.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.fZL.findViewById(R.id.webview_progress);
        this.eAA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fZL != null && !c.this.fZL.webViewGoBack()) {
                    c.this.fZL.finish();
                }
            }
        });
        this.eAB = (ImageView) this.eAA.findViewById(R.id.widget_navi_back_button);
        this.eAB.setContentDescription(this.fZL.getResources().getString(R.string.back));
        this.eAC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fZL != null) {
                    c.this.fZL.finish();
                }
            }
        });
        this.eAD = (ImageView) this.eAC.findViewById(R.id.widget_navi_back_button);
        this.eAD.setContentDescription(this.fZL.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eAD.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.fZL.getPageContext().getPageActivity(), R.dimen.ds4);
        this.eAD.setLayoutParams(layoutParams2);
        this.eAJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bbZ();
            }
        });
        this.ahT = (ImageView) this.eAJ.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.fZL.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.eAK = new MorePopupWindow(this.fZL.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.fZL.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void blL() {
                c.this.bbZ();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void blM() {
            }
        });
        this.eAL = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.eAL.setOnClickListener(this.fZL);
        if (g.eM(this.fZL.getPageContext().getPageActivity())) {
            this.eAL.setVisibility(0);
        } else {
            this.eAL.setVisibility(8);
        }
        this.eAK.refresh();
        this.eAN = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.eAN.setOnClickListener(this.fZL);
        this.eAM = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.eAM.setOnClickListener(this.fZL);
        bMq();
    }

    private void bMq() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.fZL.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.fZL.getPageContext().getPageActivity()).heightPixels;
        this.fZM = (i - statusBarHeight) - dimens;
        this.fZN = i - statusBarHeight;
    }

    public boolean blC() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean blE() {
        try {
            this.eAF.addView(this.fZL.createWebView());
            this.eAG.setVisibility(8);
            if (!this.eAO) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.eAG.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.eAF.getLayoutParams().height = this.fZM;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.eAF.getLayoutParams().height = this.fZN;
        this.mNavigationBar.setVisibility(8);
    }

    public void iJ(boolean z) {
        if (this.eAL != null) {
            if (z) {
                this.eAL.setVisibility(0);
            } else {
                this.eAL.setVisibility(8);
            }
            this.eAK.refresh();
        }
    }

    public void iK(boolean z) {
        if (this.eAJ != null) {
            if (z) {
                this.eAJ.setVisibility(0);
            } else {
                this.eAJ.setVisibility(8);
            }
        }
    }

    public void bbZ() {
        this.eAK.showWindowInRightBottomOfHost();
    }

    public void bca() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.eAK, this.fZL.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.eAG.setVisibility(8);
    }

    public void Az(String str) {
        this.eAz = this.mNavigationBar.setCenterTextTitle(str);
        if (this.eAB != null && this.eAB.getVisibility() == 0 && this.eAD != null && this.eAD.getVisibility() == 0) {
            this.eAz.setMaxWidth(l.getDimens(this.fZL.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ap.setNavbarTitleColor(this.eAz, R.color.CAM_X0105, R.color.s_navbar_title_color);
    }

    public void showShareDialog(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.fZL.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ar arVar = new ar(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            arVar.dY(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            arVar.al("obj_type", 0);
            TiebaStatic.log(arVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.fZL.getPageContext().getPageActivity(), shareItem, true, blH())));
        }
    }

    private SparseArray<String> blH() {
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
            this.mNavigationBar.onChangeSkinType(this.fZL.getPageContext(), i);
        }
        if (this.eAK != null) {
            this.eAK.onChangeSkinType(this.fZL, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fZL.getPageContext(), i);
        }
        ap.setNavbarIconSrc(this.eAB, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        ap.setNavbarIconSrc(this.eAD, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        ap.setNavbarIconSrc(this.ahT, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.eAF.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fZL.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dZ(null, this.fZL.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fZL.getResources().getString(R.string.refresh), this.eAI)));
        }
        this.mNoDataView.onChangeSkinType(this.fZL.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.eAF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.eAI = onClickListener;
    }

    public void release() {
        if (this.eAF != null) {
            this.eAF.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.eAK != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.eAK, this.fZL.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eAF.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.eAF.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ap.setBackgroundResource(this.eAB, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.eAD, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.ahT, R.drawable.frs_star_navigation_bg);
        Az("");
        this.fZL.getWindow().setFlags(1024, 1024);
    }

    public void blJ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eAF.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eAF.setLayoutParams(layoutParams);
        this.eAB.setBackgroundDrawable(null);
        this.eAD.setBackgroundDrawable(null);
        this.ahT.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.fZL.getWindow().clearFlags(1024);
    }

    public void iM(boolean z) {
        this.eAO = z;
    }
}
