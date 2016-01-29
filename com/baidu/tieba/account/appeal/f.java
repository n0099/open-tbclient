package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aw;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String aJV = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private String aJW;
        private String aJX;
        private String aJY;
        private String aJZ;
        private WeakReference<b> aKa;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aJW = str;
            this.aJX = str2;
            this.aJY = str3;
            this.aJZ = str4;
            this.aKa = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public AppealData doInBackground(String... strArr) {
            aa aaVar = new aa(f.aJV);
            aaVar.p("forum_id", this.aJW);
            aaVar.p("user_id", this.aJX);
            aaVar.p("user_name", this.aJY);
            aaVar.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aJZ);
            String uZ = aaVar.uZ();
            if (aaVar.vB().ww().rl()) {
                try {
                    return (AppealData) i.objectWithJsonStr(uZ, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = aaVar.vF();
            appealData2.errMsg = aaVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aKa.get();
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
