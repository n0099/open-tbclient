package com.baidu.tieba.im.a;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements com.baidu.adp.lib.c.d {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.adp.lib.c.d
    public final void a(int i, Address address) {
        e eVar;
        e eVar2;
        e unused;
        e unused2;
        e unused3;
        e unused4;
        if (i != 0) {
            eVar = this.a.h;
            if (eVar != null) {
                unused3 = this.a.h;
                unused4 = this.a.h;
            }
        } else if (address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            TbadkApplication.j();
            TbadkApplication.i(valueOf);
            TbadkApplication.j();
            TbadkApplication.j(valueOf2);
            TbadkApplication.j();
            TbadkApplication.k(address.getAdminArea());
            TbadkApplication.j();
            if (!TextUtils.isEmpty(TbadkApplication.W())) {
                TbadkApplication.j();
                if (!TextUtils.isEmpty(TbadkApplication.Y())) {
                    x xVar = new x();
                    TbadkApplication.j();
                    xVar.b(TbadkApplication.W());
                    TbadkApplication.j();
                    xVar.a(TbadkApplication.Y());
                    com.baidu.adp.framework.c.a().a(xVar);
                    return;
                }
            }
            eVar2 = this.a.h;
            if (eVar2 != null) {
                unused = this.a.h;
                unused2 = this.a.h;
            }
        }
    }
}
