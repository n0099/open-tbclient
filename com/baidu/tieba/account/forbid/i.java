package com.baidu.tieba.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bg;
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
        an anVar = new an(str);
        anVar.a("day", this.e);
        anVar.a("un", this.d);
        anVar.a("fid", this.a);
        anVar.a("word", this.b);
        anVar.a("z", this.c);
        anVar.a("reason", this.f);
        anVar.a("ntn", "banid");
        anVar.a().a().a = true;
        String i = anVar.i();
        if (anVar.a().b().b()) {
            try {
                return (ForbidResultData) new GsonBuilder().create().fromJson(i, (Class<Object>) ForbidResultData.class);
            } catch (Exception e) {
                BdLog.e("ForbidPostModel", "doInBackground", e.getMessage());
                ForbidResultData forbidResultData = new ForbidResultData();
                forbidResultData.errNo = -1000;
                return forbidResultData;
            }
        }
        ForbidResultData forbidResultData2 = new ForbidResultData();
        forbidResultData2.errNo = anVar.d();
        forbidResultData2.errMsg = anVar.f();
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
            if (forbidResultData.errNo == 0 && bg.c(forbidResultData.errMsg)) {
                jVar.a(forbidResultData);
            } else {
                jVar.b(forbidResultData);
            }
        }
    }
}
