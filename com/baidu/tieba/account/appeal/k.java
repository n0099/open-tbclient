package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bb;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Object, ForbidReasonData> {
    private String aye;
    private String ayf;
    private WeakReference<l> ayi;

    public k(String str, String str2, l lVar) {
        this.aye = str;
        this.ayf = str2;
        this.ayi = new WeakReference<>(lVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: p */
    public ForbidReasonData doInBackground(String... strArr) {
        String str;
        str = j.ayj;
        aa aaVar = new aa(str);
        aaVar.o("forum_id", this.aye);
        aaVar.o("user_id", this.ayf);
        String sw = aaVar.sw();
        if (aaVar.sX().tT().qa()) {
            try {
                ForbidReasonData forbidReasonData = (ForbidReasonData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(sw, ForbidReasonData.class);
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
        forbidReasonData3.error.errno = aaVar.tb();
        forbidReasonData3.error.errMsg = aaVar.getErrorString();
        return forbidReasonData3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ForbidReasonData forbidReasonData) {
        super.onPostExecute(forbidReasonData);
        l lVar = this.ayi.get();
        if (lVar != null) {
            if (forbidReasonData.error.errno == 0 && bb.isEmpty(forbidReasonData.error.errMsg)) {
                lVar.a(forbidReasonData);
            } else {
                lVar.b(forbidReasonData);
            }
        }
    }
}
