package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ac {
    private static final BdUniqueId dHc = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, dHc);

    public static <T> void a(ab<T> abVar, l<T> lVar) {
        if (abVar != null) {
            a aVar = new a(abVar, lVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(dHc);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(ab<T> abVar, l<T> lVar) {
        if (abVar != null) {
            a aVar = new a(abVar, lVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(dHc);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private ab<T> dHd;
        private l<T> dHe;

        public a(ab<T> abVar, l<T> lVar) {
            this.dHd = null;
            this.dHe = null;
            this.dHd = abVar;
            this.dHe = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            try {
                if (this.dHd == null) {
                    return null;
                }
                return this.dHd.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.dHe != null) {
                this.dHe.onReturnDataInUI(t);
            }
        }
    }

    public static void clearQueue() {
        BdAsyncTask.removeAllTask(dHc);
    }
}
