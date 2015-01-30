package com.baidu.tieba;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class ar implements com.baidu.adp.lib.d.d {
    final /* synthetic */ ao amp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar) {
        this.amp = aoVar;
    }

    @Override // com.baidu.adp.lib.d.d
    public void b(int i, String str, Address address) {
        if (i == 0 && address != null) {
            try {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                    TbadkApplication.getInst().setLocationLat(valueOf);
                    TbadkApplication.getInst().setLocationLng(valueOf2);
                    TbadkApplication.getInst().setLocationPos(address.getAddressLine(0));
                }
            } catch (IllegalStateException e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
