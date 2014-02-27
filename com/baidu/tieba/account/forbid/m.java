package com.baidu.tieba.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.bs;
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
    public final /* synthetic */ ForbidTplData a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(ForbidTplData forbidTplData) {
        ForbidTplData forbidTplData2 = forbidTplData;
        super.a((m) forbidTplData2);
        n nVar = this.c.get();
        if (nVar != null) {
            if (forbidTplData2.error.a == 0 && bs.c(forbidTplData2.error.b)) {
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

    private ForbidTplData d() {
        String str;
        str = l.a;
        ba baVar = new ba(str);
        baVar.a("forum_id", this.a);
        baVar.a(PushConstants.EXTRA_USER_ID, this.b);
        String l = baVar.l();
        if (baVar.c()) {
            try {
                return (ForbidTplData) new GsonBuilder().create().fromJson(l, (Class<Object>) ForbidTplData.class);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("ForbidTplModel", "doInBackground", e.getMessage());
                ForbidTplData forbidTplData = new ForbidTplData();
                forbidTplData.error.a = -1000;
                return forbidTplData;
            }
        }
        ForbidTplData forbidTplData2 = new ForbidTplData();
        forbidTplData2.error.a = baVar.e();
        forbidTplData2.error.b = baVar.i();
        return forbidTplData2;
    }
}
