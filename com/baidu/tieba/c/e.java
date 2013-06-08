package com.baidu.tieba.c;

import com.baidu.android.pushservice.PushConstants;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.a.a {
    final /* synthetic */ c a;
    private volatile com.baidu.tieba.d.t b;

    private e(c cVar) {
        this.a = cVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(c cVar, e eVar) {
        this(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        String str5;
        List list2;
        try {
            this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/comlist");
            this.b.d(true);
            com.baidu.tieba.d.t tVar = this.b;
            str = this.a.f;
            tVar.a(PushConstants.EXTRA_USER_ID, str);
            com.baidu.tieba.d.t tVar2 = this.b;
            str2 = this.a.h;
            tVar2.a("pn", str2);
            com.baidu.tieba.d.t tVar3 = this.b;
            str3 = this.a.i;
            tVar3.a("rn", str3);
            String i = this.b.i();
            if (this.b.b() && i != null) {
                this.a.c(i);
                if (this.a.f() == 0) {
                    str4 = this.a.h;
                    if (str4.equals("1")) {
                        list = this.a.e;
                        if (list != null) {
                            com.baidu.tieba.a.a.f a = com.baidu.tieba.a.a.f.a();
                            str5 = this.a.f;
                            list2 = this.a.e;
                            a.a(str5, list2);
                        }
                    }
                }
                return true;
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.a.m = null;
        if (bool.booleanValue()) {
            eVar = this.a.b;
            eVar.a(true);
            return;
        }
        this.a.c = this.b.d();
        this.a.d = this.b.f();
        eVar2 = this.a.b;
        eVar2.a(false);
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        com.baidu.adp.a.e eVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.e = null;
        eVar = this.a.b;
        eVar.a(false);
    }
}
