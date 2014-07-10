package com.baidu.tieba.barcode.b.a;

import android.os.AsyncTask;
/* loaded from: classes.dex */
public final class c implements a {
    @Override // com.baidu.tieba.barcode.b.a.a
    public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        asyncTask.execute(tArr);
    }
}
