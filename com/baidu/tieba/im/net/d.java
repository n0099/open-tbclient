package com.baidu.tieba.im.net;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.ba;
import java.util.List;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends BdAsyncTask<Object, Integer, Void> {
    final /* synthetic */ b a;
    private c b;
    private volatile ba c = null;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Void a(Object... objArr) {
        return d();
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

    public d(b bVar, c cVar) {
        this.a = bVar;
        this.b = null;
        this.b = cVar;
    }

    private Void d() {
        List b;
        List list;
        try {
            this.c = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/getipinfo");
            String l = this.c.l();
            if (this.c.c() && l != null) {
                JSONObject jSONObject = new JSONObject(l);
                if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                    String optString = jSONObject.optString("urls");
                    b bVar = this.a;
                    b bVar2 = this.a;
                    b = b.b(optString);
                    bVar.b = b;
                    list = this.a.b;
                    if (list != null) {
                        com.baidu.tieba.sharedPref.b.a().b("KeyOfSharedPrefIpList", optString);
                        return null;
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("IpListManager get list exception: " + e.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        this.a.c = null;
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.c != null) {
            this.c.j();
            this.c = null;
        }
        this.a.c = null;
        super.cancel(true);
    }
}
