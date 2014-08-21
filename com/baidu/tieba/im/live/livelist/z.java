package com.baidu.tieba.im.live.livelist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.core.d implements com.baidu.adp.widget.ListView.x {
    private HotLiveListActivity b;
    private com.baidu.tieba.im.model.n c;
    private ad d;
    private BdListView e;
    private com.baidu.tbadk.core.view.v f;
    private HotLiveInitGuideView g;
    private View h;
    private HotLiveListAdapter i;
    private final com.baidu.adp.framework.listener.d j = new aa(this, 107003);
    private final CustomMessageListener k = new ab(this, 2001214);

    public BdListView f() {
        return this.e;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (HotLiveListActivity) getActivity();
        this.c = this.b.g();
        this.d = this.b.h();
        this.c.registerListener(this.j);
        this.c.registerListener(this.k);
    }

    private void g() {
        this.c.registerListener(this.j);
        this.c.registerListener(this.k);
        if (!this.c.a(b())) {
            i();
        }
    }

    private void h() {
        this.c.a(this.j);
        this.c.a(this.k);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        if (z) {
            h();
        } else {
            g();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = layoutInflater.inflate(com.baidu.tieba.v.live_hot_list, (ViewGroup) null);
        this.g = (HotLiveInitGuideView) this.h.findViewById(com.baidu.tieba.u.live_guide);
        this.e = (BdListView) this.h.findViewById(com.baidu.tieba.u.live_list);
        this.f = new com.baidu.tbadk.core.view.v(this.b);
        this.e.setPullRefresh(this.f);
        this.i = new HotLiveListAdapter(this.b);
        this.e.setAdapter((ListAdapter) this.i);
        this.e.setDivider(null);
        this.e.setDividerHeight(0);
        this.e.setOnScrollListener(this);
        this.e.setOnSrollToBottomListener(this);
        this.f.a(new ac(this));
        return this.h;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.baidu.tbadk.core.d
    public void e() {
        if (!this.c.a(b())) {
            j();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.g.b()) {
            this.g.g();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.g.h();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.c.a(this.j);
        MessageManager.getInstance().unRegisterListener(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.c.a(this.c.e(), this.c.f(), 20, this.c.a(), this.c.b());
        } else {
            this.c.b(this.c.e(), this.c.f(), 20, this.c.a(), this.c.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.i.b(false);
        this.c.b(0);
        this.c.d(0);
        this.e.e();
        a(true);
    }

    private void j() {
        this.g.a();
        this.i.b(true);
        this.c.b(0);
        this.c.d(0);
        this.e.e();
        a(false);
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        k();
    }

    private void k() {
        if (this.i.a()) {
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.c.d()) {
            this.e.d();
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        this.d.d(i);
        this.b.c().a(i == 1);
        this.b.c().a(this.h);
        this.f.a(i);
        this.g.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.g.b()) {
            this.g.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.g.g();
        switch (this.c.c()) {
            case 1:
                this.g.c();
                return;
            case 2:
                this.g.d();
                return;
            case 3:
                this.g.e();
                return;
            default:
                return;
        }
    }
}
