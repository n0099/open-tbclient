package com.baidu.tieba.im;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f<T> extends BdAsyncTask<String, Object, T> {
    private b<T> aNt;
    private a<T> aNu;

    public f(b<T> bVar, a<T> aVar) {
        this.aNt = null;
        this.aNu = null;
        this.aNt = bVar;
        this.aNu = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public T doInBackground(String... strArr) {
        try {
            if (this.aNt == null) {
                return null;
            }
            return this.aNt.doInBackground();
        } catch (Throwable th) {
            BdLog.detailException(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(T t) {
        if (this.aNu != null) {
            this.aNu.onReturnDataInUI(t);
        }
    }
}
