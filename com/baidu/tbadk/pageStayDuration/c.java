package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.w;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static String L(List<String> list) {
        if (w.z(list) <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        Iterator<String> it = list.iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    if (!z2 && !StringUtils.isNull(sb.toString())) {
                        z2 = true;
                    }
                    if (z2) {
                        sb.append("_");
                    }
                    sb.append(next);
                }
                z = z2;
            } else {
                return sb.toString();
            }
        }
    }

    public static List<String> f(List<String> list, int i) {
        int z = w.z(list);
        if (z > 0 && i >= 0 && z > i) {
            return w.a(list, z - i, z);
        }
        return list;
    }
}
