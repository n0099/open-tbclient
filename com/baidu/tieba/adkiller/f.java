package com.baidu.tieba.adkiller;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class f implements o.a<String> {
    private final /* synthetic */ String aMN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str) {
        this.aMN = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: ap */
    public void h(String str, String str2) {
        boolean z = false;
        if (!StringUtils.isNULL(str2)) {
            String[] split = str2.split(",");
            if (split != null) {
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str3 = split[i];
                    if (str3.startsWith("submit*")) {
                        if (this.aMN.equals(str3.substring("submit*".length()))) {
                            z = true;
                            break;
                        }
                    }
                    i++;
                }
            }
            if (z) {
                TbadkCoreApplication.m411getInst().handler.post(new g(this, this.aMN));
            }
        }
    }
}
