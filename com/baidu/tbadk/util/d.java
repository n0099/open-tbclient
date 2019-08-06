package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    public static String[] awd() {
        String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "");
        if (StringUtils.isNull(string)) {
            return new String[0];
        }
        String[] split = string.split("\\^");
        if (split != null && split.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : split) {
                a rc = a.rc(str);
                if (rc != null && !StringUtils.isNull(rc.forumName)) {
                    arrayList.add(rc.forumName);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static class a {
        public String forumName;
        public int level;

        public a() {
        }

        public a(String str, int i) {
            this.forumName = str;
            this.level = i;
        }

        public String toString() {
            if (StringUtils.isNull(this.forumName)) {
                return null;
            }
            return this.forumName + "#" + this.level;
        }

        public static a rc(String str) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            a aVar = new a();
            if (str.contains("#")) {
                String[] split = str.split("#");
                if (split.length == 1) {
                    aVar.forumName = split[0];
                    return aVar;
                } else if (split.length == 2) {
                    aVar.forumName = split[0];
                    aVar.level = com.baidu.adp.lib.g.b.f(split[1], -1);
                    return aVar;
                } else {
                    return aVar;
                }
            }
            aVar.forumName = str;
            return aVar;
        }
    }
}
