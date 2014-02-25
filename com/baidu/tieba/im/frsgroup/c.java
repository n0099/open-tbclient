package com.baidu.tieba.im.frsgroup;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.bv;
import com.baidu.tieba.im.message.cy;
import com.baidu.tieba.view.ct;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.j implements AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.r, com.baidu.tieba.im.messageCenter.g {
    private FrsGroupActivity b;
    private com.baidu.tieba.im.model.d c;
    private i d;
    private BdListView e;
    private Button f;
    private ct g;
    private InitGuideView h;
    private GroupListAdapter i;
    private Handler j;
    private int k;
    private boolean l;
    private Runnable m = new d(this);
    private com.baidu.tieba.im.messageCenter.g n = new e(this);

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (FrsGroupActivity) getActivity();
        this.c = this.b.e();
        this.d = this.b.f();
        this.j = new Handler();
        this.c.a(this.n);
        com.baidu.tieba.im.messageCenter.e.a().a(103104, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-141, this);
        com.baidu.tieba.im.messageCenter.e.a().a(103105, this);
    }

    private void c() {
        this.c.a(this.n);
        if (!this.c.b(getTag()) || this.l) {
            f();
        }
    }

    private void d() {
        this.c.b(this.n);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        if (z) {
            d();
        } else {
            c();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.im_frsgroup_list, (ViewGroup) null);
        this.h = (InitGuideView) inflate.findViewById(R.id.group_guide);
        this.f = (Button) inflate.findViewById(R.id.guide_create);
        this.e = (BdListView) inflate.findViewById(R.id.group_list);
        this.g = new ct(this.b);
        this.e.setPullRefresh(this.g);
        this.i = new GroupListAdapter(this.b);
        this.e.setAdapter((ListAdapter) this.i);
        this.e.setOnScrollListener(this);
        this.e.setOnSrollToBottomListener(this);
        this.g.a(new f(this));
        this.e.setOnItemClickListener(new g(this));
        this.f.setOnClickListener(new h(this));
        this.h.setCreateButton(this.f);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        switch (this.c.g()) {
            case 1:
            default:
                return 4;
            case 2:
                return 5;
            case 3:
                return 6;
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.h.b()) {
            this.h.f();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.h.g();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.c.b(this.n);
        com.baidu.tieba.im.messageCenter.e.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.c.a(this.c.m(), this.c.j(), this.c.k(), this.c.l(), this.c.b(), this.c.c());
        } else {
            this.c.b(this.c.m(), this.c.j(), this.c.k(), this.c.l(), this.c.b(), this.c.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.c.f();
        this.c.a(true);
        this.i.a(false);
        this.k = 0;
        this.c.b(0);
        this.c.d(50);
        this.e.b();
    }

    private void g() {
        this.c.f();
        this.c.a(false);
        this.k = 0;
        this.h.a();
        this.i.a(true);
        this.c.b(0);
        this.c.d(50);
        this.e.b();
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        h();
    }

    private void h() {
        if (this.i.c()) {
            a(true);
        }
    }

    @Override // com.baidu.tieba.j, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.j != null) {
                this.j.removeCallbacks(this.m);
                this.j.postDelayed(this.m, 300L);
            }
        } else if (this.j != null) {
            this.j.removeCallbacks(this.m);
        }
    }

    @Override // com.baidu.tieba.j, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.c.h()) {
            this.e.a();
        }
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        super.c(i);
        if (i == 1) {
            this.e.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
        } else {
            this.e.setDivider(getResources().getDrawable(R.drawable.list_divider));
        }
        this.g.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.h.b()) {
            this.h.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.j != null) {
            this.j.removeCallbacks(this.m);
            this.j.postDelayed(this.m, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int al = TiebaApplication.g().al();
        if (!z) {
            this.e.setDivider(getResources().getDrawable(17170445));
        } else if (al == 1) {
            this.e.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
        } else {
            this.e.setDivider(getResources().getDrawable(R.drawable.list_divider));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        b(false);
        this.h.f();
        switch (this.c.g()) {
            case 1:
                this.h.c();
                return;
            case 2:
                this.h.a(this.c.d());
                return;
            case 3:
                this.h.b(this.c.d());
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        GroupNewsPojo a;
        if (sVar != null) {
            if (sVar instanceof bv) {
                bv bvVar = (bv) sVar;
                if (!bvVar.l()) {
                    a(bvVar.a());
                }
            } else if (sVar instanceof cy) {
                cy cyVar = (cy) sVar;
                if (!cyVar.l() || cyVar.m() == 2230110) {
                    g();
                }
            } else if ((sVar instanceof com.baidu.tieba.im.message.aa) && (a = ((com.baidu.tieba.im.message.aa) sVar).a()) != null && !TextUtils.isEmpty(a.getCmd()) && a.getCmd().equals("dismiss_group")) {
                a(Long.parseLong(a.getGid()));
            }
        }
    }

    private void a(long j) {
        ArrayList<GroupInfoData> a = this.i.a();
        if (a != null) {
            int size = a.size();
            for (int i = 0; i < size; i++) {
                if (a.get(i).getGroupId() == j) {
                    if (b()) {
                        f();
                        return;
                    } else {
                        this.l = true;
                        return;
                    }
                }
            }
        }
    }
}
