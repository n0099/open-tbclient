package com.baidu.tieba.im;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class m<T> extends BdAsyncTask<String, Object, T> {
    private h<T> aYU;
    private g<T> aYV;

    public m(h<T> hVar, g<T> gVar) {
        this.aYU = null;
        this.aYV = null;
        this.aYU = hVar;
        this.aYV = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public T doInBackground(String... strArr) {
        try {
            if (this.aYU == null) {
                return null;
            }
            return this.aYU.doInBackground();
        } catch (Throwable th) {
            BdLog.detailException(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(T t) {
        if (this.aYV != null) {
            this.aYV.onReturnDataInUI(t);
        }
    }
}
