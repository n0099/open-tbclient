package com.baidu.tieba.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ba;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Object, ForbidResultData> {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private WeakReference<j> g;

    public i(String str, String str2, String str3, String str4, String str5, String str6, j jVar) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = new WeakReference<>(jVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public ForbidResultData doInBackground(String... strArr) {
        String str;
        str = h.a;
        ae aeVar = new ae(str);
        aeVar.a("day", this.e);
        aeVar.a("un", this.d);
        aeVar.a("fid", this.a);
        aeVar.a("word", this.b);
        aeVar.a("z", this.c);
        aeVar.a("reason", this.f);
        aeVar.a("ntn", "banid");
        aeVar.a().a().a = true;
        String h = aeVar.h();
        if (aeVar.a().b().b()) {
            try {
                return (ForbidResultData) new GsonBuilder().create().fromJson(h, (Class<Object>) ForbidResultData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                ForbidResultData forbidResultData = new ForbidResultData();
                forbidResultData.errNo = -1000;
                return forbidResultData;
            }
        }
        ForbidResultData forbidResultData2 = new ForbidResultData();
        forbidResultData2.errNo = aeVar.c();
        forbidResultData2.errMsg = aeVar.e();
        return forbidResultData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ForbidResultData forbidResultData) {
        super.onPostExecute(forbidResultData);
        j jVar = this.g.get();
        if (jVar != null) {
            if (forbidResultData.errNo == 0 && ba.c(forbidResultData.errMsg)) {
                jVar.a(forbidResultData);
            } else {
                jVar.b(forbidResultData);
            }
        }
    }
}
