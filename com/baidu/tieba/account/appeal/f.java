package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String aQe = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/bawu/appeal";

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
        private String aQf;
        private String aQg;
        private String aQh;
        private String aQi;
        private WeakReference<b> aQj;

        public a(String str, String str2, String str3, String str4, b bVar) {
            this.aQf = str;
            this.aQg = str2;
            this.aQh = str3;
            this.aQi = str4;
            this.aQj = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public AppealData doInBackground(String... strArr) {
            y yVar = new y(f.aQe);
            yVar.n("forum_id", this.aQf);
            yVar.n("user_id", this.aQg);
            yVar.n("user_name", this.aQh);
            yVar.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aQi);
            String ud = yVar.ud();
            if (yVar.uC().vw().isRequestSuccess()) {
                try {
                    return (AppealData) OrmObject.objectWithJsonStr(ud, AppealData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    AppealData appealData = new AppealData();
                    appealData.errNo = -1000;
                    return appealData;
                }
            }
            AppealData appealData2 = new AppealData();
            appealData2.errNo = yVar.uG();
            appealData2.errMsg = yVar.getErrorString();
            return appealData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AppealData appealData) {
            super.onPostExecute(appealData);
            b bVar = this.aQj.get();
            if (bVar != null) {
                if (appealData.errNo == 0 && at.isEmpty(appealData.errMsg)) {
                    bVar.a(appealData);
                } else {
                    bVar.b(appealData);
                }
            }
        }
    }
}
