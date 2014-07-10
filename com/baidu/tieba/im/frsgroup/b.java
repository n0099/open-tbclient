package com.baidu.tieba.im.frsgroup;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.core.d implements AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.x {
    private FrsGroupActivity b;
    private com.baidu.tieba.im.model.i c;
    private k d;
    private BdListView e;
    private Button f;
    private com.baidu.tbadk.core.view.q g;
    private InitGuideView h;
    private GroupListAdapter i;
    private Handler j;
    private boolean k;
    private final Runnable l = new c(this);
    private final com.baidu.adp.framework.listener.b m = new d(this, 103002);
    private final CustomMessageListener n = new e(this, 2001201);
    private final com.baidu.adp.framework.listener.b o = new f(this, 0);
    private final CustomMessageListener p = new g(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (FrsGroupActivity) getActivity();
        this.c = this.b.g();
        this.d = this.b.h();
        this.j = new Handler();
        this.c.registerListener(this.m);
        this.c.registerListener(this.n);
        MessageManager.getInstance().registerListener(103104, this.o);
        MessageManager.getInstance().registerListener(103105, this.o);
        MessageManager.getInstance().registerListener(2001141, this.p);
    }

    private void f() {
        this.c.registerListener(this.m);
        this.c.registerListener(this.n);
        if (!this.c.b(getTag()) || this.k) {
            i();
        }
    }

    private void g() {
        this.c.a(this.m);
        this.c.a(this.n);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        if (z) {
            g();
        } else {
            f();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.im_frsgroup_list, (ViewGroup) null);
        this.h = (InitGuideView) inflate.findViewById(com.baidu.tieba.v.group_guide);
        this.f = (Button) inflate.findViewById(com.baidu.tieba.v.guide_create);
        this.e = (BdListView) inflate.findViewById(com.baidu.tieba.v.group_list);
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
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h() {
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

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.h.b()) {
            this.h.f();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.h.g();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.c.a(this.m);
        MessageManager.getInstance().unRegisterListener(this.p);
        MessageManager.getInstance().unRegisterListener(this.p);
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
    public void i() {
        this.c.f();
        this.c.a(true);
        this.i.a(false);
        this.c.b(0);
        this.c.d(50);
        this.e.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.c.f();
        this.c.a(false);
        this.h.a();
        this.i.a(true);
        this.c.b(0);
        this.c.d(50);
        this.e.e();
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        k();
    }

    private void k() {
        if (this.i.c()) {
            a(true);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.j != null) {
                this.j.removeCallbacks(this.l);
                this.j.postDelayed(this.l, 90L);
            }
        } else if (this.j != null) {
            this.j.removeCallbacks(this.l);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.c.h()) {
            this.e.d();
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        if (i == 1) {
            this.e.setDivider(getResources().getDrawable(com.baidu.tieba.u.list_divider_1));
        } else {
            this.e.setDivider(getResources().getDrawable(com.baidu.tieba.u.list_divider));
        }
        this.g.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.h.b()) {
            this.h.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.j != null) {
            this.j.removeCallbacks(this.l);
            this.j.postDelayed(this.l, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (!z) {
            this.e.setDivider(getResources().getDrawable(17170445));
        } else if (skinType == 1) {
            this.e.setDivider(getResources().getDrawable(com.baidu.tieba.u.list_divider_1));
        } else {
            this.e.setDivider(getResources().getDrawable(com.baidu.tieba.u.list_divider));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        c(false);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        ArrayList<GroupInfoData> a = this.i.a();
        if (a != null) {
            int size = a.size();
            for (int i = 0; i < size; i++) {
                if (a.get(i).getGroupId() == j) {
                    if (d_()) {
                        i();
                        return;
                    } else {
                        this.k = true;
                        return;
                    }
                }
            }
        }
    }
}
