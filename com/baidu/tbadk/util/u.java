package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class u {
    private static final BdUniqueId aFa = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aFa);

    public static <T> void a(t<T> tVar, g<T> gVar) {
        if (tVar != null) {
            a aVar = new a(tVar, gVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aFa);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(t<T> tVar, g<T> gVar) {
        if (tVar != null) {
            a aVar = new a(tVar, gVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aFa);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private t<T> aFb;
        private g<T> aFc;

        public a(t<T> tVar, g<T> gVar) {
            this.aFb = null;
            this.aFc = null;
            this.aFb = tVar;
            this.aFc = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            try {
                if (this.aFb == null) {
                    return null;
                }
                return this.aFb.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aFc != null) {
                this.aFc.onReturnDataInUI(t);
            }
        }
    }

    public static void Hg() {
        BdAsyncTask.removeAllTask(aFa);
    }
}
