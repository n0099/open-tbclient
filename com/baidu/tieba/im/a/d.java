package com.baidu.tieba.im.a;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.QueryGroupCountMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.c.d {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        e eVar5;
        e eVar6;
        if (i != 0) {
            eVar = this.a.h;
            if (eVar != null) {
                eVar2 = this.a.h;
                eVar2.a();
                eVar3 = this.a.h;
                eVar3.f();
            }
        } else if (address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            TbadkApplication.m252getInst().setLocationLat(valueOf);
            TbadkApplication.m252getInst().setLocationLng(valueOf2);
            TbadkApplication.m252getInst().setLocationPos(address.getAdminArea());
            if (TextUtils.isEmpty(TbadkApplication.m252getInst().getLocationLat()) || TextUtils.isEmpty(TbadkApplication.m252getInst().getLocationLng())) {
                eVar4 = this.a.h;
                if (eVar4 != null) {
                    eVar5 = this.a.h;
                    eVar5.a();
                    eVar6 = this.a.h;
                    eVar6.f();
                    return;
                }
                return;
            }
            QueryGroupCountMessage queryGroupCountMessage = new QueryGroupCountMessage();
            queryGroupCountMessage.setLat(TbadkApplication.m252getInst().getLocationLat());
            queryGroupCountMessage.setLng(TbadkApplication.m252getInst().getLocationLng());
            MessageManager.getInstance().sendMessage(queryGroupCountMessage);
        }
    }
}
