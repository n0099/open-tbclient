package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ay;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String aMR = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private String aMS;
        private String aMT;
        private String aMU;
        private String aMV;
        private WeakReference<b> aMW;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aMS = str;
            this.aMT = str2;
            this.aMU = str3;
            this.aMV = str4;
            this.aMW = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public AppealData doInBackground(String... strArr) {
            ab abVar = new ab(f.aMR);
            abVar.p("forum_id", this.aMS);
            abVar.p("user_id", this.aMT);
            abVar.p("user_name", this.aMU);
            abVar.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aMV);
            String vw = abVar.vw();
            if (abVar.vU().wP().qC()) {
                try {
                    return (AppealData) i.objectWithJsonStr(vw, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = abVar.vY();
            appealData2.errMsg = abVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aMW.get();
            if (bVar != null) {
                if (appealData.errNo == 0 && ay.isEmpty(appealData.errMsg)) {
                    bVar.a(appealData);
                } else {
                    bVar.b(appealData);
                }
            }
        }
    }
}
