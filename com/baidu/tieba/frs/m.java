package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class m implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        bk bkVar;
        bk bkVar2;
        Handler handler2;
        bk bkVar3;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        bk bkVar4;
        Handler handler3;
        Runnable runnable;
        Handler handler4;
        Runnable runnable2;
        handler = this.a.O;
        if (handler != null) {
            handler4 = this.a.O;
            runnable2 = this.a.Q;
            handler4.removeCallbacks(runnable2);
        }
        this.a.Z = i;
        if (i == 0) {
            handler2 = this.a.O;
            if (handler2 != null) {
                handler3 = this.a.O;
                runnable = this.a.Q;
                handler3.postDelayed(runnable, 300L);
            }
            bkVar3 = this.a.n;
            onItemLongClickListener = this.a.W;
            bkVar3.a(onItemLongClickListener);
            bkVar4 = this.a.n;
            bkVar4.e(false);
            this.a.J = false;
            return;
        }
        bkVar = this.a.n;
        bkVar.a((AdapterView.OnItemLongClickListener) null);
        bkVar2 = this.a.n;
        bkVar2.e(true);
        this.a.J = true;
    }
}
