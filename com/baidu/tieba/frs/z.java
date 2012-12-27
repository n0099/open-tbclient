package com.baidu.tieba.frs;

import android.os.AsyncTask;
import com.baidu.tieba.R;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends AsyncTask {
    final /* synthetic */ FrsActivity a;
    private String c;
    private String d;
    private String e;
    private com.baidu.tieba.c.t b = null;
    private int f = -1;
    private int g = -1;
    private String h = null;
    private boolean i = false;

    public z(FrsActivity frsActivity, String str, String str2, String str3) {
        this.a = frsActivity;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        boolean z;
        try {
            this.b = new com.baidu.tieba.c.t(strArr[0]);
            this.b.a("fid", this.c);
            this.b.a("kw", this.d);
            this.b.a("is_like", this.e);
            this.b.d(true);
            String i = this.b.i();
            if (this.b.c()) {
                if (this.e.equals("0")) {
                    try {
                        JSONObject optJSONObject = new JSONObject(i).optJSONObject("like_data");
                        if (optJSONObject.optInt("is_success", 0) == 1) {
                            this.g = optJSONObject.optInt("level_id");
                            this.h = optJSONObject.optString("level_name");
                            this.i = true;
                        }
                    } catch (Exception e) {
                        com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                    }
                }
                if (this.b.b()) {
                    try {
                        this.f = new JSONObject(i).optInt("num");
                        z = true;
                    } catch (Exception e2) {
                        com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e2.getMessage());
                    }
                    return Boolean.valueOf(z);
                }
            }
            z = false;
            return Boolean.valueOf(z);
        } catch (Exception e3) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e3.getMessage());
            return false;
        }
    }

    public void a() {
        com.baidu.tieba.b.c cVar;
        com.baidu.tieba.b.c cVar2;
        if (this.b != null) {
            this.b.g();
        }
        this.a.Q = null;
        cVar = this.a.y;
        if (cVar != null) {
            cVar2 = this.a.y;
            cVar2.a(false);
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        com.baidu.tieba.b.c cVar;
        com.baidu.tieba.b.c cVar2;
        com.baidu.tieba.b.c cVar3;
        com.baidu.tieba.b.c cVar4;
        ab abVar;
        com.baidu.tieba.view.l lVar;
        com.baidu.tieba.view.l lVar2;
        this.a.Q = null;
        cVar = this.a.y;
        if (cVar == null) {
            return;
        }
        cVar2 = this.a.y;
        cVar2.a(false);
        if (this.b != null) {
            if (this.i) {
                lVar = this.a.K;
                if (lVar != null) {
                    lVar2 = this.a.K;
                    lVar2.a(1, this.h, this.g);
                }
            }
            if (!bool.booleanValue()) {
                if (this.b.f() != null) {
                    this.a.b(this.b.f());
                } else {
                    this.a.b(this.a.getString(R.string.add_fan_error));
                }
                if (this.b.d() == 120002) {
                    this.a.t();
                    return;
                }
                return;
            }
            this.a.b(this.a.getString(R.string.add_fan_sucess));
            cVar3 = this.a.y;
            cVar3.e().b(1);
            cVar4 = this.a.y;
            cVar4.e().c(this.f);
            abVar = this.a.w;
            abVar.notifyDataSetChanged();
        }
    }
}
