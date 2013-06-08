package com.baidu.tieba.c;

import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.lib.a.a {
    final /* synthetic */ j a;
    private com.baidu.tieba.d.t b = null;
    private boolean c;
    private boolean d;
    private boolean e;

    public k(j jVar, Boolean bool, Boolean bool2, Boolean bool3) {
        this.a = jVar;
        this.c = false;
        this.d = false;
        this.e = true;
        this.c = bool.booleanValue();
        this.d = bool2.booleanValue();
        this.e = bool3.booleanValue();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public com.baidu.tieba.a.q a(Object... objArr) {
        com.baidu.tieba.a.q qVar;
        Exception e;
        com.baidu.tieba.a.q qVar2;
        String f;
        boolean z;
        try {
            if (this.c) {
                if (this.e) {
                    f = com.baidu.tieba.d.k.c();
                } else {
                    f = com.baidu.tieba.d.k.f("0");
                }
                if (f == null || f.length() <= 0) {
                    z = false;
                    qVar2 = null;
                } else {
                    qVar2 = new com.baidu.tieba.a.q();
                    try {
                        qVar2.a(f);
                        if (!qVar2.a()) {
                            com.baidu.tieba.d.ae.a("Like_Recommend_AsyncTask", "doInBackground", "cache data format err");
                            if (this.e) {
                                com.baidu.tieba.d.k.b();
                                z = false;
                                qVar2 = null;
                            } else {
                                com.baidu.tieba.d.k.e("0");
                                z = false;
                                qVar2 = null;
                            }
                        } else {
                            c(qVar2);
                            com.baidu.tieba.d.ae.a("Like_Recommend_AsyncTask", "doInBackground", "cache data.size: " + String.valueOf(f.length()));
                            z = true;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        qVar = qVar2;
                        com.baidu.tieba.d.ae.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                        return qVar;
                    }
                }
                if (!z) {
                    this.d = true;
                }
            } else {
                qVar2 = null;
            }
        } catch (Exception e3) {
            qVar = null;
            e = e3;
        }
        if (this.d) {
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
        return null;
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
