package com.baidu.tieba.im.a;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.z;
import com.baidu.tieba.im.messageCenter.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.c.d {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        d dVar5;
        d dVar6;
        if (i != 0) {
            dVar = this.a.h;
            if (dVar != null) {
                dVar2 = this.a.h;
                dVar2.a();
                dVar3 = this.a.h;
                dVar3.G();
            }
        } else if (address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            TiebaApplication.h().x(valueOf);
            TiebaApplication.h().y(valueOf2);
            TiebaApplication.h().z(address.getAdminArea());
            if (TextUtils.isEmpty(TiebaApplication.h().bf()) || TextUtils.isEmpty(TiebaApplication.h().bh())) {
                dVar4 = this.a.h;
                if (dVar4 != null) {
                    dVar5 = this.a.h;
                    dVar5.a();
                    dVar6 = this.a.h;
                    dVar6.G();
                    return;
                }
                return;
            }
            z zVar = new z();
            zVar.b(TiebaApplication.h().bf());
            zVar.a(TiebaApplication.h().bh());
            e.a().a(zVar);
        }
    }
}
