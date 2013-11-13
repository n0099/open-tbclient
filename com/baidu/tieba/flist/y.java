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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.bi;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class y {
    private boolean A;
    private int B = 0;

    /* renamed from: a  reason: collision with root package name */
    final View f1265a;
    final View b;
    ViewPager c;
    LinearLayout d;
    NavigationBar e;
    TextView f;
    BdListView g;
    BdListView h;
    TextView i;
    TextView j;
    LinearLayout k;
    TextView l;
    ImageView m;
    LinearLayout n;
    TextView o;
    ImageView p;
    bi q;
    bi r;
    PopupWindow s;
    View t;
    ForumListActivity u;
    ListView v;
    a w;
    LinearLayout x;
    ImageView y;
    ProgressBar z;

    public y(ForumListActivity forumListActivity) {
        this.A = false;
        this.c = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.c.setOnPageChangeListener(forumListActivity);
        this.d = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.e = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.x = (LinearLayout) this.e.a(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.y = (ImageView) this.x.findViewById(R.id.title_arrow);
        this.f = (TextView) this.x.findViewById(R.id.title_text);
        this.i = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.i.setOnClickListener(forumListActivity);
        this.j = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.j.setOnClickListener(forumListActivity);
        this.q = new bi(forumListActivity);
        this.r = new bi(forumListActivity);
        this.k = (LinearLayout) forumListActivity.getLayoutInflater().inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.f1265a = this.k.findViewById(R.id.footer_background);
        this.l = (TextView) this.k.findViewById(R.id.footer_text);
        this.m = (ImageView) this.k.findViewById(R.id.footer_icon);
        this.n = (LinearLayout) forumListActivity.getLayoutInflater().inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.b = this.n.findViewById(R.id.footer_background);
        this.o = (TextView) this.n.findViewById(R.id.footer_text);
        this.p = (ImageView) this.n.findViewById(R.id.footer_icon);
        this.z = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.A = false;
        this.u = forumListActivity;
        this.w = new a(this.u);
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.u).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.v = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.v.setOnItemClickListener(onItemClickListener);
        this.v.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.B = this.w.getCount();
        this.v.setAdapter((ListAdapter) this.w);
        return inflate;
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.A) {
            if (TiebaApplication.g().ap() == 1) {
                this.y.setImageResource(R.drawable.btn_allsproutpop_up_1);
            } else {
                this.y.setImageResource(R.drawable.btn_allsproutpop_up);
            }
            this.A = true;
            if (this.t == null) {
                this.t = a(0, onItemClickListener);
            }
            int a2 = (UtilHelper.a((Context) this.u, 160.0f) - this.x.getWidth()) / 2;
            if (this.s == null) {
                this.s = new PopupWindow(this.t, UtilHelper.a((Context) this.u, 160.0f), -2, true);
                this.s.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.B > 6) {
                    this.s.setHeight(UtilHelper.a((Context) this.u, 272.0f));
                }
            }
            this.s.setOutsideTouchable(true);
            this.s.setFocusable(true);
            this.t.setFocusable(true);
            this.t.setFocusableInTouchMode(true);
            this.s.showAsDropDown(this.x, 0 - a2, UtilHelper.a((Context) this.u, 0.0f));
            this.t.setOnKeyListener(new z(this));
            this.t.setOnTouchListener(new aa(this));
            this.s.setOnDismissListener(new ab(this));
            return;
        }
        this.s.dismiss();
        this.y.setImageResource(R.drawable.btn_allsproutpop_down);
        this.A = false;
    }

    public void a() {
        this.d.setVisibility(0);
    }

    public void b() {
        this.d.setVisibility(8);
    }

    public void c() {
        if (this.c.getCurrentItem() == 0) {
            this.g.a();
        } else {
            this.h.a();
        }
        this.z.setVisibility(8);
    }

    public void d() {
        this.x.setClickable(false);
        this.x.setOnClickListener(null);
    }
}
