package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.z;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String aVx = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private String aVA;
        private String aVB;
        private WeakReference<b> aVC;
        private String aVy;
        private String aVz;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aVy = str;
            this.aVz = str2;
            this.aVA = str3;
            this.aVB = str4;
            this.aVC = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public AppealData doInBackground(String... strArr) {
            z zVar = new z(f.aVx);
            zVar.n("forum_id", this.aVy);
            zVar.n("user_id", this.aVz);
            zVar.n("user_name", this.aVA);
            zVar.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aVB);
            String uy = zVar.uy();
            if (zVar.uW().vS().oH()) {
                try {
                    return (AppealData) i.objectWithJsonStr(uy, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = zVar.va();
            appealData2.errMsg = zVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aVC.get();
            if (bVar != null) {
                if (appealData.errNo == 0 && ax.isEmpty(appealData.errMsg)) {
                    bVar.a(appealData);
                } else {
                    bVar.b(appealData);
                }
            }
        }
    }
}
