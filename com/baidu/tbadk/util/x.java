package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class x {
    private static final BdUniqueId bfn = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, bfn);

    public static <T> void a(w<T> wVar, h<T> hVar) {
        if (wVar != null) {
            a aVar = new a(wVar, hVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(bfn);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(w<T> wVar, h<T> hVar) {
        if (wVar != null) {
            a aVar = new a(wVar, hVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(bfn);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private w<T> bfo;
        private h<T> bfp;

        public a(w<T> wVar, h<T> hVar) {
            this.bfo = null;
            this.bfp = null;
            this.bfo = wVar;
            this.bfp = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public T doInBackground(String... strArr) {
            try {
                if (this.bfo == null) {
                    return null;
                }
                return this.bfo.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.bfp != null) {
                this.bfp.onReturnDataInUI(t);
            }
        }
    }

    public static void Pb() {
        BdAsyncTask.removeAllTask(bfn);
    }
}
