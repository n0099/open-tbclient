package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.a.d {
    boolean b;
    private EnterForumActivity c;
    private BdListView d;
    private j e;
    private AlertDialog f;
    private AlertDialog g;
    private AlertDialog h;
    private RelativeLayout i;
    private RelativeLayout j;
    private LinearLayout k;
    private ImageView l;
    private LinearLayout m;
    private TextView n;
    private com.baidu.tieba.view.ba o;
    private TextView p;
    private EnterForumGuideCenterView q;
    private EnterForumGuideBottomView r;
    private NoNetworkView s;

    public k(EnterForumActivity enterForumActivity, View.OnKeyListener onKeyListener) {
        super(enterForumActivity);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.b = false;
        this.c = enterForumActivity;
        enterForumActivity.setContentView(R.layout.enter_forum_view);
        this.s = (NoNetworkView) enterForumActivity.findViewById(R.id.view_no_network);
        this.p = (TextView) enterForumActivity.findViewById(R.id.titel_text);
        this.l = (ImageView) enterForumActivity.findViewById(R.id.search_bar_icon);
        this.i = (RelativeLayout) enterForumActivity.findViewById(R.id.container);
        this.j = (RelativeLayout) enterForumActivity.findViewById(R.id.title);
        this.k = (LinearLayout) enterForumActivity.findViewById(R.id.search_bg_layout);
        this.m = (LinearLayout) enterForumActivity.findViewById(R.id.search_tap_layout);
        this.n = (TextView) enterForumActivity.findViewById(R.id.search_bar_text);
        this.k.setOnClickListener(enterForumActivity);
        this.d = (BdListView) enterForumActivity.findViewById(R.id.enter_forum_lv_forum);
        this.e = new j(enterForumActivity);
        this.e.a((View.OnClickListener) enterForumActivity);
        this.e.a((View.OnLongClickListener) enterForumActivity);
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnKeyListener(onKeyListener);
        this.d.setOnItemClickListener(enterForumActivity);
        this.d.setOnScrollListener(enterForumActivity);
        this.o = new com.baidu.tieba.view.ba(enterForumActivity);
        this.d.setPullRefresh(this.o);
        CharSequence[] charSequenceArr = {enterForumActivity.getString(R.string.enter_forum), enterForumActivity.getString(R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(enterForumActivity);
        builder.setTitle(enterForumActivity.getString(R.string.operation));
        builder.setItems(charSequenceArr, enterForumActivity);
        this.g = builder.create();
        this.g.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {enterForumActivity.getString(R.string.enter_forum), enterForumActivity.getString(R.string.delete)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(enterForumActivity);
        builder2.setTitle(enterForumActivity.getString(R.string.operation));
        builder2.setItems(charSequenceArr2, enterForumActivity);
        this.h = builder2.create();
        this.h.setCanceledOnTouchOutside(true);
    }

    public void b() {
        if (this.b) {
            this.b = false;
            this.d.setPullRefresh(this.o);
            this.e.a((com.baidu.tieba.data.af) null);
            s();
            a(0);
        }
        this.d.b();
    }

    public void c() {
        this.d.a();
    }

    public void a(com.baidu.tieba.data.q qVar, boolean z) {
        c();
        if (qVar != null) {
            try {
                this.e.a(Boolean.valueOf(z));
                this.e.a(qVar);
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), Headers.REFRESH, e.getMessage());
                return;
            }
        }
        d();
    }

    private void s() {
        if (this.q == null) {
            this.q = (EnterForumGuideCenterView) this.c.findViewById(R.id.lv_guid_center_root);
            this.q.a();
        }
    }

    private void t() {
        if (this.r == null) {
            this.r = (EnterForumGuideBottomView) this.c.findViewById(R.id.lv_guide_bottom);
            this.r.a();
        }
    }

    public void a(int i) {
        if (this.q != null) {
            this.q.b(i);
        }
    }

    public void b(int i) {
        if (this.r != null) {
            this.r.b(i);
        }
    }

    public void d() {
        int b = this.e.b();
        if (b == 3) {
            t();
            a(8);
            b(0);
        } else if (b == 2) {
            s();
            a(0);
            b(8);
        } else {
            if (b == 0) {
                this.d.setPullRefresh(null);
                this.b = true;
            }
            a(8);
            b(8);
        }
        if (this.b && b != 0) {
            this.d.setPullRefresh(this.o);
            this.b = false;
        }
    }

    public void a(boolean z, String str) {
        if (!z && str != null) {
            this.c.a(str);
        }
    }

    public void e() {
        this.e.notifyDataSetChanged();
    }

    public void f() {
        if (this.r != null) {
            this.r.b();
        }
        if (this.q != null) {
            this.q.b();
        }
    }

    public void g() {
        if (this.r != null) {
            this.r.c();
        }
        if (this.q != null) {
            this.q.c();
        }
    }

    public void h() {
        if (this.r != null && this.r.getVisibility() == 0) {
            b(8);
        }
    }

    public void i() {
    }

    public void j() {
        if (this.g != null) {
            this.g.dismiss();
        }
        if (this.h != null) {
            this.h.dismiss();
        }
    }

    public void k() {
        if (this.s != null) {
            this.s.setVisible(true);
        }
    }

    public void c(int i) {
        com.baidu.tieba.util.ao.d(this.j, i);
        com.baidu.tieba.util.ao.f(this.p, i);
        if (i == 1) {
            this.l.setImageResource(R.drawable.icon_head_bar_search_1);
            this.i.setBackgroundColor(-13618114);
            com.baidu.tieba.util.ao.g(this.m, (int) R.drawable.inputbox_topbg_1);
            com.baidu.tieba.util.ao.g(this.k, (int) R.drawable.inputbox_top_1);
            this.n.setHintTextColor(-11446171);
        } else {
            this.i.setBackgroundColor(-197380);
            this.l.setImageResource(R.drawable.icon_head_bar_search);
            com.baidu.tieba.util.ao.g(this.m, (int) R.drawable.inputbox_topbg);
            com.baidu.tieba.util.ao.g(this.k, (int) R.drawable.inputbox_top);
            this.n.setHintTextColor(-5921112);
        }
        if (this.r != null) {
            this.r.a(i);
        }
        if (this.q != null) {
            this.q.a(i);
        }
        if (this.s != null) {
            this.s.a(i);
        }
        this.e.a(i);
        this.o.a(i);
    }

    public int l() {
        return R.id.first;
    }

    public int m() {
        return R.id.second;
    }

    public void n() {
        this.g.show();
    }

    public void o() {
        this.h.show();
    }

    public void p() {
        if (this.f == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.c.getParent());
            builder.setTitle(R.string.alerm_title);
            builder.setIcon(R.drawable.dialogue_quit);
            builder.setMessage(R.string.delete_like_info);
            builder.setPositiveButton(this.c.getString(R.string.confirm), this.c);
            builder.setNegativeButton(this.c.getString(R.string.cancel), this.c);
            this.f = builder.create();
        }
        this.f.show();
    }

    public AlertDialog q() {
        return this.g;
    }

    public AlertDialog r() {
        return this.h;
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.o.a(bVar);
    }
}
