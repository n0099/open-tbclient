package com.baidu.tieba.im.a;

import android.text.TextUtils;
import com.baidu.tieba.im.message.cl;
import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.im.messageCenter.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements g {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(s sVar) {
        d dVar;
        d dVar2;
        int i;
        String str;
        String str2;
        d dVar3;
        d dVar4;
        d dVar5;
        d dVar6;
        d dVar7;
        int unused;
        if (sVar instanceof da) {
            if (((da) sVar).l()) {
                dVar5 = this.a.h;
                if (dVar5 != null) {
                    dVar6 = this.a.h;
                    dVar6.a();
                    if (((da) sVar).m() > 0 && !TextUtils.isEmpty(((da) sVar).n())) {
                        dVar7 = this.a.h;
                        dVar7.b(((da) sVar).n());
                    }
                }
            } else if (sVar instanceof cl) {
                cl clVar = (cl) sVar;
                this.a.d = clVar.c();
                this.a.e = clVar.d();
                this.a.f = clVar.b();
                this.a.g = clVar.a();
                if (sVar.v() == 103011) {
                    a.a = false;
                    dVar3 = this.a.h;
                    if (dVar3 != null) {
                        dVar4 = this.a.h;
                        dVar4.a();
                    }
                } else if (sVar.v() == -114) {
                    this.a.a();
                }
                dVar = this.a.h;
                if (dVar != null) {
                    dVar2 = this.a.h;
                    unused = this.a.d;
                    i = this.a.e;
                    str = this.a.g;
                    str2 = this.a.f;
                    dVar2.a(i, str, str2);
                }
            }
        }
    }
}
