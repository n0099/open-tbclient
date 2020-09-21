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
/* loaded from: classes20.dex */
public class c {
    private ImageView agA;
    private TextView dUN;
    private View dUO;
    private ImageView dUP;
    private View dUQ;
    private ImageView dUR;
    private LinearLayout dUT;
    private TextView dUU;
    private View.OnClickListener dUW;
    private View dUX;
    private MorePopupWindow dUY;
    protected View dUZ;
    private View dVa;
    private View dVb;
    private AdBaseWebViewActivity frw;
    private int frx;
    private int fry;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean dVc = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.frw = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.frw.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.frw.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.frw.findViewById(R.id.view_navigation_bar);
        ze("");
        this.dUT = (LinearLayout) this.frw.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUT.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dUT.setLayoutParams(layoutParams);
        this.dUU = (TextView) this.frw.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.frw.findViewById(R.id.webview_progress);
        this.dUO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.frw != null && !c.this.frw.webViewGoBack()) {
                    c.this.frw.finish();
                }
            }
        });
        this.dUP = (ImageView) this.dUO.findViewById(R.id.widget_navi_back_button);
        this.dUP.setContentDescription(this.frw.getResources().getString(R.string.back));
        this.dUQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.frw != null) {
                    c.this.frw.finish();
                }
            }
        });
        this.dUR = (ImageView) this.dUQ.findViewById(R.id.widget_navi_back_button);
        this.dUR.setContentDescription(this.frw.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dUR.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.frw.getPageContext().getPageActivity(), R.dimen.ds4);
        this.dUR.setLayoutParams(layoutParams2);
        this.dUX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aSy();
            }
        });
        this.agA = (ImageView) this.dUX.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.frw.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.dUY = new MorePopupWindow(this.frw.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.frw.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bcw() {
                c.this.aSy();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bcx() {
            }
        });
        this.dUZ = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.dUZ.setOnClickListener(this.frw);
        if (g.ea(this.frw.getPageContext().getPageActivity())) {
            this.dUZ.setVisibility(0);
        } else {
            this.dUZ.setVisibility(8);
        }
        this.dUY.refresh();
        this.dVb = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.dVb.setOnClickListener(this.frw);
        this.dVa = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.dVa.setOnClickListener(this.frw);
        bCj();
    }

    private void bCj() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.frw.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.frw.getPageContext().getPageActivity()).heightPixels;
        this.frx = (i - statusBarHeight) - dimens;
        this.fry = i - statusBarHeight;
    }

    public boolean bcn() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean bcp() {
        try {
            this.dUT.addView(this.frw.createWebView());
            this.dUU.setVisibility(8);
            if (!this.dVc) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dUU.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.dUT.getLayoutParams().height = this.frx;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.dUT.getLayoutParams().height = this.fry;
        this.mNavigationBar.setVisibility(8);
    }

    public void hB(boolean z) {
        if (this.dUZ != null) {
            if (z) {
                this.dUZ.setVisibility(0);
            } else {
                this.dUZ.setVisibility(8);
            }
            this.dUY.refresh();
        }
    }

    public void hC(boolean z) {
        if (this.dUX != null) {
            if (z) {
                this.dUX.setVisibility(0);
            } else {
                this.dUX.setVisibility(8);
            }
        }
    }

    public void aSy() {
        this.dUY.showWindowInRightBottomOfHost();
    }

    public void aSz() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.dUY, this.frw.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.dUU.setVisibility(8);
    }

    public void ze(String str) {
        this.dUN = this.mNavigationBar.setCenterTextTitle(str);
        if (this.dUP != null && this.dUP.getVisibility() == 0 && this.dUR != null && this.dUR.getVisibility() == 0) {
            this.dUN.setMaxWidth(l.getDimens(this.frw.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ap.setNavbarTitleColor(this.dUN, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.frw.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dF(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.ai("obj_type", 0);
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.frw.getPageContext().getPageActivity(), shareItem, true, bcs())));
        }
    }

    private SparseArray<String> bcs() {
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
            this.mNavigationBar.onChangeSkinType(this.frw.getPageContext(), i);
        }
        if (this.dUY != null) {
            this.dUY.onChangeSkinType(this.frw, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.frw.getPageContext(), i);
        }
        ap.setNavbarIconSrc(this.dUP, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        ap.setNavbarIconSrc(this.dUR, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        ap.setNavbarIconSrc(this.agA, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dUT.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.frw.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dG(null, this.frw.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.frw.getResources().getString(R.string.refresh), this.dUW)));
        }
        this.mNoDataView.onChangeSkinType(this.frw.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dUT.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dUW = onClickListener;
    }

    public void release() {
        if (this.dUT != null) {
            this.dUT.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dUY != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.dUY, this.frw.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUT.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dUT.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ap.setBackgroundResource(this.dUP, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.dUR, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agA, R.drawable.frs_star_navigation_bg);
        ze("");
        this.frw.getWindow().setFlags(1024, 1024);
    }

    public void bcu() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUT.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dUT.setLayoutParams(layoutParams);
        this.dUP.setBackgroundDrawable(null);
        this.dUR.setBackgroundDrawable(null);
        this.agA.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.frw.getWindow().clearFlags(1024);
    }

    public void hE(boolean z) {
        this.dVc = z;
    }
}
