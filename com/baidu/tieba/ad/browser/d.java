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
    private TextView btX;
    private View btY;
    private ImageView btZ;
    private ImageView bua;
    private LinearLayout buc;
    private TextView bud;
    private View.OnClickListener bug;
    private View buh;
    private MorePopupWindow bui;
    protected View buj;
    private View buk;
    private View bul;
    private int bum;
    private int bun;
    private AdBaseWebViewActivity cNB;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View btW = null;
    private ProgressBar mProgressBar = null;
    private boolean buo = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.cNB = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.cNB.setContentView(d.h.base_webview_activity);
        this.btW = this.cNB.findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) this.cNB.findViewById(d.g.view_navigation_bar);
        kP("");
        this.buc = (LinearLayout) this.cNB.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buc.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.buc.setLayoutParams(layoutParams);
        this.bud = (TextView) this.cNB.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.cNB.findViewById(d.g.webview_progress);
        this.btY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cNB != null) {
                    d.this.cNB.finish();
                }
            }
        });
        this.btZ = (ImageView) this.btY.findViewById(d.g.widget_navi_back_button);
        this.btZ.setContentDescription(this.cNB.getResources().getString(d.j.close));
        this.buh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Qj();
            }
        });
        this.bua = (ImageView) this.buh.findViewById(d.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.cNB.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.bui = new MorePopupWindow(this.cNB.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.cNB.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void VX() {
                d.this.Qj();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void VY() {
            }
        });
        this.buj = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.buj.setOnClickListener(this.cNB);
        if (com.baidu.tbadk.coreExtra.c.e.dc(this.cNB.getPageContext().getPageActivity())) {
            this.buj.setVisibility(0);
        } else {
            this.buj.setVisibility(8);
        }
        this.bui.refresh();
        this.bul = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.bul.setOnClickListener(this.cNB);
        this.buk = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.buk.setOnClickListener(this.cNB);
        VO();
    }

    private void VO() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.cNB.getPageContext().getPageActivity(), d.e.ds98);
        int i = l.s(this.cNB.getPageContext().getPageActivity()).heightPixels;
        this.bum = (i - statusBarHeight) - h;
        this.bun = i - statusBarHeight;
    }

    public boolean VQ() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean VS() {
        try {
            this.buc.addView(this.cNB.createWebView());
            this.bud.setVisibility(8);
            if (!this.buo) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bud.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.buc.getLayoutParams().height = this.bum;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.buc.getLayoutParams().height = this.bun;
        this.mNavigationBar.setVisibility(8);
    }

    public void db(boolean z) {
        if (this.buj != null) {
            if (z) {
                this.buj.setVisibility(0);
            } else {
                this.buj.setVisibility(8);
            }
            this.bui.refresh();
        }
    }

    public void dc(boolean z) {
        if (this.buh != null) {
            if (z) {
                this.buh.setVisibility(0);
            } else {
                this.buh.setVisibility(8);
            }
        }
    }

    public void Qj() {
        this.bui.showWindowInRightBottomOfHost();
    }

    public void Qk() {
        com.baidu.adp.lib.g.g.a(this.bui, this.cNB.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.bud.setVisibility(8);
    }

    public void kP(String str) {
        this.btX = this.mNavigationBar.setTitleText(str);
        al.c(this.btX, d.C0236d.cp_cont_b, d.C0236d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.cNB.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.bJ("obj_url", dVar.linkUrl);
            amVar.T("obj_type", 0);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.cNB.getPageContext().getPageActivity(), dVar, true, VV())));
        }
    }

    private SparseArray<String> VV() {
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
        if (this.bui != null) {
            this.bui.onChangeSkinType(this.cNB, i, al.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cNB.getPageContext(), i);
        }
        al.a(this.btZ, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        al.a(this.bua, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.buc.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cNB.getPageContext().getPageActivity(), this.btW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.bM(null, this.cNB.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cNB.getResources().getString(d.j.refresh), this.bug)));
        }
        this.mNoDataView.onChangeSkinType(this.cNB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.buc.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.bug = onClickListener;
    }

    public void release() {
        if (this.buc != null) {
            this.buc.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.bui != null) {
            com.baidu.adp.lib.g.g.a(this.bui, this.cNB.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buc.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.buc.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.k(this.btZ, d.f.frs_star_navigation_bg);
        al.k(this.bua, d.f.frs_star_navigation_bg);
        kP("");
        this.cNB.getWindow().setFlags(1024, 1024);
    }

    public void VW() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buc.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.buc.setLayoutParams(layoutParams);
        this.btZ.setBackgroundDrawable(null);
        this.bua.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.cNB.getWindow().clearFlags(1024);
    }

    public void de(boolean z) {
        this.buo = z;
    }
}
