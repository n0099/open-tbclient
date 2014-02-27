package com.baidu.tieba.im.a;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements com.baidu.adp.lib.c.d {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.adp.lib.c.d
    public final void a(int i, Address address) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        d unused;
        d unused2;
        if (i != 0) {
            dVar = this.a.h;
            if (dVar != null) {
                unused2 = this.a.h;
                dVar2 = this.a.h;
                dVar2.a();
            }
        } else if (address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            TiebaApplication.g().x(valueOf);
            TiebaApplication.g().y(valueOf2);
            TiebaApplication.g().z(address.getAdminArea());
            if (TextUtils.isEmpty(TiebaApplication.g().aU()) || TextUtils.isEmpty(TiebaApplication.g().aW())) {
                dVar3 = this.a.h;
                if (dVar3 != null) {
                    unused = this.a.h;
                    dVar4 = this.a.h;
                    dVar4.a();
                    return;
                }
                return;
            }
            ac acVar = new ac();
            acVar.b(TiebaApplication.g().aU());
            acVar.a(TiebaApplication.g().aW());
            com.baidu.tieba.im.messageCenter.d.a().a(acVar);
        }
    }
}
