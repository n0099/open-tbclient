package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class x {
    private static final BdUniqueId aZY = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aZY);

    public static <T> void a(w<T> wVar, h<T> hVar) {
        if (wVar != null) {
            a aVar = new a(wVar, hVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aZY);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(w<T> wVar, h<T> hVar) {
        if (wVar != null) {
            a aVar = new a(wVar, hVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aZY);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private w<T> aZZ;
        private h<T> baa;

        public a(w<T> wVar, h<T> hVar) {
            this.aZZ = null;
            this.baa = null;
            this.aZZ = wVar;
            this.baa = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public T doInBackground(String... strArr) {
            try {
                if (this.aZZ == null) {
                    return null;
                }
                return this.aZZ.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.baa != null) {
                this.baa.onReturnDataInUI(t);
            }
        }
    }

    public static void MU() {
        BdAsyncTask.removeAllTask(aZY);
    }
}
