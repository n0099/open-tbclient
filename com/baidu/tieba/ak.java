package com.baidu.tieba;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.adp.lib.c.d {
    final /* synthetic */ ai a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.a = aiVar;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        if (i == 0 && address != null) {
            try {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                    TbadkApplication.m252getInst().setLocationLat(valueOf);
                    TbadkApplication.m252getInst().setLocationLng(valueOf2);
                    TbadkApplication.m252getInst().setLocationPos(address.getAddressLine(0));
                }
            } catch (IllegalStateException e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
