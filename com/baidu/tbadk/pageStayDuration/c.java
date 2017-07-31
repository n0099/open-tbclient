package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.u;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static String F(List<String> list) {
        if (u.u(list) <= 0) {
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

    public static List<String> e(List<String> list, int i) {
        int u = u.u(list);
        if (u > 0 && i >= 0 && u > i) {
            return u.a(list, u - i, u);
        }
        return list;
    }
}
