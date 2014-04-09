package com.baidu.tieba.im.frsgroup;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b extends com.baidu.tbadk.core.d implements AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.t {
    private FrsGroupActivity b;
    private com.baidu.tieba.im.model.k c;
    private k d;
    private BdListView e;
    private Button f;
    private com.baidu.tbadk.core.view.q g;
    private InitGuideView h;
    private GroupListAdapter i;
    private Handler j;
    private int k;
    private boolean l;
    private final Runnable m = new c(this);
    private final com.baidu.adp.framework.c.g n = new d(this, 103002);
    private final com.baidu.adp.framework.c.a o = new e(this, 2001201);
    private final com.baidu.adp.framework.c.g p = new f(this, 0);
    private final com.baidu.adp.framework.c.a q = new g(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (FrsGroupActivity) getActivity();
        this.c = this.b.f();
        this.d = this.b.g();
        this.j = new Handler();
        this.c.registerListener(this.n);
        this.c.registerListener(this.o);
        com.baidu.adp.framework.c.a().a(103104, this.p);
        com.baidu.adp.framework.c.a().a(103105, this.p);
        com.baidu.adp.framework.c.a().a(2001141, this.q);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onHiddenChanged(boolean z) {
        if (z) {
            com.baidu.tieba.im.model.k kVar = this.c;
            com.baidu.adp.framework.c.a().b(this.n);
            com.baidu.tieba.im.model.k kVar2 = this.c;
            com.baidu.adp.framework.c.a().b(this.o);
            return;
        }
        this.c.registerListener(this.n);
        this.c.registerListener(this.o);
        if (!this.c.b(getTag()) || this.l) {
            a();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.baidu.tieba.im.i.im_frsgroup_list, (ViewGroup) null);
        this.h = (InitGuideView) inflate.findViewById(com.baidu.tieba.im.h.group_guide);
        this.f = (Button) inflate.findViewById(com.baidu.tieba.im.h.guide_create);
        this.e = (BdListView) inflate.findViewById(com.baidu.tieba.im.h.group_list);
        this.g = new com.baidu.tbadk.core.view.q(this.b);
        this.e.setPullRefresh(this.g);
        this.i = new GroupListAdapter(this.b);
        this.e.setAdapter((ListAdapter) this.i);
        this.e.setOnScrollListener(this);
        this.e.setOnSrollToBottomListener(this);
        this.g.a(new h(this));
        this.e.setOnItemClickListener(new i(this));
        this.f.setOnClickListener(new j(this));
        this.h.setCreateButton(this.f);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int m(b bVar) {
        switch (bVar.c.g()) {
            case 1:
            default:
                return 4;
            case 2:
                return 5;
            case 3:
                return 6;
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
        if (this.h.b()) {
            this.h.e();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStop() {
        super.onStop();
        this.h.f();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.model.k kVar = this.c;
        com.baidu.adp.framework.c.a().b(this.n);
        com.baidu.adp.framework.c.a().b(this.q);
        com.baidu.adp.framework.c.a().b(this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.c.a(this.c.l(), this.c.i(), this.c.j(), this.c.k(), this.c.b(), this.c.c());
        } else {
            this.c.b(this.c.l(), this.c.i(), this.c.j(), this.c.k(), this.c.b(), this.c.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.c.f();
        this.c.a(true);
        this.i.a(false);
        this.k = 0;
        this.c.b(0);
        this.c.d(50);
        this.e.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.c.f();
        this.c.a(false);
        this.k = 0;
        this.h.a();
        this.i.a(true);
        this.c.b(0);
        this.c.d(50);
        this.e.c();
    }

    @Override // com.baidu.adp.widget.ListView.t
    public final void b() {
        if (this.i.c()) {
            a(true);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.j != null) {
                this.j.removeCallbacks(this.m);
                this.j.postDelayed(this.m, 300L);
            }
        } else if (this.j != null) {
            this.j.removeCallbacks(this.m);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(b bVar) {
        if (bVar.c.h()) {
            bVar.e.b();
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void c(int i) {
        super.c(i);
        if (i == 1) {
            this.e.setDivider(getResources().getDrawable(com.baidu.tieba.im.g.list_divider_1));
        } else {
            this.e.setDivider(getResources().getDrawable(com.baidu.tieba.im.g.list_divider));
        }
        this.g.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(b bVar) {
        if (bVar.h.b()) {
            bVar.h.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(b bVar) {
        if (bVar.j != null) {
            bVar.j.removeCallbacks(bVar.m);
            bVar.j.postDelayed(bVar.m, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        int l = TbadkApplication.j().l();
        if (!z) {
            this.e.setDivider(getResources().getDrawable(17170445));
        } else if (l == 1) {
            this.e.setDivider(getResources().getDrawable(com.baidu.tieba.im.g.list_divider_1));
        } else {
            this.e.setDivider(getResources().getDrawable(com.baidu.tieba.im.g.list_divider));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(b bVar) {
        bVar.c(false);
        bVar.h.e();
        switch (bVar.c.g()) {
            case 1:
                bVar.h.c();
                return;
            case 2:
                bVar.h.a(bVar.c.d());
                return;
            case 3:
                bVar.h.b(bVar.c.d());
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar, long j) {
        ArrayList<GroupInfoData> a = bVar.i.a();
        if (a != null) {
            int size = a.size();
            for (int i = 0; i < size; i++) {
                if (a.get(i).getGroupId() == j) {
                    if (bVar.c_()) {
                        bVar.a();
                        return;
                    } else {
                        bVar.l = true;
                        return;
                    }
                }
            }
        }
    }
}
