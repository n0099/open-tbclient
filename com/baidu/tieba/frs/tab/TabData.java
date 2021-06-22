package com.baidu.tieba.frs.tab;

import d.a.o0.r0.k2.d;
import java.util.Collection;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class TabData extends LinkedList<d> {
    public static final int TYPE_TAB_LOCATE_1 = 1;
    public static final int TYPE_TAB_LOCATE_2 = 2;
    public static final long serialVersionUID = -5491033066240609561L;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        if (collection == null || collection.size() <= 0 || size() != collection.size()) {
            return false;
        }
        try {
            LinkedList linkedList = (LinkedList) collection;
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                d dVar = get(i2);
                if (dVar == null || !dVar.equals(linkedList.get(i2))) {
                    return false;
                }
            }
        } catch (Throwable unused) {
        }
        return super.containsAll(collection);
    }
}
