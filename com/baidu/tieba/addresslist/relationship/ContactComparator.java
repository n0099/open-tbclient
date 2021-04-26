package com.baidu.tieba.addresslist.relationship;

import android.text.TextUtils;
import d.a.i0.s.f.a;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes4.dex */
public class ContactComparator implements Comparator<a>, Serializable {
    public static final String LAST_KEY = "#";
    public static final long serialVersionUID = 5856247139420779621L;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(a aVar, a aVar2) {
        if (aVar == null) {
            return -1;
        }
        if (aVar2 == null) {
            return 1;
        }
        String a2 = aVar.a();
        String a3 = aVar2.a();
        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a3) && !a2.equals(a3)) {
            if ("#".equals(a2)) {
                return 1;
            }
            if ("#".equals(a3)) {
                return -1;
            }
            return a2.compareToIgnoreCase(a3);
        }
        String f2 = aVar.f();
        String f3 = aVar2.f();
        if (TextUtils.isEmpty(f2)) {
            return -1;
        }
        if (TextUtils.isEmpty(f3)) {
            return 1;
        }
        String d2 = aVar.d();
        String d3 = aVar2.d();
        if (TextUtils.isEmpty(d2) || TextUtils.isEmpty(d3)) {
            return 0;
        }
        return d2.compareToIgnoreCase(d3);
    }
}
