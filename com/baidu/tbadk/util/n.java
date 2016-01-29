package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class n {
    private static final BdUniqueId aDd = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aDd);

    public static <T> void a(m<T> mVar, d<T> dVar) {
        if (mVar != null) {
            a aVar = new a(mVar, dVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aDd);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(m<T> mVar, d<T> dVar) {
        if (mVar != null) {
            a aVar = new a(mVar, dVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aDd);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private m<T> aDe;
        private d<T> aDf;

        public a(m<T> mVar, d<T> dVar) {
            this.aDe = null;
            this.aDf = null;
            this.aDe = mVar;
            this.aDf = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public T doInBackground(String... strArr) {
            try {
                if (this.aDe == null) {
                    return null;
                }
                return this.aDe.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aDf != null) {
                this.aDf.onReturnDataInUI(t);
            }
        }
    }

    public static void GD() {
        BdAsyncTask.removeAllTask(aDd);
    }
}
