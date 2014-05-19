package com.baidu.tieba.im.f;

import android.location.Address;
import com.baidu.tieba.im.model.bu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.adp.lib.c.d {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        h hVar;
        h hVar2;
        bu buVar;
        bu buVar2;
        bu buVar3;
        bu buVar4;
        switch (i) {
            case 0:
                if (address != null) {
                    this.a.b = address.getLatitude();
                    this.a.a = address.getLongitude();
                    buVar = this.a.d;
                    buVar.b(String.valueOf(address.getLatitude()));
                    buVar2 = this.a.d;
                    buVar2.a(String.valueOf(address.getLongitude()));
                    buVar3 = this.a.d;
                    buVar3.a(0);
                    buVar4 = this.a.d;
                    buVar4.a();
                    return;
                }
                return;
            case 1:
            case 2:
            case 3:
                hVar2 = this.a.e;
                hVar2.b();
                return;
            case 4:
            case 5:
                hVar = this.a.e;
                hVar.a();
                return;
            default:
                return;
        }
    }
}
