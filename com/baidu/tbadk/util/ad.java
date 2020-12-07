package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ad {
    private static final BdUniqueId fGo = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, fGo);

    public static <T> void a(ac<T> acVar, m<T> mVar) {
        if (acVar != null) {
            a aVar = new a(acVar, mVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(fGo);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(ac<T> acVar, m<T> mVar) {
        if (acVar != null) {
            a aVar = new a(acVar, mVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(fGo);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private ac<T> fGp;
        private m<T> fGq;

        public a(ac<T> acVar, m<T> mVar) {
            this.fGp = null;
            this.fGq = null;
            this.fGp = acVar;
            this.fGq = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            try {
                if (this.fGp == null) {
                    return null;
                }
                return this.fGp.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.fGq != null) {
                this.fGq.onReturnDataInUI(t);
            }
        }
    }

    public static void clearQueue() {
        BdAsyncTask.removeAllTask(fGo);
    }
}
