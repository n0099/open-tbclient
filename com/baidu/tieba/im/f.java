package com.baidu.tieba.im;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f<T> extends BdAsyncTask<String, Object, T> {
    private b<T> a;
    private a<T> b;

    public f(b<T> bVar, a<T> aVar) {
        this.a = null;
        this.b = null;
        this.a = bVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public T doInBackground(String... strArr) {
        try {
            if (this.a == null) {
                return null;
            }
            return this.a.a();
        } catch (Throwable th) {
            BdLog.detailException(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(T t) {
        if (this.b != null) {
            this.b.a(t);
        }
    }
}
