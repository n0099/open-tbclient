package com.baidu.tieba.addresslist.relationship;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class ContactComparator implements Serializable, Comparator<com.baidu.tbadk.coreExtra.relationship.a> {
    private static final long serialVersionUID = 5856247139420779621L;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(com.baidu.tbadk.coreExtra.relationship.a aVar, com.baidu.tbadk.coreExtra.relationship.a aVar2) {
        if (aVar == null) {
            return -1;
        }
        if (aVar2 == null) {
            return 1;
        }
        String apT = aVar.apT();
        String apT2 = aVar2.apT();
        if (!TextUtils.isEmpty(apT) && !TextUtils.isEmpty(apT2) && !apT.equals(apT2)) {
            if ("#".equals(apT)) {
                return 1;
            }
            if ("#".equals(apT2)) {
                return -1;
            }
            return apT.compareToIgnoreCase(apT2);
        }
        String userName = aVar.getUserName();
        String userName2 = aVar2.getUserName();
        if (TextUtils.isEmpty(userName)) {
            return -1;
        }
        if (TextUtils.isEmpty(userName2)) {
            return 1;
        }
        String quanpin = aVar.getQuanpin();
        String quanpin2 = aVar2.getQuanpin();
        if (!TextUtils.isEmpty(quanpin) && !TextUtils.isEmpty(quanpin2)) {
            return quanpin.compareToIgnoreCase(quanpin2);
        }
        return 0;
    }
}
