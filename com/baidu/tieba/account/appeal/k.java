package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ba;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Object, ForbidReasonData> {
    private String a;
    private String b;
    private WeakReference<l> c;

    public k(String str, String str2, l lVar) {
        this.a = str;
        this.b = str2;
        this.c = new WeakReference<>(lVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public ForbidReasonData doInBackground(String... strArr) {
        String str;
        str = j.a;
        ae aeVar = new ae(str);
        aeVar.a(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, this.a);
        aeVar.a(com.baidu.tbadk.core.frameworkData.a.USER_ID, this.b);
        String h = aeVar.h();
        if (aeVar.a().b().b()) {
            try {
                ForbidReasonData forbidReasonData = (ForbidReasonData) new GsonBuilder().create().fromJson(h, (Class<Object>) ForbidReasonData.class);
                forbidReasonData.reason = forbidReasonData.reason.replaceAll("\\\\n", "\n");
                return forbidReasonData;
            } catch (Exception e) {
                BdLog.detailException(e);
                ForbidReasonData forbidReasonData2 = new ForbidReasonData();
                forbidReasonData2.error.a = -1000;
                return forbidReasonData2;
            }
        }
        ForbidReasonData forbidReasonData3 = new ForbidReasonData();
        forbidReasonData3.error.a = aeVar.c();
        forbidReasonData3.error.b = aeVar.e();
        return forbidReasonData3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ForbidReasonData forbidReasonData) {
        super.onPostExecute(forbidReasonData);
        l lVar = this.c.get();
        if (lVar != null) {
            if (forbidReasonData.error.a == 0 && ba.c(forbidReasonData.error.b)) {
                lVar.a(forbidReasonData);
            } else {
                lVar.b(forbidReasonData);
            }
        }
    }
}
