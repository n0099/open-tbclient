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
        long SU = dVar.SU();
        long SU2 = dVar2.SU();
        int i = SU > SU2 ? 1 : 0;
        if (SU < SU2) {
            return -1;
        }
        return i;
    }
}
