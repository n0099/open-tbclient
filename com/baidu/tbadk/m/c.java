package com.baidu.tbadk.m;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.util.y;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public static String toSourceTraceString(List<String> list) {
        if (y.getCount(list) <= 0) {
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
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    sb.append(next);
                }
                z = z2;
            } else {
                return sb.toString();
            }
        }
    }

    public static List<String> trimToSize(List<String> list, int i) {
        int count = y.getCount(list);
        if (count > 0 && i >= 0 && count > i) {
            return y.subList(list, count - i, count);
        }
        return list;
    }
}
