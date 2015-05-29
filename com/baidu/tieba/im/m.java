package com.baidu.tieba.im;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class m<T> extends BdAsyncTask<String, Object, T> {
    private h<T> aYT;
    private g<T> aYU;

    public m(h<T> hVar, g<T> gVar) {
        this.aYT = null;
        this.aYU = null;
        this.aYT = hVar;
        this.aYU = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public T doInBackground(String... strArr) {
        try {
            if (this.aYT == null) {
                return null;
            }
            return this.aYT.doInBackground();
        } catch (Throwable th) {
            BdLog.detailException(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(T t) {
        if (this.aYU != null) {
            this.aYU.onReturnDataInUI(t);
        }
    }
}
