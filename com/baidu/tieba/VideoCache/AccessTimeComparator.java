package com.baidu.tieba.VideoCache;

import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes7.dex */
public class AccessTimeComparator implements Serializable, Comparator<d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(d dVar, d dVar2) {
        if (dVar == null || dVar2 == null) {
            return 0;
        }
        long aUM = dVar.aUM();
        long aUM2 = dVar2.aUM();
        int i = aUM > aUM2 ? 1 : 0;
        if (aUM < aUM2) {
            return -1;
        }
        return i;
    }
}
