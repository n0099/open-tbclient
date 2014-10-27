package com.baidu.tbadk.coreExtra.relationship;

import android.text.TextUtils;
import java.util.Comparator;
/* loaded from: classes.dex */
public class c implements Comparator<b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(b bVar, b bVar2) {
        if (bVar == null) {
            return -1;
        }
        if (bVar2 == null) {
            return 1;
        }
        String pA = bVar.pA();
        String pA2 = bVar2.pA();
        if (!TextUtils.isEmpty(pA) && !TextUtils.isEmpty(pA2) && !pA.equals(pA2)) {
            if ("#".equals(pA)) {
                return 1;
            }
            if ("#".equals(pA2)) {
                return -1;
            }
            return pA.compareToIgnoreCase(pA2);
        }
        String userName = bVar.getUserName();
        String userName2 = bVar2.getUserName();
        if (TextUtils.isEmpty(userName)) {
            return -1;
        }
        if (TextUtils.isEmpty(userName2)) {
            return 1;
        }
        String quanpin = bVar.getQuanpin();
        String quanpin2 = bVar2.getQuanpin();
        if (!TextUtils.isEmpty(quanpin) && !TextUtils.isEmpty(quanpin2)) {
            return quanpin.compareToIgnoreCase(quanpin2);
        }
        return 0;
    }
}
