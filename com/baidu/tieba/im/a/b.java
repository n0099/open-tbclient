package com.baidu.tieba.im.a;

import android.text.TextUtils;
import com.baidu.tieba.im.message.bs;
import com.baidu.tieba.im.message.cc;
import com.baidu.tieba.im.message.o;
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
    public void a(o oVar) {
        d dVar;
        d dVar2;
        int i;
        int i2;
        d dVar3;
        d dVar4;
        d dVar5;
        d dVar6;
        d dVar7;
        if (oVar instanceof cc) {
            if (((cc) oVar).i()) {
                dVar5 = this.a.f;
                if (dVar5 != null) {
                    dVar6 = this.a.f;
                    dVar6.G();
                    if (((cc) oVar).j() > 0 && !TextUtils.isEmpty(((cc) oVar).k())) {
                        dVar7 = this.a.f;
                        dVar7.b(((cc) oVar).k());
                    }
                }
            } else if (oVar instanceof bs) {
                bs bsVar = (bs) oVar;
                this.a.d = bsVar.a();
                this.a.e = bsVar.b();
                if (oVar.u() == 103011) {
                    a.a = false;
                    dVar3 = this.a.f;
                    if (dVar3 != null) {
                        dVar4 = this.a.f;
                        dVar4.G();
                    }
                } else if (oVar.u() == -114) {
                    this.a.a();
                }
                dVar = this.a.f;
                if (dVar != null) {
                    dVar2 = this.a.f;
                    i = this.a.d;
                    i2 = this.a.e;
                    dVar2.a(i, i2);
                }
            }
        }
    }
}
