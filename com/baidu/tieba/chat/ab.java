package com.baidu.tieba.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask {
    final /* synthetic */ aa a;
    private com.baidu.tieba.a.a b = null;

    public ab(aa aaVar) {
        this.a = aaVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ac acVar;
        ac acVar2;
        super.b();
        acVar = this.a.c;
        if (acVar != null) {
            acVar2 = this.a.c;
            acVar2.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.a.c a(Object... objArr) {
        com.baidu.tieba.data.a.e eVar;
        com.baidu.tieba.data.a.e eVar2;
        com.baidu.tieba.data.a.e eVar3;
        com.baidu.tieba.data.a.e eVar4;
        com.baidu.tieba.data.a.e eVar5;
        com.baidu.tieba.data.a.f fVar;
        this.b = new com.baidu.tieba.a.a();
        com.baidu.tieba.a.a aVar = this.b;
        eVar = this.a.a;
        String a = aVar.a(eVar);
        com.baidu.tieba.util.z.a(getClass().getName(), "postData", a);
        com.baidu.tieba.data.a.c cVar = new com.baidu.tieba.data.a.c();
        eVar2 = this.a.a;
        cVar.a(eVar2.b());
        eVar3 = this.a.a;
        cVar.b(eVar3.c());
        try {
            com.baidu.tieba.data.a.d a2 = com.baidu.tieba.data.a.d.a();
            eVar4 = this.a.a;
            a2.b(eVar4.b());
            eVar5 = this.a.a;
            a2.a(eVar5.c());
            JSONObject jSONObject = new JSONObject(a);
            a2.a(jSONObject.optJSONObject(PushConstants.EXTRA_PUSH_MESSAGE));
            cVar.a(jSONObject.optJSONObject("recent"));
            if (cVar.d().size() > 0) {
                if (!cVar.c() && ((com.baidu.tieba.data.a.d) cVar.d().getLast()).b() != a2.b()) {
                    cVar.a(a2);
                }
            } else {
                cVar.a(a2);
            }
            fVar = this.a.d;
            fVar.a(cVar.d());
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.toString());
        }
        return cVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
        this.a.b = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.a.c cVar) {
        ac acVar;
        ac acVar2;
        ac acVar3;
        ac acVar4;
        ac acVar5;
        ac acVar6;
        super.a((Object) cVar);
        if (this.b != null) {
            if (!this.b.b()) {
                acVar = this.a.c;
                if (acVar != null) {
                    acVar2 = this.a.c;
                    acVar2.a(false, this.b.c(), null);
                }
            } else if (this.b.d() == 0) {
                acVar5 = this.a.c;
                if (acVar5 != null) {
                    acVar6 = this.a.c;
                    acVar6.a(true, null, cVar);
                }
            } else {
                acVar3 = this.a.c;
                if (acVar3 != null) {
                    acVar4 = this.a.c;
                    acVar4.a(false, this.b.e(), null);
                }
            }
        }
        this.a.b = null;
    }
}
