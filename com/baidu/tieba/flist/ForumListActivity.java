package com.baidu.tieba.flist;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.model.af;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ForumListActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private p A;
    private p B;
    private c C;
    private r D;
    public ForumListModel.List a;
    public ForumListModel.List b;
    public u c;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private ForumListModel.RequestParams x;
    public static boolean d = false;
    private static String I = "";
    private static String J = "";
    private static String K = "";
    private static String L = "";
    private int m = Constants.MEDIA_INFO;
    private int n = Constants.MEDIA_INFO;
    private int o = 0;
    private final af p = new af();
    private boolean q = false;
    private int r = 0;
    private boolean s = false;
    private int t = 0;
    private int u = Constants.MEDIA_INFO;
    private boolean v = true;
    private boolean w = true;
    private boolean y = false;
    private boolean z = false;
    private final s E = new f(this);
    private final e F = new g(this);
    private final AdapterView.OnItemClickListener G = new h(this);
    private final com.baidu.adp.widget.ListView.d H = new i(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.baidu.tieba.square.w a = this.c.y.a();
        if (a != null) {
            ArrayList<com.baidu.tieba.square.w> arrayList = a.e;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).b.equals(str)) {
                    this.r = i;
                    this.c.y.a(this.r);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        try {
            this.x.menu_id = Integer.valueOf(str2).intValue();
            this.x.menu_name = str;
            this.x.menu_type = Integer.valueOf(str3).intValue();
            this.x.parent_menu_id = Integer.valueOf(getIntent().getStringExtra("parent_menu_id")).intValue();
            this.x.parent_menu_name = getIntent().getStringExtra("parent_menu_name");
            this.x.offset = 0;
            this.x.rn = 10;
        } catch (NullPointerException e) {
            finish();
        }
        this.t = this.x.recommend_type;
        this.u = this.x.rn;
        this.x.recommend_type = 0;
        this.x.rn = Constants.MEDIA_INFO;
        this.s = true;
        this.D.a(this.x);
        this.D.LoadData();
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.v.forum_list_activity);
        this.c = new u(this);
        this.c.i = (BdListView) a();
        this.c.j = (BdListView) c();
        this.c.B.setVisibility(0);
        this.c.z.setOnClickListener(null);
        this.c.z.setClickable(false);
        this.c.d.setAdapter(new m(this));
        this.A = new p(this, 0);
        this.c.i.setAdapter((ListAdapter) this.A);
        this.B = new p(this, 1);
        this.c.j.setAdapter((ListAdapter) this.B);
        b(getIntent().getStringExtra("parent_menu_name"), getIntent().getStringExtra("parent_menu_id"), getIntent().getStringExtra("menu_type"), getIntent().getStringExtra("level_2_menu_name"));
    }

    private void b(String str, String str2, String str3, String str4) {
        if (ba.c(str4)) {
            str4 = str;
        }
        this.c.h.setText(str4);
        this.x = new ForumListModel.RequestParams();
        try {
            this.x.menu_id = Integer.valueOf(str2).intValue();
            this.x.menu_name = str4;
            this.x.menu_type = Integer.valueOf(str3).intValue();
            this.x.parent_menu_id = Integer.valueOf(str2).intValue();
            this.x.parent_menu_name = str;
            this.x.offset = 0;
            this.x.rn = 10;
        } catch (NullPointerException e) {
            finish();
        }
        if (this.x.menu_id != 0) {
            this.c.b();
            this.q = true;
            this.w = false;
            this.A.a(Boolean.valueOf(this.w));
            this.c.d.getAdapter().notifyDataSetChanged();
        } else {
            this.w = true;
            this.A.a(Boolean.valueOf(this.w));
            this.c.a();
        }
        this.a = new ForumListModel.List();
        this.b = new ForumListModel.List();
        this.a.forum_list = new ForumInfoData[50];
        this.b.forum_list = new ForumInfoData[50];
        this.c.i.setPullRefresh(this.c.s);
        this.c.j.setPullRefresh(this.c.t);
        this.c.s.a(this.H);
        this.c.t.a(this.H);
        if (str3.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
            this.c.A.setVisibility(8);
            this.c.d();
        } else {
            this.C = new c(this, str, str3, str2);
            this.C.a(this.F);
            this.C.LoadData();
        }
        this.D = new r(this, this.x);
        this.D.a(this.E);
        this.c.i.e();
    }

    public static void a(String str, String str2, String str3, String str4) {
        I = str;
        J = str2;
        K = str3;
        L = str4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (d) {
            d = false;
            finish();
            a(this, I, K, J, L);
            return;
        }
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.A != null) {
                this.A.b();
                this.A.notifyDataSetChanged();
            }
            if (this.B != null) {
                this.B.b();
                this.B.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.p != null) {
            this.p.a();
        }
        this.c.d.setAdapter(null);
        this.c.j.setAdapter((ListAdapter) null);
        this.c.i.setAdapter((ListAdapter) null);
        if (this.c.x != null) {
            this.c.x.setAdapter((ListAdapter) null);
        }
        if (this.C != null) {
            this.C.cancelLoadData();
        }
        if (this.D != null) {
            this.D.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().a(i == 1);
        getLayoutMode().a((View) this.c.a);
        this.c.f.c(i);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.A.a(true);
            this.B.a(true);
        } else {
            this.A.a(false);
            this.B.a(false);
        }
        this.A.notifyDataSetChanged();
        this.B.notifyDataSetChanged();
        if (i == 1) {
            if (this.c.u != null) {
                this.c.u.setBackgroundDrawable(getResources().getDrawable(com.baidu.tieba.t.bg_allsproutpop_dropdown_1));
            }
            this.c.A.setImageResource(com.baidu.tieba.t.btn_allsproutpop_down_1);
            this.c.e.setBackgroundResource(com.baidu.tieba.t.bg_up_bar_1);
            this.e = getResources().getColor(com.baidu.tieba.r.flist_text_color_night);
            this.f = getResources().getColor(com.baidu.tieba.r.forum_list_tab_text_select);
            this.g = com.baidu.tieba.t.btn_pop_most_left_n_1;
            this.h = com.baidu.tieba.t.btn_pop_most_right_n_1;
            this.i = com.baidu.tieba.t.btn_pop_most_left_s_1;
            this.j = com.baidu.tieba.t.btn_pop_most_right_s_1;
            this.k = com.baidu.tieba.t.ico_downward_1;
            this.l = com.baidu.tieba.t.ico_upward_1;
            this.A.a(com.baidu.tieba.t.btn_add_end_1, com.baidu.tieba.t.btn_add_1);
            this.B.a(com.baidu.tieba.t.btn_add_end_1, com.baidu.tieba.t.btn_add_1);
            this.c.k.setTextColor(this.e);
            this.c.l.setTextColor(this.e);
            this.c.c.setBackgroundResource(com.baidu.tieba.t.bg_black_banner_down_1);
            this.c.q.setTextColor(getResources().getColor(com.baidu.tieba.r.flist_text_color_night));
            this.c.b.setBackgroundResource(com.baidu.tieba.t.bg_black_banner_down_1);
            this.c.n.setTextColor(getResources().getColor(com.baidu.tieba.r.flist_text_color_night));
            if (this.c.s != null && this.c.t != null) {
                this.c.s.a(i);
                this.c.t.a(i);
            }
            if (this.y) {
                this.c.o.setImageResource(com.baidu.tieba.t.ico_upward_1);
            } else {
                this.c.o.setImageResource(com.baidu.tieba.t.ico_downward_1);
            }
            if (this.z) {
                this.c.r.setImageResource(com.baidu.tieba.t.ico_upward_1);
            } else {
                this.c.r.setImageResource(com.baidu.tieba.t.ico_downward_1);
            }
        } else {
            if (this.c.u != null) {
                this.c.u.setBackgroundDrawable(getResources().getDrawable(com.baidu.tieba.t.bg_allsproutpop_dropdown_1));
            }
            this.c.A.setImageResource(com.baidu.tieba.t.btn_allsproutpop_down);
            this.c.e.setBackgroundResource(com.baidu.tieba.t.bg_pop_most);
            this.e = getResources().getColor(com.baidu.tieba.r.flist_text_color_day);
            this.f = getResources().getColor(com.baidu.tieba.r.forum_list_tab_text_select);
            this.g = com.baidu.tieba.t.btn_pop_most_left_n;
            this.h = com.baidu.tieba.t.btn_pop_most_right_n;
            this.i = com.baidu.tieba.t.btn_pop_most_left_s;
            this.j = com.baidu.tieba.t.btn_pop_most_right_s;
            this.k = com.baidu.tieba.t.ico_downward;
            this.l = com.baidu.tieba.t.ico_upward;
            this.A.a(com.baidu.tieba.t.btn_add_end, com.baidu.tieba.t.btn_add);
            this.B.a(com.baidu.tieba.t.btn_add_end, com.baidu.tieba.t.btn_add);
            this.c.c.setBackgroundResource(com.baidu.tieba.t.bg_black_banner_down);
            this.c.q.setTextColor(getResources().getColor(com.baidu.tieba.r.flist_text_color_day));
            this.c.b.setBackgroundResource(com.baidu.tieba.t.bg_black_banner_down);
            this.c.n.setTextColor(getResources().getColor(com.baidu.tieba.r.flist_text_color_day));
            if (this.y) {
                this.c.o.setImageResource(com.baidu.tieba.t.ico_upward);
            } else {
                this.c.o.setImageResource(com.baidu.tieba.t.ico_downward);
            }
            if (this.z) {
                this.c.r.setImageResource(com.baidu.tieba.t.ico_upward);
            } else {
                this.c.r.setImageResource(com.baidu.tieba.t.ico_downward);
            }
        }
        if (this.c.d.getCurrentItem() == 0) {
            this.c.k.setTextColor(this.f);
            this.c.k.setBackgroundResource(this.i);
            this.c.l.setBackgroundResource(this.h);
            this.c.l.setTextColor(this.e);
            return;
        }
        this.c.l.setTextColor(this.f);
        this.c.l.setBackgroundResource(this.j);
        this.c.k.setBackgroundResource(this.g);
        this.c.k.setTextColor(this.e);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.u.tab_recommends) {
            this.c.d.setCurrentItem(0);
            this.o = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == com.baidu.tieba.u.tab_hot) {
            this.c.d.setCurrentItem(1);
            this.o = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == com.baidu.tieba.u.title_menu) {
            this.c.a(this.G);
        }
    }

    private View a() {
        this.c.i = e();
        this.c.m.setOnClickListener(new j(this));
        return this.c.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.y) {
            int min = Math.min(this.A.getCount(), (int) Constants.MEDIA_INFO);
            this.m = Constants.MEDIA_INFO;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.A.a(), 0, forumInfoDataArr, 0, min);
            this.A.a(min);
            this.A.a(forumInfoDataArr);
            this.y = false;
            this.c.n.setText(getString(com.baidu.tieba.x.flist_expand_list));
            this.c.o.setImageResource(this.k);
            return;
        }
        this.m = 50;
        o oVar = new o(this, null);
        oVar.a(true);
        oVar.execute(new Void[0]);
    }

    private View c() {
        this.c.j = e();
        this.c.p.setOnClickListener(new k(this));
        return this.c.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.z) {
            int min = Math.min(this.B.getCount(), (int) Constants.MEDIA_INFO);
            this.n = Constants.MEDIA_INFO;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.B.a(), 0, forumInfoDataArr, 0, min);
            this.B.a(min);
            this.B.a(forumInfoDataArr);
            this.z = false;
            this.c.q.setText(getString(com.baidu.tieba.x.flist_expand_list));
            this.c.r.setImageResource(this.k);
            return;
        }
        this.n = 50;
        n nVar = new n(this, null);
        nVar.a(true);
        nVar.execute(new Void[0]);
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
        return bdListView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (!this.q) {
            if (i == 0) {
                this.A.b();
                this.A.notifyDataSetChanged();
                this.c.k.setBackgroundResource(this.i);
                this.c.k.setTextColor(this.f);
                this.c.l.setBackgroundResource(this.h);
                this.c.l.setTextColor(this.e);
            } else if (i == 1) {
                this.B.b();
                this.B.notifyDataSetChanged();
                this.c.l.setBackgroundResource(this.j);
                this.c.l.setTextColor(this.f);
                this.c.k.setBackgroundResource(this.g);
                this.c.k.setTextColor(this.e);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        ForumInfoData[] a;
        if (i == 11002 && i2 == -1) {
            this.D.LoadData();
            if (this.o == 0) {
                a = this.A.a();
            } else {
                a = this.B.a();
            }
            this.p.setLoadDataCallBack(new l(this, a));
            if (this.o == 0) {
                this.p.a(a[this.A.a].forum_name, String.valueOf(a[this.A.a].forum_id));
            } else {
                this.p.a(a[this.B.a].forum_name, String.valueOf(a[this.B.a].forum_id));
            }
        }
    }
}
