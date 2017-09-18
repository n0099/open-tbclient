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
    private static final String aXz = TbConfig.SERVER_ADDRESS + "c/u/user/getreason";

    /* renamed from: com.baidu.tieba.account.appeal.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0072b {
        void a(ForbidReasonData forbidReasonData);

        void b(ForbidReasonData forbidReasonData);
    }

    public static void a(String str, String str2, InterfaceC0072b interfaceC0072b) {
        new a(str, str2, interfaceC0072b).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidReasonData> {
        private String aXu;
        private String aXv;
        private WeakReference<InterfaceC0072b> aXy;

        public a(String str, String str2, InterfaceC0072b interfaceC0072b) {
            this.aXu = str;
            this.aXv = str2;
            this.aXy = new WeakReference<>(interfaceC0072b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public ForbidReasonData doInBackground(String... strArr) {
            x xVar = new x(b.aXz);
            xVar.n("forum_id", this.aXu);
            xVar.n("user_id", this.aXv);
            String uM = xVar.uM();
            if (xVar.vj().wg().isRequestSuccess()) {
                try {
                    ForbidReasonData forbidReasonData = (ForbidReasonData) OrmObject.objectWithJsonStr(uM, ForbidReasonData.class);
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
            forbidReasonData3.error.errno = xVar.vn();
            forbidReasonData3.error.errMsg = xVar.getErrorString();
            return forbidReasonData3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidReasonData forbidReasonData) {
            super.onPostExecute(forbidReasonData);
            InterfaceC0072b interfaceC0072b = this.aXy.get();
            if (interfaceC0072b != null) {
                if (forbidReasonData.error.errno == 0 && am.isEmpty(forbidReasonData.error.errMsg)) {
                    interfaceC0072b.a(forbidReasonData);
                } else {
                    interfaceC0072b.b(forbidReasonData);
                }
            }
        }
    }
}
