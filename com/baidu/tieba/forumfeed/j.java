package com.baidu.tieba.forumfeed;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1294a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f1294a = iVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Runnable runnable;
        Handler handler4;
        Runnable runnable2;
        handler = this.f1294a.h;
        if (handler != null) {
            handler4 = this.f1294a.h;
            runnable2 = this.f1294a.q;
            handler4.removeCallbacks(runnable2);
        }
        if (i == 0) {
            handler2 = this.f1294a.h;
            if (handler2 != null) {
                handler3 = this.f1294a.h;
                runnable = this.f1294a.q;
                handler3.postDelayed(runnable, 300L);
            }
        }
    }
}
