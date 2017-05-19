package com.baidu.tbadk.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class w {
    private static final BdUniqueId aJu = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, aJu);

    public static <T> void a(v<T> vVar, g<T> gVar) {
        if (vVar != null) {
            a aVar = new a(vVar, gVar);
            aVar.setParallel(sBdAsyncTaskParallel);
            aVar.setTag(aJu);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void b(v<T> vVar, g<T> gVar) {
        if (vVar != null) {
            a aVar = new a(vVar, gVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(aJu);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        private v<T> aJv;
        private g<T> aJw;

        public a(v<T> vVar, g<T> gVar) {
            this.aJv = null;
            this.aJw = null;
            this.aJv = vVar;
            this.aJw = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            try {
                if (this.aJv == null) {
                    return null;
                }
                return this.aJv.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.aJw != null) {
                this.aJw.onReturnDataInUI(t);
            }
        }
    }

    public static void GF() {
        BdAsyncTask.removeAllTask(aJu);
    }
}
