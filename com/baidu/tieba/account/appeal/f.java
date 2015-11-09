package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String aEp = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private String aEq;
        private String aEr;
        private String aEs;
        private String aEt;
        private WeakReference<b> aEu;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aEq = str;
            this.aEr = str2;
            this.aEs = str3;
            this.aEt = str4;
            this.aEu = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public AppealData doInBackground(String... strArr) {
            w wVar = new w(f.aEp);
            wVar.o("forum_id", this.aEq);
            wVar.o("user_id", this.aEr);
            wVar.o("user_name", this.aEs);
            wVar.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aEt);
            String tG = wVar.tG();
            if (wVar.uh().va().qT()) {
                try {
                    return (AppealData) i.objectWithJsonStr(tG, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = wVar.ul();
            appealData2.errMsg = wVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aEu.get();
            if (bVar != null) {
                if (appealData.errNo == 0 && as.isEmpty(appealData.errMsg)) {
                    bVar.a(appealData);
                } else {
                    bVar.b(appealData);
                }
            }
        }
    }
}
