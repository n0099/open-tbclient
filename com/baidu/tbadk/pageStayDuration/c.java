package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static String y(List<String> list) {
        if (x.p(list) <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (String str : list) {
            if (!StringUtils.isNull(str)) {
                if (!z && !StringUtils.isNull(sb.toString())) {
                    z = true;
                }
                if (z) {
                    sb.append("_");
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static List<String> e(List<String> list, int i) {
        int p = x.p(list);
        if (p > 0 && i >= 0 && p > i) {
            return x.a(list, p - i, p);
        }
        return list;
    }
}
