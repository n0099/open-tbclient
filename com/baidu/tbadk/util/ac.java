package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ac {
    private static final BdUniqueId egZ = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, egZ);

    public static <T> void a(ab<T> abVar, l<T> lVar) {
        if (abVar != null) {
            a aVar = new a(abVar, lVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(egZ);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(ab<T> abVar, l<T> lVar) {
        if (abVar != null) {
            a aVar = new a(abVar, lVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(egZ);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private ab<T> eha;
        private l<T> ehb;

        public a(ab<T> abVar, l<T> lVar) {
            this.eha = null;
            this.ehb = null;
            this.eha = abVar;
            this.ehb = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            try {
                if (this.eha == null) {
                    return null;
                }
                return this.eha.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.ehb != null) {
                this.ehb.onReturnDataInUI(t);
            }
        }
    }

    public static void clearQueue() {
        BdAsyncTask.removeAllTask(egZ);
    }
}
