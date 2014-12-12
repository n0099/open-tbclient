package com.baidu.tieba.album;

import android.database.ContentObserver;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends ContentObserver {
    final /* synthetic */ q this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(q qVar, Handler handler) {
        super(handler);
        this.this$0 = qVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.this$0.handler;
        runnable = this.this$0.apv;
        handler.removeCallbacks(runnable);
        handler2 = this.this$0.handler;
        runnable2 = this.this$0.apv;
        handler2.postDelayed(runnable2, 2000L);
    }
}
