package com.baidu.tieba.addresslist.relationship;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.DataRes;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes21.dex */
public class a {
    private List<e> gcW;
    private List<e> gcX;

    public List<e> getAddressList() {
        if (this.gcW == null) {
            this.gcW = new ArrayList();
        }
        return this.gcW;
    }

    public boolean a(DataRes dataRes) {
        boolean z;
        if (dataRes == null || dataRes.robots_list == null) {
            z = false;
        } else {
            this.gcX = new ArrayList();
            boolean z2 = false;
            for (robotsList robotslist : dataRes.robots_list) {
                if (TextUtils.isEmpty(robotslist.key)) {
                    z2 = true;
                } else {
                    e eVar = new e();
                    eVar.a(robotslist);
                    this.gcX.add(eVar);
                }
            }
            z = z2;
        }
        if (dataRes != null && dataRes.address_list != null) {
            this.gcW = new ArrayList();
            boolean z3 = z;
            for (listData listdata : dataRes.address_list) {
                if (TextUtils.isEmpty(listdata.key)) {
                    z3 = true;
                } else {
                    e eVar2 = new e();
                    eVar2.a(listdata);
                    if (eVar2.getContacts() != null) {
                        for (com.baidu.tbadk.coreExtra.relationship.a aVar : eVar2.getContacts()) {
                            if (a(this.gcX, aVar)) {
                                aVar.setUserType(1);
                            } else {
                                aVar.setUserType(0);
                            }
                        }
                    }
                    this.gcW.add(eVar2);
                }
            }
            return z3;
        }
        return z;
    }

    private boolean a(List<e> list, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        List<com.baidu.tbadk.coreExtra.relationship.a> contacts;
        if (list == null || aVar == null) {
            return false;
        }
        for (e eVar : list) {
            if (eVar != null && (contacts = eVar.getContacts()) != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : contacts) {
                    if (aVar2 != null && aVar2.getUserId() == aVar.getUserId()) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }
}
