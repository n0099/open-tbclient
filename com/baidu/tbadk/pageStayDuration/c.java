package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.w;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static String K(List<String> list) {
        if (w.y(list) <= 0) {
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
        int y = w.y(list);
        if (y > 0 && i >= 0 && y > i) {
            return w.a(list, y - i, y);
        }
        return list;
    }
}
