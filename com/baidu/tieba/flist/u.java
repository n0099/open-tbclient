package com.baidu.tieba.flist;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class u {
    ViewPager Ct;
    LinearLayout asy;
    TextView atA;
    View awA;
    ForumListActivity awB;
    ListView awC;
    a awD;
    LinearLayout awE;
    ImageView awF;
    final View awj;
    final View awk;
    LinearLayout awl;
    BdListView awn;
    BdListView awo;
    TextView awp;
    TextView awq;
    LinearLayout awr;
    TextView aws;
    ImageView awt;
    LinearLayout awu;
    TextView awv;
    ImageView aww;
    com.baidu.tbadk.core.view.y awx;
    com.baidu.tbadk.core.view.y awy;
    PopupWindow awz;
    private boolean iC;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    boolean awm = true;
    private int awG = 0;

    public u(ForumListActivity forumListActivity) {
        this.iC = false;
        this.asy = (LinearLayout) forumListActivity.findViewById(com.baidu.tieba.v.forum_list_root);
        this.Ct = (ViewPager) forumListActivity.findViewById(com.baidu.tieba.v.view_pager);
        this.Ct.setOnPageChangeListener(forumListActivity);
        this.awl = (LinearLayout) forumListActivity.findViewById(com.baidu.tieba.v.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.awE = (LinearLayout) this.mNavigationBar.setTitleView(com.baidu.tieba.w.nb_item_forum_list, (View.OnClickListener) null);
        this.awF = (ImageView) this.awE.findViewById(com.baidu.tieba.v.title_arrow);
        this.atA = (TextView) this.awE.findViewById(com.baidu.tieba.v.title_text);
        this.awp = (TextView) forumListActivity.findViewById(com.baidu.tieba.v.tab_recommends);
        this.awp.setOnClickListener(forumListActivity);
        this.awq = (TextView) forumListActivity.findViewById(com.baidu.tieba.v.tab_hot);
        this.awq.setOnClickListener(forumListActivity);
        this.awx = new com.baidu.tbadk.core.view.y(forumListActivity);
        this.awy = new com.baidu.tbadk.core.view.y(forumListActivity);
        this.awr = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(forumListActivity, com.baidu.tieba.w.forum_list_forum_footer, null);
        this.awj = this.awr.findViewById(com.baidu.tieba.v.footer_background);
        this.aws = (TextView) this.awr.findViewById(com.baidu.tieba.v.footer_text);
        this.awt = (ImageView) this.awr.findViewById(com.baidu.tieba.v.footer_icon);
        this.awu = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(forumListActivity, com.baidu.tieba.w.forum_list_forum_footer, null);
        this.awk = this.awu.findViewById(com.baidu.tieba.v.footer_background);
        this.awv = (TextView) this.awu.findViewById(com.baidu.tieba.v.footer_text);
        this.aww = (ImageView) this.awu.findViewById(com.baidu.tieba.v.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(com.baidu.tieba.v.loading);
        this.iC = false;
        this.awB = forumListActivity;
        this.awD = new a(this.awB);
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.awB, com.baidu.tieba.w.forum_list__dir_menu, null);
        this.awC = (ListView) inflate.findViewById(com.baidu.tieba.v.dir_menu_list);
        this.awC.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(com.baidu.tieba.u.bg_allsproutpop_dropdown);
        this.awG = this.awD.getCount();
        this.awC.setAdapter((ListAdapter) this.awD);
        return inflate;
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.iC) {
            aw.c(this.awF, com.baidu.tieba.u.btn_allsproutpop_up);
            this.iC = true;
            if (this.awA == null) {
                this.awA = a(0, onItemClickListener);
            }
            int dip2px = (com.baidu.adp.lib.util.m.dip2px(this.awB, 160.0f) - this.awE.getWidth()) / 2;
            if (this.awz == null) {
                this.awz = new PopupWindow(this.awA, com.baidu.adp.lib.util.m.dip2px(this.awB, 160.0f), -2, true);
                this.awz.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.awG > 6) {
                    this.awz.setHeight(com.baidu.adp.lib.util.m.dip2px(this.awB, 272.0f));
                }
            }
            this.awz.setOutsideTouchable(true);
            this.awz.setFocusable(true);
            this.awA.setFocusable(true);
            this.awA.setFocusableInTouchMode(true);
            com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(this.awz, this.awE, 0 - dip2px, com.baidu.adp.lib.util.m.dip2px(this.awB, 0.0f));
            this.awA.setOnKeyListener(new v(this));
            this.awA.setOnTouchListener(new w(this));
            this.awz.setOnDismissListener(new x(this));
            return;
        }
        com.baidu.adp.lib.g.j.a(this.awz, this.awB);
        this.awF.setImageResource(com.baidu.tieba.u.btn_allsproutpop_down);
        this.iC = false;
    }

    public void DS() {
        this.awl.setVisibility(0);
    }

    public void DT() {
        this.awl.setVisibility(8);
    }

    public void DU() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.Ct != null) {
            if (this.Ct.getCurrentItem() == 0 && this.awn != null) {
                this.awn.hN();
            } else if (this.awo != null) {
                this.awo.hN();
            }
        }
    }

    public void DV() {
        this.awE.setClickable(false);
        this.awE.setOnClickListener(null);
    }
}
