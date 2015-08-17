package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String aFv = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private WeakReference<b> aFA;
        private String aFw;
        private String aFx;
        private String aFy;
        private String aFz;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aFw = str;
            this.aFx = str2;
            this.aFy = str3;
            this.aFz = str4;
            this.aFA = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public AppealData doInBackground(String... strArr) {
            v vVar = new v(f.aFv);
            vVar.o("forum_id", this.aFw);
            vVar.o("user_id", this.aFx);
            vVar.o("user_name", this.aFy);
            vVar.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aFz);
            String tD = vVar.tD();
            if (vVar.ue().uW().rb()) {
                try {
                    return (AppealData) i.objectWithJsonStr(tD, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = vVar.ui();
            appealData2.errMsg = vVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aFA.get();
            if (bVar != null) {
                if (appealData.errNo == 0 && aq.isEmpty(appealData.errMsg)) {
                    bVar.a(appealData);
                } else {
                    bVar.b(appealData);
                }
            }
        }
    }
}
