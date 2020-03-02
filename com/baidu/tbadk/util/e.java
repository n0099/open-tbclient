package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e {
    public static String[] aRV() {
        String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "");
        if (StringUtils.isNull(string)) {
            return new String[0];
        }
        String[] split = string.split("\\^");
        if (split != null && split.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : split) {
                a vP = a.vP(str);
                if (vP != null && !StringUtils.isNull(vP.forumName)) {
                    arrayList.add(vP.forumName);
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

        public static a vP(String str) {
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
                    aVar.level = com.baidu.adp.lib.f.b.toInt(split[1], -1);
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
