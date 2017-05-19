package com.baidu.tieba.VideoCache;

import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes2.dex */
public class AccessTimeComparator implements Serializable, Comparator<e> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(e eVar, e eVar2) {
        if (eVar == null || eVar2 == null) {
            return 0;
        }
        long KN = eVar.KN();
        long KN2 = eVar2.KN();
        int i = KN > KN2 ? 1 : 0;
        if (KN < KN2) {
            return -1;
        }
        return i;
    }
}
