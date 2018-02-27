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
        long TE = dVar.TE();
        long TE2 = dVar2.TE();
        int i = TE > TE2 ? 1 : 0;
        if (TE < TE2) {
            return -1;
        }
        return i;
    }
}
