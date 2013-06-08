package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.a.d {
    RelativeLayout b;
    RelativeLayout c;
    ImageView d;
    TextView e;
    private EnterForumActivity f;
    private ListView g;
    private ProgressBar h;
    private l i;
    private AlertDialog j;
    private AlertDialog k;
    private AlertDialog l;
    private com.baidu.tieba.d.a m;

    public t(EnterForumActivity enterForumActivity, View.OnKeyListener onKeyListener) {
        super(enterForumActivity);
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.m = null;
        this.f = enterForumActivity;
        enterForumActivity.setContentView(R.layout.enter_forum_view);
        this.b = (RelativeLayout) enterForumActivity.findViewById(R.id.container);
        this.c = (RelativeLayout) enterForumActivity.findViewById(R.id.title);
        this.d = (ImageView) enterForumActivity.findViewById(R.id.refresh);
        this.d.setOnClickListener(enterForumActivity);
        this.e = (TextView) enterForumActivity.findViewById(R.id.titel_text);
        this.m = new com.baidu.tieba.d.a(this.f);
        int a = com.baidu.tieba.d.ag.a(this.f, 41.0f);
        this.m.a(a, a);
        this.m.a("forum_icon_mini");
        this.g = (ListView) enterForumActivity.findViewById(R.id.enter_forum_lv_forum);
        this.i = new l(enterForumActivity, null);
        this.i.a((View.OnClickListener) enterForumActivity);
        this.i.a((View.OnLongClickListener) enterForumActivity);
        this.i.b(enterForumActivity);
        this.i.c(enterForumActivity);
        this.g.setAdapter((ListAdapter) this.i);
        this.g.setOnKeyListener(onKeyListener);
        this.g.setOnItemClickListener(enterForumActivity);
        this.g.setOnScrollListener(enterForumActivity);
        CharSequence[] charSequenceArr = {enterForumActivity.getString(R.string.enter_forum), enterForumActivity.getString(R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(enterForumActivity);
        builder.setTitle(enterForumActivity.getString(R.string.operation));
        builder.setItems(charSequenceArr, enterForumActivity);
        this.k = builder.create();
        this.k.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {enterForumActivity.getString(R.string.enter_forum), enterForumActivity.getString(R.string.delete)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(enterForumActivity);
        builder2.setTitle(enterForumActivity.getString(R.string.operation));
        builder2.setItems(charSequenceArr2, enterForumActivity);
        this.l = builder2.create();
        this.l.setCanceledOnTouchOutside(true);
        this.h = (ProgressBar) enterForumActivity.findViewById(R.id.enter_forum_progress);
        this.h.setVisibility(8);
    }

    public void a(com.baidu.tieba.c.j jVar, boolean z, int i) {
        if (jVar != null) {
            try {
                com.baidu.tieba.d.ac.a((View) this.g, i);
                this.i.a(jVar.d());
                this.i.a(Boolean.valueOf(z));
                this.i.notifyDataSetChanged();
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), Headers.REFRESH, e.getMessage());
            }
        }
    }

    public void a() {
        this.h.setVisibility(0);
    }

    public void a(boolean z, String str) {
        this.h.setVisibility(8);
        if (!z && str != null) {
            this.f.a(str);
        }
    }

    public void b() {
        this.h.setVisibility(0);
    }

    public void b(boolean z, String str) {
        this.h.setVisibility(8);
        if (z) {
            this.f.a(this.f.getString(R.string.like_success_and_addto_list));
        } else if (str != null) {
            this.f.a(str);
        }
    }

    public void c() {
        this.i.notifyDataSetChanged();
    }

    public void d() {
        this.i.b();
        this.i.notifyDataSetChanged();
    }

    public void e() {
        View findViewById = this.g.findViewById(R.id.lottery_image);
        if (findViewById != null && (findViewById instanceof ImageView)) {
            ((ImageView) findViewById).setImageResource(0);
        }
    }

    public void f() {
        View findViewById = this.g.findViewById(R.id.lottery_image);
        if (findViewById != null && (findViewById instanceof ImageView) && findViewById.getVisibility() == 0) {
            ((ImageView) findViewById).setImageResource(R.drawable.banner_image);
        }
    }

    public void g() {
        this.h.setVisibility(8);
        this.i.a();
        if (this.m != null) {
            this.m.b();
        }
    }

    public void h() {
        if (this.k != null) {
            this.k.dismiss();
        }
        if (this.l != null) {
            this.l.dismiss();
        }
    }

    public void a(int i) {
        com.baidu.tieba.d.ac.f(this.e, i);
        com.baidu.tieba.d.ac.a(this.b, i);
        com.baidu.tieba.d.ac.d(this.c, i);
        com.baidu.tieba.d.ac.b(this.d, i);
        com.baidu.tieba.d.ac.a((View) this.g, i);
        com.baidu.tieba.d.ac.a(this.g, i);
        this.i.notifyDataSetChanged();
    }

    public int i() {
        return R.id.first;
    }

    public int j() {
        return R.id.second;
    }

    public int k() {
        return R.id.want_login;
    }

    public int l() {
        return R.id.recommend_like;
    }

    public ImageView m() {
        return this.d;
    }

    public void n() {
        this.k.show();
    }

    public void o() {
        this.l.show();
    }

    public void p() {
        if (this.j == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f.getParent());
            builder.setTitle(R.string.alerm_title);
            builder.setIcon(R.drawable.dialogue_quit);
            builder.setMessage(R.string.delete_like_info);
            builder.setPositiveButton(this.f.getString(R.string.confirm), this.f);
            builder.setNegativeButton(this.f.getString(R.string.cancel), this.f);
            this.j = builder.create();
        }
        this.j.show();
    }

    public void q() {
        if (this.j != null) {
            this.j.dismiss();
        }
    }

    public AlertDialog r() {
        return this.k;
    }

    public AlertDialog s() {
        return this.l;
    }

    public AlertDialog t() {
        return this.j;
    }

    public ListView u() {
        return this.g;
    }

    public Object b(int i) {
        return this.i.getItem(i);
    }

    public void v() {
        String g;
        com.baidu.tieba.d.z c = com.baidu.tieba.d.w.c(this.f);
        this.m.a();
        boolean z = c == com.baidu.tieba.d.z.WIFI || c == com.baidu.tieba.d.z.ThreeG;
        this.m.a(z);
        int lastVisiblePosition = this.g.getLastVisiblePosition();
        int i = 0;
        for (int firstVisiblePosition = this.g.getFirstVisiblePosition(); firstVisiblePosition < this.i.getCount(); firstVisiblePosition++) {
            if (z || firstVisiblePosition <= lastVisiblePosition) {
                if ((this.i.getItem(firstVisiblePosition) instanceof com.baidu.tieba.a.p) && i < 13 && (g = ((com.baidu.tieba.a.p) this.i.getItem(firstVisiblePosition)).g()) != null && !g.equals("")) {
                    i++;
                    this.m.e(g, this.f);
                }
                if (i >= 13) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void a(String str) {
        View findViewWithTag;
        if (this.g != null && (findViewWithTag = this.g.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
