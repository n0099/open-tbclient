package com.baidu.tieba.addresslist.relationship;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes3.dex */
public final class OrderedContactsComparator implements Serializable, Comparator<e> {
    private static final long serialVersionUID = 1284474050586872045L;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(e eVar, e eVar2) {
        if (eVar == null) {
            return -1;
        }
        if (eVar2 == null) {
            return 1;
        }
        String key = eVar.getKey();
        String key2 = eVar2.getKey();
        if ("#".equals(key)) {
            return 1;
        }
        if ("#".equals(key2)) {
            return -1;
        }
        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(key2)) {
            return key.compareToIgnoreCase(key2);
        }
        return 0;
    }
}
