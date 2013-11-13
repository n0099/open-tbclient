package com.baidu.tieba.flist;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.bq;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.model.ax;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.bg;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ForumListActivity extends com.baidu.tieba.j implements bq {
    private ForumListModel.RequestParams A;
    private s D;
    private s E;
    private c F;
    private u G;

    /* renamed from: a  reason: collision with root package name */
    public ForumListModel.List f1232a;
    public ForumListModel.List b;
    public y c;
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
    private ax q = new ax();
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
    private w H = new g(this);
    private f I = new h(this);
    private AdapterView.OnItemClickListener J = new i(this);
    private com.baidu.adp.widget.ListView.b K = new j(this);
    private Runnable P = new n(this);
    private AbsListView.OnScrollListener Q = new o(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.baidu.tieba.square.z a2 = this.c.w.a();
        if (a2 != null) {
            ArrayList<com.baidu.tieba.square.z> arrayList = a2.e;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).b.equals(str)) {
                    this.t = i;
                    this.c.w.a(this.t);
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
            bg.e("ForumListActivity", "onCreate", this.A.toString());
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

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forum_list_activity);
        this.c = new y(this);
        this.c.g = (BdListView) a();
        this.c.h = (BdListView) c();
        this.c.z.setVisibility(0);
        this.c.x.setOnClickListener(this);
        this.c.c.setAdapter(new p(this));
        this.D = new s(this, 0);
        this.c.g.setAdapter((ListAdapter) this.D);
        this.E = new s(this, 1);
        this.c.h.setAdapter((ListAdapter) this.E);
        b(getIntent().getStringExtra("parent_menu_name"), getIntent().getStringExtra("parent_menu_id"), getIntent().getStringExtra("menu_type"), getIntent().getStringExtra("level_2_menu_name"));
    }

    private void b(String str, String str2, String str3, String str4) {
        this.e = new Handler();
        if (be.c(str4)) {
            str4 = str;
        }
        this.c.f.setText(str4);
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
            bg.e("ForumListActivity", "onCreate", this.A.toString());
        } catch (NullPointerException e) {
            finish();
        }
        if (this.A.menu_id != 0) {
            this.c.b();
            this.s = true;
            this.y = false;
            this.D.a(Boolean.valueOf(this.y));
            this.c.c.getAdapter().notifyDataSetChanged();
        } else {
            this.y = true;
            this.D.a(Boolean.valueOf(this.y));
            this.c.a();
        }
        this.f1232a = new ForumListModel.List();
        this.b = new ForumListModel.List();
        this.f1232a.forum_list = new ForumInfoData[50];
        this.b.forum_list = new ForumInfoData[50];
        this.c.g.setPullRefresh(this.c.q);
        this.c.h.setPullRefresh(this.c.r);
        this.c.q.a(this.K);
        this.c.r.a(this.K);
        if (str3.equals("2")) {
            bg.e("ForumListActivity", "OnCreate", "from frs");
            this.c.y.setVisibility(8);
            this.c.d();
        } else {
            this.F = new c(this, str, str3, str2);
            this.F.a(this.I);
            this.F.LoadData();
            this.c.x.setOnClickListener(this);
        }
        this.G = new u(this, this.A);
        this.G.a(this.H);
        this.c.g.b();
    }

    public static void a(String str, String str2, String str3, String str4) {
        L = str;
        M = str2;
        N = str3;
        O = str4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
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
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.e.removeCallbacks(this.P);
        this.r.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.q != null) {
            this.q.a();
        }
        this.c.c.setAdapter(null);
        this.c.h.setAdapter((ListAdapter) null);
        this.c.g.setAdapter((ListAdapter) null);
        if (this.c.v != null) {
            this.c.v.setAdapter((ListAdapter) null);
        }
        if (this.F != null) {
            this.F.cancelLoadData();
        }
        if (this.G != null) {
            this.G.cancelLoadData();
        }
        this.e.removeCallbacks(this.P);
        this.r.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        bd.b(findViewById(R.id.forum_list_root), i);
        this.c.e.c(i);
        if (TiebaApplication.g().ap() == 1) {
            this.c.g.setDivider(new ColorDrawable(-13881543));
            this.c.h.setDivider(new ColorDrawable(-13881543));
        } else {
            this.c.g.setDivider(new ColorDrawable(-1775893));
            this.c.h.setDivider(new ColorDrawable(-1775893));
        }
        this.c.g.setDividerHeight(2);
        this.c.h.setDividerHeight(2);
        this.D.notifyDataSetChanged();
        this.E.notifyDataSetChanged();
        if (i == 1) {
            if (this.c.s != null) {
                this.c.s.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_allsproutpop_dropdown_1));
            }
            this.c.y.setImageResource(R.drawable.btn_allsproutpop_down_1);
            this.c.d.setBackgroundResource(R.drawable.bg_up_bar_1);
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
            this.c.i.setTextColor(this.f);
            this.c.j.setTextColor(this.f);
            this.c.b.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            this.c.o.setTextColor(getResources().getColor(R.color.flist_text_color_night));
            this.c.f1265a.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            this.c.l.setTextColor(getResources().getColor(R.color.flist_text_color_night));
            if (this.c.q != null && this.c.r != null) {
                this.c.q.a(i);
                this.c.r.a(i);
            }
            if (this.B) {
                this.c.m.setImageResource(R.drawable.ico_upward_1);
            } else {
                this.c.m.setImageResource(R.drawable.ico_downward_1);
            }
            if (this.C) {
                this.c.p.setImageResource(R.drawable.ico_upward_1);
            } else {
                this.c.p.setImageResource(R.drawable.ico_downward_1);
            }
        } else {
            if (this.c.s != null) {
                this.c.s.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_allsproutpop_dropdown_1));
            }
            this.c.y.setImageResource(R.drawable.btn_allsproutpop_down);
            this.c.d.setBackgroundResource(R.drawable.bg_pop_most);
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
            this.c.b.setBackgroundResource(R.drawable.bg_black_banner_down);
            this.c.o.setTextColor(getResources().getColor(R.color.flist_text_color_day));
            this.c.f1265a.setBackgroundResource(R.drawable.bg_black_banner_down);
            this.c.l.setTextColor(getResources().getColor(R.color.flist_text_color_day));
            if (this.B) {
                this.c.m.setImageResource(R.drawable.ico_upward);
            } else {
                this.c.m.setImageResource(R.drawable.ico_downward);
            }
            if (this.C) {
                this.c.p.setImageResource(R.drawable.ico_upward);
            } else {
                this.c.p.setImageResource(R.drawable.ico_downward);
            }
        }
        if (this.c.c.getCurrentItem() == 0) {
            this.c.i.setTextColor(this.g);
            this.c.i.setBackgroundResource(this.j);
            this.c.j.setBackgroundResource(this.i);
            this.c.j.setTextColor(this.f);
            return;
        }
        this.c.j.setTextColor(this.g);
        this.c.j.setBackgroundResource(this.k);
        this.c.i.setBackgroundResource(this.h);
        this.c.i.setTextColor(this.f);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_recommends /* 2131100128 */:
                this.c.c.setCurrentItem(0);
                this.p = 0;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(view.getContext(), "recommend_list_click", "click", 1);
                    return;
                }
                return;
            case R.id.tab_hot /* 2131100129 */:
                this.c.c.setCurrentItem(1);
                this.p = 1;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(view.getContext(), "hot_list_click", "click", 1);
                    return;
                }
                return;
            case R.id.title_menu /* 2131100605 */:
                this.c.a(this.J);
                return;
            default:
                return;
        }
    }

    private View a() {
        this.c.g = e();
        this.c.k.setOnClickListener(new k(this));
        return this.c.g;
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
            this.c.l.setText(getString(R.string.flist_expand_list));
            this.c.m.setImageResource(this.l);
            return;
        }
        this.n = 50;
        r rVar = new r(this, null);
        rVar.a(true);
        rVar.execute(new Void[0]);
    }

    private View c() {
        this.c.h = e();
        this.c.n.setOnClickListener(new l(this));
        return this.c.h;
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
            this.c.o.setText(getString(R.string.flist_expand_list));
            this.c.p.setImageResource(this.l);
            return;
        }
        this.o = 50;
        q qVar = new q(this, null);
        qVar.a(true);
        qVar.execute(new Void[0]);
    }

    private BdListView e() {
        BdListView bdListView = new BdListView(this);
        bdListView.setScrollingCacheEnabled(false);
        bdListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        bdListView.setCacheColorHint(0);
        bdListView.setSelector(17170445);
        if (TiebaApplication.g().ap() == 1) {
            bdListView.setDivider(new ColorDrawable(-13881543));
        } else {
            bdListView.setDivider(new ColorDrawable(-1775893));
        }
        bdListView.setDividerHeight(2);
        bdListView.setFooterDividersEnabled(false);
        bdListView.setHorizontalFadingEdgeEnabled(false);
        bdListView.setVerticalFadingEdgeEnabled(false);
        bdListView.setOnScrollListener(this.Q);
        return bdListView;
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        this.z = i;
        if (!this.s) {
            if (i == 0) {
                this.D.b();
                this.D.notifyDataSetChanged();
                this.c.i.setBackgroundResource(this.j);
                this.c.i.setTextColor(this.g);
                this.c.j.setBackgroundResource(this.i);
                this.c.j.setTextColor(this.f);
            } else if (i == 1) {
                this.E.b();
                this.E.notifyDataSetChanged();
                this.c.j.setBackgroundResource(this.k);
                this.c.j.setTextColor(this.g);
                this.c.i.setBackgroundResource(this.h);
                this.c.i.setTextColor(this.f);
            }
            this.e.removeCallbacks(this.P);
            this.e.post(this.P);
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        ForumInfoData[] a2;
        if (i == 11002 && i2 == -1) {
            this.G.LoadData();
            if (this.p == 0) {
                a2 = this.D.a();
            } else {
                a2 = this.E.a();
            }
            this.q.setLoadDataCallBack(new m(this, a2));
            if (this.p == 0) {
                this.q.a(a2[this.D.f1261a].forum_name, String.valueOf(a2[this.D.f1261a].forum_id));
            } else {
                this.q.a(a2[this.E.f1261a].forum_name, String.valueOf(a2[this.E.f1261a].forum_id));
            }
        }
    }
}
