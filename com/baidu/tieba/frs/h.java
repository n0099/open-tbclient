package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ g a;
    private com.baidu.tbadk.core.util.ak b = null;
    private final String c;
    private final String d;
    private final String e;
    private final i f;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        cy cyVar;
        cy cyVar2;
        this.a.n = null;
        this.a.a(false);
        if (this.b != null) {
            j jVar = new j(this.a);
            jVar.d = this.b.f();
            jVar.c = this.b.d();
            cyVar = this.a.k;
            if (cyVar != null) {
                cyVar2 = this.a.k;
                cyVar2.a(this.f, jVar);
            }
        }
    }

    public h(g gVar, String str, String str2, String str3) {
        this.a = gVar;
        this.f = new i(gVar);
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        try {
            this.b = new com.baidu.tbadk.core.util.ak(strArr[0]);
            this.b.a("fid", this.c);
            this.b.a("kw", this.d);
            this.b.a("is_like", this.e);
            this.b.a().a().a = true;
            String i = this.b.i();
            if (this.b.c()) {
                if (this.e.equals("0")) {
                    try {
                        JSONObject jSONObject = new JSONObject(i);
                        JSONObject optJSONObject = jSONObject.optJSONObject("like_data");
                        if (optJSONObject.optInt("is_success", 0) == 1) {
                            this.f.d = optJSONObject.optInt("level_id", 0);
                            this.f.e = optJSONObject.optString("level_name", "");
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_perm");
                            if (optJSONObject2 != null) {
                                this.f.f = optJSONObject2.optInt("cur_score", 0);
                                this.f.g = optJSONObject2.optInt("levelup_score", 0);
                            }
                            this.f.b = true;
                        }
                        this.a.a(this.f);
                    } catch (Exception e) {
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                    }
                }
                if (this.b.a().b().b()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(i);
                        this.f.c = jSONObject2.optInt("num");
                        this.f.a = true;
                    } catch (Exception e2) {
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e2.getMessage());
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e3.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.n = null;
        this.a.a(false);
    }
}
