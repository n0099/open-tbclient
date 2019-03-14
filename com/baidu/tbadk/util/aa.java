package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class aa {
    private static final BdUniqueId ctH = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ctH);

    public static <T> void a(z<T> zVar, k<T> kVar) {
        if (zVar != null) {
            a aVar = new a(zVar, kVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(ctH);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(z<T> zVar, k<T> kVar) {
        if (zVar != null) {
            a aVar = new a(zVar, kVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(ctH);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private z<T> ctI;
        private k<T> ctJ;

        public a(z<T> zVar, k<T> kVar) {
            this.ctI = null;
            this.ctJ = null;
            this.ctI = zVar;
            this.ctJ = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public T doInBackground(String... strArr) {
            try {
                if (this.ctI == null) {
                    return null;
                }
                return this.ctI.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.ctJ != null) {
                this.ctJ.onReturnDataInUI(t);
            }
        }
    }

    public static void aqp() {
        BdAsyncTask.removeAllTask(ctH);
    }
}
