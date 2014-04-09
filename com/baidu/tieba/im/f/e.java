package com.baidu.tieba.im.f;

import android.location.Address;
import com.baidu.tieba.im.model.bp;
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
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bp bpVar4;
        switch (i) {
            case 0:
                if (address != null) {
                    this.a.b = address.getLatitude();
                    this.a.a = address.getLongitude();
                    bpVar = this.a.d;
                    bpVar.b(String.valueOf(address.getLatitude()));
                    bpVar2 = this.a.d;
                    bpVar2.a(String.valueOf(address.getLongitude()));
                    bpVar3 = this.a.d;
                    bpVar3.a(0);
                    bpVar4 = this.a.d;
                    bpVar4.a();
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
