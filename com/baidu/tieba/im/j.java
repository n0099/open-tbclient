package com.baidu.tieba.im;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j<T> extends BdAsyncTask<String, Object, T> {
    private h<T> aQL;
    private g<T> aQM;

    public j(h<T> hVar, g<T> gVar) {
        this.aQL = null;
        this.aQM = null;
        this.aQL = hVar;
        this.aQM = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public T doInBackground(String... strArr) {
        try {
            if (this.aQL == null) {
                return null;
            }
            return this.aQL.doInBackground();
        } catch (Throwable th) {
            BdLog.detailException(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(T t) {
        if (this.aQM != null) {
            this.aQM.onReturnDataInUI(t);
        }
    }
}
