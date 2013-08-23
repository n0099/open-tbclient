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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.aa;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class w {
    ProgressBar A;
    private boolean B;
    private int C = 0;

    /* renamed from: a  reason: collision with root package name */
    final View f1057a;
    final View b;
    ViewPager c;
    LinearLayout d;
    RelativeLayout e;
    ImageView f;
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
    aa r;
    aa s;
    PopupWindow t;
    View u;
    ForumListActivity v;
    ListView w;
    a x;
    LinearLayout y;
    ImageView z;

    public w(ForumListActivity forumListActivity) {
        this.B = false;
        this.c = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.c.setOnPageChangeListener(forumListActivity);
        this.d = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.e = (RelativeLayout) forumListActivity.findViewById(R.id.title);
        this.f = (ImageView) forumListActivity.findViewById(R.id.title_back);
        this.g = (TextView) forumListActivity.findViewById(R.id.title_text);
        this.f.setOnClickListener(forumListActivity);
        this.j = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.j.setOnClickListener(forumListActivity);
        this.k = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.k.setOnClickListener(forumListActivity);
        this.r = new aa(forumListActivity);
        this.s = new aa(forumListActivity);
        this.l = (LinearLayout) forumListActivity.getLayoutInflater().inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.f1057a = this.l.findViewById(R.id.footer_background);
        this.m = (TextView) this.l.findViewById(R.id.footer_text);
        this.n = (ImageView) this.l.findViewById(R.id.footer_icon);
        this.o = (LinearLayout) forumListActivity.getLayoutInflater().inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.b = this.o.findViewById(R.id.footer_background);
        this.p = (TextView) this.o.findViewById(R.id.footer_text);
        this.q = (ImageView) this.o.findViewById(R.id.footer_icon);
        this.y = (LinearLayout) forumListActivity.findViewById(R.id.title_menu);
        this.z = (ImageView) forumListActivity.findViewById(R.id.title_arrow);
        this.A = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.B = false;
        this.v = forumListActivity;
        this.x = new a(this.v);
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.v).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.w = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.w.setOnItemClickListener(onItemClickListener);
        this.w.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.C = this.x.getCount();
        this.w.setAdapter((ListAdapter) this.x);
        return inflate;
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.B) {
            if (TiebaApplication.g().an() == 1) {
                this.z.setImageResource(R.drawable.btn_allsproutpop_up_1);
            } else {
                this.z.setImageResource(R.drawable.btn_allsproutpop_up);
            }
            this.B = true;
            if (this.u == null) {
                this.u = a(0, onItemClickListener);
            }
            int a2 = (UtilHelper.a((Context) this.v, 160.0f) - this.y.getWidth()) / 2;
            if (this.t == null) {
                this.t = new PopupWindow(this.u, UtilHelper.a((Context) this.v, 160.0f), -2, true);
                this.t.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.C > 6) {
                    this.t.setHeight(UtilHelper.a((Context) this.v, 272.0f));
                }
            }
            this.t.setOutsideTouchable(true);
            this.t.setFocusable(true);
            this.u.setFocusable(true);
            this.u.setFocusableInTouchMode(true);
            this.t.showAsDropDown(this.y, 0 - a2, UtilHelper.a((Context) this.v, 10.0f));
            this.u.setOnKeyListener(new x(this));
            this.u.setOnTouchListener(new y(this));
            this.t.setOnDismissListener(new z(this));
            return;
        }
        this.t.dismiss();
        this.z.setImageResource(R.drawable.btn_allsproutpop_down);
        this.B = false;
    }

    public void a() {
        this.d.setVisibility(0);
    }

    public void b() {
        this.d.setVisibility(8);
    }

    public void c() {
        if (this.c.getCurrentItem() == 0) {
            this.h.a();
        } else {
            this.i.a();
        }
        this.A.setVisibility(8);
    }

    public void d() {
        this.y.setClickable(false);
        this.y.setOnClickListener(null);
    }
}
