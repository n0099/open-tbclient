package com.baidu.tieba;

import android.location.Address;
import android.text.TextUtils;
/* loaded from: classes.dex */
class bb implements com.baidu.adp.lib.c.d {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        if (i == 0 && address != null) {
            try {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                    this.a.y(valueOf);
                    this.a.z(valueOf2);
                    this.a.A(address.getAddressLine(0));
                }
            } catch (IllegalStateException e) {
                com.baidu.adp.lib.h.e.a(e.getMessage());
            }
        }
    }
}
