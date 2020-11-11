package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ae {
    private static final BdUniqueId fzc = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, fzc);

    public static <T> void a(ad<T> adVar, m<T> mVar) {
        if (adVar != null) {
            a aVar = new a(adVar, mVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(fzc);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(ad<T> adVar, m<T> mVar) {
        if (adVar != null) {
            a aVar = new a(adVar, mVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(fzc);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private ad<T> fzd;
        private m<T> fze;

        public a(ad<T> adVar, m<T> mVar) {
            this.fzd = null;
            this.fze = null;
            this.fzd = adVar;
            this.fze = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            try {
                if (this.fzd == null) {
                    return null;
                }
                return this.fzd.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.fze != null) {
                this.fze.onReturnDataInUI(t);
            }
        }
    }

    public static void clearQueue() {
        BdAsyncTask.removeAllTask(fzc);
    }
}
