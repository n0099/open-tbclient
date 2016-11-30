package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static String C(List<String> list) {
        if (x.s(list) <= 0) {
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
        int s = x.s(list);
        if (s > 0 && i >= 0 && s > i) {
            return x.a(list, s - i, s);
        }
        return list;
    }
}
