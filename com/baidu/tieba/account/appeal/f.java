package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.z;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String aWf = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private String aWg;
        private String aWh;
        private String aWi;
        private String aWj;
        private WeakReference<b> aWk;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aWg = str;
            this.aWh = str2;
            this.aWi = str3;
            this.aWj = str4;
            this.aWk = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public AppealData doInBackground(String... strArr) {
            z zVar = new z(f.aWf);
            zVar.n("forum_id", this.aWg);
            zVar.n("user_id", this.aWh);
            zVar.n("user_name", this.aWi);
            zVar.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aWj);
            String uY = zVar.uY();
            if (zVar.vw().wq().isRequestSuccess()) {
                try {
                    return (AppealData) OrmObject.objectWithJsonStr(uY, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = zVar.vA();
            appealData2.errMsg = zVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aWk.get();
            if (bVar != null) {
                if (appealData.errNo == 0 && au.isEmpty(appealData.errMsg)) {
                    bVar.a(appealData);
                } else {
                    bVar.b(appealData);
                }
            }
        }
    }
}
