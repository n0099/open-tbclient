package com.baidu.tieba.im.a;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ac;
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
                dVar3.c();
            }
        } else if (address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            TiebaApplication.g().x(valueOf);
            TiebaApplication.g().y(valueOf2);
            TiebaApplication.g().z(address.getAdminArea());
            if (TextUtils.isEmpty(TiebaApplication.g().bc()) || TextUtils.isEmpty(TiebaApplication.g().be())) {
                dVar4 = this.a.h;
                if (dVar4 != null) {
                    dVar5 = this.a.h;
                    dVar5.a();
                    dVar6 = this.a.h;
                    dVar6.c();
                    return;
                }
                return;
            }
            ac acVar = new ac();
            acVar.b(TiebaApplication.g().bc());
            acVar.a(TiebaApplication.g().be());
            e.a().a(acVar);
        }
    }
}
