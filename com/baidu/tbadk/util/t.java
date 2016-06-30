package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class t {
    private static final BdUniqueId aBd = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aBd);

    public static <T> void a(s<T> sVar, g<T> gVar) {
        if (sVar != null) {
            a aVar = new a(sVar, gVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aBd);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(s<T> sVar, g<T> gVar) {
        if (sVar != null) {
            a aVar = new a(sVar, gVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aBd);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private s<T> aBe;
        private g<T> aBf;

        public a(s<T> sVar, g<T> gVar) {
            this.aBe = null;
            this.aBf = null;
            this.aBe = sVar;
            this.aBf = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            try {
                if (this.aBe == null) {
                    return null;
                }
                return this.aBe.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aBf != null) {
                this.aBf.onReturnDataInUI(t);
            }
        }
    }

    public static void FJ() {
        BdAsyncTask.removeAllTask(aBd);
    }
}
