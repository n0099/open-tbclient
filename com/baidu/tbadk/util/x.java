package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class x {
    private static final BdUniqueId biQ = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, biQ);

    public static <T> void a(w<T> wVar, h<T> hVar) {
        if (wVar != null) {
            a aVar = new a(wVar, hVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(biQ);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(w<T> wVar, h<T> hVar) {
        if (wVar != null) {
            a aVar = new a(wVar, hVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(biQ);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private w<T> biR;
        private h<T> biS;

        public a(w<T> wVar, h<T> hVar) {
            this.biR = null;
            this.biS = null;
            this.biR = wVar;
            this.biS = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public T doInBackground(String... strArr) {
            try {
                if (this.biR == null) {
                    return null;
                }
                return this.biR.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.biS != null) {
                this.biS.onReturnDataInUI(t);
            }
        }
    }

    public static void Qj() {
        BdAsyncTask.removeAllTask(biQ);
    }
}
