package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bm;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<String, Object, AppealData> {
    private String a;
    private String b;
    private String c;
    private String d;
    private WeakReference<h> e;

    public g(String str, String str2, String str3, String str4, h hVar) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = new WeakReference<>(hVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public AppealData doInBackground(String... strArr) {
        String str;
        str = f.a;
        aq aqVar = new aq(str);
        aqVar.a(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, this.a);
        aqVar.a(com.baidu.tbadk.core.frameworkData.a.USER_ID, this.b);
        aqVar.a(com.baidu.tbadk.core.frameworkData.a.USER_NAME, this.c);
        aqVar.a("content", this.d);
        String i = aqVar.i();
        if (aqVar.a().b().b()) {
            try {
                return (AppealData) new GsonBuilder().create().fromJson(i, (Class<Object>) AppealData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                AppealData appealData = new AppealData();
                appealData.errNo = -1000;
                return appealData;
            }
        }
        AppealData appealData2 = new AppealData();
        appealData2.errNo = aqVar.d();
        appealData2.errMsg = aqVar.f();
        return appealData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(AppealData appealData) {
        super.onPostExecute(appealData);
        h hVar = this.e.get();
        if (hVar != null) {
            if (appealData.errNo == 0 && bm.c(appealData.errMsg)) {
                hVar.a(appealData);
            } else {
                hVar.b(appealData);
            }
        }
    }
}
