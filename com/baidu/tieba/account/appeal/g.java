package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g {
    private static final String aEv = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/user/getreason";

    /* loaded from: classes.dex */
    public interface b {
        void a(ForbidReasonData forbidReasonData);

        void b(ForbidReasonData forbidReasonData);
    }

    public static void a(String str, String str2, b bVar) {
        new a(str, str2, bVar).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidReasonData> {
        private String aEq;
        private String aEr;
        private WeakReference<b> aEu;

        public a(String str, String str2, b bVar) {
            this.aEq = str;
            this.aEr = str2;
            this.aEu = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public ForbidReasonData doInBackground(String... strArr) {
            w wVar = new w(g.aEv);
            wVar.o("forum_id", this.aEq);
            wVar.o("user_id", this.aEr);
            String tG = wVar.tG();
            if (wVar.uh().va().qT()) {
                try {
                    ForbidReasonData forbidReasonData = (ForbidReasonData) i.objectWithJsonStr(tG, ForbidReasonData.class);
                    forbidReasonData.reason = forbidReasonData.reason.replaceAll("\\\\n", "\n");
                    return forbidReasonData;
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidReasonData forbidReasonData2 = new ForbidReasonData();
                    forbidReasonData2.error.errno = -1000;
                    return forbidReasonData2;
                }
            }
            ForbidReasonData forbidReasonData3 = new ForbidReasonData();
            forbidReasonData3.error.errno = wVar.ul();
            forbidReasonData3.error.errMsg = wVar.getErrorString();
            return forbidReasonData3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidReasonData forbidReasonData) {
            super.onPostExecute(forbidReasonData);
            b bVar = this.aEu.get();
            if (bVar != null) {
                if (forbidReasonData.error.errno == 0 && as.isEmpty(forbidReasonData.error.errMsg)) {
                    bVar.a(forbidReasonData);
                } else {
                    bVar.b(forbidReasonData);
                }
            }
        }
    }
}
