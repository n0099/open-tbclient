package com.baidu.tbadk.coreExtra.relationship;

import android.text.TextUtils;
import java.util.Comparator;
/* loaded from: classes.dex */
public class c implements Comparator<b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(b bVar, b bVar2) {
        if (bVar == null) {
            return -1;
        }
        if (bVar2 == null) {
            return 1;
        }
        String f = bVar.f();
        String f2 = bVar2.f();
        if (!TextUtils.isEmpty(f) && !TextUtils.isEmpty(f2) && !f.equals(f2)) {
            if ("#".equals(f)) {
                return 1;
            }
            if ("#".equals(f2)) {
                return -1;
            }
            return f.compareToIgnoreCase(f2);
        }
        String b = bVar.b();
        String b2 = bVar2.b();
        if (TextUtils.isEmpty(b)) {
            return -1;
        }
        if (TextUtils.isEmpty(b2)) {
            return 1;
        }
        String e = bVar.e();
        String e2 = bVar2.e();
        if (!TextUtils.isEmpty(e) && !TextUtils.isEmpty(e2)) {
            return e.compareToIgnoreCase(e2);
        }
        return 0;
    }
}
