package com.baidu.tieba.flist;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class w {
    ImageView A;
    ProgressBar B;
    private boolean C;
    LinearLayout a;
    final View b;
    final View c;
    ViewPager d;
    LinearLayout e;
    NavigationBar f;
    TextView h;
    BdListView i;
    BdListView j;
    TextView k;
    TextView l;
    LinearLayout m;
    TextView n;
    ImageView o;
    LinearLayout p;
    TextView q;
    ImageView r;
    com.baidu.tbadk.core.view.q s;
    com.baidu.tbadk.core.view.q t;
    PopupWindow u;
    View v;
    ForumListActivity w;
    ListView x;
    a y;
    LinearLayout z;
    boolean g = true;
    private int D = 0;

    public w(ForumListActivity forumListActivity) {
        this.C = false;
        this.a = (LinearLayout) forumListActivity.findViewById(com.baidu.tieba.r.forum_list_root);
        this.d = (ViewPager) forumListActivity.findViewById(com.baidu.tieba.r.view_pager);
        this.d.setOnPageChangeListener(forumListActivity);
        this.e = (LinearLayout) forumListActivity.findViewById(com.baidu.tieba.r.tab_strip);
        this.f = (NavigationBar) forumListActivity.findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.z = (LinearLayout) this.f.a(com.baidu.tieba.s.nb_item_forum_list, (View.OnClickListener) null);
        this.A = (ImageView) this.z.findViewById(com.baidu.tieba.r.title_arrow);
        this.h = (TextView) this.z.findViewById(com.baidu.tieba.r.title_text);
        this.k = (TextView) forumListActivity.findViewById(com.baidu.tieba.r.tab_recommends);
        this.k.setOnClickListener(forumListActivity);
        this.l = (TextView) forumListActivity.findViewById(com.baidu.tieba.r.tab_hot);
        this.l.setOnClickListener(forumListActivity);
        this.s = new com.baidu.tbadk.core.view.q(forumListActivity);
        this.t = new com.baidu.tbadk.core.view.q(forumListActivity);
        this.m = (LinearLayout) forumListActivity.getLayoutInflater().inflate(com.baidu.tieba.s.forum_list_forum_footer, (ViewGroup) null);
        this.b = this.m.findViewById(com.baidu.tieba.r.footer_background);
        this.n = (TextView) this.m.findViewById(com.baidu.tieba.r.footer_text);
        this.o = (ImageView) this.m.findViewById(com.baidu.tieba.r.footer_icon);
        this.p = (LinearLayout) forumListActivity.getLayoutInflater().inflate(com.baidu.tieba.s.forum_list_forum_footer, (ViewGroup) null);
        this.c = this.p.findViewById(com.baidu.tieba.r.footer_background);
        this.q = (TextView) this.p.findViewById(com.baidu.tieba.r.footer_text);
        this.r = (ImageView) this.p.findViewById(com.baidu.tieba.r.footer_icon);
        this.B = (ProgressBar) forumListActivity.findViewById(com.baidu.tieba.r.loading);
        this.C = false;
        this.w = forumListActivity;
        this.y = new a(this.w);
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.w).inflate(com.baidu.tieba.s.forum_list__dir_menu, (ViewGroup) null);
        this.x = (ListView) inflate.findViewById(com.baidu.tieba.r.dir_menu_list);
        this.x.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(com.baidu.tieba.q.bg_allsproutpop_dropdown);
        this.D = this.y.getCount();
        this.x.setAdapter((ListAdapter) this.y);
        return inflate;
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.C) {
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                this.A.setImageResource(com.baidu.tieba.q.btn_allsproutpop_up_1);
            } else {
                this.A.setImageResource(com.baidu.tieba.q.btn_allsproutpop_up);
            }
            this.C = true;
            if (this.v == null) {
                this.v = a(0, onItemClickListener);
            }
            int a = (com.baidu.adp.lib.util.h.a((Context) this.w, 160.0f) - this.z.getWidth()) / 2;
            if (this.u == null) {
                this.u = new PopupWindow(this.v, com.baidu.adp.lib.util.h.a((Context) this.w, 160.0f), -2, true);
                this.u.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.D > 6) {
                    this.u.setHeight(com.baidu.adp.lib.util.h.a((Context) this.w, 272.0f));
                }
            }
            this.u.setOutsideTouchable(true);
            this.u.setFocusable(true);
            this.v.setFocusable(true);
            this.v.setFocusableInTouchMode(true);
            this.u.showAsDropDown(this.z, 0 - a, com.baidu.adp.lib.util.h.a((Context) this.w, 0.0f));
            this.v.setOnKeyListener(new x(this));
            this.v.setOnTouchListener(new y(this));
            this.u.setOnDismissListener(new z(this));
            return;
        }
        this.u.dismiss();
        this.A.setImageResource(com.baidu.tieba.q.btn_allsproutpop_down);
        this.C = false;
    }

    public void a() {
        this.e.setVisibility(0);
    }

    public void b() {
        this.e.setVisibility(8);
    }

    public void c() {
        if (this.d.getCurrentItem() == 0) {
            this.i.c();
        } else {
            this.j.c();
        }
        this.B.setVisibility(8);
    }

    public void d() {
        this.z.setClickable(false);
        this.z.setOnClickListener(null);
    }
}
