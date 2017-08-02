package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a {
    private static final String aWx = TbConfig.SERVER_ADDRESS + "c/c/bawu/appeal";

    /* loaded from: classes.dex */
    public interface b {
        void a(AppealData appealData);

        void b(AppealData appealData);
    }

    public static void a(String str, String str2, String str3, String str4, b bVar) {
        new C0069a(str, str2, str3, str4, bVar).execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.account.appeal.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0069a extends BdAsyncTask<String, Object, AppealData> {
        private String aWA;
        private String aWB;
        private WeakReference<b> aWC;
        private String aWy;
        private String aWz;

        public C0069a(String str, String str2, String str3, String str4, b bVar) {
            this.aWy = str;
            this.aWz = str2;
            this.aWA = str3;
            this.aWB = str4;
            this.aWC = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public AppealData doInBackground(String... strArr) {
            w wVar = new w(a.aWx);
            wVar.n("forum_id", this.aWy);
            wVar.n("user_id", this.aWz);
            wVar.n("user_name", this.aWA);
            wVar.n("content", this.aWB);
            String uE = wVar.uE();
            if (wVar.vb().vY().isRequestSuccess()) {
                try {
                    return (AppealData) OrmObject.objectWithJsonStr(uE, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = wVar.vf();
            appealData2.errMsg = wVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aWC.get();
            if (bVar != null) {
                if (appealData.errNo == 0 && al.isEmpty(appealData.errMsg)) {
                    bVar.a(appealData);
                } else {
                    bVar.b(appealData);
                }
            }
        }
    }
}
