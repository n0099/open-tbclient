package com.baidu.tieba.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.ax;
import com.baidu.tieba.util.bu;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Object, ForbidTplData> {
    private String a;
    private String b;
    private WeakReference<n> c;

    public m(String str, String str2, n nVar) {
        this.a = str;
        this.b = str2;
        this.c = new WeakReference<>(nVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForbidTplData a(String... strArr) {
        String str;
        str = l.a;
        ax axVar = new ax(str);
        axVar.a("forum_id", this.a);
        axVar.a(PushConstants.EXTRA_USER_ID, this.b);
        String m = axVar.m();
        if (axVar.d()) {
            try {
                return (ForbidTplData) new GsonBuilder().create().fromJson(m, (Class<Object>) ForbidTplData.class);
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b("ForbidTplModel", "doInBackground", e.getMessage());
                ForbidTplData forbidTplData = new ForbidTplData();
                forbidTplData.error.a = -1000;
                return forbidTplData;
            }
        }
        ForbidTplData forbidTplData2 = new ForbidTplData();
        forbidTplData2.error.a = axVar.f();
        forbidTplData2.error.b = axVar.j();
        return forbidTplData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForbidTplData forbidTplData) {
        super.a((m) forbidTplData);
        n nVar = this.c.get();
        if (nVar != null) {
            if (forbidTplData.error.a == 0 && bu.c(forbidTplData.error.b)) {
                nVar.a(forbidTplData);
            } else {
                nVar.b(forbidTplData);
            }
        }
    }
}
