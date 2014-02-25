package com.baidu.tieba.im.net;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.ba;
import java.util.List;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Object, Integer, Void> {
    final /* synthetic */ b a;
    private c b;
    private volatile ba c = null;

    public d(b bVar, c cVar) {
        this.a = bVar;
        this.b = null;
        this.b = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Void a(Object... objArr) {
        List b;
        List list;
        try {
            this.c = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/getipinfo");
            String m = this.c.m();
            if (this.c.d() && m != null) {
                JSONObject jSONObject = new JSONObject(m);
                if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                    String optString = jSONObject.optString("urls");
                    b bVar = this.a;
                    b = this.a.b(optString);
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
            com.baidu.adp.lib.util.f.b("IpListManager get list exception: " + e.toString());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Void r3) {
        this.a.c = null;
        if (this.b != null) {
            this.b.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b(Void r3) {
        this.a.c = null;
        if (this.b != null) {
            this.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        this.a.c = null;
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.c != null) {
            this.c.k();
            this.c = null;
        }
        this.a.c = null;
        super.cancel(true);
    }
}
