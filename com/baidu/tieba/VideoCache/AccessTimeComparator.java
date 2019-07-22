package com.baidu.tieba.VideoCache;

import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes4.dex */
public class AccessTimeComparator implements Serializable, Comparator<d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(d dVar, d dVar2) {
        if (dVar == null || dVar2 == null) {
            return 0;
        }
        long aCa = dVar.aCa();
        long aCa2 = dVar2.aCa();
        int i = aCa > aCa2 ? 1 : 0;
        if (aCa < aCa2) {
            return -1;
        }
        return i;
    }
}
