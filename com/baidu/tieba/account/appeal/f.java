package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ax;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String aHo = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private String aHp;
        private String aHq;
        private String aHr;
        private String aHs;
        private WeakReference<b> aHt;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aHp = str;
            this.aHq = str2;
            this.aHr = str3;
            this.aHs = str4;
            this.aHt = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public AppealData doInBackground(String... strArr) {
            ab abVar = new ab(f.aHo);
            abVar.o("forum_id", this.aHp);
            abVar.o("user_id", this.aHq);
            abVar.o("user_name", this.aHr);
            abVar.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aHs);
            String ul = abVar.ul();
            if (abVar.uM().vG().rf()) {
                try {
                    return (AppealData) i.objectWithJsonStr(ul, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = abVar.uQ();
            appealData2.errMsg = abVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aHt.get();
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
