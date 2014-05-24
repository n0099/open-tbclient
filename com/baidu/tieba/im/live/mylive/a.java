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
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.coreExtra.view.ae;
import com.baidu.tieba.im.message.RequestSubscribeLiveGroupMessage;
import com.baidu.tieba.im.model.bd;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.d implements x, ae {
    private MyLiveActivity b;
    private bd c;
    private BdListView d;
    private ProgressBar e;
    private q f;
    private MyLiveNoDataView g;
    private MyLiveListAdapter h;
    private int i = 1;
    private LiveCardData j = null;
    private final com.baidu.adp.framework.listener.b k = new b(this, 0);
    private final CustomMessageListener l = new c(this, 0);
    private final com.baidu.adp.framework.listener.b m = new d(this, 0);
    private final com.baidu.adp.framework.listener.b n = new e(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (MyLiveActivity) getActivity();
        this.i = getArguments().getInt("KeyOfFragmentType", 1);
        this.c = new bd(this.i);
        this.c.setUniqueId(d());
        this.c.registerListener(MessageTypes.CMD_QUERY_MYLIVE, this.k);
        this.c.registerListener(MessageTypes.CMD_QUERY_MYLIVE_LOCAL, this.l);
        if (this.i == 1) {
            this.c.registerListener(MessageTypes.CMD_DISSMISS_GROUP, this.m);
        } else if (this.i == 2) {
            this.c.registerListener(MessageTypes.CMD_SUBSCRIBE_LIVE_GROUP, this.n);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(w.mylive_fragment, (ViewGroup) null);
        this.g = (MyLiveNoDataView) inflate.findViewById(v.mylive_fragment_live_guide);
        this.d = (BdListView) inflate.findViewById(v.mylive_fragment_live_list);
        this.f = new q(this.b);
        this.d.setPullRefresh(this.f);
        this.h = new MyLiveListAdapter(this.b, this);
        this.d.setAdapter((ListAdapter) this.h);
        this.d.setOnScrollListener(this);
        this.d.setOnSrollToBottomListener(this);
        this.f.a(new f(this));
        this.e = (ProgressBar) inflate.findViewById(v.mylive_fragment_live_list_progress);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.i == 1 && this.c != null && !this.c.a()) {
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

    @Override // com.baidu.tbadk.coreExtra.view.ae
    public void a(View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof LiveCardData)) {
            this.j = (LiveCardData) view.getTag();
            if (this.i == 1) {
                d(y.live_mylive_dismiss_hint);
            } else if (this.i == 2) {
                RequestSubscribeLiveGroupMessage requestSubscribeLiveGroupMessage = new RequestSubscribeLiveGroupMessage();
                requestSubscribeLiveGroupMessage.setGroupId(this.j.getGroupId());
                requestSubscribeLiveGroupMessage.setSubscribe(0);
                this.e.setVisibility(0);
                MessageManager.getInstance().sendMessage(requestSubscribeLiveGroupMessage);
            }
        }
    }

    private void d(int i) {
        new AlertDialog.Builder(this.b).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(i).setPositiveButton(y.confirm, new g(this)).setNegativeButton(y.cancel, new h(this)).create().show();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.k);
        MessageManager.getInstance().unRegisterListener(this.l);
        if (this.i == 1) {
            MessageManager.getInstance().unRegisterListener(this.m);
        } else if (this.i == 2) {
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    public int f() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.c.a(this.c.b(), 20);
        } else {
            this.c.b(this.c.b(), 20);
        }
    }

    public void g() {
        this.d.d();
    }

    public boolean h() {
        if (this.c == null) {
            return false;
        }
        return this.c.a();
    }

    public void a(boolean z, String str) {
        if (this.h != null) {
            this.h.a(z, str);
        }
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void f_() {
        i();
    }

    private void i() {
        if (this.h.a()) {
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.d.c();
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
    public void k() {
        if (this.g.b()) {
            this.g.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.g.f();
        switch (this.i) {
            case 1:
                this.g.c();
                return;
            case 2:
                this.g.d();
                return;
            default:
                return;
        }
    }
}
