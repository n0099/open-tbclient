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
        long aUs = dVar.aUs();
        long aUs2 = dVar2.aUs();
        int i = aUs > aUs2 ? 1 : 0;
        if (aUs < aUs2) {
            return -1;
        }
        return i;
    }
}
