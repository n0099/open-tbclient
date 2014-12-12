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
        String sW = bVar.sW();
        String sW2 = bVar2.sW();
        if (!TextUtils.isEmpty(sW) && !TextUtils.isEmpty(sW2) && !sW.equals(sW2)) {
            if ("#".equals(sW)) {
                return 1;
            }
            if ("#".equals(sW2)) {
                return -1;
            }
            return sW.compareToIgnoreCase(sW2);
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
