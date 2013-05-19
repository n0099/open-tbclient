package com.baidu.tieba.c;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.lib.a.a {
    final /* synthetic */ p a;
    private com.baidu.tieba.d.t b = null;
    private String c;
    private String d;
    private String e;
    private r f;

    public q(p pVar, String str, String str2, String str3) {
        this.a = pVar;
        this.f = new r(pVar);
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public Boolean a(String... strArr) {
        try {
            this.b = new com.baidu.tieba.d.t(strArr[0]);
            this.b.a("fid", this.c);
            this.b.a("kw", this.d);
            this.b.a("is_like", this.e);
            this.b.d(true);
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
                        com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                    }
                }
                if (this.b.b()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(i);
                        this.f.c = jSONObject2.optInt("num");
                        this.f.a = true;
                    } catch (Exception e2) {
                        com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e2.getMessage());
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e3.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.j = null;
        this.a.a(false);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        com.baidu.tieba.frs.ab abVar;
        com.baidu.tieba.frs.ab abVar2;
        this.a.j = null;
        this.a.a(false);
        if (this.b != null) {
            s sVar = new s(this.a);
            sVar.d = this.b.f();
            sVar.c = this.b.d();
            abVar = this.a.g;
            if (abVar != null) {
                abVar2 = this.a.g;
                abVar2.a(this.f, sVar);
            }
        }
    }
}
