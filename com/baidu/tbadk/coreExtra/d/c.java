package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ak;
import java.util.List;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends BdAsyncTask<Object, Integer, Void> {
    final /* synthetic */ a a;
    private b b;
    private volatile ak c = null;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Void a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(Void r3) {
        this.a.c = null;
        if (this.b != null) {
            this.b.a();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    protected final /* synthetic */ void b(Void r3) {
        this.a.c = null;
        if (this.b != null) {
            this.b.a();
        }
    }

    public c(a aVar, b bVar) {
        this.a = aVar;
        this.b = null;
        this.b = bVar;
    }

    private Void a() {
        List b;
        List list;
        try {
            this.c = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/getipinfo");
            String i = this.c.i();
            if (this.c.a().b().b() && i != null) {
                JSONObject jSONObject = new JSONObject(i);
                if (jSONObject.optInt("error_code") == 0) {
                    String optString = jSONObject.optString("urls");
                    a aVar = this.a;
                    a aVar2 = this.a;
                    b = a.b(optString);
                    aVar.b = b;
                    list = this.a.b;
                    if (list != null) {
                        com.baidu.tbadk.core.sharedPref.b.a().b("KeyOfSharedPrefIpList", optString);
                        return null;
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("IpListManager get list exception: " + e.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void d() {
        this.a.c = null;
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        this.a.c = null;
        super.cancel(true);
    }
}
