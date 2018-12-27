package com.baidu.tieba.VideoCache;

import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes6.dex */
public class AccessTimeComparator implements Serializable, Comparator<d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(d dVar, d dVar2) {
        if (dVar == null || dVar2 == null) {
            return 0;
        }
        long Vj = dVar.Vj();
        long Vj2 = dVar2.Vj();
        int i = Vj > Vj2 ? 1 : 0;
        if (Vj < Vj2) {
            return -1;
        }
        return i;
    }
}
