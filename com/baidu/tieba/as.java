package com.baidu.tieba;

import android.location.Address;
import android.text.TextUtils;
/* loaded from: classes.dex */
final class as implements com.baidu.adp.lib.c.d {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // com.baidu.adp.lib.c.d
    public final void a(int i, Address address) {
        if (i == 0 && address != null) {
            try {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                    this.a.x(valueOf);
                    this.a.y(valueOf2);
                    this.a.z(address.getAddressLine(0));
                }
            } catch (IllegalStateException e) {
                com.baidu.adp.lib.util.e.b(e.getMessage());
            }
        }
    }
}
