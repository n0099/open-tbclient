package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class s implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        cs csVar;
        cs csVar2;
        cs csVar3;
        Handler handler3;
        Runnable runnable;
        Handler handler4;
        cs csVar4;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        cs csVar5;
        Handler handler5;
        Runnable runnable2;
        Handler handler6;
        Runnable runnable3;
        handler = this.a.ag;
        if (handler != null) {
            handler6 = this.a.ag;
            runnable3 = this.a.ai;
            handler6.removeCallbacks(runnable3);
        }
        this.a.ar = i;
        if (i == 0) {
            handler4 = this.a.ag;
            if (handler4 != null) {
                handler5 = this.a.ag;
                runnable2 = this.a.ai;
                handler5.postDelayed(runnable2, 90L);
            }
            csVar4 = this.a.w;
            onItemLongClickListener = this.a.ao;
            csVar4.a(onItemLongClickListener);
            csVar5 = this.a.w;
            csVar5.e(false);
            this.a.U = false;
            return;
        }
        handler2 = this.a.ag;
        if (handler2 != null && i == 1) {
            handler3 = this.a.ag;
            runnable = this.a.ai;
            handler3.postDelayed(runnable, 90L);
        }
        csVar = this.a.w;
        csVar.a((AdapterView.OnItemLongClickListener) null);
        csVar2 = this.a.w;
        csVar2.e(true);
        this.a.U = true;
        csVar3 = this.a.w;
        csVar3.U();
    }
}
