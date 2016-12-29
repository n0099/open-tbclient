package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.z;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String aUO = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private String aUP;
        private String aUQ;
        private String aUR;
        private String aUS;
        private WeakReference<b> aUT;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aUP = str;
            this.aUQ = str2;
            this.aUR = str3;
            this.aUS = str4;
            this.aUT = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public AppealData doInBackground(String... strArr) {
            z zVar = new z(f.aUO);
            zVar.n("forum_id", this.aUP);
            zVar.n("user_id", this.aUQ);
            zVar.n("user_name", this.aUR);
            zVar.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aUS);
            String uk = zVar.uk();
            if (zVar.uI().vC().oH()) {
                try {
                    return (AppealData) i.objectWithJsonStr(uk, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = zVar.uM();
            appealData2.errMsg = zVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aUT.get();
            if (bVar != null) {
                if (appealData.errNo == 0 && av.isEmpty(appealData.errMsg)) {
                    bVar.a(appealData);
                } else {
                    bVar.b(appealData);
                }
            }
        }
    }
}
