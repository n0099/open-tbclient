package com.baidu.tieba.im;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f<T> extends BdAsyncTask<String, Object, T> {
    private b<T> aNf;
    private a<T> aNg;

    public f(b<T> bVar, a<T> aVar) {
        this.aNf = null;
        this.aNg = null;
        this.aNf = bVar;
        this.aNg = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public T doInBackground(String... strArr) {
        try {
            if (this.aNf == null) {
                return null;
            }
            return this.aNf.doInBackground();
        } catch (Throwable th) {
            BdLog.detailException(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(T t) {
        if (this.aNg != null) {
            this.aNg.onReturnDataInUI(t);
        }
    }
}
