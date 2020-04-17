package com.baidu.tieba.VideoCache;

import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes9.dex */
public class AccessTimeComparator implements Serializable, Comparator<d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(d dVar, d dVar2) {
        if (dVar == null || dVar2 == null) {
            return 0;
        }
        long bfn = dVar.bfn();
        long bfn2 = dVar2.bfn();
        int i = bfn > bfn2 ? 1 : 0;
        if (bfn < bfn2) {
            return -1;
        }
        return i;
    }
}
