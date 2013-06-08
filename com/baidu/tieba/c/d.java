package com.baidu.tieba.c;

import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.a.a {
    final /* synthetic */ c a;
    private volatile com.baidu.tieba.d.t b;

    private d(c cVar) {
        this.a = cVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(c cVar, d dVar) {
        this(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        String str;
        String str2;
        JSONObject jSONObject;
        try {
            this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/delcom");
            this.b.d(true);
            com.baidu.tieba.d.t tVar = this.b;
            str = this.a.f;
            tVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.d.t tVar2 = this.b;
            str2 = this.a.g;
            tVar2.a("com_id", str2);
            String i = this.b.i();
            if (this.b.b() && i != null && (jSONObject = new JSONObject(i)) != null && jSONObject.optJSONObject("error").optInt("errno") == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.a.n = null;
        if (bool.booleanValue()) {
            eVar = this.a.b;
            eVar.a(true);
            return;
        }
        this.a.c = this.b.d();
        this.a.d = this.b.f();
        eVar2 = this.a.b;
        eVar2.a(false);
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        com.baidu.adp.a.e eVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        eVar = this.a.b;
        eVar.a(false);
    }
}
