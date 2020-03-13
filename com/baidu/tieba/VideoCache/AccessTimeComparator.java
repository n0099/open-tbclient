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
        long aXf = dVar.aXf();
        long aXf2 = dVar2.aXf();
        int i = aXf > aXf2 ? 1 : 0;
        if (aXf < aXf2) {
            return -1;
        }
        return i;
    }
}
