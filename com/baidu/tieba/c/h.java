package com.baidu.tieba.c;

import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.a.a {
    final /* synthetic */ g a;
    private com.baidu.tieba.d.t b = null;
    private boolean c;
    private boolean d;
    private boolean e;

    public h(g gVar, Boolean bool, Boolean bool2, Boolean bool3) {
        this.a = gVar;
        this.c = false;
        this.d = false;
        this.e = true;
        this.c = bool.booleanValue();
        this.d = bool2.booleanValue();
        this.e = bool3.booleanValue();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096 A[Catch: Exception -> 0x0071, TRY_ENTER, TryCatch #2 {Exception -> 0x0071, blocks: (B:12:0x001c, B:14:0x0025, B:19:0x0036, B:32:0x0096, B:35:0x00de, B:26:0x004a), top: B:58:0x001c }] */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.tieba.a.q a(Object... objArr) {
        com.baidu.tieba.a.q qVar;
        Exception e;
        com.baidu.tieba.a.q qVar2;
        String f;
        try {
        } catch (Exception e2) {
            qVar = null;
            e = e2;
        }
        if (this.c) {
            if (this.e) {
                f = com.baidu.tieba.d.k.b();
            } else {
                f = com.baidu.tieba.d.k.f("0");
            }
            if (f != null && f.length() > 0) {
                qVar2 = new com.baidu.tieba.a.q();
                try {
                    qVar2.a(f);
                    if (!qVar2.a()) {
                        com.baidu.tieba.d.ae.a("Like_Recommend_AsyncTask", "doInBackground", "cache data format err");
                        if (this.e) {
                            com.baidu.tieba.d.k.a();
                            qVar2 = null;
                        } else {
                            com.baidu.tieba.d.k.e("0");
                            qVar2 = null;
                        }
                    } else {
                        c(qVar2);
                        com.baidu.tieba.d.ae.a("Like_Recommend_AsyncTask", "doInBackground", "cache data.size: " + String.valueOf(f.length()));
                    }
                } catch (Exception e3) {
                    e = e3;
                    qVar = qVar2;
                    com.baidu.tieba.d.ae.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                    return qVar;
                }
                if (this.d) {
                    return null;
                }
                StringBuffer stringBuffer = new StringBuffer(30);
                stringBuffer.append(com.baidu.tieba.a.i.e);
                stringBuffer.append("c/f/forum/favocommend");
                ArrayList arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("ctime", String.valueOf(System.currentTimeMillis())));
                this.b = new com.baidu.tieba.d.t(stringBuffer.toString());
                this.b.a(arrayList);
                String i = this.b.i();
                if (!this.b.b() || i == null) {
                    qVar = null;
                } else {
                    qVar = new com.baidu.tieba.a.q();
                    try {
                        qVar.a(i);
                        if (qVar.a()) {
                            this.e = qVar.b() == 1;
                            if (this.e) {
                                com.baidu.tieba.d.k.d(i);
                            } else {
                                com.baidu.tieba.d.k.a(i, "0");
                            }
                        } else {
                            qVar = null;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        com.baidu.tieba.d.ae.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                        return qVar;
                    }
                }
                return qVar;
            }
        }
        qVar2 = null;
        if (this.d) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: a */
    public void b(com.baidu.tieba.a.q... qVarArr) {
        com.baidu.adp.a.e eVar;
        this.a.e = qVarArr[0];
        this.a.a = 2;
        eVar = this.a.b;
        eVar.a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.q qVar) {
        com.baidu.adp.a.e eVar;
        boolean z = true;
        this.a.a = 1;
        if (qVar == null) {
            z = false;
            if (this.b != null) {
                this.a.d = this.b.f();
            }
        } else {
            this.a.e = qVar;
        }
        this.a.f = null;
        eVar = this.a.b;
        eVar.a(Boolean.valueOf(z));
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.f = null;
        super.cancel(true);
        eVar = this.a.b;
        eVar.a(false);
    }
}
