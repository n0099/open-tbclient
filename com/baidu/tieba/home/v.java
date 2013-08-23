package com.baidu.tieba.home;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f1196a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.f1196a = sVar;
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
            handler3 = this.f1196a.i;
            if (handler3 != null) {
                handler4 = this.f1196a.i;
                runnable2 = this.f1196a.q;
                handler4.removeCallbacks(runnable2);
                handler5 = this.f1196a.i;
                runnable3 = this.f1196a.q;
                handler5.postDelayed(runnable3, 300L);
                return;
            }
            return;
        }
        handler = this.f1196a.i;
        if (handler != null) {
            handler2 = this.f1196a.i;
            runnable = this.f1196a.q;
            handler2.removeCallbacks(runnable);
        }
    }
}
