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
        long aXj = dVar.aXj();
        long aXj2 = dVar2.aXj();
        int i = aXj > aXj2 ? 1 : 0;
        if (aXj < aXj2) {
            return -1;
        }
        return i;
    }
}
