package com.baidu.tieba.frs.tab;

import java.util.Collection;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class TabData extends LinkedList<d> {
    public static final int TYPE_CUSTOM = 12;
    public static final int TYPE_H5 = 1;
    public static final int TYPE_NATIVE = 0;
    public static final int TYPE_NEWPAGE = 11;
    public static final int TYPE_TAB_AD = 90;
    public static final int TYPE_TAB_ALA_LIVE = 49;
    public static final int TYPE_TAB_ALL = 1;
    public static final int TYPE_TAB_COMMON_TAB = 91;
    public static final int TYPE_TAB_CORE = 502;
    public static final int TYPE_TAB_DYNAMIC = 89;
    public static final int TYPE_TAB_HOT = 13;
    public static final int TYPE_TAB_HOTTOPIC = 404;
    public static final int TYPE_TAB_LOCATE_1 = 1;
    public static final int TYPE_TAB_LOCATE_2 = 2;
    public static final int TYPE_TAB_NERAAREA = 14;
    public static final int TYPE_TAB_VIDEO = 501;
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
