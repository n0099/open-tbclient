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
    private FrsGroupActivity a;
    private com.baidu.tieba.im.model.k b;
    private k c;
    private BdListView d;
    private Button e;
    private com.baidu.tbadk.core.view.q f;
    private InitGuideView g;
    private GroupListAdapter h;
    private Handler i;
    private int j;
    private boolean k;
    private final Runnable l = new c(this);
    private final com.baidu.adp.framework.c.g m = new d(this, 103002);
    private final com.baidu.adp.framework.c.a n = new e(this, 2001201);
    private final com.baidu.adp.framework.c.g o = new f(this, 0);
    private final com.baidu.adp.framework.c.a p = new g(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = (FrsGroupActivity) getActivity();
        this.b = this.a.f();
        this.c = this.a.g();
        this.i = new Handler();
        this.b.registerListener(this.m);
        this.b.registerListener(this.n);
        com.baidu.adp.framework.c.a().a(103104, this.o);
        com.baidu.adp.framework.c.a().a(103105, this.o);
        com.baidu.adp.framework.c.a().a(2001141, this.p);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onHiddenChanged(boolean z) {
        if (z) {
            com.baidu.tieba.im.model.k kVar = this.b;
            com.baidu.adp.framework.c.a().b(this.m);
            com.baidu.tieba.im.model.k kVar2 = this.b;
            com.baidu.adp.framework.c.a().b(this.n);
            return;
        }
        this.b.registerListener(this.m);
        this.b.registerListener(this.n);
        if (!this.b.b(getTag()) || this.k) {
            a();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.baidu.tieba.im.i.im_frsgroup_list, (ViewGroup) null);
        this.g = (InitGuideView) inflate.findViewById(com.baidu.tieba.im.h.group_guide);
        this.e = (Button) inflate.findViewById(com.baidu.tieba.im.h.guide_create);
        this.d = (BdListView) inflate.findViewById(com.baidu.tieba.im.h.group_list);
        this.f = new com.baidu.tbadk.core.view.q(this.a);
        this.d.setPullRefresh(this.f);
        this.h = new GroupListAdapter(this.a);
        this.d.setAdapter((ListAdapter) this.h);
        this.d.setOnScrollListener(this);
        this.d.setOnSrollToBottomListener(this);
        this.f.a(new h(this));
        this.d.setOnItemClickListener(new i(this));
        this.e.setOnClickListener(new j(this));
        this.g.setCreateButton(this.e);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int m(b bVar) {
        switch (bVar.b.g()) {
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
        if (this.g.b()) {
            this.g.e();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStop() {
        super.onStop();
        this.g.f();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.model.k kVar = this.b;
        com.baidu.adp.framework.c.a().b(this.m);
        com.baidu.adp.framework.c.a().b(this.p);
        com.baidu.adp.framework.c.a().b(this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.b.a(this.b.l(), this.b.i(), this.b.j(), this.b.k(), this.b.b(), this.b.c());
        } else {
            this.b.b(this.b.l(), this.b.i(), this.b.j(), this.b.k(), this.b.b(), this.b.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.b.f();
        this.b.a(true);
        this.h.a(false);
        this.j = 0;
        this.b.b(0);
        this.b.d(50);
        this.d.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.b.f();
        this.b.a(false);
        this.j = 0;
        this.g.a();
        this.h.a(true);
        this.b.b(0);
        this.b.d(50);
        this.d.c();
    }

    @Override // com.baidu.adp.widget.ListView.t
    public final void b() {
        if (this.h.c()) {
            a(true);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.i != null) {
                this.i.removeCallbacks(this.l);
                this.i.postDelayed(this.l, 300L);
            }
        } else if (this.i != null) {
            this.i.removeCallbacks(this.l);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(b bVar) {
        if (bVar.b.h()) {
            bVar.d.b();
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.d.setDivider(getResources().getDrawable(com.baidu.tieba.im.g.list_divider_1));
        } else {
            this.d.setDivider(getResources().getDrawable(com.baidu.tieba.im.g.list_divider));
        }
        this.f.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(b bVar) {
        if (bVar.g.b()) {
            bVar.g.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(b bVar) {
        if (bVar.i != null) {
            bVar.i.removeCallbacks(bVar.l);
            bVar.i.postDelayed(bVar.l, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int l = TbadkApplication.j().l();
        if (!z) {
            this.d.setDivider(getResources().getDrawable(17170445));
        } else if (l == 1) {
            this.d.setDivider(getResources().getDrawable(com.baidu.tieba.im.g.list_divider_1));
        } else {
            this.d.setDivider(getResources().getDrawable(com.baidu.tieba.im.g.list_divider));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(b bVar) {
        bVar.b(false);
        bVar.g.e();
        switch (bVar.b.g()) {
            case 1:
                bVar.g.c();
                return;
            case 2:
                bVar.g.a(bVar.b.d());
                return;
            case 3:
                bVar.g.b(bVar.b.d());
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar, long j) {
        ArrayList<GroupInfoData> a = bVar.h.a();
        if (a != null) {
            int size = a.size();
            for (int i = 0; i < size; i++) {
                if (a.get(i).getGroupId() == j) {
                    if (bVar.isShow()) {
                        bVar.a();
                        return;
                    } else {
                        bVar.k = true;
                        return;
                    }
                }
            }
        }
    }
}
