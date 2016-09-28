package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.az;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String aTw = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private String aTA;
        private WeakReference<b> aTB;
        private String aTx;
        private String aTy;
        private String aTz;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aTx = str;
            this.aTy = str2;
            this.aTz = str3;
            this.aTA = str4;
            this.aTB = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public AppealData doInBackground(String... strArr) {
            ab abVar = new ab(f.aTw);
            abVar.n("forum_id", this.aTx);
            abVar.n("user_id", this.aTy);
            abVar.n("user_name", this.aTz);
            abVar.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aTA);
            String uu = abVar.uu();
            if (abVar.uS().vO().oF()) {
                try {
                    return (AppealData) i.objectWithJsonStr(uu, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = abVar.uW();
            appealData2.errMsg = abVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aTB.get();
            if (bVar != null) {
                if (appealData.errNo == 0 && az.isEmpty(appealData.errMsg)) {
                    bVar.a(appealData);
                } else {
                    bVar.b(appealData);
                }
            }
        }
    }
}
