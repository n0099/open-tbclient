package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.az;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Object, ForbidReasonData> {
    private String agf;
    private String agg;
    private WeakReference<l> agj;

    public k(String str, String str2, l lVar) {
        this.agf = str;
        this.agg = str2;
        this.agj = new WeakReference<>(lVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: p */
    public ForbidReasonData doInBackground(String... strArr) {
        String str;
        str = j.agk;
        ac acVar = new ac(str);
        acVar.k("forum_id", this.agf);
        acVar.k(com.baidu.tbadk.core.frameworkData.a.USER_ID, this.agg);
        String lA = acVar.lA();
        if (acVar.mc().nb().jq()) {
            try {
                ForbidReasonData forbidReasonData = (ForbidReasonData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(lA, ForbidReasonData.class);
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
        forbidReasonData3.error.errno = acVar.mg();
        forbidReasonData3.error.errMsg = acVar.getErrorString();
        return forbidReasonData3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ForbidReasonData forbidReasonData) {
        super.onPostExecute(forbidReasonData);
        l lVar = this.agj.get();
        if (lVar != null) {
            if (forbidReasonData.error.errno == 0 && az.aA(forbidReasonData.error.errMsg)) {
                lVar.a(forbidReasonData);
            } else {
                lVar.b(forbidReasonData);
            }
        }
    }
}
