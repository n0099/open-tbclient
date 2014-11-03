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
    ViewPager Cu;
    LinearLayout asH;
    TextView atJ;
    LinearLayout awA;
    TextView awB;
    ImageView awC;
    LinearLayout awD;
    TextView awE;
    ImageView awF;
    com.baidu.tbadk.core.view.y awG;
    com.baidu.tbadk.core.view.y awH;
    PopupWindow awI;
    View awJ;
    ForumListActivity awK;
    ListView awL;
    a awM;
    LinearLayout awN;
    ImageView awO;
    final View aws;
    final View awt;
    LinearLayout awu;
    BdListView aww;
    BdListView awx;
    TextView awy;
    TextView awz;
    private boolean iC;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    boolean awv = true;
    private int awP = 0;

    public u(ForumListActivity forumListActivity) {
        this.iC = false;
        this.asH = (LinearLayout) forumListActivity.findViewById(com.baidu.tieba.v.forum_list_root);
        this.Cu = (ViewPager) forumListActivity.findViewById(com.baidu.tieba.v.view_pager);
        this.Cu.setOnPageChangeListener(forumListActivity);
        this.awu = (LinearLayout) forumListActivity.findViewById(com.baidu.tieba.v.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.awN = (LinearLayout) this.mNavigationBar.setTitleView(com.baidu.tieba.w.nb_item_forum_list, (View.OnClickListener) null);
        this.awO = (ImageView) this.awN.findViewById(com.baidu.tieba.v.title_arrow);
        this.atJ = (TextView) this.awN.findViewById(com.baidu.tieba.v.title_text);
        this.awy = (TextView) forumListActivity.findViewById(com.baidu.tieba.v.tab_recommends);
        this.awy.setOnClickListener(forumListActivity);
        this.awz = (TextView) forumListActivity.findViewById(com.baidu.tieba.v.tab_hot);
        this.awz.setOnClickListener(forumListActivity);
        this.awG = new com.baidu.tbadk.core.view.y(forumListActivity);
        this.awH = new com.baidu.tbadk.core.view.y(forumListActivity);
        this.awA = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(forumListActivity, com.baidu.tieba.w.forum_list_forum_footer, null);
        this.aws = this.awA.findViewById(com.baidu.tieba.v.footer_background);
        this.awB = (TextView) this.awA.findViewById(com.baidu.tieba.v.footer_text);
        this.awC = (ImageView) this.awA.findViewById(com.baidu.tieba.v.footer_icon);
        this.awD = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(forumListActivity, com.baidu.tieba.w.forum_list_forum_footer, null);
        this.awt = this.awD.findViewById(com.baidu.tieba.v.footer_background);
        this.awE = (TextView) this.awD.findViewById(com.baidu.tieba.v.footer_text);
        this.awF = (ImageView) this.awD.findViewById(com.baidu.tieba.v.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(com.baidu.tieba.v.loading);
        this.iC = false;
        this.awK = forumListActivity;
        this.awM = new a(this.awK);
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.awK, com.baidu.tieba.w.forum_list__dir_menu, null);
        this.awL = (ListView) inflate.findViewById(com.baidu.tieba.v.dir_menu_list);
        this.awL.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(com.baidu.tieba.u.bg_allsproutpop_dropdown);
        this.awP = this.awM.getCount();
        this.awL.setAdapter((ListAdapter) this.awM);
        return inflate;
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.iC) {
            aw.c(this.awO, com.baidu.tieba.u.btn_allsproutpop_up);
            this.iC = true;
            if (this.awJ == null) {
                this.awJ = a(0, onItemClickListener);
            }
            int dip2px = (com.baidu.adp.lib.util.m.dip2px(this.awK, 160.0f) - this.awN.getWidth()) / 2;
            if (this.awI == null) {
                this.awI = new PopupWindow(this.awJ, com.baidu.adp.lib.util.m.dip2px(this.awK, 160.0f), -2, true);
                this.awI.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.awP > 6) {
                    this.awI.setHeight(com.baidu.adp.lib.util.m.dip2px(this.awK, 272.0f));
                }
            }
            this.awI.setOutsideTouchable(true);
            this.awI.setFocusable(true);
            this.awJ.setFocusable(true);
            this.awJ.setFocusableInTouchMode(true);
            com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(this.awI, this.awN, 0 - dip2px, com.baidu.adp.lib.util.m.dip2px(this.awK, 0.0f));
            this.awJ.setOnKeyListener(new v(this));
            this.awJ.setOnTouchListener(new w(this));
            this.awI.setOnDismissListener(new x(this));
            return;
        }
        com.baidu.adp.lib.g.j.a(this.awI, this.awK);
        this.awO.setImageResource(com.baidu.tieba.u.btn_allsproutpop_down);
        this.iC = false;
    }

    public void DU() {
        this.awu.setVisibility(0);
    }

    public void DV() {
        this.awu.setVisibility(8);
    }

    public void DW() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.Cu != null) {
            if (this.Cu.getCurrentItem() == 0 && this.aww != null) {
                this.aww.hN();
            } else if (this.awx != null) {
                this.awx.hN();
            }
        }
    }

    public void DX() {
        this.awN.setClickable(false);
        this.awN.setOnClickListener(null);
    }
}
