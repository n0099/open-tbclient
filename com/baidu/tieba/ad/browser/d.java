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
import com.baidu.tieba.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d {
    private TextView bud;
    private View bue;
    private ImageView bug;
    private ImageView buh;
    private LinearLayout buj;
    private TextView buk;
    private View.OnClickListener bum;
    private View bun;
    private MorePopupWindow buo;
    protected View bup;
    private View buq;
    private View bur;
    private int bus;
    private int but;
    private AdBaseWebViewActivity cNB;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View buc = null;
    private ProgressBar mProgressBar = null;
    private boolean buu = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.cNB = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.cNB.setContentView(d.h.base_webview_activity);
        this.buc = this.cNB.findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) this.cNB.findViewById(d.g.view_navigation_bar);
        kQ("");
        this.buj = (LinearLayout) this.cNB.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buj.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.buj.setLayoutParams(layoutParams);
        this.buk = (TextView) this.cNB.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.cNB.findViewById(d.g.webview_progress);
        this.bue = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cNB != null) {
                    d.this.cNB.finish();
                }
            }
        });
        this.bug = (ImageView) this.bue.findViewById(d.g.widget_navi_back_button);
        this.bug.setContentDescription(this.cNB.getResources().getString(d.j.close));
        this.bun = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Qh();
            }
        });
        this.buh = (ImageView) this.bun.findViewById(d.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.cNB.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.buo = new MorePopupWindow(this.cNB.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.cNB.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void VU() {
                d.this.Qh();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void VV() {
            }
        });
        this.bup = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.bup.setOnClickListener(this.cNB);
        if (com.baidu.tbadk.coreExtra.c.e.dc(this.cNB.getPageContext().getPageActivity())) {
            this.bup.setVisibility(0);
        } else {
            this.bup.setVisibility(8);
        }
        this.buo.refresh();
        this.bur = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.bur.setOnClickListener(this.cNB);
        this.buq = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.buq.setOnClickListener(this.cNB);
        VL();
    }

    private void VL() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.cNB.getPageContext().getPageActivity(), d.e.ds98);
        int i = l.s(this.cNB.getPageContext().getPageActivity()).heightPixels;
        this.bus = (i - statusBarHeight) - h;
        this.but = i - statusBarHeight;
    }

    public boolean VN() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean VP() {
        try {
            this.buj.addView(this.cNB.createWebView());
            this.buk.setVisibility(8);
            if (!this.buu) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.buk.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.buj.getLayoutParams().height = this.bus;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.buj.getLayoutParams().height = this.but;
        this.mNavigationBar.setVisibility(8);
    }

    public void db(boolean z) {
        if (this.bup != null) {
            if (z) {
                this.bup.setVisibility(0);
            } else {
                this.bup.setVisibility(8);
            }
            this.buo.refresh();
        }
    }

    public void dc(boolean z) {
        if (this.bun != null) {
            if (z) {
                this.bun.setVisibility(0);
            } else {
                this.bun.setVisibility(8);
            }
        }
    }

    public void Qh() {
        this.buo.showWindowInRightBottomOfHost();
    }

    public void Qi() {
        com.baidu.adp.lib.g.g.a(this.buo, this.cNB.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.buk.setVisibility(8);
    }

    public void kQ(String str) {
        this.bud = this.mNavigationBar.setTitleText(str);
        al.c(this.bud, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.cNB.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.bJ("obj_url", dVar.linkUrl);
            amVar.T("obj_type", 0);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.cNB.getPageContext().getPageActivity(), dVar, true, VS())));
        }
    }

    private SparseArray<String> VS() {
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
            this.mNavigationBar.onChangeSkinType(this.cNB.getPageContext(), i);
        }
        if (this.buo != null) {
            this.buo.onChangeSkinType(this.cNB, i, al.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cNB.getPageContext(), i);
        }
        al.a(this.bug, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        al.a(this.buh, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.buj.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cNB.getPageContext().getPageActivity(), this.buc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.bM(null, this.cNB.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cNB.getResources().getString(d.j.refresh), this.bum)));
        }
        this.mNoDataView.onChangeSkinType(this.cNB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.buj.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.bum = onClickListener;
    }

    public void release() {
        if (this.buj != null) {
            this.buj.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.buo != null) {
            com.baidu.adp.lib.g.g.a(this.buo, this.cNB.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buj.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.buj.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.k(this.bug, d.f.frs_star_navigation_bg);
        al.k(this.buh, d.f.frs_star_navigation_bg);
        kQ("");
        this.cNB.getWindow().setFlags(1024, 1024);
    }

    public void VT() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buj.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.buj.setLayoutParams(layoutParams);
        this.bug.setBackgroundDrawable(null);
        this.buh.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.cNB.getWindow().clearFlags(1024);
    }

    public void de(boolean z) {
        this.buu = z;
    }
}
