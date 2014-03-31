package com.baidu.tieba.im.f;

import android.location.Address;
import com.baidu.tieba.im.model.bo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements com.baidu.adp.lib.c.d {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.adp.lib.c.d
    public final void a(int i, Address address) {
        g gVar;
        g gVar2;
        bo boVar;
        bo boVar2;
        bo boVar3;
        bo boVar4;
        switch (i) {
            case 0:
                if (address != null) {
                    this.a.b = address.getLatitude();
                    this.a.a = address.getLongitude();
                    boVar = this.a.d;
                    boVar.b(String.valueOf(address.getLatitude()));
                    boVar2 = this.a.d;
                    boVar2.a(String.valueOf(address.getLongitude()));
                    boVar3 = this.a.d;
                    boVar3.a(0);
                    boVar4 = this.a.d;
                    boVar4.a();
                    return;
                }
                return;
            case 1:
            case 2:
            case 3:
                gVar2 = this.a.e;
                gVar2.b();
                return;
            case 4:
            case 5:
                gVar = this.a.e;
                gVar.a();
                return;
            default:
                return;
        }
    }
}
