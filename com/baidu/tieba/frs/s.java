package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
/* loaded from: classes.dex */
final class s implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        cm cmVar;
        cm cmVar2;
        cm cmVar3;
        Handler handler3;
        Runnable runnable;
        Handler handler4;
        cm cmVar4;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        cm cmVar5;
        Handler handler5;
        Runnable runnable2;
        Handler handler6;
        Runnable runnable3;
        handler = this.a.Z;
        if (handler != null) {
            handler6 = this.a.Z;
            runnable3 = this.a.ab;
            handler6.removeCallbacks(runnable3);
        }
        this.a.am = i;
        if (i == 0) {
            handler4 = this.a.Z;
            if (handler4 != null) {
                handler5 = this.a.Z;
                runnable2 = this.a.ab;
                handler5.postDelayed(runnable2, 300L);
            }
            cmVar4 = this.a.r;
            onItemLongClickListener = this.a.aj;
            cmVar4.a(onItemLongClickListener);
            cmVar5 = this.a.r;
            cmVar5.f(false);
            this.a.N = false;
            return;
        }
        handler2 = this.a.Z;
        if (handler2 != null && i == 1) {
            handler3 = this.a.Z;
            runnable = this.a.ab;
            handler3.postDelayed(runnable, 300L);
        }
        cmVar = this.a.r;
        cmVar.a((AdapterView.OnItemLongClickListener) null);
        cmVar2 = this.a.r;
        cmVar2.f(true);
        this.a.N = true;
        cmVar3 = this.a.r;
        cmVar3.P();
    }
}
