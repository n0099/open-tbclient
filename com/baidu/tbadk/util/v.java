package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class v {
    private static final BdUniqueId aMJ = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aMJ);

    public static <T> void a(u<T> uVar, h<T> hVar) {
        if (uVar != null) {
            a aVar = new a(uVar, hVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aMJ);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(u<T> uVar, h<T> hVar) {
        if (uVar != null) {
            a aVar = new a(uVar, hVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aMJ);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private u<T> aMK;
        private h<T> aML;

        public a(u<T> uVar, h<T> hVar) {
            this.aMK = null;
            this.aML = null;
            this.aMK = uVar;
            this.aML = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            try {
                if (this.aMK == null) {
                    return null;
                }
                return this.aMK.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aML != null) {
                this.aML.onReturnDataInUI(t);
            }
        }
    }

    public static void Hn() {
        BdAsyncTask.removeAllTask(aMJ);
    }
}
