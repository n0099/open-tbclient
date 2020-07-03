package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ad {
    private static final BdUniqueId eED = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, eED);

    public static <T> void a(ac<T> acVar, l<T> lVar) {
        if (acVar != null) {
            a aVar = new a(acVar, lVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(eED);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(ac<T> acVar, l<T> lVar) {
        if (acVar != null) {
            a aVar = new a(acVar, lVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(eED);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private ac<T> eEE;
        private l<T> eEF;

        public a(ac<T> acVar, l<T> lVar) {
            this.eEE = null;
            this.eEF = null;
            this.eEE = acVar;
            this.eEF = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            try {
                if (this.eEE == null) {
                    return null;
                }
                return this.eEE.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.eEF != null) {
                this.eEF.onReturnDataInUI(t);
            }
        }
    }

    public static void clearQueue() {
        BdAsyncTask.removeAllTask(eED);
    }
}
