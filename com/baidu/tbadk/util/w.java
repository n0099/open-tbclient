package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class w {
    private static final BdUniqueId aVJ = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aVJ);

    public static <T> void a(v<T> vVar, h<T> hVar) {
        if (vVar != null) {
            a aVar = new a(vVar, hVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aVJ);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(v<T> vVar, h<T> hVar) {
        if (vVar != null) {
            a aVar = new a(vVar, hVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aVJ);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private v<T> aVK;
        private h<T> aVL;

        public a(v<T> vVar, h<T> hVar) {
            this.aVK = null;
            this.aVL = null;
            this.aVK = vVar;
            this.aVL = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            try {
                if (this.aVK == null) {
                    return null;
                }
                return this.aVK.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aVL != null) {
                this.aVL.onReturnDataInUI(t);
            }
        }
    }

    public static void Ll() {
        BdAsyncTask.removeAllTask(aVJ);
    }
}
