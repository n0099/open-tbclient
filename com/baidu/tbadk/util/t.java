package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class t {
    private static final BdUniqueId aJn = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aJn);

    public static <T> void a(s<T> sVar, f<T> fVar) {
        if (sVar != null) {
            a aVar = new a(sVar, fVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aJn);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(s<T> sVar, f<T> fVar) {
        if (sVar != null) {
            a aVar = new a(sVar, fVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aJn);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private s<T> aJo;
        private f<T> aJp;

        public a(s<T> sVar, f<T> fVar) {
            this.aJo = null;
            this.aJp = null;
            this.aJo = sVar;
            this.aJp = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            try {
                if (this.aJo == null) {
                    return null;
                }
                return this.aJo.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aJp != null) {
                this.aJp.onReturnDataInUI(t);
            }
        }
    }

    public static void Hu() {
        BdAsyncTask.removeAllTask(aJn);
    }
}
