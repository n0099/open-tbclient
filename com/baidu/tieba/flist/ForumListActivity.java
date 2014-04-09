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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.flist.ForumListModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ForumListActivity extends com.baidu.tbadk.a implements ViewPager.OnPageChangeListener {
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
    private final com.baidu.tieba.model.af q = new com.baidu.tieba.model.af();
    private com.baidu.tbadk.editortool.ab r = null;
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
    private final u H = new f(this);
    private final e I = new g(this);
    private final AdapterView.OnItemClickListener J = new h(this);
    private final com.baidu.adp.widget.ListView.d K = new i(this);
    private final Runnable P = new j(this);
    private final AbsListView.OnScrollListener Q = new k(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ForumListActivity forumListActivity, String str) {
        com.baidu.tieba.square.ab a = forumListActivity.c.y.a();
        if (a != null) {
            ArrayList<com.baidu.tieba.square.ab> arrayList = a.e;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).b.equals(str)) {
                    forumListActivity.t = i;
                    forumListActivity.c.y.a(forumListActivity.t);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ForumListActivity forumListActivity, String str, String str2, String str3) {
        try {
            forumListActivity.A.menu_id = Integer.valueOf(str2).intValue();
            forumListActivity.A.menu_name = str;
            forumListActivity.A.menu_type = Integer.valueOf(str3).intValue();
            forumListActivity.A.parent_menu_id = Integer.valueOf(forumListActivity.getIntent().getStringExtra("parent_menu_id")).intValue();
            forumListActivity.A.parent_menu_name = forumListActivity.getIntent().getStringExtra("parent_menu_name");
            forumListActivity.A.offset = 0;
            forumListActivity.A.rn = 10;
            com.baidu.adp.lib.util.f.e("ForumListActivity", "onCreate", forumListActivity.A.toString());
        } catch (NullPointerException e) {
            forumListActivity.finish();
        }
        forumListActivity.v = forumListActivity.A.recommend_type;
        forumListActivity.w = forumListActivity.A.rn;
        forumListActivity.A.recommend_type = 0;
        forumListActivity.A.rn = 200;
        forumListActivity.u = true;
        forumListActivity.G.a(forumListActivity.A);
        forumListActivity.G.LoadData();
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

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.forum_list_activity);
        this.c = new w(this);
        w wVar = this.c;
        this.c.i = a();
        this.c.m.setOnClickListener(new l(this));
        wVar.i = this.c.i;
        w wVar2 = this.c;
        this.c.j = a();
        this.c.p.setOnClickListener(new m(this));
        wVar2.j = this.c.j;
        this.c.B.setVisibility(0);
        this.c.z.setOnClickListener(null);
        this.c.z.setClickable(false);
        this.c.d.setAdapter(new o(this));
        this.D = new r(this, 0);
        this.c.i.setAdapter((ListAdapter) this.D);
        this.E = new r(this, 1);
        this.c.j.setAdapter((ListAdapter) this.E);
        String stringExtra = getIntent().getStringExtra("parent_menu_name");
        String stringExtra2 = getIntent().getStringExtra("level_2_menu_name");
        String stringExtra3 = getIntent().getStringExtra("parent_menu_id");
        String stringExtra4 = getIntent().getStringExtra("menu_type");
        this.e = new Handler();
        if (bc.c(stringExtra2)) {
            stringExtra2 = stringExtra;
        }
        this.c.h.setText(stringExtra2);
        this.r = new com.baidu.tbadk.editortool.ab(this);
        this.A = new ForumListModel.RequestParams();
        try {
            this.A.menu_id = Integer.valueOf(stringExtra3).intValue();
            this.A.menu_name = stringExtra2;
            this.A.menu_type = Integer.valueOf(stringExtra4).intValue();
            this.A.parent_menu_id = Integer.valueOf(stringExtra3).intValue();
            this.A.parent_menu_name = stringExtra;
            this.A.offset = 0;
            this.A.rn = 10;
            com.baidu.adp.lib.util.f.e("ForumListActivity", "onCreate", this.A.toString());
        } catch (NullPointerException e) {
            finish();
        }
        if (this.A.menu_id != 0) {
            this.c.e.setVisibility(8);
            this.s = true;
            this.y = false;
            this.D.a(Boolean.valueOf(this.y));
            this.c.d.getAdapter().notifyDataSetChanged();
        } else {
            this.y = true;
            this.D.a(Boolean.valueOf(this.y));
            this.c.e.setVisibility(0);
        }
        this.a = new ForumListModel.List();
        this.b = new ForumListModel.List();
        this.a.forum_list = new ForumInfoData[50];
        this.b.forum_list = new ForumInfoData[50];
        this.c.i.setPullRefresh(this.c.s);
        this.c.j.setPullRefresh(this.c.t);
        this.c.s.a(this.K);
        this.c.t.a(this.K);
        if (stringExtra4.equals("2")) {
            com.baidu.adp.lib.util.f.e("ForumListActivity", "OnCreate", "from frs");
            this.c.A.setVisibility(8);
            this.c.b();
        } else {
            this.F = new c(stringExtra, stringExtra4, stringExtra3);
            this.F.a(this.I);
            this.F.LoadData();
        }
        this.G = new t(this, this.A);
        this.G.a(this.H);
        this.c.i.c();
    }

    public static void a(String str, String str2, String str3, String str4) {
        L = str;
        M = str2;
        N = str3;
        O = str4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        if (d) {
            d = false;
            finish();
            a(this, L, N, M, O);
            return;
        }
        String E = TbadkApplication.E();
        if (E != null && E.length() > 0) {
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
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        this.e.removeCallbacks(this.P);
        this.r.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.q != null) {
            this.q.a();
        }
        this.c.d.setAdapter(null);
        this.c.j.setAdapter((ListAdapter) null);
        this.c.i.setAdapter((ListAdapter) null);
        if (this.c.x != null) {
            this.c.x.setAdapter((ListAdapter) null);
        }
        if (this.F != null) {
            this.F.cancelLoadData();
        }
        if (this.G != null) {
            this.G.cancelLoadData();
        }
        this.e.removeCallbacks(this.P);
        this.r.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.c.a);
        this.c.f.b(i);
        if (TbadkApplication.j().l() == 1) {
            this.D.a(true);
            this.E.a(true);
        } else {
            this.D.a(false);
            this.E.a(false);
        }
        this.D.notifyDataSetChanged();
        this.E.notifyDataSetChanged();
        if (i == 1) {
            if (this.c.u != null) {
                this.c.u.setBackgroundDrawable(getResources().getDrawable(com.baidu.tieba.a.g.bg_allsproutpop_dropdown_1));
            }
            this.c.A.setImageResource(com.baidu.tieba.a.g.btn_allsproutpop_down_1);
            this.c.e.setBackgroundResource(com.baidu.tieba.a.g.bg_up_bar_1);
            this.f = getResources().getColor(com.baidu.tieba.a.e.flist_text_color_night);
            this.g = getResources().getColor(com.baidu.tieba.a.e.forum_list_tab_text_select);
            this.h = com.baidu.tieba.a.g.btn_pop_most_left_n_1;
            this.i = com.baidu.tieba.a.g.btn_pop_most_right_n_1;
            this.j = com.baidu.tieba.a.g.btn_pop_most_left_s_1;
            this.k = com.baidu.tieba.a.g.btn_pop_most_right_s_1;
            this.l = com.baidu.tieba.a.g.ico_downward_1;
            this.m = com.baidu.tieba.a.g.ico_upward_1;
            this.D.a(com.baidu.tieba.a.g.btn_add_end_1, com.baidu.tieba.a.g.btn_add_1);
            this.E.a(com.baidu.tieba.a.g.btn_add_end_1, com.baidu.tieba.a.g.btn_add_1);
            this.c.k.setTextColor(this.f);
            this.c.l.setTextColor(this.f);
            this.c.c.setBackgroundResource(com.baidu.tieba.a.g.bg_black_banner_down_1);
            this.c.q.setTextColor(getResources().getColor(com.baidu.tieba.a.e.flist_text_color_night));
            this.c.b.setBackgroundResource(com.baidu.tieba.a.g.bg_black_banner_down_1);
            this.c.n.setTextColor(getResources().getColor(com.baidu.tieba.a.e.flist_text_color_night));
            if (this.c.s != null && this.c.t != null) {
                this.c.s.a(i);
                this.c.t.a(i);
            }
            if (this.B) {
                this.c.o.setImageResource(com.baidu.tieba.a.g.ico_upward_1);
            } else {
                this.c.o.setImageResource(com.baidu.tieba.a.g.ico_downward_1);
            }
            if (this.C) {
                this.c.r.setImageResource(com.baidu.tieba.a.g.ico_upward_1);
            } else {
                this.c.r.setImageResource(com.baidu.tieba.a.g.ico_downward_1);
            }
        } else {
            if (this.c.u != null) {
                this.c.u.setBackgroundDrawable(getResources().getDrawable(com.baidu.tieba.a.g.bg_allsproutpop_dropdown_1));
            }
            this.c.A.setImageResource(com.baidu.tieba.a.g.btn_allsproutpop_down);
            this.c.e.setBackgroundResource(com.baidu.tieba.a.g.bg_pop_most);
            this.f = getResources().getColor(com.baidu.tieba.a.e.flist_text_color_day);
            this.g = getResources().getColor(com.baidu.tieba.a.e.forum_list_tab_text_select);
            this.h = com.baidu.tieba.a.g.btn_pop_most_left_n;
            this.i = com.baidu.tieba.a.g.btn_pop_most_right_n;
            this.j = com.baidu.tieba.a.g.btn_pop_most_left_s;
            this.k = com.baidu.tieba.a.g.btn_pop_most_right_s;
            this.l = com.baidu.tieba.a.g.ico_downward;
            this.m = com.baidu.tieba.a.g.ico_upward;
            this.D.a(com.baidu.tieba.a.g.btn_add_end, com.baidu.tieba.a.g.btn_add);
            this.E.a(com.baidu.tieba.a.g.btn_add_end, com.baidu.tieba.a.g.btn_add);
            this.c.c.setBackgroundResource(com.baidu.tieba.a.g.bg_black_banner_down);
            this.c.q.setTextColor(getResources().getColor(com.baidu.tieba.a.e.flist_text_color_day));
            this.c.b.setBackgroundResource(com.baidu.tieba.a.g.bg_black_banner_down);
            this.c.n.setTextColor(getResources().getColor(com.baidu.tieba.a.e.flist_text_color_day));
            if (this.B) {
                this.c.o.setImageResource(com.baidu.tieba.a.g.ico_upward);
            } else {
                this.c.o.setImageResource(com.baidu.tieba.a.g.ico_downward);
            }
            if (this.C) {
                this.c.r.setImageResource(com.baidu.tieba.a.g.ico_upward);
            } else {
                this.c.r.setImageResource(com.baidu.tieba.a.g.ico_downward);
            }
        }
        if (this.c.d.getCurrentItem() == 0) {
            this.c.k.setTextColor(this.g);
            this.c.k.setBackgroundResource(this.j);
            this.c.l.setBackgroundResource(this.i);
            this.c.l.setTextColor(this.f);
            return;
        }
        this.c.l.setTextColor(this.g);
        this.c.l.setBackgroundResource(this.k);
        this.c.k.setBackgroundResource(this.h);
        this.c.k.setTextColor(this.f);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.a.h.tab_recommends) {
            this.c.d.setCurrentItem(0);
            this.p = 0;
            TiebaStatic.a(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == com.baidu.tieba.a.h.tab_hot) {
            this.c.d.setCurrentItem(1);
            this.p = 1;
            TiebaStatic.a(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == com.baidu.tieba.a.h.title_menu) {
            this.c.a(this.J);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void v(ForumListActivity forumListActivity) {
        if (!forumListActivity.B) {
            forumListActivity.n = 50;
            q qVar = new q(forumListActivity, (byte) 0);
            qVar.a(true);
            qVar.execute(new Void[0]);
            return;
        }
        int min = Math.min(forumListActivity.D.getCount(), 200);
        forumListActivity.n = 200;
        ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
        System.arraycopy(forumListActivity.D.a(), 0, forumInfoDataArr, 0, min);
        forumListActivity.D.a(min);
        forumListActivity.D.a(forumInfoDataArr);
        forumListActivity.B = false;
        forumListActivity.c.n.setText(forumListActivity.getString(com.baidu.tieba.a.k.flist_expand_list));
        forumListActivity.c.o.setImageResource(forumListActivity.l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void w(ForumListActivity forumListActivity) {
        if (!forumListActivity.C) {
            forumListActivity.o = 50;
            p pVar = new p(forumListActivity, (byte) 0);
            pVar.a(true);
            pVar.execute(new Void[0]);
            return;
        }
        int min = Math.min(forumListActivity.E.getCount(), 200);
        forumListActivity.o = 200;
        ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
        System.arraycopy(forumListActivity.E.a(), 0, forumInfoDataArr, 0, min);
        forumListActivity.E.a(min);
        forumListActivity.E.a(forumInfoDataArr);
        forumListActivity.C = false;
        forumListActivity.c.q.setText(forumListActivity.getString(com.baidu.tieba.a.k.flist_expand_list));
        forumListActivity.c.r.setImageResource(forumListActivity.l);
    }

    private BdListView a() {
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
                this.c.k.setBackgroundResource(this.j);
                this.c.k.setTextColor(this.g);
                this.c.l.setBackgroundResource(this.i);
                this.c.l.setTextColor(this.f);
            } else if (i == 1) {
                this.E.b();
                this.E.notifyDataSetChanged();
                this.c.l.setBackgroundResource(this.k);
                this.c.l.setTextColor(this.g);
                this.c.k.setBackgroundResource(this.h);
                this.c.k.setTextColor(this.f);
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
