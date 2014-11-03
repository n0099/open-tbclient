package com.baidu.tbadk.coreExtra.relationship;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.DataRes;
import tbclient.GetAddressList.listData;
/* loaded from: classes.dex */
public class a {
    private List<h> Mo;

    public List<h> getAddressList() {
        if (this.Mo == null) {
            this.Mo = new ArrayList();
        }
        return this.Mo;
    }

    public boolean a(DataRes dataRes) {
        if (dataRes == null || dataRes.address_list == null) {
            return false;
        }
        this.Mo = new ArrayList();
        boolean z = false;
        for (listData listdata : dataRes.address_list) {
            if (TextUtils.isEmpty(listdata.key)) {
                z = true;
            } else {
                h hVar = new h();
                hVar.a(listdata);
                this.Mo.add(hVar);
            }
        }
        return z;
    }
}
