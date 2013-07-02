package com.baidu.tieba.flist;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.bq;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.aj;
import com.baidu.tieba.util.x;
import com.baidu.tieba.util.z;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ForumListActivity extends com.baidu.tieba.g implements bq {
    public m a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int j;
    private com.baidu.tieba.util.a n;
    private ForumListModel.RequestParams o;
    private f r;
    private f s;
    private int k = -1;
    private int l = -1;
    private aj m = new aj();
    private boolean p = false;
    private boolean q = false;

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(context, ForumListActivity.class);
        intent.putExtra("menu_name", str);
        intent.putExtra("menu_id", str2);
        intent.putExtra("menu_type", str3);
        intent.putExtra("parent_menu_name", str4);
        intent.putExtra("parent_menu_id", str5);
        context.startActivity(intent);
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forum_list_activity);
        this.a = new m(this);
        this.a.t.setOnClickListener(this);
        this.a.j = (ListView) b();
        this.a.k = (ListView) c();
        this.n = new com.baidu.tieba.util.a(this);
        this.n.a(BdWebErrorView.ERROR_CODE_400, BdWebErrorView.ERROR_CODE_400);
        this.a.e.setAdapter(new j(this));
        this.a.i.setText(getIntent().getStringExtra("menu_name"));
        this.r = new f(this, 0);
        this.s = new f(this, 1);
        this.o = new ForumListModel.RequestParams();
        try {
            this.o.menu_id = Integer.valueOf(getIntent().getStringExtra("menu_id")).intValue();
            this.o.menu_name = getIntent().getStringExtra("menu_name");
            this.o.menu_type = Integer.valueOf(getIntent().getStringExtra("menu_type")).intValue();
            this.o.parent_menu_id = Integer.valueOf(getIntent().getStringExtra("parent_menu_id")).intValue();
            this.o.parent_menu_name = getIntent().getStringExtra("parent_menu_name");
            this.o.offset = 0;
            this.o.rn = 10;
            z.e("ForumListActivity", "onCreate", this.o.toString());
        } catch (NullPointerException e) {
            finish();
        }
        new b(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.r != null) {
            this.r.notifyDataSetChanged();
        }
        if (this.s != null) {
            this.s.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.a.e.setAdapter(null);
        this.a.k.setAdapter((ListAdapter) null);
        this.a.j.setAdapter((ListAdapter) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        x.d(this.a.g, i);
        x.a(this.a.h, i);
        x.f(this.a.i, i);
        x.b(findViewById(R.id.container), i);
        x.d(this.a.t, i);
        if (TiebaApplication.f().at() == 1) {
            this.a.j.setDivider(new ColorDrawable(-13881543));
            this.a.k.setDivider(new ColorDrawable(-13881543));
        } else {
            this.a.j.setDivider(new ColorDrawable(-1775893));
            this.a.k.setDivider(new ColorDrawable(-1775893));
        }
        this.a.j.setDividerHeight(2);
        this.a.k.setDividerHeight(2);
        this.r.notifyDataSetChanged();
        this.s.notifyDataSetChanged();
        if (i == 1) {
            findViewById(R.id.light).setBackgroundResource(R.drawable.light_1);
            findViewById(R.id.cover_shadow).setBackgroundDrawable(null);
            this.a.d.setBackgroundColor(-14144717);
            this.a.f.setBackgroundResource(R.drawable.bg_up_bar_1);
            this.b = getResources().getColor(R.color.flist_text_color_night);
            this.c = getResources().getColor(R.color.flist_selected_text_color_night);
            this.d = R.drawable.btn_gray_fillet_s_1;
            this.e = R.drawable.ico_downward_1;
            this.f = R.drawable.ico_upward_1;
            this.g = R.drawable.icon_like_s_1;
            this.j = R.drawable.icon_like_n_1;
            this.a.l.setTextColor(this.b);
            this.a.m.setTextColor(this.b);
            this.a.b.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            this.a.r.setTextColor(getResources().getColor(R.color.flist_text_color_night));
            this.a.a.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            this.a.o.setTextColor(getResources().getColor(R.color.flist_text_color_night));
            if (this.p) {
                this.a.p.setImageResource(R.drawable.ico_upward_1);
            } else {
                this.a.p.setImageResource(R.drawable.ico_downward_1);
            }
            if (this.q) {
                this.a.s.setImageResource(R.drawable.ico_upward_1);
            } else {
                this.a.s.setImageResource(R.drawable.ico_downward_1);
            }
        } else {
            findViewById(R.id.light).setBackgroundResource(R.drawable.light);
            findViewById(R.id.cover_shadow).setBackgroundResource(R.drawable.cover_flow_shadow);
            this.a.d.setBackgroundResource(R.drawable.bg_recommend_flower_tiled);
            this.a.f.setBackgroundResource(R.drawable.bg_black_banner_up);
            this.b = getResources().getColor(R.color.flist_text_color_day);
            this.c = getResources().getColor(R.color.flist_selected_text_color_day);
            this.d = R.drawable.btn_gray_fillet_s;
            this.e = R.drawable.ico_downward;
            this.f = R.drawable.ico_upward;
            this.g = R.drawable.icon_like_s;
            this.j = R.drawable.icon_like_n;
            this.a.b.setBackgroundResource(R.drawable.bg_black_banner_down);
            this.a.r.setTextColor(getResources().getColor(R.color.flist_text_color_day));
            this.a.a.setBackgroundResource(R.drawable.bg_black_banner_down);
            this.a.o.setTextColor(getResources().getColor(R.color.flist_text_color_day));
            if (this.p) {
                this.a.p.setImageResource(R.drawable.ico_upward);
            } else {
                this.a.p.setImageResource(R.drawable.ico_downward);
            }
            if (this.q) {
                this.a.s.setImageResource(R.drawable.ico_upward);
            } else {
                this.a.s.setImageResource(R.drawable.ico_downward);
            }
        }
        if (this.a.c.getCurrentItem() == 0) {
            this.a.l.setTextColor(this.c);
            this.a.l.setBackgroundResource(this.d);
            this.a.m.setTextColor(this.b);
            return;
        }
        this.a.m.setTextColor(this.c);
        this.a.m.setBackgroundResource(this.d);
        this.a.l.setTextColor(this.b);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back /* 2131099687 */:
                finish();
                return;
            case R.id.home /* 2131099811 */:
                MainTabActivity.a(this);
                return;
            case R.id.tab_recommends /* 2131099981 */:
                this.a.e.setCurrentItem(0);
                return;
            case R.id.tab_hot /* 2131099982 */:
                this.a.e.setCurrentItem(1);
                return;
            default:
                return;
        }
    }

    private View b() {
        this.a.j = d();
        this.a.j.setAdapter((ListAdapter) this.r);
        this.a.n.setOnClickListener(new c(this));
        return this.a.j;
    }

    private View c() {
        this.a.k = d();
        this.a.k.setAdapter((ListAdapter) this.s);
        this.a.q.setOnClickListener(new d(this));
        return this.a.k;
    }

    private ListView d() {
        ListView listView = new ListView(this);
        listView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        listView.setCacheColorHint(0);
        listView.setSelector(17170445);
        if (TiebaApplication.f().at() == 1) {
            listView.setDivider(new ColorDrawable(-13881543));
        } else {
            listView.setDivider(new ColorDrawable(-1775893));
        }
        listView.setDividerHeight(2);
        listView.setFooterDividersEnabled(false);
        listView.setHorizontalFadingEdgeEnabled(false);
        listView.setVerticalFadingEdgeEnabled(false);
        return listView;
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        if (i == 0) {
            this.a.l.setBackgroundResource(this.d);
            this.a.l.setTextColor(this.c);
            this.a.m.setBackgroundResource(0);
            this.a.m.setTextColor(this.b);
        } else if (i == 1) {
            this.a.m.setBackgroundResource(this.d);
            this.a.m.setTextColor(this.c);
            this.a.l.setBackgroundResource(0);
            this.a.l.setTextColor(this.b);
        }
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        ForumListModel.Forum[] a;
        if (i == 1100002 && i2 == -1) {
            if (this.l == 0) {
                a = this.r.a();
            } else if (this.l == 1) {
                a = this.s.a();
            } else {
                return;
            }
            findViewById(R.id.loading).setVisibility(0);
            this.m.setLoadDataCallBack(new e(this, a));
            this.m.a(a[this.k].forum_name, String.valueOf(a[this.k].forum_id));
        }
    }
}
