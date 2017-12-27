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
public class b {
    private static final String bQB = TbConfig.SERVER_ADDRESS + "c/u/user/getreason";

    /* renamed from: com.baidu.tieba.account.appeal.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0100b {
        void a(ForbidReasonData forbidReasonData);

        void b(ForbidReasonData forbidReasonData);
    }

    public static void a(String str, String str2, InterfaceC0100b interfaceC0100b) {
        new a(str, str2, interfaceC0100b).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidReasonData> {
        private WeakReference<InterfaceC0100b> bQA;
        private String bQw;
        private String bQx;

        public a(String str, String str2, InterfaceC0100b interfaceC0100b) {
            this.bQw = str;
            this.bQx = str2;
            this.bQA = new WeakReference<>(interfaceC0100b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public ForbidReasonData doInBackground(String... strArr) {
            x xVar = new x(b.bQB);
            xVar.n("forum_id", this.bQw);
            xVar.n("user_id", this.bQx);
            String BP = xVar.BP();
            if (xVar.Cn().Dl().isRequestSuccess()) {
                try {
                    ForbidReasonData forbidReasonData = (ForbidReasonData) OrmObject.objectWithJsonStr(BP, ForbidReasonData.class);
                    forbidReasonData.reason = forbidReasonData.reason.replaceAll("\\\\n", "\n");
                    return forbidReasonData;
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidReasonData forbidReasonData2 = new ForbidReasonData();
                    forbidReasonData2.error.errno = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidReasonData2;
                }
            }
            ForbidReasonData forbidReasonData3 = new ForbidReasonData();
            forbidReasonData3.error.errno = xVar.Cr();
            forbidReasonData3.error.errMsg = xVar.getErrorString();
            return forbidReasonData3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidReasonData forbidReasonData) {
            super.onPostExecute(forbidReasonData);
            InterfaceC0100b interfaceC0100b = this.bQA.get();
            if (interfaceC0100b != null) {
                if (forbidReasonData.error.errno == 0 && am.isEmpty(forbidReasonData.error.errMsg)) {
                    interfaceC0100b.a(forbidReasonData);
                } else {
                    interfaceC0100b.b(forbidReasonData);
                }
            }
        }
    }
}
