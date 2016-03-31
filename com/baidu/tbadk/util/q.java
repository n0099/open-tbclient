package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class q {
    private static final BdUniqueId aEb = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aEb);

    public static <T> void a(p<T> pVar, g<T> gVar) {
        if (pVar != null) {
            a aVar = new a(pVar, gVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aEb);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(p<T> pVar, g<T> gVar) {
        if (pVar != null) {
            a aVar = new a(pVar, gVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aEb);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private p<T> aEc;
        private g<T> aEd;

        public a(p<T> pVar, g<T> gVar) {
            this.aEc = null;
            this.aEd = null;
            this.aEc = pVar;
            this.aEd = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public T doInBackground(String... strArr) {
            try {
                if (this.aEc == null) {
                    return null;
                }
                return this.aEc.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aEd != null) {
                this.aEd.onReturnDataInUI(t);
            }
        }
    }

    public static void Hz() {
        BdAsyncTask.removeAllTask(aEb);
    }
}
