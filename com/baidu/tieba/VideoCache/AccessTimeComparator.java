package com.baidu.tieba.VideoCache;

import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes.dex */
public class AccessTimeComparator implements Serializable, Comparator<e> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(e eVar, e eVar2) {
        if (eVar == null || eVar2 == null) {
            return 0;
        }
        long Lz = eVar.Lz();
        long Lz2 = eVar2.Lz();
        int i = Lz > Lz2 ? 1 : 0;
        if (Lz < Lz2) {
            return -1;
        }
        return i;
    }
}
