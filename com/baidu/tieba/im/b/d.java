package com.baidu.tieba.im.b;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.home.EnterForumActivity;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.view.bb;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Timer;
/* loaded from: classes.dex */
public class d implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    public c b;
    public boolean c;
    private EnterForumActivity d;
    private Button f;
    private TextView g;
    private a h;
    private n i;
    private bb e = null;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f1381a = null;
    private Handler j = new e(this);
    private Handler k = new Handler();
    private com.baidu.tieba.im.messageCenter.h l = new i(this);
    private com.baidu.tieba.im.messageCenter.h m = new j(this);
    private Runnable n = new k(this);

    public void a() {
        this.j.removeMessages(1);
        this.j.sendEmptyMessageDelayed(1, Util.MILLSECONDS_OF_MINUTE);
    }

    public d(EnterForumActivity enterForumActivity, n nVar) {
        this.d = enterForumActivity;
        this.i = nVar;
        i();
        com.baidu.tieba.im.messageCenter.f.a().a(103003, this.m);
        com.baidu.tieba.im.messageCenter.f.a().a(-106, this.m);
        com.baidu.tieba.im.messageCenter.f.a().a(1001, this.l);
    }

    public void b() {
        com.baidu.tieba.im.messageCenter.f.a().a(this.m);
        com.baidu.tieba.im.messageCenter.f.a().a(this.l);
    }

    public a c() {
        return this.h;
    }

    private void i() {
        this.f = (Button) this.d.findViewById(R.id.btn_create_group);
        this.f.setOnClickListener(this.d);
        this.g = (TextView) this.d.findViewById(R.id.enter_group);
        this.f1381a = (BdListView) this.d.findViewById(R.id.enter_group_lv_forum);
        this.e = new bb(this.d);
        this.h = new a(this.d);
        this.e.a(new f(this));
        this.f1381a.setAdapter((ListAdapter) this.h);
        this.f1381a.setOnItemClickListener(this);
        this.f1381a.setOnScrollListener(this);
    }

    public void d() {
        if (TiebaApplication.D()) {
            this.f1381a.setPullRefresh(this.e);
            a(this.e);
        } else {
            this.f1381a.setPullRefresh(null);
        }
        if (TiebaApplication.D()) {
            if (!com.baidu.tieba.im.l.b().d()) {
                new Timer().schedule(new g(this), 300L);
            }
            com.baidu.tieba.im.l.b().a(true);
        }
        if (this.b == null) {
            this.b = new c();
            this.f1381a.b();
        } else if (this.c) {
            this.f1381a.b();
        }
        k();
        this.f.setVisibility(0);
        com.baidu.tieba.util.bb.f((View) this.f, (int) R.drawable.btn_step);
        j();
        com.baidu.tieba.util.bb.f((View) this.g, (int) R.drawable.btn_baidu_s);
        this.f1381a.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.b.a() != null) {
            this.f.setEnabled(true);
        } else {
            this.f.setEnabled(false);
        }
    }

    public void e() {
        com.baidu.tieba.util.bb.f((View) this.g, (int) R.drawable.btn_baidu_n);
        this.f1381a.setVisibility(8);
        this.f.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f1381a != null && this.h != null) {
            if (TiebaApplication.D()) {
                if (this.h.b()) {
                    this.f1381a.setHeaderDividersEnabled(true);
                    this.f1381a.setFooterDividersEnabled(true);
                    return;
                }
                this.f1381a.setHeaderDividersEnabled(false);
                this.f1381a.setFooterDividersEnabled(false);
                return;
            }
            this.f1381a.setHeaderDividersEnabled(false);
            this.f1381a.setFooterDividersEnabled(false);
        }
    }

    public void f() {
        if (this.k != null) {
            this.k.removeCallbacks(this.n);
            this.k.postDelayed(this.n, 0L);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.k != null) {
                this.k.removeCallbacks(this.n);
                this.k.postDelayed(this.n, 300L);
            }
        } else if (this.k != null) {
            this.k.removeCallbacks(this.n);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.h.getItem(i);
        if (item != null) {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.d, "cl_enter_group", "click", 1);
            }
            MsglistActivity.a(this.d, item.getGroupId(), item.getName(), item.getAuthorId());
        }
    }

    public void g() {
        if (TiebaApplication.g().as() != 1) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(R.id.btn_create_group).a(150).a(true);
            l lVar = new l(this);
            gVar.a(lVar).a(new m(this));
            gVar.a().a(this.d);
        }
    }

    public void h() {
        if (this.c) {
            this.f1381a.b();
        }
        f();
    }

    private void a(bb bbVar) {
        bbVar.a(TiebaApplication.g().as());
    }

    public void a(int i) {
        if (i == 1) {
            this.f1381a.setDivider(this.d.getResources().getDrawable(R.drawable.list_divider_1));
        } else {
            this.f1381a.setDivider(this.d.getResources().getDrawable(R.drawable.list_divider));
        }
    }
}
