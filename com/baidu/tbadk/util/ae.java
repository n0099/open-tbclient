package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ae {
    private static final BdUniqueId eYz = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, eYz);

    public static <T> void a(ad<T> adVar, m<T> mVar) {
        if (adVar != null) {
            a aVar = new a(adVar, mVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(eYz);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(ad<T> adVar, m<T> mVar) {
        if (adVar != null) {
            a aVar = new a(adVar, mVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(eYz);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private ad<T> eYA;
        private m<T> eYB;

        public a(ad<T> adVar, m<T> mVar) {
            this.eYA = null;
            this.eYB = null;
            this.eYA = adVar;
            this.eYB = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            try {
                if (this.eYA == null) {
                    return null;
                }
                return this.eYA.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.eYB != null) {
                this.eYB.onReturnDataInUI(t);
            }
        }
    }

    public static void clearQueue() {
        BdAsyncTask.removeAllTask(eYz);
    }
}
