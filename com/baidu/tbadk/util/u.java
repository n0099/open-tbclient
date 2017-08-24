package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class u {
    private static final BdUniqueId aMV = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aMV);

    public static <T> void a(t<T> tVar, h<T> hVar) {
        if (tVar != null) {
            a aVar = new a(tVar, hVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aMV);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(t<T> tVar, h<T> hVar) {
        if (tVar != null) {
            a aVar = new a(tVar, hVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aMV);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private t<T> aMW;
        private h<T> aMX;

        public a(t<T> tVar, h<T> hVar) {
            this.aMW = null;
            this.aMX = null;
            this.aMW = tVar;
            this.aMX = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            try {
                if (this.aMW == null) {
                    return null;
                }
                return this.aMW.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aMX != null) {
                this.aMX.onReturnDataInUI(t);
            }
        }
    }

    public static void Ht() {
        BdAsyncTask.removeAllTask(aMV);
    }
}
