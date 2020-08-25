package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes2.dex */
public class ad {
    private static final BdUniqueId eVE = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, eVE);

    public static <T> void a(ac<T> acVar, l<T> lVar) {
        if (acVar != null) {
            a aVar = new a(acVar, lVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(eVE);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(ac<T> acVar, l<T> lVar) {
        if (acVar != null) {
            a aVar = new a(acVar, lVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(eVE);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private ac<T> eVF;
        private l<T> eVG;

        public a(ac<T> acVar, l<T> lVar) {
            this.eVF = null;
            this.eVG = null;
            this.eVF = acVar;
            this.eVG = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            try {
                if (this.eVF == null) {
                    return null;
                }
                return this.eVF.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.eVG != null) {
                this.eVG.onReturnDataInUI(t);
            }
        }
    }

    public static void clearQueue() {
        BdAsyncTask.removeAllTask(eVE);
    }
}
