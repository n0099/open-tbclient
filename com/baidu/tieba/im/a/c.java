package com.baidu.tieba.im.a;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.x;
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
            dVar = this.a.f;
            if (dVar != null) {
                dVar2 = this.a.f;
                dVar2.a();
                dVar3 = this.a.f;
                dVar3.G();
            }
        } else if (address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            TiebaApplication.g().y(valueOf);
            TiebaApplication.g().z(valueOf2);
            TiebaApplication.g().A(address.getAdminArea());
            if (TextUtils.isEmpty(TiebaApplication.g().bf()) || TextUtils.isEmpty(TiebaApplication.g().bg())) {
                dVar4 = this.a.f;
                if (dVar4 != null) {
                    dVar5 = this.a.f;
                    dVar5.a();
                    dVar6 = this.a.f;
                    dVar6.G();
                    return;
                }
                return;
            }
            x xVar = new x();
            xVar.b(TiebaApplication.g().bf());
            xVar.a(TiebaApplication.g().bg());
            e.a().a(xVar);
        }
    }
}
