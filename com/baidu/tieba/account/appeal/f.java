package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ba;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String aSM = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private String aSN;
        private String aSO;
        private String aSP;
        private String aSQ;
        private WeakReference<b> aSR;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aSN = str;
            this.aSO = str2;
            this.aSP = str3;
            this.aSQ = str4;
            this.aSR = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public AppealData doInBackground(String... strArr) {
            ab abVar = new ab(f.aSM);
            abVar.n("forum_id", this.aSN);
            abVar.n("user_id", this.aSO);
            abVar.n("user_name", this.aSP);
            abVar.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aSQ);
            String ue = abVar.ue();
            if (abVar.uD().vA().oE()) {
                try {
                    return (AppealData) i.objectWithJsonStr(ue, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = abVar.uH();
            appealData2.errMsg = abVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aSR.get();
            if (bVar != null) {
                if (appealData.errNo == 0 && ba.isEmpty(appealData.errMsg)) {
                    bVar.a(appealData);
                } else {
                    bVar.b(appealData);
                }
            }
        }
    }
}
