package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class aa {
    private static final BdUniqueId cBT = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, cBT);

    public static <T> void a(z<T> zVar, k<T> kVar) {
        if (zVar != null) {
            a aVar = new a(zVar, kVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(cBT);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(z<T> zVar, k<T> kVar) {
        if (zVar != null) {
            a aVar = new a(zVar, kVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(cBT);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private z<T> cBU;
        private k<T> cBV;

        public a(z<T> zVar, k<T> kVar) {
            this.cBU = null;
            this.cBV = null;
            this.cBU = zVar;
            this.cBV = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            try {
                if (this.cBU == null) {
                    return null;
                }
                return this.cBU.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.cBV != null) {
                this.cBV.onReturnDataInUI(t);
            }
        }
    }

    public static void avr() {
        BdAsyncTask.removeAllTask(cBT);
    }
}
