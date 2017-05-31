package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class w {
    private static final BdUniqueId aJh = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aJh);

    public static <T> void a(v<T> vVar, g<T> gVar) {
        if (vVar != null) {
            a aVar = new a(vVar, gVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aJh);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(v<T> vVar, g<T> gVar) {
        if (vVar != null) {
            a aVar = new a(vVar, gVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aJh);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private v<T> aJi;
        private g<T> aJj;

        public a(v<T> vVar, g<T> gVar) {
            this.aJi = null;
            this.aJj = null;
            this.aJi = vVar;
            this.aJj = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            try {
                if (this.aJi == null) {
                    return null;
                }
                return this.aJi.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aJj != null) {
                this.aJj.onReturnDataInUI(t);
            }
        }
    }

    public static void Gz() {
        BdAsyncTask.removeAllTask(aJh);
    }
}
