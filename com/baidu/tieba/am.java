package com.baidu.tieba;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements com.baidu.adp.lib.d.d {
    final /* synthetic */ aj adY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.adY = ajVar;
    }

    @Override // com.baidu.adp.lib.d.d
    public void OnLocationGeted(int i, String str, Address address) {
        if (i == 0 && address != null) {
            try {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                    TbadkApplication.m251getInst().setLocationLat(valueOf);
                    TbadkApplication.m251getInst().setLocationLng(valueOf2);
                    TbadkApplication.m251getInst().setLocationPos(address.getAddressLine(0));
                }
            } catch (IllegalStateException e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
