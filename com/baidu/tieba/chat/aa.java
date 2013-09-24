package com.baidu.tieba.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.av;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.a.c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f954a;
    private com.baidu.tieba.a.c b = null;

    public aa(z zVar) {
        this.f954a = zVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ab abVar;
        ab abVar2;
        super.b();
        abVar = this.f954a.c;
        if (abVar != null) {
            abVar2 = this.f954a.c;
            abVar2.a();
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
        this.b = new com.baidu.tieba.a.c();
        com.baidu.tieba.a.c cVar = this.b;
        eVar = this.f954a.f981a;
        String a2 = cVar.a(eVar);
        av.a(getClass().getName(), "postData", a2);
        com.baidu.tieba.data.a.c cVar2 = new com.baidu.tieba.data.a.c();
        eVar2 = this.f954a.f981a;
        cVar2.a(eVar2.b());
        eVar3 = this.f954a.f981a;
        cVar2.b(eVar3.c());
        try {
            com.baidu.tieba.data.a.d a3 = com.baidu.tieba.data.a.d.a();
            eVar4 = this.f954a.f981a;
            a3.b(eVar4.b());
            eVar5 = this.f954a.f981a;
            a3.a(eVar5.c());
            JSONObject jSONObject = new JSONObject(a2);
            a3.a(jSONObject.optJSONObject("message"));
            cVar2.a(jSONObject.optJSONObject("recent"));
            if (cVar2.d().size() > 0) {
                if (!cVar2.c() && cVar2.d().getLast().b() != a3.b()) {
                    cVar2.a(a3);
                }
            } else {
                cVar2.a(a3);
            }
            fVar = this.f954a.d;
            fVar.a(cVar2.d());
        } catch (Exception e) {
            av.b(getClass().getName(), "doInBackground", e.toString());
        }
        return cVar2;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
        this.f954a.b = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.a.c cVar) {
        ab abVar;
        ab abVar2;
        ab abVar3;
        ab abVar4;
        ab abVar5;
        ab abVar6;
        super.a((aa) cVar);
        if (this.b != null) {
            if (!this.b.b()) {
                abVar = this.f954a.c;
                if (abVar != null) {
                    abVar2 = this.f954a.c;
                    abVar2.a(false, this.b.c(), null);
                }
            } else if (this.b.d() == 0) {
                abVar5 = this.f954a.c;
                if (abVar5 != null) {
                    abVar6 = this.f954a.c;
                    abVar6.a(true, null, cVar);
                }
            } else {
                abVar3 = this.f954a.c;
                if (abVar3 != null) {
                    abVar4 = this.f954a.c;
                    abVar4.a(false, this.b.e(), null);
                }
            }
        }
        this.f954a.b = null;
    }
}
