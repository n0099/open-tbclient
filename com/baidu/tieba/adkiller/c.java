package com.baidu.tieba.adkiller;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class c implements o.a<String> {
    private final /* synthetic */ String aMJ;
    private final /* synthetic */ o aMK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, o oVar) {
        this.aMJ = str;
        this.aMK = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: ap */
    public void h(String str, String str2) {
        if (StringUtils.isNull(str2)) {
            str2 = "start*" + this.aMJ;
        } else if (!str2.contains(this.aMJ)) {
            str2 = String.valueOf(str2) + ",start*" + this.aMJ;
        } else {
            String[] split = str2.split(",");
            if (split != null) {
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str3 = split[i];
                    if (!str3.endsWith(this.aMJ)) {
                        i++;
                    } else if (!str3.startsWith("start*")) {
                        String str4 = "start*" + this.aMJ;
                    } else {
                        return;
                    }
                }
            }
        }
        this.aMK.f(str, str2);
    }
}
