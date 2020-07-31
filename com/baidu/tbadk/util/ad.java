package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ad {
    private static final BdUniqueId eKZ = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, eKZ);

    public static <T> void a(ac<T> acVar, l<T> lVar) {
        if (acVar != null) {
            a aVar = new a(acVar, lVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(eKZ);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(ac<T> acVar, l<T> lVar) {
        if (acVar != null) {
            a aVar = new a(acVar, lVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(eKZ);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private ac<T> eLa;
        private l<T> eLb;

        public a(ac<T> acVar, l<T> lVar) {
            this.eLa = null;
            this.eLb = null;
            this.eLa = acVar;
            this.eLb = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            try {
                if (this.eLa == null) {
                    return null;
                }
                return this.eLa.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.eLb != null) {
                this.eLb.onReturnDataInUI(t);
            }
        }
    }

    public static void clearQueue() {
        BdAsyncTask.removeAllTask(eKZ);
    }
}
