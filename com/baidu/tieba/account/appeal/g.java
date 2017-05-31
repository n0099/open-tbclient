package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.z;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g {
    private static final String aUj = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/user/getreason";

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
        private String aUe;
        private String aUf;
        private WeakReference<b> aUi;

        public a(String str, String str2, b bVar) {
            this.aUe = str;
            this.aUf = str2;
            this.aUi = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public ForbidReasonData doInBackground(String... strArr) {
            z zVar = new z(g.aUj);
            zVar.n("forum_id", this.aUe);
            zVar.n("user_id", this.aUf);
            String ug = zVar.ug();
            if (zVar.uF().vB().isRequestSuccess()) {
                try {
                    ForbidReasonData forbidReasonData = (ForbidReasonData) OrmObject.objectWithJsonStr(ug, ForbidReasonData.class);
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
            forbidReasonData3.error.errno = zVar.uJ();
            forbidReasonData3.error.errMsg = zVar.getErrorString();
            return forbidReasonData3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidReasonData forbidReasonData) {
            super.onPostExecute(forbidReasonData);
            b bVar = this.aUi.get();
            if (bVar != null) {
                if (forbidReasonData.error.errno == 0 && au.isEmpty(forbidReasonData.error.errMsg)) {
                    bVar.a(forbidReasonData);
                } else {
                    bVar.b(forbidReasonData);
                }
            }
        }
    }
}
