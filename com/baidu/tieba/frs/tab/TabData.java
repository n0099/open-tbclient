package com.baidu.tieba.frs.tab;

import java.util.Collection;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class TabData extends LinkedList<d> {
    public static final int TYPE_TAB_LOCATE_1 = 1;
    public static final int TYPE_TAB_LOCATE_2 = 2;
    private static final long serialVersionUID = -5491033066240609561L;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        if (collection == null || collection.size() <= 0 || size() != collection.size()) {
            return false;
        }
        try {
            LinkedList linkedList = (LinkedList) collection;
            int size = size();
            for (int i = 0; i < size; i++) {
                d dVar = get(i);
                if (dVar == null || !dVar.equals(linkedList.get(i))) {
                    return false;
                }
            }
        } catch (Throwable th) {
        }
        return super.containsAll(collection);
    }
}
