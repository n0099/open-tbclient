package com.baidu.tieba.adkiller;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class d implements o.a<String> {
    private final /* synthetic */ String aLQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.aLQ = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aw */
    public void g(String str, String str2) {
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
                    if (str3.startsWith("start*")) {
                        if (this.aLQ.equals(str3.substring("start*".length()))) {
                            z = true;
                            break;
                        }
                    }
                    i++;
                }
            }
            if (z) {
                TbadkCoreApplication.m11getInst().handler.post(new e(this, this.aLQ));
            }
        }
    }
}
