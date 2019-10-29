package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class z {
    private static final BdUniqueId cPp = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, cPp);

    public static <T> void a(y<T> yVar, j<T> jVar) {
        if (yVar != null) {
            a aVar = new a(yVar, jVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(cPp);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(y<T> yVar, j<T> jVar) {
        if (yVar != null) {
            a aVar = new a(yVar, jVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(cPp);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private y<T> cPq;
        private j<T> cPr;

        public a(y<T> yVar, j<T> jVar) {
            this.cPq = null;
            this.cPr = null;
            this.cPq = yVar;
            this.cPr = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            try {
                if (this.cPq == null) {
                    return null;
                }
                return this.cPq.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.cPr != null) {
                this.cPr.onReturnDataInUI(t);
            }
        }
    }

    public static void clearQueue() {
        BdAsyncTask.removeAllTask(cPp);
    }
}
