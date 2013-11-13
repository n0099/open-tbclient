package com.baidu.tieba.im.b;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.home.EnterForumActivity;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.l;
import com.baidu.tieba.view.bi;
import com.baidu.tieba.view.q;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class d implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    public c b;
    public boolean c;
    private EnterForumActivity d;
    private BaseFragmentActivity e;
    private TextView h;
    private ImageView i;
    private a j;
    private j k;
    private bi f = null;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f1477a = null;
    private q g = null;
    private Handler l = new e(this);
    private Handler m = new Handler();
    private com.baidu.tieba.im.messageCenter.h n = new g(this);
    private com.baidu.tieba.im.messageCenter.h o = new h(this);
    private Runnable p = new i(this);

    public void a() {
        this.l.removeMessages(1);
        this.l.sendEmptyMessageDelayed(1, Util.MILLSECONDS_OF_MINUTE);
    }

    public d(EnterForumActivity enterForumActivity, BaseFragmentActivity baseFragmentActivity, j jVar) {
        this.d = enterForumActivity;
        this.e = baseFragmentActivity;
        this.k = jVar;
        this.i = (ImageView) this.d.i().findViewById(R.id.enter_group_new);
        if (!l.b().c()) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        h();
        com.baidu.tieba.im.messageCenter.f.a().a(103003, this.o);
        com.baidu.tieba.im.messageCenter.f.a().a(-106, this.o);
        com.baidu.tieba.im.messageCenter.f.a().a(1001, this.n);
    }

    public void b() {
        com.baidu.tieba.im.messageCenter.f.a().a(this.o);
        com.baidu.tieba.im.messageCenter.f.a().a(this.n);
    }

    public a c() {
        return this.j;
    }

    private void h() {
        this.f1477a = (BdListView) this.d.i().findViewById(R.id.enter_group_lv_forum);
        this.f = new bi(this.d.i());
        this.j = new a(this.d);
        this.f.a(new f(this));
        this.f1477a.setAdapter((ListAdapter) this.j);
        this.f1477a.setOnItemClickListener(this);
        this.f1477a.setOnScrollListener(this);
    }

    public void a(TextView textView) {
        this.h = textView;
    }

    public void d() {
        if (TiebaApplication.B()) {
            this.f1477a.setPullRefresh(this.f);
            a(this.f);
        } else {
            this.f1477a.setPullRefresh(null);
        }
        if (TiebaApplication.B()) {
            l.b().a(true);
        }
        if (this.b == null) {
            this.b = new c();
            this.f1477a.b();
        } else if (this.c) {
            this.f1477a.b();
        }
        j();
        this.f1477a.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.h != null) {
            if (this.b.a() != null) {
                this.h.setEnabled(true);
            } else {
                this.h.setEnabled(false);
            }
        }
    }

    public void e() {
        this.f1477a.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f1477a != null && this.j != null) {
            if (TiebaApplication.B()) {
                if (this.j.b()) {
                    this.f1477a.setHeaderDividersEnabled(true);
                    this.f1477a.setFooterDividersEnabled(true);
                    return;
                }
                this.f1477a.setHeaderDividersEnabled(false);
                this.f1477a.setFooterDividersEnabled(false);
                return;
            }
            this.f1477a.setHeaderDividersEnabled(false);
            this.f1477a.setFooterDividersEnabled(false);
        }
    }

    public void f() {
        if (this.m != null) {
            this.m.removeCallbacks(this.p);
            this.m.postDelayed(this.p, 0L);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.m != null) {
                this.m.removeCallbacks(this.p);
                this.m.postDelayed(this.p, 300L);
            }
        } else if (this.m != null) {
            this.m.removeCallbacks(this.p);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f1477a.getAdapter() != null && i2 < this.f1477a.getAdapter().getCount() && this.g == null) {
            this.g = new q(this.e);
            this.g.setHeightDip(30);
            this.f1477a.addFooterView(this.g);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.j.getItem(i);
        if (item != null) {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.d.i(), "cl_enter_group", "click", 1);
            }
            MsglistActivity.a(this.d.i(), item.getGroupId(), item.getName(), item.getAuthorId());
        }
    }

    public void g() {
        if (this.c) {
            this.f1477a.b();
        }
        f();
    }

    private void a(bi biVar) {
        biVar.a(TiebaApplication.g().ap());
    }

    public void a(int i) {
        if (i == 1) {
            this.f1477a.setDivider(this.d.j().getDrawable(R.drawable.list_divider_1));
        } else {
            this.f1477a.setDivider(this.d.j().getDrawable(R.drawable.list_divider));
        }
    }
}
