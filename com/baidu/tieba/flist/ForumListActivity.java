package com.baidu.tieba.flist;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.model.ar;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ForumListActivity extends com.baidu.tieba.f implements ViewPager.OnPageChangeListener {
    private ForumListModel.RequestParams A;
    private r D;
    private r E;
    private c F;
    private t G;
    public ForumListModel.List a;
    public ForumListModel.List b;
    public w c;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    public static boolean d = false;
    private static String L = "";
    private static String M = "";
    private static String N = "";
    private static String O = "";
    private Handler e = null;
    private int n = 200;
    private int o = 200;
    private int p = 0;
    private ar q = new ar();
    private com.baidu.tieba.util.i r = null;
    private boolean s = false;
    private int t = 0;
    private boolean u = false;
    private int v = 0;
    private int w = 200;
    private boolean x = true;
    private boolean y = true;
    private int z = 0;
    private boolean B = false;
    private boolean C = false;
    private u H = new f(this);
    private e I = new g(this);
    private AdapterView.OnItemClickListener J = new h(this);
    private com.baidu.adp.widget.ListView.b K = new i(this);
    private Runnable P = new j(this);
    private AbsListView.OnScrollListener Q = new k(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.baidu.tieba.square.ab a = this.c.x.a();
        if (a != null) {
            ArrayList<com.baidu.tieba.square.ab> arrayList = a.e;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).b.equals(str)) {
                    this.t = i;
                    this.c.x.a(this.t);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        try {
            this.A.menu_id = Integer.valueOf(str2).intValue();
            this.A.menu_name = str;
            this.A.menu_type = Integer.valueOf(str3).intValue();
            this.A.parent_menu_id = Integer.valueOf(getIntent().getStringExtra("parent_menu_id")).intValue();
            this.A.parent_menu_name = getIntent().getStringExtra("parent_menu_name");
            this.A.offset = 0;
            this.A.rn = 10;
            com.baidu.adp.lib.util.f.e("ForumListActivity", "onCreate", this.A.toString());
        } catch (NullPointerException e) {
            finish();
        }
        this.v = this.A.recommend_type;
        this.w = this.A.rn;
        this.A.recommend_type = 0;
        this.A.rn = 200;
        this.u = true;
        this.G.a(this.A);
        this.G.LoadData();
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(context, ForumListActivity.class);
        intent.putExtra("menu_name", str);
        intent.putExtra("menu_id", str2);
        intent.putExtra("menu_type", str3);
        intent.putExtra("parent_menu_name", str4);
        intent.putExtra("parent_menu_id", str5);
        context.startActivity(intent);
    }

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, ForumListActivity.class);
        intent.putExtra("parent_menu_name", str);
        intent.putExtra("menu_type", str2);
        intent.putExtra("parent_menu_id", str3);
        context.startActivity(intent);
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(context, ForumListActivity.class);
        intent.putExtra("parent_menu_name", str);
        intent.putExtra("menu_type", str2);
        intent.putExtra("parent_menu_id", str3);
        intent.putExtra("level_2_menu_name", str4);
        context.startActivity(intent);
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forum_list_activity);
        this.c = new w(this);
        this.c.h = (BdListView) a();
        this.c.i = (BdListView) c();
        this.c.A.setVisibility(0);
        this.c.y.setOnClickListener(null);
        this.c.y.setClickable(false);
        this.c.d.setAdapter(new o(this));
        this.D = new r(this, 0);
        this.c.h.setAdapter((ListAdapter) this.D);
        this.E = new r(this, 1);
        this.c.i.setAdapter((ListAdapter) this.E);
        b(getIntent().getStringExtra("parent_menu_name"), getIntent().getStringExtra("parent_menu_id"), getIntent().getStringExtra("menu_type"), getIntent().getStringExtra("level_2_menu_name"));
    }

    private void b(String str, String str2, String str3, String str4) {
        this.e = new Handler();
        if (bs.c(str4)) {
            str4 = str;
        }
        this.c.g.setText(str4);
        this.r = new com.baidu.tieba.util.i(this);
        this.A = new ForumListModel.RequestParams();
        try {
            this.A.menu_id = Integer.valueOf(str2).intValue();
            this.A.menu_name = str4;
            this.A.menu_type = Integer.valueOf(str3).intValue();
            this.A.parent_menu_id = Integer.valueOf(str2).intValue();
            this.A.parent_menu_name = str;
            this.A.offset = 0;
            this.A.rn = 10;
            com.baidu.adp.lib.util.f.e("ForumListActivity", "onCreate", this.A.toString());
        } catch (NullPointerException e) {
            finish();
        }
        if (this.A.menu_id != 0) {
            this.c.b();
            this.s = true;
            this.y = false;
            this.D.a(Boolean.valueOf(this.y));
            this.c.d.getAdapter().notifyDataSetChanged();
        } else {
            this.y = true;
            this.D.a(Boolean.valueOf(this.y));
            this.c.a();
        }
        this.a = new ForumListModel.List();
        this.b = new ForumListModel.List();
        this.a.forum_list = new ForumInfoData[50];
        this.b.forum_list = new ForumInfoData[50];
        this.c.h.setPullRefresh(this.c.r);
        this.c.i.setPullRefresh(this.c.s);
        this.c.r.a(this.K);
        this.c.s.a(this.K);
        if (str3.equals("2")) {
            com.baidu.adp.lib.util.f.e("ForumListActivity", "OnCreate", "from frs");
            this.c.z.setVisibility(8);
            this.c.d();
        } else {
            this.F = new c(this, str, str3, str2);
            this.F.a(this.I);
            this.F.LoadData();
        }
        this.G = new t(this, this.A);
        this.G.a(this.H);
        this.c.h.b();
    }

    public static void a(String str, String str2, String str3, String str4) {
        L = str;
        M = str2;
        N = str3;
        O = str4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (d) {
            d = false;
            finish();
            a(this, L, N, M, O);
            return;
        }
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            if (this.D != null) {
                this.D.b();
                this.D.notifyDataSetChanged();
            }
            if (this.E != null) {
                this.E.b();
                this.E.notifyDataSetChanged();
            }
        }
        this.e.removeCallbacks(this.P);
        this.e.post(this.P);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        this.e.removeCallbacks(this.P);
        this.r.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.q != null) {
            this.q.a();
        }
        this.c.d.setAdapter(null);
        this.c.i.setAdapter((ListAdapter) null);
        this.c.h.setAdapter((ListAdapter) null);
        if (this.c.w != null) {
            this.c.w.setAdapter((ListAdapter) null);
        }
        if (this.F != null) {
            this.F.cancelLoadData();
        }
        if (this.G != null) {
            this.G.cancelLoadData();
        }
        this.e.removeCallbacks(this.P);
        this.r.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        getLayoutMode().a(i == 1);
        getLayoutMode().a((View) this.c.a);
        this.c.f.c(i);
        if (TiebaApplication.g().al() == 1) {
            this.D.a(true);
            this.E.a(true);
        } else {
            this.D.a(false);
            this.E.a(false);
        }
        this.D.notifyDataSetChanged();
        this.E.notifyDataSetChanged();
        if (i == 1) {
            if (this.c.t != null) {
                this.c.t.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_allsproutpop_dropdown_1));
            }
            this.c.z.setImageResource(R.drawable.btn_allsproutpop_down_1);
            this.c.e.setBackgroundResource(R.drawable.bg_up_bar_1);
            this.f = getResources().getColor(R.color.flist_text_color_night);
            this.g = getResources().getColor(R.color.forum_list_tab_text_select);
            this.h = R.drawable.btn_pop_most_left_n_1;
            this.i = R.drawable.btn_pop_most_right_n_1;
            this.j = R.drawable.btn_pop_most_left_s_1;
            this.k = R.drawable.btn_pop_most_right_s_1;
            this.l = R.drawable.ico_downward_1;
            this.m = R.drawable.ico_upward_1;
            this.D.a(R.drawable.btn_add_end_1, R.drawable.btn_add_1);
            this.E.a(R.drawable.btn_add_end_1, R.drawable.btn_add_1);
            this.c.j.setTextColor(this.f);
            this.c.k.setTextColor(this.f);
            this.c.c.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            this.c.p.setTextColor(getResources().getColor(R.color.flist_text_color_night));
            this.c.b.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            this.c.m.setTextColor(getResources().getColor(R.color.flist_text_color_night));
            if (this.c.r != null && this.c.s != null) {
                this.c.r.a(i);
                this.c.s.a(i);
            }
            if (this.B) {
                this.c.n.setImageResource(R.drawable.ico_upward_1);
            } else {
                this.c.n.setImageResource(R.drawable.ico_downward_1);
            }
            if (this.C) {
                this.c.q.setImageResource(R.drawable.ico_upward_1);
            } else {
                this.c.q.setImageResource(R.drawable.ico_downward_1);
            }
        } else {
            if (this.c.t != null) {
                this.c.t.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_allsproutpop_dropdown_1));
            }
            this.c.z.setImageResource(R.drawable.btn_allsproutpop_down);
            this.c.e.setBackgroundResource(R.drawable.bg_pop_most);
            this.f = getResources().getColor(R.color.flist_text_color_day);
            this.g = getResources().getColor(R.color.forum_list_tab_text_select);
            this.h = R.drawable.btn_pop_most_left_n;
            this.i = R.drawable.btn_pop_most_right_n;
            this.j = R.drawable.btn_pop_most_left_s;
            this.k = R.drawable.btn_pop_most_right_s;
            this.l = R.drawable.ico_downward;
            this.m = R.drawable.ico_upward;
            this.D.a(R.drawable.btn_add_end, R.drawable.btn_add);
            this.E.a(R.drawable.btn_add_end, R.drawable.btn_add);
            this.c.c.setBackgroundResource(R.drawable.bg_black_banner_down);
            this.c.p.setTextColor(getResources().getColor(R.color.flist_text_color_day));
            this.c.b.setBackgroundResource(R.drawable.bg_black_banner_down);
            this.c.m.setTextColor(getResources().getColor(R.color.flist_text_color_day));
            if (this.B) {
                this.c.n.setImageResource(R.drawable.ico_upward);
            } else {
                this.c.n.setImageResource(R.drawable.ico_downward);
            }
            if (this.C) {
                this.c.q.setImageResource(R.drawable.ico_upward);
            } else {
                this.c.q.setImageResource(R.drawable.ico_downward);
            }
        }
        if (this.c.d.getCurrentItem() == 0) {
            this.c.j.setTextColor(this.g);
            this.c.j.setBackgroundResource(this.j);
            this.c.k.setBackgroundResource(this.i);
            this.c.k.setTextColor(this.f);
            return;
        }
        this.c.k.setTextColor(this.g);
        this.c.k.setBackgroundResource(this.k);
        this.c.j.setBackgroundResource(this.h);
        this.c.j.setTextColor(this.f);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_recommends /* 2131100368 */:
                this.c.d.setCurrentItem(0);
                this.p = 0;
                cb.a(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
                return;
            case R.id.tab_hot /* 2131100369 */:
                this.c.d.setCurrentItem(1);
                this.p = 1;
                cb.a(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
                return;
            case R.id.title_menu /* 2131101118 */:
                this.c.a(this.J);
                return;
            default:
                return;
        }
    }

    private View a() {
        this.c.h = e();
        this.c.l.setOnClickListener(new l(this));
        return this.c.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.B) {
            int min = Math.min(this.D.getCount(), 200);
            this.n = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.D.a(), 0, forumInfoDataArr, 0, min);
            this.D.a(min);
            this.D.a(forumInfoDataArr);
            this.B = false;
            this.c.m.setText(getString(R.string.flist_expand_list));
            this.c.n.setImageResource(this.l);
            return;
        }
        this.n = 50;
        q qVar = new q(this, null);
        qVar.a(true);
        qVar.execute(new Void[0]);
    }

    private View c() {
        this.c.i = e();
        this.c.o.setOnClickListener(new m(this));
        return this.c.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.C) {
            int min = Math.min(this.E.getCount(), 200);
            this.o = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.E.a(), 0, forumInfoDataArr, 0, min);
            this.E.a(min);
            this.E.a(forumInfoDataArr);
            this.C = false;
            this.c.p.setText(getString(R.string.flist_expand_list));
            this.c.q.setImageResource(this.l);
            return;
        }
        this.o = 50;
        p pVar = new p(this, null);
        pVar.a(true);
        pVar.execute(new Void[0]);
    }

    private BdListView e() {
        BdListView bdListView = new BdListView(this);
        bdListView.setScrollingCacheEnabled(false);
        bdListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        bdListView.setCacheColorHint(0);
        bdListView.setSelector(17170445);
        bdListView.setDivider(new ColorDrawable(0));
        bdListView.setDividerHeight(0);
        bdListView.setFooterDividersEnabled(false);
        bdListView.setHorizontalFadingEdgeEnabled(false);
        bdListView.setVerticalFadingEdgeEnabled(false);
        bdListView.setOnScrollListener(this.Q);
        return bdListView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.z = i;
        if (!this.s) {
            if (i == 0) {
                this.D.b();
                this.D.notifyDataSetChanged();
                this.c.j.setBackgroundResource(this.j);
                this.c.j.setTextColor(this.g);
                this.c.k.setBackgroundResource(this.i);
                this.c.k.setTextColor(this.f);
            } else if (i == 1) {
                this.E.b();
                this.E.notifyDataSetChanged();
                this.c.k.setBackgroundResource(this.k);
                this.c.k.setTextColor(this.g);
                this.c.j.setBackgroundResource(this.h);
                this.c.j.setTextColor(this.f);
            }
            this.e.removeCallbacks(this.P);
            this.e.post(this.P);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        ForumInfoData[] a;
        if (i == 11002 && i2 == -1) {
            this.G.LoadData();
            if (this.p == 0) {
                a = this.D.a();
            } else {
                a = this.E.a();
            }
            this.q.setLoadDataCallBack(new n(this, a));
            if (this.p == 0) {
                this.q.a(a[this.D.a].forum_name, String.valueOf(a[this.D.a].forum_id));
            } else {
                this.q.a(a[this.E.a].forum_name, String.valueOf(a[this.E.a].forum_id));
            }
        }
    }
}
