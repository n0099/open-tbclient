package com.baidu.tieba.im.creategroup;

import android.location.Address;
/* loaded from: classes.dex */
class k implements com.baidu.adp.lib.c.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1590a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f1590a = jVar;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        if (i == 0 && address != null) {
            this.f1590a.h.setLat(String.valueOf(address.getLatitude()));
            this.f1590a.h.setLng(String.valueOf(address.getLongitude()));
            this.f1590a.h.setPosition(address.getAddressLine(0));
        }
    }
}
