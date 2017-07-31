package com.baidu.tieba.VideoCache;

import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes2.dex */
public class AccessTimeComparator implements Serializable, Comparator<d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(d dVar, d dVar2) {
        if (dVar == null || dVar2 == null) {
            return 0;
        }
        long Ks = dVar.Ks();
        long Ks2 = dVar2.Ks();
        int i = Ks > Ks2 ? 1 : 0;
        if (Ks < Ks2) {
            return -1;
        }
        return i;
    }
}
