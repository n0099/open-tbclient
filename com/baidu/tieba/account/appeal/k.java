package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bd;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Object, ForbidReasonData> {
    private String awq;
    private String awr;
    private WeakReference<l> awu;

    public k(String str, String str2, l lVar) {
        this.awq = str;
        this.awr = str2;
        this.awu = new WeakReference<>(lVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public ForbidReasonData doInBackground(String... strArr) {
        String str;
        str = j.awv;
        aa aaVar = new aa(str);
        aaVar.o("forum_id", this.awq);
        aaVar.o("user_id", this.awr);
        String rO = aaVar.rO();
        if (aaVar.sp().tq().pv()) {
            try {
                ForbidReasonData forbidReasonData = (ForbidReasonData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(rO, ForbidReasonData.class);
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
        forbidReasonData3.error.errno = aaVar.st();
        forbidReasonData3.error.errMsg = aaVar.getErrorString();
        return forbidReasonData3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ForbidReasonData forbidReasonData) {
        super.onPostExecute(forbidReasonData);
        l lVar = this.awu.get();
        if (lVar != null) {
            if (forbidReasonData.error.errno == 0 && bd.isEmpty(forbidReasonData.error.errMsg)) {
                lVar.a(forbidReasonData);
            } else {
                lVar.b(forbidReasonData);
            }
        }
    }
}
