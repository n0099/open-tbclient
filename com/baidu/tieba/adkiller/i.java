package com.baidu.tieba.adkiller;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class i implements o.a<String> {
    private final /* synthetic */ o aMK;
    private final /* synthetic */ String aMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, o oVar) {
        this.aMQ = str;
        this.aMK = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: ap */
    public void h(String str, String str2) {
        if (!StringUtils.isNULL(str2)) {
            String[] split = str2.split(",");
            String[] strArr = null;
            if (split != null) {
                String[] strArr2 = new String[split.length];
                int i = 0;
                for (String str3 : split) {
                    if (str3.endsWith(this.aMQ) && !str3.startsWith("submit*")) {
                        strArr2[i] = "submit*" + str3.substring("start*".length());
                    } else {
                        strArr2[i] = str3;
                        i++;
                    }
                }
                strArr = strArr2;
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
