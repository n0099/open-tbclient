package com.baidu.tieba.frs;

import android.os.AsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends AsyncTask {
    final /* synthetic */ FrsImageActivity a;
    private int b;
    private com.baidu.tieba.c.t c = null;

    public aq(FrsImageActivity frsImageActivity, int i) {
        this.a = frsImageActivity;
        this.b = 0;
        this.b = i;
        if (this.b < 0) {
            this.b = 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.d doInBackground(Object... objArr) {
        com.baidu.tieba.b.d dVar;
        Exception e;
        com.baidu.tieba.b.d dVar2;
        String str;
        com.baidu.tieba.b.d dVar3;
        try {
            this.c = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/f/frs/photo");
            StringBuilder sb = new StringBuilder();
            dVar2 = this.a.q;
            int size = dVar2.c().size();
            for (int i = this.b; i < size && i < this.b + 30; i++) {
                dVar3 = this.a.q;
                sb.append((String) dVar3.c().get(i));
                sb.append(",");
            }
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == ',') {
                sb.deleteCharAt(length - 1);
            }
            this.c.a("alb_ids", sb.toString());
            com.baidu.tieba.c.t tVar = this.c;
            str = this.a.d;
            tVar.a("kw", str);
            String i2 = this.c.i();
            if (this.c.b()) {
                dVar = new com.baidu.tieba.b.d();
                try {
                    dVar.a(i2);
                    return dVar;
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                    return dVar;
                }
            }
            return null;
        } catch (Exception e3) {
            dVar = null;
            e = e3;
        }
    }

    public void a() {
        this.a.f = null;
        if (this.c != null) {
            this.c.g();
        }
        this.a.a(ao.NORMAL);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.d dVar) {
        int i;
        int i2;
        com.baidu.tieba.b.d dVar2;
        com.baidu.tieba.b.d dVar3;
        super.onPostExecute(dVar);
        this.a.f = null;
        this.a.a(ao.NORMAL);
        if (dVar == null) {
            if (this.c != null) {
                this.a.b(this.c.f());
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.a;
        i = frsImageActivity.u;
        frsImageActivity.u = i + 30;
        this.a.a(dVar.b());
        i2 = this.a.u;
        dVar2 = this.a.q;
        if (i2 >= dVar2.c().size()) {
            dVar3 = this.a.q;
            if (dVar3.d() == 0) {
                this.a.a(ao.LAST);
            } else {
                this.a.a(ao.NEXT);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.a.a(ao.LOADING);
    }
}
