package com.baidu.tieba.im.live.livelist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.core.d implements com.baidu.adp.widget.ListView.u {
    private HotLiveListActivity b;
    private com.baidu.tieba.im.model.p c;
    private ad d;
    private BdListView e;
    private com.baidu.tbadk.core.view.q f;
    private HotLiveInitGuideView g;
    private View h;
    private HotLiveListAdapter i;
    private final com.baidu.adp.framework.listener.b j = new aa(this, MessageTypes.CMD_REQUEST_LIVE_LIST_ALL);
    private final CustomMessageListener k = new ab(this, MessageTypes.CMD_CACHE_LIVE_HOT_LIST_ALL);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (HotLiveListActivity) getActivity();
        this.c = this.b.e();
        this.d = this.b.f();
        this.c.registerListener(this.j);
        this.c.registerListener(this.k);
    }

    private void f() {
        this.c.registerListener(this.j);
        this.c.registerListener(this.k);
        if (!this.c.a(b())) {
            h();
        }
    }

    private void g() {
        this.c.a(this.j);
        this.c.a(this.k);
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
        this.h = layoutInflater.inflate(com.baidu.tieba.s.live_hot_list, (ViewGroup) null);
        this.g = (HotLiveInitGuideView) this.h.findViewById(com.baidu.tieba.r.live_guide);
        this.e = (BdListView) this.h.findViewById(com.baidu.tieba.r.live_list);
        this.f = new com.baidu.tbadk.core.view.q(this.b);
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
            i();
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
    public void h() {
        this.i.b(false);
        this.c.b(0);
        this.c.d(0);
        this.e.d();
        a(true);
    }

    private void i() {
        this.g.a();
        this.i.b(true);
        this.c.b(0);
        this.c.d(0);
        this.e.d();
        a(false);
    }

    @Override // com.baidu.adp.widget.ListView.u
    public void f_() {
        j();
    }

    private void j() {
        if (this.i.a()) {
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.c.d()) {
            this.e.c();
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        this.d.d(i);
        this.b.a().a(i == 1);
        this.b.a().a(this.h);
        this.f.a(i);
        this.g.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.g.b()) {
            this.g.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
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
