package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String aFk = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private String aFl;
        private String aFm;
        private String aFn;
        private String aFo;
        private WeakReference<b> aFp;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aFl = str;
            this.aFm = str2;
            this.aFn = str3;
            this.aFo = str4;
            this.aFp = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public AppealData doInBackground(String... strArr) {
            w wVar = new w(f.aFk);
            wVar.o("forum_id", this.aFl);
            wVar.o("user_id", this.aFm);
            wVar.o("user_name", this.aFn);
            wVar.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aFo);
            String tG = wVar.tG();
            if (wVar.uh().uY().qV()) {
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
            b bVar = this.aFp.get();
            if (bVar != null) {
                if (appealData.errNo == 0 && ar.isEmpty(appealData.errMsg)) {
                    bVar.a(appealData);
                } else {
                    bVar.b(appealData);
                }
            }
        }
    }
}
