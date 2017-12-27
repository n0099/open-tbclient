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
    private static final String bQv = TbConfig.SERVER_ADDRESS + "c/c/bawu/appeal";

    /* loaded from: classes.dex */
    public interface b {
        void a(AppealData appealData);

        void b(AppealData appealData);
    }

    public static void a(String str, String str2, String str3, String str4, b bVar) {
        new C0099a(str, str2, str3, str4, bVar).execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.account.appeal.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0099a extends BdAsyncTask<String, Object, AppealData> {
        private WeakReference<b> bQA;
        private String bQw;
        private String bQx;
        private String bQy;
        private String bQz;

        public C0099a(String str, String str2, String str3, String str4, b bVar) {
            this.bQw = str;
            this.bQx = str2;
            this.bQy = str3;
            this.bQz = str4;
            this.bQA = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public AppealData doInBackground(String... strArr) {
            x xVar = new x(a.bQv);
            xVar.n("forum_id", this.bQw);
            xVar.n("user_id", this.bQx);
            xVar.n("user_name", this.bQy);
            xVar.n("content", this.bQz);
            String BP = xVar.BP();
            if (xVar.Cn().Dl().isRequestSuccess()) {
                try {
                    return (AppealData) OrmObject.objectWithJsonStr(BP, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = xVar.Cr();
            appealData2.errMsg = xVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.bQA.get();
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
