package com.baidu.tieba.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.bc;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends BdAsyncTask<String, Object, ForbidResultData> {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private WeakReference<j> g;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ ForbidResultData a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(ForbidResultData forbidResultData) {
        ForbidResultData forbidResultData2 = forbidResultData;
        super.a((i) forbidResultData2);
        j jVar = this.g.get();
        if (jVar != null) {
            if (forbidResultData2.errNo == 0 && bc.c(forbidResultData2.errMsg)) {
                jVar.a();
            } else {
                jVar.b();
            }
        }
    }

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

    private ForbidResultData a() {
        String str;
        str = h.a;
        ak akVar = new ak(str);
        akVar.a("day", this.e);
        akVar.a("un", this.d);
        akVar.a("fid", this.a);
        akVar.a("word", this.b);
        akVar.a("z", this.c);
        akVar.a("reason", this.f);
        akVar.a("ntn", "banid");
        akVar.a().a().a = true;
        String i = akVar.i();
        if (akVar.a().b().b()) {
            try {
                return (ForbidResultData) new GsonBuilder().create().fromJson(i, (Class<Object>) ForbidResultData.class);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("ForbidPostModel", "doInBackground", e.getMessage());
                ForbidResultData forbidResultData = new ForbidResultData();
                forbidResultData.errNo = -1000;
                return forbidResultData;
            }
        }
        ForbidResultData forbidResultData2 = new ForbidResultData();
        forbidResultData2.errNo = akVar.d();
        forbidResultData2.errMsg = akVar.f();
        return forbidResultData2;
    }
}
