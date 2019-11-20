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
        long aCx = dVar.aCx();
        long aCx2 = dVar2.aCx();
        int i = aCx > aCx2 ? 1 : 0;
        if (aCx < aCx2) {
            return -1;
        }
        return i;
    }
}
