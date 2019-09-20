package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class z {
    private static final BdUniqueId cEj = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, cEj);

    public static <T> void a(y<T> yVar, j<T> jVar) {
        if (yVar != null) {
            a aVar = new a(yVar, jVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(cEj);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(y<T> yVar, j<T> jVar) {
        if (yVar != null) {
            a aVar = new a(yVar, jVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(cEj);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private y<T> cEk;
        private j<T> cEl;

        public a(y<T> yVar, j<T> jVar) {
            this.cEk = null;
            this.cEl = null;
            this.cEk = yVar;
            this.cEl = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            try {
                if (this.cEk == null) {
                    return null;
                }
                return this.cEk.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.cEl != null) {
                this.cEl.onReturnDataInUI(t);
            }
        }
    }

    public static void awO() {
        BdAsyncTask.removeAllTask(cEj);
    }
}
