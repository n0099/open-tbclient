package com.baidu.tieba.addresslist.relationship;

import android.text.TextUtils;
import java.util.Comparator;
/* loaded from: classes.dex */
public class b implements Comparator<com.baidu.tbadk.coreExtra.relationship.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(com.baidu.tbadk.coreExtra.relationship.a aVar, com.baidu.tbadk.coreExtra.relationship.a aVar2) {
        if (aVar == null) {
            return -1;
        }
        if (aVar2 == null) {
            return 1;
        }
        String xx = aVar.xx();
        String xx2 = aVar2.xx();
        if (!TextUtils.isEmpty(xx) && !TextUtils.isEmpty(xx2) && !xx.equals(xx2)) {
            if ("#".equals(xx)) {
                return 1;
            }
            if ("#".equals(xx2)) {
                return -1;
            }
            return xx.compareToIgnoreCase(xx2);
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
