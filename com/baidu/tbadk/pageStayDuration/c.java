package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static String B(List<String> list) {
        if (y.r(list) <= 0) {
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
        int r = y.r(list);
        if (r > 0 && i >= 0 && r > i) {
            return y.a(list, r - i, r);
        }
        return list;
    }
}
