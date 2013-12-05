package com.baidu.tieba;

import android.location.Address;
/* loaded from: classes.dex */
class ba implements com.baidu.adp.lib.c.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f1129a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(TiebaApplication tiebaApplication) {
        this.f1129a = tiebaApplication;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        if (i == 0 && address != null) {
            this.f1129a.y(String.valueOf(address.getLatitude()));
            this.f1129a.z(String.valueOf(address.getLongitude()));
            this.f1129a.A(address.getAddressLine(0));
        }
    }
}
