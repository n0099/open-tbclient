package com.baidu.tieba.addresslist.relationship;

import android.text.TextUtils;
import d.a.j0.q.f.e;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes4.dex */
public final class OrderedContactsComparator implements Comparator<e>, Serializable {
    public static final String LAST_KEY = "#";
    public static final long serialVersionUID = 1284474050586872045L;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(e eVar, e eVar2) {
        if (eVar == null) {
            return -1;
        }
        if (eVar2 == null) {
            return 1;
        }
        String b2 = eVar.b();
        String b3 = eVar2.b();
        if ("#".equals(b2)) {
            return 1;
        }
        if ("#".equals(b3)) {
            return -1;
        }
        if (TextUtils.isEmpty(b2) || TextUtils.isEmpty(b3)) {
            return 0;
        }
        return b2.compareToIgnoreCase(b3);
    }
}
