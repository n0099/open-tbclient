package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class m {
    private static final BdUniqueId ayA = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ayA);

    public static <T> void a(l<T> lVar, d<T> dVar) {
        if (lVar != null) {
            a aVar = new a(lVar, dVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(ayA);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(l<T> lVar, d<T> dVar) {
        if (lVar != null) {
            a aVar = new a(lVar, dVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(ayA);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private l<T> ayB;
        private d<T> ayC;

        public a(l<T> lVar, d<T> dVar) {
            this.ayB = null;
            this.ayC = null;
            this.ayB = lVar;
            this.ayC = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public T doInBackground(String... strArr) {
            try {
                if (this.ayB == null) {
                    return null;
                }
                return this.ayB.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.ayC != null) {
                this.ayC.onReturnDataInUI(t);
            }
        }
    }

    public static void Eu() {
        BdAsyncTask.removeAllTask(ayA);
    }
}
