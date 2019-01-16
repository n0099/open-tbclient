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
        long VF = dVar.VF();
        long VF2 = dVar2.VF();
        int i = VF > VF2 ? 1 : 0;
        if (VF < VF2) {
            return -1;
        }
        return i;
    }
}
