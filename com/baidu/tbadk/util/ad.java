package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ad {
    private static final BdUniqueId evx = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, evx);

    public static <T> void a(ac<T> acVar, l<T> lVar) {
        if (acVar != null) {
            a aVar = new a(acVar, lVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(evx);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(ac<T> acVar, l<T> lVar) {
        if (acVar != null) {
            a aVar = new a(acVar, lVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(evx);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private ac<T> evy;
        private l<T> evz;

        public a(ac<T> acVar, l<T> lVar) {
            this.evy = null;
            this.evz = null;
            this.evy = acVar;
            this.evz = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            try {
                if (this.evy == null) {
                    return null;
                }
                return this.evy.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.evz != null) {
                this.evz.onReturnDataInUI(t);
            }
        }
    }

    public static void clearQueue() {
        BdAsyncTask.removeAllTask(evx);
    }
}
