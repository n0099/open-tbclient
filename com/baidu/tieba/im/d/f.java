package com.baidu.tieba.im.d;

import android.location.Address;
import com.baidu.tieba.im.model.ay;
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
        ay ayVar;
        ay ayVar2;
        ay ayVar3;
        ay ayVar4;
        switch (i) {
            case 0:
                if (address != null) {
                    this.a.b = address.getLatitude();
                    this.a.a = address.getLongitude();
                    ayVar = this.a.d;
                    ayVar.b(String.valueOf(address.getLatitude()));
                    ayVar2 = this.a.d;
                    ayVar2.a(String.valueOf(address.getLongitude()));
                    ayVar3 = this.a.d;
                    ayVar3.a(0);
                    ayVar4 = this.a.d;
                    ayVar4.a();
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
