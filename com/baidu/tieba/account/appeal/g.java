package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bd;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<String, Object, AppealData> {
    private String awq;
    private String awr;
    private String aws;
    private String awt;
    private WeakReference<h> awu;

    public g(String str, String str2, String str3, String str4, h hVar) {
        this.awq = str;
        this.awr = str2;
        this.aws = str3;
        this.awt = str4;
        this.awu = new WeakReference<>(hVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public AppealData doInBackground(String... strArr) {
        String str;
        str = f.awp;
        aa aaVar = new aa(str);
        aaVar.o("forum_id", this.awq);
        aaVar.o("user_id", this.awr);
        aaVar.o("user_name", this.aws);
        aaVar.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.awt);
        String rO = aaVar.rO();
        if (aaVar.sp().tq().pv()) {
            try {
                return (AppealData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(rO, AppealData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                AppealData appealData = new AppealData();
                appealData.errNo = -1000;
                return appealData;
            }
        }
        AppealData appealData2 = new AppealData();
        appealData2.errNo = aaVar.st();
        appealData2.errMsg = aaVar.getErrorString();
        return appealData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(AppealData appealData) {
        super.onPostExecute(appealData);
        h hVar = this.awu.get();
        if (hVar != null) {
            if (appealData.errNo == 0 && bd.isEmpty(appealData.errMsg)) {
                hVar.a(appealData);
            } else {
                hVar.b(appealData);
            }
        }
    }
}
