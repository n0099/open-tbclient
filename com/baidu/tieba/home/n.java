package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.be;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.SearchBoxView;
import com.baidu.tieba.view.bb;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    public SearchBoxView f1363a;
    public View c;
    protected com.baidu.tieba.im.b.d d;
    TextView e;
    TextView f;
    boolean g;
    private EnterForumActivity h;
    private BdListView i;
    private m j;
    private AlertDialog k;
    private AlertDialog l;
    private AlertDialog m;
    private RelativeLayout n;
    private RelativeLayout o;
    private TextView p;
    private bb q;
    private EnterForumGuideCenterView r;
    private EnterForumGuideBottomView s;
    private NoNetworkView t;
    private ImageView u;
    private com.baidu.tieba.im.b.n v;

    public void a() {
        if (!com.baidu.tieba.im.l.b().d() && TiebaApplication.D()) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
        switch (EnterForumActivity.f1320a) {
            case 0:
                g();
                if (this.s != null && this.s.getVisibility() == 0) {
                    a(8);
                }
                com.baidu.tieba.util.bb.f((View) this.f, (int) R.drawable.btn_jin_ba_s);
                com.baidu.tieba.util.bb.a(this.f, true);
                com.baidu.tieba.util.bb.a(this.e, false);
                this.d.e();
                this.i.setVisibility(0);
                this.f1363a.setText(this.h.getString(R.string.search_bar_post));
                return;
            case 1:
                this.u.setVisibility(8);
                a(8);
                if (this.d != null && this.d.c() != null) {
                    if (this.d.c().getCount() > 0) {
                        this.d.c().notifyDataSetChanged();
                        a(8, 1);
                    } else {
                        a(0, 1);
                    }
                    com.baidu.tieba.util.bb.f((View) this.f, (int) R.drawable.btn_jin_ba_n);
                    com.baidu.tieba.util.bb.a(this.f, false);
                    com.baidu.tieba.util.bb.a(this.e, true);
                    this.d.d();
                    this.i.setVisibility(8);
                    this.f1363a.setText(this.h.getString(R.string.search_group_text));
                    this.d.h();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public n(EnterForumActivity enterForumActivity, View.OnKeyListener onKeyListener) {
        super(enterForumActivity);
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
        this.t = null;
        this.g = false;
        this.v = new o(this);
        this.h = enterForumActivity;
        enterForumActivity.setContentView(R.layout.enter_forum_view);
        this.c = enterForumActivity.findViewById(R.id.container);
        this.t = (NoNetworkView) enterForumActivity.findViewById(R.id.view_no_network);
        this.p = (TextView) enterForumActivity.findViewById(R.id.titel_text);
        this.d = new com.baidu.tieba.im.b.d(enterForumActivity, this.v);
        this.e = (TextView) enterForumActivity.findViewById(R.id.enter_group);
        this.e.setOnClickListener(this.h);
        this.f = (TextView) enterForumActivity.findViewById(R.id.enter_forum);
        this.f.setOnClickListener(this.h);
        this.u = (ImageView) this.h.findViewById(R.id.enter_group_new);
        this.n = (RelativeLayout) enterForumActivity.findViewById(R.id.container);
        this.o = (RelativeLayout) enterForumActivity.findViewById(R.id.title);
        this.f1363a = (SearchBoxView) enterForumActivity.findViewById(R.id.view_searchbox);
        this.f1363a.setText(R.string.search_bar_post);
        this.f1363a.setOnClickListener(this.h);
        this.i = (BdListView) enterForumActivity.findViewById(R.id.enter_forum_lv_forum);
        this.j = new m(enterForumActivity);
        this.j.a((View.OnClickListener) enterForumActivity);
        this.j.a((View.OnLongClickListener) enterForumActivity);
        this.i.setAdapter((ListAdapter) this.j);
        this.i.setOnKeyListener(onKeyListener);
        this.i.setOnItemClickListener(enterForumActivity);
        this.i.setOnScrollListener(enterForumActivity);
        this.q = new bb(enterForumActivity);
        this.i.setPullRefresh(this.q);
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
    }

    public void e() {
        if (this.g) {
            this.g = false;
            this.i.setPullRefresh(this.q);
            this.j.a((com.baidu.tieba.data.af) null);
            w();
            a(0, 0);
        }
        this.i.b();
    }

    public void f() {
        this.i.a();
    }

    public void a(com.baidu.tieba.data.r rVar, boolean z) {
        f();
        if (rVar != null) {
            try {
                this.j.a(Boolean.valueOf(z));
                this.j.a(rVar);
            } catch (Exception e) {
                be.b(getClass().getName(), Headers.REFRESH, e.getMessage());
                return;
            }
        }
        g();
    }

    private void w() {
        if (this.r == null) {
            this.r = (EnterForumGuideCenterView) this.h.findViewById(R.id.lv_guid_center_root);
            this.r.a();
        }
    }

    private void x() {
        if (this.s == null) {
            this.s = (EnterForumGuideBottomView) this.h.findViewById(R.id.lv_guide_bottom);
            this.s.a();
        }
    }

    public void a(int i, int i2) {
        if (i2 == EnterForumActivity.f1320a) {
            if (this.s == null) {
                w();
            }
            this.r.b(i);
            if (i == 0) {
                switch (EnterForumActivity.f1320a) {
                    case 0:
                        this.r.setNoCenterTipText(R.string.forum_not_like_tip);
                        this.r.setArrowDisplay(0);
                        return;
                    case 1:
                        this.r.setNoCenterTipText(R.string.group_no_data_tip);
                        this.r.setArrowDisplay(8);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void a(int i) {
        if (this.s != null) {
            this.s.b(i);
        }
    }

    public void g() {
        int b = this.j.b();
        if (EnterForumActivity.f1320a == 0) {
            if (b == 3) {
                x();
                a(8, 0);
                a(0);
            } else if (b == 2) {
                w();
                a(0, 0);
                a(8);
            } else {
                if (b == 0) {
                    this.i.setPullRefresh(null);
                    this.g = true;
                }
                a(8, 0);
                a(8);
            }
            if (this.g && b != 0) {
                this.i.setPullRefresh(this.q);
                this.g = false;
            }
        }
    }

    public void a(boolean z, String str) {
        if (!z && str != null) {
            this.h.a(str);
        }
    }

    public SearchBoxView h() {
        return this.f1363a;
    }

    public void i() {
        this.j.notifyDataSetChanged();
    }

    public void j() {
        if (this.s != null) {
            this.s.b();
        }
        if (this.r != null) {
            this.r.b();
        }
    }

    public void k() {
        if (this.s != null) {
            this.s.c();
        }
        if (this.r != null) {
            this.r.c();
        }
    }

    public void l() {
        NetworkInfo activeNetworkInfo;
        a();
        if (this.t != null && this.t.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.h.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.t.setVisible(false);
        }
    }

    public void m() {
        if (this.d != null) {
            this.d.b();
        }
    }

    public void n() {
        if (this.l != null) {
            this.l.dismiss();
        }
        if (this.m != null) {
            this.m.dismiss();
        }
    }

    public void o() {
        if (this.t != null) {
            this.t.setVisible(true);
        }
    }

    public void b(int i) {
        this.h.m().a(i == 1);
        this.h.m().a(this.n);
        com.baidu.tieba.util.bb.d(this.o, i);
        com.baidu.tieba.util.bb.f(this.p, i);
        if (i == 1) {
            this.n.setBackgroundColor(-13618114);
        } else {
            this.n.setBackgroundColor(-197380);
        }
        if (this.s != null) {
            this.s.a(i);
        }
        if (this.r != null) {
            this.r.a(i);
        }
        if (this.t != null) {
            this.t.a(i);
        }
        this.j.a(i);
        this.q.a(i);
        this.f1363a.a(i);
        if (this.d != null) {
            this.d.a(i);
        }
    }

    public int p() {
        return R.id.first;
    }

    public int q() {
        return R.id.second;
    }

    public void r() {
        this.l.show();
    }

    public void s() {
        this.m.show();
    }

    public void t() {
        if (this.k == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.h.getParent());
            builder.setTitle(R.string.alerm_title);
            builder.setIcon(R.drawable.dialogue_quit);
            builder.setMessage(R.string.delete_like_info);
            builder.setPositiveButton(this.h.getString(R.string.confirm), this.h);
            builder.setNegativeButton(this.h.getString(R.string.cancel), this.h);
            this.k = builder.create();
        }
        this.k.show();
    }

    public AlertDialog u() {
        return this.l;
    }

    public AlertDialog v() {
        return this.m;
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.q.a(bVar);
    }
}
