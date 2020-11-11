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
    private TextView evg;
    private View evh;
    private ImageView evi;
    private View evj;
    private ImageView evk;
    private LinearLayout evm;
    private TextView evn;
    private View.OnClickListener evp;
    private View evq;
    private MorePopupWindow evr;
    protected View evs;
    private View evt;
    private View evu;
    private AdBaseWebViewActivity fRS;
    private int fRT;
    private int fRU;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean evv = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.fRS = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.fRS.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.fRS.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.fRS.findViewById(R.id.view_navigation_bar);
        Ax("");
        this.evm = (LinearLayout) this.fRS.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evm.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.evm.setLayoutParams(layoutParams);
        this.evn = (TextView) this.fRS.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.fRS.findViewById(R.id.webview_progress);
        this.evh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fRS != null && !c.this.fRS.webViewGoBack()) {
                    c.this.fRS.finish();
                }
            }
        });
        this.evi = (ImageView) this.evh.findViewById(R.id.widget_navi_back_button);
        this.evi.setContentDescription(this.fRS.getResources().getString(R.string.back));
        this.evj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fRS != null) {
                    c.this.fRS.finish();
                }
            }
        });
        this.evk = (ImageView) this.evj.findViewById(R.id.widget_navi_back_button);
        this.evk.setContentDescription(this.fRS.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.evk.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.fRS.getPageContext().getPageActivity(), R.dimen.ds4);
        this.evk.setLayoutParams(layoutParams2);
        this.evq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aZB();
            }
        });
        this.agS = (ImageView) this.evq.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.fRS.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.evr = new MorePopupWindow(this.fRS.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.fRS.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bjx() {
                c.this.aZB();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bjy() {
            }
        });
        this.evs = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.evs.setOnClickListener(this.fRS);
        if (g.eh(this.fRS.getPageContext().getPageActivity())) {
            this.evs.setVisibility(0);
        } else {
            this.evs.setVisibility(8);
        }
        this.evr.refresh();
        this.evu = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.evu.setOnClickListener(this.fRS);
        this.evt = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.evt.setOnClickListener(this.fRS);
        bJn();
    }

    private void bJn() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.fRS.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.fRS.getPageContext().getPageActivity()).heightPixels;
        this.fRT = (i - statusBarHeight) - dimens;
        this.fRU = i - statusBarHeight;
    }

    public boolean bjo() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean bjq() {
        try {
            this.evm.addView(this.fRS.createWebView());
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
            this.evm.getLayoutParams().height = this.fRT;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.evm.getLayoutParams().height = this.fRU;
        this.mNavigationBar.setVisibility(8);
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

    public void aZB() {
        this.evr.showWindowInRightBottomOfHost();
    }

    public void aZC() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.evr, this.fRS.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.evn.setVisibility(8);
    }

    public void Ax(String str) {
        this.evg = this.mNavigationBar.setCenterTextTitle(str);
        if (this.evi != null && this.evi.getVisibility() == 0 && this.evk != null && this.evk.getVisibility() == 0) {
            this.evg.setMaxWidth(l.getDimens(this.fRS.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ap.setNavbarTitleColor(this.evg, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.fRS.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.al("obj_type", 0);
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.fRS.getPageContext().getPageActivity(), shareItem, true, bjt())));
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
            this.mNavigationBar.onChangeSkinType(this.fRS.getPageContext(), i);
        }
        if (this.evr != null) {
            this.evr.onChangeSkinType(this.fRS, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fRS.getPageContext(), i);
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
            this.mNoDataView = NoDataViewFactory.a(this.fRS.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dS(null, this.fRS.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fRS.getResources().getString(R.string.refresh), this.evp)));
        }
        this.mNoDataView.onChangeSkinType(this.fRS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
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
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.evr, this.fRS.getPageContext().getPageActivity());
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
        this.fRS.getWindow().setFlags(1024, 1024);
    }

    public void bjv() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evm.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.evm.setLayoutParams(layoutParams);
        this.evi.setBackgroundDrawable(null);
        this.evk.setBackgroundDrawable(null);
        this.agS.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.fRS.getWindow().clearFlags(1024);
    }

    public void iw(boolean z) {
        this.evv = z;
    }
}
