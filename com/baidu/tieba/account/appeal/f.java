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
    private static final String aNs = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private String aNt;
        private String aNu;
        private String aNv;
        private String aNw;
        private WeakReference<b> aNx;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aNt = str;
            this.aNu = str2;
            this.aNv = str3;
            this.aNw = str4;
            this.aNx = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public AppealData doInBackground(String... strArr) {
            ab abVar = new ab(f.aNs);
            abVar.n("forum_id", this.aNt);
            abVar.n("user_id", this.aNu);
            abVar.n("user_name", this.aNv);
            abVar.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aNw);
            String sZ = abVar.sZ();
            if (abVar.tx().uv().nJ()) {
                try {
                    return (AppealData) i.objectWithJsonStr(sZ, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = abVar.tB();
            appealData2.errMsg = abVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aNx.get();
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
