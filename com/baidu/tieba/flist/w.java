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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.cs;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class w {
    ProgressBar A;
    private boolean B;
    private int C = 0;
    LinearLayout a;
    final View b;
    final View c;
    ViewPager d;
    LinearLayout e;
    NavigationBar f;
    TextView g;
    BdListView h;
    BdListView i;
    TextView j;
    TextView k;
    LinearLayout l;
    TextView m;
    ImageView n;
    LinearLayout o;
    TextView p;
    ImageView q;
    cs r;
    cs s;
    PopupWindow t;
    View u;
    ForumListActivity v;
    ListView w;
    a x;
    LinearLayout y;
    ImageView z;

    public w(ForumListActivity forumListActivity) {
        this.B = false;
        this.a = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.d = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.d.setOnPageChangeListener(forumListActivity);
        this.e = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.f = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.y = (LinearLayout) this.f.a(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.z = (ImageView) this.y.findViewById(R.id.title_arrow);
        this.g = (TextView) this.y.findViewById(R.id.title_text);
        this.j = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.j.setOnClickListener(forumListActivity);
        this.k = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.k.setOnClickListener(forumListActivity);
        this.r = new cs(forumListActivity);
        this.s = new cs(forumListActivity);
        this.l = (LinearLayout) forumListActivity.getLayoutInflater().inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.b = this.l.findViewById(R.id.footer_background);
        this.m = (TextView) this.l.findViewById(R.id.footer_text);
        this.n = (ImageView) this.l.findViewById(R.id.footer_icon);
        this.o = (LinearLayout) forumListActivity.getLayoutInflater().inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.c = this.o.findViewById(R.id.footer_background);
        this.p = (TextView) this.o.findViewById(R.id.footer_text);
        this.q = (ImageView) this.o.findViewById(R.id.footer_icon);
        this.A = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.B = false;
        this.v = forumListActivity;
        this.x = new a(this.v);
    }

    public final void a(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.B) {
            if (TiebaApplication.g().ae() == 1) {
                this.z.setImageResource(R.drawable.btn_allsproutpop_up_1);
            } else {
                this.z.setImageResource(R.drawable.btn_allsproutpop_up);
            }
            this.B = true;
            if (this.u == null) {
                View inflate = LayoutInflater.from(this.v).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
                this.w = (ListView) inflate.findViewById(R.id.dir_menu_list);
                this.w.setOnItemClickListener(onItemClickListener);
                inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
                this.C = this.x.getCount();
                this.w.setAdapter((ListAdapter) this.x);
                this.u = inflate;
            }
            int a = (BdUtilHelper.a((Context) this.v, 160.0f) - this.y.getWidth()) / 2;
            if (this.t == null) {
                this.t = new PopupWindow(this.u, BdUtilHelper.a((Context) this.v, 160.0f), -2, true);
                this.t.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.C > 6) {
                    this.t.setHeight(BdUtilHelper.a((Context) this.v, 272.0f));
                }
            }
            this.t.setOutsideTouchable(true);
            this.t.setFocusable(true);
            this.u.setFocusable(true);
            this.u.setFocusableInTouchMode(true);
            this.t.showAsDropDown(this.y, 0 - a, BdUtilHelper.a((Context) this.v, 0.0f));
            this.u.setOnKeyListener(new x(this));
            this.u.setOnTouchListener(new y(this));
            this.t.setOnDismissListener(new z(this));
            return;
        }
        this.t.dismiss();
        this.z.setImageResource(R.drawable.btn_allsproutpop_down);
        this.B = false;
    }

    public final void a() {
        if (this.d.getCurrentItem() == 0) {
            this.h.a();
        } else {
            this.i.a();
        }
        this.A.setVisibility(8);
    }

    public final void b() {
        this.y.setClickable(false);
        this.y.setOnClickListener(null);
    }
}
