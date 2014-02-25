package com.baidu.tieba.album;

import android.database.ContentObserver;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends ContentObserver {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(q qVar, Handler handler) {
        super(handler);
        this.a = qVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.a.a(false);
    }
}
