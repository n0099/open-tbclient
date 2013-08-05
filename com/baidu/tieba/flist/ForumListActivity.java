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
import com.baidu.tieba.model.ar;
import com.baidu.tieba.util.ah;
import com.baidu.tieba.util.aj;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ForumListActivity extends com.baidu.tieba.g implements bq {

    /* renamed from: a  reason: collision with root package name */
    public l f1036a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int j;
    private com.baidu.tieba.util.a n;
    private ForumListModel.RequestParams o;
    private e r;
    private e s;
    private int k = -1;
    private int l = -1;
    private ar m = new ar();
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
        this.f1036a = new l(this);
        this.f1036a.r.setOnClickListener(this);
        this.f1036a.h = (ListView) b();
        this.f1036a.i = (ListView) c();
        this.n = new com.baidu.tieba.util.a(this);
        this.n.a(BdWebErrorView.ERROR_CODE_400, BdWebErrorView.ERROR_CODE_400);
        this.f1036a.c.setAdapter(new i(this));
        this.f1036a.g.setText(getIntent().getStringExtra("menu_name"));
        this.r = new e(this, 0);
        this.s = new e(this, 1);
        this.o = new ForumListModel.RequestParams();
        try {
            this.o.menu_id = Integer.valueOf(getIntent().getStringExtra("menu_id")).intValue();
            this.o.menu_name = getIntent().getStringExtra("menu_name");
            this.o.menu_type = Integer.valueOf(getIntent().getStringExtra("menu_type")).intValue();
            this.o.parent_menu_id = Integer.valueOf(getIntent().getStringExtra("parent_menu_id")).intValue();
            this.o.parent_menu_name = getIntent().getStringExtra("parent_menu_name");
            this.o.offset = 0;
            this.o.rn = 10;
            aj.e("ForumListActivity", "onCreate", this.o.toString());
        } catch (NullPointerException e) {
            finish();
        }
        new a(this).execute(new Void[0]);
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
        this.m.a();
        this.f1036a.c.setAdapter(null);
        this.f1036a.i.setAdapter((ListAdapter) null);
        this.f1036a.h.setAdapter((ListAdapter) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        ah.d(this.f1036a.e, i);
        ah.a(this.f1036a.f, i);
        ah.f(this.f1036a.g, i);
        ah.b(findViewById(R.id.container), i);
        ah.d(this.f1036a.r, i);
        if (TiebaApplication.f().au() == 1) {
            this.f1036a.h.setDivider(new ColorDrawable(-13881543));
            this.f1036a.i.setDivider(new ColorDrawable(-13881543));
        } else {
            this.f1036a.h.setDivider(new ColorDrawable(-1775893));
            this.f1036a.i.setDivider(new ColorDrawable(-1775893));
        }
        this.f1036a.h.setDividerHeight(2);
        this.f1036a.i.setDividerHeight(2);
        this.r.notifyDataSetChanged();
        this.s.notifyDataSetChanged();
        if (i == 1) {
            this.f1036a.d.setBackgroundResource(R.drawable.bg_up_bar_1);
            this.b = getResources().getColor(R.color.flist_text_color_night);
            this.c = getResources().getColor(R.color.flist_selected_text_color_night);
            this.d = R.drawable.btn_gray_fillet_s_1;
            this.e = R.drawable.ico_downward_1;
            this.f = R.drawable.ico_upward_1;
            this.g = R.drawable.icon_like_s_1;
            this.j = R.drawable.icon_like_n_1;
            this.f1036a.j.setTextColor(this.b);
            this.f1036a.k.setTextColor(this.b);
            this.f1036a.b.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            this.f1036a.p.setTextColor(getResources().getColor(R.color.flist_text_color_night));
            this.f1036a.f1048a.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            this.f1036a.m.setTextColor(getResources().getColor(R.color.flist_text_color_night));
            if (this.p) {
                this.f1036a.n.setImageResource(R.drawable.ico_upward_1);
            } else {
                this.f1036a.n.setImageResource(R.drawable.ico_downward_1);
            }
            if (this.q) {
                this.f1036a.q.setImageResource(R.drawable.ico_upward_1);
            } else {
                this.f1036a.q.setImageResource(R.drawable.ico_downward_1);
            }
        } else {
            this.f1036a.d.setBackgroundResource(R.drawable.bg_black_banner_up);
            this.b = getResources().getColor(R.color.flist_text_color_day);
            this.c = getResources().getColor(R.color.flist_selected_text_color_day);
            this.d = R.drawable.btn_gray_fillet_s;
            this.e = R.drawable.ico_downward;
            this.f = R.drawable.ico_upward;
            this.g = R.drawable.icon_like_s;
            this.j = R.drawable.icon_like_n;
            this.f1036a.b.setBackgroundResource(R.drawable.bg_black_banner_down);
            this.f1036a.p.setTextColor(getResources().getColor(R.color.flist_text_color_day));
            this.f1036a.f1048a.setBackgroundResource(R.drawable.bg_black_banner_down);
            this.f1036a.m.setTextColor(getResources().getColor(R.color.flist_text_color_day));
            if (this.p) {
                this.f1036a.n.setImageResource(R.drawable.ico_upward);
            } else {
                this.f1036a.n.setImageResource(R.drawable.ico_downward);
            }
            if (this.q) {
                this.f1036a.q.setImageResource(R.drawable.ico_upward);
            } else {
                this.f1036a.q.setImageResource(R.drawable.ico_downward);
            }
        }
        if (this.f1036a.c.getCurrentItem() == 0) {
            this.f1036a.j.setTextColor(this.c);
            this.f1036a.j.setBackgroundResource(this.d);
            this.f1036a.k.setTextColor(this.b);
            return;
        }
        this.f1036a.k.setTextColor(this.c);
        this.f1036a.k.setBackgroundResource(this.d);
        this.f1036a.j.setTextColor(this.b);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back /* 2131099689 */:
                finish();
                return;
            case R.id.home /* 2131099816 */:
                MainTabActivity.a(this);
                return;
            case R.id.tab_recommends /* 2131100002 */:
                this.f1036a.c.setCurrentItem(0);
                return;
            case R.id.tab_hot /* 2131100003 */:
                this.f1036a.c.setCurrentItem(1);
                return;
            default:
                return;
        }
    }

    private View b() {
        this.f1036a.h = d();
        this.f1036a.h.setAdapter((ListAdapter) this.r);
        this.f1036a.l.setOnClickListener(new b(this));
        return this.f1036a.h;
    }

    private View c() {
        this.f1036a.i = d();
        this.f1036a.i.setAdapter((ListAdapter) this.s);
        this.f1036a.o.setOnClickListener(new c(this));
        return this.f1036a.i;
    }

    private ListView d() {
        ListView listView = new ListView(this);
        listView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        listView.setCacheColorHint(0);
        listView.setSelector(17170445);
        if (TiebaApplication.f().au() == 1) {
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
            this.f1036a.j.setBackgroundResource(this.d);
            this.f1036a.j.setTextColor(this.c);
            this.f1036a.k.setBackgroundResource(0);
            this.f1036a.k.setTextColor(this.b);
        } else if (i == 1) {
            this.f1036a.k.setBackgroundResource(this.d);
            this.f1036a.k.setTextColor(this.c);
            this.f1036a.j.setBackgroundResource(0);
            this.f1036a.j.setTextColor(this.b);
        }
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        ForumListModel.Forum[] a2;
        if (i == 11002 && i2 == -1) {
            if (this.l == 0) {
                a2 = this.r.a();
            } else if (this.l == 1) {
                a2 = this.s.a();
            } else {
                return;
            }
            findViewById(R.id.loading).setVisibility(0);
            this.m.setLoadDataCallBack(new d(this, a2));
            this.m.a(a2[this.k].forum_name, String.valueOf(a2[this.k].forum_id));
        }
    }
}
