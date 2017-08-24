package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private static final String aXQ = TbConfig.SERVER_ADDRESS + "c/u/user/getreason";

    /* renamed from: com.baidu.tieba.account.appeal.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070b {
        void a(ForbidReasonData forbidReasonData);

        void b(ForbidReasonData forbidReasonData);
    }

    public static void a(String str, String str2, InterfaceC0070b interfaceC0070b) {
        new a(str, str2, interfaceC0070b).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidReasonData> {
        private String aXL;
        private String aXM;
        private WeakReference<InterfaceC0070b> aXP;

        public a(String str, String str2, InterfaceC0070b interfaceC0070b) {
            this.aXL = str;
            this.aXM = str2;
            this.aXP = new WeakReference<>(interfaceC0070b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public ForbidReasonData doInBackground(String... strArr) {
            w wVar = new w(b.aXQ);
            wVar.n("forum_id", this.aXL);
            wVar.n("user_id", this.aXM);
            String uP = wVar.uP();
            if (wVar.vm().wj().isRequestSuccess()) {
                try {
                    ForbidReasonData forbidReasonData = (ForbidReasonData) OrmObject.objectWithJsonStr(uP, ForbidReasonData.class);
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
            forbidReasonData3.error.errno = wVar.vq();
            forbidReasonData3.error.errMsg = wVar.getErrorString();
            return forbidReasonData3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidReasonData forbidReasonData) {
            super.onPostExecute(forbidReasonData);
            InterfaceC0070b interfaceC0070b = this.aXP.get();
            if (interfaceC0070b != null) {
                if (forbidReasonData.error.errno == 0 && al.isEmpty(forbidReasonData.error.errMsg)) {
                    interfaceC0070b.a(forbidReasonData);
                } else {
                    interfaceC0070b.b(forbidReasonData);
                }
            }
        }
    }
}
