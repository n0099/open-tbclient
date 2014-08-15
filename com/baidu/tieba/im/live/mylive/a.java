package com.baidu.tieba.im.live.mylive;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.view.u;
import com.baidu.tbadk.coreExtra.view.ag;
import com.baidu.tieba.im.message.RequestSubscribeLiveGroupMessage;
import com.baidu.tieba.im.model.am;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.d implements x, ag {
    private MyLiveActivity b;
    private am c;
    private BdListView d;
    private ProgressBar e;
    private u f;
    private MyLiveNoDataView g;
    private MyLiveListAdapter h;
    private boolean j;
    private int i = 1;
    private LiveCardData k = null;
    private final com.baidu.adp.framework.listener.d l = new b(this, 0);
    private final CustomMessageListener m = new c(this, 0);
    private final com.baidu.adp.framework.listener.d n = new d(this, 0);
    private final com.baidu.adp.framework.listener.d o = new e(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (MyLiveActivity) getActivity();
        this.i = getArguments().getInt("KeyOfFragmentType", 2);
        this.c = new am(this.b, this.i);
        this.c.setUniqueId(d());
        this.c.registerListener(107002, this.l);
        this.c.registerListener(2001165, this.m);
        if (this.i == 1) {
            this.c.registerListener(103104, this.n);
        } else if (this.i == 2) {
            this.c.registerListener(107105, this.o);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(v.mylive_fragment, (ViewGroup) null);
        this.g = (MyLiveNoDataView) inflate.findViewById(com.baidu.tieba.u.mylive_fragment_live_guide);
        this.d = (BdListView) inflate.findViewById(com.baidu.tieba.u.mylive_fragment_live_list);
        this.f = new u(this.b);
        this.d.setPullRefresh(this.f);
        this.h = new MyLiveListAdapter(this.b, this);
        this.d.setAdapter((ListAdapter) this.h);
        this.d.setOnScrollListener(this);
        this.d.setOnSrollToBottomListener(this);
        this.f.a(new f(this));
        this.e = (ProgressBar) inflate.findViewById(com.baidu.tieba.u.mylive_fragment_live_list_progress);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.i == 2 && this.c != null && !this.c.b()) {
            g();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.g.b()) {
            this.g.f();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.g.g();
    }

    @Override // com.baidu.tbadk.coreExtra.view.ag
    public void a(View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof LiveCardData)) {
            this.k = (LiveCardData) view.getTag();
            if (this.i == 1) {
                d(com.baidu.tieba.x.live_mylive_dismiss_hint);
            } else if (this.i == 2) {
                RequestSubscribeLiveGroupMessage requestSubscribeLiveGroupMessage = new RequestSubscribeLiveGroupMessage();
                requestSubscribeLiveGroupMessage.setGroupId(this.k.getGroupId());
                requestSubscribeLiveGroupMessage.setSubscribe(0);
                this.e.setVisibility(0);
                MessageManager.getInstance().sendMessage(requestSubscribeLiveGroupMessage);
            }
        }
    }

    private void d(int i) {
        new AlertDialog.Builder(this.b).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(i).setPositiveButton(com.baidu.tieba.x.confirm, new g(this)).setNegativeButton(com.baidu.tieba.x.cancel, new h(this)).create().show();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.l);
        MessageManager.getInstance().unRegisterListener(this.m);
        if (this.i == 1) {
            MessageManager.getInstance().unRegisterListener(this.n);
        } else if (this.i == 2) {
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public int f() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.c.a(this.c.c(), 20);
        } else {
            this.c.b(this.c.c(), 20);
        }
    }

    public void g() {
        if (this.d != null) {
            this.d.e();
        }
    }

    public boolean h() {
        if (this.c == null) {
            return false;
        }
        return this.c.b();
    }

    public boolean i() {
        if (this.c == null) {
            return true;
        }
        return this.c.a();
    }

    public void a(boolean z, String str) {
        if (this.h != null) {
            this.h.a(z, str);
        }
    }

    public boolean j() {
        if (this.h != null) {
            return (this.h.getCount() <= 1 || !this.h.b()) && (this.h.getCount() <= 0 || this.h.b());
        }
        return true;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        k();
    }

    private void k() {
        if (this.h.a()) {
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.d.d();
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        this.f.a(i);
    }

    public void a(LiveCardData liveCardData) {
        this.h.a(liveCardData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.g.b()) {
            this.g.a();
        }
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        layoutParams.height = -1;
        this.d.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.g.f();
        switch (this.i) {
            case 1:
                this.g.c();
                break;
            case 2:
                this.g.d();
                break;
        }
        int clickBtnTop = this.g.getClickBtnTop();
        if (clickBtnTop <= 0) {
            clickBtnTop = ((View) this.d.getParent()).getMeasuredHeight() / 2;
        }
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        layoutParams.height = clickBtnTop;
        this.d.setLayoutParams(layoutParams);
    }
}
