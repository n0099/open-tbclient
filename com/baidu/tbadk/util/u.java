package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class u {
    private static final BdUniqueId aMB = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aMB);

    public static <T> void a(t<T> tVar, h<T> hVar) {
        if (tVar != null) {
            a aVar = new a(tVar, hVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aMB);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(t<T> tVar, h<T> hVar) {
        if (tVar != null) {
            a aVar = new a(tVar, hVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aMB);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private t<T> aMC;
        private h<T> aMD;

        public a(t<T> tVar, h<T> hVar) {
            this.aMC = null;
            this.aMD = null;
            this.aMC = tVar;
            this.aMD = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            try {
                if (this.aMC == null) {
                    return null;
                }
                return this.aMC.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aMD != null) {
                this.aMD.onReturnDataInUI(t);
            }
        }
    }

    public static void Hs() {
        BdAsyncTask.removeAllTask(aMB);
    }
}
