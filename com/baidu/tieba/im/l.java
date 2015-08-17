package com.baidu.tieba.im;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class l {
    private static final BdUniqueId bmO = BdUniqueId.gen();

    public static <T> void a(h<T> hVar, g<T> gVar) {
        if (hVar != null) {
            a aVar = new a(hVar, gVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(bmO);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private static class a<T> extends BdAsyncTask<String, Object, T> {
        private h<T> bmP;
        private g<T> bmQ;

        public a(h<T> hVar, g<T> gVar) {
            this.bmP = null;
            this.bmQ = null;
            this.bmP = hVar;
            this.bmQ = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public T doInBackground(String... strArr) {
            try {
                if (this.bmP == null) {
                    return null;
                }
                return this.bmP.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.bmQ != null) {
                this.bmQ.onReturnDataInUI(t);
            }
        }
    }

    public static void QD() {
        BdAsyncTask.removeAllTask(bmO);
    }
}
