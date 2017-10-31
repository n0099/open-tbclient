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
        long KW = dVar.KW();
        long KW2 = dVar2.KW();
        int i = KW > KW2 ? 1 : 0;
        if (KW < KW2) {
            return -1;
        }
        return i;
    }
}
