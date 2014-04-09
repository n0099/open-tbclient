package com.baidu.tieba.home;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.ad;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.data.x;
import com.baidu.tieba.square.BarFolderFirstDirActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class e extends com.baidu.tbadk.core.d implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.d {
    private com.baidu.tbadk.core.e h;
    private o b = null;
    private k c = null;
    private com.baidu.tieba.model.o d = null;
    private x e = null;
    private boolean f = true;
    private Boolean g = false;
    private long i = -1;
    private final com.baidu.tieba.model.r j = new f(this);
    private final View.OnKeyListener k = new h(this);
    private final com.baidu.adp.widget.ListView.d l = new i(this);

    @Override // com.baidu.tbadk.core.d, android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.b.p() || dialogInterface == this.b.q()) {
            switch (i) {
                case 0:
                    if (this.e != null) {
                        String b = this.e.b();
                        if (bc.b(b)) {
                            a(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this.h).a(b, "tb_forumlist")));
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    if (this.e != null) {
                        if (this.e.e() == 1) {
                            this.b.o();
                            return;
                        } else if (this.c == null) {
                            this.c = new k(this, this.e);
                            this.c.execute(new x[0]);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.h = (com.baidu.tbadk.core.e) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.a.i.enter_forum_view, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.i = System.currentTimeMillis();
        this.b = new o(this.h, this, this.k);
        this.b.a(this.l);
        this.b.a(new j(this));
        this.b.e().setOnClickListener(this);
        getArguments();
        this.f = true;
        this.g = false;
        this.d = new com.baidu.tieba.model.o();
        this.d.a(this.j);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStop() {
        super.onStop();
        o oVar = this.b;
        o.i();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (!TbadkApplication.F()) {
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new ad(getActivity(), ad.c)));
        }
        if (!c_()) {
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void d() {
        boolean z;
        boolean z2;
        boolean z3;
        super.d();
        this.b.h();
        if (this.d != null) {
            boolean booleanValue = this.g.booleanValue();
            this.g = Boolean.valueOf((TbadkApplication.E() == null || TbadkApplication.O() == null) ? false : true);
            if (this.f) {
                this.f = false;
                z = true;
                z2 = false;
            } else if (booleanValue != this.g.booleanValue()) {
                z = false;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            if (com.baidu.tieba.p.c().m()) {
                com.baidu.tieba.p.c().e(false);
                z3 = true;
            } else {
                z3 = z2;
            }
            if (com.baidu.tieba.p.c().h() > 0) {
                if (this.d != null && this.d.e() != null && this.d.e().f() != null) {
                    Iterator<x> it = this.d.e().f().a().iterator();
                    while (it.hasNext()) {
                        x next = it.next();
                        if (com.baidu.tieba.p.c().a(next.b())) {
                            next.a(1);
                            int c = com.baidu.tieba.p.c().c(next.b());
                            if (c > 0) {
                                next.b(c);
                            }
                        }
                    }
                }
                com.baidu.tieba.p.c().g();
                String E = TbadkApplication.E();
                if (E != null && E.length() > 0) {
                    com.baidu.tieba.util.k.b(E);
                }
                this.b.g();
            }
            if (z || z3) {
                a();
                if (z3) {
                    this.b.a();
                } else {
                    this.d.b(this.g.booleanValue());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        a();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == com.baidu.tieba.a.h.search_bg_layout) {
            a(new com.baidu.adp.framework.message.a(2015002, new com.baidu.tbadk.core.frameworkData.a(this.h)));
            return;
        }
        int id = view.getId();
        o oVar = this.b;
        if (id != o.k()) {
            int id2 = view.getId();
            o oVar2 = this.b;
            if (id2 != o.l()) {
                if (view.getId() == com.baidu.tieba.a.h.square_all_cat) {
                    TiebaStatic.a(this.h, "enter_icon_category", "click", 1, new Object[0]);
                    BarFolderFirstDirActivity.a(this.h, "enter_icon_category");
                    return;
                } else if (view == this.b.e()) {
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2015002, new com.baidu.tbadk.core.frameworkData.a(this.h)));
                    return;
                } else {
                    return;
                }
            }
        }
        x xVar = null;
        if (view.getTag() instanceof x) {
            xVar = (x) view.getTag();
        }
        if (xVar != null) {
            String b = xVar.b();
            if (bc.b(b)) {
                TiebaStatic.a(this.h, "ef_recent", "click", 1, new Object[0]);
                a(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this.h).a(b, "tb_forumlist")));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (r1 == com.baidu.tieba.home.o.l()) goto L7;
     */
    @Override // com.baidu.tbadk.core.d, android.view.View.OnLongClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onLongClick(View view) {
        int id = view.getId();
        o oVar = this.b;
        if (id != o.k()) {
            int id2 = view.getId();
            o oVar2 = this.b;
        }
        this.e = null;
        x xVar = view.getTag() instanceof x ? (x) view.getTag() : null;
        if (xVar != null) {
            this.e = xVar;
            String b = xVar.b();
            int e = xVar.e();
            if (bc.b(b)) {
                if (e == 1) {
                    this.b.m();
                } else {
                    this.b.n();
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tbadk.core.d
    public final void c(int i) {
        super.c(i);
        this.b.a(i);
    }

    private void a() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
        this.d.cancelLoadData();
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar == null) {
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }
}
