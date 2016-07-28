package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ba;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g {
    private static final String aNy = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/user/getreason";

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
        private String aNt;
        private String aNu;
        private WeakReference<b> aNx;

        public a(String str, String str2, b bVar) {
            this.aNt = str;
            this.aNu = str2;
            this.aNx = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public ForbidReasonData doInBackground(String... strArr) {
            ab abVar = new ab(g.aNy);
            abVar.n("forum_id", this.aNt);
            abVar.n("user_id", this.aNu);
            String sZ = abVar.sZ();
            if (abVar.tx().uv().nJ()) {
                try {
                    ForbidReasonData forbidReasonData = (ForbidReasonData) i.objectWithJsonStr(sZ, ForbidReasonData.class);
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
            forbidReasonData3.error.errno = abVar.tB();
            forbidReasonData3.error.errMsg = abVar.getErrorString();
            return forbidReasonData3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidReasonData forbidReasonData) {
            super.onPostExecute(forbidReasonData);
            b bVar = this.aNx.get();
            if (bVar != null) {
                if (forbidReasonData.error.errno == 0 && ba.isEmpty(forbidReasonData.error.errMsg)) {
                    bVar.a(forbidReasonData);
                } else {
                    bVar.b(forbidReasonData);
                }
            }
        }
    }
}
