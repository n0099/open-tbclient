package com.baidu.tieba.flist;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.bq;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.ba;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ForumListActivity extends com.baidu.tieba.j implements bq {
    private q C;
    private q D;
    private c E;
    private t F;

    /* renamed from: a  reason: collision with root package name */
    public ForumListModel.List f1185a;
    public ForumListModel.List b;
    public x c;
    private int e;
    private int f;
    private int g;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private ForumListModel.RequestParams z;
    public static boolean d = false;
    private static String K = "";
    private static String L = "";
    private static String M = "";
    private static String N = "";
    private int o = 10;
    private int p = 10;
    private int q = -1;
    private ba r = new ba();
    private boolean s = false;
    private int t = 0;
    private boolean u = false;
    private int v = 0;
    private int w = 10;
    private boolean x = true;
    private boolean y = true;
    private boolean A = false;
    private boolean B = false;
    private v G = new g(this);
    private f H = new h(this);
    private AdapterView.OnItemClickListener I = new i(this);
    private com.baidu.adp.widget.ListView.b J = new j(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.baidu.tieba.square.s a2 = this.c.x.a();
        if (a2 != null) {
            ArrayList<com.baidu.tieba.square.s> arrayList = a2.e;
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
            this.z.menu_id = Integer.valueOf(str2).intValue();
            this.z.menu_name = str;
            this.z.menu_type = Integer.valueOf(str3).intValue();
            this.z.parent_menu_id = Integer.valueOf(getIntent().getStringExtra("parent_menu_id")).intValue();
            this.z.parent_menu_name = getIntent().getStringExtra("parent_menu_name");
            this.z.offset = 0;
            this.z.rn = 10;
            be.e("ForumListActivity", "onCreate", this.z.toString());
        } catch (NullPointerException e) {
            finish();
        }
        this.v = this.z.recommend_type;
        this.w = this.z.rn;
        this.z.recommend_type = 0;
        this.z.rn = 10;
        this.u = true;
        this.F.a(this.z);
        this.F.LoadData();
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
        this.c = new x(this);
        this.c.h = (BdListView) b();
        this.c.i = (BdListView) d();
        this.c.A.setVisibility(0);
        this.c.y.setOnClickListener(this);
        this.c.c.setAdapter(new n(this));
        this.C = new q(this, 0);
        this.c.h.setAdapter((ListAdapter) this.C);
        this.D = new q(this, 1);
        this.c.i.setAdapter((ListAdapter) this.D);
        this.c.h.addFooterView(this.c.l);
        this.c.i.addFooterView(this.c.o);
        b(getIntent().getStringExtra("parent_menu_name"), getIntent().getStringExtra("parent_menu_id"), getIntent().getStringExtra("menu_type"), getIntent().getStringExtra("level_2_menu_name"));
    }

    private void b(String str, String str2, String str3, String str4) {
        if (bc.c(str4)) {
            str4 = str;
        }
        this.c.g.setText(str4);
        this.z = new ForumListModel.RequestParams();
        try {
            this.z.menu_id = Integer.valueOf(str2).intValue();
            this.z.menu_name = str4;
            this.z.menu_type = Integer.valueOf(str3).intValue();
            this.z.parent_menu_id = Integer.valueOf(str2).intValue();
            this.z.parent_menu_name = str;
            this.z.offset = 0;
            this.z.rn = 10;
            be.e("ForumListActivity", "onCreate", this.z.toString());
        } catch (NullPointerException e) {
            finish();
        }
        if (this.z.menu_id != 0) {
            this.c.b();
            this.s = true;
            this.y = false;
            this.C.a(Boolean.valueOf(this.y));
            this.c.c.getAdapter().notifyDataSetChanged();
        } else {
            this.y = true;
            this.C.a(Boolean.valueOf(this.y));
            this.c.a();
        }
        this.f1185a = new ForumListModel.List();
        this.b = new ForumListModel.List();
        this.f1185a.forum_list = new ForumListModel.Forum[50];
        this.b.forum_list = new ForumListModel.Forum[50];
        this.c.h.setPullRefresh(this.c.r);
        this.c.i.setPullRefresh(this.c.s);
        this.c.r.a(this.J);
        this.c.s.a(this.J);
        if (str3.equals("2")) {
            be.e("ForumListActivity", "OnCreate", "from frs");
            this.c.z.setVisibility(8);
            this.c.d();
        } else {
            this.E = new c(this, str, str3, str2);
            this.E.a(this.H);
            this.E.LoadData();
            this.c.y.setOnClickListener(this);
        }
        this.F = new t(this, this.z);
        this.F.a(this.G);
        this.c.h.b();
    }

    public static void a(String str, String str2, String str3, String str4) {
        K = str;
        L = str2;
        M = str3;
        N = str4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (d) {
            d = false;
            finish();
            a(this, K, M, L, N);
            return;
        }
        if (this.C != null) {
            this.C.b();
            this.C.notifyDataSetChanged();
        }
        if (this.D != null) {
            this.D.b();
            this.D.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.r != null) {
            this.r.a();
        }
        this.c.c.setAdapter(null);
        this.c.i.setAdapter((ListAdapter) null);
        this.c.h.setAdapter((ListAdapter) null);
        if (this.c.w != null) {
            this.c.w.setAdapter((ListAdapter) null);
        }
        if (this.E != null) {
            this.E.cancelLoadData();
        }
        if (this.F != null) {
            this.F.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        bb.d(this.c.e, i);
        bb.a(this.c.f, i);
        bb.f(this.c.g, i);
        bb.b(findViewById(R.id.container), i);
        if (TiebaApplication.g().as() == 1) {
            this.c.h.setDivider(new ColorDrawable(-13881543));
            this.c.i.setDivider(new ColorDrawable(-13881543));
        } else {
            this.c.h.setDivider(new ColorDrawable(-1775893));
            this.c.i.setDivider(new ColorDrawable(-1775893));
        }
        this.c.h.setDividerHeight(2);
        this.c.i.setDividerHeight(2);
        this.C.notifyDataSetChanged();
        this.D.notifyDataSetChanged();
        if (i == 1) {
            if (this.c.t != null) {
                this.c.t.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_allsproutpop_dropdown_1));
            }
            this.c.z.setImageResource(R.drawable.btn_allsproutpop_down_1);
            this.c.d.setBackgroundResource(R.drawable.bg_up_bar_1);
            this.e = getResources().getColor(R.color.flist_text_color_night);
            this.f = getResources().getColor(R.color.forum_list_tab_text_select);
            this.g = R.drawable.btn_pop_most_left_n_1;
            this.j = R.drawable.btn_pop_most_right_n_1;
            this.k = R.drawable.btn_pop_most_left_s_1;
            this.l = R.drawable.btn_pop_most_right_s_1;
            this.m = R.drawable.ico_downward_1;
            this.n = R.drawable.ico_upward_1;
            this.C.a(R.drawable.btn_add_end_1, R.drawable.btn_add_1);
            this.D.a(R.drawable.btn_add_end_1, R.drawable.btn_add_1);
            this.c.j.setTextColor(this.e);
            this.c.k.setTextColor(this.e);
            this.c.b.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            this.c.p.setTextColor(getResources().getColor(R.color.flist_text_color_night));
            this.c.f1206a.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            this.c.m.setTextColor(getResources().getColor(R.color.flist_text_color_night));
            if (this.c.r != null && this.c.s != null) {
                this.c.r.a(i);
                this.c.s.a(i);
            }
            if (this.A) {
                this.c.n.setImageResource(R.drawable.ico_upward_1);
            } else {
                this.c.n.setImageResource(R.drawable.ico_downward_1);
            }
            if (this.B) {
                this.c.q.setImageResource(R.drawable.ico_upward_1);
            } else {
                this.c.q.setImageResource(R.drawable.ico_downward_1);
            }
        } else {
            if (this.c.t != null) {
                this.c.t.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_allsproutpop_dropdown_1));
            }
            this.c.z.setImageResource(R.drawable.btn_allsproutpop_down);
            this.c.d.setBackgroundResource(R.drawable.bg_pop_most);
            this.e = getResources().getColor(R.color.flist_text_color_day);
            this.f = getResources().getColor(R.color.forum_list_tab_text_select);
            this.g = R.drawable.btn_pop_most_left_n;
            this.j = R.drawable.btn_pop_most_right_n;
            this.k = R.drawable.btn_pop_most_left_s;
            this.l = R.drawable.btn_pop_most_right_s;
            this.m = R.drawable.ico_downward;
            this.n = R.drawable.ico_upward;
            this.C.a(R.drawable.btn_add_end, R.drawable.btn_add);
            this.D.a(R.drawable.btn_add_end, R.drawable.btn_add);
            this.c.b.setBackgroundResource(R.drawable.bg_black_banner_down);
            this.c.p.setTextColor(getResources().getColor(R.color.flist_text_color_day));
            this.c.f1206a.setBackgroundResource(R.drawable.bg_black_banner_down);
            this.c.m.setTextColor(getResources().getColor(R.color.flist_text_color_day));
            if (this.A) {
                this.c.n.setImageResource(R.drawable.ico_upward);
            } else {
                this.c.n.setImageResource(R.drawable.ico_downward);
            }
            if (this.B) {
                this.c.q.setImageResource(R.drawable.ico_upward);
            } else {
                this.c.q.setImageResource(R.drawable.ico_downward);
            }
        }
        if (this.c.c.getCurrentItem() == 0) {
            this.c.j.setTextColor(this.f);
            this.c.j.setBackgroundResource(this.k);
            this.c.k.setBackgroundResource(this.j);
            this.c.k.setTextColor(this.e);
            return;
        }
        this.c.k.setTextColor(this.f);
        this.c.k.setBackgroundResource(this.l);
        this.c.j.setBackgroundResource(this.g);
        this.c.j.setTextColor(this.e);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back /* 2131100112 */:
                finish();
                return;
            case R.id.title_menu /* 2131100113 */:
                this.c.a(this.I);
                return;
            case R.id.title_arrow /* 2131100114 */:
            case R.id.item_root /* 2131100115 */:
            case R.id.tab_strip /* 2131100116 */:
            default:
                return;
            case R.id.tab_recommends /* 2131100117 */:
                this.c.c.setCurrentItem(0);
                this.q = 0;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(view.getContext(), "recommend_list_click", "click", 1);
                    return;
                }
                return;
            case R.id.tab_hot /* 2131100118 */:
                this.c.c.setCurrentItem(1);
                this.q = 1;
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(view.getContext(), "hot_list_click", "click", 1);
                    return;
                }
                return;
        }
    }

    private View b() {
        this.c.h = f();
        this.c.l.setOnClickListener(new k(this));
        return this.c.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.A) {
            int min = Math.min(this.C.getCount(), 10);
            this.o = 10;
            ForumListModel.Forum[] forumArr = new ForumListModel.Forum[min];
            System.arraycopy(this.C.a(), 0, forumArr, 0, min);
            this.C.a(min);
            this.C.a(forumArr);
            this.A = false;
            this.c.m.setText(getString(R.string.flist_expand_list));
            this.c.n.setImageResource(this.m);
            return;
        }
        this.o = 50;
        p pVar = new p(this, null);
        pVar.a(true);
        pVar.execute(new Void[0]);
    }

    private View d() {
        this.c.i = f();
        this.c.o.setOnClickListener(new l(this));
        return this.c.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.B) {
            int min = Math.min(this.D.getCount(), 10);
            this.p = 10;
            ForumListModel.Forum[] forumArr = new ForumListModel.Forum[min];
            System.arraycopy(this.D.a(), 0, forumArr, 0, min);
            this.D.a(min);
            this.D.a(forumArr);
            this.B = false;
            this.c.p.setText(getString(R.string.flist_expand_list));
            this.c.q.setImageResource(this.m);
            return;
        }
        this.p = 50;
        o oVar = new o(this, null);
        oVar.a(true);
        oVar.execute(new Void[0]);
    }

    private BdListView f() {
        BdListView bdListView = new BdListView(this);
        bdListView.setScrollingCacheEnabled(false);
        bdListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        bdListView.setCacheColorHint(0);
        bdListView.setSelector(17170445);
        if (TiebaApplication.g().as() == 1) {
            bdListView.setDivider(new ColorDrawable(-13881543));
        } else {
            bdListView.setDivider(new ColorDrawable(-1775893));
        }
        bdListView.setDividerHeight(2);
        bdListView.setFooterDividersEnabled(false);
        bdListView.setHorizontalFadingEdgeEnabled(false);
        bdListView.setVerticalFadingEdgeEnabled(false);
        return bdListView;
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        if (!this.s) {
            if (i == 0) {
                this.c.j.setBackgroundResource(this.k);
                this.c.j.setTextColor(this.f);
                this.c.k.setBackgroundResource(this.j);
                this.c.k.setTextColor(this.e);
            } else if (i == 1) {
                this.c.k.setBackgroundResource(this.l);
                this.c.k.setTextColor(this.f);
                this.c.j.setBackgroundResource(this.g);
                this.c.j.setTextColor(this.e);
            }
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        ForumListModel.Forum[] a2;
        if (i == 11002 && i2 == -1) {
            if (this.q == 0) {
                a2 = this.C.a();
            } else if (this.q == 1) {
                a2 = this.D.a();
            } else {
                return;
            }
            this.r.setLoadDataCallBack(new m(this, a2));
            this.r.a(a2[this.C.f1201a].forum_name, String.valueOf(a2[this.C.f1201a].forum_id));
        }
    }
}
