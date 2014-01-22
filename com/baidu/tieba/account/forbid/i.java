package com.baidu.tieba.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.ax;
import com.baidu.tieba.util.bu;
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
    public ForbidResultData a(String... strArr) {
        String str;
        str = h.a;
        ax axVar = new ax(str);
        axVar.a("day", this.e);
        axVar.a("un", this.d);
        axVar.a("fid", this.a);
        axVar.a("word", this.b);
        axVar.a("z", this.c);
        axVar.a("reason", this.f);
        axVar.a("ntn", "banid");
        axVar.e(true);
        String m = axVar.m();
        if (axVar.d()) {
            try {
                return (ForbidResultData) new GsonBuilder().create().fromJson(m, (Class<Object>) ForbidResultData.class);
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b("ForbidPostModel", "doInBackground", e.getMessage());
                ForbidResultData forbidResultData = new ForbidResultData();
                forbidResultData.errNo = -1000;
                return forbidResultData;
            }
        }
        ForbidResultData forbidResultData2 = new ForbidResultData();
        forbidResultData2.errNo = axVar.f();
        forbidResultData2.errMsg = axVar.j();
        return forbidResultData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForbidResultData forbidResultData) {
        super.a((i) forbidResultData);
        j jVar = this.g.get();
        if (jVar != null) {
            if (forbidResultData.errNo == 0 && bu.c(forbidResultData.errMsg)) {
                jVar.a(forbidResultData);
            } else {
                jVar.b(forbidResultData);
            }
        }
    }
}
