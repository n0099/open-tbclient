package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.SearchBoxView;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.a.e {
    private com.baidu.tieba.im.b.j A;

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.tieba.im.b.d f1450a;
    TextView c;
    TextView d;
    boolean e;
    private BaseFragmentActivity f;
    private EnterForumActivity g;
    private BdListView h;
    private n i;
    private AlertDialog j;
    private AlertDialog k;
    private AlertDialog l;
    private LinearLayout m;
    private FrameLayout n;
    private NavigationBar o;
    private SearchBoxView p;
    private com.baidu.tieba.view.bi q;
    private EnterForumGuideCenterView r;
    private EnterForumGuideBottomView s;
    private NoNetworkView t;
    private ImageView u;
    private View.OnClickListener v;
    private View.OnClickListener w;
    private boolean x;
    private String y;
    private TextView z;

    public void a() {
        int i = R.color.navi_multiview_text_n_1;
        if (this.d != null && this.c != null) {
            if (!com.baidu.tieba.im.l.b().c() && TiebaApplication.B()) {
                this.u.setVisibility(0);
            } else {
                this.u.setVisibility(8);
            }
            boolean z = TiebaApplication.g().ap() == 1;
            EnterForumActivity enterForumActivity = this.g;
            switch (EnterForumActivity.f1379a) {
                case 0:
                    g();
                    if (this.s != null && this.s.getVisibility() == 0) {
                        a(8);
                    }
                    com.baidu.tieba.util.bd.f((View) this.d, (int) R.drawable.btn_jin_ba_s);
                    com.baidu.tieba.util.bd.f((View) this.c, (int) R.drawable.btn_jin_qun_n);
                    this.d.setTextColor(this.b.getResources().getColor(z ? R.color.navi_multiview_text_s_1 : R.color.navi_multiview_text_s));
                    this.c.setTextColor(this.b.getResources().getColor(z ? R.color.navi_multiview_text_n_1 : R.color.navi_multiview_text_n));
                    this.f1450a.e();
                    this.h.setVisibility(0);
                    this.p.setText(this.f.getString(R.string.search_bar_post));
                    this.z.setOnClickListener(this.v);
                    y();
                    return;
                case 1:
                    this.u.setVisibility(8);
                    a(8);
                    if (this.f1450a != null && this.f1450a.c() != null) {
                        if (this.f1450a.c().getCount() > 0) {
                            this.f1450a.c().notifyDataSetChanged();
                            a(8, 1);
                        } else {
                            a(0, 1);
                        }
                        com.baidu.tieba.util.bd.f((View) this.d, (int) R.drawable.btn_jin_ba_n);
                        com.baidu.tieba.util.bd.f((View) this.c, (int) R.drawable.btn_jin_qun_s);
                        TextView textView = this.d;
                        Resources resources = this.b.getResources();
                        if (!z) {
                            i = R.color.navi_multiview_text_n;
                        }
                        textView.setTextColor(resources.getColor(i));
                        this.c.setTextColor(this.b.getResources().getColor(z ? R.color.navi_multiview_text_s_1 : R.color.navi_multiview_text_s));
                        this.f1450a.d();
                        this.h.setVisibility(8);
                        this.p.setText(this.f.getString(R.string.search_group_text));
                        this.f1450a.g();
                        this.z.setOnClickListener(this.w);
                        y();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public o(BaseFragmentActivity baseFragmentActivity, EnterForumActivity enterForumActivity, View.OnKeyListener onKeyListener) {
        super(baseFragmentActivity);
        this.f = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.v = new p(this);
        this.w = null;
        this.e = false;
        this.A = new q(this);
        this.f = baseFragmentActivity;
        this.g = enterForumActivity;
        View q = enterForumActivity.q();
        this.m = (LinearLayout) q.findViewById(R.id.container);
        this.t = (NoNetworkView) q.findViewById(R.id.view_no_network);
        this.o = (NavigationBar) q.findViewById(R.id.view_navigation_bar);
        this.f.getLayoutInflater();
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.enter_forum_title, (ViewGroup) null);
        this.d = (TextView) inflate.findViewById(R.id.enter_forum);
        this.c = (TextView) inflate.findViewById(R.id.enter_group);
        this.c.setOnClickListener(this.g);
        this.d.setOnClickListener(this.g);
        this.o.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, inflate, (View.OnClickListener) null);
        this.f1450a = new com.baidu.tieba.im.b.d(this.g, this.f, this.A);
        this.z = this.o.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f.getString(R.string.signallforum_title), this.v);
        this.f1450a.a(this.z);
        this.z.setVisibility(8);
        this.u = (ImageView) inflate.findViewById(R.id.enter_group_new);
        this.n = (FrameLayout) q.findViewById(R.id.lv_container);
        this.p = (SearchBoxView) q.findViewById(R.id.view_searchbox);
        this.p.setText(R.string.search_bar_post);
        this.p.setOnClickListener(this.g);
        this.h = (BdListView) q.findViewById(R.id.enter_forum_lv_forum);
        this.i = new n(baseFragmentActivity);
        this.i.a((View.OnClickListener) enterForumActivity);
        this.i.a((View.OnLongClickListener) enterForumActivity);
        this.h.setAdapter((ListAdapter) this.i);
        this.h.setOnKeyListener(onKeyListener);
        this.h.setOnItemClickListener(enterForumActivity);
        this.h.setOnScrollListener(enterForumActivity);
        this.q = new com.baidu.tieba.view.bi(baseFragmentActivity);
        this.h.setPullRefresh(this.q);
        com.baidu.tieba.view.q qVar = new com.baidu.tieba.view.q(this.f);
        qVar.setHeightDip(30);
        this.h.addFooterView(qVar);
        CharSequence[] charSequenceArr = {baseFragmentActivity.getString(R.string.enter_forum), baseFragmentActivity.getString(R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragmentActivity);
        builder.setTitle(baseFragmentActivity.getString(R.string.operation));
        builder.setItems(charSequenceArr, enterForumActivity);
        this.k = builder.create();
        this.k.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {baseFragmentActivity.getString(R.string.enter_forum), baseFragmentActivity.getString(R.string.delete)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(baseFragmentActivity);
        builder2.setTitle(baseFragmentActivity.getString(R.string.operation));
        builder2.setItems(charSequenceArr2, enterForumActivity);
        this.l = builder2.create();
        this.l.setCanceledOnTouchOutside(true);
    }

    public void e() {
        if (this.e) {
            this.e = false;
            this.h.setPullRefresh(this.q);
            this.i.a((com.baidu.tieba.data.ae) null);
            w();
            a(0, 0);
        }
        this.h.b();
    }

    public void f() {
        this.h.a();
    }

    public void a(com.baidu.tieba.data.r rVar, boolean z) {
        f();
        if (rVar != null) {
            try {
                this.i.a(Boolean.valueOf(z));
                this.i.a(rVar);
            } catch (Exception e) {
                com.baidu.tieba.util.bg.b(getClass().getName(), Headers.REFRESH, e.getMessage());
                return;
            }
        }
        g();
    }

    private void w() {
        if (this.r == null) {
            this.r = (EnterForumGuideCenterView) this.f.findViewById(R.id.lv_guid_center_root);
            this.r.a();
        }
    }

    private void x() {
        if (this.s == null) {
            this.s = (EnterForumGuideBottomView) this.f.findViewById(R.id.lv_guide_bottom);
            this.s.a();
        }
    }

    public void a(int i, int i2) {
        EnterForumActivity enterForumActivity = this.g;
        if (i2 == EnterForumActivity.f1379a) {
            if (this.r == null) {
                w();
            }
            if (this.r != null) {
                this.r.b(i);
                if (i == 0) {
                    EnterForumActivity enterForumActivity2 = this.g;
                    switch (EnterForumActivity.f1379a) {
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
    }

    public void a(int i) {
        if (this.s != null) {
            this.s.b(i);
        }
    }

    public void g() {
        int b = this.i.b();
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
                this.h.setPullRefresh(null);
                this.e = true;
            }
            a(8, 0);
            a(8);
        }
        if (this.e && b != 0) {
            this.h.setPullRefresh(this.q);
            this.e = false;
        }
    }

    public void a(boolean z, String str) {
        if (!z && str != null) {
            this.f.a(str);
        }
    }

    public SearchBoxView h() {
        return this.p;
    }

    public void i() {
        this.i.notifyDataSetChanged();
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
        if (this.s != null && this.s.getVisibility() == 0) {
            a(8);
        }
        if (this.t != null && this.t.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.f.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.t.setVisible(false);
        }
    }

    public void m() {
        if (this.f1450a != null) {
            this.f1450a.b();
        }
    }

    public void n() {
        if (this.k != null) {
            this.k.dismiss();
        }
        if (this.l != null) {
            this.l.dismiss();
        }
    }

    public void o() {
        if (this.t != null) {
            this.t.setVisible(true);
        }
    }

    private void y() {
        EnterForumActivity enterForumActivity = this.g;
        if (EnterForumActivity.f1379a == 0) {
            this.z.setText(this.f.getString(R.string.signallforum_title));
            this.z.setTextSize(10.0f);
            return;
        }
        this.z.setText(this.f.getString(R.string.frsgroup_create));
        if (UtilHelper.a((Context) this.f) > 700) {
            this.z.setTextSize(14.0f);
        } else {
            this.z.setTextSize(12.0f);
        }
    }

    public void b(int i) {
        this.f.a().a(i == 1);
        this.f.a().a(this.m);
        this.o.c(i);
        y();
        if (i == 1) {
            this.n.setBackgroundColor(-14538444);
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
        this.i.a(i);
        this.q.a(i);
        this.p.a(i);
        if (this.f1450a != null) {
            this.f1450a.a(i);
        }
    }

    public int p() {
        return R.id.item_left;
    }

    public int q() {
        return R.id.item_right;
    }

    public void r() {
        this.k.show();
    }

    public void s() {
        this.l.show();
    }

    public void t() {
        if (this.j == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f.getParent());
            builder.setTitle(R.string.alerm_title);
            builder.setIcon(R.drawable.dialogue_quit);
            builder.setMessage(R.string.delete_like_info);
            builder.setPositiveButton(this.f.getString(R.string.confirm), this.g);
            builder.setNegativeButton(this.f.getString(R.string.cancel), this.g);
            this.j = builder.create();
        }
        this.j.show();
    }

    public AlertDialog u() {
        return this.k;
    }

    public AlertDialog v() {
        return this.l;
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.q.a(bVar);
    }

    public void a(boolean z, boolean z2, String str) {
        if (z) {
            this.x = z2;
            this.y = str;
            if ((TiebaApplication.A() == null || TiebaApplication.F() == null) ? false : true) {
                this.z.setVisibility(0);
                return;
            }
            return;
        }
        this.z.setVisibility(8);
    }

    public void a(View.OnClickListener onClickListener) {
        this.w = onClickListener;
    }
}
