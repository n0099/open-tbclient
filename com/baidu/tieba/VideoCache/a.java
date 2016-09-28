package com.baidu.tieba.VideoCache;

import java.util.Comparator;
/* loaded from: classes.dex */
public class a implements Comparator<f> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(f fVar, f fVar2) {
        if (fVar == null || fVar2 == null) {
            return 0;
        }
        long Ki = fVar.Ki();
        long Ki2 = fVar2.Ki();
        int i = Ki > Ki2 ? 1 : 0;
        if (Ki < Ki2) {
            return -1;
        }
        return i;
    }
}
