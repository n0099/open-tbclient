package com.baidu.tieba.account.appeal;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a {
    private static final String bQC = TbConfig.SERVER_ADDRESS + "c/c/bawu/appeal";

    /* loaded from: classes.dex */
    public interface b {
        void a(AppealData appealData);

        void b(AppealData appealData);
    }

    public static void a(String str, String str2, String str3, String str4, b bVar) {
        new C0098a(str, str2, str3, str4, bVar).execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.account.appeal.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0098a extends BdAsyncTask<String, Object, AppealData> {
        private String bQD;
        private String bQE;
        private String bQF;
        private String bQG;
        private WeakReference<b> bQH;

        public C0098a(String str, String str2, String str3, String str4, b bVar) {
            this.bQD = str;
            this.bQE = str2;
            this.bQF = str3;
            this.bQG = str4;
            this.bQH = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public AppealData doInBackground(String... strArr) {
            x xVar = new x(a.bQC);
            xVar.n("forum_id", this.bQD);
            xVar.n("user_id", this.bQE);
            xVar.n("user_name", this.bQF);
            xVar.n("content", this.bQG);
            String BH = xVar.BH();
            if (xVar.Cf().Dc().isRequestSuccess()) {
                try {
                    return (AppealData) OrmObject.objectWithJsonStr(BH, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = xVar.Cj();
            appealData2.errMsg = xVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.bQH.get();
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
