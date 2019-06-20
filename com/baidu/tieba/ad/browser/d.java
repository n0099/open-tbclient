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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d {
    private TextView bBh;
    private View bBi;
    private ImageView bBj;
    private View bBk;
    private ImageView bBl;
    private ImageView bBm;
    private LinearLayout bBo;
    private TextView bBp;
    private View.OnClickListener bBr;
    private View bBs;
    private MorePopupWindow bBt;
    protected View bBu;
    private View bBv;
    private View bBw;
    private int bBx;
    private int bBy;
    private AdBaseWebViewActivity cVO;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View bBg = null;
    private ProgressBar mProgressBar = null;
    private boolean bBz = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.cVO = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.cVO.setContentView(R.layout.base_webview_activity);
        this.bBg = this.cVO.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.cVO.findViewById(R.id.view_navigation_bar);
        lU("");
        this.bBo = (LinearLayout) this.cVO.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bBo.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bBo.setLayoutParams(layoutParams);
        this.bBp = (TextView) this.cVO.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.cVO.findViewById(R.id.webview_progress);
        this.bBi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cVO != null && !d.this.cVO.webViewGoBack()) {
                    d.this.cVO.finish();
                }
            }
        });
        this.bBj = (ImageView) this.bBi.findViewById(R.id.widget_navi_back_button);
        this.bBj.setContentDescription(this.cVO.getResources().getString(R.string.back));
        this.bBk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cVO != null) {
                    d.this.cVO.finish();
                }
            }
        });
        this.bBl = (ImageView) this.bBk.findViewById(R.id.widget_navi_back_button);
        this.bBl.setContentDescription(this.cVO.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bBl.getLayoutParams();
        layoutParams2.leftMargin = l.g(this.cVO.getPageContext().getPageActivity(), R.dimen.ds4);
        this.bBl.setLayoutParams(layoutParams2);
        this.bBs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.TT();
            }
        });
        this.bBm = (ImageView) this.bBs.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.cVO.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.bBt = new MorePopupWindow(this.cVO.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.cVO.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aaA() {
                d.this.TT();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aaB() {
            }
        });
        this.bBu = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.bBu.setOnClickListener(this.cVO);
        if (com.baidu.tbadk.coreExtra.c.f.cI(this.cVO.getPageContext().getPageActivity())) {
            this.bBu.setVisibility(0);
        } else {
            this.bBu.setVisibility(8);
        }
        this.bBt.refresh();
        this.bBw = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.bBw.setOnClickListener(this.cVO);
        this.bBv = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.bBv.setOnClickListener(this.cVO);
        aar();
    }

    private void aar() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = l.g(this.cVO.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.s(this.cVO.getPageContext().getPageActivity()).heightPixels;
        this.bBx = (i - statusBarHeight) - g;
        this.bBy = i - statusBarHeight;
    }

    public boolean aat() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean aav() {
        try {
            this.bBo.addView(this.cVO.createWebView());
            this.bBp.setVisibility(8);
            if (!this.bBz) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bBp.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.bBo.getLayoutParams().height = this.bBx;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.bBo.getLayoutParams().height = this.bBy;
        this.mNavigationBar.setVisibility(8);
    }

    public void dw(boolean z) {
        if (this.bBu != null) {
            if (z) {
                this.bBu.setVisibility(0);
            } else {
                this.bBu.setVisibility(8);
            }
            this.bBt.refresh();
        }
    }

    public void dx(boolean z) {
        if (this.bBs != null) {
            if (z) {
                this.bBs.setVisibility(0);
            } else {
                this.bBs.setVisibility(8);
            }
        }
    }

    public void TT() {
        this.bBt.showWindowInRightBottomOfHost();
    }

    public void TU() {
        com.baidu.adp.lib.g.g.a(this.bBt, this.cVO.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.bBp.setVisibility(8);
    }

    public void lU(String str) {
        this.bBh = this.mNavigationBar.setCenterTextTitle(str);
        if (this.bBj != null && this.bBj.getVisibility() == 0 && this.bBl != null && this.bBl.getVisibility() == 0) {
            this.bBh.setMaxWidth(l.g(this.cVO.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        al.e(this.bBh, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.cVO.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.bT("obj_url", eVar.linkUrl);
            amVar.P("obj_type", 0);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.cVO.getPageContext().getPageActivity(), eVar, true, aay())));
        }
    }

    private SparseArray<String> aay() {
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
            this.mNavigationBar.onChangeSkinType(this.cVO.getPageContext(), i);
        }
        if (this.bBt != null) {
            this.bBt.onChangeSkinType(this.cVO, i, al.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cVO.getPageContext(), i);
        }
        al.a(this.bBj, (int) R.drawable.selector_web_topbar_return_black, (int) R.drawable.selector_web_topbar_return_white, i);
        al.a(this.bBl, (int) R.drawable.selector_web_topbar_close_black, (int) R.drawable.selector_web_topbar_close_white, i);
        al.a(this.bBm, (int) R.drawable.selector_web_topbar_more_black, (int) R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bBo.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cVO.getPageContext().getPageActivity(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.bW(null, this.cVO.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cVO.getResources().getString(R.string.refresh), this.bBr)));
        }
        this.mNoDataView.onChangeSkinType(this.cVO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bBo.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.bBr = onClickListener;
    }

    public void release() {
        if (this.bBo != null) {
            this.bBo.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.bBt != null) {
            com.baidu.adp.lib.g.g.a(this.bBt, this.cVO.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bBo.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.bBo.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.k(this.bBj, R.drawable.frs_star_navigation_bg);
        al.k(this.bBl, R.drawable.frs_star_navigation_bg);
        al.k(this.bBm, R.drawable.frs_star_navigation_bg);
        lU("");
        this.cVO.getWindow().setFlags(1024, 1024);
    }

    public void aaz() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bBo.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bBo.setLayoutParams(layoutParams);
        this.bBj.setBackgroundDrawable(null);
        this.bBl.setBackgroundDrawable(null);
        this.bBm.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.cVO.getWindow().clearFlags(1024);
    }

    public void dz(boolean z) {
        this.bBz = z;
    }
}
