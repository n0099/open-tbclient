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
    private static final String aMy = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private String aMA;
        private String aMB;
        private String aMC;
        private WeakReference<b> aMD;
        private String aMz;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aMz = str;
            this.aMA = str2;
            this.aMB = str3;
            this.aMC = str4;
            this.aMD = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public AppealData doInBackground(String... strArr) {
            ab abVar = new ab(f.aMy);
            abVar.n("forum_id", this.aMz);
            abVar.n("user_id", this.aMA);
            abVar.n("user_name", this.aMB);
            abVar.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aMC);
            String ta = abVar.ta();
            if (abVar.ty().uv().nU()) {
                try {
                    return (AppealData) i.objectWithJsonStr(ta, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = abVar.tC();
            appealData2.errMsg = abVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aMD.get();
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
