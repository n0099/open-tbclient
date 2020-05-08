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
        long bfl = dVar.bfl();
        long bfl2 = dVar2.bfl();
        int i = bfl > bfl2 ? 1 : 0;
        if (bfl < bfl2) {
            return -1;
        }
        return i;
    }
}
