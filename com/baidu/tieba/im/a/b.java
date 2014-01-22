package com.baidu.tieba.im.a;

import android.text.TextUtils;
import com.baidu.tieba.im.message.cc;
import com.baidu.tieba.im.message.cr;
import com.baidu.tieba.im.message.q;
import com.baidu.tieba.im.messageCenter.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements g {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(q qVar) {
        d dVar;
        d dVar2;
        int i;
        int i2;
        String str;
        String str2;
        d dVar3;
        d dVar4;
        d dVar5;
        d dVar6;
        d dVar7;
        if (qVar instanceof cr) {
            if (((cr) qVar).k()) {
                dVar5 = this.a.h;
                if (dVar5 != null) {
                    dVar6 = this.a.h;
                    dVar6.G();
                    if (((cr) qVar).l() > 0 && !TextUtils.isEmpty(((cr) qVar).m())) {
                        dVar7 = this.a.h;
                        dVar7.b(((cr) qVar).m());
                    }
                }
            } else if (qVar instanceof cc) {
                cc ccVar = (cc) qVar;
                this.a.d = ccVar.c();
                this.a.e = ccVar.d();
                this.a.f = ccVar.b();
                this.a.g = ccVar.a();
                if (qVar.w() == 103011) {
                    a.a = false;
                    dVar3 = this.a.h;
                    if (dVar3 != null) {
                        dVar4 = this.a.h;
                        dVar4.G();
                    }
                } else if (qVar.w() == -114) {
                    this.a.a();
                }
                dVar = this.a.h;
                if (dVar != null) {
                    dVar2 = this.a.h;
                    i = this.a.d;
                    i2 = this.a.e;
                    str = this.a.g;
                    str2 = this.a.f;
                    dVar2.a(i, i2, str, str2);
                }
            }
        }
    }
}
