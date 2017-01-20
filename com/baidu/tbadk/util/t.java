package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class t {
    private static final BdUniqueId aDy = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aDy);

    public static <T> void a(s<T> sVar, f<T> fVar) {
        if (sVar != null) {
            a aVar = new a(sVar, fVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aDy);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(s<T> sVar, f<T> fVar) {
        if (sVar != null) {
            a aVar = new a(sVar, fVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aDy);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private f<T> aDA;
        private s<T> aDz;

        public a(s<T> sVar, f<T> fVar) {
            this.aDz = null;
            this.aDA = null;
            this.aDz = sVar;
            this.aDA = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            try {
                if (this.aDz == null) {
                    return null;
                }
                return this.aDz.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aDA != null) {
                this.aDA.onReturnDataInUI(t);
            }
        }
    }

    public static void Gw() {
        BdAsyncTask.removeAllTask(aDy);
    }
}
