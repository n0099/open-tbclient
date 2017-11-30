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
        long LH = dVar.LH();
        long LH2 = dVar2.LH();
        int i = LH > LH2 ? 1 : 0;
        if (LH < LH2) {
            return -1;
        }
        return i;
    }
}
