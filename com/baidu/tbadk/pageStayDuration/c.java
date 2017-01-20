package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.w;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static String A(List<String> list) {
        if (w.r(list) <= 0) {
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
        int r = w.r(list);
        if (r > 0 && i >= 0 && r > i) {
            return w.a(list, r - i, r);
        }
        return list;
    }
}
