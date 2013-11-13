package com.baidu.tieba.chat;

import android.app.Activity;
import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1119a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ChatListFragment chatListFragment) {
        this.f1119a = chatListFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        BdListView bdListView;
        BdListView bdListView2;
        com.baidu.tieba.view.q qVar;
        Activity activity;
        com.baidu.tieba.view.q qVar2;
        BdListView bdListView3;
        com.baidu.tieba.view.q qVar3;
        handler = this.f1119a.f;
        runnable = this.f1119a.g;
        handler.removeCallbacks(runnable);
        handler2 = this.f1119a.f;
        runnable2 = this.f1119a.g;
        handler2.postDelayed(runnable2, 300L);
        bdListView = this.f1119a.Z;
        if (bdListView.getAdapter() != null) {
            bdListView2 = this.f1119a.Z;
            if (i2 < bdListView2.getAdapter().getCount()) {
                qVar = this.f1119a.af;
                if (qVar == null) {
                    ChatListFragment chatListFragment = this.f1119a;
                    activity = this.f1119a.d;
                    chatListFragment.af = new com.baidu.tieba.view.q(activity);
                    qVar2 = this.f1119a.af;
                    qVar2.setHeightDip(30);
                    bdListView3 = this.f1119a.Z;
                    qVar3 = this.f1119a.af;
                    bdListView3.addFooterView(qVar3);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
