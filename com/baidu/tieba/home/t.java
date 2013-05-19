package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.view.View;
import android.widget.FrameLayout;
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
    FrameLayout f;
    private EnterForumActivity g;
    private ListView h;
    private ProgressBar i;
    private l j;
    private AlertDialog k;
    private AlertDialog l;
    private AlertDialog m;
    private com.baidu.tieba.d.a n;

    public t(EnterForumActivity enterForumActivity, View.OnKeyListener onKeyListener) {
        super(enterForumActivity);
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.n = null;
        this.g = enterForumActivity;
        enterForumActivity.setContentView(R.layout.enter_forum_view);
        this.b = (RelativeLayout) enterForumActivity.findViewById(R.id.container);
        this.c = (RelativeLayout) enterForumActivity.findViewById(R.id.title);
        this.d = (ImageView) enterForumActivity.findViewById(R.id.refresh);
        this.d.setOnClickListener(enterForumActivity);
        this.e = (TextView) enterForumActivity.findViewById(R.id.titel_text);
        this.f = (FrameLayout) enterForumActivity.findViewById(R.id.lv_container);
        this.n = new com.baidu.tieba.d.a(this.g);
        int a = com.baidu.tieba.d.ag.a(this.g, 41.0f);
        this.n.a(a, a);
        this.n.a("forum_icon_mini");
        this.h = (ListView) enterForumActivity.findViewById(R.id.enter_forum_lv_forum);
        this.j = new l(enterForumActivity, null);
        this.j.a((View.OnClickListener) enterForumActivity);
        this.j.a((View.OnLongClickListener) enterForumActivity);
        this.j.b(enterForumActivity);
        this.j.c(enterForumActivity);
        this.h.setAdapter((ListAdapter) this.j);
        this.h.setOnKeyListener(onKeyListener);
        this.h.setOnItemClickListener(enterForumActivity);
        this.h.setOnScrollListener(enterForumActivity);
        CharSequence[] charSequenceArr = {enterForumActivity.getString(R.string.enter_forum), enterForumActivity.getString(R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(enterForumActivity);
        builder.setTitle(enterForumActivity.getString(R.string.operation));
        builder.setItems(charSequenceArr, enterForumActivity);
        this.l = builder.create();
        this.l.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {enterForumActivity.getString(R.string.enter_forum), enterForumActivity.getString(R.string.delete)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(enterForumActivity);
        builder2.setTitle(enterForumActivity.getString(R.string.operation));
        builder2.setItems(charSequenceArr2, enterForumActivity);
        this.m = builder2.create();
        this.m.setCanceledOnTouchOutside(true);
        this.i = (ProgressBar) enterForumActivity.findViewById(R.id.enter_forum_progress);
        this.i.setVisibility(8);
    }

    public void a(com.baidu.tieba.c.g gVar, boolean z, int i) {
        if (gVar != null) {
            try {
                com.baidu.tieba.d.ac.a((View) this.h, i);
                this.j.a(gVar.d());
                this.j.a(Boolean.valueOf(z));
                this.j.notifyDataSetChanged();
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), Headers.REFRESH, e.getMessage());
            }
        }
    }

    public void a() {
        this.i.setVisibility(0);
    }

    public void a(boolean z, String str) {
        this.i.setVisibility(8);
        if (!z && str != null) {
            this.g.a(str);
        }
    }

    public void b() {
        this.i.setVisibility(0);
    }

    public void b(boolean z, String str) {
        this.i.setVisibility(8);
        if (z) {
            this.g.a(this.g.getString(R.string.like_success_and_addto_list));
        } else if (str != null) {
            this.g.a(str);
        }
    }

    public void c() {
        this.j.notifyDataSetChanged();
    }

    public void d() {
        this.j.b();
        this.j.notifyDataSetChanged();
    }

    public void e() {
        View findViewById = this.h.findViewById(R.id.lottery_image);
        if (findViewById != null && (findViewById instanceof ImageView)) {
            ((ImageView) findViewById).setImageResource(0);
        }
    }

    public void f() {
        View findViewById = this.h.findViewById(R.id.lottery_image);
        if (findViewById != null && (findViewById instanceof ImageView) && findViewById.getVisibility() == 0) {
            ((ImageView) findViewById).setImageResource(R.drawable.banner_image);
        }
    }

    public void g() {
        this.i.setVisibility(8);
        this.j.a();
        if (this.n != null) {
            this.n.b();
        }
    }

    public void h() {
        if (this.l != null) {
            this.l.dismiss();
        }
        if (this.m != null) {
            this.m.dismiss();
        }
    }

    public void a(int i) {
        com.baidu.tieba.d.ac.f(this.e, i);
        com.baidu.tieba.d.ac.a(this.b, i);
        com.baidu.tieba.d.ac.d(this.c, i);
        com.baidu.tieba.d.ac.b(this.d, i);
        com.baidu.tieba.d.ac.a((View) this.h, i);
        com.baidu.tieba.d.ac.a(this.h, i);
        this.j.notifyDataSetChanged();
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
        this.l.show();
    }

    public void o() {
        this.m.show();
    }

    public void p() {
        if (this.k == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.g.getParent());
            builder.setTitle(R.string.alerm_title);
            builder.setIcon(R.drawable.dialogue_quit);
            builder.setMessage(R.string.delete_like_info);
            builder.setPositiveButton(this.g.getString(R.string.confirm), this.g);
            builder.setNegativeButton(this.g.getString(R.string.cancel), this.g);
            this.k = builder.create();
        }
        this.k.show();
    }

    public void q() {
        if (this.k != null) {
            this.k.dismiss();
        }
    }

    public AlertDialog r() {
        return this.l;
    }

    public AlertDialog s() {
        return this.m;
    }

    public AlertDialog t() {
        return this.k;
    }

    public ListView u() {
        return this.h;
    }

    public Object b(int i) {
        return this.j.getItem(i);
    }

    public void v() {
        String g;
        com.baidu.tieba.d.z c = com.baidu.tieba.d.w.c(this.g);
        this.n.a();
        boolean z = c == com.baidu.tieba.d.z.WIFI || c == com.baidu.tieba.d.z.ThreeG;
        this.n.a(z);
        int lastVisiblePosition = this.h.getLastVisiblePosition();
        int i = 0;
        for (int firstVisiblePosition = this.h.getFirstVisiblePosition(); firstVisiblePosition < this.j.getCount(); firstVisiblePosition++) {
            if (z || firstVisiblePosition <= lastVisiblePosition) {
                if ((this.j.getItem(firstVisiblePosition) instanceof com.baidu.tieba.a.p) && i < 13 && (g = ((com.baidu.tieba.a.p) this.j.getItem(firstVisiblePosition)).g()) != null && !g.equals("")) {
                    i++;
                    this.n.e(g, this.g);
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
        if (this.h != null && (findViewWithTag = this.h.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
