package com.baidu.tieba.flist;

import android.app.Activity;
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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.aq;
import com.baidu.tieba.util.ao;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ForumListActivity extends com.baidu.tieba.g implements bq {
    private p A;
    private p B;
    private c C;
    private t D;

    /* renamed from: a  reason: collision with root package name */
    public ForumListModel.List f1036a;
    public ForumListModel.List b;
    public w c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int j;
    private int k;
    private int l;
    private int m;
    private ForumListModel.RequestParams x;
    private int n = 10;
    private int o = 10;
    private int p = -1;
    private aq q = new aq();
    private boolean r = false;
    private int s = 0;
    private boolean t = false;
    private int u = 0;
    private int v = 10;
    private boolean w = true;
    private boolean y = false;
    private boolean z = false;
    private u E = new f(this);
    private e F = new g(this);
    private AdapterView.OnItemClickListener G = new h(this);
    private com.baidu.adp.widget.ListView.b H = new i(this);

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(context, ForumListActivity.class);
        intent.putExtra("menu_name", str);
        intent.putExtra("menu_id", str2);
        intent.putExtra("menu_type", str3);
        intent.putExtra("parent_menu_name", str4);
        intent.putExtra("parent_menu_id", str5);
        context.startActivity(intent);
    }

    public static void a(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, ForumListActivity.class);
        intent.putExtra("parent_menu_name", str);
        intent.putExtra("menu_type", str2);
        intent.putExtra("parent_menu_id", str3);
        activity.startActivity(intent);
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forum_list_activity);
        this.c = new w(this);
        this.c.h = (BdListView) b();
        this.c.i = (BdListView) d();
        this.c.c.setAdapter(new m(this));
        this.c.g.setText(getIntent().getStringExtra("parent_menu_name"));
        this.A = new p(this);
        this.c.h.setAdapter((ListAdapter) this.A);
        this.B = new p(this);
        this.c.i.setAdapter((ListAdapter) this.B);
        this.c.y.setOnClickListener(this);
        this.x = new ForumListModel.RequestParams();
        try {
            this.x.menu_id = Integer.valueOf(getIntent().getStringExtra("parent_menu_id")).intValue();
            this.x.menu_name = getIntent().getStringExtra("parent_menu_name");
            this.x.menu_type = Integer.valueOf(getIntent().getStringExtra("menu_type")).intValue();
            this.x.parent_menu_id = Integer.valueOf(getIntent().getStringExtra("parent_menu_id")).intValue();
            this.x.parent_menu_name = getIntent().getStringExtra("parent_menu_name");
            this.x.offset = 0;
            this.x.rn = 10;
            com.baidu.tieba.util.aq.e("ForumListActivity", "onCreate", this.x.toString());
        } catch (NullPointerException e) {
            finish();
        }
        if (this.x.menu_id != 0) {
            this.c.b();
            this.r = true;
            this.c.c.getAdapter().notifyDataSetChanged();
        } else {
            this.c.a();
        }
        this.f1036a = new ForumListModel.List();
        this.b = new ForumListModel.List();
        this.f1036a.forum_list = new ForumListModel.Forum[50];
        this.b.forum_list = new ForumListModel.Forum[50];
        this.c.h.setPullRefresh(this.c.r);
        this.c.i.setPullRefresh(this.c.s);
        this.c.r.a(this.H);
        this.c.s.a(this.H);
        this.c.h.addFooterView(this.c.l);
        this.c.i.addFooterView(this.c.o);
        if (getIntent().getStringExtra("menu_type").equals("2")) {
            com.baidu.tieba.util.aq.e("ForumListActivity", "OnCreate", "from frs");
            this.c.z.setVisibility(8);
            this.c.d();
        } else {
            this.C = new c(this, getIntent().getStringExtra("parent_menu_name"), getIntent().getStringExtra("menu_type"), getIntent().getStringExtra("parent_menu_id"));
            this.C.a(this.F);
            this.C.LoadData();
            this.c.y.setOnClickListener(this);
        }
        this.D = new t(this, this.x);
        this.D.a(this.E);
        this.c.h.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.A != null) {
            this.A.b();
            this.A.notifyDataSetChanged();
        }
        if (this.B != null) {
            this.B.b();
            this.B.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.q != null) {
            this.q.a();
        }
        this.c.c.setAdapter(null);
        this.c.i.setAdapter((ListAdapter) null);
        this.c.h.setAdapter((ListAdapter) null);
        if (this.c.w != null) {
            this.c.w.setAdapter((ListAdapter) null);
        }
        if (this.C != null) {
            this.C.cancelLoadData();
        }
        if (this.D != null) {
            this.D.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        ao.d(this.c.e, i);
        ao.a(this.c.f, i);
        ao.f(this.c.g, i);
        ao.b(findViewById(R.id.container), i);
        if (TiebaApplication.g().an() == 1) {
            this.c.h.setDivider(new ColorDrawable(-13881543));
            this.c.i.setDivider(new ColorDrawable(-13881543));
        } else {
            this.c.h.setDivider(new ColorDrawable(-1775893));
            this.c.i.setDivider(new ColorDrawable(-1775893));
        }
        this.c.h.setDividerHeight(2);
        this.c.i.setDividerHeight(2);
        this.A.notifyDataSetChanged();
        this.B.notifyDataSetChanged();
        if (i == 1) {
            if (this.c.t != null) {
                this.c.t.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_allsproutpop_dropdown_1));
            }
            this.c.z.setImageResource(R.drawable.btn_allsproutpop_down_1);
            this.c.d.setBackgroundResource(R.drawable.bg_up_bar_1);
            this.d = getResources().getColor(R.color.flist_text_color_night);
            this.e = getResources().getColor(R.color.forum_list_tab_text_select);
            this.f = R.drawable.btn_pop_most_left_n_1;
            this.g = R.drawable.btn_pop_most_right_n_1;
            this.j = R.drawable.btn_pop_most_left_s_1;
            this.k = R.drawable.btn_pop_most_right_s_1;
            this.l = R.drawable.ico_downward_1;
            this.m = R.drawable.ico_upward_1;
            this.A.a(R.drawable.btn_add_end_1, R.drawable.btn_add_1);
            this.B.a(R.drawable.btn_add_end_1, R.drawable.btn_add_1);
            this.c.j.setTextColor(this.d);
            this.c.k.setTextColor(this.d);
            this.c.b.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            this.c.p.setTextColor(getResources().getColor(R.color.flist_text_color_night));
            this.c.f1057a.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            this.c.m.setTextColor(getResources().getColor(R.color.flist_text_color_night));
            if (this.c.r != null && this.c.s != null) {
                this.c.r.a(i);
                this.c.s.a(i);
            }
            if (this.y) {
                this.c.n.setImageResource(R.drawable.ico_upward_1);
            } else {
                this.c.n.setImageResource(R.drawable.ico_downward_1);
            }
            if (this.z) {
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
            this.d = getResources().getColor(R.color.flist_text_color_day);
            this.e = getResources().getColor(R.color.forum_list_tab_text_select);
            this.f = R.drawable.btn_pop_most_left_n;
            this.g = R.drawable.btn_pop_most_right_n;
            this.j = R.drawable.btn_pop_most_left_s;
            this.k = R.drawable.btn_pop_most_right_s;
            this.l = R.drawable.ico_downward;
            this.m = R.drawable.ico_upward;
            this.A.a(R.drawable.btn_add_end, R.drawable.btn_add);
            this.B.a(R.drawable.btn_add_end, R.drawable.btn_add);
            this.c.b.setBackgroundResource(R.drawable.bg_black_banner_down);
            this.c.p.setTextColor(getResources().getColor(R.color.flist_text_color_day));
            this.c.f1057a.setBackgroundResource(R.drawable.bg_black_banner_down);
            this.c.m.setTextColor(getResources().getColor(R.color.flist_text_color_day));
            if (this.y) {
                this.c.n.setImageResource(R.drawable.ico_upward);
            } else {
                this.c.n.setImageResource(R.drawable.ico_downward);
            }
            if (this.z) {
                this.c.q.setImageResource(R.drawable.ico_upward);
            } else {
                this.c.q.setImageResource(R.drawable.ico_downward);
            }
        }
        if (this.c.c.getCurrentItem() == 0) {
            this.c.j.setTextColor(this.e);
            this.c.j.setBackgroundResource(this.j);
            this.c.k.setBackgroundResource(this.g);
            this.c.k.setTextColor(this.d);
            return;
        }
        this.c.k.setTextColor(this.e);
        this.c.k.setBackgroundResource(this.k);
        this.c.j.setBackgroundResource(this.f);
        this.c.j.setTextColor(this.d);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back /* 2131099689 */:
                finish();
                return;
            case R.id.title_menu /* 2131100036 */:
                this.c.a(this.G);
                return;
            case R.id.tab_recommends /* 2131100040 */:
                this.c.c.setCurrentItem(0);
                this.p = 0;
                return;
            case R.id.tab_hot /* 2131100041 */:
                this.c.c.setCurrentItem(1);
                this.p = 1;
                return;
            default:
                return;
        }
    }

    private View b() {
        this.c.h = l();
        this.c.l.setOnClickListener(new j(this));
        return this.c.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.y) {
            int min = Math.min(this.A.getCount(), 10);
            this.n = 10;
            ForumListModel.Forum[] forumArr = new ForumListModel.Forum[min];
            System.arraycopy(this.A.a(), 0, forumArr, 0, min);
            this.A.a(min);
            this.A.a(forumArr);
            this.y = false;
            this.c.m.setText(getString(R.string.flist_expand_list));
            this.c.n.setImageResource(this.l);
            return;
        }
        this.n = 50;
        o oVar = new o(this, null);
        oVar.a(true);
        oVar.execute(new Void[0]);
    }

    private View d() {
        this.c.i = l();
        this.c.o.setOnClickListener(new k(this));
        return this.c.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.z) {
            int min = Math.min(this.B.getCount(), 10);
            this.o = 10;
            ForumListModel.Forum[] forumArr = new ForumListModel.Forum[min];
            System.arraycopy(this.B.a(), 0, forumArr, 0, min);
            this.B.a(min);
            this.B.a(forumArr);
            this.z = false;
            this.c.p.setText(getString(R.string.flist_expand_list));
            this.c.q.setImageResource(this.l);
            return;
        }
        this.o = 50;
        n nVar = new n(this, null);
        nVar.a(true);
        nVar.execute(new Void[0]);
    }

    private BdListView l() {
        BdListView bdListView = new BdListView(this);
        bdListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        bdListView.setCacheColorHint(0);
        bdListView.setSelector(17170445);
        if (TiebaApplication.g().an() == 1) {
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
    public void a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        if (!this.r) {
            if (i == 0) {
                this.c.j.setBackgroundResource(this.j);
                this.c.j.setTextColor(this.e);
                this.c.k.setBackgroundResource(this.g);
                this.c.k.setTextColor(this.d);
            } else if (i == 1) {
                this.c.k.setBackgroundResource(this.k);
                this.c.k.setTextColor(this.e);
                this.c.j.setBackgroundResource(this.f);
                this.c.j.setTextColor(this.d);
            }
        }
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        ForumListModel.Forum[] a2;
        if (i == 11002 && i2 == -1) {
            if (this.p == 0) {
                a2 = this.A.a();
            } else if (this.p == 1) {
                a2 = this.B.a();
            } else {
                return;
            }
            this.q.setLoadDataCallBack(new l(this, a2));
            this.q.a(a2[this.A.f1051a].forum_name, String.valueOf(a2[this.A.f1051a].forum_id));
        }
    }
}
