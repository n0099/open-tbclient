package com.baidu.tieba.adkiller;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class h implements o.a<String> {
    private final /* synthetic */ o aMK;
    private final /* synthetic */ String aMP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str, o oVar) {
        this.aMP = str;
        this.aMK = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: ap */
    public void h(String str, String str2) {
        String[] strArr;
        if (!StringUtils.isNULL(str2)) {
            String[] split = str2.split(",");
            if (split != null) {
                strArr = new String[split.length];
                int i = 0;
                for (String str3 : split) {
                    if (str3.endsWith(this.aMP)) {
                        strArr[i] = null;
                    } else {
                        strArr[i] = str3;
                    }
                    i++;
                }
            } else {
                strArr = null;
            }
            StringBuilder sb = new StringBuilder();
            for (String str4 : strArr) {
                if (!StringUtils.isNULL(str4)) {
                    sb.append(str4).append(",");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            this.aMK.f("ad_killer_tag_key", sb.toString());
        }
    }
}
