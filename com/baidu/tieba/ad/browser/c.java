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
/* loaded from: classes21.dex */
public class c {
    private ImageView agS;
    private View epA;
    private View epB;
    private TextView epn;
    private View epo;
    private ImageView epp;
    private View epq;
    private ImageView epr;
    private LinearLayout ept;
    private TextView epu;
    private View.OnClickListener epw;
    private View epx;
    private MorePopupWindow epy;
    protected View epz;
    private AdBaseWebViewActivity fMc;
    private int fMd;
    private int fMe;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean epC = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.fMc = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.fMc.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.fMc.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.fMc.findViewById(R.id.view_navigation_bar);
        Aj("");
        this.ept = (LinearLayout) this.fMc.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ept.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.ept.setLayoutParams(layoutParams);
        this.epu = (TextView) this.fMc.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.fMc.findViewById(R.id.webview_progress);
        this.epo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fMc != null && !c.this.fMc.webViewGoBack()) {
                    c.this.fMc.finish();
                }
            }
        });
        this.epp = (ImageView) this.epo.findViewById(R.id.widget_navi_back_button);
        this.epp.setContentDescription(this.fMc.getResources().getString(R.string.back));
        this.epq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fMc != null) {
                    c.this.fMc.finish();
                }
            }
        });
        this.epr = (ImageView) this.epq.findViewById(R.id.widget_navi_back_button);
        this.epr.setContentDescription(this.fMc.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.epr.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.fMc.getPageContext().getPageActivity(), R.dimen.ds4);
        this.epr.setLayoutParams(layoutParams2);
        this.epx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aXb();
            }
        });
        this.agS = (ImageView) this.epx.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.fMc.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.epy = new MorePopupWindow(this.fMc.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.fMc.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bgX() {
                c.this.aXb();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bgY() {
            }
        });
        this.epz = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.epz.setOnClickListener(this.fMc);
        if (g.eh(this.fMc.getPageContext().getPageActivity())) {
            this.epz.setVisibility(0);
        } else {
            this.epz.setVisibility(8);
        }
        this.epy.refresh();
        this.epB = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.epB.setOnClickListener(this.fMc);
        this.epA = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.epA.setOnClickListener(this.fMc);
        bGO();
    }

    private void bGO() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.fMc.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.fMc.getPageContext().getPageActivity()).heightPixels;
        this.fMd = (i - statusBarHeight) - dimens;
        this.fMe = i - statusBarHeight;
    }

    public boolean bgO() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean bgQ() {
        try {
            this.ept.addView(this.fMc.createWebView());
            this.epu.setVisibility(8);
            if (!this.epC) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.epu.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.ept.getLayoutParams().height = this.fMd;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.ept.getLayoutParams().height = this.fMe;
        this.mNavigationBar.setVisibility(8);
    }

    public void ik(boolean z) {
        if (this.epz != null) {
            if (z) {
                this.epz.setVisibility(0);
            } else {
                this.epz.setVisibility(8);
            }
            this.epy.refresh();
        }
    }

    public void il(boolean z) {
        if (this.epx != null) {
            if (z) {
                this.epx.setVisibility(0);
            } else {
                this.epx.setVisibility(8);
            }
        }
    }

    public void aXb() {
        this.epy.showWindowInRightBottomOfHost();
    }

    public void aXc() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.epy, this.fMc.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.epu.setVisibility(8);
    }

    public void Aj(String str) {
        this.epn = this.mNavigationBar.setCenterTextTitle(str);
        if (this.epp != null && this.epp.getVisibility() == 0 && this.epr != null && this.epr.getVisibility() == 0) {
            this.epn.setMaxWidth(l.getDimens(this.fMc.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ap.setNavbarTitleColor(this.epn, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.fMc.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.aj("obj_type", 0);
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.fMc.getPageContext().getPageActivity(), shareItem, true, bgT())));
        }
    }

    private SparseArray<String> bgT() {
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
            this.mNavigationBar.onChangeSkinType(this.fMc.getPageContext(), i);
        }
        if (this.epy != null) {
            this.epy.onChangeSkinType(this.fMc, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fMc.getPageContext(), i);
        }
        ap.setNavbarIconSrc(this.epp, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        ap.setNavbarIconSrc(this.epr, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        ap.setNavbarIconSrc(this.agS, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.ept.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fMc.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dS(null, this.fMc.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fMc.getResources().getString(R.string.refresh), this.epw)));
        }
        this.mNoDataView.onChangeSkinType(this.fMc.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.ept.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.epw = onClickListener;
    }

    public void release() {
        if (this.ept != null) {
            this.ept.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.epy != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.epy, this.fMc.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ept.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.ept.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ap.setBackgroundResource(this.epp, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.epr, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agS, R.drawable.frs_star_navigation_bg);
        Aj("");
        this.fMc.getWindow().setFlags(1024, 1024);
    }

    public void bgV() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ept.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.ept.setLayoutParams(layoutParams);
        this.epp.setBackgroundDrawable(null);
        this.epr.setBackgroundDrawable(null);
        this.agS.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.fMc.getWindow().clearFlags(1024);
    }

    public void in(boolean z) {
        this.epC = z;
    }
}
