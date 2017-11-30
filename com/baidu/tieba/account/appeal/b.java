package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private static final String bcK = TbConfig.SERVER_ADDRESS + "c/u/user/getreason";

    /* renamed from: com.baidu.tieba.account.appeal.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0074b {
        void a(ForbidReasonData forbidReasonData);

        void b(ForbidReasonData forbidReasonData);
    }

    public static void a(String str, String str2, InterfaceC0074b interfaceC0074b) {
        new a(str, str2, interfaceC0074b).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidReasonData> {
        private String bcF;
        private String bcG;
        private WeakReference<InterfaceC0074b> bcJ;

        public a(String str, String str2, InterfaceC0074b interfaceC0074b) {
            this.bcF = str;
            this.bcG = str2;
            this.bcJ = new WeakReference<>(interfaceC0074b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public ForbidReasonData doInBackground(String... strArr) {
            x xVar = new x(b.bcK);
            xVar.n("forum_id", this.bcF);
            xVar.n("user_id", this.bcG);
            String us = xVar.us();
            if (xVar.uQ().vO().isRequestSuccess()) {
                try {
                    ForbidReasonData forbidReasonData = (ForbidReasonData) OrmObject.objectWithJsonStr(us, ForbidReasonData.class);
                    forbidReasonData.reason = forbidReasonData.reason.replaceAll("\\\\n", "\n");
                    return forbidReasonData;
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidReasonData forbidReasonData2 = new ForbidReasonData();
                    forbidReasonData2.error.errno = -1000;
                    return forbidReasonData2;
                }
            }
            ForbidReasonData forbidReasonData3 = new ForbidReasonData();
            forbidReasonData3.error.errno = xVar.uU();
            forbidReasonData3.error.errMsg = xVar.getErrorString();
            return forbidReasonData3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidReasonData forbidReasonData) {
            super.onPostExecute(forbidReasonData);
            InterfaceC0074b interfaceC0074b = this.bcJ.get();
            if (interfaceC0074b != null) {
                if (forbidReasonData.error.errno == 0 && am.isEmpty(forbidReasonData.error.errMsg)) {
                    interfaceC0074b.a(forbidReasonData);
                } else {
                    interfaceC0074b.b(forbidReasonData);
                }
            }
        }
    }
}
