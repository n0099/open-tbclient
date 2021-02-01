package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class af {
    private static final BdUniqueId fNx = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, fNx);

    public static <T> void a(ae<T> aeVar, m<T> mVar) {
        if (aeVar != null) {
            a aVar = new a(aeVar, mVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(fNx);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(ae<T> aeVar, m<T> mVar) {
        if (aeVar != null) {
            a aVar = new a(aeVar, mVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(fNx);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private ae<T> fNy;
        private m<T> fNz;

        public a(ae<T> aeVar, m<T> mVar) {
            this.fNy = null;
            this.fNz = null;
            this.fNy = aeVar;
            this.fNz = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            try {
                if (this.fNy == null) {
                    return null;
                }
                return this.fNy.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.fNz != null) {
                this.fNz.onReturnDataInUI(t);
            }
        }
    }

    public static void clearQueue() {
        BdAsyncTask.removeAllTask(fNx);
    }
}
