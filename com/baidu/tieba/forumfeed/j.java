package com.baidu.tieba.forumfeed;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1237a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f1237a = iVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Runnable runnable;
        Handler handler3;
        Handler handler4;
        Runnable runnable2;
        Handler handler5;
        Runnable runnable3;
        if (i == 0) {
            handler3 = this.f1237a.g;
            if (handler3 != null) {
                handler4 = this.f1237a.g;
                runnable2 = this.f1237a.p;
                handler4.removeCallbacks(runnable2);
                handler5 = this.f1237a.g;
                runnable3 = this.f1237a.p;
                handler5.postDelayed(runnable3, 300L);
                return;
            }
            return;
        }
        handler = this.f1237a.g;
        if (handler != null) {
            handler2 = this.f1237a.g;
            runnable = this.f1237a.p;
            handler2.removeCallbacks(runnable);
        }
    }
}
