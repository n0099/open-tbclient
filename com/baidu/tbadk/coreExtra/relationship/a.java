package com.baidu.tbadk.coreExtra.relationship;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.DataRes;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes.dex */
public class a {
    private List<h> SI;
    private List<h> SJ;

    public List<h> getAddressList() {
        if (this.SI == null) {
            this.SI = new ArrayList();
        }
        return this.SI;
    }

    public boolean a(DataRes dataRes) {
        boolean z;
        if (dataRes == null || dataRes.robots_list == null) {
            z = false;
        } else {
            this.SJ = new ArrayList();
            boolean z2 = false;
            for (robotsList robotslist : dataRes.robots_list) {
                if (TextUtils.isEmpty(robotslist.key)) {
                    z2 = true;
                } else {
                    h hVar = new h();
                    hVar.a(robotslist);
                    this.SJ.add(hVar);
                }
            }
            z = z2;
        }
        if (dataRes != null && dataRes.address_list != null) {
            this.SI = new ArrayList();
            boolean z3 = z;
            for (listData listdata : dataRes.address_list) {
                if (TextUtils.isEmpty(listdata.key)) {
                    z3 = true;
                } else {
                    h hVar2 = new h();
                    hVar2.a(listdata);
                    if (hVar2.getContacts() != null) {
                        for (b bVar : hVar2.getContacts()) {
                            if (a(this.SJ, bVar)) {
                                bVar.setUserType(1);
                            } else {
                                bVar.setUserType(0);
                            }
                        }
                    }
                    this.SI.add(hVar2);
                }
            }
            return z3;
        }
        return z;
    }

    private boolean a(List<h> list, b bVar) {
        List<b> contacts;
        if (list == null || bVar == null) {
            return false;
        }
        for (h hVar : list) {
            if (hVar != null && (contacts = hVar.getContacts()) != null) {
                for (b bVar2 : contacts) {
                    if (bVar2 != null && bVar2.getUserId() == bVar.getUserId()) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }
}
