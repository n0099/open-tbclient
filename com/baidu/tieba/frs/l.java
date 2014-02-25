package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class l implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        br brVar;
        br brVar2;
        Handler handler2;
        br brVar3;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        br brVar4;
        Handler handler3;
        Runnable runnable;
        Handler handler4;
        Runnable runnable2;
        handler = this.a.U;
        if (handler != null) {
            handler4 = this.a.U;
            runnable2 = this.a.W;
            handler4.removeCallbacks(runnable2);
        }
        this.a.af = i;
        if (i != 0) {
            brVar = this.a.p;
            brVar.a((AdapterView.OnItemLongClickListener) null);
            brVar2 = this.a.p;
            brVar2.e(true);
            this.a.N = true;
            return;
        }
        handler2 = this.a.U;
        if (handler2 != null) {
            handler3 = this.a.U;
            runnable = this.a.W;
            handler3.postDelayed(runnable, 300L);
        }
        brVar3 = this.a.p;
        onItemLongClickListener = this.a.ac;
        brVar3.a(onItemLongClickListener);
        brVar4 = this.a.p;
        brVar4.e(false);
        this.a.N = false;
    }
}
