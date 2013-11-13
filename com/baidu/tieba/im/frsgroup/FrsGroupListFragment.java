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
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.bi;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class FrsGroupListFragment extends BaseFragment implements AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.r {
    private int Y;

    /* renamed from: a  reason: collision with root package name */
    private FrsGroupActivity f1636a;
    private com.baidu.tieba.im.model.b b;
    private g c;
    private BdListView d;
    private Button e;
    private bi f;
    private InitGuideView g;
    private GroupListAdapter h;
    private Handler i;
    private Runnable Z = new e(this);
    private com.baidu.tieba.im.messageCenter.h aa = new f(this);

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f1636a = (FrsGroupActivity) i();
        this.b = this.f1636a.c();
        this.c = this.f1636a.d();
        this.i = new Handler();
        this.b.a(this.aa);
    }

    private void G() {
        this.b.a(this.aa);
        if (!this.b.b(g())) {
            J();
        }
    }

    private void H() {
        this.b.b(this.aa);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void b(boolean z) {
        if (z) {
            H();
        } else {
            G();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.im_frsgroup_list, (ViewGroup) null);
        this.g = (InitGuideView) inflate.findViewById(R.id.group_guide);
        this.e = (Button) inflate.findViewById(R.id.guide_create);
        this.d = (BdListView) inflate.findViewById(R.id.group_list);
        this.f = new bi(this.f1636a);
        this.d.setPullRefresh(this.f);
        this.h = new GroupListAdapter(this.f1636a);
        this.d.setAdapter((ListAdapter) this.h);
        this.d.setOnScrollListener(this);
        this.d.setOnSrollToBottomListener(this);
        this.f.a(new b(this));
        this.d.setOnItemClickListener(new c(this));
        this.e.setOnClickListener(new d(this));
        this.g.setCreateButton(this.e);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void a(View view, Bundle bundle) {
        super.a(view, bundle);
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I() {
        switch (this.b.g()) {
            case 1:
            default:
                return 4;
            case 2:
                return 5;
            case 3:
                return 6;
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void c_() {
        super.c_();
        if (this.g.b()) {
            this.g.g();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d() {
        super.d();
        this.g.h();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        super.t();
        this.b.b(this.aa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.b.a(this.b.m(), this.b.j(), this.b.k(), this.b.l(), this.b.b(), this.b.c());
        } else {
            this.b.b(this.b.m(), this.b.j(), this.b.k(), this.b.l(), this.b.b(), this.b.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.c.b(false);
        this.b.f();
        this.b.a(true);
        this.h.a(false);
        this.Y = 0;
        this.b.b(0);
        this.b.d(50);
        this.d.b();
    }

    private void K() {
        this.c.b(false);
        this.b.f();
        this.b.a(false);
        this.Y = 0;
        this.g.a();
        this.h.a(true);
        this.b.b(0);
        this.b.d(50);
        this.d.b();
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        L();
    }

    private void L() {
        if (this.h.b()) {
            a(true);
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.i != null) {
                this.i.removeCallbacks(this.Z);
                this.i.postDelayed(this.Z, 300L);
            }
        } else if (this.i != null) {
            this.i.removeCallbacks(this.Z);
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (this.b.h()) {
            this.d.a();
        }
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
        if (i == 1) {
            this.d.setDivider(j().getDrawable(R.drawable.list_divider_1));
        } else {
            this.d.setDivider(j().getDrawable(R.drawable.list_divider));
        }
        this.f.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (this.g.b()) {
            this.g.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (this.i != null) {
            this.i.removeCallbacks(this.Z);
            this.i.postDelayed(this.Z, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z) {
        int ap = TiebaApplication.g().ap();
        if (!z) {
            this.d.setDivider(j().getDrawable(17170445));
        } else if (ap == 1) {
            this.d.setDivider(j().getDrawable(R.drawable.list_divider_1));
        } else {
            this.d.setDivider(j().getDrawable(R.drawable.list_divider));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        e(false);
        this.g.g();
        switch (this.b.g()) {
            case 1:
                this.g.c();
                return;
            case 2:
                this.g.d();
                return;
            case 3:
                this.g.a(this.b.d());
                return;
            default:
                return;
        }
    }
}
