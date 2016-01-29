package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aw;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g {
    private static final String aKb = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/user/getreason";

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
        private String aJW;
        private String aJX;
        private WeakReference<b> aKa;

        public a(String str, String str2, b bVar) {
            this.aJW = str;
            this.aJX = str2;
            this.aKa = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public ForbidReasonData doInBackground(String... strArr) {
            aa aaVar = new aa(g.aKb);
            aaVar.p("forum_id", this.aJW);
            aaVar.p("user_id", this.aJX);
            String uZ = aaVar.uZ();
            if (aaVar.vB().ww().rl()) {
                try {
                    ForbidReasonData forbidReasonData = (ForbidReasonData) i.objectWithJsonStr(uZ, ForbidReasonData.class);
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
            forbidReasonData3.error.errno = aaVar.vF();
            forbidReasonData3.error.errMsg = aaVar.getErrorString();
            return forbidReasonData3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidReasonData forbidReasonData) {
            super.onPostExecute(forbidReasonData);
            b bVar = this.aKa.get();
            if (bVar != null) {
                if (forbidReasonData.error.errno == 0 && aw.isEmpty(forbidReasonData.error.errMsg)) {
                    bVar.a(forbidReasonData);
                } else {
                    bVar.b(forbidReasonData);
                }
            }
        }
    }
}
