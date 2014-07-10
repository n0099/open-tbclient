package com.baidu.tbadk.coreExtra.relationship;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.DataRes;
import tbclient.GetAddressList.listData;
/* loaded from: classes.dex */
public class a {
    private List<g> a;

    public List<g> a() {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        return this.a;
    }

    public boolean a(DataRes dataRes) {
        if (dataRes == null || dataRes.address_list == null) {
            return false;
        }
        this.a = new ArrayList();
        boolean z = false;
        for (listData listdata : dataRes.address_list) {
            if (TextUtils.isEmpty(listdata.key)) {
                z = true;
            } else {
                g gVar = new g();
                gVar.a(listdata);
                this.a.add(gVar);
            }
        }
        return z;
    }
}
