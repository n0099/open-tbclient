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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.ae;
import com.baidu.tieba.data.z;
import com.baidu.tieba.square.BarFolderFirstDirActivity;
import com.baidu.tieba.v;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.core.d implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.d {
    private BaseFragmentActivity h;
    private p b = null;
    private k c = null;
    private com.baidu.tieba.model.n d = null;
    private z e = null;
    private boolean f = true;
    private Boolean g = false;
    private long i = -1;
    private final com.baidu.tieba.model.q j = new f(this);
    private final View.OnKeyListener k = new h(this);
    private final com.baidu.adp.widget.ListView.d l = new i(this);

    @Override // com.baidu.tbadk.core.d, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.b.t() || dialogInterface == this.b.u()) {
            switch (i) {
                case 0:
                    if (this.e != null) {
                        String b = this.e.b();
                        if (ba.b(b)) {
                            a(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(this.h).a(b, "tb_forumlist")));
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
                this.b.s();
            } else if (this.c == null) {
                this.c = new k(this, this.e);
                this.c.execute(new z[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.h = (BaseFragmentActivity) activity;
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
        return layoutInflater.inflate(v.enter_forum_view, (ViewGroup) null);
    }

    private void g() {
        this.b = new p(this.h, this, this.k);
        this.b.a(this.l);
        this.b.a(new j(this));
        this.b.f().setOnClickListener(this);
    }

    private void a(Bundle bundle) {
        this.f = true;
        this.g = false;
        this.d = new com.baidu.tieba.model.n();
        this.d.a(this.j);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.b.k();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!d_()) {
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void e() {
        super.e();
        if (!TbadkApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ba(getActivity(), com.baidu.tbadk.core.atomData.ba.c)));
            getActivity().finish();
        }
        this.b.j();
        a(false);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        a();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Hao123Plugin hao123Plugin;
        if (view.getId() == com.baidu.tieba.u.search_bg_layout) {
            a(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(this.h)));
        } else if (view.getId() == this.b.m() || view.getId() == this.b.n()) {
            z zVar = view.getTag() instanceof z ? (z) view.getTag() : null;
            if (zVar != null) {
                String b = zVar.b();
                if (ba.b(b)) {
                    TiebaStatic.eventStat(this.h, "ef_recent", "click", 1, new Object[0]);
                    a(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(this.h).a(b, "tb_forumlist")));
                }
            }
        } else if (view.getId() == this.b.o() || view.getId() == this.b.p()) {
            ae aeVar = view.getTag() instanceof ae ? (ae) view.getTag() : null;
            if (aeVar != null) {
                String a = aeVar.a();
                if (ba.b(a)) {
                    a(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(this.h).a(a, "tb_forumlist")));
                }
            }
        } else if (view.getId() == com.baidu.tieba.u.square_all_cat) {
            TiebaStatic.eventStat(this.h, "enter_icon_category", "click", 1, new Object[0]);
            BarFolderFirstDirActivity.a(this.h, "enter_icon_category");
        } else if (view == this.b.f()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(this.h)));
        } else if (view == this.b.c()) {
            this.b.w();
        } else if (view == this.b.b()) {
            TbadkApplication.m252getInst().setTiebaHelperOpen(true);
            com.baidu.tbadk.pluginArch.c a2 = com.baidu.tbadk.pluginArch.d.a().a("hao123");
            if (a2 != null && (hao123Plugin = (Hao123Plugin) a2.a(Hao123Plugin.class)) != null) {
                hao123Plugin.openFloating(this.h);
            }
            this.b.w();
            com.baidu.tbadk.core.f.a(this.h, "tb_zs_entering");
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.b.m() || view.getId() == this.b.n()) {
            this.e = null;
            z zVar = view.getTag() instanceof z ? (z) view.getTag() : null;
            if (zVar != null) {
                this.e = zVar;
                String b = zVar.b();
                int e = zVar.e();
                if (ba.b(b)) {
                    if (e == 1) {
                        this.b.q();
                    } else {
                        this.b.r();
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
            if (ai.c().p()) {
                ai.c().e(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (ai.c().i() > 0) {
                if (this.d != null && this.d.e() != null && this.d.e().g() != null) {
                    Iterator<z> it = this.d.e().g().a().iterator();
                    while (it.hasNext()) {
                        z next = it.next();
                        if (ai.c().a(next.b())) {
                            next.a(1);
                            int b = ai.c().b(next.b());
                            if (b > 0) {
                                next.b(b);
                            }
                        }
                    }
                }
                ai.c().h();
                String currentAccount = TbadkApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    com.baidu.tieba.util.k.b(currentAccount);
                }
                this.b.i();
            }
            if (z2 || z4) {
                a();
                if (z4) {
                    this.b.a();
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
