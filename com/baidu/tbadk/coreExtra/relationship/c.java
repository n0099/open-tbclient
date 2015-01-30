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
        String tn = bVar.tn();
        String tn2 = bVar2.tn();
        if (!TextUtils.isEmpty(tn) && !TextUtils.isEmpty(tn2) && !tn.equals(tn2)) {
            if ("#".equals(tn)) {
                return 1;
            }
            if ("#".equals(tn2)) {
                return -1;
            }
            return tn.compareToIgnoreCase(tn2);
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
