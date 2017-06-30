package com.baidu.tieba.VideoCache;

import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes2.dex */
public class AccessTimeComparator implements Serializable, Comparator<e> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(e eVar, e eVar2) {
        if (eVar == null || eVar2 == null) {
            return 0;
        }
        long Kg = eVar.Kg();
        long Kg2 = eVar2.Kg();
        int i = Kg > Kg2 ? 1 : 0;
        if (Kg < Kg2) {
            return -1;
        }
        return i;
    }
}
