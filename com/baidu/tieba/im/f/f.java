package com.baidu.tieba.im.f;

import android.location.Address;
import com.baidu.tieba.im.model.bv;
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
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bv bvVar4;
        switch (i) {
            case 0:
                if (address != null) {
                    this.a.b = address.getLatitude();
                    this.a.a = address.getLongitude();
                    bvVar = this.a.d;
                    bvVar.b(String.valueOf(address.getLatitude()));
                    bvVar2 = this.a.d;
                    bvVar2.a(String.valueOf(address.getLongitude()));
                    bvVar3 = this.a.d;
                    bvVar3.a(0);
                    bvVar4 = this.a.d;
                    bvVar4.a();
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
