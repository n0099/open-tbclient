package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.a.Z;
        runnable = this.a.ac;
        handler.removeCallbacks(runnable);
        handler2 = this.a.Z;
        runnable2 = this.a.ac;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        ListView listView;
        ListView listView2;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        if (i == 0) {
            listView2 = this.a.x;
            onItemLongClickListener = this.a.ad;
            listView2.setOnItemLongClickListener(onItemLongClickListener);
            return;
        }
        listView = this.a.x;
        listView.setOnItemLongClickListener(null);
    }
}
