package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class t {
    private static final BdUniqueId aAl = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aAl);

    public static <T> void a(s<T> sVar, g<T> gVar) {
        if (sVar != null) {
            a aVar = new a(sVar, gVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aAl);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(s<T> sVar, g<T> gVar) {
        if (sVar != null) {
            a aVar = new a(sVar, gVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aAl);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private s<T> aAm;
        private g<T> aAn;

        public a(s<T> sVar, g<T> gVar) {
            this.aAm = null;
            this.aAn = null;
            this.aAm = sVar;
            this.aAn = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            try {
                if (this.aAm == null) {
                    return null;
                }
                return this.aAm.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aAn != null) {
                this.aAn.onReturnDataInUI(t);
            }
        }
    }

    public static void FA() {
        BdAsyncTask.removeAllTask(aAl);
    }
}
