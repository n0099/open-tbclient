package com.baidu.tieba;

import android.location.Address;
import java.util.Locale;
/* loaded from: classes.dex */
public class au implements com.baidu.location.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f701a;

    public au(TiebaApplication tiebaApplication) {
        this.f701a = tiebaApplication;
    }

    @Override // com.baidu.location.c
    public void onReceiveLocation(com.baidu.location.a aVar) {
        Address address;
        Address address2;
        int i;
        Address address3;
        Address address4;
        if (aVar != null && aVar.d() != 62 && aVar.d() != 63 && aVar.d() != 68 && aVar.d() <= 161) {
            this.f701a.D = 0;
            this.f701a.aO();
            this.f701a.F = new Address(Locale.getDefault());
            address = this.f701a.F;
            address.setLatitude(aVar.a());
            address2 = this.f701a.F;
            address2.setLongitude(aVar.b());
            this.f701a.f618a = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            if ((aVar.g() == null || aVar.h() == null) && aVar.f() != null) {
                stringBuffer.append(aVar.f());
            }
            if (aVar.g() != null) {
                stringBuffer.append(aVar.g());
            }
            if (aVar.h() != null) {
                stringBuffer.append(aVar.h());
            }
            if (aVar.e() != null) {
                address4 = this.f701a.F;
                address4.setAddressLine(0, stringBuffer.toString());
            }
            TiebaApplication tiebaApplication = this.f701a;
            i = this.f701a.D;
            address3 = this.f701a.F;
            tiebaApplication.a(i, "", address3);
        }
    }

    @Override // com.baidu.location.c
    public void onReceivePoi(com.baidu.location.a aVar) {
    }
}
