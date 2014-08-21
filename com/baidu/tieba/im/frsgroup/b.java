package com.baidu.tieba.im.frsgroup;

import android.os.Bundle;
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
    private j d;
    private BdListView e;
    private Button f;
    private com.baidu.tbadk.core.view.v g;
    private InitGuideView h;
    private GroupListAdapter i;
    private boolean j;
    private final com.baidu.adp.framework.listener.d k = new c(this, 103002);
    private final CustomMessageListener l = new d(this, 2001210);
    private final com.baidu.adp.framework.listener.d m = new e(this, 0);
    private final CustomMessageListener n = new f(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (FrsGroupActivity) getActivity();
        this.c = this.b.g();
        this.d = this.b.h();
        this.c.registerListener(this.k);
        this.c.registerListener(this.l);
        a(103104, this.m);
        a(103105, this.m);
        a(2001141, this.n);
    }

    private void f() {
        this.c.registerListener(this.k);
        this.c.registerListener(this.l);
        if (!this.c.b(getTag()) || this.j) {
            i();
        }
    }

    private void g() {
        this.c.a(this.k);
        this.c.a(this.l);
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
        View inflate = layoutInflater.inflate(com.baidu.tieba.v.im_frsgroup_list, (ViewGroup) null);
        this.h = (InitGuideView) inflate.findViewById(com.baidu.tieba.u.group_guide);
        this.f = (Button) inflate.findViewById(com.baidu.tieba.u.guide_create);
        this.e = (BdListView) inflate.findViewById(com.baidu.tieba.u.group_list);
        this.g = new com.baidu.tbadk.core.view.v(this.b);
        this.e.setPullRefresh(this.g);
        this.i = new GroupListAdapter(this.b);
        this.e.setAdapter((ListAdapter) this.i);
        this.e.setOnScrollListener(this);
        this.e.setOnSrollToBottomListener(this);
        this.g.a(new g(this));
        this.e.setOnItemClickListener(new h(this));
        this.f.setOnClickListener(new i(this));
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
        this.c.a(this.k);
        MessageManager.getInstance().unRegisterListener(this.n);
        MessageManager.getInstance().unRegisterListener(this.n);
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
        if (this.i.b()) {
            a(true);
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
            this.e.setDivider(getResources().getDrawable(com.baidu.tieba.t.list_divider_1));
        } else {
            this.e.setDivider(getResources().getDrawable(com.baidu.tieba.t.list_divider));
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
    public void c(boolean z) {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (!z) {
            this.e.setDivider(getResources().getDrawable(17170445));
        } else if (skinType == 1) {
            this.e.setDivider(getResources().getDrawable(com.baidu.tieba.t.list_divider_1));
        } else {
            this.e.setDivider(getResources().getDrawable(com.baidu.tieba.t.list_divider));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
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
                        this.j = true;
                        return;
                    }
                }
            }
        }
    }
}
