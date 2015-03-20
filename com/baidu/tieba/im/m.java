package com.baidu.tieba.im;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class m<T> extends BdAsyncTask<String, Object, T> {
    private h<T> aVY;
    private g<T> aVZ;

    public m(h<T> hVar, g<T> gVar) {
        this.aVY = null;
        this.aVZ = null;
        this.aVY = hVar;
        this.aVZ = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public T doInBackground(String... strArr) {
        try {
            if (this.aVY == null) {
                return null;
            }
            return this.aVY.doInBackground();
        } catch (Throwable th) {
            BdLog.detailException(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(T t) {
        if (this.aVZ != null) {
            this.aVZ.onReturnDataInUI(t);
        }
    }
}
