package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class y {
    private static final BdUniqueId bjD = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, bjD);

    public static <T> void a(x<T> xVar, h<T> hVar) {
        if (xVar != null) {
            a aVar = new a(xVar, hVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(bjD);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(x<T> xVar, h<T> hVar) {
        if (xVar != null) {
            a aVar = new a(xVar, hVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(bjD);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private x<T> bjE;
        private h<T> bjF;

        public a(x<T> xVar, h<T> hVar) {
            this.bjE = null;
            this.bjF = null;
            this.bjE = xVar;
            this.bjF = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public T doInBackground(String... strArr) {
            try {
                if (this.bjE == null) {
                    return null;
                }
                return this.bjE.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.bjF != null) {
                this.bjF.onReturnDataInUI(t);
            }
        }
    }

    public static void QE() {
        BdAsyncTask.removeAllTask(bjD);
    }
}
