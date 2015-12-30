package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class n {
    private static final BdUniqueId aCn = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aCn);

    public static <T> void a(m<T> mVar, d<T> dVar) {
        if (mVar != null) {
            a aVar = new a(mVar, dVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aCn);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(m<T> mVar, d<T> dVar) {
        if (mVar != null) {
            a aVar = new a(mVar, dVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aCn);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private m<T> aCo;
        private d<T> aCp;

        public a(m<T> mVar, d<T> dVar) {
            this.aCo = null;
            this.aCp = null;
            this.aCo = mVar;
            this.aCp = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public T doInBackground(String... strArr) {
            try {
                if (this.aCo == null) {
                    return null;
                }
                return this.aCo.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aCp != null) {
                this.aCp.onReturnDataInUI(t);
            }
        }
    }

    public static void Fl() {
        BdAsyncTask.removeAllTask(aCn);
    }
}
