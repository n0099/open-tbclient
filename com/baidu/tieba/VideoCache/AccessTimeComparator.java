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
        long Qi = dVar.Qi();
        long Qi2 = dVar2.Qi();
        int i = Qi > Qi2 ? 1 : 0;
        if (Qi < Qi2) {
            return -1;
        }
        return i;
    }
}
