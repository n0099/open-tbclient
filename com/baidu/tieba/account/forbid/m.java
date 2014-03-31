package com.baidu.tieba.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.bc;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends BdAsyncTask<String, Object, ForbidTplData> {
    private String a;
    private String b;
    private WeakReference<n> c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ ForbidTplData a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(ForbidTplData forbidTplData) {
        ForbidTplData forbidTplData2 = forbidTplData;
        super.a((m) forbidTplData2);
        n nVar = this.c.get();
        if (nVar != null) {
            if (forbidTplData2.error.a == 0 && bc.c(forbidTplData2.error.b)) {
                nVar.a(forbidTplData2);
            } else {
                nVar.b(forbidTplData2);
            }
        }
    }

    public m(String str, String str2, n nVar) {
        this.a = str;
        this.b = str2;
        this.c = new WeakReference<>(nVar);
        setPriority(3);
    }

    private ForbidTplData a() {
        String str;
        str = l.a;
        ak akVar = new ak(str);
        akVar.a("forum_id", this.a);
        akVar.a("user_id", this.b);
        String i = akVar.i();
        if (akVar.a().b().b()) {
            try {
                return (ForbidTplData) new GsonBuilder().create().fromJson(i, (Class<Object>) ForbidTplData.class);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("ForbidTplModel", "doInBackground", e.getMessage());
                ForbidTplData forbidTplData = new ForbidTplData();
                forbidTplData.error.a = -1000;
                return forbidTplData;
            }
        }
        ForbidTplData forbidTplData2 = new ForbidTplData();
        forbidTplData2.error.a = akVar.d();
        forbidTplData2.error.b = akVar.f();
        return forbidTplData2;
    }
}
