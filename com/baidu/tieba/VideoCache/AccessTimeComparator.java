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
        long avF = dVar.avF();
        long avF2 = dVar2.avF();
        int i = avF > avF2 ? 1 : 0;
        if (avF < avF2) {
            return -1;
        }
        return i;
    }
}
