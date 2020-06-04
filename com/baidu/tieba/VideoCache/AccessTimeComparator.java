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
        long blz = dVar.blz();
        long blz2 = dVar2.blz();
        int i = blz > blz2 ? 1 : 0;
        if (blz < blz2) {
            return -1;
        }
        return i;
    }
}
