package com.baidu.tieba.c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.lib.a.a {
    ArrayList a;
    String b;
    final /* synthetic */ l c;
    private com.baidu.tieba.d.t d = null;
    private String e;
    private String f;
    private String g;
    private int h;

    public q(l lVar, String str, String str2, String str3, int i, String str4) {
        this.c = lVar;
        this.a = null;
        this.b = null;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = i;
        this.b = str4;
        this.a = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public Boolean a(String... strArr) {
        this.d = new com.baidu.tieba.d.t(strArr[0]);
        this.d.a("word", this.f);
        if (this.h != 6) {
            this.d.a("fid", this.e);
            this.d.a("z", this.g);
            if (this.h == 4) {
                this.d.a("ntn", "set");
            } else if (this.h == 5) {
                this.d.a("ntn", "");
            } else if (this.h == 2) {
                this.d.a("ntn", "set");
                this.d.a("cid", this.b);
            } else {
                this.d.a("ntn", "");
            }
        }
        this.d.d(true);
        String i = this.d.i();
        if (this.d.b()) {
            if (this.h == 6) {
                try {
                    JSONArray optJSONArray = new JSONObject(i).optJSONArray("cates");
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        com.baidu.tieba.a.v vVar = new com.baidu.tieba.a.v();
                        vVar.a(optJSONArray.optJSONObject(i2));
                        this.a.add(vVar);
                    }
                } catch (Exception e) {
                    com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) bool);
        this.c.g = null;
        if (this.d == null) {
            eVar2 = this.c.b;
            eVar2.a(null);
            return;
        }
        r rVar = new r(this.c);
        rVar.a = bool.booleanValue();
        if (bool.booleanValue()) {
            if (this.h == 6) {
                rVar.c = this.a;
            }
        } else {
            rVar.b = this.d.f();
        }
        eVar = this.c.b;
        eVar.a(rVar);
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.d != null) {
            this.d.g();
        }
        this.c.g = null;
        super.cancel(true);
        eVar = this.c.b;
        eVar.a(null);
    }
}
