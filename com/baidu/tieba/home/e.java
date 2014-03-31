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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.data.x;
import com.baidu.tieba.square.BarFolderFirstDirActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class e extends com.baidu.tbadk.core.d implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.d {
    private com.baidu.tbadk.core.e g;
    private n a = null;
    private j b = null;
    private com.baidu.tieba.model.o c = null;
    private x d = null;
    private boolean e = true;
    private Boolean f = false;
    private long h = -1;
    private final com.baidu.tieba.model.r i = new f(this);
    private final View.OnKeyListener j = new h(this);
    private final com.baidu.adp.widget.ListView.d k = new i(this);

    @Override // com.baidu.tbadk.core.d, android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.a.o() || dialogInterface == this.a.p()) {
            switch (i) {
                case 0:
                    if (this.d != null) {
                        String b = this.d.b();
                        if (bc.b(b)) {
                            sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this.g).a(b, "tb_forumlist")));
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    if (this.d != null) {
                        if (this.d.e() == 1) {
                            this.a.n();
                            return;
                        } else if (this.b == null) {
                            this.b = new j(this, this.d);
                            this.b.execute(new x[0]);
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
        this.g = (com.baidu.tbadk.core.e) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.a.i.enter_forum_view, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.h = System.currentTimeMillis();
        this.a = new n(this.g, this, this.j);
        this.a.a(this.k);
        getArguments();
        this.e = true;
        this.f = false;
        this.c = new com.baidu.tieba.model.o();
        this.c.a(this.i);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStop() {
        super.onStop();
        n nVar = this.a;
        n.h();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (!isShow()) {
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void onPrimary() {
        boolean z;
        boolean z2;
        boolean z3;
        super.onPrimary();
        this.a.g();
        if (this.c != null) {
            boolean booleanValue = this.f.booleanValue();
            this.f = Boolean.valueOf((TbadkApplication.E() == null || TbadkApplication.O() == null) ? false : true);
            if (this.e) {
                this.e = false;
                z = true;
                z2 = false;
            } else if (booleanValue != this.f.booleanValue()) {
                z = false;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            if (com.baidu.tieba.r.c().m()) {
                com.baidu.tieba.r.c().e(false);
                z3 = true;
            } else {
                z3 = z2;
            }
            if (com.baidu.tieba.r.c().h() > 0) {
                if (this.c != null && this.c.e() != null && this.c.e().f() != null) {
                    Iterator<x> it = this.c.e().f().a().iterator();
                    while (it.hasNext()) {
                        x next = it.next();
                        if (com.baidu.tieba.r.c().a(next.b())) {
                            next.a(1);
                            int c = com.baidu.tieba.r.c().c(next.b());
                            if (c > 0) {
                                next.b(c);
                            }
                        }
                    }
                }
                com.baidu.tieba.r.c().g();
                String E = TbadkApplication.E();
                if (E != null && E.length() > 0) {
                    com.baidu.tieba.util.k.b(E);
                }
                this.a.f();
            }
            if (z || z3) {
                a();
                if (z3) {
                    this.a.a();
                } else {
                    this.c.b(this.f.booleanValue());
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
            sendMessage(new com.baidu.adp.framework.message.a(2015002, new com.baidu.tbadk.core.frameworkData.a(this.g)));
            return;
        }
        int id = view.getId();
        n nVar = this.a;
        if (id != n.j()) {
            int id2 = view.getId();
            n nVar2 = this.a;
            if (id2 != n.k()) {
                if (view.getId() == com.baidu.tieba.a.h.square_all_cat) {
                    TiebaStatic.a(this.g, "enter_icon_category", "click", 1, new Object[0]);
                    BarFolderFirstDirActivity.a(this.g, "enter_icon_category");
                    return;
                }
                return;
            }
        }
        x xVar = null;
        if (view.getTag() instanceof x) {
            xVar = (x) view.getTag();
        }
        if (xVar != null) {
            String b = xVar.b();
            if (bc.b(b)) {
                TiebaStatic.a(this.g, "ef_recent", "click", 1, new Object[0]);
                sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this.g).a(b, "tb_forumlist")));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (r1 == com.baidu.tieba.home.n.k()) goto L7;
     */
    @Override // com.baidu.tbadk.core.d, android.view.View.OnLongClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onLongClick(View view) {
        int id = view.getId();
        n nVar = this.a;
        if (id != n.j()) {
            int id2 = view.getId();
            n nVar2 = this.a;
        }
        this.d = null;
        x xVar = view.getTag() instanceof x ? (x) view.getTag() : null;
        if (xVar != null) {
            this.d = xVar;
            String b = xVar.b();
            int e = xVar.e();
            if (bc.b(b)) {
                if (e == 1) {
                    this.a.l();
                } else {
                    this.a.m();
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
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    private void a() {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        this.c.cancelLoadData();
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
