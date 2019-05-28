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
    private ImageView bBk;
    private LinearLayout bBm;
    private TextView bBn;
    private View.OnClickListener bBp;
    private View bBq;
    private MorePopupWindow bBr;
    protected View bBs;
    private View bBt;
    private View bBu;
    private int bBv;
    private int bBw;
    private AdBaseWebViewActivity cVN;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View bBg = null;
    private ProgressBar mProgressBar = null;
    private boolean bBx = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.cVN = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.cVN.setContentView(R.layout.base_webview_activity);
        this.bBg = this.cVN.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.cVN.findViewById(R.id.view_navigation_bar);
        lV("");
        this.bBm = (LinearLayout) this.cVN.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bBm.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bBm.setLayoutParams(layoutParams);
        this.bBn = (TextView) this.cVN.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.cVN.findViewById(R.id.webview_progress);
        this.bBi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cVN != null) {
                    d.this.cVN.finish();
                }
            }
        });
        this.bBj = (ImageView) this.bBi.findViewById(R.id.widget_navi_back_button);
        this.bBj.setContentDescription(this.cVN.getResources().getString(R.string.close));
        this.bBq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.TT();
            }
        });
        this.bBk = (ImageView) this.bBq.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.cVN.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.bBr = new MorePopupWindow(this.cVN.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.cVN.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aaA() {
                d.this.TT();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aaB() {
            }
        });
        this.bBs = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.bBs.setOnClickListener(this.cVN);
        if (com.baidu.tbadk.coreExtra.c.f.cI(this.cVN.getPageContext().getPageActivity())) {
            this.bBs.setVisibility(0);
        } else {
            this.bBs.setVisibility(8);
        }
        this.bBr.refresh();
        this.bBu = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.bBu.setOnClickListener(this.cVN);
        this.bBt = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.bBt.setOnClickListener(this.cVN);
        aar();
    }

    private void aar() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = l.g(this.cVN.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.s(this.cVN.getPageContext().getPageActivity()).heightPixels;
        this.bBv = (i - statusBarHeight) - g;
        this.bBw = i - statusBarHeight;
    }

    public boolean aat() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean aav() {
        try {
            this.bBm.addView(this.cVN.createWebView());
            this.bBn.setVisibility(8);
            if (!this.bBx) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bBn.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.bBm.getLayoutParams().height = this.bBv;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.bBm.getLayoutParams().height = this.bBw;
        this.mNavigationBar.setVisibility(8);
    }

    public void dw(boolean z) {
        if (this.bBs != null) {
            if (z) {
                this.bBs.setVisibility(0);
            } else {
                this.bBs.setVisibility(8);
            }
            this.bBr.refresh();
        }
    }

    public void dx(boolean z) {
        if (this.bBq != null) {
            if (z) {
                this.bBq.setVisibility(0);
            } else {
                this.bBq.setVisibility(8);
            }
        }
    }

    public void TT() {
        this.bBr.showWindowInRightBottomOfHost();
    }

    public void TU() {
        com.baidu.adp.lib.g.g.a(this.bBr, this.cVN.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.bBn.setVisibility(8);
    }

    public void lV(String str) {
        this.bBh = this.mNavigationBar.setTitleText(str);
        al.e(this.bBh, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.cVN.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.bT("obj_url", eVar.linkUrl);
            amVar.P("obj_type", 0);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.cVN.getPageContext().getPageActivity(), eVar, true, aay())));
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
            this.mNavigationBar.onChangeSkinType(this.cVN.getPageContext(), i);
        }
        if (this.bBr != null) {
            this.bBr.onChangeSkinType(this.cVN, i, al.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cVN.getPageContext(), i);
        }
        al.a(this.bBj, (int) R.drawable.icon_nav_close, (int) R.drawable.icon_nav_close_w, (int) R.drawable.icon_nav_close, i);
        al.a(this.bBk, (int) R.drawable.icon_more_bg_s, (int) R.drawable.icon_more_bg_s, (int) R.drawable.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bBm.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cVN.getPageContext().getPageActivity(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.bW(null, this.cVN.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cVN.getResources().getString(R.string.refresh), this.bBp)));
        }
        this.mNoDataView.onChangeSkinType(this.cVN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bBm.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.bBp = onClickListener;
    }

    public void release() {
        if (this.bBm != null) {
            this.bBm.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.bBr != null) {
            com.baidu.adp.lib.g.g.a(this.bBr, this.cVN.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bBm.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.bBm.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.k(this.bBj, R.drawable.frs_star_navigation_bg);
        al.k(this.bBk, R.drawable.frs_star_navigation_bg);
        lV("");
        this.cVN.getWindow().setFlags(1024, 1024);
    }

    public void aaz() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bBm.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bBm.setLayoutParams(layoutParams);
        this.bBj.setBackgroundDrawable(null);
        this.bBk.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.cVN.getWindow().clearFlags(1024);
    }

    public void dz(boolean z) {
        this.bBx = z;
    }
}
