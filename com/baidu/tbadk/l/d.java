package com.baidu.tbadk.l;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public static String b(ArrayList<String> arrayList, String str, int i) {
        ArrayList arrayList2 = new ArrayList();
        if (!x.isEmpty(arrayList)) {
            arrayList2.addAll(arrayList);
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList2.add(str);
        }
        List<String> trimToSize = trimToSize(arrayList2, i);
        if (x.isEmpty(trimToSize)) {
            return null;
        }
        return toSourceTraceString(trimToSize);
    }

    public static String toSourceTraceString(List<String> list) {
        if (x.getCount(list) <= 0) {
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
        int count = x.getCount(list);
        if (count > 0 && i >= 0 && count > i) {
            return x.subList(list, count - i, count);
        }
        return list;
    }
}
