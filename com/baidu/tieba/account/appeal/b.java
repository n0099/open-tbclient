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
    private static final String aYZ = TbConfig.SERVER_ADDRESS + "c/u/user/getreason";

    /* renamed from: com.baidu.tieba.account.appeal.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0073b {
        void a(ForbidReasonData forbidReasonData);

        void b(ForbidReasonData forbidReasonData);
    }

    public static void a(String str, String str2, InterfaceC0073b interfaceC0073b) {
        new a(str, str2, interfaceC0073b).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidReasonData> {
        private String aYU;
        private String aYV;
        private WeakReference<InterfaceC0073b> aYY;

        public a(String str, String str2, InterfaceC0073b interfaceC0073b) {
            this.aYU = str;
            this.aYV = str2;
            this.aYY = new WeakReference<>(interfaceC0073b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public ForbidReasonData doInBackground(String... strArr) {
            x xVar = new x(b.aYZ);
            xVar.n("forum_id", this.aYU);
            xVar.n("user_id", this.aYV);
            String ui = xVar.ui();
            if (xVar.uG().vD().isRequestSuccess()) {
                try {
                    ForbidReasonData forbidReasonData = (ForbidReasonData) OrmObject.objectWithJsonStr(ui, ForbidReasonData.class);
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
            forbidReasonData3.error.errno = xVar.uK();
            forbidReasonData3.error.errMsg = xVar.getErrorString();
            return forbidReasonData3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidReasonData forbidReasonData) {
            super.onPostExecute(forbidReasonData);
            InterfaceC0073b interfaceC0073b = this.aYY.get();
            if (interfaceC0073b != null) {
                if (forbidReasonData.error.errno == 0 && am.isEmpty(forbidReasonData.error.errMsg)) {
                    interfaceC0073b.a(forbidReasonData);
                } else {
                    interfaceC0073b.b(forbidReasonData);
                }
            }
        }
    }
}
