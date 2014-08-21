package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ g a;
    private final String c;
    private final String d;
    private final String e;
    private com.baidu.tbadk.core.util.ae b = null;
    private final i f = new i();

    public h(g gVar, String str, String str2, String str3) {
        this.a = gVar;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        try {
            this.b = new com.baidu.tbadk.core.util.ae(strArr[0]);
            this.b.a("fid", this.c);
            this.b.a("kw", this.d);
            this.b.a("is_like", this.e);
            this.b.a().a().a = true;
            String h = this.b.h();
            if (this.b.b()) {
                if (this.e.equals("0")) {
                    try {
                        JSONObject jSONObject = new JSONObject(h);
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
                        BdLog.detailException(e);
                    }
                }
                if (this.b.a().b().b()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(h);
                        this.f.c = jSONObject2.optInt("num");
                        this.f.a = true;
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            BdLog.e(e3.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.f();
        }
        this.a.r = null;
        this.a.a(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        dm dmVar;
        dm dmVar2;
        this.a.r = null;
        this.a.a(false);
        if (this.b != null) {
            j jVar = new j();
            jVar.d = this.b.e();
            jVar.c = this.b.c();
            dmVar = this.a.o;
            if (dmVar != null) {
                dmVar2 = this.a.o;
                dmVar2.a(this.f, jVar);
            }
        }
    }
}
