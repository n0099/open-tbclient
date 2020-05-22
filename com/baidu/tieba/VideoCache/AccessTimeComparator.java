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
        long blx = dVar.blx();
        long blx2 = dVar2.blx();
        int i = blx > blx2 ? 1 : 0;
        if (blx < blx2) {
            return -1;
        }
        return i;
    }
}
