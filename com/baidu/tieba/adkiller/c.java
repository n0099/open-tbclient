package com.baidu.tieba.adkiller;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class c implements o.a<String> {
    private final /* synthetic */ String aPE;
    private final /* synthetic */ o aPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, o oVar) {
        this.aPE = str;
        this.aPF = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aw */
    public void g(String str, String str2) {
        if (StringUtils.isNull(str2)) {
            str2 = "start*" + this.aPE;
        } else if (!str2.contains(this.aPE)) {
            str2 = String.valueOf(str2) + ",start*" + this.aPE;
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
                    if (!str3.endsWith(this.aPE)) {
                        i++;
                    } else if (!str3.startsWith("start*")) {
                        String str4 = "start*" + this.aPE;
                    } else {
                        return;
                    }
                }
            }
        }
        this.aPF.e(str, str2);
    }
}
