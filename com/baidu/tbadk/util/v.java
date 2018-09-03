package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class v {
    private static final BdUniqueId aWG = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aWG);

    public static <T> void a(u<T> uVar, g<T> gVar) {
        if (uVar != null) {
            a aVar = new a(uVar, gVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aWG);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(u<T> uVar, g<T> gVar) {
        if (uVar != null) {
            a aVar = new a(uVar, gVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aWG);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private u<T> aWH;
        private g<T> aWI;

        public a(u<T> uVar, g<T> gVar) {
            this.aWH = null;
            this.aWI = null;
            this.aWH = uVar;
            this.aWI = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            try {
                if (this.aWH == null) {
                    return null;
                }
                return this.aWH.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aWI != null) {
                this.aWI.onReturnDataInUI(t);
            }
        }
    }

    public static void LC() {
        BdAsyncTask.removeAllTask(aWG);
    }
}
