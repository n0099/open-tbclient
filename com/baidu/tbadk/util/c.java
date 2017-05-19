package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static void B(List<a> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            HashMap hashMap = new HashMap();
            for (a aVar : list) {
                if (aVar != null && !StringUtils.isNull(aVar.forumName)) {
                    if (!hashMap.containsKey(aVar.forumName)) {
                        sb.append(aVar.toString()).append("^");
                        hashMap.put(aVar.forumName, aVar.forumName);
                    }
                } else {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tX().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public static String[] Gk() {
        String string = com.baidu.tbadk.core.sharedPref.b.tX().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "");
        if (StringUtils.isNull(string)) {
            return new String[0];
        }
        String[] split = string.split("\\^");
        if (split != null && split.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : split) {
                a gb = a.gb(str);
                if (gb != null && !StringUtils.isNull(gb.forumName)) {
                    arrayList.add(gb.forumName);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return null;
    }

    public static a[] Gl() {
        String string = com.baidu.tbadk.core.sharedPref.b.tX().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "");
        if (StringUtils.isNull(string)) {
            return new a[0];
        }
        String[] split = string.split("\\^");
        if (split != null && split.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : split) {
                a gb = a.gb(str);
                if (gb != null && !StringUtils.isNull(gb.forumName)) {
                    arrayList.add(gb);
                }
            }
            return (a[]) arrayList.toArray(new a[arrayList.size()]);
        }
        return new a[0];
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
            return String.valueOf(this.forumName) + "#" + this.level;
        }

        public static a gb(String str) {
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
                    aVar.level = com.baidu.adp.lib.g.b.g(split[1], -1);
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
