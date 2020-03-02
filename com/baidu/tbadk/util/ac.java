package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ac {
    private static final BdUniqueId dGP = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, dGP);

    public static <T> void a(ab<T> abVar, l<T> lVar) {
        if (abVar != null) {
            a aVar = new a(abVar, lVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(dGP);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(ab<T> abVar, l<T> lVar) {
        if (abVar != null) {
            a aVar = new a(abVar, lVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(dGP);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private ab<T> dGQ;
        private l<T> dGR;

        public a(ab<T> abVar, l<T> lVar) {
            this.dGQ = null;
            this.dGR = null;
            this.dGQ = abVar;
            this.dGR = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            try {
                if (this.dGQ == null) {
                    return null;
                }
                return this.dGQ.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.dGR != null) {
                this.dGR.onReturnDataInUI(t);
            }
        }
    }

    public static void clearQueue() {
        BdAsyncTask.removeAllTask(dGP);
    }
}
