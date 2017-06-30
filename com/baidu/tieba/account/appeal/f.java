package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aw;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String aVw = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

    /* loaded from: classes.dex */
    public interface b {
        void a(AppealData appealData);

        void b(AppealData appealData);
    }

    public static void a(String str, String str2, String str3, String str4, b bVar) {
        new a(str, str2, str3, str4, bVar).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Object, AppealData> {
        private String aVA;
        private WeakReference<b> aVB;
        private String aVx;
        private String aVy;
        private String aVz;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aVx = str;
            this.aVy = str2;
            this.aVz = str3;
            this.aVA = str4;
            this.aVB = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public AppealData doInBackground(String... strArr) {
            ab abVar = new ab(f.aVw);
            abVar.n("forum_id", this.aVx);
            abVar.n("user_id", this.aVy);
            abVar.n("user_name", this.aVz);
            abVar.n("content", this.aVA);
            String uy = abVar.uy();
            if (abVar.uV().vS().isRequestSuccess()) {
                try {
                    return (AppealData) OrmObject.objectWithJsonStr(uy, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = abVar.uZ();
            appealData2.errMsg = abVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aVB.get();
            if (bVar != null) {
                if (appealData.errNo == 0 && aw.isEmpty(appealData.errMsg)) {
                    bVar.a(appealData);
                } else {
                    bVar.b(appealData);
                }
            }
        }
    }
}
