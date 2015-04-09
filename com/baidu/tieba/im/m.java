package com.baidu.tieba.im;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class m<T> extends BdAsyncTask<String, Object, T> {
    private h<T> aWo;
    private g<T> aWp;

    public m(h<T> hVar, g<T> gVar) {
        this.aWo = null;
        this.aWp = null;
        this.aWo = hVar;
        this.aWp = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public T doInBackground(String... strArr) {
        try {
            if (this.aWo == null) {
                return null;
            }
            return this.aWo.doInBackground();
        } catch (Throwable th) {
            BdLog.detailException(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(T t) {
        if (this.aWp != null) {
            this.aWp.onReturnDataInUI(t);
        }
    }
}
