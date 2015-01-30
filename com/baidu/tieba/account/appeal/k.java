package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bf;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Object, ForbidReasonData> {
    private String aor;
    private String aos;
    private WeakReference<l> aov;

    public k(String str, String str2, l lVar) {
        this.aor = str;
        this.aos = str2;
        this.aov = new WeakReference<>(lVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: s */
    public ForbidReasonData doInBackground(String... strArr) {
        String str;
        str = j.aow;
        ad adVar = new ad(str);
        adVar.o("forum_id", this.aor);
        adVar.o("user_id", this.aos);
        String oy = adVar.oy();
        if (adVar.oZ().qh().ma()) {
            try {
                ForbidReasonData forbidReasonData = (ForbidReasonData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(oy, ForbidReasonData.class);
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
        forbidReasonData3.error.errno = adVar.pd();
        forbidReasonData3.error.errMsg = adVar.getErrorString();
        return forbidReasonData3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ForbidReasonData forbidReasonData) {
        super.onPostExecute(forbidReasonData);
        l lVar = this.aov.get();
        if (lVar != null) {
            if (forbidReasonData.error.errno == 0 && bf.isEmpty(forbidReasonData.error.errMsg)) {
                lVar.a(forbidReasonData);
            } else {
                lVar.b(forbidReasonData);
            }
        }
    }
}
