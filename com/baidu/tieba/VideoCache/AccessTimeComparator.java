package com.baidu.tieba.VideoCache;

import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes.dex */
public class AccessTimeComparator implements Serializable, Comparator<e> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(e eVar, e eVar2) {
        if (eVar == null || eVar2 == null) {
            return 0;
        }
        long Ku = eVar.Ku();
        long Ku2 = eVar2.Ku();
        int i = Ku > Ku2 ? 1 : 0;
        if (Ku < Ku2) {
            return -1;
        }
        return i;
    }
}
