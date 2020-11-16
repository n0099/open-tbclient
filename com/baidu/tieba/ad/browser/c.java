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
/* loaded from: classes20.dex */
public class c {
    private ImageView agU;
    private View etA;
    private ImageView etB;
    private LinearLayout etD;
    private TextView etE;
    private View.OnClickListener etG;
    private View etH;
    private MorePopupWindow etI;
    protected View etJ;
    private View etK;
    private View etL;
    private TextView etx;
    private View ety;
    private ImageView etz;
    private AdBaseWebViewActivity fRA;
    private int fRB;
    private int fRC;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean etM = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.fRA = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.fRA.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.fRA.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.fRA.findViewById(R.id.view_navigation_bar);
        zS("");
        this.etD = (LinearLayout) this.fRA.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.etD.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.etD.setLayoutParams(layoutParams);
        this.etE = (TextView) this.fRA.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.fRA.findViewById(R.id.webview_progress);
        this.ety = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fRA != null && !c.this.fRA.webViewGoBack()) {
                    c.this.fRA.finish();
                }
            }
        });
        this.etz = (ImageView) this.ety.findViewById(R.id.widget_navi_back_button);
        this.etz.setContentDescription(this.fRA.getResources().getString(R.string.back));
        this.etA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fRA != null) {
                    c.this.fRA.finish();
                }
            }
        });
        this.etB = (ImageView) this.etA.findViewById(R.id.widget_navi_back_button);
        this.etB.setContentDescription(this.fRA.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.etB.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.fRA.getPageContext().getPageActivity(), R.dimen.ds4);
        this.etB.setLayoutParams(layoutParams2);
        this.etH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aYU();
            }
        });
        this.agU = (ImageView) this.etH.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.fRA.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.etI = new MorePopupWindow(this.fRA.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.fRA.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void biB() {
                c.this.aYU();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void biC() {
            }
        });
        this.etJ = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.etJ.setOnClickListener(this.fRA);
        if (g.eh(this.fRA.getPageContext().getPageActivity())) {
            this.etJ.setVisibility(0);
        } else {
            this.etJ.setVisibility(8);
        }
        this.etI.refresh();
        this.etL = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.etL.setOnClickListener(this.fRA);
        this.etK = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.etK.setOnClickListener(this.fRA);
        bIH();
    }

    private void bIH() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.fRA.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.fRA.getPageContext().getPageActivity()).heightPixels;
        this.fRB = (i - statusBarHeight) - dimens;
        this.fRC = i - statusBarHeight;
    }

    public boolean bis() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean biu() {
        try {
            this.etD.addView(this.fRA.createWebView());
            this.etE.setVisibility(8);
            if (!this.etM) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.etE.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.etD.getLayoutParams().height = this.fRB;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.etD.getLayoutParams().height = this.fRC;
        this.mNavigationBar.setVisibility(8);
    }

    public void iu(boolean z) {
        if (this.etJ != null) {
            if (z) {
                this.etJ.setVisibility(0);
            } else {
                this.etJ.setVisibility(8);
            }
            this.etI.refresh();
        }
    }

    public void iv(boolean z) {
        if (this.etH != null) {
            if (z) {
                this.etH.setVisibility(0);
            } else {
                this.etH.setVisibility(8);
            }
        }
    }

    public void aYU() {
        this.etI.showWindowInRightBottomOfHost();
    }

    public void aYV() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.etI, this.fRA.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.etE.setVisibility(8);
    }

    public void zS(String str) {
        this.etx = this.mNavigationBar.setCenterTextTitle(str);
        if (this.etz != null && this.etz.getVisibility() == 0 && this.etB != null && this.etB.getVisibility() == 0) {
            this.etx.setMaxWidth(l.getDimens(this.fRA.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ap.setNavbarTitleColor(this.etx, R.color.CAM_X0105, R.color.s_navbar_title_color);
    }

    public void showShareDialog(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.fRA.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ar arVar = new ar(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            arVar.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            arVar.ak("obj_type", 0);
            TiebaStatic.log(arVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.fRA.getPageContext().getPageActivity(), shareItem, true, bix())));
        }
    }

    private SparseArray<String> bix() {
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
            this.mNavigationBar.onChangeSkinType(this.fRA.getPageContext(), i);
        }
        if (this.etI != null) {
            this.etI.onChangeSkinType(this.fRA, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fRA.getPageContext(), i);
        }
        ap.setNavbarIconSrc(this.etz, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        ap.setNavbarIconSrc(this.etB, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        ap.setNavbarIconSrc(this.agU, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.etD.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fRA.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dS(null, this.fRA.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fRA.getResources().getString(R.string.refresh), this.etG)));
        }
        this.mNoDataView.onChangeSkinType(this.fRA.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.etD.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.etG = onClickListener;
    }

    public void release() {
        if (this.etD != null) {
            this.etD.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.etI != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.etI, this.fRA.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.etD.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.etD.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ap.setBackgroundResource(this.etz, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.etB, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agU, R.drawable.frs_star_navigation_bg);
        zS("");
        this.fRA.getWindow().setFlags(1024, 1024);
    }

    public void biz() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.etD.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.etD.setLayoutParams(layoutParams);
        this.etz.setBackgroundDrawable(null);
        this.etB.setBackgroundDrawable(null);
        this.agU.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.fRA.getWindow().clearFlags(1024);
    }

    public void ix(boolean z) {
        this.etM = z;
    }
}
