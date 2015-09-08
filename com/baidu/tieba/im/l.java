package com.baidu.tieba.im;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class l {
    private static final BdUniqueId bnm = BdUniqueId.gen();

    public static <T> void a(h<T> hVar, g<T> gVar) {
        if (hVar != null) {
            a aVar = new a(hVar, gVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(bnm);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private static class a<T> extends BdAsyncTask<String, Object, T> {
        private h<T> bnn;
        private g<T> bno;

        public a(h<T> hVar, g<T> gVar) {
            this.bnn = null;
            this.bno = null;
            this.bnn = hVar;
            this.bno = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public T doInBackground(String... strArr) {
            try {
                if (this.bnn == null) {
                    return null;
                }
                return this.bnn.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.bno != null) {
                this.bno.onReturnDataInUI(t);
            }
        }
    }

    public static void QF() {
        BdAsyncTask.removeAllTask(bnm);
    }
}
