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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.aq;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.ad;
import com.baidu.tieba.data.ac;
import com.baidu.tieba.data.x;
import com.baidu.tieba.square.BarFolderFirstDirActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.core.d implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.d {
    private com.baidu.tbadk.core.e h;
    private p b = null;
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
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.b.s() || dialogInterface == this.b.t()) {
            switch (i) {
                case 0:
                    if (this.e != null) {
                        String b = this.e.b();
                        if (be.b(b)) {
                            a(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(this.h).a(b, "tb_forumlist")));
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    f();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    private void f() {
        if (this.e != null) {
            if (this.e.e() == 1) {
                this.b.r();
            } else if (this.c == null) {
                this.c = new k(this, this.e);
                this.c.execute(new x[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.h = (com.baidu.tbadk.core.e) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.i = System.currentTimeMillis();
        g();
        a(getArguments());
    }

    private View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.s.enter_forum_view, (ViewGroup) null);
    }

    private void g() {
        this.b = new p(this.h, this, this.k);
        this.b.a(this.l);
        this.b.a(new j(this));
        this.b.e().setOnClickListener(this);
    }

    private void a(Bundle bundle) {
        this.f = true;
        this.g = false;
        this.d = new com.baidu.tieba.model.o();
        this.d.a(this.j);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.b.j();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbadkApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new aq(getActivity(), aq.c)));
            getActivity().finish();
        }
        if (!d_()) {
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void e() {
        super.e();
        this.b.i();
        a(false);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        a();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.r.search_bg_layout) {
            a(new CustomMessage(2017002, new com.baidu.tbadk.core.frameworkData.a(this.h)));
        } else if (view.getId() == this.b.l() || view.getId() == this.b.m()) {
            x xVar = view.getTag() instanceof x ? (x) view.getTag() : null;
            if (xVar != null) {
                String b = xVar.b();
                if (be.b(b)) {
                    TiebaStatic.eventStat(this.h, "ef_recent", "click", 1, new Object[0]);
                    a(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(this.h).a(b, "tb_forumlist")));
                }
            }
        } else if (view.getId() == this.b.n() || view.getId() == this.b.o()) {
            ac acVar = view.getTag() instanceof ac ? (ac) view.getTag() : null;
            if (acVar != null) {
                String a = acVar.a();
                if (be.b(a)) {
                    a(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(this.h).a(a, "tb_forumlist")));
                }
            }
        } else if (view.getId() == com.baidu.tieba.r.square_all_cat) {
            TiebaStatic.eventStat(this.h, "enter_icon_category", "click", 1, new Object[0]);
            BarFolderFirstDirActivity.a(this.h, "enter_icon_category");
        } else if (view == this.b.e()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2017002, new com.baidu.tbadk.core.frameworkData.a(this.h)));
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.b.l() || view.getId() == this.b.m()) {
            this.e = null;
            x xVar = view.getTag() instanceof x ? (x) view.getTag() : null;
            if (xVar != null) {
                this.e = xVar;
                String b = xVar.b();
                int e = xVar.e();
                if (be.b(b)) {
                    if (e == 1) {
                        this.b.p();
                    } else {
                        this.b.q();
                    }
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        this.b.a(i);
    }

    public void a() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
        this.d.cancelLoadData();
    }

    public void a(boolean z) {
        boolean z2;
        boolean z3;
        if (this.d != null) {
            boolean booleanValue = this.g.booleanValue();
            this.g = Boolean.valueOf((TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccountName() == null) ? false : true);
            if (this.f) {
                this.f = false;
                z2 = true;
                z3 = false;
            } else if (booleanValue != this.g.booleanValue()) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (ad.c().q()) {
                ad.c().e(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (ad.c().i() > 0) {
                if (this.d != null && this.d.e() != null && this.d.e().g() != null) {
                    Iterator<x> it = this.d.e().g().a().iterator();
                    while (it.hasNext()) {
                        x next = it.next();
                        if (ad.c().a(next.b())) {
                            next.a(1);
                            int c = ad.c().c(next.b());
                            if (c > 0) {
                                next.b(c);
                            }
                        }
                    }
                }
                ad.c().h();
                String currentAccount = TbadkApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    com.baidu.tieba.util.k.b(currentAccount);
                }
                this.b.h();
            }
            if (z2 || z4) {
                a();
                if (z4) {
                    this.b.b();
                } else {
                    this.d.b(this.g.booleanValue());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }
}
