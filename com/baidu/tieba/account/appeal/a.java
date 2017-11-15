package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a {
    private static final String aZs = TbConfig.SERVER_ADDRESS + "c/c/bawu/appeal";

    /* loaded from: classes.dex */
    public interface b {
        void a(AppealData appealData);

        void b(AppealData appealData);
    }

    public static void a(String str, String str2, String str3, String str4, b bVar) {
        new C0072a(str, str2, str3, str4, bVar).execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.account.appeal.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0072a extends BdAsyncTask<String, Object, AppealData> {
        private String aZt;
        private String aZu;
        private String aZv;
        private String aZw;
        private WeakReference<b> aZx;

        public C0072a(String str, String str2, String str3, String str4, b bVar) {
            this.aZt = str;
            this.aZu = str2;
            this.aZv = str3;
            this.aZw = str4;
            this.aZx = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public AppealData doInBackground(String... strArr) {
            x xVar = new x(a.aZs);
            xVar.n("forum_id", this.aZt);
            xVar.n("user_id", this.aZu);
            xVar.n("user_name", this.aZv);
            xVar.n("content", this.aZw);
            String up = xVar.up();
            if (xVar.uN().vL().isRequestSuccess()) {
                try {
                    return (AppealData) OrmObject.objectWithJsonStr(up, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = xVar.uR();
            appealData2.errMsg = xVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aZx.get();
            if (bVar != null) {
                if (appealData.errNo == 0 && am.isEmpty(appealData.errMsg)) {
                    bVar.a(appealData);
                } else {
                    bVar.b(appealData);
                }
            }
        }
    }
}
