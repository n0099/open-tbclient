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
    private static final String aJb = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private String aJc;
        private String aJd;
        private String aJe;
        private String aJf;
        private WeakReference<b> aJg;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aJc = str;
            this.aJd = str2;
            this.aJe = str3;
            this.aJf = str4;
            this.aJg = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public AppealData doInBackground(String... strArr) {
            ab abVar = new ab(f.aJb);
            abVar.n("forum_id", this.aJc);
            abVar.n("user_id", this.aJd);
            abVar.n("user_name", this.aJe);
            abVar.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aJf);
            String td = abVar.td();
            if (abVar.tB().uw().nZ()) {
                try {
                    return (AppealData) i.objectWithJsonStr(td, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = abVar.tF();
            appealData2.errMsg = abVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aJg.get();
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
