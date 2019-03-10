package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class aa {
    private static final BdUniqueId ctK = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ctK);

    public static <T> void a(z<T> zVar, k<T> kVar) {
        if (zVar != null) {
            a aVar = new a(zVar, kVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(ctK);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(z<T> zVar, k<T> kVar) {
        if (zVar != null) {
            a aVar = new a(zVar, kVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(ctK);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private z<T> ctL;
        private k<T> ctM;

        public a(z<T> zVar, k<T> kVar) {
            this.ctL = null;
            this.ctM = null;
            this.ctL = zVar;
            this.ctM = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public T doInBackground(String... strArr) {
            try {
                if (this.ctL == null) {
                    return null;
                }
                return this.ctL.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.ctM != null) {
                this.ctM.onReturnDataInUI(t);
            }
        }
    }

    public static void aqq() {
        BdAsyncTask.removeAllTask(ctK);
    }
}
