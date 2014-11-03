package com.baidu.tieba.im.a;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.QueryGroupCountMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.d.d {
    final /* synthetic */ a bcM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bcM = aVar;
    }

    @Override // com.baidu.adp.lib.d.d
    public void OnLocationGeted(int i, String str, Address address) {
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        e eVar5;
        e eVar6;
        if (i != 0) {
            eVar = this.bcM.bcJ;
            if (eVar != null) {
                eVar2 = this.bcM.bcJ;
                eVar2.NX();
                eVar3 = this.bcM.bcJ;
                eVar3.ig();
            }
        } else if (address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            TbadkApplication.m251getInst().setLocationLat(valueOf);
            TbadkApplication.m251getInst().setLocationLng(valueOf2);
            TbadkApplication.m251getInst().setLocationPos(address.getAdminArea());
            if (TextUtils.isEmpty(TbadkApplication.m251getInst().getLocationLat()) || TextUtils.isEmpty(TbadkApplication.m251getInst().getLocationLng())) {
                eVar4 = this.bcM.bcJ;
                if (eVar4 != null) {
                    eVar5 = this.bcM.bcJ;
                    eVar5.NX();
                    eVar6 = this.bcM.bcJ;
                    eVar6.ig();
                    return;
                }
                return;
            }
            QueryGroupCountMessage queryGroupCountMessage = new QueryGroupCountMessage();
            queryGroupCountMessage.setLat(TbadkApplication.m251getInst().getLocationLat());
            queryGroupCountMessage.setLng(TbadkApplication.m251getInst().getLocationLng());
            MessageManager.getInstance().sendMessage(queryGroupCountMessage);
        }
    }
}
